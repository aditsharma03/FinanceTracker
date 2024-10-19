//import FinanceManagement;

public class SavingsTracker {

    private double goal;
    private double savings;


    public SavingsTracker( FinanceManagement obj, String config ) {
        
        savings = obj.getIncome() - obj.getExpense();

        obj.setBalance(savings);

        System.out.println(savings);
    }



    
}
