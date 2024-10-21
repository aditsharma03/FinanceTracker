import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class FinanceManagement implements Serializable {

    private double _income;
    private double _expense;
    private double _balance;

    private File _config_dir;
    //private File _config_income;
    //private File _config_expense;
    //private File _config_savings;
    //private File _config_recurring;

    

    protected IncomeTracker _income_tracker;
    protected ExpenseTracker _expense_tracker;
    protected SavingsTracker _savings_tracker;
    //private RecurringExpenseTracker _recurring_expense_tracker;

    

    public FinanceManagement() {
        
        String path_config = "config/";
        String path_savings = path_config + "savings.ser";
        String path_income = path_config + "income.ser";
        String path_expense = path_config + "expense.ser";
        String path_recurring = path_config + "recurring.ser";



        _config_dir = new File(path_config);

        boolean flag = false;
        try{
            if( ! _config_dir.exists() ){
                _config_dir.mkdirs();
                flag = true;
            }
            else{
                FileInputStream fileIn;
                ObjectInputStream in;

                fileIn = new FileInputStream(path_income);
                in = new ObjectInputStream(fileIn);
                _income_tracker = (IncomeTracker) in.readObject();

                fileIn = new FileInputStream(path_expense);
                in = new ObjectInputStream(fileIn);
                _expense_tracker = (ExpenseTracker) in.readObject();

                fileIn = new FileInputStream(path_savings);
                in = new ObjectInputStream(fileIn);
                _savings_tracker = (SavingsTracker) in.readObject();



                in.close();
                fileIn.close();
            }
        }
        catch( Exception e  ){
            System.out.println(e);
        }
        finally{
            if( flag  ){
                _income_tracker = new IncomeTracker( this,  path_income );
                _expense_tracker = new ExpenseTracker( this, path_expense );
                _savings_tracker = new SavingsTracker( this,  path_savings );
            }

        }




    }


    public void refresh(){
        setIncome( _income_tracker.calculateIncome() );
        setExpense( _expense_tracker.calculateExpense() );
    }




    public void setIncome( double income ){
        this._income = income;
    }
    public double getIncome(){
        return this._income;
    }

    public void setExpense( double expense ){
        this._expense = expense;
    }
    public double getExpense(){
        return this._expense;
    }

    public void setBalance( double savings  ){
        this._balance = savings;
    }
    public double getBalance(){
        return this._balance;
    }
    



    public static void main(String[] args) {

        FinanceManagement obj = new FinanceManagement();
        
    }
}
