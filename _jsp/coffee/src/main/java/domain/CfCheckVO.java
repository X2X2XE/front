package domain;

public class CfCheckVO {
	public String id;
	public String name;
	private int pno;
	private int price; 
	private int kind;
	private int sal;
	private String image_file;
	public CfCheckVO() {}

	public CfCheckVO(String id) {
		this.id = id;
	}
	
	
	// list
	public CfCheckVO(int pno, String name, int price, int kind, int sal, String image_file) {
		this.pno = pno;
		this.name = name;
		this.price = price;
		this.kind = kind;
		this.sal = sal;
		this.image_file = image_file;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPno() {
		return pno;
	}

	public void setPno(int pno) {
		this.pno = pno;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public String getImage_file() {
		return image_file;
	}

	public void setImage_file(String image_file) {
		this.image_file = image_file;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}
