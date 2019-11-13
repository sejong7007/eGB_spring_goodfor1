package com.goodfor.web.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class OthersTest {

	public static void main(String[] args) {
		
			List<String> newtitle = new ArrayList<>();
			List<String> newitem1 = new ArrayList<>();
			String url = "https://finance.naver.com/sise/sise_rise.nhn";
			try {
				Document rawData = Jsoup.connect(url).timeout(10*1000).get();
				Elements titles = rawData.select("a[class=tltle]");
				Elements item1 = rawData.select("span[class=tah p11 red01]");
				for(Element e : titles) {
					newtitle.add(e.text());
				}
				for(Element e : item1) {
					newitem1.add(e.text());
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
			for( int i=0; i< newtitle.size();i++) {
			System.out.println(newtitle.get(i)+" , "+newitem1.get(i));
			}
			
			
			
			
			
	}
}
