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

<title>Security Question</title>
</head>

<body>
	<div class="card cardStyle">
		<h:form id="form" onsubmit="return validateForm()">
			<h2>Security Question</h2>
			<div>
            <label for="securityQuestion">Choose a security question:</label>
            <select id="securityQuestion" name="selectedQuestion">
                <option value="">Select a question</option>
                <option value="firstConcert">What was the first concert you attended?</option>
                <option value="birthCity">What city you were born in?</option>
                <option value="sibling">What is your oldest sibling’s middle name?</option>
                <option value="city">In what city or town did your parents meet?</option>
                <option value="favourite">What was your favorite elementary school teacher’s name?”</option>
            </select>
        </div>

			<h:inputText styleClass="box" id="otp"
				value="#{daoImp.enteredAnswers}" maxlength="20" onkeypress="return isNonNumeric(event)"/>
			<h:message for="otp" style="color: red; font: 15px" />
			<h:commandButton styleClass="btn1"
				action="#{daoImp.validateSecurityInfo(daoImp.enteredAnswers)}"
				value="Next" />
			</br>
			</div>
		</h:form>
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
	margin: 5px;
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
	align-items: center;
}

.box {
	display: block;
	margin: 0px auto 20px;
	margin-top: 30px;
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
	background: #7f5feb;
	color: #dfdeee;
	border-radius: 10px;
	width: 100%; /* Adjusted width to take full width */
	height: 35px;
	font-size: 16px;
	margin: 20px auto;
	transition: 0.3s;
	cursor: pointer;
}
</style>

	</html>
</f:view>
