<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Question" %>
 <%@ page import="data.CounterIndex" %>
  
 <%@ page import="java.sql.Connection" %>  
 <%@ page import="java.sql.DriverManager" %>   
 <%@ page import="dao.Dao" %> 
 <%@ page import="app.SaveAnswers" %>   
 <%@ page import="data.CustomerAnswers" %>



<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en">
 <head>
    <meta http-equiv="content-type" content="application/xhtml+xml; charset=UTF-8" />
	<link href="../CSS/style.css" rel="stylesheet">
	<title>Answers</title>
</head>
<%
	int i = 1;
	//int[] ans = new int[19];
	//int[] num = new int[19];
	//String[] question = new String[19];

	//ans[i] = Integer.parseInt(request.getParameter("recommend-radio"));
	//out.println(ans[i]);
	
	// just for Test connection to database
	//ArrayList<Question> questionList=(ArrayList<Question>)request.getAttribute("questionlist");
	//Question f = questionList.get(1);
	//out.println(f.getId()+" . "+f.getQuestion());

	//num[i] = f.getId();
	//question[i] = f.getQuestion();
%>
<body>
<h1>Your Answers:</h1>
<%
ArrayList<CustomerAnswers> result=(ArrayList<CustomerAnswers>)request.getAttribute("qlist");

//for (int j=0; result!=null && j<result.size();j++){
//	CustomerAnswers ca= qlist.get(j);
//	out.println(ca.getNumber()+": "+ ca.getAnswer());
//}
%>

<table border="1">
	<tbody>
		<tr>
			<td>Number<td>
			<td>Question Text</td>
			<td>Answer</td>
		</tr>
		<tr>
			<td>Number<td>
			<td>Question Text</td>
			<td>Answer</td>
		</tr>	
		<tr>
			<td>Number<td>
			<td>Question Text</td>
			<td>Answer</td>
		</tr>
	</tbody>
</table>

</body>
</html>