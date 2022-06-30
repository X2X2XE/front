package webservice;

public class WebService implements Service {
	
	DataBase dbms;
	
	Member member = new Member();
	
	
	


	public WebService(int select_num, int user_cnt) {
		if(select_num ==1) {
			dbms = new MySQL(member);
			
			
		} else if(select_num == 2) {
			dbms = new Oracle();
		}
	}
	
	public WebService() {
		dbms = new MySQL();
	}
	
	@Override
	public void register(String nick, String pwd, String em, int cnt) {
		System.out.println("회원가입 서비스 요청");
		
		if(dbms.insert(em)) {
			member.setNickname(nick);
			member.setPwd(pwd);
			member.setEmail(em);
			member.setGrade(9);
			System.out.println("회원가입 " + (dbms.insert(em) ? "성공" : "실패"));
		} else {
			System.out.println("회원가입 " + (dbms.insert(em) ? "성공" : "실패"));
		}
	}

	@Override
	public void login() {
		System.out.println("회원로그인 서비스");
		dbms.select();
		System.out.println("로그인 완료");

	}

	@Override
	public void edit() {
		System.out.println("회원 정보 수정 서비스");
		dbms.update();
		System.out.println("수정 완료");
	}

	@Override
	public void resign() {
		System.out.println("회원 탈퇴 서비스");
		dbms.delect();
		System.out.println("탈퇴 완료");
	}

	
}
