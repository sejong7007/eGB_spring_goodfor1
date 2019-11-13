package com.goodfor.web.pxy;

import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.goodfor.web.enums.Path;
import com.goodfor.web.utl.Printer;

@Component("Crawler")
public class CrawlingProxy extends Proxy {
	@Autowired Printer p;
	@Autowired Box<String> box;
	public Box<String> crawl(Map<?,?> paramMap){
		switch (string(paramMap.get("srch"))) {
		case "테스트":
			box = crawling(Path.CRAWLING_TAGET.toString());
			break;
		case "테스트2":
			crawling(Path.CRAWLING_TAGET2.toString());
			break;
		default:
			crawling("http://"+paramMap.get("site")+".co.kr");
			break;
		}
		
		return box;
	}

	private Box<String> crawling(String url) {
		box.clear();
		try {
			Document rawData = Jsoup.connect(url).timeout(10 * 1000).get();
			Elements artist = rawData.select("div[class=box_type_l]");
			for (Element e : artist) {
				box.add(e.text() + "\n ====== \n");
				p.accept(box+"\n === \n");
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return box;
	}
}
