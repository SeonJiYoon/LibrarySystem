package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.MemberDto;

public interface IMemberDao {

	public List<MemberDto> getAllUserStatus();

	public List<MemberDto> getAllUser();

	public Integer updateAuthUser(Map<String, Object> map);

	public Integer insertUser(MemberDto dto);

	public MemberDto getLogin(Map<String, Object> map);

	public MemberDto getUserInfo(String member_id);

	public Integer updateUserInfo(MemberDto dto);

	public Integer delUser(String member_id);

	public String duplicateId(String id);

}
