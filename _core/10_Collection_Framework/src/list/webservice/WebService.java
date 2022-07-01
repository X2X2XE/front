package list.webservice;

import java.util.ArrayList;

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

	public ArrayList<Member> user_list() {
		int list_size,oracle_size,sql_size  = 0;
		oracle_size = oracle.last();
		sql_size = mysql.last();
		list_size = oracle_size + sql_size;
		ArrayList<Member> user_arr = arr_insert(list_size, sql_size, oracle_size);
		
		
		return user_arr;
	}

	private ArrayList<Member> arr_insert(int list_size, int sql_size, int oracle_size) {
		ArrayList<Member> arr = new ArrayList<Member>();
		ArrayList<Member> sql_arr = mysql.arr(sql_size);
		ArrayList<Member> ora_arr = oracle.arr(oracle_size);
		for (int i = 0; i < (sql_size+oracle_size); i++) {
			if(i <= sql_size) {
				arr.add( sql_arr.get(i));
			} else if (i > sql_size) {
				arr.add(ora_arr.get(i-sql_size));
			}
			
		}
		return arr;
	}

	@Override
	public Member getMember(int dbms, Member info) {
		
	
		return dbms > 1? oracle.select_re(info) : mysql.select_re(info);
	}
	
}
