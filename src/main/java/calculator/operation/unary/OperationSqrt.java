package calculator.operation.unary;

public class OperationSqrt extends UnaryOperation {
    @Override
    public double getResult() {
        return Math.sqrt(firstNum);
    }
}
