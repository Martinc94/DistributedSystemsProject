package ie.gmit.sw.stringComparisonService;

import java.rmi.Naming;

public class StringClient {
	public static void main(String[] args) throws Exception{
		//Ask the registry running on 10.2.2.65 and listening in port 1099 for the instance of
		//the StringService object that is bound to the RMI registry with the name stringService.
		StringService stringService = (StringService) Naming.lookup("rmi://localhost:1099/stringService");

		//calls the compare method of the remote object
		//Doesn't need to know how StringService Interface is implemented
		stringService.compare("Hello", "Hello", "Damerau-Levenshtein Distance");
		stringService.compare("Hello", "Helli", "Hamming Distance");
		stringService.compare("Hello", "Hello World", "Levenshtein Distance");
		
	}//end main
	
}//end StringClient