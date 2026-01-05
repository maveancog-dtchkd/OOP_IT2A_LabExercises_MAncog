import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class ArithmeticGame extends JFrame {
    private JPanel panel1, panel2, panel3;
    private JTextField num1Field, num2Field, operatorLabel, userInputField;
    private JButton submitButton, cancelButton, nextButton;
    private JLabel messageLabel, scrollingLabel, correctLabel, incorrectLabel;
    private JRadioButton addButton, subButton, mulButton, divButton;
    private JRadioButton level1Button, level2Button, level3Button;
    private ButtonGroup operatorGroup, levelGroup;
    private int num1, num2, correctAnswer;
    private String selectedOperator;
    private Random random = new Random();
    private int correctCount = 0, incorrectCount = 0;
    private String[] messages = {
        "Slow lang, di ’to karera",
        "Math genius ka pala eh, eto oh",
        "Pag tama ’to, libre self-confidence",
        "Hinga muna… tapos compute ulit",
        "Math is fun daw, sabi ng teacher"
    };
    

    public ArithmeticGame() {
        // frame
        setTitle("💜 Arithmetic Game");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(15, 15));
        getContentPane().setBackground(new Color(240, 230, 255));

        Color pastelPurple = new Color(230, 210, 255); // very soft purple
        Color bubblePurple = new Color(200, 160, 235); // bubbly purple

        //gui
        submitButton = createStyledButton("Submit", new Color(186, 85, 211));
        cancelButton = createStyledButton("Cancel", new Color(148, 0, 211));
        nextButton   = createStyledButton("Next", new Color(170, 70, 230));

        // panel3, settings
        panel3 = new JPanel();
        panel3.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(10, 10, 10, 10),
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(155, 89, 182), 3, true),
                "⚙ Settings",
                0,
                0,
                new Font("Arial", Font.BOLD, 16),
                new Color(100, 50, 150)
            )
        ));
        panel3.setLayout(new GridLayout(2, 1, 10, 10));
        panel3.setBackground(bubblePurple);

        JPanel operatorPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        operatorPanel.setBackground(bubblePurple);
        JPanel levelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        levelPanel.setBackground(bubblePurple);

        operatorGroup = new ButtonGroup();
        levelGroup = new ButtonGroup();

        addButton = createRadio("Addition (+)", true);
        subButton = createRadio("Subtraction (-)", false);
        mulButton = createRadio("Multiplication (*)", false);
        divButton = createRadio("Division (/)", false);

        operatorGroup.add(addButton);
        operatorGroup.add(subButton);
        operatorGroup.add(mulButton);
        operatorGroup.add(divButton);

        level1Button = createRadio("Level 1 (1–100)", true);
        level2Button = createRadio("Level 2 (100–200)", false);
        level3Button = createRadio("Level 3 (200–300)", false);

        levelGroup.add(level1Button);
        levelGroup.add(level2Button);
        levelGroup.add(level3Button);

        // Auto-generate problem when operator or level changes
        ActionListener autoGenerate = e -> {
            generateProblem();
            userInputField.setText("");
            messageLabel.setText(messages[random.nextInt(messages.length)]);
            userInputField.requestFocus();
        };

        addButton.addActionListener(autoGenerate);
        subButton.addActionListener(autoGenerate);
        mulButton.addActionListener(autoGenerate);
        divButton.addActionListener(autoGenerate);
        level1Button.addActionListener(autoGenerate);
        level2Button.addActionListener(autoGenerate);
        level3Button.addActionListener(autoGenerate);

        JLabel opLabel = new JLabel("Operator:");
        opLabel.setFont(new Font("Arial", Font.BOLD, 14));
        opLabel.setForeground(new Color(80, 40, 120));
        operatorPanel.add(opLabel);
        operatorPanel.add(addButton);
        operatorPanel.add(subButton);
        operatorPanel.add(mulButton);
        operatorPanel.add(divButton);

        JLabel lvlLabel = new JLabel("Level:");
        lvlLabel.setFont(new Font("Arial", Font.BOLD, 14));
        lvlLabel.setForeground(new Color(80, 40, 120));
        levelPanel.add(lvlLabel);
        levelPanel.add(level1Button);
        levelPanel.add(level2Button);
        levelPanel.add(level3Button);

        panel3.add(operatorPanel);
        panel3.add(levelPanel);

        //panel1 - Main Problem Area
        panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(15, 15, 15, 15),
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(155, 89, 182), 3, true),
                "🧮 Solve the Problem",
                0,
                0,
                new Font("Arial", Font.BOLD, 16),
                new Color(100, 50, 150)
            )
        ));
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.setBackground(pastelPurple);

        // Problem display panel
        JPanel problemPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
        problemPanel.setBackground(pastelPurple);

        num1Field = styledField(5);
        operatorLabel = styledField(3);
        num2Field = styledField(5);
        userInputField = styledField(10);
        userInputField.setEditable(true); // Make user input field editable!

        problemPanel.add(num1Field);
        problemPanel.add(operatorLabel);
        problemPanel.add(num2Field);
        problemPanel.add(new JLabel(" = "));
        problemPanel.add(userInputField);

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonPanel.setBackground(pastelPurple);
        buttonPanel.add(submitButton);
        buttonPanel.add(nextButton);
        buttonPanel.add(cancelButton);

        // Score panel
        JPanel scorePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 30, 10));
        scorePanel.setBackground(pastelPurple);

        correctLabel = new JLabel("✓ Correct: 0");
        incorrectLabel = new JLabel("✗ Incorrect: 0");
        correctLabel.setFont(new Font("Arial", Font.BOLD, 16));
        incorrectLabel.setFont(new Font("Arial", Font.BOLD, 16));
        correctLabel.setForeground(new Color(80, 40, 120));
        incorrectLabel.setForeground(new Color(80, 40, 120));
        
        scorePanel.add(correctLabel);
        scorePanel.add(incorrectLabel);

        panel1.add(problemPanel);
        panel1.add(buttonPanel);
        panel1.add(scorePanel);

        //panel2, messages
        panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createEmptyBorder(10, 15, 10, 15),
            BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(new Color(155, 89, 182), 3, true),
                "💬 Messages",
                0,
                0,
                new Font("Arial", Font.BOLD, 16),
                new Color(100, 50, 150)
            )
        ));
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.setBackground(bubblePurple);

        messageLabel = new JLabel("Select operator and level to start!");
        messageLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        messageLabel.setForeground(new Color(80, 40, 120));

        scrollingLabel = new JLabel(scrollText);
        scrollingLabel.setFont(new Font("Arial", Font.BOLD, 14));
        scrollingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        scrollingLabel.setForeground(new Color(120, 60, 160));

        panel2.add(Box.createVerticalStrut(5));
        panel2.add(messageLabel);
        panel2.add(Box.createVerticalStrut(10));
        panel2.add(scrollingLabel);
        panel2.add(Box.createVerticalStrut(5));

        add(panel3, BorderLayout.NORTH);
        add(panel1, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);

        //listeners
        nextButton.addActionListener(e -> {
            generateProblem();
            userInputField.setText("");
            messageLabel.setText(messages[random.nextInt(messages.length)]);
            userInputField.requestFocus();
        });

        submitButton.addActionListener(e -> {
            checkAnswer();
            // Auto-generate next problem after checking answer
            generateProblem();
            userInputField.setText("");
            userInputField.requestFocus();
        });

        cancelButton.addActionListener(e -> {
            userInputField.setText("");
            messageLabel.setText("Cancelled. Click Next for a new problem.");
        });

        //scrolling text
        scrollTimer = new Timer(300, e -> {
            scrollText = scrollText.substring(1) + scrollText.charAt(0);
            scrollingLabel.setText(scrollText);
        });
        scrollTimer.start();

        // Generate initial problem
        generateProblem();
        messageLabel.setText(messages[random.nextInt(messages.length)]);

        setVisible(true);
    }

    //helper
    private JTextField styledField(int size) {
        JTextField f = new JTextField(size);
        f.setEditable(false);
        f.setFont(new Font("Arial", Font.BOLD, 22));
        f.setHorizontalAlignment(JTextField.CENTER);
        f.setBackground(Color.WHITE);
        f.setForeground(new Color(100, 50, 150));
        f.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(155, 89, 182), 3, true),
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        ));
        return f;
    }

    //styled buttons
    private JButton createStyledButton(String text, Color bg) {
        JButton btn = new JButton(text);
        btn.setForeground(Color.WHITE);
        btn.setBackground(bg);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Arial", Font.BOLD, 15));
        btn.setPreferredSize(new Dimension(100, 40));
        btn.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(100, 50, 150), 2, true),
            BorderFactory.createEmptyBorder(5, 15, 5, 15)
        ));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return btn;
    }

    // radio buttons
    private JRadioButton createRadio(String text, boolean selected) {
        JRadioButton rb = new JRadioButton(text, selected);
        rb.setBackground(new Color(200, 160, 235));
        rb.setForeground(new Color(80, 40, 120));
        rb.setFont(new Font("Arial", Font.BOLD, 13));
        rb.setCursor(new Cursor(Cursor.HAND_CURSOR));
        rb.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        return rb;
    }

    //logic functions
    private void generateProblem() {
        int min = 1, max = 100;
        if (level2Button.isSelected()) { min = 100; max = 200; }
        else if (level3Button.isSelected()) { min = 200; max = 300; }

        num1 = random.nextInt(max - min + 1) + min;
        num2 = random.nextInt(max - min + 1) + min;

        if (addButton.isSelected()) {
            selectedOperator = "+";
            correctAnswer = num1 + num2;
        } else if (subButton.isSelected()) {
            selectedOperator = "-";
            correctAnswer = num1 - num2;
        } else if (mulButton.isSelected()) {
            selectedOperator = "*";
            correctAnswer = num1 * num2;
        } else if (divButton.isSelected()) {
            selectedOperator = "/";
            do {
                num1 = random.nextInt(max - min + 1) + min;
                num2 = random.nextInt(max) + 1;
            } while (num1 % num2 != 0);
            correctAnswer = num1 / num2;
        }

        num1Field.setText("" + num1);
        operatorLabel.setText(selectedOperator);
        num2Field.setText("" + num2);
    }

    private void checkAnswer() {
        try {
            int userAnswer = Integer.parseInt(userInputField.getText().trim());
            if (userAnswer == correctAnswer) {
                correctCount++;
                messageLabel.setText("💜 Correct! Great job!");
            } else {
                incorrectCount++;
                messageLabel.setText("❌ Incorrect! Correct answer: " + correctAnswer);
            }
            correctLabel.setText("✓ Correct: " + correctCount);
            incorrectLabel.setText("✗ Incorrect: " + incorrectCount);
        } catch (NumberFormatException e) {
            messageLabel.setText("Invalid input. Enter a number!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ArithmeticGame::new);
    }
}
