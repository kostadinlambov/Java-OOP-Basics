package p01_Sort_Persons_by_Name_and_Age;

class Person {
    private String firstName;
    private String lastName;
    private int age;

    Person(String s, String s1, int i) {
        this.firstName = s;
        this.lastName = s1;
        this.age = i;
    }

    int getAge() {
        return this.age;
    }

    String getFirstName() {
        return this.firstName;
    }

    @Override
    public String toString() {
        return String.format("%s %s is %d years old.", this.getFirstName(),
                this.lastName, this.getAge());
    }
}
