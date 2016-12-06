package ie.gmit.sw.stringComparisonService;

/* The remote interface Resultator declares four remote methods:
*
* 		public String getResult() throws RemoteException;
*		public void setResult(String result) throws RemoteException;
*		public boolean isProcessed() throws RemoteException;
*		public void setProcessed() throws RemoteException;
*
*		The remote method setResult() should be used by the service provider to update the
*		state of the returned “pass-by-reference” object with a relevant string response (edit
*		distance or optimal alignment). The method getResult() should return this text to a
*		caller. The service provider should flag the Resultator object as processed by calling
*		the method setProcessed(). Finally, calling isProcessed() should return whether or not
*		the process is complete. Note that the Resultator object is a remote object reference
*		that is returned when the remote method compare(…) is called. This object should be
*		stored in the Out-Queue (Map)
*/

import java.rmi.*;

public interface Resultator extends Remote{
	public String getResult() throws RemoteException;
	public void setResult(String result) throws RemoteException;
	public boolean isProcessed() throws RemoteException;
	public void setProcessed() throws RemoteException;
}//end Resultator
