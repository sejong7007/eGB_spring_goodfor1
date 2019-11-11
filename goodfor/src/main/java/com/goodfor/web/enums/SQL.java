package com.goodfor.web.enums;

public enum SQL {
	CREATE_CUSTOMER, DROP_CUSTOMER, CREATE_DB, CREATE_ADMIN, DROP_ADMIN ;
	@Override
	public String toString() {
		String result = "";
		switch(this) {
		case CREATE_CUSTOMER :
			result = "CREATE TABLE GOODFOR.CUSTOMER() ";
			break;
		case DROP_CUSTOMER : 
			result = "DROP TABLE GOODFOR.CUSTOMER";
			break;
		
		case CREATE_ADMIN :
			result = "CREATE TABLE GOODFOR.ADMIN("+ 
				 	 "	  AID VARCHAR(10) NOT NULL,\r\n" + 
					 "    APW VARCHAR(10) NOT NULL,\r\n" + 
					 "    ANAME VARCHAR(4) NOT NULL,\r\n" + 
					 "    ANUM INT(6) PRIMARY KEY,\r\n" + 
					 "    ARANK VARCHAR(5),\r\n" + 
					 "    EMAIL VARCHAR(30),\r\n" + 
					 "    PHONENUM INT(11)) ";
			break;
		
		case DROP_ADMIN : 
			result = "DROP TABLE GOODFOR.ADMIN";
			break;
		case CREATE_DB :
			result = "CREATE DATABASE GOODFORDB";
			break;
		}
		return result;
	}

}
