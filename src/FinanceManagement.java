import java.io.File;

public class FinanceManagement {

    private File _config_dir;
    private File _config_income;
    private File _config_expense;
    private File _config_savings;
    private File _config_recurring;

    /*

    private IncomeTracker _income_tracker;
    private ExpenseTracker _expense_tracker;
    private SavingsTracker _savings_tracker;
    private RecurringExpenseTracker _recurring_expense_tracker;

    */

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



    }



    public static void main(String[] args) {

        FinanceManagement obj = new FinanceManagement();
        
    }
}
