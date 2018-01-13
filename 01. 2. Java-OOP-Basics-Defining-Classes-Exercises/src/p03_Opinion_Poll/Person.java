package p03_Opinion_Poll;

public class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person(){
        this.name = "No name";
        this.age = 1;
    }

    public Person(int age){
        this.name = "No name";
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return this.name + " - " + this.age;
    }

    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.getName());
    }
}
