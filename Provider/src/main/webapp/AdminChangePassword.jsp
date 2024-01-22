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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
<!-- Google Fonts  -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins&display=swap"
	rel="stylesheet">

<title>Change Password</title>
</head>

<body>
	<div class="card cardStyle">
		<h:form id="form" onsubmit="return validateForm()">
			<h2>Change Password?</h2>

			<button onclick="showInfo()">
				<i class="fas fa-info-circle"></i>Tips for Strong password
			</button>
			<div>
				<i class='fas fa-lock'></i> <label for="password">New
					password</label>

				<div class="eye">
					<i id="hide1" class="fa-regular fa-eye"></i> <i id="hide2"
						class="fa-regular fa-eye-slash"></i>
				</div>
				<div id="passInputWrapperc">
					<h:inputSecret styleClass="box" id="password"
						value="#{admin2.password}" maxlength="16"
						autocomplete="new-password"
						onkeyup="checkPasswordStrength(this.value)" />
				</div>
			</div>
            <div id="password-strength"
					style="height: 5px; width: 80%; margin-bottom: 11px;margin-top: 23px; position: relative; top: -14px;font-weight: bold;"></div>
			

			<div>
				<i class='fas fa-lock'></i> <label for="password">Confirm
					Password</label>

				<div class="eye2">
					<i id="hide3" class="fa-regular fa-eye"></i> <i id="hide4"
						class="fa-regular fa-eye-slash"></i>
				</div>
				<div id="passInputWrapper">
					<h:inputSecret styleClass="box" id="confirmpassword"
						value="#{admin2.confirmPassword}" maxlength="16"
						onkeyup="checkPasswordStrength()" />

				</div>
	</div>
	
	<div>
		<h:commandButton styleClass="btn1"
			action="#{daoImp.ChangePassword(admin2.password, admin2.confirmPassword)}"
			value="Change Password" />
	</div>
	<div style="margin-bottom: 12px;">
		<h:commandButton value="Clear" onclick="clearForm()" styleClass="btn1" />
	</div>
	<div>
		<h:message for="password"
			style="color: red; font-weight: bold; font-size: 15px;" />
	</div>
	<a href="AdminLogin.jsf"></a> -->
	</h:form>

	</div>
</body>
<script>
	$(document).ready(function() {
		$('#hide1, #hide2').on('click', function() {
			var passInput = $("#passInputWrapperc input");
			var showPassIcon = $("#hide1");
			var showPassSlashIcon = $("#hide2");
			if (passInput.attr('type') === 'password') {
				passInput.attr('type', 'text');
				showPassIcon.hide();
				showPassSlashIcon.show();
			} else {
				passInput.attr('type', 'password');
				showPassIcon.show();
				showPassSlashIcon.hide();
			}
		});
	});

	$(document).ready(function() {
		$('#hide3, #hide4').on('click', function() {
			var passInput = $("#passInputWrapper input");
			var showPassIcon = $("#hide3");
			var showPassSlashIcon = $("#hide4");

			if (passInput.attr('type') === 'password') {
				passInput.attr('type', 'text');
				showPassIcon.hide();
				showPassSlashIcon.show();
			} else {
				passInput.attr('type', 'password');
				showPassIcon.show();
				showPassSlashIcon.hide();
			}
		});
	});
	function clearForm() {
		document.getElementById("form:oldPassWord").value = "";
		document.getElementById("form:password").value = "";
	}
	function showInfo() {
		alert("To create a strong password:\n- Use at least 8 characters\n- Include at least one uppercase letter\n- Include at least one lowercase letter\n- Include at least one number\n- Include at least one special character");
	}

	function checkPasswordStrength(password) {
		var strengthMeter = document.getElementById("password-strength");

		if (password.length < 6) {
			strengthMeter.innerText = "Weak";
			strengthMeter.style.color = "red";
			strengthMeter.style.backgroundColor = "transparent"; // Set background to transparent
		} else if (password.length < 10) {
			strengthMeter.innerText = "Medium";
			strengthMeter.style.color = "orange";
			strengthMeter.style.backgroundColor = "transparent"; // Set background to transparent
		} else {
			strengthMeter.innerText = "Strong";
			strengthMeter.style.color = "green";
			strengthMeter.style.backgroundColor = "transparent"; // Set background to transparent
		}
	}
</script>

<style>
* {
	margin: 0;
	padding: 0;
	font-family: Arial, sans-serif;;
}

.pass {
	font-size: 12px
}

#hide2 {
	display: none
}

#hide4 {
	display: none
}

.eye {
	position: absolute;
	right: 57px;
	top: 33%;
	transform: translateY(-50%);
}

.eye2 {
	position: absolute;
	right: 57px;
	top: 55%;
	transform: translateY(-50%);
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

.cardStyle {
	backdrop-filter: blur(16px) saturate(180%);
	-webkit-backdrop-filter: blur(16px) saturate(180%);
	background-color: white;
	border-radius: 12px;
	border-top: 10px solid #79a6fe;
	border-bottom: 10px solid #8BD17C;
	display: flex;
	flex-direction: column;
	padding: 30px 40px;
	max-width: 400px; /* Adjusted max-width for responsiveness */
	width: 100%; /* Ensure it takes full width on small screens */
}

h2 {
	font-size: 1.5rem;
	margin-top: 10px;
	text-transform: uppercase;
}

button {
	background-color: white;
	border: 1px solid white;
	padding: 15px 0px;
	color: #333;
	font-size: 14px;
	cursor: pointer;
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

<script>
	function clearForm() {
		document.getElementById("form:oldPassWord").value = "";
		document.getElementById("form:password").value = "";
	}
	function showInfo() {
		alert("To create a strong password:\n- Use at least 8 characters\n- Include at least one uppercase letter\n- Include at least one lowercase letter\n- Include at least one number\n- Include at least one special character");
	}
</script>

	</html>
</f:view>
