package csust.txr.film;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FilmList {

	ArrayList<Film> films =new ArrayList<>();
	
	public void write() {
		Scanner in=new Scanner(System.in);
		int d=1;
		while(d==1) {
			System.out.println("输入信息");
			System.out.print("请输入电影名：");
			String a=in.nextLine();
			System.out.print("请输入上映时间：");
			int b=in.nextInt();
			System.out.print("请输入评分：");
			double c=in.nextDouble();
			
			films.add(new Film(a,b,c));
			System.out.println("是否继续录入：0（否）    1（是）");
			d=in.nextInt();
			if(d!=0&&d!=1) {
				System.out.println("输入错误（0-1）");
			}
		}
		System.out.println("录入结束");
	}
	
	public void show() {
		int i=0;
		for(Film film:films) {
			System.out.println(film);
			
		}
	}
	public void showByYear() {
		Collections.sort(films);
		this.show();
	}
	public void showByRating() {
		
	}
}
