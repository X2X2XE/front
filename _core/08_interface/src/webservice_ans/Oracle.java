package webservice_ans;

public class Oracle implements DataBase {
	private Member[] members;
	
	public Oracle() {
		members = new Member[10];
	}

	@Override
	public boolean insert(Member member) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean select(Member member) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Member member) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean del(Member member) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member select_re(Member member) {
		// TODO Auto-generated method stub
		return null;
	}
}
