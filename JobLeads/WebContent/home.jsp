<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MUM lead position</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- <link href="boots.css" rel="stylesheet"> -->
<link href="home.css" rel="stylesheet">
</head>
<body>
	<div class='container'>		
		<h1 class='page.header'
				style="background-image: url('images/Global_Country_headquarters.JPG');">
				Job Lead Positions! <small> MUM students</small>
			</h1>
		<div class='page-select-btns'>
			<button id='jobOfferBtn' class='btn-info'>Job Offers</button>
			<button id='jobSeekBtn' class='btn-info'>Job Seeks</button>
			<button id='weatherInfoBtn' class='btn-info'>Weather info</button>
		</div>
		<div class='container bg-info pull-left nav-bar'
			style='margin-bottom: 20px'>
			<form action='login.html' method='get'>
				<button class='btn-info pull-right ' style='margin-left: 5px'>
					<span class="glyphicon glyphicon-off"></span>Log out
				</button>
			</form>
			<form action='UpdateUser' method='get' class="form-inline">
				<button class='btn-info pull-right ' style='margin-left: 5px'>Update
					Profile</button>
				<a class='pull-right' style="color: brown; margin-left: 5px;"
					title="Notification!"><span class="glyphicon glyphicon-bell"></span></a>
				<div class='form-group pull-right has-feedback'>
					<button style="margin-right: 10px;">Find Jobs</button>
					<input type='text' class='form-control' name='search'
						placeholder='Fairfield, Iowa'> <span
						class="glyphicon glyphicon-map-marker form-control-feedback">
					</span>
				</div>
			</form>
		</div>
		<div class='container' id='jobOffer'>
			<div class='container raw'>
				<div class=' container-fluid well col-xs-4'
					style="margin-right: 25px;">
					
						<fieldset>
							<legend> Suggest jobs</legend>
							<textarea class='form-control' name = 'offerTextArea' id = 'offersTextArea'
								style=" margin-bottom: 25px;" rows="6">
				Enter job description				
			</textarea>
							<div class='form-group form-inline'>
								<label> Location: </label> <input type='text'
									class='form-control' name='addLocation' id = 'locationSearch' placeholder='Enter city'>
							</div>

							<div class='text-center'>
								<input type='submit' id ='postSubmit'class='btn-primary' class='btn-lg'
									value='Post'>
							</div>
						</fieldset>
					
				</div>
				<div class='col-xs-5' >
					
						<fieldset>
							<legend>Job posts</legend>
							<div class="scrollPost" id = 'addPost'> </div>
                            <div class="scrollPost" id = 'divPost'> </div>
							posted...
							<p id="date" style="font-weight: em"></p>
							<p>Length and appearance do not determine whether a section
								in a paper is a paragraph. For instance, in some styles of
								writing, particularly journalistic</p>
							<div class="form-inline" style="margin-top: 10px;">
								<label><a><span
										class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>Like</a>
									24<%-- ${numberLike} --%></label> <label><a
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
							<div  style="margin-top: 10px;">
								<input type='text' class='form-control' name='search'
									placeholder='write Comment...'>
							</div>
							</fieldset>						
				</div>
			</div>
		</div>
		<div class='container' id='jobSeek'>

			<div class='container raw'>
				<div class=' container-fluid well col-xs-4'
					style="margin-right: 25px;">
					<form>
						<fieldset>
							<legend> Seeking jobs</legend>
							<textarea class='form-control'
								style="min-width: 100%; margin-bottom: 25px;" rows="6">
				Enter job description				
			</textarea>
							<div class='form-group form-inline'>
								<label> Location: </label> <input type='text'
									class='form-control' name='search' placeholder='Enter city'>
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
							<legend>Job Seeks</legend>

							posted...
							<p id="date" style="font-weight: em"></p>
							<p>Length and appearance do not determine whether a section
								in a paper is a paragraph. For instance, in some styles of
								writing, particularly journalistic</p>
							<div class="form-inline" style="margin-top: 10px;">
								<label><a><span
										class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>Like</a>
									24${numberLike}</label> <label><a style="margin-left: 10px;"><span
										class="glyphicon glyphicon-comment"></span>Comments</a> 24
									${numberLike}</label>
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
							<p>Length and appearance do not determine whether a section
								in a paper is a paragraph. For instance, in some styles of
								writing, particularly journalistic</p>
							<div class="form-inline" style="margin-top: 10px;">
								<label><a><span
										class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>Like</a>
									24${numberLike}</label> <label><a style="margin-left: 10px;"><span
										class="glyphicon glyphicon-comment"></span>Comments</a> 24
									${numberLike}</label>
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
		</div>
       <div class ='container' id = 'weatherInfo'>
       I am wating for you Mr. Tsegay
	</div>
	</div>
	<script src = js/jquery-dateFormat.min.js>
			 
		</script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="home.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>