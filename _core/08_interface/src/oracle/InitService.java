package oracle;

import java.util.Scanner;

import webservice_ans.Member;

public class InitService {
	private Scanner sc;
	private boolean flag;
	private WebService websvc;
	
	public InitService() {
		sc = new Scanner(System.in);
		flag =true;
		
	}
	private void menuService() {
		while(flag) {
			System.out.println("서비스를 선택하세요");
			System.out.println(
					"1.회원가입 2.로그인 3.회원수정 4.회원탈퇴 "
					+ "5.회원리스트 6.회원조회 Etc.DB변경");
			int svc = sc.nextInt();
			switch (svc) {
			case 1:
				websvc.register(getRegInfo());
				break;
			case 2:
				websvc.login(getLoginInfo());
				break;
			case 3:
				websvc.edit(getEditInfo());
				break;
			case 4:
				websvc.delect(getdelectInfo(true));
				break;

			default:
				break;
			}
		}
	}
	
	
	
	
	
	
	private oracle.Member getdelectInfo(boolean sign) {
		System.out.println("회원"+(sign ? "탈퇴" : "조회")+"을 시작합니다");
		System.out.println("Email 입력 >>");
		String email = sc.next();
		System.out.println("PWD입력 >>");
		String pwd = sc.next();
		return new oracle.Member(email, pwd);
	}
	private oracle.Member getEditInfo() {
		System.out.println("회원수정을 시작합니다");
		System.out.println("Email 입력 >>");
		String email = sc.next();
		System.out.println("PWD입력 >>");
		String pwd = sc.next();
		System.out.println("Nickname 입력 >>");
		String nick = sc.next();
		System.out.println("GRADE 입력 >>");
		int grade = sc.nextInt();
		return new oracle.Member(email, pwd, nick, grade);
	}
	private oracle.Member getLoginInfo() {
		System.out.println("로그인을 시작합니다");
		System.out.println("Email 입력 >>");
		String email = sc.next();
		System.out.println("PWD입력 >>");
		String pwd = sc.next();
		return new oracle.Member(email,pwd);
		
	}
	private oracle.Member getRegInfo() {
		System.out.println("회원가입을 시작합니다");
		System.out.println("Email 입력 >>");
		String email = sc.next();
		System.out.println("PWD입력 >>");
		String pwd = sc.next();
		System.out.println("Nickname 입력 >>");
		String nick = sc.next();
		return new oracle.Member(email, pwd, nick, 0);
	}
}
