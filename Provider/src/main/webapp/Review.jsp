<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<style>
.button-style {
	display: inline-block;
	padding: 10px 20px;
	text-align: center;
	text-decoration: none;
	background-color: #4CAF50; /* Red background color */
	color: white; /* White text color */
	border: 1px solid #4CAF50;
	border-radius: 5px;
	cursor: pointer;
	transition: background-color 0.3s ease;
	/* Add a smooth transition effect */
}

.button-style:hover {
	background-color: #A569BD;
}

body {
	background-image: url('B3.jpg');
	/* Replace with the path to your background image */
	background-size: cover;
	/* Cover the entire viewport with the background image */
	margin: 0; /* Remove default margin */
	padding: 0; /* Remove default padding */
	font-family: 'Arial', sans-serif; /* Set the default font family */
	color: #333; /* Set text color */
	line-height: 1.6; /* Set line height for better readability */
}

#loader {
	display: none;
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background-color: #defcf9;
	text-align: center;
	z-index: 0;
}

/* Style for spinner */
.spinner {
	position: absolute;
	height: 3em;
	width: 3em;
	top: 50%;
	left: 50%;
	box-sizing: border-box;
	margin-left: -1.5em;
	margin-top: -1.5em;
	border: 0.21em solid;
	border-color: #E67676 #F2F062 #A9E6E6 #7692E4;
	border-radius: 50%;
	box-shadow: 0 0 2.4em blue;
	opacity: 0.9;
	animation: spin 1s infinite linear;
}

 @keyframes spin {
        from {
            transform: rotate(0deg);
        }
        to {
            transform: rotate(360deg);
        }
    }
.form-border {
	border: 2px solid #ddd;
	padding: 20px;
	border-radius: 10px;
	margin: 20px;
	background-color: #f2f2f2; /* Set the background color for the table */
}

/* Add styles for outputLabel */
.output-label {
	font-weight: bold; /* Make the label text bold */
	color: black; /* Set the text color */
	margin-right: 10px; /* Add right margin for spacing */
}

.output-text {
	color: #e74c3c; /* Set the text color to a shade of red */
	font-weight: 600;
	/* Add more styles as needed */
}

#form {
	max-width: 600px; /* Set the maximum width of the form */
	margin: 0 auto; /* Center the form horizontally */
}

/* Style for the header inside the form */
#form h2 {
	background-color: #333; /* Set background color for the header */
	color: white; /* Set text color for the header */
	padding: 10px; /* Add padding to the header */
	border-radius: 5px; /* Add border radius to the header */
}

#form hr {
	border-color: #333;
}
</style>
</head>
<body>

	<div id="loader">
		<div class="spinner"></div>

	</div>

	<h:form id="form" styleClass="form-border">
		<center>
			<h2 style="text-align: center" class="col-sm-4">Review Provider</h2>
			<hr />

			<h:outputLabel value="ProviderId:" styleClass="output-label" />
			<h:outputText value="#{list.providerId}" styleClass="output-text" />
			<br />

			<h:outputLabel value="Name:" styleClass="output-label" />
			<h:outputText value="#{list.firstName} #{list.lastName}"
				styleClass="output-text" />
			<br />


			<h:outputLabel value="DateOfBirth:" styleClass="output-label" />
			<h:outputText value="#{list.dateOfBirth.toString().substring(0, 10)}" styleClass="output-text" />
			<br />

			<h:outputLabel value="Enrollment Date:" styleClass="output-label" />
			<h:outputText value="#{list.enrollmentDate.toString().substring(0, 10)}" styleClass="output-text" />
			<br />

			<h:outputLabel value="Email:" styleClass="output-label" />
			<h:outputText value="#{list.email}" styleClass="output-text" />
			<br />

			<h:outputLabel value="LicenseNumber:" styleClass="output-label" />
			<h:outputText value="#{list.licenseNumber}" styleClass="output-text" />
			<br />

			<h:outputLabel value="Qualification:" styleClass="output-label" />
			<h:outputText value="#{list.qualification}" styleClass="output-text" />
			<br />

			<h:outputLabel value="UserName:" styleClass="output-label" />
			<h:outputText value="#{list.username}" styleClass="output-text" />
			<br />

			<h:outputLabel value="Status:" styleClass="output-label" />
			<h:outputText value="#{list.status}" styleClass="output-text" />
			<br />

			<h:outputLabel value="PhoneNo:" styleClass="output-label" />
			<h:outputText value="#{list.phoneNo}" styleClass="output-text" />
			<br />

			<h:outputLabel value="Gender:" styleClass="output-label" />
			<h:outputText value="#{list.gender}" styleClass="output-text" />
			<br />

			<h:outputLabel value="Speciality:" styleClass="output-label" />
			<h:outputText value="#{list.speciality}" styleClass="output-text" />
			<br />

			<h:outputLabel value="Address:" styleClass="output-label" />
			<h:outputText value="#{list.address}" styleClass="output-text" />
			<br />

			<h:commandButton action="#{providerImpl.validating()}"
				value="Validate" styleClass="record-link button-style"
				onclick="showLoader()" />

			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
			<h:commandButton action="#{providerImpl.cancel()}" value="Cancel"
				styleClass="record-link button-style" onclick="showLoader()" />
		</center>
	</h:form>


	<script type="text/javascript">
        function showLoader() {
            document.getElementById('loader').style.display = 'block';
        }
    </script>

</body>
	</html>
</f:view>
