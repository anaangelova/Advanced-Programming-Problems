package aud02_Polymorphism.calculator;

public class UnknownOperatorException extends Exception{
    public UnknownOperatorException(char operator) {
        super(String.format("Unknown operator: %c",operator));
    }
}
