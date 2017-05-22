<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MUM lead position</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="boots.css" rel="stylesheet">
</head>
<body>

	<div class='container'>
		<h1 class='page.header'
			style="background-image: url('images/Global_Country_headquarters.JPG');">
			Job Lead Positions! <small> MUM students</small>
		</h1>
	</div>
	<div class='container bg-info' style='margin-bottom: 20px'>
		<form class="form-inline">
			<button class='btn-info'>Job Offers</button>
			<button class='btn-info'>Job Seeks</button>
			<button class='btn-info pull-right ' style='margin-left: 5px'>
				<span class="glyphicon glyphicon-off"></span>Log out
			</button>
			<button class='btn-info pull-right ' style='margin-left: 5px'>Update
				Profile</button>
			<a style="color: brown;" title="Notification!"><span
				class="glyphicon glyphicon-bell"></span></a>
			<div class='form-group pull-right has-feedback'>
				<button style="margin-right: 10px;">
						Find Jobs
					</button>
					<input type='text' class='form-control' name='search'				
					placeholder='Fairfield, Iowa'> 
					<span class="glyphicon glyphicon-map-marker form-control-feedback"> </span>
			</div>


		</form>
	</div>
	<div class='container raw'>
		<div class=' container-fluid well col-xs-4'
			style="margin-right: 25px;">
			<form>
				<fieldset>
					<legend> suggest jobs</legend>
					<textarea class='form-control'
						style="min-width: 100%; margin-bottom: 25px;" rows="6">
				Enter job description				
			</textarea>
					<div class='form-group form-inline'>
						<label> Location: </label> <input type='text' class='form-control'
							name='search' placeholder='Enter city'>
					</div>

					<div class='text-center'>
						<input type='submit' class='btn-primary' class='btn-lg'
							value='Post'>
					</div>
				</fieldset>
			</form>
		</div>
		<div class='col-xs-5'>
			<form>
				<fieldset>
					<legend>Job posts</legend>

					posted...
					<p id="date" style="font-weight: em"></p>
					<p>Length and appearance do not determine whether a section in
						a paper is a paragraph. For instance, in some styles of writing,
						particularly journalistic</p>
					<div class="form-inline" style="margin-top: 10px;">
						<label><a><span class="glyphicon glyphicon-thumbs-up"
								aria-hidden="true"></span>Like</a> 24<%-- ${numberLike} --%></label> <label><a
							style="margin-left: 10px;"><span
								class="glyphicon glyphicon-comment"></span>Comments</a> 24 <%-- ${numberLike} --%></label>
						<div class='pull-right btn-default'>
							<label> <a> <span
									class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>
									Location
							</a>
							</label>
						</div>

					</div>
					<div class='form-group' style="margin-top: 10px;">
						<input type='text' class='form-control' name='search'
							placeholder='write Comment...'>
					</div>
					posted...
					<p id="date" style="font-weight: em"></p>
					<p>Length and appearance do not determine whether a section in
						a paper is a paragraph. For instance, in some styles of writing,
						particularly journalistic</p>
					<div class="form-inline" style="margin-top: 10px;">
						<label><a><span class="glyphicon glyphicon-thumbs-up"
								aria-hidden="true"></span>Like</a> 24<%-- ${numberLike} --%></label> <label><a
							style="margin-left: 10px;"><span
								class="glyphicon glyphicon-comment"></span>Comments</a> 24 <%-- ${numberLike} --%></label>
						<div class='pull-right btn-default'>
							<label> <a> <span
									class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>
									Location
							</a>
							</label>
						</div>

					</div>
					<div class='form-group' style="margin-top: 10px;">
						<input type='text' class='form-control' name='search'
							placeholder='write Comment...'>
					</div>
					posted...
					<p id="date" style="font-weight: em"></p>
					<p>Length and appearance do not determine whether a section in
						a paper is a paragraph. For instance, in some styles of writing,
						particularly journalistic</p>
					<div class="form-inline" style="margin-top: 10px;">
						<label><a><span class="glyphicon glyphicon-thumbs-up"
								aria-hidden="true"></span>Like</a> 24<%-- ${numberLike} --%></label> <label><a
							style="margin-left: 10px;"><span
								class="glyphicon glyphicon-comment"></span>Comments</a> 24 <%-- ${numberLike} --%></label>
						<div class='pull-right btn-default'>
							<label> <a> <span
									class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>
									Location
							</a>
							</label>
						</div>

					</div>
					<div class='form-group' style="margin-top: 10px;">
						<input type='text' class='form-control' name='search'
							placeholder='write Comment...'>
					</div>
					posted...
					<p id="date" style="font-weight: em"></p>
					<p>Length and appearance do not determine whether a section in
						a paper is a paragraph. For instance, in some styles of writing,
						particularly journalistic</p>
					<div class="form-inline" style="margin-top: 10px;">
						<label><a><span class="glyphicon glyphicon-thumbs-up"
								aria-hidden="true"></span>Like</a> 24<%-- ${numberLike} --%></label> <label><a
							style="margin-left: 10px;"><span
								class="glyphicon glyphicon-comment"></span>Comments</a> 24 <%-- ${numberLike} --%></label>
						<div class='pull-right btn-default'>
							<label> <a> <span
									class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>
									Location
							</a>
							</label>
						</div>

					</div>
					<div class='form-group' style="margin-top: 10px;">
						<input type='text' class='form-control' name='search'
							placeholder='write Comment...'>
					</div>


				</fieldset>

			</form>
		</div>
	</div>
	<script>
		var d = new Date();
		document.getElementById("date").innerHTML = d.toString();
	</script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="js/bootstrap.min.js"></script>
</body>
</html>