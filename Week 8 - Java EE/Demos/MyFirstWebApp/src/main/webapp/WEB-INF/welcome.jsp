<%--
  Created by IntelliJ IDEA.
  User: janjakovacevic
  Date: 09/11/2020
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sparta Global</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="webjars/bootstrap/4.5.2/css/bootstrap.css">
    <link rel="stylesheet" href="resources/css/style_welcome.css">
</head>
<body>
<div class="jumbotron">
    <h1 class="display-4">Hello, ${username}</h1>
    <p class="lead">You have successfully navigated to the welcome page!</p>
    <hr class="my-4">
    <p>If you wish to logout, click on the button below. </p>
    <form method="get" action="logout">
        <button type="submit">Logout</button>
    </form>
</div>
</body>
</html>
