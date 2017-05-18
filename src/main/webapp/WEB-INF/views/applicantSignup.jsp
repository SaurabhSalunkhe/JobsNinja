<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page session="false"%>
<html>
<head>
<title>Application Sign Up</title>
<!-- Latest compiled and minified CSS -->

<link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/footer.css" />"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
</head>
<body style="background-color: ivory">
	<nav class="navbar navbar-default navbar-inverse"
		style="margin-bottom: 0px; border-radius: 0px;">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
					aria-expanded="false">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" id="step-one" href="#"
					style="color: #dcbd2f; font-size: 20px; font-weight: bold;"><span
					class="glyphicon glyphicon-screenshot"
					style="color: #dcbd2f; margin-right: 5px;"></span>JobsNinja</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
				</ul>
			</div>
		</div>
	</nav>
	<div>

		<h2>
			<i>Applicant Registration form</i>
		</h2>

		<form:form commandName="applicant" action="applicantSignUpSubmit"
			method="POST" onsubmit="return validateApplicant();">
			<div class="">
				<table class="table table-condensed">
					<tbody>
						<tr>
							<td>First Name:-</td>
							<td>
								<div class="col-sm-8">
									<form:input path="firstName" cssClass="form-control"
										name="fistName" required="required" pattern="[a-z]{1,15}"/>
									<form:errors path="firstName" cssClass="error" />
								</div>
							</td>
						</tr>
						<tr>
							<td>Last Name:-</td>
							<td>
								<div class="col-sm-8">
									<form:input path="lastName" cssClass="form-control"
										name="lastName" required="required" pattern="[a-z]{1,15}" />
									<form:errors path="lastName" cssClass="error" />
								</div>
							</td>
						</tr>
						<tr>
							<td>Contact Number:-</td>
							<td>
								<div class="col-sm-8">
									<form:input path="contactNumber" type="number"
										cssClass="form-control" name="contactNumber" />
									<form:errors path="contactNumber" cssClass="error" />
								</div>
							</td>
						</tr>
						<tr>
							<td>Email Address:-</td>
							<td>
								<div class="col-sm-8">
									<form:input path="emailId" cssClass="form-control"
										name="emailId" required="required" />
									<form:errors path="emailId" cssClass="error" />
								</div>
							</td>
						</tr>
						<tr>
							<td>Enter Password:-</td>
							<td>
								<div class="col-sm-8">
									<input type="password" id="password1" class="form-control"
										name="password2" required="required">
									<form:errors path="password" cssClass="error" />
								</div>
							</td>
						</tr>
						<tr>
							<td>Confirm Password:-</td>
							<td>
								<div class="col-sm-8">
									<form:password path="password" id="password2"
										cssClass="form-control" name="password" required="required" />
									<form:errors path="password" cssClass="error" />
								</div>
							</td>
						</tr>
						<td>
							<div align="center">
								<input type="submit" name="applicantinfo" value="Submit "
									class="form-control btn btn-info" />

							</div>
						</td>
						</tr>
					</tbody>
				</table>
			</div>
		</form:form>
	</div>
	<footer class="footer-distributed">
		<div class="footer-left">
			<h3>
				NU<span>Finder</span>
			</h3>
			<p class="footer-links">
				<a href="#">Home</a> · <a href="pages/userStories.html">Testimonials</a>
				· <a href="pages/contactus.html">Contact</a>
			</p>
			<p class="footer-company-name">NUFinder © 2016</p>
		</div>
		<div class="footer-center">
			<div>
				<i class="fa fa-map-marker"></i>
				<p>
					<span>360 Huntington Ave</span> Boston, MA 02115
				</p>
			</div>
			<div>
				<i class="fa fa-phone"></i>
				<p>+1 8575 2206 12</p>
			</div>
			<div>
				<i class="fa fa-envelope"></i>
				<p>
					<a href="mailto:meanstackdevelopers@gmail.com">meanstackdevelopers@gmail.com</a>
				</p>
			</div>
		</div>
		<div class="footer-right">
			<p class="footer-company-about">
				<span>About the company</span> We at NUFinder, aim to help the
				Northeastern community by locating and reporting all types of lost
				items.
			</p>
			<div class="footer-icons">
				<a href="https://www.facebook.com/"><img
					src="images/facebook.png"></a> <a href="https://www.twitter.com"><img
					src="images/twitter.png"></a> <a href="https://www.linkedin.com"><img
					src="images/linkedin.png"></a> <a href="https://www.github.io"><img
					src="images/github.png"></a>
			</div>
		</div>
	</footer>
</body>
<script type="text/javascript">
	function validateApplicant() {

		var password1 = document.getElementById('password1');

		if (password1.value.length < 4) {
			alert('Password should have least 4 characters ');
			return false;
		}
		var password2 = document.getElementById('password2');
		if (password1.value != password2.value) {
			alert('Your passwords do not match.');
			return false;
		}
		return true;
	}
</script>
</html>
