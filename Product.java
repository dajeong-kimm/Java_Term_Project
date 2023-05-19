public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }

    // Getters and setters

    @Override
    public String toString() {
        return name + " - $" + price;
    }
}
