<!-- taglib to support JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<title>Logs</title>

<!-- * Reference to style sheet ${pageContext.request.contextPath} gives proper name of our application
	 * We are using expression language syntax below to get the context path
	 * You can also embed java code in jsp using different tags
	 * Problem with embeded java or expression language is that if the string that gets evaluated has symbols that HTML interprets then your HTML wont look good
	 * Hence its better to use JSTL where possible
 -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<table>
				<tr>
					<th>S3 Logs</th>
				</tr>

				<!-- * Loop over and print our customers 
				 	 * This is JSTL for-loop
				-->
				<c:forEach var="currentS3Log" items="${s3Logs}">

					<tr>
						<td>${currentS3Log}</td>

					</tr>

				</c:forEach>

			</table>

		</div>

	</div>
	
	<div id="container">

		<div id="content">

			<table>
				<tr>
					<th>SQS Logs</th>
				</tr>

				<c:forEach var="currentSqsLog" items="${sqsLogs}">

					<tr>
						<td>${currentSqsLog}</td>

					</tr>

				</c:forEach>

			</table>

		</div>

	</div>
	

</body>

</html>