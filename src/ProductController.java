import java.util.ArrayList;

public class ProductController {
   private ProductDao pd = new ProductDao();
   
   public void saveBasketFile(ArrayList<Product> p) {
      pd.saveBasketList(p);
   }
   public ArrayList<Product>getProductList(){
      ////saveFile();
      //pd.saveProductListFile();
      return pd.openProductListFile();
   }
   
   public void saveProductFile(ArrayList<Product> pf) {
      pd.saveProductListFile(pf);
   }
   public ArrayList<Product>getBasketList(){

      
      return pd.openBasketListFile();
   }
   
   
   
}