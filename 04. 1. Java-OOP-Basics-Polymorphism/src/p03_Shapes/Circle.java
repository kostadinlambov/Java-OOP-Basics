package p03_Shapes;

public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super();
        this.setRadius(radius);
    }

    public final double getRadius() {
        return this.radius;
    }

    private void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    protected Double calculatePerimeter() {
        return 2* this.radius * Math.PI;
    }

    @Override
    protected Double calculateArea() {
        return this.radius * this.radius * Math.PI;
    }
}
