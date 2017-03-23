package pckg4;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Demo4 {
	
private static BlockingQueue<Integer> bq= new ArrayBlockingQueue<Integer>(10);	
	public static void main(String[] args) throws InterruptedException{
		
		Thread t1=new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		Thread t2=new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		
	}

	public static void producer() throws InterruptedException
	{
		Random random= new Random();
		while(true){
			bq.put(random.nextInt(100));
		}
	}
	
	public static void consumer() throws InterruptedException
	{
		Random random= new Random();
		while(true){
			Thread.sleep(100);
		if(random.nextInt(10)==0)
		{
			Integer value=bq.take();
			System.out.println("taken value is" +value +" queue size is" +bq.size());
		}
		}
	}
	
}
