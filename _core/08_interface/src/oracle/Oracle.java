package oracle;

import webservice_ans.Member;

public class Oracle implements DataBase{
	private oracle.Member[] members;
	private int lastCount;
	
	public Oracle() {
		members = new oracle.Member[10];
		lastCount = 0;
	}
	
	@Override
	public boolean insert(oracle.Member info) {
		if(lastCount < members.length) {
			if(hasEmail(info.getEmail())) {
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
		return -1;
		
	}

	private boolean hasEmail(String email) {
		for(oracle.Member member : members) {
			if(member != null) {
				if(email.equals(member.getEmail())) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean select(oracle.Member info) {
		for (oracle.Member member : members) {
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
	public boolean update(oracle.Member info) {
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

	
	
}
