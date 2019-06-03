
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta charset="UTF-8">
<title>MIW Autobuses</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.5/css/bootstrap.min.css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script
	src="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker.min.css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js"></script>

<script>
	$(document).ready(function() {
		$('#departureDate').datepicker();
		$('#arriveDate').datepicker();
	});
</script>

</head>
<body>
	<h1 class="text-center">
		<spring:message code="title" />
	</h1>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<h4 class="text-center">
					<spring:message code="SearchTitle" />
				</h4>
				<c:if test = "${errors}">
				<div class="alert alert-danger" role="alert">
				  <spring:message code= "${errorCode}"/>
				</div>				
				</c:if>
				<form:form modelAttribute="index">
					<div class="form-row">
						<div class="col">
							<label for="originId"><spring:message code="origin" /></label>
							<form:select class="form-control" path="originId" id="originId">
								<form:option value="-1" label="Select" />
								<form:options items="${cities}" />
							</form:select>
						</div>
						<div class="col">
							<label for="destinationID"><spring:message
									code="destination" /></label>
							<form:select class="form-control" path="destinationId"
								id="destinationID">
								<form:option value="-1" label="Select" />
								<form:options items="${cities}" />
							</form:select>
						</div>
					</div>
					<div class="form-row">
						<div class="col">
							<label for="departureDate"> <spring:message
									code="fechaIdaLabel" />
							</label>
							<form:input type="text" path="departureDate"
								data-date-format="dd/mm/yyyy" id="departureDate"
								name="departureDate" class="form-control" />
						</div>
						<div class="col">
							<label for="arriveDate"> <spring:message
									code="fechaVueltaLabel" />
							</label> <form:input type="text" path="arriveDate"
								data-date-format="dd/mm/yyyy" id="arriveDate" name="arriveDate"
								class="form-control" />
						</div>
					</div>
					<div class="form-row">
						<div class="col">
							<label for="passengers"> <spring:message
									code="numeroViajeros" />
							</label> 
							<form:input type="number" path="passengers" id="passengers"
								name="passengers" class="form-control" />
						</div>
					</div>
					<br>
					<button type="submit" class="btn btn-default btn-block">
						<spring:message code="buscar" />
					</button>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-12 text-center">
				<spring:message code="contadorVisitas" />
				<c:out value="${visitCounter.logins}" />
			</div>
		</div>
	</div>
</body>
</html>
