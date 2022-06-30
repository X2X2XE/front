package webservice_ans;

public interface Service {
	void register(int dbms, Member member);
	void login(int dbms, Member member);
	void edit(int dbms, Member member);
	void delect(int dbms, Member member);
	
	Member getMember(int dbms, Member member);
}
