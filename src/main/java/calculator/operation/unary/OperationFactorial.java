package calculator.operation.unary;

public class OperationFactorial extends UnaryOperation {

    @Override
    public double getResult() {
        double result = 1;
        for (int i = 1; i < firstNum+1; i++)
            result *= i;
        return result;
    }
}
