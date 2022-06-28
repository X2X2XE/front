package basic;

public class Person {
	protected int telNum;
	protected String name;
	protected String dept;
	protected String addr;
	
	public Person() {
		System.out.println("This is Person Instance");
	}

	protected void printInfo() {
		System.out.println("telNum : " + telNum);
		System.out.println("name : " + name);
		System.out.println("dept : " + dept);
		System.out.println("addr : " + addr);
	}
	
	
	
	public int getTelNum() {
		return telNum;
	}





	public void setTelNum(int telNum) {
		this.telNum = telNum;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getDept() {
		return dept;
	}





	public void setDept(String dept) {
		this.dept = dept;
	}





	public String getAddr() {
		return addr;
	}





	public void setAddr(String addr) {
		this.addr = addr;
	}





	
	
	
}
