import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizApp extends JFrame {

    private JLabel questionLabel;
    private JButton[] answerButtons;
    private int questionIndex = 0;
    private int correctAnswers = 0;
    private List<QuizQuestion> questions;

    public QuizApp() {
        setTitle("Quiz App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // 1. Create Questions
        createQuestions();

        // 2. Create UI Components
        questionLabel = new JLabel();
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(questionLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2));
        answerButtons = new JButton[4];
        for (int i = 0; i < 4; i++) {
            answerButtons[i] = new JButton();
            answerButtons[i].addActionListener(new AnswerButtonListener());
            buttonPanel.add(answerButtons[i]);
        }
        add(buttonPanel, BorderLayout.CENTER);

        // 3. Load First Question
        loadQuestion();

        setVisible(true);
    }

    private void createQuestions() {
        questions = new ArrayList<>();
        questions.add(new QuizQuestion(
                "What is the capital of France?",
                new String[]{"London", "Paris", "Berlin", "Rome"},
                1
        ));
        questions.add(new QuizQuestion(
                "What is the highest mountain in the world?",
                new String[]{"K2", "Kangchenjunga", "Lhotse", "Mount Everest"},
                3
        ));
        questions.add(new QuizQuestion(
                "What is the largest planet in our solar system?",
                new String[]{"Mars", "Venus", "Jupiter", "Saturn"},
                2
        ));

        //You can create more questions if you want!
    }

    private void loadQuestion() {
        if (questionIndex < questions.size()) {
            QuizQuestion currentQuestion = questions.get(questionIndex);
            questionLabel.setText(currentQuestion.getQuestion());

            String[] answers = currentQuestion.getAnswers();
            for (int i = 0; i < answerButtons.length; i++) {
                answerButtons[i].setText(answers[i]);
            }
        } else {
            showResults();
        }
    }

    private void showResults() {
        double percentage = (double) correctAnswers / questions.size() * 100;
        String message = String.format("Quiz complete! You scored %.2f%% (%d/%d)", percentage, correctAnswers, questions.size());
        JOptionPane.showMessageDialog(this, message, "Results", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0); //Exit the program
    }

    // Inner class to represent a quiz question
    private class QuizQuestion {
        private String question;
        private String[] answers;
        private int correctAnswerIndex;

        public QuizQuestion(String question, String[] answers, int correctAnswerIndex) {
            this.question = question;
            this.answers = answers;
            this.correctAnswerIndex = correctAnswerIndex;
        }

        public String getQuestion() {
            return question;
        }

        public String[] getAnswers() {
            return answers;
        }

        public int getCorrectAnswerIndex() {
            return correctAnswerIndex;
        }
    }

    // Inner class to handle button clicks
    private class AnswerButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedAnswer = -1;
            for (int i = 0; i < answerButtons.length; i++) {
                if (e.getSource() == answerButtons[i]) {
                    selectedAnswer = i;
                    break;
                }
            }

            QuizQuestion currentQuestion = questions.get(questionIndex);
            if (selectedAnswer == currentQuestion.getCorrectAnswerIndex()) {
                correctAnswers++;
            }

            questionIndex++;
            loadQuestion();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(QuizApp::new);
    }
}