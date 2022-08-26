<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org" class="h-100">
<head>
    <meta charset="UTF-8">
    <title>Spring MVC</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link th:href="@{styles/main.css}" rel="stylesheet" />
</head>
<body class="d-flex flex-column h-100">

<div th:replace="~{fragments/header :: header}"> </div>


<main role="main" class="flex-shrink-0">
<BR>
    <div class="container mt-5">
        <div class="jumbotron">
            <h1 class="display-4"></h1>
        </div>
         <c:if test="${displayheader=='false'}">
            
        
        <div>
            <h5><a href="/library-management-system/library/addBook">Add Book</a> &nbsp
	    <a href="/library-management-system/library/addBook">Remove Book</a></h5>
        </div>
        </c:if>
    </div>
</main>


<div  th:replace="~{fragments/footer :: footer}"> </div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha256-4+XzXVhsDmqanXGHaHvgh1gMQKX40OUvDEBTu8JcmNs="
        crossorigin="anonymous">
</script>
<script
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.bundle.min.js">
</script>
</body>
</html>