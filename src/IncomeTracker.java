import java.util.List;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class IncomeTracker implements Serializable {
    
    private double _total_income;

    private List<TransactionEntity> _income_sources;

    public IncomeTracker( FinanceManagement obj, String config ) {


        _income_sources = new ArrayList<>();


        try{
            FileOutputStream config_income = new FileOutputStream( config );
            ObjectOutputStream out = new ObjectOutputStream(config_income );
            out.writeObject(this);
        }
        catch( Exception e ){
            System.out.println( e );
        }

    }

    public void addIncomeSource( IncomeSource source ){
        this._income_sources.add( source  );
    }

    public double calculateIncome(){
        _total_income = 0;
        for( IncomeSource src: _income_sources ){
            _total_income += src.getAmount();
        }

        return _total_income;
    }
}
