package com.goodfor.web.aop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goodfor.web.customer.Customer;
import com.goodfor.web.customer.CustomerMapper;
import com.goodfor.web.pxy.Proxy;


@Service
public class TxService {

	@Autowired TxMapper txmapper;
	@Autowired CustomerMapper cusmapper;
	@Autowired Proxy pxy;
	//@Autowired List<String> txServiceList;

	@SuppressWarnings("unchecked")
	public List<?> crawling(Map<?,?> paramMap){
		List<String> txServiceList = new ArrayList<>();
		txServiceList.clear();
		txServiceList = (List<String>) pxy.crawl(paramMap);
		return null;		
	}
	
	@Transactional
	public int registerUsers() {
		List<Customer> list = new ArrayList<>();
		for(Customer c : list) {
			txmapper.insertCustomer(c);
		}
		return cusmapper.countCustomer();
	}
	
}
