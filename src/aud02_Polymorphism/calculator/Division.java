package aud02_Polymorphism.calculator;

public class Division implements Operation{
    @Override
    public double doOperation(double op1, double op2) {
        return op1/op2;
    }
}
