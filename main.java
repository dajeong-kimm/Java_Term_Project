public class main {
    public static void main(String[] args) {
        // Initialize the necessary objects
        Inventory inventory = new Inventory();
        UserManager userManager = new UserManager();
        OrderManager orderManager = new OrderManager();

        // Add some sample products to the inventory
        Product product1 = new Product("Product 1", 10.99);
        Product product2 = new Product("Product 2", 19.99);
        inventory.addProduct(product1);
        inventory.addProduct(product2);

        // Add some sample users to the user manager
        User user1 = new User("user1", "password1");
        User user2 = new User("user2", "password2");
        userManager.addUser(user1);
        userManager.addUser(user2);

        // Create the GUI and pass the necessary objects
        GUI gui = new GUI(inventory, userManager, orderManager);
    }
}
