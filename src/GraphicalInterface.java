import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class GraphicalInterface extends FinanceManagement {

    public GraphicalInterface() {
        super();


        JFrame frame = new JFrame("Finance Tracker");
        frame.setSize(640, 480);
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

        
        tabbedpane.addTab("Overview", tab1 );
        tabbedpane.addTab("Income", tab2 );
        tabbedpane.addTab("Expense", tab3 );
        tabbedpane.addTab("Savings", tab4 );

        frame.add( tabbedpane, BorderLayout.CENTER );

    }


    public static void main(String[] args) {
        
        GraphicalInterface obj = new GraphicalInterface();
    }
    
}
