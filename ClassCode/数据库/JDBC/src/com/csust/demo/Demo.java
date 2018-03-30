package com.csust.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo {

	public static void main(String[] args) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int ret=0;
		try {
			//1、加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			
			//2、创建连接
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","654321");
			
			//String sql="select * from student";
			//pstmt=conn.prepareStatement(sql);
			//rs=pstmt.executeQuery();
			
//			while(rs.next()) {
//				System.out.print("学号"+rs.getString("Cno")+"\t");
//				System.out.print("姓名"+rs.getString("Cname")+"\t");
//				System.out.print("年龄"+rs.getInt("Age")+"\t");
//				System.out.print("性别"+rs.getString("Sex")+"\t");
//				System.out.println("电话"+rs.getString("Tele")+"\t");
//			}
			
			//3、创建数据库命令
			String sql="update student set Age=?,Sex=?,Tele=? where Cno='666'";
			
			//4、通过数据库处理对象提交并执行数据库命令
			pstmt=conn.prepareStatement(sql);
			
			//将参数传递给预编译对象
			pstmt.setInt(1, 66);
			pstmt.setString(2, "男");
			pstmt.setString(3, "5557777");
			
			//5、接收并处理结果集
			ret=pstmt.executeUpdate();
			if(ret>0){
				System.out.println("数据库修改成功！");
			}
			else{
				System.out.println("数据库修改失败！！");
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//6、关闭/释放资源
				//rs.close();
				pstmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
