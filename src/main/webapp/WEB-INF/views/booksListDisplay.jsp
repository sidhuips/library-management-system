<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="header.jsp"></jsp:include>

<html>
<head>
	<title>Library Management System</title>
</head>

<body>
<div align="center">
	<h2>All Books in Library</h2><BR>
	<table id="bookList" border="1">
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
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>