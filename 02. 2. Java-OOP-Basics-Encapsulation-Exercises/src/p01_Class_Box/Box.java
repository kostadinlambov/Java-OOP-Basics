package p01_Class_Box;

class Box {
    private double length;
    private double width;
    private double height;

    Box(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    double calculateSurfaceArea() {
        return 2 * (this.length * this.width) + 2 * (this.length * this.height) + 2 * (this.width * this.height);
    }

    double calculateVolume(){
        return this.length* this.width * this.height;
    }

    double calculateLateralSurfaceArea() {
        return 2*(this.length * this.height) + 2*(this.width * this.height);
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f%nLateral Surface Area - %.2f%nVolume - %.2f%n",
                calculateSurfaceArea(),calculateLateralSurfaceArea() ,calculateVolume());
    }
}
