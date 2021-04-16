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
import data.Fish;

/**
 * Servlet implementation class ShowFish
 */
@WebServlet("/showfish")
public class ShowFish extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao=null;
	
	@Override
	public void init() {
		dao=new Dao("//localhost:3306/fishdatabase", "root", "Hh4497");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowFish() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Fish> list=null;
		if (dao.getConnection()) {
			list=dao.readAllFish();
		}
		else {
			System.out.println("No connection to database");
		}
		request.setAttribute("fishlist", list);
		
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showfish.jsp");
		rd.forward(request, response);
	}
}
