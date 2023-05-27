import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ProductDao {
   public ArrayList<Product>openProductListFile(){
	      ArrayList<Product>productList = new ArrayList<>();
	      try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("productList.dat"))){
	         productList = (ArrayList<Product>) ois.readObject();
	      } catch (FileNotFoundException e) {
	         e.printStackTrace();
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	      }
	      return productList;
	      
	   }
   
   public void saveProductListFile(ArrayList<Product> productList){
      try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("productList.dat"))){

         oos.writeObject(productList);
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   //장바구니에 담을 리스트 넣는 메소드
   public void saveBasketList(ArrayList<Product> p){
      try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("basketList.dat"))){

         oos.writeObject(p);
      } catch (FileNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   
      
   }
   
   
   public ArrayList<Product>openBasketListFile(){
      

      ArrayList<Product>list = new ArrayList<>();
      try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("basketList.dat"))){
   
         list = (ArrayList<Product>) ois.readObject();
         
      } catch (FileNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   
      return list;
      
   }
}