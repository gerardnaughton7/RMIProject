package ie.gmit.sw;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.servlet4preview.RequestDispatcher;

/**
 * Servlet implementation class DictionaryServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/DictionaryServlet" })
public class DictionaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BlockingQueue<Job> inQueue = new ArrayBlockingQueue<Job>(10);
    private int giveID; 
    private Map<String, Job> jobList = new HashMap<String, Job>();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DictionaryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		giveID++;
		Job j = new Job(giveID, request.getParameter("word"));
		try {
			inQueue.put(j);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = response.getWriter();
		
		Iterator<Job> it = inQueue.iterator();
	    while(it.hasNext()){
	      System.out.println(it.next().getID());
	    }
		
		String word = request.getParameter("word");
		
		out.println("Your word Means");
		out.println(word);
		jobList.put(Integer.toString(giveID), j);
		request.setAttribute("jobList", inQueue);
		//request.setAttribute("job", Integer.toString(j.getID()));
		javax.servlet.RequestDispatcher rd=request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
