import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class FontSizeSliderExample extends JFrame {

    private JLabel myLabel;

    public FontSizeSliderExample() {
        setTitle("Font Size Slider");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // 1. Create the JLabel (with initial text)
        myLabel = new JLabel("Моя первая надпись!");
        myLabel.setHorizontalAlignment(SwingConstants.CENTER);
        updateLabelFont(25); // Initial font size

        // 2. Create the Font Size Slider
        JSlider fontSizeSlider = new JSlider(SwingConstants.HORIZONTAL, 5, 100, 25); // Min, Max, Initial
        fontSizeSlider.setMajorTickSpacing(25);
        fontSizeSlider.setMinorTickSpacing(5);
        fontSizeSlider.setPaintTicks(true);
        fontSizeSlider.setPaintLabels(true);

        // 3. Add a ChangeListener to the slider
        fontSizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int fontSize = fontSizeSlider.getValue();
                updateLabelFont(fontSize);
            }
        });

        // 4. Layout the Components
        setLayout(new BorderLayout());
        add(myLabel, BorderLayout.CENTER);
        add(fontSizeSlider, BorderLayout.SOUTH);

        setVisible(true);
    }

    // Method to update the label's font
    private void updateLabelFont(int fontSize) {
        Font customFont = new Font("Serif", Font.ITALIC, fontSize);
        myLabel.setFont(customFont);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FontSizeSliderExample::new);
    }
}