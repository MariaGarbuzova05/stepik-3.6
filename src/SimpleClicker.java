import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleClicker extends JFrame {

    private int clickCount = 0;
    private JLabel countLabel;

    public SimpleClicker() {
        setTitle("Simple Clicker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        // 1. Create the Click Button
        JButton clickButton = new JButton("Click Me!");

        // 2. Create the Count Label
        countLabel = new JLabel("Clicks: 0");
        countLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the text

        // 3. Add Action Listener to the Button
        clickButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickCount++;
                countLabel.setText("Clicks: " + clickCount);
            }
        });

        // 4. Set Layout and Add Components
        setLayout(new BorderLayout());
        add(clickButton, BorderLayout.CENTER);
        add(countLabel, BorderLayout.NORTH);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SimpleClicker::new);
    }
}