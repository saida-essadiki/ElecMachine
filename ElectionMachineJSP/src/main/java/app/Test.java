package app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    name = "HelloAppEngine",
    urlPatterns = {"/handleform"}
)
public class Test extends HttpServlet {

/**
 * Method receives GET type requests
 * Of course, one could call method doPost(request, response) from here,
 * but in this example is not done so.
 */
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {
	  response.sendRedirect("./html/vehicleform.html");
	  return; //Not necessary because method ends, but as the must not be any output after 
	  			// redirecting, this is common way always to add return after redirect
  }
/**
 * Method receives POST type requests
 * Of course, one could call method doGet(request, response) from here,
 * but in this example is not done so.
 */
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {

    response.setContentType("text/html");
    response.setCharacterEncoding("UTF-8");
    PrintWriter out=response.getWriter();
    
    htmlHead(out); //Print the beginning part of html, which might contain a banner image and more
    
    /*
     * We always get strings or string arrays from an html form
     * The data is read with request.getParameter("value-of-the-name-attribute-in-the-html-form"):
     */
    String type=request.getParameter("type");
    String brand=request.getParameter("brand");
    String year=request.getParameter("year");
    
    out.println("<ol>"+
    			"<li>Type="+type+
    			"<li>Brand="+brand+
    			"<li>Year="+year+
    			"</ol>"
    			);
    out.println("<a href='./vehicleform.html'>Back to form</a>");
    htmlEnd(out);//And the end of html - perhaps a whole footer
  }

  /**
   * Printing the starting part of outputted html
   * @param out PrintWriter printing to the response
   */
	private void htmlHead(PrintWriter out) {
		// TODO Auto-generated method stub
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>Form handler</title></head><body>");
	}
	
  /**
   * Printing the ending part of outputted html
   * @param out PrintWriter printing to the response
   */
	private void htmlEnd(PrintWriter out) {
		out.println("<p style='font-style:italic;'>Author: pentti.ojaniemi@hamk.fi</p>");
		out.println("</body></html>");
	}
}