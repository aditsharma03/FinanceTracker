public class IncomeEntity extends TransactionEntity {



    public IncomeEntity( Currency currency, double amount, String name, String description ) {
        super( currency, amount, name, description );
    }


    public double getRelativeAmount(){
        return getAmount();
    }

    
}
