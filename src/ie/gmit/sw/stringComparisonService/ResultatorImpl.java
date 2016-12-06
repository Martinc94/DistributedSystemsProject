package ie.gmit.sw.stringComparisonService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ResultatorImpl extends UnicastRemoteObject implements Resultator {
	private static final long serialVersionUID = 1L;
	private String result;
	private boolean processed;

	protected ResultatorImpl() throws RemoteException {	
	}//end defaultConstructor

	public String getResult() throws RemoteException {
		return this.result;
	}//end getResult

	public void setResult(String result) throws RemoteException {
		this.result=result;
	}//end setResult

	public boolean isProcessed() throws RemoteException {
		return this.processed;
	}//end isProcessed

	public void setProcessed() throws RemoteException {
		this.processed=true;
	}//end setProcessed

}//end ResultatorImpl
