<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fish application</title>
</head>
<body>
<h2>Edit fish</h2>
<form action='update' method='post'>
Fish id: <input type='text' name='id' value='${requestScope.fish.id}' readonly><br> 
Fish breed: <input type='text' name='breed' value='${requestScope.fish.breed}'><br>
<input type='submit' name='ok' value='Send'> 
</form>
</body>
</html>