package edu.csust.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.csust.dao.EmployeeDao;
import edu.csust.javabean.EmployeeBean;

public class EmployeeDaoImpl implements EmployeeDao {

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	int ret = 0;

	@Override
	public String add(EmployeeBean bean) {
		String msg = null;
		if (find(bean.getID())) {
			msg = "该用户已存在";
		} else {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/employdb?useSSL=false&serverTimezone=UTC", "root", "654321");
				String sql = "insert into employee values(?,?,?,?,?)";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, bean.getID());
				pstmt.setString(2, bean.getName());
				pstmt.setString(3, bean.getSex());
				pstmt.setString(4, bean.getTele());
				pstmt.setString(5, bean.getAddr());
				
				ret=pstmt.executeUpdate();
				if(ret!=0) {
					msg="录入人员信息成功";
				}else {
					msg="录入失败";
				}
			} catch (Exception e) {
				msg="数据库异常";
			} finally {
				try {
					pstmt.close();
					conn.close();
				} catch (Exception e) {
					msg="数据库释放资源出错";
				}
			}
		}
		return msg;
	}

	@Override
	public String search(EmployeeBean bean) {
		String msg=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/employdb?useSSL=false&serverTimezone=UTC", "root", "654321");
			String sql = "select * from employee where name like ? and addr like ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, "%"+bean.getName()+"%");
			pstmt.setString(2, "%"+bean.getAddr()+"%");
			
			rs=pstmt.executeQuery();
			if(rs.next()) {
				System.out.print("工号 "+rs.getString("id")+"\t");
				System.out.print("姓名 "+rs.getString("name")+"\t");
				System.out.print("性别 "+rs.getString("sex")+"\t");
				System.out.print("联系方式 "+rs.getString("tele")+"\t");
				System.out.println("家庭住址 "+rs.getString("addr")+"\t");
				while(rs.next()) {
					System.out.print("工号 "+rs.getString("id")+"\t");
					System.out.print("姓名 "+rs.getString("name")+"\t");
					System.out.print("性别 "+rs.getString("sex")+"\t");
					System.out.print("联系方式 "+rs.getString("tele")+"\t");
					System.out.println("家庭住址 "+rs.getString("addr")+"\t");
				}
				msg = "查询结束";
			}else {
				msg="查询结果无记录";
			}
		} catch (Exception e) {
			msg="数据库异常";
		} finally {
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

	@Override
	public String update(EmployeeBean bean) {
		String msg = null;
		if (find(bean.getID())) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/employdb?useSSL=false&serverTimezone=UTC", "root", "654321");
				String sql = "update employee set tele=?,addr=? where id=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, bean.getTele());
				pstmt.setString(2, bean.getAddr());
				pstmt.setInt(3, bean.getID());
				
				ret=pstmt.executeUpdate();
				if(ret!=0) {
					msg="修改人员信息成功";
				}else {
					msg="修改失败";
				}
			} catch (Exception e) {
				msg="数据库异常";
			} finally {
				try {
					pstmt.close();
					conn.close();
				} catch (Exception e) {
					msg="数据库释放资源出错";
				}
			}
		} else {
			msg = "该用户不存在";
		}
		return msg;
	}

	@Override
	public String delete(int id) {
		String msg = null;
		if (find(id)) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/employdb?useSSL=false&serverTimezone=UTC", "root", "654321");
				String sql = "delete from employee where id=?";
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, id);
				
				ret=pstmt.executeUpdate();
				if(ret!=0) {
					msg="删除成功";
				}else {
					msg="删除失败";
				}
			} catch (Exception e) {
				msg="数据库异常";
			} finally {
				try {
					pstmt.close();
					conn.close();
				} catch (Exception e) {
					msg="数据库释放资源出错";
				}
			}
		} else {
			msg = "该用户不存在";
		}
		return msg;
	}

	public boolean find(int id) {
		boolean flag = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employdb?useSSL=false&serverTimezone=UTC",
					"root", "654321");
			String sql = "select * from employee where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
}
