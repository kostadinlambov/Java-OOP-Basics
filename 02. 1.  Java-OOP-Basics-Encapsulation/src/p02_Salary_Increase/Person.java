package p02_Salary_Increase;

class Person {

    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    Person(String s, String s1, int i, double salary) {
        this.firstName = s;
        this.lastName = s1;
        this.age = i;
        this.salary = salary;
    }

    void increaseSalary(int bonus) {
        if(this.age > 30){
            this.salary += this.salary * bonus / 100;
        }else{
            this.salary += this.salary * bonus / 200;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %s leva", this.firstName,
                this.lastName, this.salary);
    }
}
