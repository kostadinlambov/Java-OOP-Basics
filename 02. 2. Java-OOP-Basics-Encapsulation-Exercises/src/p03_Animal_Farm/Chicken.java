package p03_Animal_Farm;

class Chicken {

    private String name;
    private int age;

    Chicken(String name, int age) {
        setName(name);
        setAge(age);
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    private void setAge(int age) {
        if (age < 0 || age > 15) {
            throw new IllegalArgumentException("Age should be between 0 and 15.");
        }
        this.age = age;
    }

    String getProductPerDay() {
        return calculateProductPerDay(this.age);
    }

    private String calculateProductPerDay(int age) {
        if (age < 6) {
            return "2";
        } else if (age <= 12) {
            return "1";
        } else {
            return "0.75";
        }
    }

    @Override
    public String toString() {
        return String.format("Chicken %s (age %d) can produce %s eggs per day.",
                this.name, this.age, getProductPerDay());
    }
}
