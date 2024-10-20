import java.io.Serializable;


public class TransactionEntity implements Serializable {
    
    private Currency _currency;
    private double _amount;
    private String _name;
    private String _description;


    public TransactionEntity( Currency currency, double amount, String name, String description ) {
        
        setCurrency( currency );
        setAmount(amount);
        setName(name);
        setDescription(description);

    }

    public void setCurrency( Currency currency ){
        this._currency = currency;
    }
    public Currency getCurrency(){
        return this._currency;
    }

    public void setAmount( double amount ){
        this._amount = amount;
    }
    public double getAmount(){
        return this._amount;
    }

    public void setName( String name  ){
        this._name = name;
    }
    public String getName(){
        return this._name;
    }

    public void setDescription( String description ){
        this._description = description;
    }
    public String getDescription(){
        return this._description;
    }
}
