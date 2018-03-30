package edu.csust.dao;

import edu.csust.javabean.UserBean;

/**
 * 数据库User表的dao类
 * @author 15295
 * 2018/3/28
 */
public interface UserDao {

	/**
	 * 用于用户登录的方法
	 * @param userBean
	 * @return
	 */
	public String login(UserBean userBean);
}
