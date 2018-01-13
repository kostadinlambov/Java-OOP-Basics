package p09_Google;

class Car {
    private String carModel;
    private int carSpeed;

    Car(String carModel, int carSpeed) {
        this.carModel = carModel;
        this.carSpeed = carSpeed;
    }

    @Override
    public String toString() {
        return String.format(carModel + " " + carSpeed);
    }
}
