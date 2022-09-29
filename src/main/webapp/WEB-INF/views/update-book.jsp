<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="header.jsp"></jsp:include>

<html>
    <head>
        <title>Update Book</title>
    </head>
    <body>
    <div><BR><BR></div>
        <c:if test="${updateBookSuccess}">
            <div align="center">Successfully updated Book with ISBN: ${updatedBook.id}</div>
            <BR><BR>
        </c:if>
        
        <c:if test="${bookDoesNotExist}">
            <div align="center">No book found with ISBN: ${updatedBook.id}</div>
            <BR><BR>
        </c:if>

        <c:url var="update_book_url" value="/library/updateBook"/>
        <form:form action="${update_book_url}" method="post" modelAttribute="book" align="center">
            <form:label path="id">ISBN:* </form:label> <form:input type="text" path="id" required="required" id = "isbn"/>
            <form:label path="bookName">Book Name: </form:label> <form:input type="text" path="bookName" id="bookName"/>
            <form:label path="author">Author Name: </form:label> <form:input path="author"/>
            <form:label path="type">Book Type: </form:label> <form:input path="type"/>
            <input type="submit" value="submit" id = "submit"/>
        </form:form>
        <div><BR><BR></div>
    </body>
</html>