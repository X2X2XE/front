package domain;

public class CfMemberVO {
	private String id;
	private String pwd;
	private String tel;
	private int grade;
	
	public CfMemberVO() {}

	// register
	public CfMemberVO(String id, String pwd, String tel) {
		this.id = id;
		this.pwd = pwd;
		this.tel = tel;
	}

	// idcheck , tel
	public CfMemberVO(String id) {
		this.id = id;
	}

	// detail
	public CfMemberVO(String id, String pwd, String tel, int grade) {
		this.id = id;
		this.pwd = pwd;
		this.tel = tel;
		this.grade = grade;
	}

	
	// login
	public CfMemberVO(String id, String pwd) {
		this.id = id;
		this.pwd = pwd;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public String getId() {
		return id;
	}

	

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
	
	
	
	
	
}
