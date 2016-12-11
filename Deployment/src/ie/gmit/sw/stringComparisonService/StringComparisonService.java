package ie.gmit.sw.stringComparisonService;

import java.rmi.RemoteException;

//import algorithms
import ie.gmit.sw.algos.*;

public class StringComparisonService {
	private String s;
	private String t;
	private String algo;
	private Resultator res;
	
	//Algorithms
	private DamerauLevenshtein damLev = new DamerauLevenshtein();
	private HammingDistance hamDis = new HammingDistance();
	private Levenshtein lev = new Levenshtein();

	public StringComparisonService(String s, String t, String algo, Resultator res){
		this.s = s;
		this.t = t;
		this.algo = algo;
		this.res = res;
		//Sets the Algorithm Depending on given algo String
		init();
	}//end constructor
	
	private void init(){
		int distance;
		
		//Switch Depending On Given Algorithm
		switch (algo) {
			case "Damerau-Levenshtein Distance":
				distance=damLev.distance(s, t);
				
				try {
					//passes result back to resultator
					res.setResult("Distance is: "+distance);
					res.setProcessed();
				} catch (RemoteException e) {
					//Handle Error
					e.printStackTrace();
				}
				break;
				
			case "Hamming Distance":
				distance=hamDis.distance(s, t);
				try {
					//passes result back to resultator
					res.setResult("Distance is: "+distance);
					res.setProcessed();
				} catch (RemoteException e) {
					//Handle Error
					e.printStackTrace();
				}
				break;
	
			case "Levenshtein Distance":
				distance=lev.distance(s, t);
				try {
					//passes result back to resultator
					res.setResult("Distance is: "+distance);
					res.setProcessed();
				} catch (RemoteException e) {
					//Handle Error
					e.printStackTrace();
				}
				break;
		}//end Switch
	}//end Init
	
}//end StringComparisonService
