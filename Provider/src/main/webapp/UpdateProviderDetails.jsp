<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<link rel="stylesheet" type="text/css" href="css/style3P.css">
</head>
<body>
	
		<h:form id="form">
		<div class="container">
		<div class="title"> Update Provider Details </div>
		<div class="user__details">
		<div class="input__box">
		<span class="details">Provider Id</span>
					<h:inputText id="providerid" value="#{editProvider.providerid}" />
					</div>
			<div class="input__box"> 
			<span class="details">FIRST NAME</span>
					<h:inputText id="firstname" value="#{editProvider.firstname}" />
					<h:outputText value="#{FirstError}" style="color:red"></h:outputText>
					<h:outputText value="#{FirstError1}" style="color:red"></h:outputText>
				</div>
			<div class="input__box"> 
			<span class="details">LAST NAME</span>	
					<h:inputText id="lastname" value="#{editProvider.lastname}" />
					<h:outputText value="#{FirstError2}" styleClass="error-message"></h:outputText>
					<h:outputText value="#{FirstError3}" style="color:red"></h:outputText>
					</div>
			<div class="input__box">
			<span class="details">USER NAME</span>
					<h:inputText id="username" value="#{editProvider.username}" />
					<h:outputText value="#{FirstError4}" style="color:red"></h:outputText>
					</div>
			<div class="input__box">
			<span class="details">PHONENO</span>
					<h:inputText id="phoneno" value="#{editProvider.phoneno}" />
					<h:outputText value="#{FirstError7}" style="color:red"></h:outputText>
					<h:outputText value="#{FirstError8}" style="color:red"></h:outputText>
					</div>
			
			<div class="input__box">	
			<span class="details">ADDRESS</span>	
					<h:inputText id="address" value="#{editProvider.address}" />
					<h:outputText value="#{FirstError8}" styleClass="error-message"></h:outputText>
					</div>
			
			<div class="input__box">
			<span class="details">LICENSENUMBER</span>		
					<h:inputText id="licensenumber" value="#{editProvider.licenseNumber}" />
					<h:outputText value="#{FirstError9}" styleClass="error-message"></h:outputText>
					<h:outputText value="#{FirstError10}" style="color:red"></h:outputText>
					</div>
			
			<div class="input__box">
			<span class="details">QUALIFICATION</span>
					<h:inputText id="qualification" value="#{editProvider.qualification}" />
					<h:outputText value="#{FirstError11}" styleClass="error-message"></h:outputText>
					<h:outputText value="#{FirstError12}" styleClass="error-message"></h:outputText>
					</div>
					
			<div class="input__box">
			<span class="details">SPECIALTY</span>		
					<h:inputText id="specialty" value="#{editProvider.specialty}" />
					<h:outputText value="#{FirstError13}" styleClass="error-message"></h:outputText>
					<h:outputText value="#{FirstError14}" styleClass="error-message"></h:outputText>
					</div>
					
			<div class="input__box">
			<span class="details">GENDER</span>
					<h:selectOneMenu id="genedr" value="#{editProvider.gender}">
					<f:selectItem itemValue="MALE" itemLabel="MALE" />
					<f:selectItem itemValue="FEMALE" itemLabel="FEMALE" />
					</h:selectOneMenu>
					<h:outputText value="#{FirstError15}" styleClass="error-message"></h:outputText>
					</div>
					
			<div class="input__box">
			<span class="details">DateOfBirth:</span>
					<h:inputText id="dateOfBirth" value="#{editProvider.dateOfBirth}" >
					<f:convertDateTime pattern="yyyy/MM/dd"/>
					</h:inputText>
					<h:outputText value="#{FirstError16}" styleClass="error-message">
					</h:outputText>
					</div>
					
			<div class="input__box">
			<span class="details">EnrollmentDate:</span>		
					<h:inputText id="enrollmentDate" value="#{editProvider.enrollmentdate}">
					<f:convertDateTime pattern="yyyy/MM/dd"/>
					</h:inputText>
					<h:outputText value="#{FirstError17}" styleClass="error-message"></h:outputText>
					</div>
					
			<div class="input__box">
			<span class="details">Email:</span>		
					<h:inputText id="email" value="#{editProvider.email}" />
					<h:outputText value="#{FirstError18}" style="color:red"></h:outputText>
					<h:outputText value="#{FirstError19}" style="color:red"></h:outputText>
					</div> 

					<div class="button">
						<h:commandButton action="ShowProviderDetails" value="All Provider" />
						&nbsp;
					  <h:commandButton
							action="#{prvdCrontroller.updateProviderDetails(editProvider)}"
							value="updated" />
					</div>
					</div>
				</div>
		</h:form>



</body>
	</html>
</f:view>