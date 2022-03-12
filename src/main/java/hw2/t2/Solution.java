package hw2.t2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

class Studio {
    private final long id;
    private BigDecimal pricePerHour;
    private int maxWorkingHours;
    private int workedHours;
    private BigDecimal minPricePerHour;
    private BigDecimal currencyEuro;

    Studio(long id, int maxWorkingHours) {
        this(id);
        this.maxWorkingHours = maxWorkingHours;
    }

    Studio(long id) {
        this.id = id;
        this.pricePerHour = BigDecimal.ONE;
        this.minPricePerHour = BigDecimal.ONE;
        this.currencyEuro = BigDecimal.ONE;
    }

    public void setMinPricePerHour(double minPricePerHour) {
        this.minPricePerHour = BigDecimal.valueOf(Math.max(0, minPricePerHour));
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = BigDecimal.valueOf(Math.max(minPricePerHour.longValue(), pricePerHour));
    }

    public void setMaxWorkingHours(int maxWorkingHours) {
        this.maxWorkingHours = Math.min(24, maxWorkingHours);
    }

    public void setWorkedHours(int workedHours) {
        this.workedHours = Math.min(workedHours, maxWorkingHours);
    }

    public void setCurrencyEuro(double currencyEuro) {
        this.currencyEuro = BigDecimal.valueOf(currencyEuro);
    }

    public long getId() {
        return id;
    }

    public BigDecimal getPricePerHour() {
        return pricePerHour;
    }

    public int getMaxWorkingHours() {
        return maxWorkingHours;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public BigDecimal getMinPricePerHour() {
        return minPricePerHour;
    }

    public BigDecimal getCurrencyEuro() {
        return currencyEuro;
    }

    public BigDecimal turnOverLv() {
        return pricePerHour.multiply(BigDecimal.valueOf(workedHours));
    }

    public BigDecimal turnOverEuro() {
        return turnOverLv().multiply(currencyEuro);
    }

    public Studio studioWithLargerPrice(Studio two) {
        if (this.pricePerHour.compareTo(two.pricePerHour) > 0) {
            return this;
        } else {
            return two;
        }
    }

    public boolean isFirstStudioWithGreaterTurnover(Studio two) {
        return this.turnOverLv().compareTo(two.turnOverLv()) > 0;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        long id = Long.parseLong(bufferedReader.readLine().trim());

        int maxWorkingHours = Integer.parseInt(bufferedReader.readLine().trim());

        double minPricePerHour = Double.parseDouble(bufferedReader.readLine().trim());

        double currencyEuro = Double.parseDouble(bufferedReader.readLine().trim());

        double pricePerHour = Double.parseDouble(bufferedReader.readLine().trim());

        int workedHours = Integer.parseInt(bufferedReader.readLine().trim());

        // Create an object of type Studio using the constructor with two parameters. Pass id and maxWorkingHours as arguments.
        final Studio one = new Studio(id,maxWorkingHours);

        // Use set method to set the minimum price per hour. User variable minPricePerHour to pass it as a method argument.
        one.setMinPricePerHour(minPricePerHour);

        // Use set method to set the Euro currency. Pass currencyEuro to the set method.
        one.setCurrencyEuro(currencyEuro);

        // Use set method to set the price for renting the studio for one hour. Pass pricePerHour to the set method.
        one.setPricePerHour(pricePerHour);

        // Use set method to set the number of hours for the day that the studio was rented.
        one.setWorkedHours(workedHours);

        // Print on the console the turnover in lv., calculated by using workedHours and pricePerHour.
        System.out.println(one.turnOverLv());

        // Print on the console the turnover in Euro., calculated by using workedHours and pricePerHour.
        System.out.println(one.turnOverEuro());

        long id2 = Long.parseLong(bufferedReader.readLine().trim());

        int maxWorkingHours2 = Integer.parseInt(bufferedReader.readLine().trim());

        double pricePerHour2 = Double.parseDouble(bufferedReader.readLine().trim());

        int workedHours2 = Integer.parseInt(bufferedReader.readLine().trim());

        // Create the second object of type Studio, using the constructor with 2 parameters. Use id2 and maxWorkingHours2 to pass them as arguments
        final Studio two = new Studio(id2, maxWorkingHours2);

        // Use set method to set the price for renting the second studio for one hour. Pass pricePerHour2 to the set method.
        two.setPricePerHour(pricePerHour2);

        // Use set method to set the number of hours for the day that the second studio was rented (workedHours2)
        two.setWorkedHours(workedHours2);

        // Print on the console the result of getting the id of the studio that is returned as a result of the studioWithLargerPrice() method. The first studio object is used to call the method.
        System.out.println(one.studioWithLargerPrice(two).getId());

        // Print on the console the result of calling the method isFirstStudioWithGreaterTurnover() method. The first studio object is used to call the method.
        System.out.println(one.isFirstStudioWithGreaterTurnover(two));

        bufferedReader.close();
    }
}
