public class Stock {
    private int shares ; // # shares after transactions
    private double price ;
    private double capital ; // total capital for all stocks bought

    // buy stock
    public void buy(double p, int s){
        shares+=s ; //accumlate bought shares
        price =p ;
        capital += s *p ; // ... ... capita;
    }

    // sell stocks
    public void sell(double p, int s){
        shares -=s ;
        price =p ;
        capital -= s*p ;  // needed capital decreases
    }

    // total shares accumulated
    public int getShares(){
        return shares ;
    }

    // average share price
    public double getAveragePrice(){
        return capital/shares ; 
    }

    // share price
    public double getPrice(){
        return price ;
    }
}
