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

@WebServlet(
    name = "Update",
    urlPatterns = {"/update"}
)
public class Update extends HttpServlet {
	private Dao dao;
	public void init() {
		dao=new Dao("//localhost:3306/fishdatabase", "root", "Hh4497");
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException {
		response.sendRedirect("index.html");
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		String id=request.getParameter("id");
		String breed=request.getParameter("breed");
		
		Fish f=new Fish(id, breed);
		
		ArrayList<Fish> list=null;
		if (dao.getConnection()) {
			list=dao.updateFish(f);
		}
		
		request.setAttribute("fishlist", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showfish.jsp");
		rd.forward(request, response);
	}
}