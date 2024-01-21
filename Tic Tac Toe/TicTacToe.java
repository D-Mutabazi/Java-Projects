import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class TicTacToe{
    static ArrayList<Integer>playerPositions =new ArrayList<Integer>() ;
    static ArrayList<Integer>cpuPositions =new ArrayList<Integer>() ;

    public static void main(String[] args){

        //borard deisgn
        char [][] gameBoard ={{' ','|',' ','|',' '}, 
                            {'-','+','-','+','-'}, 
                            {' ','|',' ','|',' '}, 
                            {'-','+','-','+','-'}, 
                        {' ','|',' ','|',' '}};

        printGameBoard(gameBoard);

        while(true){
            Scanner scan = new Scanner(System.in) ; 
            System.out.println("Enter your placement (1-9):") ;
            int playerPos = scan.nextInt();
            // Error check - cannot play in filled position
            System.out.println(playerPos) ; 
            // idea - changing position is filling space with 'X' or 'O'
            placePeace(gameBoard, playerPos,"player");
    
            Random rand = new Random() ;
            int cpuPos = rand.nextInt(9)+1 ; 
            
            placePeace(gameBoard, cpuPos, "cpu");
    
            printGameBoard(gameBoard);
            
            String result =  checkWinner() ;
            System.out.println(result) ;
    
        }

        // scan.close() ;


    }

    public static void printGameBoard(char[][] gameBoard){
        for(char[] row: gameBoard){
            for(char c : row){
                System.out.print(c) ;
            }
            System.out.println() ;
            }
        }


        /**
         * function plays a peace on board 
         * @param gameBoard gameBoard passed in
         * @param pos position to be played on gameBoard
         * @param user specify if its computer or the user playing
         */
        public static void placePeace(char[][] gameBoard, int pos, String user){
            char symbol = '\0' ;
            if(user.equals("player")){
                symbol = 'X' ; 
                playerPositions.add(pos) ; 
            }else if(user.equals("cpu")){
                symbol ='O' ;
                cpuPositions.add(pos) ;
            }
            
            switch(pos){
                case 1:
                    gameBoard[0][0]=symbol  ;
                    break;
    
                case 2:
                    gameBoard[0][2] =symbol ;
                    break;
    
                case 3:
                    gameBoard[0][4] = symbol ;  
                    break;
    
                case 4:
                    gameBoard[2][0] = symbol;
                    break ;
    
                case 5:
                    gameBoard[2][2] = symbol ;
                    break;
    
                case 6:
                    gameBoard[2][4] = symbol ;
                    break;
    
                case 7:
                    gameBoard[4][0]= symbol;
                    break ;
    
                case 8:
                    gameBoard[4][2]= symbol;
                break ;
    
                case 9:
                    gameBoard[4][4]=symbol ; 
                    break;
    
                default:
                    System.out.println("Enter valid position!");
                    break;
            }
        }

    public static String checkWinner(){

        //possible positions to check for win (straight line through positions)
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6) ;
        List botRow = Arrays.asList(7,8,9) ; //bottom row
        List leftCol = Arrays.asList(1, 4, 7) ; 
        List midCol = Arrays.asList(2, 5, 8) ;
        List rightCol = Arrays.asList(3, 6, 9); 
        List cross1 = Arrays.asList(1, 5, 9) ;
        List cross2 = Arrays.asList(7, 5, 3) ;

        List<List> winning  = new ArrayList<List>() ; //list of list instance declared (reduces code to chek )
        winning.add(topRow)  ;
        winning.add(midRow) ;
        winning.add(botRow) ;
        winning.add(midCol);
        winning.add(leftCol) ;
        winning.add(rightCol) ;
        winning.add(cross1) ;
        winning.add(cross2) ;
        

        //iterate through player list to confirm that it has the ouput
        for( List l : winning){
            if(playerPositions.containsAll(l)) //collection parameter check
            {
                return "congratulations game won" ; 
            }else if( cpuPositions.containsAll(l)){
                return "CPU won! sorry :)" ; 

            }else if(playerPositions.size() + cpuPositions.size() == 9 ){ //if boad filled and no winning positions
                return "CAT!" ;
            }
        }


         return "" ;
    }

} 