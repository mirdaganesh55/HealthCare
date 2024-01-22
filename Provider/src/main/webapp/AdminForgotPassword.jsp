<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Font Awesome Icons  -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
	integrity="sha512-+4zCK9k+qNFUR5X+cKL9EIR+ZOhtIloNl9GIKS57V1MyNsYpYcUrUeQc9vNfzsWfV28IaLL3i96P9sdNyeRssA=="
	crossorigin="anonymous" />

<!-- Google Fonts  -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins&display=swap"
	rel="stylesheet">

<title>Forget Password</title>
</head>

<body>
	<div class="card cardStyle">
		<h:form id="form" onsubmit="return validateForm()">
			<h2>Forget Password</h2>
			<p>Please Enter Your Username</p>
			<div>
				<h:inputText styleClass="box" id="username"
					value="#{admin2.username}" maxlength="20"
					onkeypress="return isNonNumeric(event)" />
			</div>
			<h:outputText value="#{err}" style="color: red; font: 12px" />
			<h:message for="username" style="color: red; font: 12px" />
			<h:commandButton styleClass="btn1"
				action="#{daoImp.initiateForgotPassword(admin2.username)}"
				value="Next" />
			</br>
		</h:form>
		<div class=pass>
			"Remember your password ?" <a href="AdminLogin.jsf" class="login-link">Click here to Login
				now</a>
		</div>
	</div>
	<script>
    
    function isNonNumeric(event) {
        var charCode = (event.which) ? event.which : event.keyCode;
        if (charCode > 31 && (charCode < 48 || charCode > 57)) {
            return true;
        }
        return false;
    }
    </script>
</body>

<style>
* {
	margin: 0;
	padding: 0;
	font-family: Arial, sans-serif;;
}

body {
	background-color: #add8e6;
	background-image: url('hospital.jpg');
	background-size: cover;
	color: black;
	display: flex;
	align-items: center;
	justify-content: center;
	padding: 5rem 0;
}
.pass{
font-size: 12px
}


.cardStyle {
	backdrop-filter: blur(16px) saturate(180%);
	-webkit-backdrop-filter: blur(16px) saturate(180%);
	background-color: white;
	border-radius: 12px;
	border-top: 10px solid #79a6fe;
	border-bottom: 10px solid #8BD17C;
	display: flex;
	flex-direction: column;
	align-items: center;
	padding: 30px 40px;
	max-width: 400px; /* Adjusted max-width for responsiveness */
	width: 100%; /* Ensure it takes full width on small screens */
}

h2 {
	text-align: center;
	font-size: 1.5rem;
	margin-top: 10px;
	text-transform: uppercase;
	align-self: center;
}

p {
	font-size: 17px;
	margin-top: 10px;
}

.box {
	display: block;
	margin: 10px auto 20px;
	background-color: #ECFFFF;
	border: 5px;
	border-bottom: #79a6fe 1px solid;
	border-radius: 5px;
	padding: 10px 10px;
	width: 100%; /* Adjusted width to take full width */
	outline: none;
	color: black;
	-webkit-transition: all 0.2s ease-out;
	-moz-transition: all 0.2s ease-out;
	-ms-transition: all 0.2s ease-out;
	-o-transition: all 0.2s ease-out;
	transition: all 0.2s ease-out;
}

.btn1 {
	border: 0;
	margin: 10px auto 20px;
	background: #7f5feb;
	color: #dfdeee;
	border-radius: 10px;
	width: 100%; /* Adjusted width to take full width */
	height: 35px;
	font-size: 16px;
	transition: 0.3s;
	cursor: pointer;
}
</style>

	</html>
</f:view>
