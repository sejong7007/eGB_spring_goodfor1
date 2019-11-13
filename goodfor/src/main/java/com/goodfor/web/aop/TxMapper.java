package com.goodfor.web.aop;

import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.goodfor.web.brd.Article;
import com.goodfor.web.customer.Customer;

@Repository
public interface TxMapper {
	
	@Insert("INSERT INTO CUSTOMER (MID, MPW, MNAME, EMAIL, PHONENUM, BIRTH, TOOJA, REGISTER_DATE, TIER )\n" + 
			"        VALUES ( #{mid}, #{mpw}, #{mname}, #{email}, #{phonenum}, #{birth}, #{tooja}, #{registerDate}, #{tier}")
	public void insertCustomer(Customer c);
	//artseq, title, content, mid, boardtype, uploadfile
	
	@Insert("INSERT INTO ARTICLE (ARTSEQ, MID, BOARDTYPE, TITLE, UPLOADFILE, CONTENT)\n"+
				"VALUES (#{artseq}, #{mid}, #{boardtype}, #{title}, #{uploadfile}, #{content})")
	public void insertArticle(Article a);
	
}


