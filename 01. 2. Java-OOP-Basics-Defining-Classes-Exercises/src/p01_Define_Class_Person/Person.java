package p01_Define_Class_Person;

public class Person {

    private String name;
    private int age;

    Person(String s){
    }

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setAge(int name){
        this.age = age;
    }

    public int getAge(){
        return this.age;
    }

}
