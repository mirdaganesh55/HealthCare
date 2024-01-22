<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
 
<f:view>
	<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Hospital</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="https://use.fontawesome.com/releases/v5.0.8/css/all.css"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="css/style1.css">
<link rel="stylesheet" href="css/style2.css">
<link rel="stylesheet" href="css/style3.css">
<style>
/* Add your styles here */
 

            .navbar {
                overflow: hidden;
                background-color: #333;
            }

            .navbar a {
                float: left;
                display: block;
                color: white;
                text-align: center;
                padding: 14px 16px;
                text-decoration: none;
            }

            .dropdown {
                float: left;
                overflow: hidden;
            }

            .dropdown .dropbtn {
                font-size: 16px;
                border: none;
                outline: none;
                color: white;
                padding: 14px 16px;
                background-color: inherit;
                font-family: inherit;
                margin: 0;
            }

            .navbar a:hover, .dropdown:hover .dropbtn {
                background-color: #ddd;
                color: black;
            }

            .dropdown-content {
                display: none;
                position: absolute;
                background-color: #f9f9f9;
                min-width: 160px;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                z-index: 1;
            }

            .dropdown-content a {
                float: none;
                color: black;
                padding: 12px 16px;
                text-decoration: none;
                display: block;
                text-align: left;
            }

            .dropdown-content a:hover {
                background-color: #ddd;
            }

            .dropdown:hover .dropdown-content {
                display: block;
            }

            .new-page-container {
                margin: 20px;
                padding: 15px;
                background-color: #1daac7;
                border: 1px solid #ccc;
                text-align: center;
            }

            .new-page-heading {
                color: #333;
                font-size: 24px;
                margin-bottom: 10px;
                align-content: center;
            }

            .logout-link {
                float: right;
                margin-right: 10px;
            }

            .logout-link2 {
                float: right;
                margin-right: -75px;
            }

            .container1 {
                width: 100%;
                height: 70%;
                position: relative;
                background: #B20DAA;
                overflow: hidden;
            }

            body {
                background: url('ray-mallick-5J1bHRX1fNw-unsplash.jpg') ;
                background-size: cover;
            }  
            img {
    overflow-clip-margin: content-box;
    overflow: clip;
}
</style>
</head>
<body>


	
	<div>
	 <div class="new-page-container">
	  <a href="AdminLogin.jsf" class="logout-link">Logout</a><br/>
                <a href="Reset.jsf" class="logout-link2">Reset Password</a>
                <h3 class="new-page-heading">Welcome to the Admin DashBoard!</h3>
                <p>This is the admin dashboard where you can manage various aspects of the system.</p>
	
            </div>
 </div>
	<div class="navbar">
		<a href="#home">Home</a> 
			
 
		<div class="dropdown">
                <button class="dropbtn">Pharmacy <i class="fa fa-caret-down"></i></button>
                <div class="dropdown-content">
                    <a href="#">Pharmacy Review & Approval</a>
                </div>
            </div>
 
		<div class="dropdown">
			<button class="dropbtn">
				Insurance <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="ShowSubscription.jsf">Create Insurance Plan</a>
			</div>
		</div>
 
		<div class="dropdown">
			<button class="dropbtn">
				Patient <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="#">Member Search & Inquiry</a>
				<a href="#">Update Member details</a>
			</div>
		</div>
 
		<div class="dropdown">
			<button class="dropbtn">
				Provider <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="ShowProviderPagination.jsf">Provider Review & Approval</a>
				 <a	href="Search_final.jsf" >Provider Search & Inquiry</a>
				 <a	href="ProviderPegination.jsf" >Update Provider details</a>
			</div>
		</div>
	
 		<div class="dropdown">
			<button class="dropbtn">
				Claims <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="#">Search Claims</a>
				<a href="#">Process Claim </a>
				
			</div>
 	
		</div>
 
		
		
	
		
	</div>
	
	 
	
	
 
 
			
 

		       
		

		
	
	

 
	<script>
		function openForm() {
			var popup = document.getElementById("myPopup");
			popup.style.display = "block";
		}
 
		function closeForm() {
			var popup = document.getElementById("myPopup");
			popup.style.display = "none";
		}
	</script>
</body>
	</html>
</f:view>
 
