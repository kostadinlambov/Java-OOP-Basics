public class Person {

    private static final String USER_NAME = "Pesho";
    private String name;
    private int age;


    // Constructor
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //Methods
    public void printName(){
        System.out.println(this.name);
    }

    //Overridden methods
    @Override
    public  String toString(){
        return "Pesho";
    }

}
