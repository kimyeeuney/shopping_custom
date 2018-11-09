package net.custom.db;

import java.sql.*;

public class OrderCustomBean {
	private int ORDER_CUSTOM_NUM;
	private int ORDER_CUSTOM1;
	private int ORDER_CUSTOM2;
	private String ORDER_CUSTOM3;
	private int ORDER_CUSTOM4;
	private int ORDER_CUSTOM5;
	private int ORDER_CUSTOM6;
	private int ORDER_CUSTOM7;
	private int ORDER_CUSTOM8;
	private int ORDER_CUSTOM9;
	private int ORDER_CUSTOM10;
	private int ORDER_CUSTOM11;
	private String ORDER_CUSTOM12;
	private String ORDER_CUSTOM13;
	private String ORDER_CUSTOM_ID;
	private String ORDER_CUSTOM_RECEIVE_NAME;
	private int ORDER_CUSTOM_ZIPCODE1;
	private int ORDER_CUSTOM_ZIPCODE2;
	private String ORDER_CUSTOM_RECEIVE_ADDR1;
	private String ORDER_CUSTOM_RECEIVE_ADDR2;
	private int ORDER_CUSTOM_RECEIVE_PHONE;
	private int ORDER_CUSTOM_RECEIVE_MOBILE;
	private String ORDER_CUSTOM_MEMO;
	private String ORDER_CUSTOM_TRADE_TYPE;
	private Timestamp ORDER_CUSTOM_TRADE_DATE;
	private int ORDER_CUSTOM_TRADE_PAYER;
	private int ORDER_CUSTOM_GALLERY;
	
	//get
	
	
	
	
	
	public int getORDER_CUSTOM_NUM() {
		return ORDER_CUSTOM_NUM;
	}
	public int getORDER_CUSTOM1() {
		return ORDER_CUSTOM1;
	}
	public int getORDER_CUSTOM2() {
		return ORDER_CUSTOM2;
	}
	public String getORDER_CUSTOM3() {
		return ORDER_CUSTOM3;
	}
	public int getORDER_CUSTOM4() {
		return ORDER_CUSTOM4;
	}
	public int getORDER_CUSTOM5() {
		return ORDER_CUSTOM5;
	}
	public int getORDER_CUSTOM6() {
		return ORDER_CUSTOM6;
	}
	public int getORDER_CUSTOM7() {
		return ORDER_CUSTOM7;
	}
	public int getORDER_CUSTOM8() {
		return ORDER_CUSTOM8;
	}
	public int getORDER_CUSTOM9() {
		return ORDER_CUSTOM9;
	}
	public int getORDER_CUSTOM10() {
		return ORDER_CUSTOM10;
	}
	public int getORDER_CUSTOM11() {
		return ORDER_CUSTOM11;
	}
	public String getORDER_CUSTOM12() {
		return ORDER_CUSTOM12;
	}
	public String getORDER_CUSTOM13() {
		return ORDER_CUSTOM13;
	}
	public String getORDER_CUSTOM_ID() {
		return ORDER_CUSTOM_ID;
	}
	public String getORDER_CUSTOM_RECEIVE_NAME() {
		return ORDER_CUSTOM_RECEIVE_NAME;
	}
	public int getORDER_CUSTOM_ZIPCODE1() {
		return ORDER_CUSTOM_ZIPCODE1;
	}
	public int getORDER_CUSTOM_ZIPCODE2() {
		return ORDER_CUSTOM_ZIPCODE2;
	}
	public String getORDER_CUSTOM_RECEIVE_ADDR1() {
		return ORDER_CUSTOM_RECEIVE_ADDR1;
	}
	public String getORDER_CUSTOM_RECEIVE_ADDR2() {
		return ORDER_CUSTOM_RECEIVE_ADDR2;
	}
	public int getORDER_CUSTOM_RECEIVE_PHONE() {
		return ORDER_CUSTOM_RECEIVE_PHONE;
	}
	public int getORDER_CUSTOM_RECEIVE_MOBILE() {
		return ORDER_CUSTOM_RECEIVE_MOBILE;
	}
	public String getORDER_CUSTOM_MEMO() {
		return ORDER_CUSTOM_MEMO;
	}
	public String getORDER_CUSTOM_TRADE_TYPE() {
		return ORDER_CUSTOM_TRADE_TYPE;
	}
	public Timestamp getORDER_CUSTOM_TRADE_DATE() {
		return ORDER_CUSTOM_TRADE_DATE;
	}
	public int getORDER_CUSTOM_TRADE_PAYER() {
		return ORDER_CUSTOM_TRADE_PAYER;
	}
	
	public int getORDER_CUSTOM_GALLERY() {
		return ORDER_CUSTOM_GALLERY;
	}
	
	
	
