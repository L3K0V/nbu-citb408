package hw4.t1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    @Test
    public void sample0() {
        String materialName = "Glass";
        boolean isFragile = true;
        boolean toClientsAddress = true;
        double minPrice = 5;
        double weight = 10;
        double pricePerKg = 1.2;
        double additionalPrice = 2;

        // Use the set method to give the value additionalPrice to the additional price when the shipment has to be delivered to the client's address.
        DeliverableItem.setAdditionalPrice(additionalPrice);

        // Create an object of type Material using the constructor with two parameters. Pass materialName and isFragile as arguments.
        Material material = new Material(materialName, isFragile);

        // Create a reference of type Deliverable.
        Deliverable deliverable;

        // Use the reference of type Deliverable to create an object of type Document. Use toClientsAddress and minPrice to the constructor of the Document.
        deliverable = new Document(toClientsAddress, minPrice);
        Assertions.assertEquals(2, DeliverableItem.additionalPrice);

        // Print on the console the result of calling the shippingPrice() method: the method that has to return the total shipping price for the delivery.
        Assertions.assertEquals(7.0, deliverable.shippingPrice());

        // Use the reference of type Deliverable to create an object of type WeightedItem. Use weight and pricePerKg to pass them to the constructor of the WeightedItem.
        deliverable = new WeightedItem(material,weight,pricePerKg, toClientsAddress);

        // Print on the console the result of calling the shippingPrice() method: the method that has to return the total shipping price for the delivery.
        Assertions.assertEquals(14.14, deliverable.shippingPrice());
    }

    @Test
    public void sample1() {
        String materialName = "Timber";
        boolean isFragile = false;
        boolean toClientsAddress = true;
        double minPrice = 5;
        double weight = 10;
        double pricePerKg = 1.2;
        double additionalPrice = 2;

        // Use the set method to give the value additionalPrice to the additional price when the shipment has to be delivered to the client's address.
        DeliverableItem.setAdditionalPrice(additionalPrice);

        // Create an object of type Material using the constructor with two parameters. Pass materialName and isFragile as arguments.
        Material material = new Material(materialName, isFragile);

        // Create a reference of type Deliverable.
        Deliverable deliverable;

        // Use the reference of type Deliverable to create an object of type Document. Use toClientsAddress and minPrice to the constructor of the Document.
        deliverable = new Document(toClientsAddress, minPrice);
        Assertions.assertEquals(2, DeliverableItem.additionalPrice);

        // Print on the console the result of calling the shippingPrice() method: the method that has to return the total shipping price for the delivery.
        Assertions.assertEquals(7.0, deliverable.shippingPrice());

        // Use the reference of type Deliverable to create an object of type WeightedItem. Use weight and pricePerKg to pass them to the constructor of the WeightedItem.
        deliverable = new WeightedItem(material,weight,pricePerKg, toClientsAddress);

        // Print on the console the result of calling the shippingPrice() method: the method that has to return the total shipping price for the delivery.
        Assertions.assertEquals(14.0, deliverable.shippingPrice());
    }

    @Test
    public void sample2() {
        String materialName = "Glass";
        boolean isFragile = true;
        boolean toClientsAddress = false;
        double minPrice = 5;
        double weight = 10;
        double pricePerKg = 1.5;
        double additionalPrice = 2;

        // Use the set method to give the value additionalPrice to the additional price when the shipment has to be delivered to the client's address.
        DeliverableItem.setAdditionalPrice(additionalPrice);

        // Create an object of type Material using the constructor with two parameters. Pass materialName and isFragile as arguments.
        Material material = new Material(materialName, isFragile);

        // Create a reference of type Deliverable.
        Deliverable deliverable;

        // Use the reference of type Deliverable to create an object of type Document. Use toClientsAddress and minPrice to the constructor of the Document.
        deliverable = new Document(toClientsAddress, minPrice);
        Assertions.assertEquals(2, DeliverableItem.additionalPrice);

        // Print on the console the result of calling the shippingPrice() method: the method that has to return the total shipping price for the delivery.
        Assertions.assertEquals(5.0, deliverable.shippingPrice());

        // Use the reference of type Deliverable to create an object of type WeightedItem. Use weight and pricePerKg to pass them to the constructor of the WeightedItem.
        deliverable = new WeightedItem(material,weight,pricePerKg, toClientsAddress);

        // Print on the console the result of calling the shippingPrice() method: the method that has to return the total shipping price for the delivery.
        Assertions.assertEquals(15.15, deliverable.shippingPrice());
    }

    @Test
    public void sample3() {
        String materialName = "Timber";
        boolean isFragile = false;
        boolean toClientsAddress = false;
        double minPrice = 5;
        double weight = 10;
        double pricePerKg = 1.5;
        double additionalPrice = 2;

        // Use the set method to give the value additionalPrice to the additional price when the shipment has to be delivered to the client's address.
        DeliverableItem.setAdditionalPrice(additionalPrice);

        // Create an object of type Material using the constructor with two parameters. Pass materialName and isFragile as arguments.
        Material material = new Material(materialName, isFragile);

        // Create a reference of type Deliverable.
        Deliverable deliverable;

        // Use the reference of type Deliverable to create an object of type Document. Use toClientsAddress and minPrice to the constructor of the Document.
        deliverable = new Document(toClientsAddress, minPrice);
        Assertions.assertEquals(2, DeliverableItem.additionalPrice);

        // Print on the console the result of calling the shippingPrice() method: the method that has to return the total shipping price for the delivery.
        Assertions.assertEquals(5.0, deliverable.shippingPrice());

        // Use the reference of type Deliverable to create an object of type WeightedItem. Use weight and pricePerKg to pass them to the constructor of the WeightedItem.
        deliverable = new WeightedItem(material,weight,pricePerKg, toClientsAddress);

        // Print on the console the result of calling the shippingPrice() method: the method that has to return the total shipping price for the delivery.
        Assertions.assertEquals(15.0, deliverable.shippingPrice());
    }

    @Test
    public void sample4() {
        String materialName = "Glass";
        boolean isFragile = true;
        boolean toClientsAddress = true;
        double minPrice = 0;
        double weight = 0;
        double pricePerKg = -1;
        double additionalPrice = -2;

        // Use the set method to give the value additionalPrice to the additional price when the shipment has to be delivered to the client's address.
        DeliverableItem.setAdditionalPrice(additionalPrice);

        // Create an object of type Material using the constructor with two parameters. Pass materialName and isFragile as arguments.
        Material material = new Material(materialName, isFragile);

        // Create a reference of type Deliverable.
        Deliverable deliverable;

        // Use the reference of type Deliverable to create an object of type Document. Use toClientsAddress and minPrice to the constructor of the Document.
        deliverable = new Document(toClientsAddress, minPrice);
        Assertions.assertEquals(1, DeliverableItem.additionalPrice);

        // Print on the console the result of calling the shippingPrice() method: the method that has to return the total shipping price for the delivery.
        Assertions.assertEquals(2.0, deliverable.shippingPrice());

        // Use the reference of type Deliverable to create an object of type WeightedItem. Use weight and pricePerKg to pass them to the constructor of the WeightedItem.
        deliverable = new WeightedItem(material,weight,pricePerKg, toClientsAddress);

        // Print on the console the result of calling the shippingPrice() method: the method that has to return the total shipping price for the delivery.
        Assertions.assertEquals(2.02, deliverable.shippingPrice());
    }
}
