package hw4.t1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface Deliverable {
    double shippingPrice();
}

abstract class DeliverableItem implements Deliverable {

    protected boolean deliverToAddress;
    protected static double additionalPrice;

    public void setDeliverToAddress(boolean deliverToAddress) {
        this.deliverToAddress = deliverToAddress;
    }

    public static void setAdditionalPrice(double additionalPrice) {
        DeliverableItem.additionalPrice = Math.max(additionalPrice, 1);
    }
}

class Material extends DeliverableItem {

    protected String name;
    protected boolean isFragile;

    Material(String name, boolean isFragile) {
        this.isFragile = isFragile;
        this.name = name;
    }

    @Override
    public double shippingPrice() {
        return 0;
    }

    public boolean isFragile() {
        return isFragile;
    }
}

class Document extends DeliverableItem {

    double minDeliveryPrice;

    Document(boolean toClientsAddress, double minDeliveryPrice) {
        deliverToAddress = toClientsAddress;
        this.minDeliveryPrice = Math.max(1, minDeliveryPrice);
    }

    @Override
    public double shippingPrice() {
        return minDeliveryPrice + (deliverToAddress ? additionalPrice : 0);
    }
}

class WeightedItem extends DeliverableItem {

    Material material;
    double weightInKg;
    double deliveryPricePerKg;

    WeightedItem(Material material, double weightInKg, double deliveryPricePerKg, boolean toClientsAddress) {
        this.material = material;
        this.weightInKg = Math.max(1, weightInKg);
        this.deliveryPricePerKg = Math.max(1, deliveryPricePerKg);
        deliverToAddress = toClientsAddress;
    }

    @Override
    public double shippingPrice() {
        final double price = weightInKg * deliveryPricePerKg + (deliverToAddress ? additionalPrice : 0);
        final double priceFragile =  price + (price / 100);
        return material.isFragile() ? priceFragile : price;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String materialName = bufferedReader.readLine();

        boolean isFragile = Integer.parseInt(bufferedReader.readLine().trim()) != 0;

        boolean toClientsAddress = Integer.parseInt(bufferedReader.readLine().trim()) != 0;

        double minPrice = Double.parseDouble(bufferedReader.readLine().trim());

        double weight = Double.parseDouble(bufferedReader.readLine().trim());

        double pricePerKg = Double.parseDouble(bufferedReader.readLine().trim());

        double additionalPrice = Double.parseDouble(bufferedReader.readLine().trim());

        // Use the set method to give the value additionalPrice to the additional price when the shipment has to be delivered to the client's address.
        DeliverableItem.setAdditionalPrice(additionalPrice);

        // Create an object of type Material using the constructor with two parameters. Pass materialName and isFragile as arguments.
        Material material = new Material(materialName, isFragile);

        // Create a reference of type Deliverable.
        Deliverable deliverable;

        // Use the reference of type Deliverable to create an object of type Document. Use toClientsAddress and minPrice to the constructor of the Document.
        deliverable = new Document(toClientsAddress, minPrice);

        // Print on the console the result of calling the shippingPrice() method: the method that has to return the total shipping price for the delivery.
        System.out.println(deliverable.shippingPrice());

        // Use the reference of type Deliverable to create an object of type WeightedItem. Use weight and pricePerKg to pass them to the constructor of the WeightedItem.
        deliverable = new WeightedItem(material,weight,pricePerKg, toClientsAddress);

        // Print on the console the result of calling the shippingPrice() method: the method that has to return the total shipping price for the delivery.
        System.out.println(deliverable.shippingPrice());

        bufferedReader.close();
    }
}