package hw1.t2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    public void samples() {
        Assertions.assertEquals(16, Result.sumOfNumbers(2));
        Assertions.assertEquals(112, Result.sumOfNumbers(4));
        Assertions.assertEquals(352, Result.sumOfNumbers(6));
        Assertions.assertEquals(0, Result.sumOfNumbers(0));
        Assertions.assertEquals(0, Result.sumOfNumbers(10));
    }
}
