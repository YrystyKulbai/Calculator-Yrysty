package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayDeque;
import java.util.Deque;

public class OperationPanel extends JPanel implements ActionListener {
    private Deque<String> equation = new ArrayDeque<>();
    private Double memoryValue = 0.0;
    private String curToken = "";

    private boolean memoryIsOn = false;
    private boolean disableCalculator = false;
    private boolean dotExisted = false;
    private boolean operIsEnd = false;
    private boolean isFirstDigit = true;

    private final CalculatorFrame frame;

    private final JButton[] numButtons = new JButton[10];
    private final JButton dotButton = new JButton();

    // Memory Operation
    private final JButton mcButton = new JButton();
    private final JButton mrButton = new JButton();
    private final JButton mPlusButton = new JButton();
    private final JButton mMinusButton = new JButton();
    private final JButton msButton = new JButton();

    // Binary Operation
    private final JButton plusButton = new JButton();
    private final JButton minusButton = new JButton();
    private final JButton divideButton = new JButton();
    private final JButton multiplyButton = new JButton();
    private final JButton expButton = new JButton();

    // Unary Operation
    private final JButton sqrtButton = new JButton();
    private final JButton modButton = new JButton();
    private final JButton logButton = new JButton();
    private final JButton factorialButton = new JButton();
    private final JButton invertSignButton = new JButton();

    private final JButton equalButton = new JButton();
    private final JButton ceButton = new JButton();
    private final JButton clearButton = new JButton();
    private final JButton backspaceButton = new JButton();

    public OperationPanel(CalculatorFrame f) {
        frame = f;
        setLayout(new GridLayout(6, 5));
        createUIComponents();
        addComponents();
    }

    private void createUIComponents() {
        setupNumButtons(new Color(247, 247, 42));
        setupBinaryOpButtons(new Color(3, 116, 14));
        setupUnaryOpButtons(new Color(3, 116, 14));
        setupMemoryButtons(new Color(107, 103, 219));
        setupFunctionButtons(new Color(107, 103, 219));
    }

    private void setupNumButtons(Color bg) {
        for (Integer i = 0; i < 10; i++) {
            numButtons[i] = new JButton();
            numButtons[i].setText(i.toString());
            numButtons[i].addActionListener(this);
            numButtons[i].setBackground(bg);
        }
    }

    private void setupBinaryOpButtons(Color bg) {
        plusButton.setText("+");
        plusButton.addActionListener(this);
        plusButton.setBackground(bg);

        minusButton.setText("-");
        minusButton.addActionListener(this);
        minusButton.setBackground(bg);

        divideButton.setText("/");
        divideButton.addActionListener(this);
        divideButton.setBackground(bg);

        multiplyButton.setText("*");
        multiplyButton.addActionListener(this);
        multiplyButton.setBackground(bg);

        modButton.setText("%");
        modButton.addActionListener(this);
        modButton.setBackground(bg);

        expButton.setText("exp");
        expButton.addActionListener(this);
        expButton.setBackground(bg);
    }

    private void setupUnaryOpButtons(Color bg) {
        sqrtButton.setText("√");
        sqrtButton.addActionListener(this);
        sqrtButton.setBackground(bg);

        logButton.setText("log");
        logButton.addActionListener(this);
        logButton.setBackground(bg);

        factorialButton.setText("!");
        factorialButton.addActionListener(this);
        factorialButton.setBackground(bg);

        invertSignButton.setText("+/-");
        invertSignButton.addActionListener(this);
        invertSignButton.setBackground(bg);
    }

    private void setupMemoryButtons(Color bg) {
        mcButton.setText("MC");
        mcButton.addActionListener(this);
        mcButton.setBackground(bg);

        msButton.setText("MS");
        msButton.addActionListener(this);
        msButton.setBackground(bg);

        mrButton.setText("MR");
        mrButton.addActionListener(this);
        mrButton.setBackground(bg);

        mPlusButton.setText("M+");
        mPlusButton.addActionListener(this);
        mPlusButton.setBackground(bg);

        mMinusButton.setText("M-");
        mMinusButton.addActionListener(this);
        mMinusButton.setBackground(bg);
    }

    private void setupFunctionButtons(Color bg) {
        ceButton.setText("CE");
        ceButton.addActionListener(this);
        ceButton.setBackground(bg);

        clearButton.setText("C");
        clearButton.addActionListener(this);
        clearButton.setBackground(bg);

        backspaceButton.setText("←");
        backspaceButton.addActionListener(this);
        backspaceButton.setBackground(bg);

        dotButton.setText(".");
        dotButton.addActionListener(this);
        dotButton.setBackground(bg);

        equalButton.setText("=");
        equalButton.addActionListener(this);
        equalButton.setBackground(bg);
    }

