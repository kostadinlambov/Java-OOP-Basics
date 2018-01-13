package p03_Mankind;

public class Worker extends Human{

    private double weekSalary;
    private double workingHours;

    public Worker(String firstName, String lastName, double weekSalary, double workingHours) {
        super(firstName, lastName);
        setWeekSalary(weekSalary);
        setWorkingHours(workingHours);
    }

    private void setWeekSalary(double weekSalary) {
        if(weekSalary < 10.0){
            throw new IllegalArgumentException("Expected value mismatch!Argument: weekSalary");
        }
        this.weekSalary = weekSalary;
    }

    private void setWorkingHours(double workingHours) {
        if(workingHours < 1 || workingHours > 12){
            throw new IllegalArgumentException("Expected value mismatch!Argument: workHoursPerDay");
        }
        this.workingHours = workingHours;
    }

    protected double salaryPerHour(){
        return this.weekSalary /(workingHours * 7);
    }

    @Override
    protected void setLastName(String lastName){
        if(lastName.length() < 4){
            throw new IllegalArgumentException("Expected length more than 3 symbols!Argument: lastName");
        }
        super.setLastName(lastName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Week Salary: %.2f", this.weekSalary)).append(System.lineSeparator());
        sb.append(String.format("Hours per day: %.2f", this.workingHours)).append(System.lineSeparator());
        sb.append(String.format("Salary per hour: %.2f", this.salaryPerHour()));
        return super.toString() + sb.toString();
    }
}
