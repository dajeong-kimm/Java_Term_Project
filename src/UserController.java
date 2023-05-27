import java.util.ArrayList;

public class UserController {
	private UserDao ud = new UserDao();
	private ArrayList<User> list = new ArrayList<>();
	private User loginUser;

	// 리스트 안에 넣기
	public void addList(User user) {
		list.add(user);
	}
	
	// 열기
	public ArrayList<User> openList() {
		list = ud.openUserListFile();
		return list;
	}
	// 저장
	public void saveList(ArrayList<User> list) {
		ud.saveUserListFile(list);
	}
	//로그인 회원 저장 
	public void saveLogin(User user) {
		ud.saveLoginListFile(user);
	}
	//로그인
	public User getLogin() {
		loginUser = ud.openLoginFile();
		return loginUser;
	}
	//로그아웃 
	public void logOut(User user) {
		ud.logoutFile(user);
	}
	//로그인된 회원정보 수정
	public void loginEdit(User user) {
		ud.saveLoginListFile(user);
	}
}