package calculator.operation;

import calculator.operation.unary.*;
import calculator.operation.binary.*;

public class OperationFactory {
    public static Operation createOperation(String operate) {
        Operation oper = null;
        switch (operate) {
            case "+/-":
                oper = new OperationInvert();
                break;
            case "/":
                oper = new OperationDiv();
                break;
            case "*":
                oper = new OperationMul();
                break;
            case "-":
                oper = new OperationSub();
                break;
            case "+":
                oper = new OperationAdd();
                break;
            case "√":
                oper = new OperationSqrt();
                break;
            case "%":
                oper = new OperationMod();
                break;
            case "!":
                oper = new OperationFactorial();
                break;
            case "log":
                oper = new OperationLog();
                break;
            case "^":
                oper = new OperationExp();
                break;
            default:
                break;
        }
        return oper;
    }
}
