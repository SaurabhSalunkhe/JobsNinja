<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>

<meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Welcome to JobsNinja</title>
  
  <link href="<c:url value="/resources/css/index.css" />" rel="stylesheet">
  <link href="<c:url value="/resources/css/footer.css" />" rel="stylesheet">
  <link href="<c:url value="/resources/css/bootstrap-tour.min.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
  <nav class="navbar navbar-default navbar-inverse" style="margin-bottom: 0px;border-radius: 0px;">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <h4><a class="navbar-brand" id="step-one" href="#" style="color:#dcbd2f;font-size: 20px;font-weight: bold;"><span class="glyphicon glyphicon-screenshot" style="color: #dcbd2f;margin-right: 5px;"></span>JobsNinja</a></h4>
      </div>
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">

          <li class="dropdown">
            <a href="#"><h4>Home</h4></a>
          </li>
    </ul>
  </div>
</div>
</nav>

<div class="container">
	<form:form method="POST" commandName="emailDetails" action="sendEmailSubmit">
	<div class="table-responsive col-md-10">
		<table class="table table-striped table-bordered">
			<tbody>
				<tr >
					<td>From:</td>
					<td>
						<div class="col-md-10">
							<form:input path="from" class="form-control" />
						</div>
					</td>
				</tr>
				<tr>
					<td>To:</td>
					<td>
						<div class="col-md-10">
							<form:input path="toName" class="form-control" />
						</div>
					</td>
				</tr>
				<tr>
					<td>Email:</td>
					<td>
						<div class="col-md-10">
							<form:input path="to" class="form-control" />
						</div>
					</td>
				</tr>
				<tr>
					<td>Subject:</td>
					<td>
						<div class="col-md-10">
							<form:input path="subject" class="form-control"/>
						</div>
					</td>
				</tr>
				
				<tr>
					<td colspan="2"><input type="submit" class="btn btn-success" value="Send" name="sendEmail"/></td>
				</tr>
			</tbody>
			</table>
		</div>
	</form:form>
</div>
					
</body>


</html>
