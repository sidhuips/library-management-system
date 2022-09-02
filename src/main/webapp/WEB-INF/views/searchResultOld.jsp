<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<jsp:include page="header.jsp"></jsp:include>

<html>
<head>
	<title>Library Management System</title>
</head>
<!-- <Script>
$("#buttton1").click(function(){
    $.ajax({
        url : 'start',
        method : 'GET',
        async : false,
        complete : function(data) {
            console.log(data.responseText);
        }
    });

});
</Script> -->
<body>
<div>
<table class="table table-striped">
			<thead>
				<tr>
			<th>ISBN</th>
			<th>Book Name</th>
			<th>Author</th>
			<th>Book Type</th>
				</tr>
			</thead>

			<c:forEach var="book" items="${books}">
			    <tr>
				<td>${book.id}</td>
				<td>${book.bookName}</td>
				<td>${book.author}</td>
				<td>${book.type}</td>
				<td>
				  <spring:url value="/library/delete/1" var="deleteUrl" /> 

				  <button class="btn btn-danger" 
                                          onclick="window.location.href='${deleteUrl}')">Delete</button>
                                </td>
			    </tr>
			</c:forEach>
		</table>

	</div>
<%-- <div align="center">
	<h2>All Books in Library</h2><BR>
	<table border="1">
		<tr>
			<th>ISBN</th>
			<th>Book Name</th>
			<th>Author</th>
			<th>Book Type</th>
		</tr>
		<c:forEach items="${books}" var="book">
			<tr>
				<td>${book.id}</td>
				<td>${book.bookName}</td>
				<td>${book.author}</td>
				<td>${book.type}</td>
				<td>
				<spring:url value="/library-management-system/library/delete/1" var="deleteUrl" />
				<button class="btn btn-danger" 
                                          onclick="this.disabled=true;post('${deleteUrl}')">Delete</button></td>
				<td><input id="buttton1" onclick = "post(/library-management-system/library/delete/${book.id})" type = "button" value="Delete"></td>
			</tr>
		</c:forEach>
	</table>
</div> --%>
</body>
</html>