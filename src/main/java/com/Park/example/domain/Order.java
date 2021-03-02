package com.Park.example.domain;

public class Order {

	private int o_idx;
	private String o_amount;
	private String o_sendname;
	private int o_sendphone;
	private String o_takename;
	private int o_takephone;
	private String o_takeaddress;
	private String o_title;
	private String o_pay;
	private int o_price;
	private int o_number;
	private String o_date;
	
	
	@Override
	public String toString() {
		return "Order [o_idx=" + o_idx + ", o_amount=" + o_amount + ", o_sendname=" + o_sendname + ", o_sendphone="
				+ o_sendphone + ", o_takename=" + o_takename + ", o_takephone=" + o_takephone + ", o_takeaddress="
				+ o_takeaddress + ", o_title=" + o_title + ", o_pay=" + o_pay + ", o_price=" + o_price + ", o_number="
				+ o_number + ", o_date=" + o_date + "]";
	}
	public int getO_idx() {
		return o_idx;
	}
	public void setO_idx(int o_idx) {
		this.o_idx = o_idx;
	}
	
	public String getO_amount() {
		return o_amount;
	}
	public void setO_amount(String o_amount) {
		this.o_amount = o_amount;
	}
	public String getO_sendname() {
		return o_sendname;
	}
	public void setO_sendname(String o_sendname) {
		this.o_sendname = o_sendname;
	}
	public int getO_sendphone() {
		return o_sendphone;
	}
	public void setO_sendphone(int o_sendphone) {
		this.o_sendphone = o_sendphone;
	}
	public String getO_takename() {
		return o_takename;
	}
	public void setO_takename(String o_takename) {
		this.o_takename = o_takename;
	}
	public int getO_takephone() {
		return o_takephone;
	}
	public void setO_takephone(int o_takephone) {
		this.o_takephone = o_takephone;
	}
	public String getO_takeaddress() {
		return o_takeaddress;
	}
	public void setO_takeaddress(String o_takeaddress) {
		this.o_takeaddress = o_takeaddress;
	}
	public String getO_title() {
		return o_title;
	}
	public void setO_title(String o_title) {
		this.o_title = o_title;
	}
	public String getO_pay() {
		return o_pay;
	}
	public void setO_pay(String o_pay) {
		this.o_pay = o_pay;
	}
	
	public int getO_price() {
		return o_price;
	}
	public void setO_price(int o_price) {
		this.o_price = o_price;
	}
	public int getO_number() {
		return o_number;
	}
	public void setO_number(int o_number) {
		this.o_number = o_number;
	}
	public String getO_date() {
		return o_date;
	}
	public void setO_date(String o_date) {
		this.o_date = o_date;
	}
	
	
	
}
	
