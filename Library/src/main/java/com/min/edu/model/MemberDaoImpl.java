package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import com.min.edu.dto.MemberDto;
import com.min.edu.support.SqlDaoSupport;

public class MemberDaoImpl implements IMemberDao {

	private Logger log = Logger.getLogger(this.getClass());
	private SqlSessionFactory manager = SqlDaoSupport.getFactory();
	private final String NS = "com.min.edu.model.MemberDaoImpl.";
	
	
	@Override
	public List<MemberDto> getAllUserStatus() {
		log.info("전체사용자 조회");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"getAllUserStatus");
	}

	@Override
	public List<MemberDto> getAllUser() {
		log.info("사용 가능한 사용자 조회");
		SqlSession session = manager.openSession();
		return session.selectList(NS+"getAllUser");
	}

	@Override
	public Integer updateAuthUser(Map<String, Object> map) {
		log.info("권한 수정 : " + map);
		SqlSession session = manager.openSession(true);
		return session.update(NS+"updateAuthUser", map);
	}

	@Override
	public Integer insertUser(MemberDto dto) {
		log.info("사용자 입력 : " + dto);
		SqlSession session = manager.openSession(true);
		return session.insert(NS+"insertUser", dto);
	}

	@Override
	public MemberDto getLogin(Map<String, Object> map) {
		log.info("로그인 : " + map);
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"getLogin", map);
	}

	@Override
	public MemberDto getUserInfo(String member_id) {
		log.info("사용자 상세 정보 : " + member_id);
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"getUserInfo", member_id);
	}

	@Override
	public Integer updateUserInfo(MemberDto dto) {
		log.info("사용자 정보 수정");
		SqlSession session = manager.openSession(true);
		return session.update(NS+"updateUserInfo", dto);
	}

	@Override
	public Integer delUser(String member_id) {
		log.info("사용자 삭제 : " + member_id);
		SqlSession session = manager.openSession(true);
		return session.update(NS+"delUser", member_id);
	}

	@Override
	public String duplicateId(String id) {
		log.info("아이디 중복 검사");
		SqlSession session = manager.openSession();
		return session.selectOne(NS+"duplicateId", id);
	}

}