	// set 
	
	
	public void setORDER_CUSTOM_NUM(int oRDER_CUSTOM_NUM) {
		ORDER_CUSTOM_NUM = oRDER_CUSTOM_NUM;
	}
	public void setORDER_CUSTOM1(int oRDER_CUSTOM1) {
		ORDER_CUSTOM1 = oRDER_CUSTOM1;
	}
	public void setORDER_CUSTOM2(int oRDER_CUSTOM2) {
		ORDER_CUSTOM2 = oRDER_CUSTOM2;
	}
	public void setORDER_CUSTOM3(String oRDER_CUSTOM3) {
		ORDER_CUSTOM3 = oRDER_CUSTOM3;
	}
	public void setORDER_CUSTOM4(int oRDER_CUSTOM4) {
		ORDER_CUSTOM4 = oRDER_CUSTOM4;
	}
	public void setORDER_CUSTOM5(int oRDER_CUSTOM5) {
		ORDER_CUSTOM5 = oRDER_CUSTOM5;
	}
	public void setORDER_CUSTOM6(int oRDER_CUSTOM6) {
		ORDER_CUSTOM6 = oRDER_CUSTOM6;
	}
	public void setORDER_CUSTOM7(int oRDER_CUSTOM7) {
		ORDER_CUSTOM7 = oRDER_CUSTOM7;
	}
	public void setORDER_CUSTOM8(int oRDER_CUSTOM8) {
		ORDER_CUSTOM8 = oRDER_CUSTOM8;
	}
	public void setORDER_CUSTOM9(int oRDER_CUSTOM9) {
		ORDER_CUSTOM9 = oRDER_CUSTOM9;
	}
	public void setORDER_CUSTOM10(int oRDER_CUSTOM10) {
		ORDER_CUSTOM10 = oRDER_CUSTOM10;
	}
	public void setORDER_CUSTOM11(int oRDER_CUSTOM11) {
		ORDER_CUSTOM11 = oRDER_CUSTOM11;
	}
	public void setORDER_CUSTOM12(String oRDER_CUSTOM12) {
		ORDER_CUSTOM12 = oRDER_CUSTOM12;
	}
	public void setORDER_CUSTOM13(String oRDER_CUSTOM13) {
		ORDER_CUSTOM13 = oRDER_CUSTOM13;
	}
	public void setORDER_CUSTOM_ID(String oRDER_CUSTOM_ID) {
		ORDER_CUSTOM_ID = oRDER_CUSTOM_ID;
	}
	public void setORDER_CUSTOM_RECEIVE_NAME(String oRDER_CUSTOM_RECEIVE_NAME) {
		ORDER_CUSTOM_RECEIVE_NAME = oRDER_CUSTOM_RECEIVE_NAME;
	}
	public void setORDER_CUSTOM_ZIPCODE1(int oRDER_CUSTOM_ZIPCODE1) {
		ORDER_CUSTOM_ZIPCODE1 = oRDER_CUSTOM_ZIPCODE1;
	}
	public void setORDER_CUSTOM_ZIPCODE2(int oRDER_CUSTOM_ZIPCODE2) {
		ORDER_CUSTOM_ZIPCODE2 = oRDER_CUSTOM_ZIPCODE2;
	}
	public void setORDER_CUSTOM_RECEIVE_ADDR1(String oRDER_CUSTOM_RECEIVE_ADDR1) {
		ORDER_CUSTOM_RECEIVE_ADDR1 = oRDER_CUSTOM_RECEIVE_ADDR1;
	}
	public void setORDER_CUSTOM_RECEIVE_ADDR2(String oRDER_CUSTOM_RECEIVE_ADDR2) {
		ORDER_CUSTOM_RECEIVE_ADDR2 = oRDER_CUSTOM_RECEIVE_ADDR2;
	}
	public void setORDER_CUSTOM_RECEIVE_PHONE(int oRDER_CUSTOM_RECEIVE_PHONE) {
		ORDER_CUSTOM_RECEIVE_PHONE = oRDER_CUSTOM_RECEIVE_PHONE;
	}
	public void setORDER_CUSTOM_RECEIVE_MOBILE(int oRDER_CUSTOM_RECEIVE_MOBILE) {
		ORDER_CUSTOM_RECEIVE_MOBILE = oRDER_CUSTOM_RECEIVE_MOBILE;
	}
	public void setORDER_CUSTOM_MEMO(String oRDER_CUSTOM_MEMO) {
		ORDER_CUSTOM_MEMO = oRDER_CUSTOM_MEMO;
	}
	public void setORDER_CUSTOM_TRADE_TYPE(String oRDER_CUSTOM_TRADE_TYPE) {
		ORDER_CUSTOM_TRADE_TYPE = oRDER_CUSTOM_TRADE_TYPE;
	}
	public void setORDER_CUSTOM_TRADE_DATE(Timestamp oRDER_CUSTOM_TRADE_DATE) {
		ORDER_CUSTOM_TRADE_DATE = oRDER_CUSTOM_TRADE_DATE;
	}
	public void setORDER_CUSTOM_TRADE_PAYER(int oRDER_CUSTOM_TRADE_PAYER) {
		ORDER_CUSTOM_TRADE_PAYER = oRDER_CUSTOM_TRADE_PAYER;
	}
	
	public void setORDER_CUSTOM_GALLERY(int oRDER_CUSTOM_GALLERY) {
		ORDER_CUSTOM_GALLERY = oRDER_CUSTOM_GALLERY;
	}
	
	
	
	
	
	
	
	
	
}
