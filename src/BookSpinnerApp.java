import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookSpinnerApp extends JFrame {

    private JLabel answerLabel;

    public BookSpinnerApp() {
        setTitle("Book Spinner App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        // 1. Create JSpinner
        SpinnerModel spinnerModel = new SpinnerNumberModel(1, 0, 20, 1); // Initial, min, max, step
        JSpinner bookSpinner = new JSpinner(spinnerModel);

        // 2. Create Button
        JButton answerButton = new JButton("Ответить");

        // 3. Create Answer Label
        answerLabel = new JLabel("Ответ: ");
        answerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // 4. Add Action Listener to Button
        answerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int bookCount = (int) bookSpinner.getValue();
                answerLabel.setText("Ответ: " + bookCount);
            }
        });

        // 5. Set Layout and Add Components
        setLayout(new FlowLayout());
        add(new JLabel("Сколько книг вы возьмёте с собой в лагерь?"));
        add(bookSpinner);
        add(answerButton);
        add(answerLabel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BookSpinnerApp::new);
    }
}