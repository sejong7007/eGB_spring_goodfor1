package com.goodfor.web.brd;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goodfor.web.enums.SQL;
import com.goodfor.web.pxy.Box;
import com.goodfor.web.pxy.Trunk;

@RestController
@RequestMapping("/community")
public class CommunityCtrl {

	private static final Logger logger = LoggerFactory.getLogger(Community.class);
	
	@Autowired ArticleMapper artMapper;
	@Autowired Box<Article> box;
	@Autowired Trunk<Object> map;
	
	@GetMapping("/create/table")
    public Map<?,?> createdb(){
    	HashMap<String, String> paramMap = new HashMap<>();
    	paramMap.put("CREATE_COMMT", SQL.CREATE_COMMT.toString());
    	System.out.println("Community table 생성 쿼리 : \n"+paramMap.get("CREATE_COMMT"));
    	Consumer<HashMap<String, String>> c = t -> artMapper.createCommunity(t);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg", "SUCCESS");
		return paramMap;
    }
    
    @GetMapping("/drop/table")
    public Map<?,?> dropCustomer(){
    	HashMap<String, String> paramMap = new HashMap<>();
    	paramMap.put("DROP_COMMT", SQL.DROP_COMMT.toString());
    	System.out.println("Community table 삭제 쿼리 : \n"+paramMap.get("DROP_COMMT"));
    	Consumer<HashMap<String, String>> c = t -> artMapper.dropCommunity(t);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg", "SUCCESS");
		return paramMap;
    }
	
}