    private void addComponents() {
        this.add(mcButton);
        this.add(mrButton);
        this.add(msButton);
        this.add(mPlusButton);
        this.add(mMinusButton);

        this.add(backspaceButton);
        this.add(ceButton);
        this.add(clearButton);
        this.add(invertSignButton);
        this.add(sqrtButton);

        this.add(numButtons[7]);
        this.add(numButtons[8]);
        this.add(numButtons[9]);
        this.add(divideButton);
        this.add(modButton);

        this.add(numButtons[4]);
        this.add(numButtons[5]);
        this.add(numButtons[6]);
        this.add(multiplyButton);
        this.add(factorialButton);

        this.add(numButtons[1]);
        this.add(numButtons[2]);
        this.add(numButtons[3]);
        this.add(minusButton);
        this.add(logButton);

        this.add(numButtons[0]);
        this.add(dotButton);
        this.add(equalButton);
        this.add(plusButton);
        this.add(expButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        String content = b.getText();

        if (disableCalculator && content != "C")
            return;

        switch (content) {
            case "0":
                clearLastResult();
                // Ensure that leading digit is not zero
                if (curToken.length() == 0 || !isFirstDigit)
                    curToken += content;
                break;
            case "1":
            case "2":
            case "3":
            case "4":
            case "5":
            case "6":
            case "7":
            case "8":
            case "9":
                clearLastResult();

                // Replace the leading zero to input digit
                if (curToken.length() == 1 && curToken.charAt(0) == '0')
                    curToken = content;
                else
                    curToken += content;
                isFirstDigit = false;
                break;
            case ".":
                clearLastResult();

                if (curToken.length() == 0) {
                    // Ensure dot not leads a number
                    curToken = "0.";
                } else if (!dotExisted) {
                    // Ensure only one dot exist
                    curToken += content;
                }
                isFirstDigit = false;
                dotExisted = true;

                break;

            // Binary Operation
            case "+":
            case "-":
            case "*":
            case "/":
            case "%":
                handleBinaryOp(content);
                break;
            case "exp":
                handleBinaryOp("^");
                break;

            // Unary Operation
            case "log":
            case "√":
                handleUnaryOp(content);
                break;
            case "!":
                if (Cal.isPositive(curToken))
                    handleUnaryOp(content);
                break;

            // Invert
            case "+/-":
                if (Cal.isNumeric(curToken))
                    curToken = trimDotZero(Cal.invert(curToken));
                break;

            // Equal
            case "=":
                if (curToken.length() > 0) {
                    appendZeroToLastDot();
                    equation.add(curToken);
                    curToken = "";
                } else if (equation.size() > 0)
                    equation.removeLast();

                String originEq = joinEquation();
                String result = Cal.calculate(equation).toString();
                result = trimDotZero(result);

                if (notANumber(result))
                    disableCalculator = true;

                operIsEnd = true;

                equation.clear();
                resetStatus();
                curToken = result;
                break;

            // Clear Entry
            case "CE":
                if (curToken.length() > 0)
                    curToken = "";
                break;

            // Clear
            case "C":
                curToken = "";
                equation.clear();
                disableCalculator = false;
                resetStatus();
                break;

            // BackSpace
            case "←":
                if (curToken.length() > 0)
                    curToken = curToken.substring(0, curToken.length() - 1);
                break;

            // Memory Functions
            case "MC":
                memoryIsOn = false;
                memoryValue = 0.0;
                break;

            case "MS":
                memoryIsOn = true;
                if (curToken.length() > 0)
                    memoryValue = Double.parseDouble(curToken);
                break;

            case "MR":
                if (memoryIsOn)
                    curToken = trimDotZero(String.valueOf(memoryValue));
                break;

            case "M+":
                memoryIsOn = true;
                if (curToken.length() > 0)
                    memoryValue += Double.parseDouble(curToken);
                break;
            case "M-":
                memoryIsOn = true;
                if (curToken.length() > 0)
                    memoryValue -= Double.parseDouble(curToken);
                break;
        }

        frame.setMemoryStatus(memoryIsOn);
        frame.updateEquation(joinEquation() + curToken);
    }

    private void clearLastResult() {
        if (operIsEnd) {
            curToken = "";
            operIsEnd = false;
        }
    }

    private void handleBinaryOp(String op) {
        if (curToken.length() > 0) {
            appendZeroToLastDot();
            equation.add(curToken);
            curToken = "";
        } else {
            equation.removeLast();
        }
        equation.add(op);
        resetStatus();
    }

    private void handleUnaryOp(String op) {
        if (curToken.length() > 0 && Cal.isPositive(curToken)) {
            appendZeroToLastDot();
            curToken = op + "(" + curToken + ")";
        }
    }

    private void appendZeroToLastDot() {
        if (curToken.charAt(curToken.length() - 1) == '.')
            curToken += "0";
    }

    private void resetStatus() {
        dotExisted = false;
        isFirstDigit = true;
    }

    private String joinEquation() {
        String result = " ";
        for (String token : equation)
            result += token + " ";
        return result;
    }

    private static String trimDotZero(String num) {
        if (num.substring(num.length() - 2).equals(".0"))
            num = num.substring(0, num.length() - 2);
        return num;
    }

    private static boolean notANumber(String num) {
        return num.contains("Infinity") || num.contains("NaN");
    }
}
