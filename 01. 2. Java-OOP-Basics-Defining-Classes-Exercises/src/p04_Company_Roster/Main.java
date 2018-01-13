package p04_Company_Roster;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Employee>> employeesByDepartment = new HashMap<>();

        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] inputLine = reader.readLine().split("\\s+");

            String name = inputLine[0];
            double salary = Double.parseDouble(inputLine[1]);
            String position = inputLine[2];
            String department = inputLine[3];

            Employee employee = null;
            switch(inputLine.length){
                case 4:
                    employee = new Employee(name, salary, position, department);
                    break;
                case 5:
                    if(inputLine[4].contains("@")){
                        employee =  new Employee(name, salary, position, department, inputLine[4]);
                    }else{
                        employee =  new Employee(name, salary, position, department, Integer.parseInt(inputLine[4]));
                    }
                    break;
                case 6:
                    employee = new Employee(name, salary, position, department, inputLine[4], Integer.parseInt(inputLine[5]));
                    break;
            }

            String departmnet = employee.getDepartment();
            if(!employeesByDepartment.containsKey(employee.getDepartment())){
                employeesByDepartment.put(departmnet, new ArrayList<>());
            }

            employeesByDepartment.get(departmnet).add(employee);

        }

        employeesByDepartment.entrySet().stream()
                .sorted((d1, d2) -> Double.compare(
                        d2.getValue().stream().mapToDouble(employee -> employee.getSalary()).average().getAsDouble(),
                        d1.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble()))
                .limit(1)
                .forEach(d -> {
                    StringBuilder sb = new StringBuilder(String.format("Highest Average Salary: %s%n", d.getKey()));
                    d.getValue().stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                            .forEach(e -> sb.append(e).append(System.lineSeparator()));

                    System.out.println(sb.toString());
                });
    }
}
