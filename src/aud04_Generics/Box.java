package aud04_Generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Box<T> {
    private List<T> elements;
    public static Random RANDOM=new Random();
    public Box(){
        this.elements=new ArrayList<>();
    }
    public void addElement(T element){

        elements.add(element);
    }

    public boolean isEmpty(){
        return  elements.isEmpty();
    }

    public T drawElement(){
        if(isEmpty())
            return null;
        else {

            /*T obj= elements.get(RANDOM.nextInt(elements.size()));
            this.elements.remove(obj);
            return obj;*/
            return elements.remove(RANDOM.nextInt(elements.size()));
        }
    }
}
