import java.util.Scanner;
public class TicTacToe{
    public static void main(String[] args){
        //borard
        char [][] gameBoard ={{' ','|',' ','|',' '}, 
                            {'-','+','-','+','-'}, 
                            {' ','|',' ','|',' '}, 
                            {'-','+','-','+','-'}, 
                        {' ','|',' ','|',' '}};

        printGameBoard(gameBoard);

        Scanner scan = new Scanner(System.in) ; 
        System.out.println("Enter your placement (1-9):") ;

        int pos = scan.nextInt();

        System.out.println(pos) ; 
        // idea - changing position is filling space with 'X' or 'O'

        placePeace(gameBoard, pos,"player");

        printGameBoard(gameBoard);

        scan.close() ;


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
            }else if(user.equals("cpu")){
                symbol ='O' ;
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

}