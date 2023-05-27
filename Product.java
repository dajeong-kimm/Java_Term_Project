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
    
    public double getPrice() {
    	return price;
    }
    
    // DB 구축 후에 setStock 함수로 재고관리, Inventory 파일 수정해서 제품 관리
    public void setStock(int stock) {
    	this.stock = stock;
    }
    
    public int getStock() {
    	return this.stock;
    }

    // Getters and setters

    @Override
    public String toString() {
        return name + " - $" + price;
    }
}
