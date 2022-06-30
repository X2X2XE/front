package oracle;

import webservice_ans.Member;

public class WebService implements Service{
	private Oracle oracle;
	
	public WebService() {
		oracle = new Oracle();
	}

	public void register(oracle.Member info) {
		boolean ok = oracle.insert(info);
		if(ok) {
			System.out.println("회원가입 완료");
		}else {
			System.out.println("회원가입 실패");
		}
	}

	public void login(oracle.Member info) {
		boolean isOk = oracle.select(info); 
		System.out.println("로그인 " + (isOk? "완료" : "실패"));
		
	}

	public void edit(oracle.Member info) {
		boolean isOk = oracle.update(info); 
		System.out.println("회원수정 " + (isOk? "완료" : "실패"));
		
	}

	public void delect(oracle.Member info) {
		boolean isOk = oracle.update(info);
		System.out.println("회원탈퇴 " + (isOk? "완료" : "실패"));
		
	}
}
