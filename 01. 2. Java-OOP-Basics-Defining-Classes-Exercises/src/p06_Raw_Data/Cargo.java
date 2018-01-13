package p06_Raw_Data;

class Cargo {
    private int cargoWeight;
    private String cargoType;

    Cargo(int cargoWeight, String cargoType) {
        this.cargoWeight = cargoWeight;
        this.cargoType = cargoType;
    }

    String getCargoType() {
        return cargoType;
    }
}
