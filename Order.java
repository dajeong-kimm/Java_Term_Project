public class Order {
    private Product product;
    private int quantity;

    public Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
   

    // Getters and setters

    @Override
    public String toString() {
        return product.getName() + " x " + quantity;
    }
}
