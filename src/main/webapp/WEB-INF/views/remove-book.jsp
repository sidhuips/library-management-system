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
        
        <c:if test="${bookDoesNotExist}">
            <div align="center">No book found with ISBN: ${removedBook.id}</div>
            <BR><BR>
        </c:if>

        <c:url var="add_book_url" value="/library/removeBook"/>
        <form:form action="${add_book_url}" method="post" modelAttribute="book" align="center">
            <form:label path="id">ISBN: </form:label> <form:input type="text" path="id" required="required"/>
            <input type="submit" value="submit"/>
        </form:form>
        <div><BR><BR></div>
    </body>
</html>
