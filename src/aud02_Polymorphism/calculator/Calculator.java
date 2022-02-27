package aud02_Polymorphism.calculator;

public class Calculator {
    public double getResult() {
        return result;
    }

    private double result;
    private Operation operation;

    public Calculator() {
        this.result = 0.0;
    }

    public String execute(char operator, double enteredValue) throws UnknownOperatorException {
        if (operator == '+') operation = new Addition();
        else if (operator == '-') operation = new Subtraction();
        else if (operator == '*') operation = new Multiplication();
        else if (operator == '/') operation = new Division();
        else throw new UnknownOperatorException(operator);

        result = operation.doOperation(result, enteredValue);
        return String.format("result %c %.2f = %.2f",operator,enteredValue,result);

    }

    @Override
    public String toString() {
        return String.format("Updated result = %.2f",result);
    }



}
