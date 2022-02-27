package aud05_Randomization.BenfordLaw;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LineNumbersReader implements NumbersReader{
    public LineNumbersReader() {
    }

    @Override
    public List<Integer> read(InputStream inputStream) {
        BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));

        List<Integer> numbers=new ArrayList<>();
        IntStream.range(0,9).forEach(i -> numbers.add(i,0));
        br.lines().forEach(l -> {
           int first= Integer.parseInt(l.substring(0,1));
           numbers.set(first-1,numbers.get(first-1)+1);
        });

        return numbers;
    }

    public static void main(String[] args) throws IOException {
        LineNumbersReader lineNumbersReader=new LineNumbersReader();

        List<Integer> stats=lineNumbersReader.read(new FileInputStream("C:\\Users\\Latinka\\Advanced Programming\\src\\aud05\\BenfordLaw\\numbers.txt"));
        IntStream.range(0,stats.size()).forEach(i -> System.out.println(String.format("%d - %d",i+1,stats.get(i))));
    }


}
