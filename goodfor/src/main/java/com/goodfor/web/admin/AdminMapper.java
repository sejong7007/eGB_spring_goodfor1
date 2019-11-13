package com.goodfor.web.admin;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {

	public int countAdmin();

	public Admin selectByIdPw(Admin param);
	public void createAdmin(HashMap<String, String> paramMap);
	public void dropAdmin(HashMap<String, String> paramMap);

	public void insertAdmin(Admin param);
	
}
