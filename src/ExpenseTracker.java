import java.util.List;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ExpenseTracker implements Serializable {
    
    private double _total_expense;
    private List<ExpenseEntity> _expense_sources;


    public ExpenseTracker( FinanceManagement obj, String config ) {

        _expense_sources = new ArrayList<>();

        try{
            FileOutputStream config_expense = new FileOutputStream( config );
            ObjectOutputStream out = new ObjectOutputStream(config_expense );
            out.writeObject(this);
            out.close();
        }
        catch( Exception e ){
            System.out.println( e );
        }

    }

    public void addExpenseSource( ExpenseEntity source ){
        this._expense_sources.add( source  );
    }

    public double calculateExpense(){
        _total_expense = 0;
        for( ExpenseEntity entity: _expense_sources ){
            _total_expense += entity.getRelativeAmount();
        }

        return _total_expense;
    }

    public List<ExpenseEntity> get_expense_sources() {
        return _expense_sources;
    }
}
