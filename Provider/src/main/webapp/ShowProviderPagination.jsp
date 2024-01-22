<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
<html>	
<head>
<meta http-equiv="Content-Type" 	content="text/html; charset=UTF-8">
<title>JSP Page</title>
<style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300&display=swap');
    {
	-moz-box-sizing: border-box;
	-o-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
}
body {
/* 	color: #333; */
	font-size: 1em;
}
a:link,
a:visited,
a:hover,
a:active {
	color: #000;
	 text-decoration: auto;
}
.container {
  margin: 50px auto;
  padding: 0 50px;
  max-width: 960px;
}
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
	text-align: revert;
	vertical-align: baseline;
	    font-size: medium;
    font-weight: 900;
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
        body {
            font-family: 'Poppins';
            margin: 0;
            padding: 0;
            color: #333;
            line-height: 1.6;
            background: #ebc4ff;
            background-image: url('background-1356642_1920.png');
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
            color: #787878;
            display: inline-block;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            background-color: #677BF3;
            color: white;
            border: 1px solid #ebc4ff;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .button-style:hover {
            background-color: #EDF551;
        }

        .record-link {
            color: #787878;
            text-decoration: none;
            font-weight: bold;
            padding: 10px;
        }

        .centered-heading {
            text-align: center;
            color: #333;
            font-size: 24px;
            margin-top: 0px;
        }

        .paginationIcon {
            margin-left: 1000px;
            
        }

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        .container2 {
            display: flex;
            justify-content: space-evenly;
            align-items: center;
            margin-top: 20px;
        }

        .container2 .button {
            transition: all 0.3s ease-in-out;
            outline: none;
            border: none;
            cursor: pointer;
            font-size: 16px;
            color: white;
            width: 150px;
            height: 40px;
            border-radius: 20px;
            text-align: center;
            line-height: 40px;
        }

        .container2 .button:nth-child(1) {
            background-image: linear-gradient(135deg, #E2B0FF 0%, #9F44D3 100%);
            box-shadow: 0 20px 30px -6px rgba(171, 88, 219, 0.5);
        }

        .container2 .button:nth-child(2) {
            background-image: linear-gradient(135deg, #81FBB8 0%, #28C76F 100%);
            box-shadow: 0 20px 30px -6px rgba(60, 211, 128, 0.5);
        }

        .container2 .button:nth-child(3) {
            background-image: linear-gradient(135deg, #ABDCFF 0%, #0396FF 100%);
            box-shadow: 0 20px 30px -6px rgba(30, 161, 255, 0.5);
        }

        .container2 .button:hover {
            transform: translateY(5px);
            box-shadow: none;
        }

        .container2 .button:active {
            opacity: 0.8;
        }
        .back-button {
    display: inline-block;
    padding: 10px 20px;
    text-decoration: none;
    background-color:#0F80D8 ; /* Change the color as needed */
    color: #ffffff; /* Change the text color as needed */
    border-radius: 5px;
    transition: background-color 0.3s ease;
}

.back-button:hover {
    background-color: #3FB500; /* Change the hover color as needed */
}
   .centered-heading {
        text-align: center;
        color: #333;
        font-size: 24px;
        margin-top: 0px;
    }
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
	text-align: Center;
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
	<h:form id="form">

		<center class="centered-heading">
			<h2>
				<h:outputText value="Provider Review & Approval" />
			</h2>
			
<!-- 		<div class="text-left"> -->
<!-- 			<a href="Reset.jsf">Reset Password</a><br/> -->
<!--     		<a href="AdminLogin.jsf">Logout</a> -->
<!-- 		</div> -->
			
		</center>
		
		<div class="container2">
			<a href="ApprovedProvider.jsf" onclick="showLoader()"
				class="button">Approved Records</a> &nbsp;
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
			&nbsp; <a id="pending" href="PendingProvider.jsf" onclick="showLoader()"
				class="button">Pending Records</a>&nbsp;
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
			&nbsp; <a href="RejectedProvider.jsf" onclick="showLoader()"
				class="button">Rejected Records</a>&nbsp;
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;
			&nbsp;
		</div>
		
		<center>
			<h:dataTable value="#{paginationDao.getProviderList()}" var="p"
				border="4">
				
				<h:column>
					<f:facet name="header">						
						<h:outputLabel value="ProviderID">&nbsp;&nbsp;&nbsp;&nbsp;
					<h:commandLink action="#{providerImpl.sortByProviderId()}" styleClass="sort-by"/>
				</h:outputLabel>
					</f:facet>
					<h:commandLink onclick="showLoader()" value="#{p.providerId}"
						action="#{providerImpl.searchProvider(p.providerId)}"
						styleClass="providerId-column button-style" />
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputLabel value="FirstName">&nbsp;&nbsp;&nbsp;&nbsp;
							<h:commandLink action="#{providerImpl.sortByFirstName()}" styleClass="sort-by" />
						</h:outputLabel>
					</f:facet>
					<h:outputText value="#{p.firstName}" />
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputLabel value="LastName">&nbsp;&nbsp;&nbsp;&nbsp;
					<h:commandLink action="#{providerImpl.sortByLastName()}"
								styleClass="sort-by" />
						</h:outputLabel>
					</f:facet>
					<h:outputText value="#{p.lastName}" />
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputLabel value="EnrollmentDate">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<h:commandLink action="#{providerImpl.sortByDate()}"
								styleClass="sort-by" />
						</h:outputLabel>
					</f:facet>
					<h:outputText value="#{p.enrollmentDate}">
						<f:convertDateTime pattern="yyyy-MM-dd" />
					</h:outputText>
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputLabel value="Email">&nbsp;&nbsp;&nbsp;&nbsp;
					<h:commandLink action="#{providerImpl.sortByEmail()}" styleClass="sort-by"/>
						</h:outputLabel>
					</f:facet>
					<h:outputText value="#{p.email}" />
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputLabel value="Licence">&nbsp;&nbsp;&nbsp;&nbsp;
					<h:commandLink action="#{providerImpl.sortByLic()}" styleClass="sort-by"/>
						</h:outputLabel>
					</f:facet>
					<h:outputText value="#{p.licenseNumber}" />
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputLabel value="Qualification">&nbsp;&nbsp;&nbsp;&nbsp;
							<h:commandLink action="#{providerImpl.sortByQualification()}" styleClass="sort-by"/>
						</h:outputLabel>
					</f:facet>
					<h:outputText value="#{p.qualification}" >
					</h:outputText>
				</h:column>

				<h:column>
					<f:facet name="header">
						<h:outputLabel value="Gender">&nbsp;&nbsp;&nbsp;&nbsp;
					<h:commandLink action="#{providerImpl.sortByGender()}" styleClass="sort-by"/>
						</h:outputLabel>
					</f:facet>
					<h:outputText value="#{p.gender}" />
				</h:column>
		
				<h:column>
					<f:facet name="header">						
						<h:outputLabel value="Speciality">
					<h:commandLink action="#{providerImpl.sortBySpeciality()}" styleClass="sort-by"/>
						</h:outputLabel>
					</f:facet>
					<h:outputText value="#{p.speciality}" />
				</h:column>
				
			</h:dataTable>

			<div class="center-container">
				<a href="Dummy.jsf" class="back-button">Back</a>
			</div>

			<div class="paginationIcon">
			<h:commandButton value="first" action="#{paginationDao.pageFirst}"
				disabled="#{paginationDao.firstRow == 0}" />&nbsp;
			<h:commandButton value="prev" action="#{paginationDao.pagePrevious}"
				disabled="#{paginationDao.firstRow == 0}" />
			<h:outputText value="&nbsp;" escape="false" />
			<h:commandButton value="next" action="#{paginationDao.pageNext}"
				disabled="#{paginationDao.firstRow + paginationDao.rowsPerPage >= paginationDao.totalRows}" />
			<h:outputText value="&nbsp;" escape="false" />
			<h:commandButton value="last" action="#{paginationDao.pageLast}"
				disabled="#{paginationDao.firstRow + paginationDao.rowsPerPage >= paginationDao.totalRows}" />
			<h:outputText value="&nbsp;" escape="false" />
			<h:outputText
				value="Page #{paginationDao.currentPage} / #{paginationDao.totalPages}" />&nbsp;&nbsp;&nbsp;&nbsp;<br>
			<h:outputText
					value="Records : #{paginationDao.startRow} - #{paginationDao.lastRow} out of #{paginationDao.totalRows}" />
				</div>
			<br />
		</center>
	</h:form>

	<div id="loader">
		<div class="spinner"></div>
	</div>

	<script type="text/javascript">
		function showLoader() {
			document.getElementById('loader').style.display = 'block';
		}

		
// 		function changeArrow() {
// 			var sortByFirstName = document.getElementId('form:SortByFirstName');
// 			var firstNameColumn1 = document.getElementId('firstNameColumn1');
// 			var firstNameColumn2 = document.getElementId('firstNameColumn2');

// 			if ('desc' === sortByFirstName.value){
// 				firstNameColumn2.style.display = 'none';
// 				}
// 			else {
// 				firstNameColumn1.style.display = 'none';
// 				}
// 		}
		
	</script>

</body>
	</html>
</f:view>