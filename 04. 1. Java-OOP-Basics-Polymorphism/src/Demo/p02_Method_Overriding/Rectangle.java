package Demo.p02_Method_Overriding;

public class Rectangle {
    private Double sideA;
    private Double sideB;

    public Rectangle(Double sideA, Double sideB) {
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public Rectangle(Double sideA) {
        this.sideA = sideA;
    }

    protected Double getSideA(){
        return this.sideA;
    }


    public Double calculateArea(){
        return this.sideA * this.sideB;
    }
}
