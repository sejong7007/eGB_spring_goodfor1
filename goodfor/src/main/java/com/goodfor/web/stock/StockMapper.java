package com.goodfor.web.stock;

import java.util.HashMap;

public interface StockMapper {

	public void createStock(HashMap<String, String> t);

	public void dropStock(HashMap<String, String> t);

}
