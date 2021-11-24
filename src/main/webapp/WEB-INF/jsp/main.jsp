<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>JSP Title</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>    
</head>
<body>
    <h1>Main Jsp Page 222</h1>

    <c:forEach var="item" items="${list}">
        <p>${item.ID}</p>
        <p>${item.NAME}</p>
        <p>${item.EMAIL}</p>
    </c:forEach>
</body>
</html>