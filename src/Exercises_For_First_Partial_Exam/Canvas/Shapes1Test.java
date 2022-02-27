package Exercises_For_First_Partial_Exam.Canvas;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Square{
    private int side;

    public Square(int side){
        this.side=side;
    }
    public int getPerimeter(){
        return 4*side;
    }
}
class Canvas{
    private String canvasId;
    private List<Square> squares;

    public Canvas(String canvasId, List<Square> squares){
        this.canvasId=canvasId;
        this.squares=squares;
    }
    public Canvas(){
        this.squares=new ArrayList<>();
    }
    public static Canvas createCanvas(String line){
        List<String> parts= Arrays.stream(line.split("\\s+")).collect(Collectors.toList());
        String id=parts.get(0);
        List<Square> squares=parts.stream().skip(1).map(p -> new Square(Integer.parseInt(p))).collect(Collectors.toList());
        return new Canvas(id,squares);
    }

    public int getTotalPerimeter(){
        return squares.stream().mapToInt(s -> s.getPerimeter()).sum();
    }

    public String getCanvasId() {
        return canvasId;
    }

    public void setCanvasId(String canvasId) {
        this.canvasId = canvasId;
    }

    public List<Square> getSquares() {
        return squares;
    }

    public void setSquares(List<Square> squares) {
        this.squares = squares;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d",canvasId,squares.size(),getTotalPerimeter());
    }
}
class ShapesApplication{

    private List<Canvas> canvasList;
    public ShapesApplication(){
        this.canvasList=new ArrayList<>();
    }

    public int readCanvases(InputStream in) {
        BufferedReader br=new BufferedReader(new InputStreamReader(in));
        this.canvasList=br.lines().map(l -> Canvas.createCanvas(l)).collect(Collectors.toList());
        return this.canvasList.stream().mapToInt(c -> c.getSquares().size()).sum();
    }

    public void printLargestCanvasTo(PrintStream out) {
       Canvas largest= canvasList.stream().max(Comparator.comparing(Canvas::getTotalPerimeter)).orElse(new Canvas());
       out.println(largest);
    }
}

public class Shapes1Test {

    public static void main(String[] args) {
        ShapesApplication shapesApplication = new ShapesApplication();

        System.out.println("===READING SQUARES FROM INPUT STREAM===");
        System.out.println(shapesApplication.readCanvases(System.in));
        System.out.println("===PRINTING LARGEST CANVAS TO OUTPUT STREAM===");
        shapesApplication.printLargestCanvasTo(System.out);

    }
}