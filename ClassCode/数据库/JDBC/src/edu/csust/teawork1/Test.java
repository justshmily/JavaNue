package edu.csust.teawork1;

import java.util.Scanner;

import edu.csust.daoimpl.UserDaoImpl;
import edu.csust.javabean.UserBean;

public class Test {

	public static void main(String[] args) {
		do {
			System.out.println("选择：1 登录     2 为注册   3 退出");
			Scanner sc=new Scanner(System.in);
			int num=0;
			
			try {
				num=sc.nextInt();
				if(num==1) {
					//登录
					System.out.println("请输入用户名：");
					//实例化实体类对象
					UserBean bean=new UserBean();
					//将获取到的用户输入的用户名和密码存储到实体类对象中
					bean.setName(sc.next());
					System.out.println("请输入密码：");
					bean.setPwd(sc.next());
					
					//实例化UserDaoImpl实体类对象
					UserDaoImpl daoImpl=new UserDaoImpl();
					String msg=daoImpl.login(bean);
					System.out.println(msg);
				}else if(num==2) {
					//注册
				}else if(num==3) {
					//退出
				}else {
					System.out.println("输入错误，请重新输入");
					continue;
				}
			} catch (Exception e) {
				System.out.println("输入内容不合法，请重新输入");
				//return;  //如果有finally,则先执行finally再return
			}
//			finally {
//				System.out.println("go");
//			}
			
		} while (true);
	}
}
