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
@WebServlet("/showfish")
public class ShowQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao=null;
	
	@Override
	public void init() {
		
        String url = getServletContext().getInitParameter("jdbc:mysql:// localhost:3306/election_machine");
        String user = getServletContext().getInitParameter("root");
        String pass = getServletContext().getInitParameter("Hh4497");
        
		dao = new Dao(url, user , pass );
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Question> list=null;
		if (dao.getConnection()) {
			list=dao.readAllQuestion();
		}
		else {
			System.out.println("No connection to database3");
		}
		request.setAttribute("questionlist", list);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showfish.jsp");
		rd.forward(request, response);
	}
}
