package pckg1;

class Runner extends Thread{
	public void run(){
		for (int i=0;i<10;i++)
		{
			System.out.println("hello"+ i);
		}
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Runner r1=new Runner();
        Runner r2=new Runner();
        
        r1.start();
        r2.start();
        
	}

}
