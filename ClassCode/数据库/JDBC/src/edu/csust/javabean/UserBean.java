package edu.csust.javabean;

import java.io.Serializable;

/**
 * 数据库User表的实体类
 * @author 15295
 * 编写时间
 */
public class UserBean implements Serializable{
	
	private static final long serialVersionUID = -9094404975533535841L;
	
	private Integer ID;
	private String Pwd;
	private String Name;
	private String Tele;
	private String Email;
	private String Addr;
	
	public UserBean(Integer iD, String pwd, String name, String tele, String email, String addr) {
		super();
		ID = iD;
		Pwd = pwd;
		Name = name;
		Tele = tele;
		Email = email;
		Addr = addr;
	}

	public UserBean() {
		super();
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getPwd() {
		return Pwd;
	}

	public void setPwd(String pwd) {
		Pwd = pwd;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getTele() {
		return Tele;
	}

	public void setTele(String tele) {
		Tele = tele;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddr() {
		return Addr;
	}

	public void setAddr(String addr) {
		Addr = addr;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
