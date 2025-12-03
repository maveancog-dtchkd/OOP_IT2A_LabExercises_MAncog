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
        "Let's see if you can solve this one!",
        "Math is fun, right? Prove it!",
        "Challenge accepted? Go for it!",
        "Think fast and calculate!",
        "You're a math wizard in the making!"
    };
    private String scrollText = "this is programmed by: LOLO, LEANDRO ALEXIS ";
    private Timer scrollTimer;

    public ArithmeticGame() {

        // frame
        setTitle("💜 Purple Arithmetic Game");
        setSize(520, 430);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        Color bgPurple = new Color(155, 89, 182);      // main purple
        Color lightPurple = new Color(200, 160, 235);  // softer purple
        Color pastelPurple = new Color(230, 210, 255); // very soft purple
        Color white = Color.WHITE;

        //gui
        submitButton = createStyledButton("Submit", new Color(186, 85, 211));
        cancelButton = createStyledButton("Cancel", new Color(148, 0, 211));
        nextButton   = createStyledButton("Next", new Color(170, 70, 230));

        // panel3, settings
        panel3 = new JPanel();
        panel3.setBorder(BorderFactory.createTitledBorder("⚙ Settings"));
        panel3.setLayout(new GridLayout(2, 4));
        panel3.setBackground(pastelPurple);

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

        panel3.add(new JLabel("Operator:"));
        panel3.add(addButton);
        panel3.add(subButton);
        panel3.add(mulButton);
        panel3.add(divButton);
        panel3.add(new JLabel("Level:"));
        panel3.add(level1Button);
        panel3.add(level2Button);
        panel3.add(level3Button);

        //panel1
        panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createTitledBorder("🧮 Solve the Problem"));
        panel1.setLayout(new FlowLayout());
        panel1.setBackground(pastelPurple);

        num1Field = styledField(5);
        operatorLabel = styledField(3);
        num2Field = styledField(5);
        userInputField = styledField(10);

        correctLabel = new JLabel("Correct: 0");
        incorrectLabel = new JLabel("Incorrect: 0");
        correctLabel.setFont(new Font("Arial", Font.BOLD, 14));
        incorrectLabel.setFont(new Font("Arial", Font.BOLD, 14));

        panel1.add(num1Field);
        panel1.add(operatorLabel);
        panel1.add(num2Field);
        panel1.add(new JLabel(" = "));
        panel1.add(userInputField);
        panel1.add(submitButton);
        panel1.add(cancelButton);
        panel1.add(nextButton);
        panel1.add(correctLabel);
        panel1.add(incorrectLabel);

        //pamel2, messages
        panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createTitledBorder("💬 Messages"));
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel2.setBackground(pastelPurple);

        messageLabel = new JLabel("Select operator and level, then click Next to start!");
        messageLabel.setFont(new Font("Arial", Font.ITALIC, 16));
        messageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        scrollingLabel = new JLabel(scrollText);
        scrollingLabel.setFont(new Font("Arial", Font.BOLD, 14));
        scrollingLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel2.add(messageLabel);
        panel2.add(Box.createVerticalStrut(10));
        panel2.add(scrollingLabel);

        add(panel3, BorderLayout.NORTH);
        add(panel1, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);

        //listenerskuno
        nextButton.addActionListener(e -> {
            generateProblem();
            userInputField.setText("");
            messageLabel.setText(messages[random.nextInt(messages.length)]);
        });

        submitButton.addActionListener(e -> checkAnswer());

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

        setVisible(true);
    }

    //helper
    private JTextField styledField(int size) {
        JTextField f = new JTextField(size);
        f.setEditable(false);
        f.setFont(new Font("Arial", Font.BOLD, 18));
        f.setHorizontalAlignment(JTextField.CENTER);
        f.setBackground(new Color(240, 225, 255));
        f.setForeground(Color.BLACK);
        f.setBorder(BorderFactory.createLineBorder(new Color(150, 80, 200), 2));
        return f;
    }

    //gandang buttons
    private JButton createStyledButton(String text, Color bg) {
        JButton btn = new JButton(text);
        btn.setForeground(Color.WHITE);
        btn.setBackground(bg);
        btn.setFocusPainted(false);
        btn.setFont(new Font("Arial", Font.BOLD, 14));
        btn.setPreferredSize(new Dimension(90, 35));
        btn.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        return btn;
    }

    // radio buttons
    private JRadioButton createRadio(String text, boolean selected) {
        JRadioButton rb = new JRadioButton(text, selected);
        rb.setBackground(new Color(230, 210, 255));
        rb.setForeground(new Color(60, 0, 110));
        return rb;
    }

    //logicfunctions
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
            correctLabel.setText("Correct: " + correctCount);
            incorrectLabel.setText("Incorrect: " + incorrectCount);
        } catch (NumberFormatException e) {
            messageLabel.setText("Invalid input. Enter a number!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ArithmeticGame::new);
    }
}
