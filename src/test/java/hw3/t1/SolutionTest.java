package hw3.t1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    public void sample0() {
        String manufacturerName = "ElDevMan";
        boolean isLongTermWarranty = true;
        int minWarranty = 12;
        boolean isGas = true;
        boolean isDryer = true;

        final var manufacturer = new Manufacturer(manufacturerName, isLongTermWarranty);
        ElectricDevice electricDevice = new ElectricDevice(manufacturer,minWarranty);

        Assertions.assertEquals(24, electricDevice.warranty());

        electricDevice = new Cooker(manufacturer, minWarranty, isGas);

        Assertions.assertEquals(36, electricDevice.warranty());

        electricDevice = new WashingMachine(manufacturer, minWarranty, isDryer);

        Assertions.assertEquals(30, electricDevice.warranty());
    }

    @Test
    public void sample1() {
        String manufacturerName = "ElDevMan";
        boolean isLongTermWarranty = false;
        int minWarranty = 6;
        boolean isGas = false;
        boolean isDryer = false;

        final var manufacturer = new Manufacturer(manufacturerName, isLongTermWarranty);
        ElectricDevice electricDevice = new ElectricDevice(manufacturer,minWarranty);

        Assertions.assertEquals(6, electricDevice.warranty());

        electricDevice = new Cooker(manufacturer, minWarranty, isGas);

        Assertions.assertEquals(6, electricDevice.warranty());

        electricDevice = new WashingMachine(manufacturer, minWarranty, isDryer);

        Assertions.assertEquals(6, electricDevice.warranty());
    }

    @Test
    public void sample2() {
        String manufacturerName = "ElDevMan";
        boolean isLongTermWarranty = true;
        int minWarranty = 6;
        boolean isGas = false;
        boolean isDryer = true;

        final var manufacturer = new Manufacturer(manufacturerName, isLongTermWarranty);
        ElectricDevice electricDevice = new ElectricDevice(manufacturer,minWarranty);

        Assertions.assertEquals(18, electricDevice.warranty());

        electricDevice = new Cooker(manufacturer, minWarranty, isGas);

        Assertions.assertEquals(18, electricDevice.warranty());

        electricDevice = new WashingMachine(manufacturer, minWarranty, isDryer);

        Assertions.assertEquals(21, electricDevice.warranty());
    }

    @Test
    public void sample3() {
        String manufacturerName = "ElDevMan";
        boolean isLongTermWarranty = false;
        int minWarranty = 3;
        boolean isGas = true;
        boolean isDryer = true;

        final var manufacturer = new Manufacturer(manufacturerName, isLongTermWarranty);
        ElectricDevice electricDevice = new ElectricDevice(manufacturer,minWarranty);

        Assertions.assertEquals(6, electricDevice.warranty());

        electricDevice = new Cooker(manufacturer, minWarranty, isGas);

        Assertions.assertEquals(18, electricDevice.warranty());

        electricDevice = new WashingMachine(manufacturer, minWarranty, isDryer);

        Assertions.assertEquals(9, electricDevice.warranty());
    }

    @Test
    public void sample4() {
        String manufacturerName = "ElDevMan";
        boolean isLongTermWarranty = false;
        int minWarranty = 3;
        boolean isGas = false;
        boolean isDryer = false;

        final var manufacturer = new Manufacturer(manufacturerName, isLongTermWarranty);
        ElectricDevice electricDevice = new ElectricDevice(manufacturer,minWarranty);

        Assertions.assertEquals(6, electricDevice.warranty());

        electricDevice = new Cooker(manufacturer, minWarranty, isGas);

        Assertions.assertEquals(6, electricDevice.warranty());

        electricDevice = new WashingMachine(manufacturer, minWarranty, isDryer);

        Assertions.assertEquals(6, electricDevice.warranty());
    }
}
