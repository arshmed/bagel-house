import javax.swing.*;
import java.awt.*;

public class CoffeePanel extends JPanel {

    public final double NO_COFFEE = 0.0;
    public final double REGULAR_COFFEE = 1.25;
    public final double DECAF_COFFEE = 1.25;
    public final double CAPPUCCINO = 2.0;

    private JRadioButton noCoffee;
    private JRadioButton regularCoffee;
    private JRadioButton decafCoffee;
    private JRadioButton cappuccino;
    private ButtonGroup bg;

    public CoffeePanel() {

        setLayout(new GridLayout(4, 1));

        noCoffee = new JRadioButton("None");
        regularCoffee = new JRadioButton("Regular Coffee", true);
        decafCoffee = new JRadioButton("Decaf Coffee");
        cappuccino = new JRadioButton("Cappuccino");

        bg = new ButtonGroup();
        bg.add(noCoffee);
        bg.add(regularCoffee);
        bg.add(decafCoffee);
        bg.add(cappuccino);

        add(noCoffee);
        add(regularCoffee);
        add(decafCoffee);
        add(cappuccino);

    }

    public double getCoffeeCost() {

        double coffeeCost = 0.0;

        if (noCoffee.isSelected())
            coffeeCost += NO_COFFEE;
        if (regularCoffee.isSelected())
            coffeeCost += REGULAR_COFFEE;
        if (decafCoffee.isSelected())
            coffeeCost += DECAF_COFFEE;
        if (cappuccino.isSelected())
            coffeeCost += CAPPUCCINO;

        return coffeeCost;
    }

}
