<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Update Ad"/>
    </jsp:include>
</head>
<body>
<div class="container">
    <h1>Update your Ad</h1>

    <form action="/update?updateId=<c:out value="${updateId}"/>" method="post">
        <div class="form-group">
            <label for="title">Title</label>
            <input id="title" name="title" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control" type="text"></textarea>
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>
</div>
<script>
    var form = document.getElementsByTagName('form')[0];
    form.addEventListener('submit', function (e) {
        let title = document.getElementById('title').value;
        var description = document.getElementById('description').value;
        if (title == '' || description == '') {
            e.preventDefault();
            alert('Please fill out all fields.');
        }
    });
</script>
</body>
</html>
