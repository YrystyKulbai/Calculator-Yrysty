package calculator.operation.binary;

public class OperationExp extends BinaryOperation{
    @Override
    public double getResult() {
        return Math.pow(firstNum, secondNum);
    }
}
