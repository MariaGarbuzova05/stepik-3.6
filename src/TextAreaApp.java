import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextAreaApp extends JFrame {

    private JTextArea textArea;
    private JTextField textField;

    public TextAreaApp() {
        setTitle("Text Area App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // 1. Create Components
        textField = new JTextField(20);
        JButton addButton = new JButton("Записать");
        textArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(textArea); // Add scroll bars if needed

        // 2. Set JTextArea to Non-Editable (Optional)
        textArea.setEditable(false);

        // 3. Add Action Listener to Button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newText = textField.getText().trim();
                if (!newText.isEmpty()) {
                    textArea.append(newText + "\n"); // Append new text with a newline
                    textField.setText(""); // Clear the text field
                }
            }
        });

        // 4. Set Layout and Add Components
        setLayout(new FlowLayout()); // Use a FlowLayout for simplicity
        add(new JLabel("Новая строка"));
        add(textField);
        add(addButton);
        add(scrollPane);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TextAreaApp::new);
    }
}
