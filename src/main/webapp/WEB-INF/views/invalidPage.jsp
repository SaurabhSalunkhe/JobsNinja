<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix = "form" %>
<%@ page session="false" %>
<html>
<head>

	  <link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
  <link href="<c:url value="/resources/css/footer.css" />" rel="stylesheet">
	<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body style="background-color:ivory">

<h2>Please check your credentials </h2>


	  <footer class="footer-distributed">
      <div class="footer-left">
        <h3>NU<span>Finder</span></h3>
        <p class="footer-links">
          <a href="#">Home</a>
          ·
          <a href="pages/userStories.html">Testimonials</a>
          ·
          <a href="pages/contactus.html">Contact</a>
        </p>
        <p class="footer-company-name">NUFinder © 2016</p>
      </div>
      <div class="footer-center">
        <div>
          <i class="fa fa-map-marker"></i>
          <p><span>360 Huntington Ave</span> Boston, MA 02115</p>
        </div>
        <div>
          <i class="fa fa-phone"></i>
          <p>+1 8575 2206 12</p>
        </div>
        <div>
          <i class="fa fa-envelope"></i>
          <p><a href="mailto:meanstackdevelopers@gmail.com">meanstackdevelopers@gmail.com</a></p>
        </div>
      </div>
      <div class="footer-right">
        <p class="footer-company-about">
          <span>About the company</span>
          We at NUFinder, aim to help the Northeastern community by locating and reporting all types of lost items.
        </p>
        <div class="footer-icons">
          <a href="https://www.facebook.com/"><img src="images/facebook.png"></a>
          <a href="https://www.twitter.com"><img src="images/twitter.png"></a>
          <a href="https://www.linkedin.com"><img src="images/linkedin.png"></a>
          <a href="https://www.github.io"><img src="images/github.png"></a>
        </div>
      </div>
    </footer>
</body>
</html>
