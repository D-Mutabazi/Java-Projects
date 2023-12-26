import java.util.Scanner;

public class BankingApplication{


}

class BankAccount{
    int balance ; 
    int previousTransaction;
    String customerName;
    String customerId ;

    // constructor to initialize user Account
    BankAccount(String cname, String cId){
        customerName = cname ; 
        customerId = cId ;
    }

    // deposit money
    void deposit(int amount){
        if(amount != 0){
            balance = balance +amount ; 
            previousTransaction = amount;
        }
    }
    // withdraw money
    void withdraw(int amount){
        if(amount != 0 ){
            balance = balance - amount ;
            previousTransaction = -amount ; //keep track of amount withdrawn per transaction
        }
    }
    // return statetement of previous transaction
    void getPreviousTransaction(){
        if(previousTransaction > 0 ){
            System.out.println("Deposited: "+previousTransaction);
        }else if(previousTransaction < 0 ){
            System.out.println("Withdrawn: "+Math.abs(previousTransaction)) ;
        }else{
            System.out.println("No transaction occurred");
        }
    }

    //display menu to user
    void showMenu(){
        char option = '\0' ;  //initialize character 
        Scanner scanner = new Scanner(System.in) ;  //read user input

        //welcome message
        System.out.println("Welcome "+customerName);
        System.out.println("Your ID is "+customerId) ;
        System.out.println("\n") ; 

        System.out.println("A. Check Balance") ;
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");

        // do loop used, to read the input from a user once atleast
        do{
            System.out.println("=============================================================================");
            System.out.println("Enter an option: ") ; 
            System.out.println("=============================================================================");
            option = scanner.next().charAt(0) ; // recieve user input
            System.out.println("\n") ;

            switch(option){
                case 'A':
                    System.out.println("-------------------------------------------");
                    System.out.println("Balance: "+balance);
                    System.out.println("-------------------------------------------");
                    System.out.println("\n");
                    break ;
                    case 'B':
                    Syse

            }
        }while( option != 'E');

        System.out.println(customerId);



    }


    
}