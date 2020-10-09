<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1" name="viewport"
	content="width=device-width, initial-scale=1">
<title>Treatment Plan</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
	integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
	crossorigin="anonymous"></script>



<!-- <link href="css/custom.css" type="text/css" rel="stylesheet">  -->
</head>
<body>

	<nav class="navbar navbar-expand-md bg-dark navbar-dark">
		<a class="navbar-brand" href="/viewallpackages">International
			Patient Treatment Management System </a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#collapsibleNavbar">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavbar">
			<ul class="navbar-nav  ml-auto">



			</ul>

			<form class="form-inline" action="/logout">
				<button class="btn btn-danger" type="submit">Log Out</button>
			</form>
		</div>
	</nav>
	<br>
	<div class="container">
		<form>
			<h2 class="display-4 text-danger mt-5"><strong>Patient Details</strong></h2>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label for="name">Name of the Patient</label> <input type="text"
						class="form-control" name="name"
						value='<c:out value="${patientdetails.name}"/>'
						readonly="readonly">

				</div>
				<div class="form-group col-md-6">
					<label for="age"><strong>Age of the Patient</strong></label> <input type="number"
						class="form-control" name="age"
						value='<c:out value="${patientdetails.age}"/>' readonly="readonly">

				</div>
			</div>
			<div class="form-group">
				<label for="ailment"><strong>Ailment</strong></label> <input type="text"
					class="form-control" name="ailment"
					value='<c:out value="${patientdetails.ailment}"/>'
					readonly="readonly">

			</div>
			<div class="form-group">
				<label for="treatmentPackageName">Package for Patient</label> <input
					type="text" class="form-control" name="treatmentPackageName"
					value='<c:out value="${patientdetails.treatmentPackageName}"/>'
					readonly="readonly">

			</div>
			<div class="form-group">

				<label for="treatmentCommencementDate"><strong>Treatment
					Commencement Date</strong></label> <input type="date" class="form-control"
					name="treatmentCommencementDate"
					value='<c:out value="${patientdetails.treatmentCommencementDate}"/>'
					readonly="readonly">



			</div>

			<div class="container">

				<div style="position: relative; top: 40px">
					<h2 class="display-4 text-danger mt-5">Patient Treatment Plan</h2>
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Package Name</th>
								<th>Test Details</th>
								<th>Cost</th>
								<th>Specialists Name</th>
								<th>Area Of Expertise</th>
								<th>Experience</th>
								<th>Contact Number</th>
								<th>Treatment Commencement Date</th>
								<th>Treatment End date</th>
								<th>Treatment Status</th>

							</tr>
						</thead>

						<tbody>

							<tr>
								<td>${treatmentPlan.packageName }</td>
								<td>${treatmentPlan.testDetails }</td>
								<td>${treatmentPlan.cost }</td>
								<td>${treatmentPlan.specialist.name }</td>
								<td>${treatmentPlan.specialist.areaOfExpertise }</td>
								<td>${treatmentPlan.specialist.experienceInYears }</td>
								<td>${treatmentPlan.specialist.contactNumber }</td>
								<td>${treatmentPlan.treatmentCommencementDate }</td>
								<td>${treatmentPlan.treatmentEndDate }</td>
								<td><p class="text-info"><strong>In Progress</strong></p></td>


							</tr>

						</tbody>
					</table>
				</div>
			</div>


		</form>
	</div>
</body>
</html>