package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import data.CounterIndex;
import data.Question;

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
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int i =index.getIndex();
		String text = "...";
		text = "hello";
		
		request.setAttribute("text", text);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showquestion.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		int ans = Integer.parseInt(request.getParameter("recommend-radio"));
		String action = request.getParameter("action");
		
		
		String destination = "/jsp/showquestion.jsp";
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
		
		// Bring questions array here and try to read specific question with index
		ArrayList<Question> questionList=(ArrayList<Question>)request.getAttribute("questionlist");
		String text = "...";
		
		
		
		
		int i =index.getIndex();
		Question f = questionList.get(i);
		text = f.getId()+" . "+f.getQuestion();
		request.setAttribute("text", text);
		RequestDispatcher rd=request.getRequestDispatcher("showquestion");
		rd.forward(request, response);	

		
		if("next".equals(action)) {
			// if click next
			pw.println("click next and answer is "+ ans);
			index.higherIndex();
			pw.println("index is "+ index.getIndex());
			
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


