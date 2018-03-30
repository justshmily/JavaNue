package edu.csust.dao;

import edu.csust.javabean.EmployeeBean;

/**
 * 数据库employee表的dao类
 * @author 15295
 *
 */
public interface EmployeeDao {

	/**
	 * 录入人员信息的方法
	 * @param bean  记录要录入人员的信息
	 * @return  返回录入是否成功
	 */
	public String add(EmployeeBean bean);
	
	/**
	 * 按姓名、家庭住址模糊查询的方法
	 * @param bean 记录要查询的姓名和家庭地址
	 * @return 返回查询结构
	 */
	public String search(EmployeeBean bean);
	
	/**
	 * 按工号修改人员信息的方法
	 * @param bean 记录工号和要修改的信息
	 * @return 返回修改是否成功
	 */
	public String update(EmployeeBean bean);
	
	/**
	 * 按工号删除的方法
	 * @param id 
	 * @return 返回是否删除成功
	 */
	public String delete(int id);
}
