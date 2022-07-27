
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>These are the results for ${search}</h1>
<c:forEach var="ad" items="${ads}">
    <di>
        <h1>Title: ${ad.title}</h1>
        <p>Description: ${ad.description}</p>
    </di>
</c:forEach>

</body>
</html>
