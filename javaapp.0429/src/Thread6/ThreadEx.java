package Thread6;

import java.util.concurrent.Semaphore;

public class ThreadEx extends Thread {
	static Semaphore semaphore = new Semaphore(3);
	public void run() {
		
		try {
			//시작할때 -1
			semaphore.acquire();
			for(int i=0; i<3; i=i+1) {
				Thread.sleep(1000);
				System.out.println(this.getName());				
			}
			//종료할때 +1
			semaphore.release();
		}catch(Exception e) {}
	}

}
