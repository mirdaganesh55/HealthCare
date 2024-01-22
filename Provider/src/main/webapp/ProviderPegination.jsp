<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
	<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<body>
	<h:form>
		<center>
			<div class="h2-container">
				<h2>
					<h:outputText value="Provider Details" />
				</h2>
			</div>
		</center>
		<center>
		<h:dataTable value="#{paginationDaoo.getProviderList()}" var="p"
			border="3">
			<div class="col">
				<h:column id="column1">
					<f:facet name="header">
						<h:outputLabel value="Provider Id" />
					</f:facet>
					<h:outputText value="#{p.providerid}" />
				</h:column>
				<h:column id="column2">
					<f:facet name="header">
						<h:outputLabel value=" Firstname" />
					</f:facet>
					<h:outputText value="#{p.firstname}" />
				</h:column>
				<h:column id="column3">
					<f:facet name="header">
						<h:outputLabel value=" lastname" />
					</f:facet>
					<h:outputText value="#{p.lastname}" />
				</h:column>
				<h:column id="column7">
					<f:facet name="header">
						<h:outputLabel value="Gender" />
					</f:facet>
					<h:outputText value="#{p.gender}" />
				</h:column>
				<h:column id="column8">
					<f:facet name="header">
						<h:outputLabel value="Specialty" />
					</f:facet>
					<h:outputText value="#{p.specialty}" />
				</h:column>
				<h:column id="column13">
					<f:facet name="header">
						<h:outputLabel value="enrollmentdate"/>
					</f:facet>
					<h:outputText
						value="#{p.enrollmentdate.toString().substring(0, 10)}" />
				</h:column>
				<h:column id="column14">
					<f:facet name="header">
						<h:outputLabel value="licenseNumber" />
					</f:facet>
					<h:outputText value="#{p.licenseNumber}" />
				</h:column>
				<h:column id="column15">
					<f:facet name="header">
						<h:outputLabel value="qualification"/>
					</f:facet>
					<h:outputText value="#{p.qualification}" />
				</h:column>

				<h:column>
					
					<h:commandButton
						action="#{daoImpl.searchProviderDetails(p.providerid)}"
						value="Update"
						style="background-color: #2ba7e2;
											color: white;
											padding: 10px;
											border-radius: 10px;
											margin-right: 4px;">
					</h:commandButton>
				</h:column>
			</div>
		</h:dataTable>
		</center>
		<!--The paging buttons-->
		<center>
		<div class="center-container">
				<a href="Dummy.jsf" class="back-button">Back</a>
			</div>
		</center>
<center>
					<h:commandButton value="first" action="#{paginationDaoo.pageFirst}"
				disabled="#{paginationDaoo.firstRow == 0}" />&nbsp;
			<h:commandButton value="prev" action="#{paginationDaoo.pagePrevious}"
				disabled="#{paginationDaoo.firstRow == 0}" />
			<h:outputText value="&nbsp;" escape="false" />
			<h:commandButton value="next" action="#{paginationDaoo.pageNext}"
				disabled="#{paginationDaoo.firstRow + paginationDaoo.rowsPerPage >= paginationDaoo.totalRows}" />
			<h:outputText value="&nbsp;" escape="false" />
			<h:commandButton value="last" action="#{paginationDaoo.pageLast}"
				disabled="#{paginationDaoo.firstRow + paginationDaoo.rowsPerPage >= paginationDaoo.totalRows}" />
			<h:outputText value="&nbsp;" escape="false" />
</center>
	</h:form>
</body>
	</html>
</f:view>