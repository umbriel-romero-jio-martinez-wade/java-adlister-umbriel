<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!"/>
    </jsp:include>
</head>
<body>
<jsp:include page="partials/navbar.jsp"/>
<div class="container">
    <h1>Please fill in your information.</h1>
    <form action="/register" method="post">
        <div class="form-group">
            <label for="username">Username</label>
            <input id="username" name="username" class="form-control" type="text" value="<c:out value="${username}"/>">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input id="email" name="email" class="form-control" type="text" value="<c:out value="${email}"/>">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input id="password" name="password" class="form-control" type="password"
                   value="<c:out value="${password}"/>">
        </div>
        <div class="form-group">
            <label for="confirm_password">Confirm Password</label>
            <input id="confirm_password" name="confirm_password" class="form-control" type="password"
                   value="<c:out value="${passwordConfirmation}"/>">
        </div>
        <input type="submit" class="btn btn-primary btn-block">
    </form>
</div>
<script>
    /* alert user if form is not filled out */
    var form = document.getElementsByTagName('form')[0];
    form.addEventListener('submit', function (e) {
        var username = document.getElementById('username').value;
        var email = document.getElementById('email').value;
        var password = document.getElementById('password').value;
        var confirm_password = document.getElementById('confirm_password').value;
        if (username == '' || email == '' || password == '' || confirm_password == '') {
            e.preventDefault();
            alert('Please fill out all fields.');
        } else if (username == username) {
            alert("Sorry that username is taken");
        }
    });

</script>
</body>
</html>
