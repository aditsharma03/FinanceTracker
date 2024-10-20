public class ExpenseEntity extends TransactionEntity {



    public ExpenseEntity( Currency currency, double amount, String name, String description ) {
        super( currency, amount, name, description );
    }


    public double getRelativeAmount(){
        double amount = getAmount();
        amount *= -1;

        return amount;
    }

    
}
