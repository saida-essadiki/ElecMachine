package app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.CounterIndex;

/**
 * Servlet implementation class SaveAnswers
 */
@WebServlet("/saveanswers")
public class SaveAnswers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveAnswers() {
        super();
        // TODO Auto-generated constructor stub
    }

	CounterIndex index = new CounterIndex();


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		int ans = Integer.parseInt(request.getParameter("recommend-radio"));
		String action = request.getParameter("action");
		
		if("next".equals(action)) {
			// if click next
			pw.println("click next and answer is "+ ans);
			index.higherIndex();
			pw.println("index is "+ index.getIndex());

			//request.setAttribute("index", index);
			
			//RequestDispatcher rd=request.getRequestDispatcher("/jsp/showquestion.jsp");
			//rd.forward(request, response);
		
			//response.sendRedirect("showquestion");
			
		}else if ("previous".equals(action)){
			//if click previous
			pw.println("click previous and answer is "+ ans);
			index.lowerIndex();
			pw.println("index is "+ index.getIndex());
			
		}else {
			//if click finish
			pw.println("click finish and answer is "+ ans );
			response.sendRedirect("resault");
				
		}
	}
	
}


