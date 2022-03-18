package hw3.t1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Manufacturer {
    String name;
    boolean isLongTermWarranty;

    public Manufacturer(String name, boolean isLongTermWarranty) {
        this.name = name;
        this.isLongTermWarranty = isLongTermWarranty;
    }
}

class ElectricDevice {
    Manufacturer manufacturer;
    int minWarranty;

    public ElectricDevice(Manufacturer manufacturer, int minWarranty) {
        this.manufacturer = manufacturer;
        this.minWarranty = minWarranty;
    }

    public int warranty() {
        return manufacturer.isLongTermWarranty ? minWarranty + 12 : minWarranty;
    }
}

class Cooker extends ElectricDevice {
    boolean isGas;

    public Cooker(Manufacturer manufacturer, int minWarranty, boolean isGas) {
        super(manufacturer, minWarranty);
        this.isGas = isGas;
    }

    @Override
    public int warranty() {
        final int base = super.warranty();
        final int extra = isGas ? 12 : 0;
        return base + extra;
    }
}

class WashingMachine extends ElectricDevice {
    boolean isDryer;

    public WashingMachine(Manufacturer manufacturer, int minWarranty, boolean isDryer) {
        super(manufacturer, minWarranty);
        this.isDryer = isDryer;
    }

    @Override
    public int warranty() {
        final int base = super.warranty();
        final int extra = isDryer ? minWarranty / 2 : 0;
        return base + extra;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String manufacturerName = bufferedReader.readLine();

        boolean isLongTermWarranty = Integer.parseInt(bufferedReader.readLine().trim()) != 0;

        int minWarranty = Integer.parseInt(bufferedReader.readLine().trim());

        boolean isGas = Integer.parseInt(bufferedReader.readLine().trim()) != 0;

        boolean isDryer = Integer.parseInt(bufferedReader.readLine().trim()) != 0;

        // Create object of type Manufacturer using the constructor with two parameters. Pass manufacturerName and isLongTermWarranty as arguments
        final Manufacturer manufacturer = new Manufacturer(manufacturerName, isLongTermWarranty);

        // Create object of type ElectricDevice using the constructor with 2 parameters. Pass manufacturer and minWarranty as arguments: ElectricDevice electricDevice = new ElectricDevice(manufacturer, minWarranty);
        ElectricDevice electricDevice = new ElectricDevice(manufacturer,minWarranty);

        // Print on the console the warranty of the the object electricDevice, by calling warranty() method
        System.out.println(electricDevice.warranty());

        // Assign the electricDevice a new object of type Cooker using the constructor with 3 parameters. Pass manufacturer, price and minWarranty as arguments: electricDevice = new Cooker(manufacturer, minWarranty, isGas);
        electricDevice = new Cooker(manufacturer, minWarranty, isGas);

        // Print on the console the warranty of the object electricDevice, by calling warranty() method
        System.out.println(electricDevice.warranty());

        // Assign the electricDevice a new object of type WashingMachine using the constructor with 3 parameters. Pass manufacturer, price and minWarranty as arguments: electricDevice = new WashingMachine(manufacturer, minWarranty, isDryer);
        electricDevice = new WashingMachine(manufacturer, minWarranty, isDryer);

        // Print on the console the warranty of the the object electricDevice, by calling warranty() method
        System.out.println(electricDevice.warranty());

        bufferedReader.close();
    }
}