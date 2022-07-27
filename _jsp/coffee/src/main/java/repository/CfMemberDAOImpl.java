package repository;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.CfMemberVO;
import orm.DataBaseBuilder;

public class CfMemberDAOImpl implements CfMemberDAO {
	private static Logger log = LoggerFactory.getLogger(CfMemberDAOImpl.class);
	private SqlSession sql;
	private final String NS = "CfMemberMapper.";
	
	public CfMemberDAOImpl() {
		new DataBaseBuilder();
		sql = DataBaseBuilder.getFactory().openSession();
	}
	@Override
	public int insert(CfMemberVO cfmvo) {
		int isUp = sql.insert(NS+"reg", cfmvo);
		if(isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public CfMemberVO idcheck(String id) {
		
		return sql.selectOne(NS+"check", id);
	}

	@Override
	public CfMemberVO selectOne(String id) {

		return sql.selectOne(NS+"det", id);
	}
	@Override
	public CfMemberVO selectOne(CfMemberVO cfmvo) {
		
		return sql.selectOne(NS+"login", cfmvo);
	}
	@Override
	public int update(CfMemberVO cfmvo) {
		log.info("id : {}" , cfmvo.getId());
		log.info("tel : {}" , cfmvo.getTel());
		int isUp = sql.update(NS+"mod",cfmvo);
		if(isUp > 0) {
			sql.commit();
		}
		return isUp;
	}
	@Override
	public int delect(String id) {
		int isUp = sql.delete(NS+"del",id);
		if(isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

}
