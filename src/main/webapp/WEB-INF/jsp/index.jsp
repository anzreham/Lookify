
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">

    <nav class="navbar navbar-light bg-light">
        <a class="navbar-brand" href="/songs/new">Add a new </a>
        <a class="navbar-brand" href="/songs/byorder">Top songs </a>
        <form action="/songs/search" method="post">
            <input type="text" name="st" value="">
            <input class="btn-outline-success" type="submit" value="Search Artist">
        </form>


    </nav>
    <div >
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <h1>All Songs</h1>
        <table class="table">
            <thead>
            <tr>
                <th>Title</th>
                <th>Artist</th>
                <th>Rating</th>
                <th>Action</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${songs}" var="song">
                <tr>

                    <td><a href="/song/${song.id}"> <c:out value="${song.title}"/></a></td>
                    <td><c:out value="${song.artist}"/></td>
                    <td><c:out value="${song.rating}"/></td>
                    <td>
                        <form action="/songs/${song.id}" method="post">
                            <input type="hidden" name="_method" value="delete">
                            <input type="submit" value="Delete">
                        </form>
                    </td>


                </tr>
            </c:forEach>
            </tbody>
        </table>


</div>
</body>
</html>
