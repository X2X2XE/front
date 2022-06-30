package oracle;

public interface DataBase {
	boolean insert(Member info);
	boolean select(Member info);
	boolean update(Member info);
}
