package hw1.t1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    public void samples() {
        Assertions.assertEquals(12, Result.countNumbers(1000,1200,700));
        Assertions.assertEquals(10, Result.countNumbers(0,100,40));
        Assertions.assertEquals(0, Result.countNumbers(-1000,-1200,700));
    }
}
