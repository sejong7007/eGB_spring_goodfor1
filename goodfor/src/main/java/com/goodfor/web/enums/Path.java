package com.goodfor.web.enums;

public enum Path {

	UPLOAD_PATH;
	
	@Override
	public String toString() {
		String result = "";
		switch(this) {
		case UPLOAD_PATH :
			result = "C:\\Users\\User\\Workspace_GB\\eGovFrameDev-3.8.0-64bit\\workspace\\goodfor\\src\\main\\webapp\\resources\\upload\\temp";
			break;
		}
		return result;
	}
	
}
