package Demo.p02_Method_Overriding;

import org.w3c.dom.css.Rect;

public class Main {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(5.0 , 3.0);
        Square square = new Square(4.0);

        Rectangle rectangle = new Square(8.5);

       if(rectangle instanceof Square){
           ((Square) rectangle).perimeter();
       }

        System.out.println(square.calculateArea());
    }
}
