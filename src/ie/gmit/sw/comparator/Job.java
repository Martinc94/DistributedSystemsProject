package ie.gmit.sw.comparator;

//simple class that stores the Variables entered by the Client
public class Job {
	private String s;
	private String t;
	private String algo;
	private String taskNo;
	
	public Job(String s, String t, String algo,String taskNo ) {
		this.s = s;
		this.t = t;
		this.algo = algo;
	}//end Constructor

	//Getters and Setters
	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

	public String getAlgo() {
		return algo;
	}

	public void setAlgo(String algo) {
		this.algo = algo;
	}

	public String getTaskNo() {
		return taskNo;
	}

	public void setTaskNo(String taskNo) {
		this.taskNo = taskNo;
	}

}//end Job

