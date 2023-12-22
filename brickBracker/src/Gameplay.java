//panel 

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener ;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener {
    // staring conditions
    private boolean play = false ;
    private int score =0 ;

    private int totalBricks =21 ;

    private Timer timer ; 
    private int delay = 8 ; 

    //paddle position
    private int playerX = 310 ; 

    //ball direction
    private int ballposX = 120;
    private int ballposY= 350 ; 
    // ball movement
    private int ballXdir = -1 ; 
    private int ballYdir = -2 ; 

    private MapGenerator map ; 
    //constructor
    public Gameplay(){
        map = new MapGenerator(3, 7) ; 
        addKeyListener(this);
        setFocusable(true); //ensures panel can receive key events
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start()  ;


    }

    // game visuals
    public void paint(Graphics g){
        //backgorund
        g.setColor(Color.BLACK);
        g.fillRect(1,1 , 692, 592);

        // draw map
        map.draw((Graphics2D)g) ; 

        //borders
        g.setColor(Color.yellow);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);

        // scores
        g.setColor(Color.white);
        g.setFont(new Font("serif", Font.BOLD,25));
        g.drawString(""+score, 590, 30);


        //paddle - player controls
        g.setColor(Color.green);
        g.fillRect(playerX, 550, 100, 8);

        //ball
        g.setColor(Color.yellow);
        g.fillOval(ballposX, ballposY, 20, 20);

        // check for game completed/finished
        if(totalBricks <=0){
            play = false ;
            ballXdir =0 ; 
            ballYdir = 0 ;

            //game finished displayed
            g.setColor(Color.GREEN);
            g.setFont(new Font("serif", Font.BOLD, 30)) ;
            g.drawString("Congratulations, GAME WON: "+score, 260, 300);

            g.setFont(new Font("serif", Font.BOLD, 20));
            g.drawString("Press Enter to Restart", 230, 350);
        }

        // check for game over (i.e. ball drops below the player paddle)
        if(ballposY >= 570){
            play = false ; //game stops
            ballXdir = 0 ;
            ballYdir = 0 ; // ball x + y position not updatedd

            //game over display
            g.setColor(Color.RED);
            g.setFont(new Font("serif", Font.BOLD, 30));
            g.drawString("GAME OVER, SCORE: "+score, 190, 300);

            g.setFont(new Font("serif", Font.BOLD, 20));
            g.drawString("Press Enter to Restart", 230, 350);

        }
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start() ;

        // update ball positions at start if game
        if(play){
            // intersection of ball and paddle
            if( new Rectangle(ballposX, ballposY, 20,20).intersects(new Rectangle(playerX, 550, 100, 8))){
                // ball bounces in the y direction
                ballYdir = -ballYdir ; 
            }

            // collision detection
            A: for(int i=0; i<map.map.length ; i++){
                for(int j=0 ; j<map.map[0].length ; j++){
                    // brick not collided
                    if(map.map[i][j] >0){
                        int brickX = j*map.brickWidth +80;
                        int brickY = i*map.brickHeight +50 ;
                        int brickWidth = map.brickWidth ;
                        int brickHeight = map.brickHeight ; 

                        //create rectangle around brick (to detect )
                        Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight) ;
                        //rectangle around ball to detect position
                        Rectangle ballRect = new Rectangle(ballposX, ballposY, 20,20) ;
                        Rectangle brickRect  = rect ;

                        // check intersection + increment score 
                        if(ballRect.intersects(brickRect)){
                            map.setBrickValue(0, i, j);
                            totalBricks-- ; 
                            score+=5 ;

                            //left & right intersection f
                            if(ballposX +19 <= brickRect.x || ballposX+1 >= brickRect.x + brickRect.width){
                                ballXdir = -ballXdir ;
                            }else{ //top or bottom intersection
                                ballYdir = -ballYdir ; 
                            }

                            break A ; //break out the double for loop at collision
                        }

                    }
                }
            }

            ballposX += ballXdir ; 
            ballposY += ballYdir ; 
            //left border
            if(ballposX < 0){
                ballXdir = -ballXdir ; 
            }
            if(ballposY < 0){
                ballYdir = -ballYdir ; 
            }
            if(ballposX > 670){
                ballXdir = -ballXdir ;  
            }
        }
        repaint(); // repaints/refreshes screen with updated positions
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //detect arrow keys
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(playerX>=580){
                playerX = 580 ; 
            }else{
                moveRight() ; 
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(playerX<=10){
                playerX =10;
            }else{
                moveLeft() ;
            } 
        }
        //detect arrow pressed
        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            //restore default properties of the game 
            if(!play){
                play = true ; 
                ballposX = 120 ; // reposition ball and player paddle postions
                ballposY = 350 ;
                ballXdir = -1 ; 
                ballYdir = -2 ; 
                playerX = 310 ; 
                score = 0  ; // reset the score
                totalBricks = 21 ;
                map = new MapGenerator(3, 7) ; // redefine the map of bricks
             }
        }
    }
    public void moveLeft(){
        play  = true ;  //game starts/continues
        playerX -= 20 ;
    }

    public void moveRight(){
        play  =  true; //game starts/continues
        playerX += 20 ;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
         // throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }
    
}
