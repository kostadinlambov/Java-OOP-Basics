package Demo.p03_Shapes;

public class Circle extends Shape {
    private double radius;

    public Circle(Double radius){
        this.radius = radius;
    }

    @Override
    public void calculatePerimeter() {
        setPerimeter(this.radius * Math.PI * 2);
    }

    @Override
    public void calculateArea() {
        setArea(this.radius * this.radius * Math.PI);
    }
}
