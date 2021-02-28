<%-- 
    Document   : error
    Created on : Feb 19, 2021, 11:34:49 PM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    <!-- Main CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
    <!-- Font-icon css-->
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">        
    <style>
        div a {
            border: 1px solid #6c757d;
            background-color:#007bff;
            color: #FFF;
            margin: 10px;
            border-radius: 10px;
            font-size: 30px;
        }
    </style>
    </head>
    <body>
        <h1 class="text text-info">This page can only be used by the authorized User</h1>
        <div>
          <a href="${pageContext.request.contextPath}/login.jsp">login</a>
          <a href="${pageContext.request.contextPath}/index.jsp">Home</a>  
        </div>
    <body>
</html>        