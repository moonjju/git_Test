package com.kh.mybatis.student.model.vo;

import java.io.Serializable;
import java.util.Date;

public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int no;
	private String name;
	private String tel;
	private Date regDate;//util.Date -> mybatis기본
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int no, String name, String tel, Date regDate) {
		super();
		this.no = no;
		this.name = name;
		this.tel = tel;
		this.regDate = regDate;
	}

	/**
	 * @return the no
	 */
	public int getNo() {
		return no;
	}

	/**
	 * @param no the no to set
	 */
	public void setNo(int no) {
		this.no = no;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the regDate
	 */
	public Date getRegDate() {
		return regDate;
	}

	/**
	 * @param regDate the regDate to set
	 */
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + ", tel=" + tel + ", regDate=" + regDate + "]";
	}
	
	
	
}
