import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class CategoryDao {

	public ArrayList<Category> fileOpen(){
		
		ArrayList<Category>  cateList = new ArrayList<>();
		
		try(ObjectInputStream ois =  new ObjectInputStream(new FileInputStream("category.dat"))){
			cateList = (ArrayList<Category>)ois.readObject();
		
		} catch (IOException e) {
			System.out.println("category.txt 파일을 로드하지 못했습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("ArrayList<Categoty>으로 캐스팅 할 수 없습니다.");
		}
		return cateList;
	}
	
	public void fileSave(ArrayList<Category> CateList) {
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("category.dat"))){
			oos.writeObject(CateList);
		} catch (IOException e) {
			System.out.println("category.txt 파일 저장에 실패하였습니다.");
		}
	}
	

}