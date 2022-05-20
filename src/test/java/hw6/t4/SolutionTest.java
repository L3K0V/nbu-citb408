package hw6.t4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {

    @Test
    public void sample0() {
        final String text = "2Wire 192.168.1.1 192.168.0.1 192.168.1.254 10.0.0.138; 3Com 192.168.1.1 192.168.10.1; Actiontec 192.168.1.1 192.168.0.1 192.168.2.1 192.168.254.254; Airlink 192.168.1.1 192.168.2.1; Airlive 192.168.2.1; Airties 192.168.2.1; Apple 10.0.1.1;";

        assertEquals("192.168.1.1<->192.168.0.1<->192.168.1.254<->10.0.0.138<->192.168.1.1<->192.168.10.1<->192.168.1.1<->192.168.0.1<->192.168.2.1<->192.168.254.254<->192.168.1.1<->192.168.2.1<->192.168.2.1<->192.168.2.1<->10.0.1.1", Result.ipAddresses(text));
    }

    @Test
    public void sample1() {
        final String text = "1.1. 2Wire 192.168.1.1 192.168.0.1 192.168.1.254, 1.2. Net.67 10.0.0.138, 1.3. 3Com 192.168.1.1 192.168.10.1, 1.4. Actiontec 192.168.1.1 192.168.0.1";

        assertEquals("192.168.1.1<->192.168.0.1<->192.168.1.254<->10.0.0.138<->192.168.1.1<->192.168.10.1<->192.168.1.1<->192.168.0.1", Result.ipAddresses(text));
    }
}
