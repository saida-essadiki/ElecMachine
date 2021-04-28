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

import dao.Dao;
import data.CounterIndex;
import data.CustomerAnswers;
import data.Question;

/**
 * Servlet implementation class SaveAnswers
 */
@WebServlet("/saveanswers")
public class SaveAnswers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao=null;
	
	@Override
	public void init() {
		
		dao = new Dao("jdbc:mysql://localhost:3306/election_machine", "root", "Hh4497");

	}
       
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
		
		
		//String destination = "/jsp/showquestion.jsp";
		//RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
		
		// Bring questions array here and try to read specific question with index
		//ArrayList<Question> questionList=(ArrayList<Question>)request.getAttribute("questionlist");
		//String text = "...";

		//int i =index.getIndex();
		//Question f = questionList.get(i);
		//text = f.getId()+" . "+f.getQuestion();
		//request.setAttribute("text", text);
		//RequestDispatcher rd=request.getRequestDispatcher("showquestion");
		//rd.forward(request, response);	

		
		if("next".equals(action)) {
			// if click next
			pw.println("click next and answer is "+ ans);
			index.higherIndex();
			pw.println("index is "+ index.getIndex());
			
			// add answer to database
			CustomerAnswers ca = new CustomerAnswers((index.getIndex()+1),ans);
			ArrayList<CustomerAnswers> list=null;
			if (dao.getConnection()) {
				pw.println("connection is done");
				list = dao.customerAnswer(ca);
			}else {
				pw.println("No connection");
			}

			//response.sendRedirect("showquestion");

			
		}else if ("previous".equals(action)){
			//if click previous
			pw.println("click previous and answer is "+ ans);
			index.lowerIndex();
			pw.println("index is "+ index.getIndex());
			
			//response.sendRedirect("showquestion");

			
		}else {
			//if click finish
			pw.println("click finish");
			
			response.sendRedirect("resault");
				
		}
	}
	
}


