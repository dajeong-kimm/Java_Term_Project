import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Product> products;

    public Inventory() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getName(), product);
    }

    public void updateProduct(Product product) {
        if (products.containsKey(product.getName())) {
            products.put(product.getName(), product);
        }
    }

    public void removeProduct(String productName) {
        products.remove(productName);
    }

    public boolean containsProduct(String productName) {
        return products.containsKey(productName);
    }

    public Product getProduct(String productName) {
        return products.get(productName);
    }
}
