package net.choice.db;

import java.sql.Timestamp;

import oracle.sql.DATE;

public class ChoiceBean {
	private int CHOICE_NUM;
	private int CHOICE_GALLERY_NUM;
	private String CHOICE_ID;
	private int CHOICE_READCOUNT;
	private Timestamp CHOICE_DATE;  
	
	
	
	//get
	public int getCHOICE_NUM() {
		return CHOICE_NUM;
	}
	public int getCHOICE_GALLERY_NUM() {
		return CHOICE_GALLERY_NUM;
	}
	
	public String getCHOICE_ID() {
		return CHOICE_ID;
	}
	
	public int getCHOICE_READCOUNT() {
		return CHOICE_READCOUNT;
	}
	
	public Timestamp getCHOICE_DATE() {
		return CHOICE_DATE;
	}
	
	//set  
	public void setCHOICE_NUM(int cHOICE_NUM) {
		CHOICE_NUM = cHOICE_NUM;
	}
	public void setCHOICE_GALLERY_NUM(int cHOICE_CUSTOM_NUM) {
		CHOICE_GALLERY_NUM = cHOICE_CUSTOM_NUM;
	}
	
	public void setCHOICE_ID(String cHOICE_ID) {
		CHOICE_ID = cHOICE_ID;
	}
	
	public void setCHOICE_READCOUNT(int cHOICE_READCOUNT) {
		CHOICE_READCOUNT = cHOICE_READCOUNT;
	}
	public void setCHOICE_DATE(Timestamp cHOICE_DATE) {
		CHOICE_DATE = cHOICE_DATE;
	}
	
	
	
	
	
}
