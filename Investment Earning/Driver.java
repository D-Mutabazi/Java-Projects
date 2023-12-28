import java.util.Scanner;
public class Driver{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your buying price per share");
        double buyingPrice = scan.nextDouble() ;
        int day  = 1 ;
        double closingPrice = 0.1 ;

        // enter closing price indefinitely (sentinel controlled)
        while(true){
            System.out.println("Enter closing price for day "+day+" OR enter negative val to exit") ;
            closingPrice = scan.nextDouble() ;
            if(closingPrice < 0.0) break; //exit program for negtive closing entered
            double earnings = closingPrice - buyingPrice;
            // earnings report
            if(earnings > 0){
                System.out.println("After day "+day+", you earned "+earnings+ " per share");
            }else if(earnings < 0){
                System.out.println("After day "+day+", you lost "+ (-earnings) +" per share.") ;
            }else{
                System.out.println("After day "+day+", you have made no earnings per share.");
            }
            day+=1 ;
        }
        scan.close();

    }
}