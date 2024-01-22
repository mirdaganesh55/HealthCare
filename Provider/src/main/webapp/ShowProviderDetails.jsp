	<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
 
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<f:view>
	<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
		 <style>
		 @import url('https://fonts.googleapis.com/css2?family=Poppins&display=swap');
		 #logo{
		 margin-top:-25;
width: 250px;
}
.button-style {
font-family:'Poppins';
    background-color: #424242;
    border: none;
    border-radius:5px;
    color: white;
    padding: 6px 6px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 14px 2px;
    cursor: pointer;
}
a{

padding:20px;	
}
.right-button{

padding-top:20px;
margin-left:350px;}

label {
	border-line: 15px;
	display: block;
	color: black;
}
                body {
                    font-family:'Poppins';
                    background-color: white;
                }

                .title {
                    font-size: 24px;
                    color: #333;
                    text-align: center;
                    margin-bottom: 20px;
                }

                table {
                    width: 50%;
                    margin: 20px auto;
                    border-collapse: collapse;
                    box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
                    background-color: #fff;
                }

                th, td {
                    padding: 15px;
                    text-align: left;
                    border-bottom: 1px solid #ddd;
                }

                th {
                    background-color: #4CAF50;
                    color: white;
                }

                .label {
                    font-weight: bold;
                    color: #333;
                }

                .value {
                    color: #555;
                }
            </style>
	</head>
	<body>
		<h:form>
		<div style="display:flex;">
	
	<div id="logo">
	<img src="Jitu logo.png">
	</img></div>
	
	<div class="right-button">
	<div style="font-size:15px">
	<a>News
	</a>
	<a>About Us
	</a>
	<a>Contact Us
	</a>
	</div>
	<div style="margin:30px 0 0 0;">
	<a>Services
	</a>
	<a>Customers
	</a>
	<a>Expertise
	</a>
	<a style="padding:5px;margin:5px">Resources
	</a>
	<a style="background-color:#b8b8b8;border:0px solid white;border-radius:25px;padding:5px 10px 5px 10px;">Find a Doctor  
	</a>
	</div>
	
	
	
	</div>
	
	</div>
	<div style="padding-left:50px;font-size:30px; background-color:#424242;color:white;margin:0 0 20px 0;">Provider Information
	</div>
				<center>
		
			
			
				
               
                 <h:outputText value="ProviderId : #{providerListNew.providerId}" >
                 <f:converter converterId="javax.faces.Integer" />  
                 </h:outputText>
				<br />
                <br /> 
                <h:outputText value="Name : #{providerListNew.firstName} #{providerListNew.lastName}" />
                <br />
                
                <br />
                <h:outputText value="Date of Birth: #{providerListNew.dateOfBirth.toString().substring(0, 10)}" />
                <br />
                <br />
                <h:outputText value="Gender: #{providerListNew.gender}" />
                <br />
                <br />
                <h:outputText value="Username : #{providerListNew.username}" />
                <br />
                <br />
                <h:outputText value="Phone Number: #{providerListNew.phoneNo}" />
                <br />
                <br />
                <h:outputText value="LicenseNumber: #{providerListNew.licenseNumber}" />
                <br />
                <br />
                <h:outputText value="qualification: #{providerListNew.qualification}" />
                <br />
                <br />
                <h:outputText value="Email : #{providerListNew.email}" />
                <br />
                <br />
                <h:outputText value="Status : #{providerListNew.status}" />
                <br />
                <br />
                <h:outputText value="Address : #{providerListNew.address}" />
                <br />
                <br />
                <h:outputText value="Speciality : #{providerListNew.speciality}" />
                <br />
                <br />
                <h:outputText value="Active : #{providerListNew.isActive}" />
                <br />
                <br /> 
                <h:commandButton action="Search_final.jsp" value="BACK" styleClass="button-style"/>
			</center>
		</h:form>
	</body>
	</html>
</f:view>
