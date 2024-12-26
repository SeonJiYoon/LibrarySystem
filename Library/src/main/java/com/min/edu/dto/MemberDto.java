package com.min.edu.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto implements Serializable{

	private static final long serialVersionUID = 5257288610890270622L;
	
	private int member_id;
	private String name;
	private String id;
	private String password;
	private String tel;
	private String is_enabled;
	private String auth;
	
	public MemberDto(String name, String id, String password, String tel, String is_enabled) {
		super();
		this.name = name;
		this.id = id;
		this.password = password;
		this.tel = tel;
		this.is_enabled = is_enabled;
	}
	
	

}
