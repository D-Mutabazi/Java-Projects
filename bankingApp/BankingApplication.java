public class BankingApplication{


}

class BankAccount{
    int balance ; 
    int previousTransaction;
    String customerName;
    String customerId ;

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
            System.out.println();
        }
    }
    
}