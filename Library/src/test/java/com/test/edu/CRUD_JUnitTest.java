package com.test.edu;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.min.edu.dto.MemberDto;
import com.min.edu.model.IMemberDao;
import com.min.edu.model.MemberDaoImpl;

public class CRUD_JUnitTest {

	private IMemberDao dao;
	
	public CRUD_JUnitTest() {
		dao = new MemberDaoImpl();
	}
	
//	@Test
	public void getAllUserStatus_Test(){
		List<MemberDto> lists = dao.getAllUserStatus();
		assertNotEquals(0, lists.size());
	}
	
//	@Test
	public void getAllUser_Test(){
		List<MemberDto> lists = dao.getAllUser();
		assertNotEquals(0, lists.size());
	}
	
	
	@SuppressWarnings("serial")
//	@Test
	public void updateAuthUser_Test(){
		Map<String, Object> map = new HashMap<String, Object>(){{put("auth", "ADMIN"); put("member_id", 2);}};
		int row = dao.updateAuthUser(map);
		assertEquals(1, row);
	}
	
//	@Test
	public void insertUser_Test(){
		MemberDto dto = new MemberDto("test", "test", "test", "000", "Y");
		int row = dao.insertUser(dto);
		assertEquals(1, row);
	}
	
//	@Test
	public void getLogin_Test(){
		Map<String, Object> map = new HashMap<String, Object>(){{put("id", "hong123"); put("password", "Passw0rd1");}};
		MemberDto dto = dao.getLogin(map);
		assertNotNull(dto);
	}
	
//	@Test
	public void getUserInfo_Test(){
		String member_id = "22";
		MemberDto dto = dao.getUserInfo(member_id);
		assertNotNull(dto);
	}
	
//	@Test
	public void updateUserInfo_Test(){
		MemberDto dto = new MemberDto().builder()
									   .password("updatepw")
									   .tel("updatetel")
									   .member_id(22)
									   .build();
		int row = dao.updateUserInfo(dto);
		assertEquals(1, row);
	}
	
//	@Test
	public void delUser_Test(){
		String member_id = "22";
		int row = dao.delUser(member_id);
		assertEquals(1, row);
	}
	
	@Test
	public void duplicateId_Test(){
		String idChk = "hong123";
		String returnId = dao.duplicateId(idChk);
		assertEquals(idChk, returnId);
	}

	


}
