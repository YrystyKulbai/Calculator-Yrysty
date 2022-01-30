package calculator.operation.unary;

public class OperationInvert extends UnaryOperation {
    @Override
    public double getResult() {
        return -firstNum;
    }
}
