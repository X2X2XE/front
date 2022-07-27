package domain;

public class CfOrderVO {
	private int ono;
	private String id;
	private String name;
	private int pno;
	private int temper;
	private int etc;
	private String order_time;
	private String endtime;
	private String image_file;
	private int price;
	private int the_number;
	private int made;
	private int kind;
	
	public int getKind() {
		return kind;
	}

	public void setKind(int kind) {
		this.kind = kind;
	}

	public CfOrderVO() {}
	
	// cart_ss
	public CfOrderVO(String id, String name, int pno, String image_file, int price, int kind) {
		super();
		this.id = id;
		this.name = name;
		this.pno = pno;
		this.image_file = image_file;
		this.price = price;
		this.kind =kind;
	}
	
	
	// cart_order
	public CfOrderVO(int ono, String id, int temper, int etc, int the_number) {
		this.ono = ono;
		this.id = id;
		this.temper = temper;
		this.etc = etc;
		this.the_number = the_number;
	}
	
	
	// order list
	public CfOrderVO(int ono, String id, String name, int pno, int temper, int etc, String order_time, String endtime,
			String image_file, int price, int the_number, int made, int kind) {
		this.ono = ono;
		this.id = id;
		this.name = name;
		this.pno = pno;
		this.temper = temper;
		this.etc = etc;
		this.order_time = order_time;
		this.endtime = endtime;
		this.image_file = image_file;
		this.price = price;
		this.the_number = the_number;
		this.made = made;
		this.kind = kind;
	}

	public String getImage_file() {
		return image_file;
	}

	public void setImage_file(String image_file) {
		this.image_file = image_file;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getThe_number() {
		return the_number;
	}

	public void setThe_number(int the_number) {
		this.the_number = the_number;
	}

	public int getOno() {
		return ono;
	}

	public void setOno(int ono) {
		this.ono = ono;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
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


	public int getTemper() {
		return temper;
	}


	public void setTemper(int temper) {
		this.temper = temper;
	}


	public int getEtc() {
		return etc;
	}


	public void setEtc(int etc) {
		this.etc = etc;
	}


	public String getOrder_time() {
		return order_time;
	}


	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}


	public String getEndtime() {
		return endtime;
	}


	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}


	public int getMade() {
		return made;
	}


	public void setMade(int made) {
		this.made = made;
	}
	
	
}
