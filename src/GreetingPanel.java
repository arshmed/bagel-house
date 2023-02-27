import javax.swing.*;

public class GreetingPanel extends JPanel {

    private JLabel greeting;

    public GreetingPanel() {

        greeting = new JLabel("Welcome to Brandi's Bagel House");
        add(greeting);

    }

}
