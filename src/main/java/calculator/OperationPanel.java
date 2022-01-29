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
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
