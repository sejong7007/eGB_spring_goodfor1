package com.goodfor.web.enums;

public enum SQL {
	CREATE_CUSTOMER, DROP_CUSTOMER, CREATE_DB, CREATE_ADMIN, DROP_ADMIN,
	CREATE_COMMT, DROP_COMMT;
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
			result = "CREATE TABLE GOODFOR.COMMUNITY(" + 
					 " SEQ VARCHAR(10) PRIMARY KEY,\r\n" + 
					 " MID VARCHAR(10) NOT NULL,\r\n" + 
					 " MNAME VARCHAR(4) NOT NULL,\r\n" + 
					 " EMAIL VARCHAR(30),\r\n" + 
					 " PHONENUM VARCHAR(15),\r\n" + 
					 " BIRTH VARCHAR(6),\r\n" + 
					 " TOOJA VARCHAR(1),\r\n" + 
					 " REGISTER_DATE VARCHAR(15),\r\n" + 
					 " TIER VARCHAR(1))";
			break;
		case DROP_COMMT : 
			result = "DROP TABLE GOODFOR.COMMUNITY";
			break;
		}
		return result;
	}

}
