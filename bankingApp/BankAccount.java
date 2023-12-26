import java.util.Scanner;

public class BankAccount {
     int balance ; // store account balance
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
                    System.out.println("-------------------------------------------");
                    System.out.println("Enter an amount to deposit: ");
                    System.out.println("-------------------------------------------");
                    int amount  = scanner.nextInt() ; 
                    deposit(amount);
                    System.out.println("\n") ; 
                    break;
                case 'C':
                    System.out.println("-------------------------------------------");
                    System.out.println("Enter an amount to withdraw") ; 
                    System.out.println("-------------------------------------------");
                    int amount2 = scanner.nextInt() ;
                    withdraw(amount2);
                    System.out.println("\n");
                    break;
                
                case 'D':
                    System.out.println("-------------------------------------------");
                    getPreviousTransaction();
                    System.out.println("-------------------------------------------");
                    System.out.println("\n");
                    break;

                case 'E':
                    System.out.println("******************************************************");
                    System.out.println("Thank you for using our services");
                    break;

                default:
                    System.out.println("Invalid Option!!. Please enter again") ;
                    break;     

            }
        }while( option != 'E');

        System.out.println(customerId);



    }
}
