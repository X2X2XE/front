package webservice_ans;

public class WebService implements Service{
	private MySQL mysql;
	private Oracle oracle;
	
	public WebService() {
		mysql = new MySQL();
		oracle = new Oracle();
	}

	@Override
	public void register(int dbms, Member info) {
		boolean isOk= dbms > 1? 
				oracle.insert(info) : mysql.insert(info);
		System.out.println("회원가입 " + (isOk ? "완료" : "실패"));
	}

	@Override
	public void login(int dbms, Member info) {
		boolean isOk = dbms > 1?
				oracle.select(info) : mysql.select(info);
		System.out.println("로그인 " + (isOk? "완료" : "실패"));
		
	}

	@Override
	public void edit(int dbms, Member info) {
		boolean isOk = dbms > 1?
				oracle.update(info) : mysql.update(info);
		System.out.println("회원수정 " + (isOk? "완료" : "실패"));
		
	}

	@Override
	public void delect(int dbms, Member info) {
		boolean isOk = dbms > 1?
				oracle.update(info) : mysql.update(info);
		System.out.println("회원탈퇴 " + (isOk? "완료" : "실패"));
		
	}

	public Member[] user_list() {
		int list_size,oracle_size,sql_size  = 0;
		oracle_size = oracle.last();
		sql_size = mysql.last();
		list_size = oracle_size + sql_size;
		Member[] user_arr = arr_insert(list_size, sql_size, oracle_size);
		
		
		return user_arr;
	}

	private Member[] arr_insert(int list_size, int sql_size, int oracle_size) {
		Member[] arr = new Member[list_size];
		Member[] sql_arr = mysql.arr(sql_size);
		Member[] ora_arr = oracle.arr(oracle_size);
		for (int i = 0; i < arr.length; i++) {
			if(i <= sql_size) {
				arr[i] = sql_arr[i];
			} else if (i > sql_size) {
				arr[i] = ora_arr[i-sql_size];
			}
			
		}
		return arr;
	}

	@Override
	public Member getMember(int dbms, Member info) {
		
	
		return dbms > 1? oracle.select_re(info) : mysql.select_re(info);
	}
	
}
