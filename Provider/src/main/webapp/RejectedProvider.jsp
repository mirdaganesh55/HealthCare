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
table { 
	background: #FFF;
	border-collapse: collapse;
	width: 100%;  
}
td,
th { 
	padding: 4px 0 4px 0; 
	border: 1px solid #AECCE7 ;
	overflow: hidden;
	text-align: center;
	vertical-align: baseline;
}
th { 
	background-color: #95DBDA ; 
	font-weight: bold;
}
th a,
td a { 
	display: block;
	width: 100%;
	background-color: #84EB85 ;
}
th a.sort-by { 
	padding-right: 18px;
	position: relative;
}

 .paginationIcon {
            margin-left: 1000px;
            
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
.button-style {
	display: inline-block;
	padding: 10px 20px;
	text-align: center;
	text-decoration: none;
	background-color: #4CAF50; /* Green background color */
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

.record-link {
	color: black; /* Set the text color */
	text-decoration: none; /* Remove underline */
	font-weight: bold; /* Make the text bold */
	border: 1px solid black;
	padding: 3px;
	/* Add more styles as needed */
}

body {
	font-family: 'Arial', sans-serif; /* Set the default font family */
	margin: 0; /* Remove default margin */
	padding: 0; /* Remove default padding */
	color: #333; /* Set text color */
	line-height: 1.6; /* Set line height for better readability */
	background-image: url('B2.jpg');
	/* Replace with the path to your background image */
	background-size: cover;
	/* Cover the entire viewport with the background image */
}
/* Add styles for the dataTable */ /* Add styles for the dataTable */
.data-table {
	width: 100%; /* Set the width to 100% */
	border-collapse: collapse; /* Collapse the borders between cells */
	margin-top: 20px; /* Add margin at the top for spacing */
}

/* Style for the table headers */
.data-table th {
	background-color: #f2f2f2; /* Set background color for header */
	padding: 10px; /* Add padding to header cells */
	text-align: 100px; /* Align text to the left in header cells */
}

/* Style for the table data cells */
.data-table td {
	padding: 10px; /* Padding inside the data cells */
	border-bottom: 1px solid #ddd; /* Add a bottom border between rows */
	transition: background-color 0.3s ease; 
	    font-size: larger;
	        text-align: center;/* Add padding to data cells */
}

/* Style for alternating rows */

/* Change background color on hover */
.data-table td:hover {
	background-color: #e6e6e6;
}

/* Style for links in the table */
.data-table a {
	text-decoration: none; /* Remove underlines from links */
	color: #3498db; /* Set link color */
}

/* Style for links on hover */
.data-table a:hover {
	text-decoration: underline; /* Add underline on hover */
}
td,
th {
	padding: 4px 0 4px 0;
	border: 1px solid #AECCE7 ;
	overflow: hidden;
	text-align: revert;
	vertical-align: baseline;
}
th {
	background-color: #95DBDA ;
	font-weight: bold;
}
th a,
td a {
	display: block;
	width: 100%;
	background-color: #84EB85 ;
}
th a.sort-by {
    left: -42px;
	padding-right: 18px;
	position: relative;
}
a.sort-by:before,
a.sort-by:after {
	border: 4px solid transparent;
	content: "";
	display: inline-block;
	height: 0;
	right: 5px;
	top: 50%;
	position: absolute;
	width: 0;
}
a.sort-by:before {
	border-bottom-color: #666;
	margin-top: -20px;
}
a.sort-by:after {
	border-top-color: #666;
	margin-top: -9px;
}
</style>
</head>


<body>
	<h:form>
		<center>
			<h2>
				<h:outputText value="Rejected Provider Details" />
			</h2>
		</center>
		<center>
			<h:dataTable value="#{paginationDaoR.getProviderByRejList()}" var="p"
				border="4" styleClass="data-table">
				
					<h:column>
					<f:facet name="header">
						<h:outputLabel value="ProviderId">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<h:commandLink action="#{providerImpl.sortByProviderIdR()}" styleClass="sort-by" />
						</h:outputLabel>
					</f:facet>
					<h:outputText value="#{p.providerId}" />
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputLabel value="FirstName">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<h:commandLink action="#{providerImpl.sortByFirstNameR()}"
								styleClass="sort-by" />
						</h:outputLabel>
					</f:facet>
					<h:outputText value="#{p.firstName}" />
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputLabel value="LastName">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<h:commandLink action="#{providerImpl.sortByLastNameR()}" styleClass="sort-by"/>
						</h:outputLabel>
					</f:facet>
					<h:outputText value="#{p.lastName}" />
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:outputLabel value="EnrollmentDate">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<h:commandLink action="#{providerImpl.sortByDateR()}" styleClass="sort-by"/>
						</h:outputLabel>
					</f:facet>
					<h:outputText value="#{p.enrollmentDate}" >
					<f:convertDateTime pattern="yyyy-MM-dd" />
					</h:outputText>
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputLabel value="Licence">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<h:commandLink action="#{providerImpl.sortByLicR()}" styleClass="sort-by"/>
						</h:outputLabel>
					</f:facet>
					<h:outputText value="#{p.licenseNumber}" />
				</h:column>
				
				<h:column>
					<f:facet name="header">
						<h:outputLabel value="Qualification">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<h:commandLink action="#{providerImpl.sortByQualificationR()}" styleClass="sort-by"/>
						</h:outputLabel>
					</f:facet>
					<h:outputText value="#{p.qualification}" >
					</h:outputText>
				</h:column>
				<h:column>
					<f:facet name="header">
						<h:outputLabel value="Gender">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<h:commandLink action="#{providerImpl.sortByGenderR()}" styleClass="sort-by"/>
						</h:outputLabel>
					</f:facet>
					<h:outputText value="#{p.gender}" >
					</h:outputText>
				</h:column>


				<h:column>
					<f:facet name="header">						
						<h:outputLabel value="Speciality">
					<h:commandLink action="#{providerImpl.sortBySpecialityR()}" styleClass="sort-by"/>
						</h:outputLabel>
					</f:facet>
					<h:outputText value="#{p.speciality}" />
				</h:column>
			
			
			
			</h:dataTable>
			<div style="text-align: center; margin-top: 10px;">
			<a href="ShowProviderPagination.jsf" onclick="showLoader()"
				class="record-link button-style">Show Provider Details</a>
		</div>
			
			<div class="paginationIcon">
			<h:commandButton value="first" action="#{paginationDaoR.pageFirst}"
				disabled="#{paginationDaoR.firstRow == 0}" />&nbsp;
			<h:commandButton value="prev" action="#{paginationDaoR.pagePrevious}"
				disabled="#{paginationDaoR.firstRow == 0}" />
			<h:outputText value="&nbsp;" escape="false" />
			<h:commandButton value="next" action="#{paginationDaoR.pageNext}"
				disabled="#{paginationDaoR.firstRow + paginationDaoR.rowsPerPage >= paginationDaoR.totalRows}" />
			<h:outputText value="&nbsp;" escape="false" />
			<h:commandButton value="last" action="#{paginationDaoR.pageLast}"
				disabled="#{paginationDaoR.firstRow + paginationDaoR.rowsPerPage >= paginationDaoR.totalRows}" />
			<h:outputText value="&nbsp;" escape="false" />
			<h:outputText
				value="Page #{paginationDaoR.currentPage} / #{paginationDaoR.totalPages}" />&nbsp;&nbsp;&nbsp;&nbsp;<br>
			<h:outputText
					value="Records : #{paginationDaoR.startRow} - #{paginationDaoR.lastRow} out of #{paginationDaoR.totalRows}" />
				</div>
		</center>
		
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