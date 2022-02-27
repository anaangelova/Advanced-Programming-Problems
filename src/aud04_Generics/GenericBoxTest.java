package aud04_Generics;

public class GenericBoxTest {

    public static void main(String[] args) {
            Box<Integer> box=new Box<>();
            for(int i=0;i<100;i++){
                box.addElement(i);
            }

            for(int i=0;i<102;i++){
                System.out.println(box.drawElement());
            }
    }
}
