package ie.gmit.sw;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Worker extends Thread{
	
	private BlockingQueue<Job> inQueue = new ArrayBlockingQueue<Job>(10);
	private BlockingQueue<Job> outQueue = new ArrayBlockingQueue<Job>(10);
	private Job j;
	private Job jobDone;
	private String def;
	
	//constructor with args inqueue and outqueue
	public Worker(BlockingQueue<Job> inQueue, BlockingQueue<Job> outQueue) {
		super();
		this.inQueue = inQueue;
		this.outQueue = outQueue;
	}
	
	//run method which runs our jobs
	public void run() {
		//keeps running
		while(true) {
			try {
				//checks queue every 10 second
				j = inQueue.poll();
				
				//if j is null do nothing till job is available
				if(j != null)
				{
					Thread.sleep(10000);//thread put to sleep to slow the service down and simulate a real asynchronous service
					//do rmi lookup
					DictionaryService ds = (DictionaryService) Naming.lookup("rmi://127.0.0.1:1099/dictionaryService");
					
					//call method to find definition and return it
					def = ds.getDefinition(j.getMsg());
					//set definition
					j.setDef(def);
					//put it into outqueue
					outQueue.offer(j); 
					
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
