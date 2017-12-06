package com.tanxiaoran.quiz;

import java.util.Scanner;

public class JudgementDays {

	private int year;
	private int month;
	private int day;
	
	/**
	 * @param year
	 * @param month
	 * @param day
	 */
	public JudgementDays(int year, int month, int day) {
		super();
		this.year = year;
		this.month = month;
		this.day = day;
	}
	
	public JudgementDays() {
		// TODO Auto-generated constructor stub
	}

	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if(month>=1&&month<=12)
		this.month = month;
		else {
			System.out.println("月份为1-12，请重新输入！");
			this.input();
		}
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if(day<1) {
			System.out.println("日期不能小于1，请重新输入");
			this.input();
		}
		else if(day>this.getMonthDays(month)) {
			System.out.println("日不能大于"+this.getMonthDays(month)+",请重新输入！");
			this.input();
		}
		this.day = day;
	}

	public boolean isLeapYear() {
		if((year%4==0&&year%100!=0)||year%400==0)
			return true;
		else
			return false;
	}
	
	public int getMonthDays(int month) {
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
			return 31;
		else if(month==4||month==6||month==8||month==10)
			return 30;
		else {
			if(isLeapYear())
				return 29;
			else
				return 28;
		}
	}
	public int getTotalDays() {
		int total=day;
		for(int i=1;i<=month-1;i++) {
			total+=getMonthDays(i);
		}
		return total;
	}
	public void run(JudgementDays time) {
		
		time=new JudgementDays(year,month,day);
		System.out.println(time.getTotalDays());
	}
	
	public void input() {
		System.out.print("请输入年：");
		this.setYear(sc.nextInt());
		System.out.print("请输入月：");
		this.setMonth(sc.nextInt());
		System.out.print("请输入日：");
		this.setDay(sc.nextInt());
	}
	
	public void print() {
		System.out.println(year+"-"+month+"-"+day+"-"+"是"+year+"的第"+this.getTotalDays()+"天");
	}
	Scanner sc=new Scanner(System.in);
	
	public static void main(String[] args) {
		JudgementDays time=new JudgementDays();
		time.input();
		time.print();
	}
}
