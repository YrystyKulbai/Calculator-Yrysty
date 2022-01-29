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

    private CalculatorFrame frame;

    private JButton[] numButtons = new JButton[10];
    private JButton dotButton = new JButton();

    // Memory Operation
    private JButton mcButton = new JButton();
    private JButton mrButton = new JButton();
    private JButton mPlusButton = new JButton();
    private JButton mMinusButton = new JButton();
    private JButton msButton = new JButton();

    // Binary Operation
    private JButton plusButton = new JButton();
    private JButton minusButton = new JButton();
    private JButton divideButton = new JButton();
    private JButton multiplyButton = new JButton();
    private JButton expButton = new JButton();

    // Unary Operation
    private JButton sqrtButton = new JButton();
    private JButton modButton = new JButton();
    private JButton logButton = new JButton();
    private JButton factorialButton = new JButton();
    private JButton invertSignButton = new JButton();

    private JButton equalButton = new JButton();
    private JButton ceButton = new JButton();
    private JButton clearButton = new JButton();
    private JButton backspaceButton = new JButton();

    public OperationPanel(CalculatorFrame f) {
        frame = f;
        setLayout(new GridLayout(6, 5));
        createUIComponents();
        addComponents();
    }

    private void createUIComponents() {
        setupNumButtons();
        setupBinaryOpButtons();
        setupUnaryOpButtons();
        setupMemoryButtons();
        setupFunctionButtons();
    }

    private void setupNumButtons() {
        for (Integer i = 0; i < 10; i++) {
            numButtons[i] = new JButton();
            numButtons[i].setText(i.toString());
            numButtons[i].addActionListener(this);
        }
    }

    private void setupBinaryOpButtons() {
        plusButton.setText("+");
        plusButton.addActionListener(this);

        minusButton.setText("-");
        minusButton.addActionListener(this);

        divideButton.setText("/");
        divideButton.addActionListener(this);

        multiplyButton.setText("*");
        multiplyButton.addActionListener(this);

        modButton.setText("%");
        modButton.addActionListener(this);

        expButton.setText("exp");
        expButton.addActionListener(this);
    }

    private void setupUnaryOpButtons() {
        sqrtButton.setText("√");
        sqrtButton.addActionListener(this);

        logButton.setText("log");
        logButton.addActionListener(this);

        factorialButton.setText("!");
        factorialButton.addActionListener(this);

        invertSignButton.setText("+/-");
        invertSignButton.addActionListener(this);
    }

    private void setupMemoryButtons() {
        mcButton.setText("MC");
        mcButton.addActionListener(this);

        msButton.setText("MS");
        msButton.addActionListener(this);

        mrButton.setText("MR");
        mrButton.addActionListener(this);

        mPlusButton.setText("M+");
        mPlusButton.addActionListener(this);

        mMinusButton.setText("M-");
        mMinusButton.addActionListener(this);
    }

    private void setupFunctionButtons() {
        ceButton.setText("CE");
        ceButton.addActionListener(this);

        clearButton.setText("C");
        clearButton.addActionListener(this);

        backspaceButton.setText("←");
        backspaceButton.addActionListener(this);

        dotButton.setText(".");
        dotButton.addActionListener(this);

        equalButton.setText("=");
        equalButton.addActionListener(this);
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

    }
}
