package com.goodfor.web.brd;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Lazy
@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Article {

	private String artseq, title, content, mid, artType ;
	
}
