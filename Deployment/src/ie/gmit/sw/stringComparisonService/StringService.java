package ie.gmit.sw.stringComparisonService;

/*			public Resultator compare(String s, String t, String algo) throws RemoteException;
* 
*			where s and t are the two strings to compare, algo is the string matching algorithm to
*			use and Resultator is a remote object reference that allows the RMI service provider
*			to push an asynchronous response to the RMI requestor (a pass by reference from the
*			service provider to the service requestor). The string comparison service should
*			delegate calls to an instance of the algorithm specified in the request, running in a
*			separate thread. Before comparing the strings, the string algorithm thread should be put
*			to sleep for a time, i.e. Thread.sleep(1000), to slow the service down and simulate a
*			real asynchronous service.
*/

import java.rmi.*;

public interface StringService extends Remote{
	public Resultator compare(String s, String t, String algo) throws RemoteException;
}//end StringService