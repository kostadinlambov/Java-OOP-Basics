package Demo.p02_Method_Overriding;

public class Square extends Rectangle {

    public Square(Double sideA) {
        super(sideA);
    }

    public Double perimeter(){
        return this.getSideA()*2;
    }


   @Override
    public Double calculateArea(){
        return super.getSideA()* super.getSideA();
   }
}
