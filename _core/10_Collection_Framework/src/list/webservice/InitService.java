package list.webservice;

import java.util.ArrayList;
import java.util.Scanner;

public class InitService {
	private Scanner sc;
	private boolean flag;
	private WebService websvc;
	
	
	public InitService() {
		sc = new Scanner(System.in);
		flag =true;
		websvc = new WebService();
		menuService();
	}

	private void menuService() {
		while (flag) {
			System.out.println("데이터베이스를 선택하세요.");
			System.out.println("1.MySQL 2.Oracle Etc.종료");
			int db = sc.nextInt();
			
			if(db ==1 || db == 2) {
				boolean flag2 = true;
				while(true) {
					System.out.println("서비스를 선택하세요");
					System.out.println(
							"1.회원가입 2.로그인 3.회원수정 4.회원탈퇴 "
							+ "5.회원리스트 6.회원조회 Etc.DB변경");
					int svc = sc.nextInt();
					
					switch (svc) {
					case 1:
//						Member regInfo = getRegInfo();
						websvc.register(db, getRegInfo());
						break;
					case 2:
						websvc.login(db, getLoginInfo());
						break;
					case 3:
						websvc.edit(db, getEditInfo());
						break;
					case 4:
						websvc.delect(db, getdelectInfo(true));
						break;
					case 5:
						// 데이터베이스에서 데이터를 리턴받아
						// 프린트 기능 메서드를 정의하여 출력
						ArrayList<Member> user_arr = websvc.user_list();
						print_arr(user_arr);
						break;
					case 6:
						Member member = websvc.getMember(db, getdelectInfo(false));
						printMember(member);
						break;
					default:
						flag2 = false;
						break;
					}
				}
				
				
			}else {
				flag = false;
				System.out.println("프로그램 종료");
			}
		}
		
	}

	

	private void printMember(Member member) {
		if(member != null) {
			System.out.println("Email : " +member.getEmail());
			System.out.println("PWD : " +member.getPwd());
			System.out.println("Nickname : " +member.getNickname());
			System.out.println("GRADE : " +member.getGrade());
		} else {
			System.out.println("검색한 회원이 존재하지 않습니다");
		}
		
	}

	private void print_arr(ArrayList<Member> user_arr) {
		for (int i = 0; i < user_arr.size(); i++) {
			System.out.print("email : " + user_arr.get(i).getEmail() + "\t");
			System.out.print("pwd : " + user_arr.get(i).getPwd() + "\t");
			System.out.print("Nickname : " + user_arr.get(i).getNickname() + "\t");
			System.out.println("GRADE : " + user_arr.get(i).getGrade() + "\t");
			

			
			
		}
		
	}

	private Member getdelectInfo(boolean sign) {
		System.out.println("회원"+(sign ? "탈퇴" : "조회")+"을 시작합니다");
		System.out.println("Email 입력 >>");
		String email = sc.next();
		System.out.println("PWD입력 >>");
		String pwd = sc.next();
		return new Member(email, pwd);
		
	}

	private Member getEditInfo() {
		System.out.println("회원수정을 시작합니다");
		System.out.println("Email 입력 >>");
		String email = sc.next();
		System.out.println("PWD입력 >>");
		String pwd = sc.next();
		System.out.println("Nickname 입력 >>");
		String nick = sc.next();
		System.out.println("GRADE 입력 >>");
		int grade = sc.nextInt();
		return new Member(email, pwd, nick, grade);
		
	}

	private Member getLoginInfo() {
		System.out.println("로그인을 시작합니다");
		System.out.println("Email 입력 >>");
		String email = sc.next();
		System.out.println("PWD입력 >>");
		String pwd = sc.next();
		return new Member(email,pwd);
	}

	private Member getRegInfo() {
		System.out.println("회원가입을 시작합니다");
		System.out.println("Email 입력 >>");
		String email = sc.next();
		System.out.println("PWD입력 >>");
		String pwd = sc.next();
		System.out.println("Nickname 입력 >>");
		String nick = sc.next();
		return new Member(email, pwd, nick, 0);
	}
}
