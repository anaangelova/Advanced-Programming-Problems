package aud04_Generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BoxDrawable<T extends Drawable> {
    private List<T> elements;
    public static Random RANDOM=new Random();

    public BoxDrawable(){
        this.elements=new ArrayList<>();
    }
    public void addElement(T element){

        elements.add(element);
    }

    public boolean isEmpty(){
        return  elements.isEmpty();
    }

    public void drawElement(){
        if(isEmpty())
            return;
        else {
            T obj= elements.get(RANDOM.nextInt(elements.size()));
            this.elements.remove(obj);
            obj.draw();

        }
    }
}
