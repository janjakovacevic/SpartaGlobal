<%@ page import="java.time.LocalDate" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>This is my JSP</h1>
<%
    out.print(LocalDate.now());
%>
</body>
</html>
