package ie.gmit.sw;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

import ie.gmit.sw.stringComparisonService.StringService;
import ie.gmit.sw.stringComparisonService.StringServiceImpl;

public class Servant {

	public static void main(String[] args) throws Exception {
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
