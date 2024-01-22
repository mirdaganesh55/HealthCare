<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<style type="text/css">
                body {
                    font-family: 'Arial', sans-serif;
                    margin: 0;
                    padding: 0;
                    color: #333;
                    line-height: 1.6;
                    background-image: url('B2.jpg');
                    background-size: cover;
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

                .custom-container {
                    max-width: 1200px;
                    margin: 0 auto;
                }

                .button-style {
                    display: inline-block;
                    padding: 10px 20px;
                    text-align: center;
                    text-decoration: none;
                    background-color: #4CAF50;
                    color: white;
                    border: 1px solid #4CAF50;
                    border-radius: 5px;
                    cursor: pointer;
                    transition: background-color 0.3s ease;
                }

                .button-style:hover {
                    background-color: #A569BD;
                }

                .record-link {
                    color: black;
                    text-decoration: none;
                    font-weight: bold;
                    border: 1px solid black;
                    padding: 3px;
                }

                .centered-heading {
                    text-align: center;
                    color: #333;
                    font-size: 24px;
                    margin-top: 0px;
                }
                
                .container-heading {
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.centered-heading {
    text-align: center;
}

.dropdown-container {
    margin-left: auto; /* This will push the dropdown to the right */
}
                
            </style>
</head>
<body>
	<h:form>

		<div class="container-heading">
    <div class="centered-heading">
        <h2>
            <h:outputText value="Provider Dashboard" />
        </h2>
    </div>
    <div class="dropdown-container">
        <h:selectOneMenu id="localCode" value="#{providerImpl.localcode}" onchange="submit()" valueChangeListener="#{providerImpl.specialityLocaleCodeChanged}">
            <f:selectItems value="#{providerImpl.showSpeciality()}" />
        </h:selectOneMenu>
    </div>
</div>


		<center>
			<h:dataTable value="#{providerImpl.getProviderBySpeciality(providerImpl.localcode)}" var="p"
				border="4">

				<h:column>
					<f:facet name="header">
						<h:outputText value="ProviderId" />
					</f:facet>
					<h:commandLink onclick="showLoader()" value="#{p.providerId}"
						action="#{providerImpl.searchProvider(p.providerId)}"
						styleClass="providerId-column button-style" />
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputLabel value="FirstName" />
					</f:facet>
					<h:outputText value="#{p.firstName}" />
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputLabel value="LastName" />
					</f:facet>
					<h:outputText value="#{p.lastName}" />
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputLabel value="EnrollmentDate" />
					</f:facet>
					<h:outputText value="#{p.enrollmentDate}">
						<f:convertDateTime pattern="yyyy-MM-dd" />
					</h:outputText>
				</h:column>


				<h:column>
					<f:facet name="header">
						<h:outputLabel value="Email" />
					</f:facet>
					<h:outputText value="#{p.email}" />
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputLabel value="LicenceNumber" />
					</f:facet>
					<h:outputText value="#{p.licenseNumber}" />
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputLabel value="Qualification" />
					</f:facet>
					<h:outputText value="#{p.qualification}" />
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputLabel value="UserName" />
					</f:facet>
					<h:outputText value="#{p.username}" />
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputLabel value="PhoneNo" />
					</f:facet>
					<h:outputText value="#{p.phoneNo}" />
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputLabel value="Gender" />
					</f:facet>
					<h:outputText value="#{p.gender}" />
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputLabel value="Speciality" />
					</f:facet>
					<h:outputText value="#{p.speciality}" />
				</h:column>
				
			</h:dataTable>
		</center>

		<div style="text-align: center; margin-top: 10px;">
			<a href="ApprovedProvider.jsf" onclick="showLoader()"
				class="record-link button-style">Show Approved Records</a> &nbsp;
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
			&nbsp; <a href="PendingProvider.jsf" onclick="showLoader()"
				class="record-link button-style">Show Pending Records</a>&nbsp;
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
			&nbsp; <a href="RejectedProvider.jsf" onclick="showLoader()"
				class="record-link button-style">Show Rejected Records</a>
		</div>
	</h:form>

	<div id="loader">
		<div class="spinner"></div>
	</div>

	<script type="text/javascript">
		function showLoader() {
			document.getElementById('loader').style.display = 'block';
		}
	</script>
	
</body>
	</html>
</f:view>