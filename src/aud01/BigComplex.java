package aud01;

import java.math.BigDecimal;

public class BigComplex {
    private BigDecimal real;
    private BigDecimal imaginary;

    public BigComplex(BigDecimal real, BigDecimal imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public BigComplex add(BigComplex complex){
        BigDecimal real=this.real.add(complex.real);
        BigDecimal imaginary=this.imaginary.add(complex.imaginary);
        return new BigComplex(real,imaginary);


    }
}
