package edu.csust.javabean;

import java.io.Serializable;

/**
 * 数据库User表的实体类
 * @author 15295
 *
 */
public class EmployeeBean implements Serializable{
	private static final long serialVersionUID = -132463238121245575L;

	private int ID;
	private String Name;
	private String Sex;
	private String Tele;
	private String Addr;
	
	public EmployeeBean(int iD, String name, String sex, String tele, String addr) {
		super();
		ID = iD;
		Name = name;
		Sex = sex;
		Tele = tele;
		Addr = addr;
	}

	public EmployeeBean() {
		super();
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public String getTele() {
		return Tele;
	}

	public void setTele(String tele) {
		Tele = tele;
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
