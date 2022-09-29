<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"></jsp:include>

<html>
    <head>
        <title>Add Book</title>
    </head>
    <body>
    <div><BR><BR></div>
        <c:if test="${removeBookSuccess}">
            <div align="center">Successfully removed Book with ISBN: ${removedBook.id}</div>
            <BR><BR>
        </c:if>

        <c:url var="search_book_url" value="/library/searchBook"/>
        <form:form action="${search_book_url}" method="post" modelAttribute="search" align="center">
            <form:label path="searchString">Search Books: </form:label> <form:input type="text" path="searchString" required="required" id="searchString"/>
            <input type="submit" value="submit" id="submit"/>
        </form:form>
        <div><BR><BR></div>
    </body>
</html>
