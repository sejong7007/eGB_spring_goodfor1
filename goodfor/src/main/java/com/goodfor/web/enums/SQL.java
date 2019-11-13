package com.goodfor.web.enums;

public enum SQL {
	CREATE_CUSTOMER, DROP_CUSTOMER, CREATE_DB, CREATE_ADMIN, DROP_ADMIN,
	CREATE_COMMT, DROP_COMMT, CREATE_ARTICLE, DROP_ARTICLE, CREATE_STOCK, DROP_STOCK;
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
		case CREATE_STOCK:
			result = "CREATE TABLE GOODFOR.STOCK( \r\n" + 
					"STOCKNAME VARCHAR(20) NOT NULL,\r\n" + 
					"STOCKCODE INT PRIMARY KEY,\r\n" + 
					"CURRENTPRICE INT(15) NOT NULL,\r\n" + 
					"CLOSINGPRICE INT(15) NOT NULL,\r\n" + 
					"PREVIOUSCLOSINGPRICE INT(15) NOT NULL,\r\n" + 
					"NETCHANGE INT(15) NOT NULL,\r\n" + 
					"CHANGERATIO INT(5) NOT NULL,\r\n" + 
					"MARKETPRICE INT(15) NOT NULL,\r\n" + 
					"HIGH INT(15) NOT NULL,\r\n" + 
					"LOW INT(15) NOT NULL,\r\n" + 
					"MAXPRICE INT(15) NOT NULL,\r\n" + 
					"MINPRICE INT(15) NOT NULL,\r\n" + 
					"VOLUME INT(15) NOT NULL,\r\n" + 
					"CLOSINGVOLUME INT(15) NOT NULL,\r\n" + 
					"TRADINGAMOUNT INT(15) NOT NULL,\r\n" + 
					"ASKPRICE INT(15) NOT NULL,\r\n" + 
					"BIDPRICE INT(15) NOT NULL,\r\n" + 
					"CLOSINGHIGH INT(15) NOT NULL,\r\n" + 
					"CLOSINGLOW INT(15) NOT NULL,\r\n" + 
					"PRICEEARNINGRATIO INT(5) NOT NULL,\r\n" + 
					"EARNINGPERSHARE INT(15) NOT NULL,\r\n" + 
					"CAPITAL INT(15) NOT NULL,\r\n" + 
					"ASKREMAINING INT(15) NOT NULL,\r\n" + 
					"BIDREMAINING INT(15) NOT NULL,\r\n" + 
					"REMAININGSUM INT(15) NOT NULL,\r\n" + 
					"CONCLUSIONTIME INT(5) NOT NULL,\r\n" + 
					"CONCLUSIONPRICE INT(15) NOT NULL,\r\n" + 
					"ASK INT(15) NOT NULL,\r\n" + 
					"BID INT(15) NOT NULL,\r\n" + 
					"FLUCTUATION INT(15) NOT NULL,\r\n" + 
					"DATE INT(15) NOT NULL,\r\n" + 
					"MARKETCAP INT(15) NOT NULL,\r\n" + 
					"MARKETCAPRANK INT(15) NOT NULL,\r\n" + 
					"NUMSTOCKLIST INT(15) NOT NULL,\r\n" + 
					"FACEVALUE INT(15) NOT NULL,\r\n" + 
					"FULLLOT INT(15) NOT NULL,\r\n" + 
					"PRICETARGET INT(15) NOT NULL,\r\n" + 
					"WEEKHIGH INT(15) NOT NULL,\r\n" + 
					"WEEKLOW INT(15) NOT NULL,\r\n" + 
					"FOREIGNLIMIT INT(15) NOT NULL,\r\n" + 
					"FOREIGNPOSSESSION INT(15) NOT NULL,\r\n" + 
					"FOREIGNEXHAUSTRATE INT(15) NOT NULL,\r\n" + 
					"FOREIGNAVAILABLE INT(15) NOT NULL,\r\n" + 
					"FOREIGNACQUISITION INT(15) NOT NULL,\r\n" + 
					"FOREIGNBID INT(15) NOT NULL,\r\n" + 
					"PRICELIMITS INT(15) NOT NULL,\r\n" + 
					"ASKINGPRICEUNIT INT(15) NOT NULL,\r\n" + 
					"SUBSTITUTEPRICE INT(15) NOT NULL,\r\n" + 
					"EXPECTEDVALUE INT(15) NOT NULL,\r\n" + 
					"EXPECTEDVOLUME INT(15) NOT NULL,\r\n" + 
					"PERMARKETCAPITALIZATION INT(15) NOT NULL,\r\n" + 
					"CONCLUSIONINDEX INT(15) NOT NULL,\r\n" + 
					"MID VARCHAR(10) REFERENCES CUSTOMER);";
			break;
		case DROP_STOCK:
			result = "DROP TABLE GOODFOR.STOCK";
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