package Demo.p03_Shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    protected Shape(){
    }

    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    protected void setArea(Double area) {
        this.area = area;
    }

    public Double getPerimeter() {
        return this.perimeter;
    }

    public Double getArea() {
        return this.area;
    }

    public abstract void calculatePerimeter();

    public abstract void calculateArea();
}
