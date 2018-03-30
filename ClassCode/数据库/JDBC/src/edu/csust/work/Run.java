package edu.csust.work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Run {

	static Scanner sc = new Scanner(System.in);
	static User user = null;

	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static ResultSet rs = null;

	public static void main(String[] args) {
		getConn();
		begin();
	}

	public static Connection getConn() { // 连接数据库方法

		try {

			// 1、加载驱动
			Class.forName("com.mysql.jdbc.Driver");

			// 2、创建连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "654321");

		} catch (Exception e) {

			e.printStackTrace();

		}

		return conn;

	}

	private static void begin() {
		System.out.println("1 登录             2 注册");
		System.out.println("请输入选择");

		int select = sc.nextInt();

		switch (select) {
		case 1:
			user = new User();
			login();
			break;
		case 2:
			user = new User();
			register();
			break;
		default: {
			System.out.println("只能输入1或2");
			select = sc.nextInt();
		}
		}
	}

	private static void login() {
		System.out.println("请输入用户名");
		user.name = sc.next();
		System.out.println("请输入密码");
		user.password = sc.next();
		try {
			String sql = "select*from user where name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.name);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				sql = "select*from user where name=? and password=?";

				pstmt = conn.prepareStatement(sql);

				pstmt.setString(1, user.name);

				pstmt.setString(2, user.password);

				rs = pstmt.executeQuery();// 得到查询结果
				if (rs.next()) {
					System.out.println("登录成功");
				} else {
					System.out.println("密码错误");
					login();
				}
			} else {
				System.out.println("该用户不存在");
				System.out.println("是否注册新账号  0  否   1  是");
				if(sc.nextInt()==1) {
					register();
				}else {
					System.out.println("欢迎使用  再见");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				} else if (pstmt != null) {
					pstmt.close();
				} else if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static void register() {
		System.out.println("请输入用户名");
		user.name = sc.next();
		System.out.println("请输入密码");
		user.password = sc.next();

		try {
			String sql = "select*from user where name=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.name);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				System.out.println("用户已存在");
				System.out.println("0 另取账号名      1 登录");
				int m=sc.nextInt();
				if(m==0) {
					register();
				}else if(m==1) {
					login();
				}else {
					System.out.println("输入错误");
				}
			} else {
				sql = "insert into user(name,password)values(?,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, user.name);
				pstmt.setString(2, user.password);
				pstmt.executeUpdate();
				System.out.println("添加成功");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				} else if (rs != null) {
					rs.close();
				} else if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
