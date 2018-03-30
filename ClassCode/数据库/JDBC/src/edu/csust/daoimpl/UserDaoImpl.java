package edu.csust.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.csust.dao.UserDao;
import edu.csust.javabean.UserBean;

public class UserDaoImpl implements UserDao{
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	int ret=0;
	
	@Override
	public String login(UserBean userBean) {
		String msg=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb?useSSL=false&serverTimezone=UTC", "root", "654321");
			String sql="select * from user where name=? and password=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userBean.getName());
			pstmt.setString(2, userBean.getPwd());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				msg= "登录成功";
			}else {
				msg= "用户名或密码错误";
			}
		} catch (Exception e) {
			msg="数据库异常";
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				msg="数据库释放资源出错";
			}
		}
		return msg;
	}

}
