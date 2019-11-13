package com.goodfor.web.aop;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.goodfor.web.brd.ArticleMapper;
import com.goodfor.web.customer.CustomerMapper;
import com.goodfor.web.pxy.ArticleProxy;
import com.goodfor.web.pxy.Box;
import com.goodfor.web.pxy.CrawlingProxy;
import com.goodfor.web.pxy.CustomerProxy;

@Service
public class TxService {

	@Autowired TxMapper txmapper;
	@Autowired CustomerMapper cusmapper;
	@Autowired CrawlingProxy crawlpxy;
	@Autowired CustomerProxy custer;
	@Autowired Box<String> box;
	@Autowired ArticleProxy artpxy;
	@Autowired ArticleMapper artMapper;
	

	public Box<String> crawling(Map<?,?> paramMap){
		return crawlpxy.crawl(paramMap);		
	}
	
	@Transactional
	public int registerUsers() {
		custer.insertCustomer();
		return cusmapper.countCustomer();
	}

	public int writeComm() {
		return 0;
	}
	
	public String writeArticles() {
		artpxy.insertArticle();
		return artMapper.countArticles();
	}
	
}
