package calculator.operation.binary;

public class OperationMod extends BinaryOperation{
    @Override
    public double getResult() {
        return firstNum % secondNum;
    }
}
