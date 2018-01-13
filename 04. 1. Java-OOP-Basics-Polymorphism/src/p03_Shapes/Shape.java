package p03_Shapes;

public abstract class Shape {

    private double perimeter;
    private double area;

    public Shape() {
    }

    double getPerimeter() {
        return this.perimeter;
    }

    private void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    double getArea() {
        return this.area;
    }

    private void setArea(double area) {
        this.area = area;
    }

    protected abstract Double calculatePerimeter();

    protected abstract Double calculateArea();
}
