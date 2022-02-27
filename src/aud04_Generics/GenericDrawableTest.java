package aud04_Generics;

public class GenericDrawableTest {

    public static void main(String[] args) {
        BoxDrawable<Drawable> elements=new BoxDrawable<>();
        for(int i=0;i<10;i++){
            elements.addElement(new DrawableInteger());

        }
        for(int i=0;i<5;i++){
            elements.drawElement();
        }
    }
}
