import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

interface InflationObserver{
    void inflation();
}

abstract class Coin implements InflationObserver{
    public static final double DEFAULT_VAL = 0.0;
    private final String name;
    private Double usdValue;

    public Coin(String name, Double value){
        this.name = name;
        this.usdValue = value;
    }

    public Coin(String name){
        this.name = name;
        this.usdValue = DEFAULT_VAL;
    }

    String getName(){return name;}

    double getUSDValue(){return usdValue;}

    void setUSDValue(double usdValue){this.usdValue = usdValue;}
}

class FiatCurrency extends Coin{

    public static final double INFLATION_FACTOR = 0.9;

    public FiatCurrency(String name, Double value) {
        super(name, value);
    }

    public FiatCurrency(String name) {
        super(name);
    }

    @Override
    public void inflation() {
        setUSDValue(getUSDValue()* INFLATION_FACTOR);
    }
}

class CryptoCurrency extends Coin{

    public static final double INFLATION_FACTOR = 0.8;

    public CryptoCurrency(String name, Double value) {
        super(name, value);
    }

    public CryptoCurrency(String name) {
        super(name);
    }

    @Override
    public void inflation() {
        setUSDValue(getUSDValue()* INFLATION_FACTOR);
    }
}

class Wallet<C extends Coin>{
    HashMap<C, Double> wallet;

    public Wallet(){
        this.wallet = new HashMap<>();
    }

    // adds a coin to the wallet
    public void addCoin(C coin, double amount){
        wallet.put(coin, amount);
    }

    // returns the total value of all the coins in the wallet
    public double getWalletBalance(){
        double total = 0;
        for(C coin: wallet.keySet()){
            total += wallet.get(coin);
        }
        return total;
    }
}

enum CoinType{ FIAT, CRYPTO}

class Bank{
    private static HashMap<String, Coin> coins = new HashMap<>();

    public static Coin getCoin(String name, CoinType type){
        if(coins.containsKey(name)){
            return coins.get(name);
        }
        Coin coin = CoinFactory.create(name, type);
        coins.put(name, coin);
        return coin;
    }

    public void inflation(){
        for(var name: coins.keySet()){
            coins.get(name).inflation();
        }
    }
}

class CoinFactory{
    public static Coin create(String name, CoinType type){
        switch (type){
            case CRYPTO: return new CryptoCurrency(name);
            case FIAT: return new FiatCurrency(name);
            default: return null;
        }
    }
}
