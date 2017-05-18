<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Welcome to JobsNinja</title>

<link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/footer.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-tour.min.css" />"
	rel="stylesheet">

<script src="<c:url value="/resources/js/jquery.1.10.2.min.js" />"></script>
<script src="<c:url value="/resources/js/jquery-3.1.1.js" />"></script>
<script src="<c:url value="/resources/js/angular-1.4.4.js" />"></script>
<script src="<c:url value="/resources/js/angularfire.js" />"></script>


<!-- Latest compiled and minified CSS -->
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
<body>

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
				<h4>
					<a class="navbar-brand" id="step-one" href="#"
						style="color: #dcbd2f; font-size: 20px; font-weight: bold;"><span
						class="glyphicon glyphicon-screenshot"
						style="color: #dcbd2f; margin-right: 5px;"></span>JobsNinja</a>
				</h4>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">

					<li class="dropdown"><a href="#"><h4>Home</h4></a></li>



					<li class="dropdown" id="step-three"><a
						href="applicantsignuppage"><h4>Applicant Registration</h4></a></li>



					<li class="dropdown"><a href="employersignuppage"><h4>Employer
								Registration</h4></a></li>

				</ul>

			</div>
		</div>
	</nav>

	<div id="myCarousel" class="carousel slide" data-ride="carousel">

		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img class="first-slide"
					src="https://static1.squarespace.com/static/56606a54e4b02bb5808cfa37/t/56aac192d51cd4476b265519/1454031261152/9_job+portal_iStock_000057531182_XXXLarge.jpg?format=1500w"
					alt="First slide">
				<div class="container">
					<div class="carousel-caption" style="color: white;">
						<h1 style="color: white">Want that perfect job?</h1>
						<p style="color: white">Our website can help you get your
							career in the proper path</p>
						<p>
							<a class="btn btn-lg btn-primary"
								href="applicantsignuppage" role="button">Join us
								today</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img class="second-slide"
					src="https://owbaz.com/blog/wp-content/uploads/2016/02/Find-Jobs.jpg"
					alt="Second slide">
				<div class="container">
					<div class="carousel-caption" style="color: white;">
						<h1>Find the right career !</h1>
						<p>Find out how our website can make it possible to find the
							perfect jobs</p>
						<p>
							<a class="btn btn-lg btn-primary" href="applicantsignuppage"
								role="button">Report now</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img class="third-slide"
					src="http://www.talent-jobs.com/images/slider-img.png"
					alt="Third slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Read the success stories!</h1>
						<p>We have successfully united several employers with apt
							applicants !</p>
						<p>
							<a class="btn btn-lg btn-primary" href="applicantsignuppage"
								role="button">Browse stories</a>
						</p>
					</div>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>

	<form class="mainPageLogin" action="loginSubmit" method="POST">
		<label>
			<h4 align="center">
				Email id
				</h2>
		</label> <input type="email" placeholder="Email ID" class="form-control"
			name="email" required> <label>
			<h4 align="center">
				Password
				</h2>
		</label> <input type="password" placeholder="Password" class="form-control"
			name="password" required> <br> <select
			class="form-control" id="" name="user">
			<option value="applicant">Applicant</option>
			<option value="employer">Employer</option>
		</select> <br> <br> <br>
		<div align="center">
			<button type="submit" class="btn btn-lg btn-info">Sign in</button>
		</div>
	</form>
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


</html>
