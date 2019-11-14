package com.goodfor.web.enums;

public enum Path {
	UPLOAD_PATH, CRAWLING_TAGET, CRAWLING_TAGET2;
	
	@Override
	public String toString() {
		String result = "";
		switch(this) {
		case UPLOAD_PATH :
			result = "//C:\\Users\\User\\git\\eGB_spring_goodfor1\\goodfor\\src\\main\\webapp\\resources\\upload\\";
			break;
		case CRAWLING_TAGET :
			result = "https://store.naver.com/accommodations/detail?entry=plt&id=1285629759&tab=bookingReview&tabPage=0";
			break;
		case CRAWLING_TAGET2 :
			result = "https://finance.naver.com/sise/sise_rise.nhn";
			break;
		}
		return result;
	}
}
