import java.io.Serializable;


public class IncomeSource implements Serializable {
    
    private double amount;
    private String name;
    private String description;


    public IncomeSource( double amount, String name, String description ) {
        
        setAmount(amount);
        this.name = name;
        this.description = description;

    }

    public void setAmount( double amount ){
        this.amount = amount;
    }
    public double getAmount(){
        return this.amount;
    }
}
