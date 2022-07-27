package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CfMenuVO;
import orm.DataBaseBuilder;

public class CfMenuDAOImpl implements CfMenuDAO {
	private static Logger log = LoggerFactory.getLogger(CfMenuDAOImpl.class);
	private SqlSession sql;
	private final String NS = "CfMenuMapper.";

	public CfMenuDAOImpl() {
		new DataBaseBuilder();
		sql = DataBaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(CfMenuVO cfmevo) {
		int isUp = sql.insert(NS + "reg", cfmevo);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public List<CfMenuVO> selectList() {

		return sql.selectList(NS + "list");
	}

	@Override
	public CfMenuVO selectOne(String pno) {

		return sql.selectOne(NS + "detail", pno);
	}

	@Override
	public int update(CfMenuVO cfmvo) {
		int isUp = sql.update(NS + "mod", cfmvo);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public int delect(String pno) {
		int isUp = sql.delete(NS + "del", pno);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public int change(CfMenuVO cfmevo) {

		int isUp = sql.update(NS + "change", cfmevo);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

}
