package aud03_IO.WordCountExercise;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

class LineRepresentation{ //pomoshna klasa za MAP/REDUCE
    int lines=0;
    int words=0;
    int characters=0;

    public LineRepresentation(int lines, int words, int characters) {
        this.lines = lines;
        this.words = words;
        this.characters = characters;
    }

    public LineRepresentation addTwoObjects(LineRepresentation l){
        return new LineRepresentation(this.lines+l.lines,this.words+l.words,this.characters+l.characters);
    }

    @Override
    public String toString() {
        return String.format("There are %d lines, %d words and %d characters\n",lines,words,characters);
    }
}

class Counter{

    public static void calculateWithScanner(InputStream inputStream){
        int lines = 0, words=0, characters=0;
        Scanner scanner=new Scanner(inputStream);
        while(scanner.hasNextLine()){
            String line=scanner.nextLine();
            lines++;
            int wordsInLine=line.split("\\s+").length;
            words+=wordsInLine;
            int charsInLine=line.trim().length();
            characters+=charsInLine;
        }
        scanner.close();
        System.out.printf("There are %d lines, %d words and %d characters\n",lines,words,characters);

    }

    public static void calculateWithBufferedReader(InputStream inputStream) throws IOException {
        int lines = 0, words=0, characters=0;
        BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line=br.readLine())!=null){
            lines++;
            int wordsInLine=line.split("\\s+").length;
            words+=wordsInLine;
            int charsInLine=line.trim().length();
            characters+=charsInLine;
        }
        br.close();
        System.out.printf("There are %d lines, %d words and %d characters\n",lines,words,characters);

    }

    public static void calculateWithBufferedReaderAndStreams(InputStream inputStream){ //vazhno
        AtomicInteger lines1= new AtomicInteger();
        AtomicInteger words1= new AtomicInteger();
        AtomicInteger chars1= new AtomicInteger();
        BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
        br.lines().forEach(l -> {
            lines1.getAndIncrement();
            words1.addAndGet(l.split("\\s+").length);
            chars1.addAndGet(l.trim().length());
        });
        System.out.printf("There are %d lines, %d words and %d characters\n",lines1.get(),words1.get(),chars1.get());
    }
    public static void calculateWithBufferedReaderAndMapReduce(InputStream inputStream){ //vazhno
        BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
        LineRepresentation lr3= br.lines().map(
                l -> new LineRepresentation(1,l.split("\\s+").length,l.trim().length())
                )
                .reduce((lineRepresentation, lineRepresentation2) -> lineRepresentation.addTwoObjects(lineRepresentation2))
                .orElseThrow();
        System.out.println(lr3);
    }
}

public class WordCountTester {
    public static void main(String[] args) throws IOException {
        File file=new File("C:\\Users\\Latinka\\Advanced Programming\\src\\text.txt");
        Counter.calculateWithScanner(new FileInputStream(file));
        Counter.calculateWithBufferedReader(new FileInputStream(file));
        Counter.calculateWithBufferedReaderAndStreams(new FileInputStream(file));
        Counter.calculateWithBufferedReaderAndMapReduce(new FileInputStream(file));

    }
}
