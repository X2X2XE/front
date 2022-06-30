package webservice;

public class MySQL implements DataBase {
	Member member;
	public MySQL(Member member) {
		this.member = member;
	}
	public MySQL() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean insert(String email) {
		
		System.out.println("MySQL > 회원 정보를 입력 " + (equl(email) ? "성공" : "실패"));
		return true;
	}

	private boolean equl(String email) {
		int eq =0;
		if(member.getEmail().equals(email)) {
			eq++;
		}
		if(eq>0) {
			return false;
		} else {
			return true;
		}
	}
	@Override
	public void select() {
		System.out.println("데이터베이스에서 회원 정보를 조회하였습니다");

	}

	@Override
	public void update() {
		System.out.println("데이터베이스에서 회원 정보를 수정하였습니다");

	}

	@Override
	public void delect() {
		System.out.println("데이터베이스에서 회원 정보를 삭제하였습니다");

	}

	

}
