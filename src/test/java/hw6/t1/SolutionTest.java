package hw6.t1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    public void sample0() {
        final String text = "If You are Seeing High CPU Usage in Windows 10, Grab This Update!";
        final String target = "in";

        assertEquals(3, Result.numberOfOccurrences(text, target));
    }

    @Test
    public void sample1() {
        final String text = "Eeeeeeh, If You are Seeing High CPU Usage in Windows 10, Grab This Update!";
        final String target = "ee";

        assertEquals(3, Result.numberOfOccurrences(text, target));
    }

    @Test
    public void sample2() {
        final String text = "If You are Seeing High CPU Usage in Windows 10, Grab This Update!";
        final String target = "In";

        assertEquals(0, Result.numberOfOccurrences(text, target));
    }
}
