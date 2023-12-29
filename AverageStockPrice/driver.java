//controls what you do with stock
public class driver{
    public static void main(String[] args){
        Stock abcCompany = new Stock();
        //acquire stocks for company
        abcCompany.buy(36.8, 2000) ;
        abcCompany.buy(39.7, 3000) ;
        abcCompany.sell(42.9, 1000) ;
        // display stock data
        System.out.println(abcCompany.getShares()) ; //no. shares acquired
        System.out.println(abcCompany.getPrice()) ; // stockPrice/ share price
        System.out.println(abcCompany.getAveragePrice() ) ;

    }
}