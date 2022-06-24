package hotel;

public class User {
	private String name;
	private int age;
	private char gen;
	
	
	public User() {
		
	}
	
	
	
	
	
	
	
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("이름 넣기");
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGen() {
		return gen;
	}
	public void setGen(char gen) {
		this.gen = gen;
	}










	public void del_user() {
		age =0;
		gen='.';
		name="";
		
	}
}
