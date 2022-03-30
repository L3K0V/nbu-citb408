package hw5.t1;

import java.io.*;
import java.math.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

enum ContractType {
    PERMANENT(0), PART_TIME(0), TRAINEE(0);

    private double minSalary;

    ContractType(double value){
        this.minSalary = value;
    }

    public void setMinSalary(double minSalary) {
        this.minSalary = minSalary;
    }

    public double getMinSalary() {
        return minSalary;
    }
}

class Employee {

    String name;
    ContractType type;
    int hours;
    BigDecimal additionalSalary;

    public Employee(String name, int hours, BigDecimal additionalSalary, ContractType type) {
        this.name = name;
        this.type = type;
        this.hours = hours;
        this.additionalSalary = additionalSalary;
    }

    BigDecimal salary() {
        return BigDecimal.valueOf(type.getMinSalary()).add(additionalSalary).multiply(BigDecimal.valueOf(hours)).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    void increaseSalary(BigDecimal percentage) {
        if (percentage.compareTo(BigDecimal.ZERO) <= 0) {
            return;
        }

        additionalSalary = additionalSalary.add(percentage(additionalSalary, percentage));
    }

    private static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

    private static BigDecimal percentage(BigDecimal base, BigDecimal pct){
        return base.multiply(pct).divide(ONE_HUNDRED, RoundingMode.HALF_UP);
    }
}

class Company {

    String name;
    int maxEmployees;
    Set<Employee> employees = new HashSet<>();

    public Company(String companyName, int maxNumberOfEmployees) {
        this.name = companyName;
        this.maxEmployees = maxNumberOfEmployees;
    }

    void hireEmployee(Employee employee) {
        if (employees.size() >= maxEmployees) {
            return;
        }

        employees.add(employee);
    }

    void fireEmployee(Employee employee) {
        employees.remove(employee);
    }

    BigDecimal averageSalary() {
        if (employees.isEmpty()) {
            return BigDecimal.ZERO;
        }

        final BigDecimal sum = employees.stream().map(Employee::salary).reduce(BigDecimal.ZERO, BigDecimal::add);
        return sum.divide(new BigDecimal(employees.size()), RoundingMode.HALF_UP).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    BigDecimal averageSalaryByType(ContractType type) {
        final List<Employee> employeesByType = employees.stream().filter(e -> type.equals(e.type)).collect(toList());

        if (employeesByType.isEmpty()) {
            return BigDecimal.ZERO;
        }

        final BigDecimal sum = employeesByType.stream().map(Employee::salary).reduce(BigDecimal.ZERO, BigDecimal::add);
        return sum.divide(new BigDecimal((long) employeesByType.size()), RoundingMode.HALF_UP).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    void increaseSalaries(BigDecimal percentage) {
        employees.forEach(e -> e.increaseSalary(percentage));
    }
}


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String companyName = bufferedReader.readLine();

        int maxNumberOfEmployees = Integer.parseInt(bufferedReader.readLine().trim());

        List<Double> minSalaryList = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Double::parseDouble)
                .collect(toList());

        List<String> namesList = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        List<Integer> workedHoursList = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<String> contractTypeList = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .collect(toList());

        List<Double> additionalSalaryList = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Double::parseDouble)
                .collect(toList());

        String contractType = bufferedReader.readLine();

        double increasePercentage = Double.parseDouble(bufferedReader.readLine().trim());

        // Set the min salary per hour, that depends on the contract type. Use the values in the minSalaryList: the first value is for PERMANENT, the second is for PART_TIME, the third is for TRAINEE
        IntStream.range(0, Math.min(ContractType.values().length, minSalaryList.size()))
                .boxed()
                .forEach(index -> ContractType.values()[index].setMinSalary(minSalaryList.get(index)));

        // Create company by using companyName and maxNumberOfEmployees
        Company company = new Company(companyName, maxNumberOfEmployees);

        // Create 6 employees by using the values in the namesList, workedHoursList, contractTypeList, and additionalSalaryList. Example for creating the first employee:  Employee employee1 = new Employee(namesList.get(0), workedHoursList.get(0), BigDecimal.valueOf(additionalSalaryList.get(0)), ContractType.valueOf(contractTypeList.get(0)));
        Employee employee1 = new Employee(namesList.get(0), workedHoursList.get(0), BigDecimal.valueOf(additionalSalaryList.get(0)), ContractType.valueOf(contractTypeList.get(0)));
        Employee employee2 = new Employee(namesList.get(1), workedHoursList.get(1), BigDecimal.valueOf(additionalSalaryList.get(1)), ContractType.valueOf(contractTypeList.get(1)));
        Employee employee3 = new Employee(namesList.get(2), workedHoursList.get(2), BigDecimal.valueOf(additionalSalaryList.get(2)), ContractType.valueOf(contractTypeList.get(2)));
        Employee employee4 = new Employee(namesList.get(3), workedHoursList.get(3), BigDecimal.valueOf(additionalSalaryList.get(3)), ContractType.valueOf(contractTypeList.get(3)));
        Employee employee5 = new Employee(namesList.get(4), workedHoursList.get(4), BigDecimal.valueOf(additionalSalaryList.get(4)), ContractType.valueOf(contractTypeList.get(4)));
        Employee employee6 = new Employee(namesList.get(5), workedHoursList.get(5), BigDecimal.valueOf(additionalSalaryList.get(5)), ContractType.valueOf(contractTypeList.get(5)));

        // Hire all the 6 employees to work at the company
        company.hireEmployee(employee1);
        company.hireEmployee(employee2);
        company.hireEmployee(employee3);
        company.hireEmployee(employee4);
        company.hireEmployee(employee5);
        company.hireEmployee(employee6);

        // Print the result of calling the method averageSalary()
        if (company.averageSalary().equals(BigDecimal.ZERO)) {
            System.out.println(0);
        } else {
            System.out.println(company.averageSalary());
        }

        // Increase the additional salary per hour, by calling the method increaseSalaries(). Use increasePercentage as an argument: company.increaseSalaries(BigDecimal.valueOf(increasePercentage));
        company.increaseSalaries(BigDecimal.valueOf(increasePercentage));

        // Print the result of calling the method averageSalary(), after increasing the additional salary per hour of all employees.
        System.out.println(company.averageSalary());

        // Print the result of calling the method averageSalaryByType(). Use the string contractType with ContractType.valueOf() method to pass it as argument: System.out.println(company.averageSalaryByType(ContractType.valueOf(contractType)));
        System.out.println(company.averageSalaryByType(ContractType.valueOf(contractType)));

        bufferedReader.close();
    }
}
