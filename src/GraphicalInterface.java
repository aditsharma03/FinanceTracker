import java.awt.BorderLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

public class GraphicalInterface extends FinanceManagement {

    public GraphicalInterface() {
        super();

        Font arial = new Font("Arial", Font.PLAIN, 18);
        UIManager.put( "Label.font", arial );
        UIManager.put( "Button.font", arial );
        UIManager.put( "TabbedPane.font", arial );

        


        JFrame frame = new JFrame("Finance Tracker");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);


        JTabbedPane tabbedpane = new JTabbedPane();

        JPanel tab1 = new JPanel();
        JPanel tab2 = new JPanel();
        JPanel tab3 = new JPanel();
        JPanel tab4 = new JPanel();
        tab4.add( new JLabel("Savings") );


        tab1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        configOverview(tab1);

        tab2.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        configIncome(tab2);

        tab3.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        configExpense(tab3);

        tab4.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        //configSavings(tab4);

        
        tabbedpane.addTab("Overview", tab1 );
        tabbedpane.addTab("Income", tab2 );
        tabbedpane.addTab("Expense", tab3 );
        tabbedpane.addTab("Savings", tab4 );

        frame.add( tabbedpane, BorderLayout.CENTER );

    }


    public void configOverview( JPanel tab ){
        refresh();
        JLabel totalIncomeLabel = new JLabel("Total Income: " + getIncome() );
        JLabel totalExpenseLabel = new JLabel("Total Expenses: " + getExpense() );
        double savings = getIncome() - getExpense();
        JLabel totalSavingsLabel = new JLabel("Total Savings: " + savings );

        // Add content to the panel
        
        tab.setLayout(new BoxLayout(tab, BoxLayout.Y_AXIS));


        JLabel heading = new JLabel("Overview");
        heading.setFont(new Font("Arial", Font.BOLD, 36));
        heading.setBorder(BorderFactory.createEmptyBorder(20, 0, 30, 0));
        tab.add( heading );

        tab.add(totalIncomeLabel);
        tab.add(totalExpenseLabel);
        tab.add(totalSavingsLabel);

    }

    public void configIncome( JPanel tab ){
        refresh();

        DefaultListModel<String> incomeListModel = new DefaultListModel<>();
        JList<String> incomeList = new JList<>(incomeListModel);
        JScrollPane scrollPane = new JScrollPane(incomeList);
        refreshIncomeList(incomeListModel);


        JLabel heading = new JLabel("Overall Income");
        heading.setFont(new Font("Arial", Font.BOLD, 36));
        heading.setBorder(BorderFactory.createEmptyBorder(20, 0, 30, 20));

        tab.setLayout(new BoxLayout(tab, BoxLayout.Y_AXIS));

        tab.add( heading );
        tab.add(scrollPane);

    }
    private void refreshIncomeList(DefaultListModel<String> incomeListModel){
        incomeListModel.clear();
        List<IncomeEntity> incomeEntities = _income_tracker.get_income_sources();
        for( IncomeEntity income: incomeEntities ){
            incomeListModel.addElement(income.getName() + "\t:" + income.getCurrency()+" "+income.getAmount() + "\t:" + income.getDescription() );
        }

    }




    public void configExpense( JPanel tab ){
        refresh();

        DefaultListModel<String> expenseListModel = new DefaultListModel<>();
        JList<String> expenseList = new JList<>(expenseListModel);
        JScrollPane scrollPane = new JScrollPane(expenseList);
        refreshExpenseList(expenseListModel);


        JLabel heading = new JLabel("Overall Expense");
        heading.setFont(new Font("Arial", Font.BOLD, 36));
        heading.setBorder(BorderFactory.createEmptyBorder(20, 0, 30, 20));

        tab.setLayout(new BoxLayout(tab, BoxLayout.Y_AXIS));

        tab.add( heading );
        tab.add(scrollPane);

    }
    private void refreshExpenseList(DefaultListModel<String> expenseListModel){
        expenseListModel.clear();
        List<ExpenseEntity> expenseEntities = _expense_tracker.get_expense_sources();
        for( ExpenseEntity expense: expenseEntities ){
            expenseListModel.addElement(expense.getName() + "\t:" + expense.getCurrency()+" "+expense.getAmount() + "\t:" + expense.getDescription() );
        }

    }



    public static void main(String[] args) {
        
        GraphicalInterface obj = new GraphicalInterface();
    }
    
}
