package hw5.t1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.IntStream;

public class SolutionTest {

    @Test
    public void sample0() {
        String companyName = "TechComp";

        int maxNumberOfEmployees = 5;

        List<Double> minSalaryList = List.of(20.0,15.0,10.0);
        List<String> namesList = List.of("Maria", "Anna", "Pavel", "Monika", "Toni", "Moni");
        List<Integer> workedHoursList = List.of(60,100,150,80,150,80);
        List<String> contractTypeList = List.of("PERMANENT", "PERMANENT", "PART_TIME", "PERMANENT", "PERMANENT", "PART_TIME");
        List<Double> additionalSalaryList = List.of(20.0, 40.0, 20.0, 20.0, 20.0, 40.0);

        String contractType = "PERMANENT";

        double increasePercentage = 5.0;

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

        List<Employee> employees = List.of(employee1, employee2, employee3, employee4, employee5, employee6);

        // Hire all the 6 employees to work at the company
        employees.forEach(company::hireEmployee);

        // Print the result of calling the method averageSalary()
        Assertions.assertEquals(4570.00, company.averageSalary().doubleValue());

        // Increase the additional salary per hour, by calling the method increaseSalaries(). Use increasePercentage as an argument: company.increaseSalaries(BigDecimal.valueOf(increasePercentage));
        company.increaseSalaries(BigDecimal.valueOf(increasePercentage));

        // Print the result of calling the method averageSalary(), after increasing the additional salary per hour of all employees.
        Assertions.assertEquals(4698.00, company.averageSalary().doubleValue());

        // Print the result of calling the method averageSalaryByType(). Use the string contractType with ContractType.valueOf() method to pass it as argument: System.out.println(company.averageSalaryByType(ContractType.valueOf(contractType)));
        Assertions.assertEquals(4522.50, company.averageSalaryByType(ContractType.valueOf(contractType)).doubleValue());
    }

    @Test
    public void sample1() {
        String companyName = "TechComp";

        int maxNumberOfEmployees = 0;

        List<Double> minSalaryList = List.of(20.0,15.0,10.0);
        List<String> namesList = List.of("Maria", "Anna", "Pavel", "Monika", "Toni", "Moni");
        List<Integer> workedHoursList = List.of(60,100,150,80,150,80);
        List<String> contractTypeList = List.of("PERMANENT", "PERMANENT", "PART_TIME", "PERMANENT", "PERMANENT", "PART_TIME");
        List<Double> additionalSalaryList = List.of(20.0, 40.0, 20.0, 20.0, 20.0, 40.0);

        String contractType = "PERMANENT";

        double increasePercentage = 5.0;

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

        List<Employee> employees = List.of(employee1, employee2, employee3, employee4, employee5, employee6);

        // Hire all the 6 employees to work at the company
        employees.forEach(company::hireEmployee);

        // Print the result of calling the method averageSalary()
        Assertions.assertEquals(0, company.averageSalary().doubleValue());

        // Increase the additional salary per hour, by calling the method increaseSalaries(). Use increasePercentage as an argument: company.increaseSalaries(BigDecimal.valueOf(increasePercentage));
        company.increaseSalaries(BigDecimal.valueOf(increasePercentage));

        // Print the result of calling the method averageSalary(), after increasing the additional salary per hour of all employees.
        Assertions.assertEquals(0, company.averageSalary().doubleValue());

        // Print the result of calling the method averageSalaryByType(). Use the string contractType with ContractType.valueOf() method to pass it as argument: System.out.println(company.averageSalaryByType(ContractType.valueOf(contractType)));
        Assertions.assertEquals(0, company.averageSalaryByType(ContractType.valueOf(contractType)).doubleValue());
    }
}
