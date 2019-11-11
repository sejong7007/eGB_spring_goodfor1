package com.goodfor.web.customer;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository
public interface CustomerMapper {
	public void insertCustomer(Customer cus);
	public Customer selectByIdPw(Customer cus);
	public int existId(String s);
	public int countCustomer();
	public void createCustomer(HashMap<String, String> paramMap);
	public void dropCustomer(HashMap<String, String> paramMap);
	public void createdb(HashMap<String, String> paramMap);
}
