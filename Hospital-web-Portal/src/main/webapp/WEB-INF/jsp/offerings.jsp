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
<title>Offerings</title>

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

<style>
</style>

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

				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbardrop"
					data-toggle="dropdown"> View </a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="/getspecialists">Specialists</a> <a
							class="dropdown-item" href="/getallpatients">Registered
							Patients</a>
							<a
							class="dropdown-item" href="/insurerdetails">Insurer Details</a>
					</div></li>

				<li class="nav-item"><a class="nav-link" href="/registerpatient">Register Patients</a></li>
				<li class="nav-item"><a class="nav-link" href="/claiminsurance">Claim Insurance</a></li>

			</ul>

			<form class="form-inline" action="/logout">
				<button class="btn btn-danger" type="submit">Log Out</button>
			</form>
		</div>
	</nav>
	<br>

	<div class="container">
		<h1 class="display-4 text-danger mt-5">Welcome ${name }</h1>

	</div>

	<div class="container">

		<div style="position: relative; top: 40px">
			<h2>Service Offerings</h2>
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Ailment</th>
						<th>Cost</th>
						<th>Test Details</th>
						<th>Treatment Duration</th>
						<th>Treatment Package</th>
					</tr>
				</thead>

				<tbody>
					<c:forEach items="${allPackages }" var="package">
						<tr>
							<td>${package.ailmentCategory }</td>
							<td>${package.packageDetails.cost }</td>
							<td>${package.packageDetails.testDetails }</td>
							<td>${package.packageDetails.treatmentDuration }</td>
							<td>${package.packageDetails.treatmentPackageName }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>