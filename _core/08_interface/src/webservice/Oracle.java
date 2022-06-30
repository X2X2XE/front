package webservice;

public class Oracle implements DataBase {

	@Override
	public boolean insert(String str) {
		System.out.println("회원 정보를 입력");
		
		return true ;
			
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
