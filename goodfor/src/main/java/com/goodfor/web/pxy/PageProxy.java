package com.goodfor.web.pxy;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import com.goodfor.web.brd.ArticleMapper;
import com.goodfor.web.utl.Printer;
import lombok.Data;

@Component("pager")
@Data
@Lazy
public class PageProxy extends Proxy {
	
	private int pageNum, pageSize, startRow, endRow, startPage, endPage, 
				nextPage, prePage, totalCount, pageCount, blockCount, blockNum;
	private boolean existPrev, existNext;
	private final int BLOCK_SIZE = 5;
	private List<Integer> pages;
	private String search;
	@Autowired Printer p;
	@Autowired ArticleMapper artMapper;
	
	public void paging() {
		Supplier<String> s = ()-> artMapper.countArticle();
		totalCount = Integer.parseInt(s.get());
		pageCount = (totalCount%pageSize==0)? totalCount/pageSize : (totalCount/pageSize)+1 ;
		startRow = (pageNum-1) * pageSize ;
		endRow = (pageNum == pageCount) ? totalCount-1 : startRow + pageSize-1 ;
		blockCount = (pageCount%BLOCK_SIZE==0)? pageCount/BLOCK_SIZE : (pageCount/BLOCK_SIZE)+1 ;
		blockNum = (pageNum-1) / BLOCK_SIZE;
		startPage = blockNum * BLOCK_SIZE + 1 ;
		endPage = (blockCount != (blockNum+1))? startPage + BLOCK_SIZE - 1 : pageCount ;
		existPrev = (blockNum!=0);
		existNext = ((blockNum+1)!=blockCount);
		nextPage = startPage+BLOCK_SIZE;
		prePage = startPage-BLOCK_SIZE;
		
	}
	
}
