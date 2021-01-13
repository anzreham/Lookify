
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
    <div class="jumbotron">
        <h1>Welcome User</h1>
    </div>

    <div >

        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
        <h1>New Book</h1>
        <form:form action="/songs" method="post" modelAttribute="song">

            <p>
                <form:label path="title">Title</form:label>
                <form:errors path="title"/>
                <form:input path="title"/>
            </p>
            <p>
                <form:label path="artist">artist</form:label>
                <form:errors path="artist"/>
                <form:input path="artist"/>
            </p>

            <p>
                <form:label path="rating">rating</form:label>
                <form:errors path="rating"/>
                <form:input type="number" path="rating"/>
            </p>
            <input type="submit" value="Submit"/>
        </form:form>


    </div>
</div>
</body>
</html>
