//panel 

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;
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

    //constructor
    public Gameplay(){
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

        //borders
        g.setColor(Color.yellow);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);

        //paddle
        g.setColor(Color.green);
        g.fillRect(playerX, 550, 100, 8);

        //ball
        g.setColor(Color.yellow);
        g.fillOval(ballposX, ballposY, 20, 20);

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start() ;
        repaint();
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
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }
    
}
