package exam1.t1;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Patient {

    private static BigDecimal tax = BigDecimal.ZERO;

    final String name;
    final LocalDate dateOfBirth;

    boolean isRetired;

    public Patient(String name, LocalDate dateOfBirth, boolean isRetired) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.isRetired = isRetired;
    }

    public int yearsOld() {
        return dateOfBirth.until(LocalDate.now()).getYears();
    }

    public BigDecimal userTax() {
        if (yearsOld() < 18) {
            return BigDecimal.ZERO;
        }

        if (isRetired) {
            return tax.divide(BigDecimal.valueOf(2));
        } else {
            return tax;
        }
    }

    public boolean isRetired() {
        return isRetired;
    }

    public void setRetired(boolean retired) {
        isRetired = retired;
    }

    public static void increaseTax(BigDecimal withValue) {
        tax = tax.add(withValue);
    }

    public static void decreaseTax(BigDecimal withValue) {
        if (withValue.compareTo(tax) > 0) {
            tax = BigDecimal.ZERO;
        }

        tax = tax.subtract(withValue);
    }
}
