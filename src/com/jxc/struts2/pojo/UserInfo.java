package com.jxc.struts2.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * UserInfo generated by MyEclipse Persistence Tools
 */

public class UserInfo implements java.io.Serializable {

	// Fields

	private Integer uid;

	private String uname;

	private String upwd;

	private Set students = new HashSet(0);

	// Constructors

	/** default constructor */
	public UserInfo() {
	}

	/** minimal constructor */
	public UserInfo(String uname, String upwd) {
		this.uname = uname;
		this.upwd = upwd;
	}

	/** full constructor */
	public UserInfo(String uname, String upwd, Set students) {
		this.uname = uname;
		this.upwd = upwd;
		this.students = students;
	}

	// Property accessors

	public Integer getUid() {
		return this.uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return this.upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public Set getStudents() {
		return this.students;
	}

	public void setStudents(Set students) {
		this.students = students;
	}

}