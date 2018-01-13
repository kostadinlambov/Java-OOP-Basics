package p09_Google;

class Company {
    private String companyName;
    private String department;
    private double salary;

    Company(String companyName, String department, double salary) {
        this.companyName = companyName;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f", companyName, department, salary);
    }
}
