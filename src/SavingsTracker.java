import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SavingsTracker implements Serializable {

    private double _goal;
    private double _savings;


    public SavingsTracker( FinanceManagement obj, String config ) {


        double savings = obj.getIncome() - obj.getExpense();
        setGoal(savings);
        obj.setBalance(savings);

        System.out.println(_savings);



        try{
            FileOutputStream config_savings = new FileOutputStream( config );
            ObjectOutputStream out = new ObjectOutputStream(config_savings);
            out.writeObject(this);
        }
        catch( Exception e ){
            System.out.println( e );
        }
        
    }


    public void setGoal( double goal ){
        this.goal = goal;
    }
    public double getGoal(){
        return this.goal;
    }



    
}
