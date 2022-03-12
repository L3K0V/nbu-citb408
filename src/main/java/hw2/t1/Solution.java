package hw2.t1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

class Manager {

    private final String name;
    private LocalDate hiringDate;

    Manager(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public LocalDate getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(LocalDate hiringDate) {
        if (hiringDate.isAfter(LocalDate.now())) {
            this.hiringDate = LocalDate.parse("2020-01-01");
        } else {
            this.hiringDate = hiringDate;
        }
    }

    public int numberOfYearsInCompanyTill(LocalDate date) {
        return hiringDate.until(date).getYears();
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String name = bufferedReader.readLine();

        int hiringYear = Integer.parseInt(bufferedReader.readLine().trim());

        int hiringMonth = Integer.parseInt(bufferedReader.readLine().trim());

        int hiringDay = Integer.parseInt(bufferedReader.readLine().trim());

        int currentYear = Integer.parseInt(bufferedReader.readLine().trim());

        int currentMonth = Integer.parseInt(bufferedReader.readLine().trim());

        int currentDay = Integer.parseInt(bufferedReader.readLine().trim());

        // Create an object of type Manager. Use one parameter constructor with argument name: Manager(name)
        final Manager manager = new Manager(name);

        // Call the set method to set the hiring date of Ivan. Pass year, month, and day as parameters: setHiringDate(LocalDate.of(hiringYear, hiringMonth, hiringDay))
        manager.setHiringDate(LocalDate.of(hiringYear, hiringMonth, hiringDay));

        // Print on the console the result of getting the hiring date
        System.out.println(manager.getHiringDate());

        // Print on the console the result of calling numberOfYearsInCompanyTill() method. The method has to be called with a parameter of type LocalDate using currentYear, currentMonth, currentDay: numberOfYearsInCompanyTill(LocalDate.of(currentYear, currentMonth, currentDay))
        System.out.println(manager.numberOfYearsInCompanyTill(LocalDate.of(currentYear, currentMonth, currentDay)));

        bufferedReader.close();
    }
}

