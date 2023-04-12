import java.util.LinkedList;

public class ProducerConsumer {

	public static void main(String[] args) {
		final Main main = new Main();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					main.produce();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					main.consume();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		t1.start();
		t2.start();
		
	}
	
	
	public static class Main {
        LinkedList<Integer> list = new LinkedList<>();
        int capacity = 2;
 
        public void produce() throws Exception
        {
            int item = 0;
            while (true) {
                synchronized (this)
                {
                    while (list.size() == capacity) {
                    	wait();
                    }
                    System.out.println("Producer produced-" + item);
                    list.add(item);
                    item++;
                    notify();
                    Thread.sleep(1000);
                }
            }
        }
 
        public void consume() throws Exception
        {
            while (true) {
                synchronized (this)
                {
                    while (list.size() == 0) {
                    	wait();
                    }
                    int item = list.removeFirst();
 
                    System.out.println("Consumer consumed-" + item);
                    notify();
                    Thread.sleep(1000);
                }
            }
        }
    }
}


