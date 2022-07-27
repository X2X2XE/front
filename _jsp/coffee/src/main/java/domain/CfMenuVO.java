package domain;

public class CfMenuVO {
	private String name;
	private int pno;
	private int price;
	private int kind; // 1. 커피, 2. 스무디, 3. 간식
	private int sal; //1. 판매가능 2. 판매불가
	private String image_file;
	public CfMenuVO() {}
	
	// register
	public CfMenuVO(String name, int kind, int price, String image_file) {
		this.name = name;
		this.kind = kind;
		this.price = price;
		this.image_file = image_file;
	}
	// sal change
	public CfMenuVO(int pno, int sal) {
		this.pno = pno;
		this.sal = sal;
	}

	// list
	public CfMenuVO(String name, int price, String image_file, int kind, int sal, int pno) {
		this.pno = pno;
		this.name = name;
		this.price = price;
		this.kind = kind;
		this.image_file = image_file;
		this.sal = sal;
	}
	
	// all
	public CfMenuVO(String name, int pno, int price, int kind, int sal, String image_file) {
		super();
		this.name = name;
		this.pno = pno;
		this.price = price;
		this.kind = kind;
		this.sal = sal;
		this.image_file = image_file;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage_file() {
		return image_file;
	}

	public void setImage_file(String image_file) {
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
	
	
	
	

}
