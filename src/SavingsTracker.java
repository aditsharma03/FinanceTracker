import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
//import FinanceManagement;

public class SavingsTracker implements Serializable {

    private double goal;
    private double savings;


    public SavingsTracker( FinanceManagement obj, String config ) {


        this.savings = obj.getIncome() - obj.getExpense();
        obj.setBalance(savings);

        System.out.println(savings);



        try{
            FileOutputStream config_savings = new FileOutputStream( config );
            ObjectOutputStream out = new ObjectOutputStream(config_savings);
            out.writeObject(this);
        }
        catch( Exception e ){
            System.out.println( e );
        }
        


        
    }



    
}
