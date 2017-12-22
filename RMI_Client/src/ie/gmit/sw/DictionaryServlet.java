package ie.gmit.sw;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DictionaryServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/DictionaryServlet" })
public class DictionaryServlet extends HttpServlet {
	//variables
	private static final long serialVersionUID = 1L;
	
	private BlockingQueue<Job> inQueue = new ArrayBlockingQueue<Job>(10);
	private BlockingQueue<Job> outQueue = new ArrayBlockingQueue<Job>(10);
	private Worker worker;
    private int giveID; 
    private Job result = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    //Constructor which starts our worker thread
    public DictionaryServlet() {
    	super();
    	//worker takes args inQueue and outQueue
		worker = new Worker(inQueue,outQueue);
		new Thread(worker).start();
		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // doGet which calls our checkQueue function to see if our result is back
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//call checkqueue and set result to what ever it returns
		try {
			result = checkQueue(request.getParameter("ID"));
			System.out.println(result.getMsg()+ "return from checkQueue");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//set result attribute = to result so jsp page can use it
		request.setAttribute("result", result);
		//navigate to response page
		javax.servlet.RequestDispatcher rd=request.getRequestDispatcher("/response.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    // do post creates our job object and adds it to our queue it then navigates to the waiting page
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		giveID++;
		result = null;//reset null back to null
		Job j = new Job(giveID, request.getParameter("word"));
		//set ID attribute to job ID so its visible to waiting page
		request.setAttribute("ID", j.getID());
		try {
			inQueue.put(j);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// nav to waiting page
		javax.servlet.RequestDispatcher rd=request.getRequestDispatcher("/waiting.jsp");
		rd.forward(request, response);
	}
	
	// checkQueue for the job u requested by searching head of queue for id
	private Job checkQueue(String id) throws InterruptedException  {
		boolean found = false;
		Job empty;//dummy object to satisfy return statement
		//keep searching till job is found in queue and retrieve job with result definition
		while(found == false)
		{
			Job j = outQueue.peek();
			//System.out.println("in while loop");
			if(j != null && j.getID() == Integer.parseInt(id))
			{
				found = true;
				Job r = outQueue.poll(10, TimeUnit.SECONDS);//poll the queue every 10 second
				return r;
			}
		}
		return empty = null;	
	}
	
}
