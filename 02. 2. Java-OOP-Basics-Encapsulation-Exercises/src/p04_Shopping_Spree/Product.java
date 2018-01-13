package p04_Shopping_Spree;

class Product {
    private String name;
    private int cost;

    Product(String name, int cost) {
        setName(name);
        setCost(cost);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setCost(int cost) {
        if(cost < 0){
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.cost = cost;
    }

    int getCost() {
        return cost;
    }

    String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format(this.name);
    }
}
