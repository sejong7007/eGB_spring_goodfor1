package com.goodfor.web.brd;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.goodfor.web.pxy.PageProxy;

@Repository
public interface ArticleMapper {

	public void insertArticle(Article param);
	public String countArticle();
	public List<Article> selectAll(PageProxy pxy);
	public void deleteById(Article param);
	public void updateByArtseq(Article param);
	public void createCommunity(HashMap<String, String> paramMap);
	public void dropCommunity(HashMap<String, String> paramMap);
	
}
