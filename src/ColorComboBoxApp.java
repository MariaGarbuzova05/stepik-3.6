import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ColorComboBoxApp extends JFrame {

    private JLabel answerLabel;
    private JTextField customColorTextField;

    public ColorComboBoxApp() {
        setTitle("Color ComboBox App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        // 1. Create JComboBox
        String[] favoriteColors = {"Red", "Blue", "Green", "Yellow"};
        JComboBox<String> colorComboBox = new JComboBox<>(favoriteColors);

        // 2. Create CheckBox and TextField for Custom Color
        JCheckBox customColorCheckBox = new JCheckBox("Свой вариант");
        customColorTextField = new JTextField(15);
        customColorTextField.setEnabled(false); // Initially disabled

        // 3. Create Button
        JButton answerButton = new JButton("Ответить");

        // 4. Create Answer Label
        answerLabel = new JLabel("Ответ: ");
        answerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // 5. Add ItemListener to CheckBox
        customColorCheckBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                customColorTextField.setEnabled(e.getStateChange() == ItemEvent.SELECTED);
                if (!customColorTextField.isEnabled()) {
                    customColorTextField.setText(""); // Clear text when disabled
                }
            }
        });

        // 6. Add ActionListener to Button
        answerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedColor;
                if (customColorCheckBox.isSelected()) {
                    selectedColor = customColorTextField.getText().trim();
                    if (selectedColor.isEmpty()) {
                        JOptionPane.showMessageDialog(ColorComboBoxApp.this, "Please enter a custom color.", "Error", JOptionPane.ERROR_MESSAGE);
                        return; // Don't update the label if no custom color is entered
                    }
                } else {
                    selectedColor = (String) colorComboBox.getSelectedItem();
                }
                answerLabel.setText("Ответ: " + selectedColor);
            }
        });

        // 7. Set Layout and Add Components
        setLayout(new FlowLayout());
        add(new JLabel("Select your favorite color:"));
        add(colorComboBox);
        add(customColorCheckBox);
        add(customColorTextField);
        add(answerButton);
        add(answerLabel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ColorComboBoxApp::new);
    }
}