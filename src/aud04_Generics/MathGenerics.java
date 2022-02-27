package aud04_Generics;

import java.util.DoubleSummaryStatistics;
import java.util.List;

public class MathGenerics {

    public <T extends Number> String getCalculations(List<T> numbers){
        DoubleSummaryStatistics dss=new DoubleSummaryStatistics();
        numbers.forEach(n -> dss.accept(n.doubleValue()));

        DoubleSummaryStatistics dss2=numbers.stream().mapToDouble(n -> n.doubleValue()).summaryStatistics();

        return String.format("Average: %.2f , Count: %d", dss.getAverage(),dss.getCount());
    }
}
