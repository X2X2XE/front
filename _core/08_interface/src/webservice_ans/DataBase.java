package webservice_ans;

public interface DataBase {
	boolean insert(Member member);
	boolean select(Member member);
	boolean update(Member member);
	boolean del(Member member);
	int last();
	Member[] arr(int size);
	
	
	Member select_re(Member member);
}
