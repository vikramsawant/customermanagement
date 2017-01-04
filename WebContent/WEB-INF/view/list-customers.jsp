<!-- taglib to support JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<title>List Customers</title>

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

			<input type="button" value="Add Customer"
				onclick="window.location.href='add'; return false;"
				class="add-button" />

			<table>
				<tr>
					<th>Customer ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Phone</th>
					<th>Action</th>
				</tr>

				<!-- * Loop over and print our customers 
				 	 * This is JSTL for-loop
				-->
				<c:forEach var="currentCustomer" items="${customers}">

					<tr>
						<td>${currentCustomer.id}</td>
						<td>${currentCustomer.FName}</td>
						<td>${currentCustomer.LName}</td>
						<td>${currentCustomer.EMail}</td>
						<td>${currentCustomer.phone}</td>
						<td>
							<!-- * Construct an "update" link and embed customer id 
								 * This will send controller a request with customerId in url (GET : ?customerId=2)
							--> 
							<c:url
								var="updateLink" value="/customer/update">
								<c:param name="customerId" value="${currentCustomer.id}" />
							</c:url> 
							<!-- Display the update link --> 
							<a href="${updateLink}">Update</a>
						</td>

					</tr>

				</c:forEach>

			</table>

		</div>

	</div>

</body>

</html>