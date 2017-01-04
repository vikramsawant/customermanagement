<!-- This taglib is for support of Spring MVC form tags -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<title>Add/Update Customer</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Add/Update Customer</h3>

		<form:form action="addOrUpdate" modelAttribute="customer"
			method="POST">
			<!-- * This form is re-used between add and update functionalities 
				 * We are adding this hidden field on the form which will contain primary key(id) of customer being updated
			 	 * This field will not contain any value if customer is being newly created.
			 	 * Remember to set primary keys of sub objects as well (address.id in this case)
			 -->
			<form:hidden path="id" />

			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="fName" /> <br /> <font color="red"> 
						<!-- * form:errors is a special spring mvc tag
							 * If there no errors this tag will not output
						--> 
							<form:errors path="fName" />
						</font></td>
					</tr>

					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lName" /> <br /> <font color="red">
								<form:errors path="lName" />
						</font></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="eMail" /> <br /> <font color="red">
								<form:errors path="eMail" />
						</font></td>
					</tr>

					<tr>
						<td><label>Phone:</label></td>
						<td><form:input path="phone" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				</tbody>
			</table>
		</form:form>

		<div style="clear: both;"></div>

		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
		</p>
	</div>
</body>

</html>
