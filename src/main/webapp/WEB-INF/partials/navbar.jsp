<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/index.jsp">Home</a>

            <a  class="navbar-brand" href="/search">Search</a>
            <a class="navbar-brand loggedin" style=display:none href="/profile">Profile</a>
            <a class="navbar-brand loggedin" style=display:none href="/ads/create">Create</a>

            <a class="navbar-brand" href="/ads">Adlister</a>


        </div>

        <a class="navbar-brand loggedout"  href="/login">Login</a>
        <a class="navbar-brand loggedout"  href="/register">Register</a>

        <a class="navbar-brand loggedin " style=display:none href="/logout ">Logout</a>
        <c:if test="${user != null}">
            <script>
                const elements1= document.getElementsByClassName("loggedin")
                for(let i =0; i<elements1.length; i++){
                    elements1[i].style.display = "block";
                }
                const elements2= document.getElementsByClassName("loggedout")
                for(let i =0; i<elements2.length; i++){
                    elements2[i].style.display = "none";
                }
            </script>
        </c:if>





    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
