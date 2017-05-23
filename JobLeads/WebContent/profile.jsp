<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MUM lead position</title>
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="login.css" rel="stylesheet">
<link href="boots.css" rel="stylesheet">
</head>
<body>

	<div class='container  raw'>
		<h1 class='page.header'
			style="background-image: url('images/MUM_campus_and_tower_.JPG');">
			Job Lead Positions! <small> MUM students</small>
		</h1>

		<div class='well pull-right col-xs-7' style='margin-left:2px;'>
			<form action = 'CreateUser' method = 'post'>
				<div style="margin-left: 55px;">
					<div class='form-group form-inline'>

						<label> Full name </label> <input type='text' class='form-control'
							name='firstname' value="${loginUser.name}" placeholder='First Name'> <input
							type='text' class='form-control' name='lastname'
							placeholder='Last Name'>
					</div>
					<div class='form-group form-inline' style="margin-left: 15px;">
						<label>Gender</label> <select name='gender' class='form-control'>
							<option selected value='male'>Male</option>
							<option value='female'>Female</option>
						</select>
					</div>
					<div class='form-group form-inline' style="margin-left: 30px;">
						<label> State </label> <input type='text' class='form-control'
							name='state' value="${loginUser.state}" placeholder='state'> <label
							style="margin-left: 30px;"> City </label> <input type='text'
							class='form-control' name='city' value=${loginUser.city} placeholder='City'>
					</div>
					<div class='form-group form-inline' style="margin-left: 25px;">
						<label> Street </label> <input type='text' class='form-control'
							name='street' value="${loginUser.street}" placeholder='Street'> <label> Zip
							code </label> <input type='text' class='form-control' value=${loginUser.zip} name='zipcode'
							pattern="(\d){5}" title="Zip code must be 5 digits"
							placeholder='Zip code'>
					</div>
					<div class='form-group form-inline' style="margin-left: 0px;">
						<label> Birth Year </label> <input type='Date'
							class='form-control' name='birthyear' value="${loginUser.birthYear}" placeholder='Birth Year'>
					</div>
					<div class='form-group form-inline' style="margin-left: 28px;">
						<label> Email </label> <input type='text' class='form-control'
							name='email' value="${loginUser.email}"
							pattern="^[a-zA-Z_\-]+@(([a-zA-Z_\-])+\.)+[a-zA-Z]{2,4}$"
							title="Please Enter a valid email adress" placeholder='Email'>
					</div>
					<div class='form-group form-inline'>
						<label> Password </label> <input type='password' id= "pw"  class='form-control'
							name='password' value="${loginUser.password}" pattern="(?=\d+)(?=[a-z]+)(?=[A-Z]+){6,}" 
							title="Passward must have atleast 6 characters and atleast one letter and atleast one number"
							placeholder='Password' required>
					</div>
				</div>
				<div class='form-group form-inline'>
					<label> Confirm Password </label> <input type='text'
						class='form-control' name='repeatpassward' value="${loginUser.password}" id ='cPw'
						placeholder='Repeat password' required>
				</div>
				<p id ="pwCheck" style = "color: red; margin-left: 120px" ></p>
				<p class='text-center'>
					<button class='btn-success' class='btn-lg' id ='signup' >Sign up</button>
				<p>
				<p style="color:red">${signUpError }</p>
			</form>
		</div>		
		
		 <div id="bootstrap-touch-slider" class="carousel bs-slider fade  control-round indicators-line" data-ride="carousel" data-pause="hover" data-interval="3000" >

            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#bootstrap-touch-slider" data-slide-to="0" class="active"></li>
                <li data-target="#bootstrap-touch-slider" data-slide-to="1"></li>
                <li data-target="#bootstrap-touch-slider" data-slide-to="2"></li>
            </ol>

            <!-- Wrapper For Slides -->
            <div class="carousel-inner" role="listbox">

                <!-- Third Slide -->
                <div class="item active">

                    <!-- Slide Background -->
                    <img src="images/Global_Country_headquarters.JPG" alt="Bootstrap Touch Slider"  class="img-rounded slide-image"/>
                    <div class="bs-slider-overlay"></div>

                    <div class="container">
                        <div class="row">
                            <!-- Slide Text Layer -->
                            <div class="slide-text slide_style_left">
                                <p data-animation="animated zoomInRight" style ="color:white;">Global Country headquarters</p>                                
                            </div>
                        </div>
                    </div>
                </div>
                <!-- End of Slide -->

                <!-- Second Slide -->
                <div class="item">

                    <!-- Slide Background -->
                    <img src="images/mum-campus.jpg" alt="Bootstrap Touch Slider"  class="img-rounded slide-image"/>
                    <div class="bs-slider-overlay"></div>
                    <!-- Slide Text Layer -->
                    <div class="slide-text slide_style_center">
                        <p data-animation="animated flipInX" style ="color:white;"> Beautiful MUM Compus</p>
                        
                    </div>
                </div>
                <!-- End of Slide -->

                <!-- Third Slide -->
                <div class="item">

                    <!-- Slide Background -->
                    <img src="images/MUM_campus_and_tower_.JPG" alt="Bootstrap Touch Slider"  class="img-rounded slide-image"/>
                    <div class="bs-slider-overlay"></div>
                    <!-- Slide Text Layer -->
                    <div class="slide-text slide_style_left">
                        <h3 data-animation="animated flipInX" style ="color:white;">MUM campus and tower</h3>                        
                    </div>
                </div>
                <!-- End of Slide -->


            </div><!-- End of Wrapper For Slides -->

            
        </div> <!-- End  bootstrap-touch-slider Slider -->

	</div>


	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	
	<script type="text/javascript"  src="profile.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>