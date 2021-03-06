package calculator;

import javax.swing.*;
import java.awt.*;

public class CalculatorFrame extends JFrame {
    private static final String TITLE = "Calculator";
    private final JLabel memoryIndicator = new JLabel();
    private final JTextField resultField = new JTextField(26);
    private final OperationPanel operationPanel = new OperationPanel(this);

    public CalculatorFrame() {
        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        createUIComponents();
        setupPanels();
    }

    public static void main(String[] args) {
        CalculatorFrame frame = new CalculatorFrame();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        memoryIndicator.setText("M");
        memoryIndicator.setVisible(false);

        resultField.setText(" ");
        resultField.setSize(100, 100);
        resultField.setEditable(false);
    }

    private void setupPanels() {
        GridBagConstraints indicatorPos = new GridBagConstraints();
        indicatorPos.gridx = 0;
        indicatorPos.gridy = 0;
        indicatorPos.gridheight = 1;
        indicatorPos.gridwidth = 1;
        this.add(memoryIndicator, indicatorPos);

        GridBagConstraints resultPos = new GridBagConstraints();
        resultPos.gridx = 1;
        resultPos.gridy = 0;
        resultPos.gridwidth = 4;
        resultPos.gridheight = 1;
        this.add(resultField, resultPos);

        GridBagConstraints operationPos = new GridBagConstraints();
        operationPos.gridx = 0;
        operationPos.gridy = 1;
        operationPos.gridheight = 6;
        operationPos.gridwidth = 5;
        this.add(operationPanel, operationPos);

        this.pack();
    }
    public void updateEquation(String eq) {
        resultField.setText(eq);
    }

    public void setMemoryStatus(boolean status) {
        memoryIndicator.setVisible(status);
    }
}
