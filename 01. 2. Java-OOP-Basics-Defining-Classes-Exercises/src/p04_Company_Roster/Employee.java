package p04_Company_Roster;

class Employee {

    private static final String defaulth_EMAIL_VALUE = "n/a";
    private static final int defaulth_AGE_VALUE = -1;
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    Employee(String name, double salary, String position, String department) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = defaulth_EMAIL_VALUE;
        this.age = defaulth_AGE_VALUE;
    }

    Employee(String name, double salary, String position, String department, int age) {
        this(name, salary, position, department);
        this.age = age;
    }

    Employee(String name, double salary, String position, String department, String email) {
        this(name, salary, position, department);
        this.email = email;
    }

    Employee(String name, double salary, String position, String department, String email, int age) {
        this(name, salary, position, department);
        this.email = email;
        this.age = age;
    }

    double getSalary() {
        return this.salary;
    }

    String getDepartment() {
        return this.department;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
    }
}
