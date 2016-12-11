package ie.gmit.sw;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import ie.gmit.sw.comparator.Job;
import ie.gmit.sw.comparator.QueueManager;

public class ServiceHandler extends HttpServlet {
	private String remoteHost = null;
	private volatile static long jobNumber = 0;
	QueueManager m;

	public void init() throws ServletException {
		ServletContext ctx = getServletContext();
		remoteHost = ctx.getInitParameter("RMI_SERVER"); //Reads the value from the <context-param> in web.xml
		//manager for Queues
		m = new QueueManager();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		//Initialise some request varuables with the submitted form info. These are local to this method and thread safe...
		String algorithm = req.getParameter("cmbAlgorithm");
		String s = req.getParameter("txtS");
		String t = req.getParameter("txtT");
		String taskNumber = req.getParameter("frmTaskNumber");
		
		Boolean complete=false;
		String distance="";


		out.print("<html><head><title>Distributed Systems Assignment</title>");		
		out.print("</head>");		
		out.print("<body>");
		
		//if there is no taskNo then a task is created
		if (taskNumber == null){
			taskNumber = new String("T" + jobNumber);
			jobNumber++;
			
			//create Job object from the request variables and jobNumber
			Job j = new Job(s, t, algorithm, taskNumber);
			
			//Add job to in-queue blockingQueue
			m.add(j);
		}else{
			//Check out-queue for finished job
			complete=m.isComplete(taskNumber);
			
			if(complete){
				distance=m.getResult(taskNumber);
			}//end if
		}//else
			
		out.print("<H1>Processing request for Job#: " + taskNumber + "</H1>");
		out.print("<div id=\"r\"></div>");
		
		out.print("<font color=\"#993333\"><b>");
		out.print("RMI Server is located at " + remoteHost);
		out.print("<br>Algorithm: " + algorithm);		
		out.print("<br>String <i>s</i> : " + s);
		out.print("<br>String <i>t</i> : " + t);
		
		if(complete){
            out.print("<br>Distance was calculated as: " + distance);
        }
		
		out.print("<form name=\"frmRequestDetails\">");
		out.print("<input name=\"cmbAlgorithm\" type=\"hidden\" value=\"" + algorithm + "\">");
		out.print("<input name=\"txtS\" type=\"hidden\" value=\"" + s + "\">");
		out.print("<input name=\"txtT\" type=\"hidden\" value=\"" + t + "\">");
		out.print("<input name=\"frmTaskNumber\" type=\"hidden\" value=\"" + taskNumber + "\">");
		out.print("</form>");								
		out.print("</body>");	
		out.print("</html>");	
		
		out.print("<script>");
		out.print("var wait=setTimeout(\"document.frmRequestDetails.submit();\", 10000);");
		out.print("</script>");
				
		//You can use this method to implement the functionality of an RMI client
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
 	}
}