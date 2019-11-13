package com.goodfor.web.aop;

import java.util.Arrays;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goodfor.web.pxy.Box;
import com.goodfor.web.pxy.CrawlingProxy;
import com.goodfor.web.pxy.Trunk;
import com.goodfor.web.utl.Printer;

@RestController
@Transactional
@RequestMapping("/txctrls")
public class TxController {
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(TxController.class);
	
	@Autowired Map<String, Object> txctrlMap;
	@Autowired TxService txService;
	@Autowired Trunk<String> trunk;
	@Autowired CrawlingProxy crawler;
	@Autowired Box<String> box;
	@Autowired Printer p;
	
	@GetMapping("/{site}/{srch}")
	public Map<?,?> goGoogle(@PathVariable String site, @PathVariable String srch){
		
		System.out.println(site+" , "+srch);
		
		txctrlMap.clear();
		txctrlMap.put("site", site);
		txctrlMap.put("srch", srch);
		txctrlMap.put("msg", "SUCCESS");
		txService.crawling(txctrlMap);
		
		return txctrlMap;
	}
	
	@GetMapping("/register/users")
	public Map<?,?> resisterUsers () {
		int userCount = txService.registerUsers();
		trunk.put(Arrays.asList("userCount"),Arrays.asList(crawler.string(userCount)));
		
		return trunk.get() ;
	}
	
	@GetMapping("/write/texts")
	public Map<?,?> writeComm () {
		int userCount = txService.writeComm();
		trunk.put(Arrays.asList("userCount"),Arrays.asList(crawler.string(userCount)));
		
		return trunk.get() ;
	}
	
	@GetMapping("/write/article")
	public Map<?,?> writeArticle () {
		String articleCount = txService.writeArticles();
		p.accept("서비스 카운팅 : "+articleCount);
		trunk.put(Arrays.asList("articleCount"),Arrays.asList(crawler.string(articleCount)));
		return trunk.get() ;
	}

}
