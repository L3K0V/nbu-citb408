package hw2.t1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class SolutionTest {

    @Test
    public void sample0() {
        final var ivan = new Manager("Ivan");
        ivan.setHiringDate(LocalDate.of(2018,3,1));

        final var date = LocalDate.of(2021,3,1);

        Assertions.assertEquals("2018-03-01",ivan.getHiringDate().toString());
        Assertions.assertEquals(3, ivan.numberOfYearsInCompanyTill(date));
    }

    @Test
    public void sample1() {
        final var ivan = new Manager("Ivan");
        ivan.setHiringDate(LocalDate.of(2021,4,1));

        final var date = LocalDate.of(2021,4,1);

        Assertions.assertEquals("2021-04-01",ivan.getHiringDate().toString());
        Assertions.assertEquals(0, ivan.numberOfYearsInCompanyTill(date));
    }

    @Test
    public void sample2() {
        final var ivan = new Manager("Ivan");
        ivan.setHiringDate(LocalDate.of(2021,3,1));

        final var date = LocalDate.of(2021,3,1);

        Assertions.assertEquals("2021-03-01",ivan.getHiringDate().toString());
        Assertions.assertEquals(0, ivan.numberOfYearsInCompanyTill(date));
    }

    @Test
    public void sample3() {
        final var ivan = new Manager("Ivan");
        ivan.setHiringDate(LocalDate.of(2018,1,1));

        final var date = LocalDate.of(2022,3,1);

        Assertions.assertEquals("2018-01-01",ivan.getHiringDate().toString());
        Assertions.assertEquals(4, ivan.numberOfYearsInCompanyTill(date));
    }

    @Test
    public void sample4() {
        final var ivan = new Manager("Ivan");
        ivan.setHiringDate(LocalDate.of(2018,12,1));

        final var date = LocalDate.of(2021,3,1);

        Assertions.assertEquals("2018-12-01",ivan.getHiringDate().toString());
        Assertions.assertEquals(2, ivan.numberOfYearsInCompanyTill(date));
    }

    @Test
    public void dateInFuture() {
        final var ivan = new Manager("Ivan");
        ivan.setHiringDate(LocalDate.of(2023,12,1));

        final var date = LocalDate.of(2023,3,1);

        Assertions.assertEquals("2020-01-01",ivan.getHiringDate().toString());
        Assertions.assertEquals(3, ivan.numberOfYearsInCompanyTill(date));
    }
}
