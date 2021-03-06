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

import com.goodfor.web.pxy.Trunk;

@RestController
@Transactional
@RequestMapping("/txctrls")
public class TxController {
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(TxController.class);
	
	@Autowired Map<String, Object> txctrlmap;
	@Autowired TxService txservice;
	@Autowired Trunk<Object> map;
	
	@GetMapping("/{site}/{srch}")
	public Map<?,?> goGoogle(@PathVariable String site, @PathVariable String srch){
		
		System.out.println(site+" , "+srch);
		
		txctrlmap.clear();
		txctrlmap.put("site", site);
		txctrlmap.put("srch", srch);
		txctrlmap.put("msg", "SUCCESS");
		txservice.crawling(txctrlmap);
		
		return txctrlmap;
		
	}
	
	@GetMapping("/register/users")
	public Map<?,?> resisterUsers () {
		int userCount = txservice.registerUsers();
		map.put(Arrays.asList("userCount"),Arrays.asList(userCount));
		return map.get() ;
	}
	
	@GetMapping("/register/admins")
	public Map<?,?> resisterAdmin () {
		int userCount = txservice.registerAdmins();
		map.put(Arrays.asList("userCount"),Arrays.asList(userCount));
		return map.get() ;
	}

}
