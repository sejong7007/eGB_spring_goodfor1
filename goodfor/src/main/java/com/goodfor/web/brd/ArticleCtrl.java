package com.goodfor.web.brd;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.goodfor.web.enums.Path;
import com.goodfor.web.enums.SQL;
import com.goodfor.web.pxy.Box;
import com.goodfor.web.pxy.PageProxy;
import com.goodfor.web.pxy.Trunk;

@RestController
@RequestMapping("/articles")
public class ArticleCtrl {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ArticleCtrl.class);
	
	@Autowired Map<String, Object> Articlemap;
	@Autowired Article art;
	@Autowired ArticleMapper artMapper;
	@Autowired Box<Article> box;
	@Autowired PageProxy pager;
	@Autowired Trunk<Object> map;
	
		
	@PostMapping("/")
	public Map<?,?> writeArticle(@RequestBody Article param){
		Consumer<Article> c = t -> artMapper.insertArticle(param); 
		c.accept(param);
		Supplier<String> s = ()->artMapper.countArticle();
		map.put(Arrays.asList("msg","count"), Arrays.asList("SUCCESS", s.get()));
		return map.get();
	}
	
	@GetMapping("/page/{pageNo}/size/{pageSize}")
	public Map<?,?> listArt(@PathVariable String pageNo, @PathVariable String pageSize){
		System.out.println("넘어오는 값 : "+pageNo+" , "+pageSize);
		pager.setPageNum(pager.parseInt(pageNo));
		pager.setPageSize(pager.parseInt(pageSize));
		System.out.println("중간점검"+pager.getPageNum()+pager.getPageSize());
		pager.paging();
		//box.clear();
		Supplier<List<Article>> s = () -> artMapper.selectAll(pager);
		System.out.println("넘어가는 값 : "+pager.getPages());
		
		map.put(Arrays.asList("articles", "pxy"),
				   Arrays.asList(s.get(), pager)) ;
		return map.get();
	}
	
	@PutMapping("/")
	public Map<?,?> updateArticle(@RequestBody Article param){
		Consumer<Article> c = t -> artMapper.updateByArtseq(param);
		c.accept(param);
		map.put(Arrays.asList("msg"), Arrays.asList("SUCCESS"));
		return map.get();
	}
	
	@DeleteMapping("/")
	public Map<?,?> deleteArticle(@RequestBody Article param){
		Consumer<Article> c = t -> artMapper.deleteById(param);
		c.accept(param);
		map.put(Arrays.asList("msg"), Arrays.asList("SUCCESS"));
		return map.get();
	}
	
	@GetMapping("/countArt")
	public Map<?,?> countArt() {
		Supplier<String> s = () -> artMapper.countArticle();
		map.put(Arrays.asList("count"), Arrays.asList(s.get()));
		return map.get();
	}
	
	@GetMapping("/fileupload")
	public void fileUpload(MultipartFile[] uploadFile) {
		String uploadFolder = Path.UPLOAD_PATH.toString();
		for(MultipartFile f : uploadFile) {
			String fname = f.getOriginalFilename();
			fname = fname.substring(fname.lastIndexOf("\\"+1));
			File saveFile = new File(uploadFolder, fname);
			try {
				f.transferTo(saveFile);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}
	}
	
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
    
    /*@GetMapping("/fileupload")
    public void fileupload() {
    	
    }*/
	
}
