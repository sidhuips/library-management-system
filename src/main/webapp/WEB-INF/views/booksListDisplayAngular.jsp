<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="header.jsp"></jsp:include>
<html>
<head>
<title>Library Management System</title>
</head>

<body ng-app="myCrudApp" class="ng-cloak">
	<div align="center" class="generic-container"
		ng-controller="LibraryController as ctrl">
		<h2>All Books in Library Using Angular and REST</h2>
		<BR>
		<table border="1">
			<tr>
				<th>Book Id</th>
				<th>Book Name</th>
				<th>Author</th>
				<th>Book Type</th>
			</tr>
			<tr ng-repeat="b in ctrl.books">
				<td><span ng-bind="b.id"></span></td>
				<td><span ng-bind="b.bookName"></span></td>
				<td><span ng-bind="b.author"></span></td>
				<td><span ng-bind="b.type"></span></td>
			</tr>
		</table>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.js"></script>
	<script src="<c:url value='../static/app.js' />"></script>
	<script src="<c:url value='../static/libraryService.js' />"></script>
	<script src="<c:url value='../static/libraryController.js' />"></script>
</body>
</html>
<jsp:include page="footer.jsp"></jsp:include>
