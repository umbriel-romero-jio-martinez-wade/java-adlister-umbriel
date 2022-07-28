<%--
  Created by IntelliJ IDEA.
  User: levengrim
  Date: 7/27/22
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/results2" method="get">
  <label for="search"></label>
  <input type="text" name="search" id="search">

    <button type="submit">Submit</button>

</form>
<form action="/results" method="get">
    <label for="cat-search">Search BY Category</label>
    <input type="text"name="cat-search" id="cat-search" >
    <button type="submit">Submit</button>
</form>
</body>
</html>
