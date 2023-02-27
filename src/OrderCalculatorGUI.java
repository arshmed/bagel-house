import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderCalculatorGUI extends JFrame {

    private BagelPanel bagels;
    private ToppingPanel toppings;
    private CoffeePanel coffee;
    private GreetingPanel banner;
    private JPanel buttonPanel;
    private JButton calcButton;
    private JButton exitButton;
    private final double TAX_RATE = 0.06;

    public OrderCalculatorGUI() {

        setTitle("Order Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        banner = new GreetingPanel();
        bagels = new BagelPanel();
        toppings = new ToppingPanel();
        coffee = new CoffeePanel();

        buildButtonPanel();

        add(banner, BorderLayout.NORTH);
        add(bagels, BorderLayout.WEST);
        add(toppings, BorderLayout.CENTER);
        add(coffee, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setVisible(true);


    }

    public void buildButtonPanel() {

        buttonPanel = new JPanel();

        calcButton = new JButton("Calculate");
        exitButton = new JButton("Exit");

        calcButton.addActionListener(new CalculateButtonListener());
        exitButton.addActionListener(new ExitButtonListener());

        buttonPanel.add(calcButton);
        buttonPanel.add(exitButton);

    }

    private class CalculateButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            double subTotal, tax, totalCost;

            subTotal = bagels.getBagelCost() +
                    toppings.getToppingCost() +
                    coffee.getCoffeeCost();
            tax = subTotal * TAX_RATE;
            totalCost = subTotal + tax;

            JOptionPane.showMessageDialog(null,
                    String.format("Subtotal: $%,.2f\n" +
                                    "Tax: $%,.2f\n" +
                                    "Total: $%,.2f",
                            subTotal, tax, totalCost));
        }
    }

    private class ExitButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            System.exit(0);

        }

    }

    public static void main(String[] args) {

        new OrderCalculatorGUI();

    }

}
