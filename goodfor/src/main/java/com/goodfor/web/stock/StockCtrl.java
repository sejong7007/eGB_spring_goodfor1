package com.goodfor.web.stock;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.goodfor.web.brd.ArticleCtrl;
import com.goodfor.web.enums.SQL;
import com.goodfor.web.utl.Printer;

@RestController
@RequestMapping("/stock")
public class StockCtrl {
	
	private static final Logger logger = LoggerFactory.getLogger(ArticleCtrl.class);
	
	@Autowired StockMapper stockMapper;
	@Autowired Printer p;
	
	@GetMapping("/create/stock")
    public Map<?,?> createStock(){
		p.accept("주식 테이블 생성 들어옴");
    	HashMap<String, String> paramMap = new HashMap<>();
    	paramMap.put("CREATE_STOCK", SQL.CREATE_STOCK.toString());
    	System.out.println("CREATE_STOCK table 생성 쿼리 : \n"+paramMap.get("CREATE_STOCK"));
    	Consumer<HashMap<String, String>> c = t -> stockMapper.createStock(t);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg", "SUCCESS");
		return paramMap;
    }
	
	@GetMapping("/drop/stock")
    public Map<?,?> dropStock(){
    	HashMap<String, String> paramMap = new HashMap<>();
    	paramMap.put("DROP_STOCK", SQL.DROP_STOCK.toString());
    	System.out.println("DROP_STOCK table 생성 쿼리 : \n"+paramMap.get("DROP_STOCK"));
    	Consumer<HashMap<String, String>> c = t -> stockMapper.dropStock(t);
		c.accept(paramMap);
		paramMap.clear();
		paramMap.put("msg", "SUCCESS");
		return paramMap;
    }
}
