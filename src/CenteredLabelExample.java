import javax.swing.*;
import java.awt.*;

public class CenteredLabelExample extends JFrame {

    public CenteredLabelExample() {
        setTitle("Centered JLabel Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400); // Set a default window size
        setLocationRelativeTo(null); // Center the window on the screen

        // 1. Create the JLabel with your text
        JLabel myLabel = new JLabel("Моя первая надпись!");
        myLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center the text

        // 2. Create the Font
        Font customFont = new Font("Serif", Font.ITALIC, 30); // Change font, style, and size
        myLabel.setFont(customFont);

        // 3. Set LayoutManager to null for absolute positioning
        setLayout(null); // Remove default layout manager

        // 4. Set the bounds of the JLabel to center it
        Dimension labelSize = myLabel.getPreferredSize();
        int labelWidth = labelSize.width;
        int labelHeight = labelSize.height;

        // Calculate the center position
        int x = (getWidth() - labelWidth) / 2;
        int y = (getHeight() - labelHeight) / 2;

        myLabel.setBounds(x, y, labelWidth, labelHeight);
        add(myLabel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CenteredLabelExample::new);
    }
}