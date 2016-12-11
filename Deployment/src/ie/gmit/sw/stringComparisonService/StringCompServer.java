package ie.gmit.sw.stringComparisonService;

/* StringCompServer is responsible for creating an instance of the remote object (StringServiceImpl)
 * and binding it to a naming server (the RMI Registry) with a human-readable name. 
 */

import java.rmi.*;
import java.rmi.registry.*;

public class StringCompServer {
	public static void main(String[] args) throws Exception{
		
		//creates a remote service for Comparing Strings
		StringService ss = new StringServiceImpl();
		
		//Start the RMI registry on port 1099
		LocateRegistry.createRegistry(1099);
		
		//Bind our remote object to the registry with the human-readable name "howdayService"
		Naming.rebind("stringService", ss);
		
		//Print a nice message to standard output
		System.out.println("String Server ready.");
	}
}
