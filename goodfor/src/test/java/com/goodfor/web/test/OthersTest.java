package com.goodfor.web.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class OthersTest {

	public static void main(String[] args) {
		
		List<String> proxyList = new ArrayList<>();
        List<String> artist2 = new ArrayList<>();
        List<String> artist4 = new ArrayList<>();
        HashMap<String,String> artist5 = new HashMap<>();
        String url = "https://finance.naver.com/sise/sise_rise.nhn";
        //String url = "https://store.naver.com/accommodations/detail?entry=plt&id=1285629759&tab=bookingReview&tabPage=0";
        proxyList.clear();
        try {
            Document rawData = Jsoup.connect(url).timeout(10*1000).get();
            Elements artist = rawData.select("a[class=tltle]");
            for(Element e : artist) {
                artist2.add(e.text());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        
        try {
            Document rawData1 = Jsoup.connect(url).timeout(10*1000).get();
            Elements artist3 = rawData1.select("span[class=tah p11 red01]");
            for(Element e : artist3) {
                artist4.add(e.text());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        for(int i=0; i<10; i++) {
        	artist5.put(artist2.get(i), artist4.get(i));
        	System.out.println(artist5);
        }
        
//        System.out.println("종목명 ="+artist2.get(0)+", 상승률 ="+artist4.get(0));
        /**HashMap<List<String>,List<String>> hashmap = new HashMap<>();
        hashmap.put(artist2, artist4);
        System.out.println(hashmap.toString());*/
	}
}
