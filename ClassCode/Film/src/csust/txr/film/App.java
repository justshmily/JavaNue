package csust.txr.film;

import java.util.ArrayList;
import java.util.Scanner;

public class App {


	FilmList list=new FilmList();
	
	public void print() {
		System.out.println("--------主菜单---------");
		System.out.println("1         录入");
		System.out.println("2         豆瓣评分浏览");
		System.out.println("3         上映时间浏览");
		System.out.println("4          退出");
		System.out.println("----------------------");
		System.out.println("请输入你的选择（1~4）：");
	}
	public void select() {
		boolean flag=true;

		Scanner sc=new Scanner(System.in);
		while(flag) {
			int select=Integer.parseInt(sc.nextLine());
			switch(select) {
			case 1:
				list.write();list.show();print();break;
			case 2:
				System.out.println("2");print();break;
			case 3:
				list.showByYear();print();break;
			case 4:
				System.out.println("欢迎使用");sc.close();flag=false;break;
			}
		}
	}
	
	public static void main(String[] args) {
		App app=new App();
		app.print();
		app.select();
	}

}
