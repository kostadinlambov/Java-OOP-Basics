package p06_Raw_Data;


import java.util.List;

class Car {
    String model;
    Engine engine;
    Cargo cargo;
    List<Tire> tires;

    Car(String model, Engine engine, Cargo cargo, List<Tire> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    Engine getEngine() {
        return this.engine;
    }

    Cargo getCargo() {
        return this.cargo;
    }

    List<Tire> getTires() {
        return this.tires;
    }
}
