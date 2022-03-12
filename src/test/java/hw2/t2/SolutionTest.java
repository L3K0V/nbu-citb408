package hw2.t2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    public void sample0() {
        final Studio one = new Studio(1);
        one.setMaxWorkingHours(24);
        one.setMinPricePerHour(100);
        one.setCurrencyEuro(0.51);
        one.setPricePerHour(120);
        one.setWorkedHours(15);

        final Studio two = new Studio(2);
        one.setMaxWorkingHours(20);
        one.setPricePerHour(120);
        one.setWorkedHours(15);

        Assertions.assertEquals(1800.0, one.turnOverLv().doubleValue());
        Assertions.assertEquals(918.000, one.turnOverEuro().doubleValue());
        Assertions.assertEquals(two, one.studioWithLargerPrice(two));
        Assertions.assertEquals(2, one.studioWithLargerPrice(two).getId());
        Assertions.assertTrue(one.isFirstStudioWithGreaterTurnover(two));
    }

    @Test
    public void sample1() {
        final Studio one = new Studio(1);
        one.setMaxWorkingHours(12);
        one.setMinPricePerHour(100);
        one.setCurrencyEuro(0.51);
        one.setPricePerHour(90);
        one.setWorkedHours(15);

        final Studio two = new Studio(2);
        one.setMaxWorkingHours(20);
        one.setPricePerHour(100);
        one.setWorkedHours(6);

        Assertions.assertEquals(1200.0, one.turnOverLv());
        Assertions.assertEquals(612.000, one.turnOverEuro());
        Assertions.assertEquals(two, one.studioWithLargerPrice(two));
        Assertions.assertEquals(2, one.studioWithLargerPrice(two).getId());
        Assertions.assertTrue(one.isFirstStudioWithGreaterTurnover(two));
    }

    @Test
    public void sample2() {
        final Studio one = new Studio(1);
        one.setMaxWorkingHours(12);
        one.setMinPricePerHour(100);
        one.setCurrencyEuro(0.51);
        one.setPricePerHour(100);
        one.setWorkedHours(15);

        final Studio two = new Studio(2);
        one.setMaxWorkingHours(18);
        one.setPricePerHour(150);
        one.setWorkedHours(3);

        Assertions.assertEquals(1200.0, one.turnOverLv());
        Assertions.assertEquals(612.000, one.turnOverEuro());
        Assertions.assertEquals(two, one.studioWithLargerPrice(two));
        Assertions.assertEquals(2, one.studioWithLargerPrice(two).getId());
        Assertions.assertTrue(one.isFirstStudioWithGreaterTurnover(two));
    }
}
