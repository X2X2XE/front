package webservice;

public interface Service {
	void register(String nick,String pwd, String em, int cnt);
	void login();
	void edit();
	void resign();
}
