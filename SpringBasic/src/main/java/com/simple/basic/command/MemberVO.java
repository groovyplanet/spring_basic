package com.simple.basic.command;

import java.util.ArrayList;

public class MemberVO { //value object(=DTO와 비슷함)
	
	
	private String id;
	private String pw;
	private String name;
	private String email;
	
	
	

	private ArrayList<String>inter;
	private int month;
	private int year;
	private int day;
	private String msg;
	
	public MemberVO() {
		
	}
	
	public MemberVO(String id, String pw, String name, String email, ArrayList<String> inter, int month, int year,
			int day, String msg) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.inter = inter;
		this.month = month;
		this.year = year;
		this.day = day;
		this.msg = msg;
	}

	public MemberVO(String id, String pw, String name , String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email= email;
	}
	

	public MemberVO(String id, String pw, ArrayList<String> inter) {
		super();
		this.id = id;
		this.pw = pw;
		this.inter = inter;
	}
	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", inter=" + inter + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public ArrayList<String> getInter() {
		return inter;
	}

	public void setInter(ArrayList<String> inter) {
		this.inter = inter;
	}
	
	
	
	

}
