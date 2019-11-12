package com.goodfor.web.customer;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goodfor.web.enums.SQL;


@RestController
@RequestMapping("/customer")

public class CustomerCtrl {

	private static final Logger logger = LoggerFactory.getLogger(CustomerCtrl.class);
	@Autowired Map<String , Object> map;
	@Autowired Customer cus;
	@Autowired CustomerMapper customerMapper;

	@GetMapping("/{mid}/checkId")
	public Map<?,?> checkId(@PathVariable String mid){
		Function<String, Integer> p = o -> customerMapper.existId(mid);
		map.clear();
		map.put("msg", (p.apply(mid)==0) ? "SUCCESS" : "FAIL");
		return map;
	}
	
	
	@PostMapping("/")
	public Map<?,?> join(@RequestBody Customer param) {
		logger.info("AJAX가 보낸 아이디와 비번{}",param.getMid() +", "+param.getMpw()+", "+param.getMname());
		Consumer<Customer> c = t -> customerMapper.insertCustomer(param);
		c.accept(param);
		map.clear();
		map.put("msg", "SUCCESS");
		return map;
	}
	
    @PostMapping("/{mid}")
    public Customer login(@PathVariable String mid, @RequestBody Customer param) {
         Function<Customer, Customer> f = t -> customerMapper.selectByIdPw(param);
         return f.apply(param);
    }
    
    @GetMapping("/{mid}")
    public Customer searchCustomerById(@PathVariable String mid, @RequestBody Customer param) {
    	Function<Customer, Customer> f = t -> customerMapper.selectByIdPw(param);
        return f.apply(param);
    }

    @PutMapping("/{mid}")
    public Customer updateCustomerById(@PathVariable String mid, @RequestBody Customer param) {
    	Function<Customer, Customer> f = t -> customerMapper.selectByIdPw(param);
        return f.apply(param);
    }
    
    @DeleteMapping("/{mid}")
    public Customer deleteCustomerById(@PathVariable String mid, @RequestBody Customer param) {
    	Function<Customer, Customer> f = t -> customerMapper.selectByIdPw(param);
        return f.apply(param);
    }
    
    @GetMapping("/create/table")
    public Map<?,?> createCustomer(){
    	HashMap<String, String> paramMap = new HashMap<>();
    	paramMap.put("CREATE_CUSTOMER", SQL.CREATE_CUSTOMER.toString());
    	System.out.println("테이블 생성 쿼리 : \n"+paramMap.get("CREATE_CUSTOMER"));
    	Consumer<HashMap<String, String>> c = t -> customerMapper.createCustomer(t);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg", "SUCCESS");
		return paramMap;
    }
    
    @GetMapping("/create/db")
    public Map<?,?> createdb(){
    	HashMap<String, String> paramMap = new HashMap<>();
    	paramMap.put("CREATE_DB", SQL.CREATE_DB.toString());
    	System.out.println("DB 생성 쿼리 : \n"+paramMap.get("CREATE_DB"));
    	Consumer<HashMap<String, String>> c = t -> customerMapper.createCustomer(t);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg", "SUCCESS");
		return paramMap;
    }
    
    @GetMapping("/drop/table")
    public Map<?,?> dropCustomer(){
    	HashMap<String, String> paramMap = new HashMap<>();
    	paramMap.put("DROP_CUSTOMER", SQL.DROP_CUSTOMER.toString());
    	System.out.println("테이블 삭제 쿼리 : \n"+paramMap.get("DROP_CUSTOMER"));
    	Consumer<HashMap<String, String>> c = t -> customerMapper.dropCustomer(t);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg", "SUCCESS");
		return paramMap;
    }
    
}





