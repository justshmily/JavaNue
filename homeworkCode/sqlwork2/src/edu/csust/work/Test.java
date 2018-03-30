package edu.csust.work;

import java.util.Scanner;

import edu.csust.daoimpl.EmployeeDaoImpl;
import edu.csust.javabean.EmployeeBean;

public class Test {

	public static void main(String[] args) {
		boolean flag=true;
		do {
			System.out.println("选择：1 录入    2 查询     3 修改     4 删除      5 退出");
			Scanner sc=new Scanner(System.in);
			int num;
			
			try {
				num=sc.nextInt();
				switch (num) {
				case 1:{
					EmployeeBean bean=new EmployeeBean();
					System.out.print("请输入要录入员工的工号：");
					bean.setID(sc.nextInt());
					System.out.print("请输入要录入员工的姓名：");
					bean.setName(sc.next());
					System.out.print("请输入要录入员工的性别：");
					bean.setSex(sc.next());
					System.out.print("请输入要录入员工的联系方式：");
					bean.setTele(sc.next());
					System.out.print("请输入要录入员工的家庭住址：");
					bean.setAddr(sc.next());
					
					//实例化UserDaoImpl实体类对象
					EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
					String msg=daoImpl.add(bean);
					System.out.println(msg);
					System.out.println();
					break;
				}
				case 2:{
					EmployeeBean bean=new EmployeeBean();
					System.out.print("请输入要查询员工的姓名：");
					bean.setName(sc.next());
					System.out.print("请输入要查询员工的家庭住址：");
					bean.setAddr(sc.next());
					
					//实例化UserDaoImpl实体类对象
					EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
					String msg=daoImpl.search(bean);
					System.out.println(msg);
					System.out.println();
					break;
				}
				case 3:{
					//修改（偷懒一下，不进行每项单独修改了）
					EmployeeBean bean=new EmployeeBean();
					System.out.print("请输入要修改员工的工号：");
					bean.setID(sc.nextInt());
					System.out.print("请输入新的联系方式：");
					bean.setTele(sc.next());
					System.out.print("请输入新的家庭住址：");
					bean.setAddr(sc.next());
					
					//实例化UserDaoImpl实体类对象
					EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
					String msg=daoImpl.update(bean);
					System.out.println(msg);
					System.out.println();
					break;
				}
				case 4:{
					System.out.println("请输入要删除员工的工号：");
					int id=sc.nextInt();
					
					//实例化UserDaoImpl实体类对象
					EmployeeDaoImpl daoImpl=new EmployeeDaoImpl();
					String msg=daoImpl.delete(id);
					System.out.println(msg);
					System.out.println();
					break;
				}
				case 5:{
					System.out.println("欢迎使用，bye");
					flag=false;
					break;
				}
				default:
					System.out.println("输入错误，请重新输入");
				}
			} catch (Exception e) {
				System.out.println("输入不合法，请重新输入");
			}
		} while (flag);
	}

}
