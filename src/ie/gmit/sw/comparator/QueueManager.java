package ie.gmit.sw.comparator;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueManager {
	private StringService ss;
	//Queues
	private BlockingQueue<Job> inQueue;
	private ConcurrentMap<String, Resultator> outQueue;
	 
	 
	public QueueManager() {
		//init queues
		inQueue = new LinkedBlockingQueue<Job>();
		outQueue = new ConcurrentHashMap<String, Resultator>();
		
		// try to connect to service running on localhost port 1099 with the name stringService from the rmi registry
        try {
			ss = (StringService) Naming.lookup("rmi://localhost:1099/stringService");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			//catch error
			e.printStackTrace();
		}
        //Start the manager
        startManager();
        
	}//end Constructor

	private void startManager() {
		Job j;
		Resultator res;
		//keep manager running
		while(true){			
			try {
				//Retrieves and removes the head of this queue, waiting if necessary until an element becomes available
				j = inQueue.take();
				
				//make an RMI call to the String Comparison Service and gets Resultator back
	            res = (Resultator) ss.compare(j.getS(), j.getT(), j.getAlgo());
	          
	            //job finished add resultator to outQueue using the jobNumber as the key and the <i>Resultator</i> as a value
	            outQueue.put(j.getTaskNo(), res);
			} catch (InterruptedException e) {
				// catch error
				e.printStackTrace();
			} catch (RemoteException e) {
				// catch remote error
				e.printStackTrace();
			}//end tryCatch
		}//end While
	}//end startManager
	
	//adds to inQueue
	public void add(Job j){
		inQueue.add(j);
	}//end add
	
	public Boolean isComplete(String taskNo){
		if(outQueue.containsKey(taskNo)){
				try {
					Resultator r = outQueue.get(taskNo);
					return r.isProcessed();
				} catch (RemoteException e) {
					//catch error
					e.printStackTrace();
				}//end try
		}//end if
		//if cant Get isProcessed return False
		return false;	
	}//end isComplete
	
	public String getResult(String taskNo){
		String str ="";
		if(outQueue.containsKey(taskNo)){
				try {
					Resultator r = outQueue.get(taskNo);
					str=r.getResult();
				} catch (RemoteException e) {
					//catch error
					e.printStackTrace();
				}//end try
		}//end if
		//return result
		return str;	
	}//end getResult
	
}//end QueueManager
 