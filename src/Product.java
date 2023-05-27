import java.io.Serializable;

public class Product implements Serializable{
	private String pName;
	private int price;
	private int cnt;
	private String img;
	private boolean adult;
	
	public Product() {
		
	}
	public Product(String pName, int price, String img) {
		super();
		this.pName = pName;
		this.price = price;
		this.img = img;
	}
	public Product(String pName, int price, int cnt, String img) {
		super();
		this.pName = pName;
		this.price = price;
		this.cnt = cnt;
		this.img = img;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "Product [pName=" + pName + ", price=" + price + ", cnt=" + cnt + ", img=" + img +"]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cnt;
		result = prime * result + ((img == null) ? 0 : img.hashCode());
		result = prime * result + ((pName == null) ? 0 : pName.hashCode());
		result = prime * result + price;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (cnt != other.cnt)
			return false;
		if (img == null) {
			if (other.img != null)
				return false;
		} else if (!img.equals(other.img))
			return false;
		if (pName == null) {
			if (other.pName != null)
				return false;
		} else if (!pName.equals(other.pName))
			return false;
		if (price != other.price)
			return false;
		return true;
	}

	
}