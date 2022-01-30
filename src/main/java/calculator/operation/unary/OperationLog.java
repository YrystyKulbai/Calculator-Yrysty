package calculator.operation.unary;

public class OperationLog extends UnaryOperation {
    @Override
    public double getResult() {
        return Math.log10(firstNum);
    }
}
