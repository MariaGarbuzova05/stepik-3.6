import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SeasonRadioButtonApp extends JFrame {

    private JLabel answerLabel;
    private JRadioButton springButton;
    private JRadioButton summerButton;
    private JRadioButton autumnButton;
    private JRadioButton winterButton;

    public SeasonRadioButtonApp() {
        setTitle("Season RadioButton App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 250);
        setLocationRelativeTo(null);

        // 1. Create RadioButtons
        springButton = new JRadioButton("Весна");
        summerButton = new JRadioButton("Лето");
        autumnButton = new JRadioButton("Осень");
        winterButton = new JRadioButton("Зима");

        // 2. Create ButtonGroup
        ButtonGroup seasonGroup = new ButtonGroup();
        seasonGroup.add(springButton);
        seasonGroup.add(summerButton);
        seasonGroup.add(autumnButton);
        seasonGroup.add(winterButton);

        // 3. Create Button
        JButton answerButton = new JButton("Ответить");

        // 4. Create Answer Label
        answerLabel = new JLabel("Ответ: ");
        answerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // 5. Add ActionListener to Button
        answerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedSeason = null;
                if (springButton.isSelected()) {
                    selectedSeason = "Весна";
                } else if (summerButton.isSelected()) {
                    selectedSeason = "Лето";
                } else if (autumnButton.isSelected()) {
                    selectedSeason = "Осень";
                } else if (winterButton.isSelected()) {
                    selectedSeason = "Зима";
                }

                if (selectedSeason != null) {
                    answerLabel.setText("Ответ: " + selectedSeason);
                } else {
                    JOptionPane.showMessageDialog(SeasonRadioButtonApp.this, "Please select a season.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // 6. Set Layout and Add Components
        setLayout(new FlowLayout());
        add(new JLabel("Выберите ваше любимое время года:"));
        add(springButton);
        add(summerButton);
        add(autumnButton);
        add(winterButton);
        add(answerButton);
        add(answerLabel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SeasonRadioButtonApp::new);
    }
}