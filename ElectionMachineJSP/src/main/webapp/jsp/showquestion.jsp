<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Question" %>
 <%@ page import="java.sql.Connection" %>  
 <%@ page import="java.sql.DriverManager" %>   
 <%@ page import="dao.Dao" %> 
 <%@ page import="test.DbManager" %>   
    
 
    

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
  <head>
    <meta http-equiv="content-type" content="application/xhtml+xml; charset=UTF-8" />
    <link href="../CSS/style.css" rel="stylesheet">


    <title>Election Machine questions</title>
  </head>

  <body>

    <table>
      <tr>
        <td colspan="2" style="font-weight:bold;">Available Servlets:</td>        
      </tr>
      <tr>
        <td><a href='/hi'>The new servlet</a></td>
      </tr>
    </table>

    <!-- question part is start here-->
       <div>
        <h1 id="title">Election Machine</h1>
        <p id="description">Answer these 20 questions to suggest the best candidates for you:</p>
    </div>
    <div class="form-container">

        <form id="survey-form">
        	<!--  begin - just for test database connection -->
        	<div class="test"> 
        	<p>HERE 1:</p>
        	<%
			DbManager db = new DbManager();
       		Connection conn = db.getConnection();
       		if(conn == null){
       			out.print("connection failed");
       		}else{
       			out.print("connection Done");

       		}
       		
			ArrayList<Question> questionList=(ArrayList<Question>)request.getAttribute("questionlist");
			
			for (int i=0; questionList!=null && i<questionList.size();i++){
				Question f = questionList.get(i);
				out.println(f.getId()+": "+f.getQuestion());
			}
        	

			%>

            <div class="part3">
                <div class="form-elements">
					<form method="post" class="answer">
                    	<label>Would you recommend More police in the city?</label><br>

	                    <p></p>
	                    <input type="radio" Class="recommend-radio" name="recommend-radio" >
	                    <label id="definitely">Definitely Agree</label><br>
	                    <input type="radio" Class="recommend-radio" name="recommend-radio">
	                    <label id="maybe">Agree</label><br>
	                    <input type="radio" Class="recommend-radio" name="recommend-radio" checked>
	                    <label id="not-sure">Middle opinion</label><br>
	                    <input type="radio" Class="recommend-radio" name="recommend-radio">
	                    <label id="not-sure">Disagree</label><br>
	                    <input type="radio" Class="recommend-radio" name="recommend-radio">
	                    <label id="not-sure">Completely disagree</label><br>
                    </form>
                </div>
            </div>
            <div class="bottons">
                <div id="Previous" class="submit">
                        <input class="submit-botton" type="submit" value="Previous">
                </div>
                
                <div id="next" class="submit">
                        <input class="submit-botton" type="submit" value="next">
                </div>
            </div>
            
        </form>
    
    </div>
  </body>
</html>