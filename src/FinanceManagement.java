import java.io.File;

public class FinanceManagement {

    private double _income;
    private double _expense;
    private double _balance;

    private File _config_dir;
    private File _config_income;
    private File _config_expense;
    private File _config_savings;
    private File _config_recurring;

    

    //private IncomeTracker _income_tracker;
    //private ExpenseTracker _expense_tracker;
    private SavingsTracker _savings_tracker;
    //private RecurringExpenseTracker _recurring_expense_tracker;

    

    public FinanceManagement() {
        
        String path_config = "config/";

        _config_dir = new File(path_config);

        if( ! _config_dir.exists() ){
            try{
                _config_dir.mkdirs();
            }
            catch( Exception e  ){
                System.out.println(e);
            }
        }



        String path_savings = path_config + "savings";
        _savings_tracker = new SavingsTracker( this,  path_savings );






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
