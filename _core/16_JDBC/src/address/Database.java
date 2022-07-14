package address;

import java.util.List;

public interface Database {
	boolean insert(Address info);
	List<Address> selectList();
	Address selectOne(String name);
	boolean update(Address info);
	boolean delect(String name);
	
}
