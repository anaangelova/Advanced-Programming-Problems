package Exercises_For_First_Partial_Exam.MojDDV2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.*;
import java.util.stream.Collectors;



public class MojDDV {

    private List<Receipt> allReceipts;

    public MojDDV() {
        this.allReceipts = new ArrayList<>();
    }

    public void readRecords(InputStream in) {
        //gi chita fiskalnite smetki - edna smetka e edna linija
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        this.allReceipts= br.lines().map(l -> {
            try{
                return Receipt.createReceipt(l);
            }catch (AmountNotAllowedException e){
                System.out.println(e.getMessage());
                return null;
            } //celta e da ne dozvolime da se kreira nevaliden objekt
        }).filter(Objects::nonNull).collect(Collectors.toList());



    }

    public void printTaxReturns(PrintStream out) {
        this.allReceipts.forEach(r -> out.println(r));
    }

    public void printStatistics(PrintStream out) {
        DoubleSummaryStatistics dss= allReceipts.stream().mapToDouble(r -> r.getTotalTaxReturn()).summaryStatistics();
        out.println(String.format("min: %.3f\nmax: %.3f\nsum: %.3f\ncount: %d\navg: %.3f\n",dss.getMin(),dss.getMax(),dss.getSum(),dss.getCount(),dss.getAverage()));
    }
}
