<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/WEB-INF/partials/head.jsp"%>
    <title>hello?</title>
</head>
<body>
<%@include file="/WEB-INF/partials/navbar.jsp"%>
<div class="col-md-6">
    <h4>Posted by:<c:out value="${username.username}"/></h4>
    <h2><c:out value="${ad.title}"/></h2>
    <p><c:out value="${ad.description}"/></p>
</div>
</body>
</html>
