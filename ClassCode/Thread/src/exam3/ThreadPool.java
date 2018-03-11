package exam3;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

	public static void main(String[] args) {
		
		//线程池
		ExecutorService exec=Executors.newCachedThreadPool();
		for(int i=0;i<10;i++) {
			exec.execute(new Runnable() {

				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
				}
				
			});
		}
		
		//固定数量线程池
		exec=Executors.newFixedThreadPool(5);
		for(int i=0;i<10;i++) {
			exec.execute(new Runnable() {

				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
				}
				
			});
		}
		
		//周期性执行任务
		ScheduledExecutorService exec1=Executors.newScheduledThreadPool(5);
		for(int i=0;i<10;i++) {
			//频率
			exec1.scheduleAtFixedRate(new Runnable() {

				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
				}
			}, 2, 1, TimeUnit.SECONDS);
			
			//间隔
			exec1.scheduleWithFixedDelay(new Runnable() {

				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName() + "," + new Date());
				}
				
			}, 2, 1, TimeUnit.SECONDS);
		}
	}

}
