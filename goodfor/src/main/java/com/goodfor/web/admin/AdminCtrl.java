package com.goodfor.web.admin;

import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goodfor.web.enums.SQL;


@RestController
@RequestMapping("/admins")
public class AdminCtrl {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(AdminCtrl.class);
	
	@Autowired Map<String, Object> map;
	@Autowired Admin admin;
	@Autowired AdminMapper adMapper;
	
	@PostMapping("/{aid}")
	public Map<?,?> access(@PathVariable String aid, @RequestBody Admin param){
		System.out.println("들어옴.");
		Function<Admin, Admin> f = t -> adMapper.selectByIdPw(param);
		System.out.println(param.getAid());
		String result = (f.apply(param)!=null)?"SUCCESS":"FAIL";
		map.clear();
		map.put("msg", result);
		return map;
	}
	
	
	@GetMapping("/create/table")
    public Map<?,?> createAdmin(){
    	HashMap<String, String> paramMap = new HashMap<>();
    	paramMap.put("CREATE_ADMIN", SQL.CREATE_ADMIN.toString());
    	System.out.println("테이블 생성 쿼리 : \n"+paramMap.get("CREATE_ADMIN"));
    	Consumer<HashMap<String, String>> c = t -> adMapper.createAdmin(t);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg", "SUCCESS");
		return paramMap;
    }
	
	@GetMapping("/drop/table")
    public Map<?,?> dropAdmin(){
    	HashMap<String, String> paramMap = new HashMap<>();
    	paramMap.put("DROP_ADMIN", SQL.DROP_ADMIN.toString());
    	System.out.println("테이블 삭제 쿼리 : \n"+paramMap.get("DROP_ADMIN"));
    	Consumer<HashMap<String, String>> c = t -> adMapper.dropAdmin(t);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg", "SUCCESS");
		return paramMap;
    }
	
	
}
