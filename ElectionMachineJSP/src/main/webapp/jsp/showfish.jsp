<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
 <%@ page import="java.util.ArrayList" %>   
 <%@ page import="data.Fish" %>   
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fish application</title>

<link rel="stylesheet" type="text/css" href="mycssfilesomewhere.css">
<script src="myscriptfile.js"></script>

</head>
<body>
<h2>Fish application</h2>
<ol>
<c:forEach var="fish" items="${requestScope.fishlist}" >
<li>${fish.id}: ${fish.breed} <a href='/delete?id=${fish.id}'>delete</a> <a href='/readtoupdate?id=${fish.id}'>update</a>
</c:forEach>
</ol>

<%
ArrayList<Fish> fishList=(ArrayList<Fish>)request.getAttribute("fishlist");

for (int i=0;fishList!=null && i<fishList.size();i++){
	Fish f=fishList.get(i);
	out.println(f.getId()+": "+f.getBreed()+"<a href='/delete?id="+f.getId()+"'>delete</a> <a href='/readtoupdate?id="+f.getId()+"'>update</a>");
}
%>

<%@ include file="../html/somehtml.html" %>



</body>
</html>