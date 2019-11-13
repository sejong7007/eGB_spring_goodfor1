package com.goodfor.web.enums;

public enum SQL {
	CREATE_CUSTOMER, DROP_CUSTOMER, CREATE_DB, CREATE_ADMIN, DROP_ADMIN,
	CREATE_COMMT, DROP_COMMT, CREATE_ARTICLE, DROP_ARTICLE;
	@Override
	public String toString() {
		String result = "";
		switch(this) {
		case CREATE_CUSTOMER :
			result = "CREATE TABLE GOODFOR.CUSTOMER(" + 
					 "                    MID VARCHAR(10) PRIMARY KEY,\r\n" + 
					 "                    MPW VARCHAR(10) NOT NULL,\r\n" + 
					 "                    MNAME VARCHAR(4) NOT NULL,\r\n" + 
					 "                    EMAIL VARCHAR(30),\r\n" + 
					 "                    PHONENUM VARCHAR(15),\r\n" + 
					 "                    BIRTH VARCHAR(6),\r\n" + 
					 "                    TOOJA VARCHAR(1),\r\n" + 
					 "                    REGISTER_DATE VARCHAR(15),\r\n" + 
					 "                    TIER VARCHAR(1))";
			break;
		case DROP_CUSTOMER : 
			result = "DROP TABLE GOODFOR.CUSTOMER";
			break;
		
		case CREATE_ADMIN :
			result = "CREATE TABLE GOODFOR.ADMIN("+ 
				 	 "	  AID VARCHAR(10) NOT NULL,\r\n" + 
					 "    APW VARCHAR(10) NOT NULL,\r\n" + 
					 "    ANAME VARCHAR(4) NOT NULL,\r\n" + 
					 "    ANUM VARCHAR(6) PRIMARY KEY,\r\n" + 
					 "    ARANK VARCHAR(5),\r\n" + 
					 "    EMAIL VARCHAR(30),\r\n" + 
					 "    PHONENUM VARCHAR(11)) ";
			break;
		case DROP_ADMIN : 
			result = "DROP TABLE GOODFOR.ADMIN";
			break;
		case CREATE_DB :
			result = "CREATE DATABASE GOODFORDB";
			break;
		case CREATE_COMMT :
			result = "CREATE TABLE GOODFOR.COMMUNITY(\r\n" + 
					"	SEQNO INT(4) PRIMARY KEY AUTO_INCREMENT,\r\n" + 
					"	MID VARCHAR(10) NOT NULL,\r\n" + 
					"	MNAME VARCHAR(4) NOT NULL,\r\n" + 
					"	MEMO VARCHAR(300),\r\n" + 
					"	UPLOADFILE VARCHAR(30))";
			break;
		case DROP_COMMT:
			result = "DROP TABLE GOODFOR.COMMUNITY";
			break;
		case CREATE_ARTICLE:
			result = "CREATE TABLE ARTICLE(\r\n"
	                   + "ARTSEQ INT AUTO_INCREMENT PRIMARY KEY,\r\n"
	                   + "MID VARCHAR(30)  REFERENCES CUSTOMER,\r\n"
	                   + "BOARDTYPE VARCHAR(50),\r\n"
	                   + "TITLE VARCHAR(100),\r\n"
	                   + "UPLOADFILE VARCHAR(30),\r\n"
	                   + "CONTENT VARCHAR(200))";
			break;
		case DROP_ARTICLE:
			result = "DROP TABLE GOODFOR.ARTICLE";
			break;
		}
		return result;
	}

}

/**"CREATE TABLE GOODFOR.COMMUNITY(\r\n" + 
"	SEQNO INT(4) PRIMARY KEY AUTO_INCREMENT,\r\n" + 
"	MID VARCHAR(10) NOT NULL,\r\n" + 
"	BRDTYPE VARCHAR(10) NOT NULL,\r\n" + 
"	TITLE VARCHAR(50),\r\n" + 
"	CONTENT VARCHAR(300),\r\n" + 
"	UPLOADFILE VARCHAR(30))"*/