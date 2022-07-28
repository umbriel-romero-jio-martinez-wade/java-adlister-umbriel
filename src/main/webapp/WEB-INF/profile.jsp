<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${profileUsername}!</h1>
    </div>
    <h2>Here are your Ads !</h2>
    <a href="/userupdate?user=<c:out value="${user.id}"/>"><h2>edit UserProfile</h2></a>
    <c:forEach var="ad" items="${profileAds}">
        <div class="col-md-6">
            <h4>Posted by:<c:out value="${username}"/></h4>
            <a href="/ad?adId=<c:out value="${ad.id}"/>"><h2><c:out value="${ad.title}"/></h2></a>
            <p><c:out value="${ad.description}"/></p>
            <a href="/profile/ads/delete?delId=<c:out value="${ad.id}"/>"><p>delete</p></a>
            <a href="/update?updateId=<c:out value="${ad.id}"/>"><p>update</p></a>
        </div>
    </c:forEach>

</body>
</html>
