package webservice_ans;

public class MySQL implements DataBase{
	private Member[] members;
	private int lastCount;
	
	public MySQL() {
		members = new Member[10];
		lastCount = 0;
	}

	@Override
	public boolean insert(Member info) {
		if(lastCount < members.length) { // 가입한 사람의 수가 자리수 보다 작다
			if(hasEmail(info.getEmail())){
				members[indexWhere()]=info;
				lastCount++;
				return true;
			}else {
				System.out.println("중복된 이메일이 존재합니다");
			}
		} else {
			System.out.println("회원가입 가능인원을 초과했습니다");
		}
		return false;
	}

	private int indexWhere() {
		for (int i = 0; i < members.length; i++) {
			if(members[i] == null) {
				return i;
			} 
			
		}
		return -1; //EOF, 예외적 상황, 에러의 의미 값으로 많이 사용
	}

	private boolean hasEmail(String email) {
		for(Member member : members) {
			if(member != null) {
				if(email.equals(member.getEmail())) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean select(Member info) {
		for (Member member : members) {
			if(member != null) {
				if(info.getEmail().equals(member.getEmail())) {
					if(info.getPwd().equals(member.getPwd())) {
						return true;
					}else {
						// 실무에서는 상세 정보 출력 하지 않음
						System.out.println("패스워드가 일치하지 않거나");
					}
				}
			}
		}
		System.out.println("이메일이 존재하지 않습니다.");
		return false;
	}

	@Override
	public boolean update(Member info) {
		for (int i = 0; i < members.length; i++) {
			if(members[i] != null) {
				if(info.getEmail().equals(members[i].getEmail())) {
					members[i] = info;
					return true;
				}
			}
			
		}
		System.out.println("이메일이 존재하지 않습니다.");
		return false;
	}

	@Override
	public boolean del(Member info) {
		for (int i = 0; i < members.length; i++) {
			if(members[i] != null) {
				if(info.getEmail().equals(members[i].getEmail())) {
					members[i] = null;
					lastCount--;
					return true;
				}
			}
			
		}
		System.out.println("이메일이 존재하지 않습니다.");
		return false;
	}

	@Override
	public int last() {
		for (int i = 0; i < members.length; i++) {
			if(members[i] == null) {
				if(i == 0) {
					return 0;
				}
				return i;
			}
			
		}
		return 10;
	}

	@Override
	public Member[] arr(int size) {
		Member[] arr = new Member[size];
		for (int i = 0; i < arr.length; i++) {
			arr[i] =members[i];
			
		}
		return arr;
	}

	@Override
	public Member select_re(Member info) {
		
		for (int i = 0; i < members.length; i++) {
			if(members[i] != null) {
				if(info.getEmail().equals(members[i].getEmail())) {
					return members[i];
				}
			}
			
		}
		System.out.println("이메일이 존재하지 않습니다.");
		return null;
	}
}