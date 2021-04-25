package app;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.Question;

/**
 * Servlet implementation class ShowFish
 */
@WebServlet("/showquestion")
public class ShowQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao=null;
	
	@Override
	public void init() {
		
		dao = new Dao("jdbc:mysql://localhost:3306/election_machine", "root", "Hh4497");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException {
		response.sendRedirect("index.html");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		String id=request.getParameter("id");
		String questionText=request.getParameter("questionText");
		
    
 		ArrayList<Question> singleQuestion=null;
		
		//////////////////////////////////////
		Question q=new Question(id, questionText);
		if (dao.getConnection()) {
			singleQuestion = dao.readQuestion(q);
		}
		else {
			System.out.println("No connection to database for read questions");
		}
		request.setAttribute("question", singleQuestion);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showquestion.jsp");
		rd.forward(request, response);
	}
}
