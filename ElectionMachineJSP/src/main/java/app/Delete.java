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
    name = "Delete",
    urlPatterns = {"/delete"}
)
public class Delete extends HttpServlet {
	private Dao dao;
	public void init() {
		dao=new Dao("//localhost:3306/fishdatabase", "root", "Hh4497");
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		String id=request.getParameter("id");
		ArrayList<Fish> list=null;
		if (dao.getConnection()) {
			list=dao.deleteFish(id);
		}
		request.setAttribute("fishlist", list);
		RequestDispatcher rd=request.getRequestDispatcher("/jsp/showfish.jsp");
		rd.forward(request, response);
	}
}