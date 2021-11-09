package com.hiepDH7.SpingBootService1.controller;



import org.springframework.stereotype.Component;

@Component
public class Library {
	private String BOOK_NAME;
	private String ID;
	private String ISBN;
	private int AISLE;
	private String AUTHOR;
	public String getBOOK_NAME() {
		return BOOK_NAME;
	}
	public void setBOOK_NAME(String bOOK_NAME) {
		BOOK_NAME = bOOK_NAME;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public int getAISLE() {
		return AISLE;
	}
	public void setAISLE(int aISLE) {
		AISLE = aISLE;
	}
	public String getAUTHOR() {
		return AUTHOR;
	}
	public void setAUTHOR(String aUTHOR) {
		AUTHOR = aUTHOR;
	}
	
}
