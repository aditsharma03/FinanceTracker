import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
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
        frame.setSize(600, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);


        JTabbedPane tabbedpane = new JTabbedPane();

        JPanel tab1 = new JPanel();
        tab1.add( new JLabel("Overview") );
        JPanel tab2 = new JPanel();
        tab2.add( new JLabel("Income") );
        JPanel tab3 = new JPanel();
        tab3.add( new JLabel("Expense") );
        JPanel tab4 = new JPanel();
        tab4.add( new JLabel("Savings") );


        tab1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        configOverview(tab1);

        tab2.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        tab3.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        tab4.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        
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
        JLabel savingsLabel = new JLabel("Total Savings: " + savings );

        // Add content to the panel
        
        tab.setLayout(new BoxLayout(tab, BoxLayout.Y_AXIS));

        tab.add(totalIncomeLabel);
        tab.add(totalExpenseLabel);
        tab.add(savingsLabel);

    }


    public static void main(String[] args) {
        
        GraphicalInterface obj = new GraphicalInterface();
    }
    
}
