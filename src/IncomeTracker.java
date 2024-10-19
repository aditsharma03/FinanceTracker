import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class IncomeTracker implements Serializable {
    
    private double total_income;

    public IncomeTracker( FinanceManagement obj, String config ) {

        try{
            FileOutputStream config_income = new FileOutputStream( config );
            ObjectOutputStream out = new ObjectOutputStream(config_income );
            out.writeObject(this);
        }
        catch( Exception e ){
            System.out.println( e );
        }

    }
}
