package com.goodfor.web.pxy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.goodfor.web.brd.ArticleMapper;

@Component("commter")
public class CommtProxy extends Proxy{

	@Autowired ArticleMapper artMapper;
	
	//seqno, mid, mname, memo, uploadfile
	
	public String makeId(){
		List<String> cusid = Arrays.asList("aedn6", "afbw6", "bawz3", "bzqh0", "cnzt2");
		Collections.shuffle(cusid);		 
		String newId = cusid.get(0);
		return newId ;
	}

	
	
}
