<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
    <div class="container">
        <h1>Create a new Ad</h1>
        <form action="/ads/create" method="post">
            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text"></textarea>
            </div>
            <div class="form-group">
            <input type="checkbox" id="category1" name="category" value="Music">
                <label for="category1">Music</label>

                <input type="checkbox" id="category2" name="category" value="Game">
                <label for="category2">Game</label>

                <input type="checkbox" id="category3" name="category" value="Job">
                <label for="category3">Jobs</label>

                <input type="checkbox" id="category4" name="category" value="Food">
                <label for="category4">Food</label>

                <input type="checkbox" id="category5" name="category" value="Selling">
                <label for="category5">Selling</label>

                <input type="checkbox" id="category6" name="category" value="Anime">
                <label for="category6">Anime</label>

                <input type="checkbox" id="category7" name="category" value="Other">
                <label for="category7">Other</label>

            </div>
            <input type="submit" class="btn btn-block btn-primary">
        </form>
    </div>
</body>
</html>
