import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 8851889852802594455L;
    
    private String name;     // 사용자 이름
    private String id;       // 사용자 아이디
    private int age;         // 사용자 나이
    private String pwd;      // 사용자 비밀번호
    private String paypwd;
    private int point=0;// 사용자 결제 비밀번호
   
    public User() {
        // 기본 생성자
    }

    public User(String name, int age, String id, String pwd, String paypwd) {
        // 생성자
        this.name = name;
        this.id = id;
        this.age = age;
        this.pwd = pwd;
        this.paypwd = paypwd;
        

    }
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPaypwd() {
		return paypwd;
	}
	public void setPaypwd(String paypwd) {
		this.paypwd = paypwd;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}

    // Getter 및 Setter 메서드들

    @Override
    public int hashCode() {
        // hashCode() 메서드 재정의
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((paypwd == null) ? 0 : paypwd.hashCode());
        result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        // equals() 메서드 재정의
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (age != other.age)
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (paypwd == null) {
            if (other.paypwd != null)
                return false;
        } else if (!paypwd.equals(other.paypwd))
            return false;
        if (pwd == null) {
            if (other.pwd != null)
                return false;
        } else if (!pwd.equals(other.pwd))
            return false;
        return true;
    }

    @Override
    public String toString() {
        // toString() 메서드 재정의
        return "User [name=" + name + ", id=" + id + ", age=" + age + ", pwd=" + pwd + ", paypwd=" + paypwd+ "]";
    }
}

