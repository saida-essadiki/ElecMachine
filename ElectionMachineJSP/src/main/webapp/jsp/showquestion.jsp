<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Question" %>
 <%@ page import="data.CounterIndex" %>
 
 <%@ page import="java.sql.Connection" %>  
 <%@ page import="java.sql.DriverManager" %>   
 <%@ page import="dao.Dao" %> 
 <%@ page import="app.SaveAnswers" %>  
 
    
 
    

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
       <form id="survey-form" method="post" class="form-answer" action="./saveanswers">
       	<div class="question-text">
	       	<% 
	       	// create index for questions for test
			//CounterIndex j = new CounterIndex();
			// out.println("your index is: "+ j.getIndex());
	       	
			ArrayList<Question> questionList=(ArrayList<Question>)request.getAttribute("questionlist");
			
			// IMP The value is not coming to this page
			//ArrayList<CounterIndex> index=(ArrayList<CounterIndex>)request.getAttribute("index");	
			//int i =index.getIndex();
			int i = 0;
			if(i<19){
				Question f = questionList.get(i);
				out.println(f.getId()+" . "+f.getQuestion());
			}else{			
				out.println("There is no such question! \n");
	        }		

			%>
			
			
		</div>
		<hr>
       	<div class="form-elements">					
		   <div class="radio-buttons">
                 <input type="radio" Class="recommend-radio" name="recommend-radio" value="1">
                 <label id="definitely">Definitely Agree</label><br>
                 <input type="radio" Class="recommend-radio" name="recommend-radio" value="2">
                 <label id="maybe">Agree</label><br>
                 <input type="radio" Class="recommend-radio" name="recommend-radio" value="3" checked>
                 <label id="not-sure">Middle opinion</label><br>
                 <input type="radio" Class="recommend-radio" name="recommend-radio" value="4">
                 <label id="not-sure">Disagree</label><br>
                 <input type="radio" Class="recommend-radio" name="recommend-radio" value="5">
                 <label id="not-sure">Completely disagree</label><br>
             </div>
             <div class="buttons">
            	<button id="previous" class="submit-button" type="submit"  name="action" value="previous">Previous</button>
         		<button id="next" class="submit-button" type="submit"  name="action" value="next">Next</button>
         		<button id="finish" class="submit-button" type="submit"  name="action" value="finish">Finish</button>
         		
             </div>
        </div>
      </form>
    </div>

  </body>
</html>