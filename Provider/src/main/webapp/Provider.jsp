<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%> 
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Provider Details</title>
        </head>
        <body>
            <h:form>
                <center>
                    <h2><h:outputText value="Provider Details" /></h2>
                
                <h:dataTable value="#{paginationDaoJ.getProviderList()}" var="p" border="3">
                    <h:column>
                        <f:facet name="header">
                            <h:outputLabel value="Provider ID" />
                        </f:facet>
                        <h:outputText value="#{p.providerId}" />
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputLabel value="First Name" />
                        </f:facet>
                        <h:outputText value="#{p.firstName}" />
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputLabel value="Last Name" />
                        </f:facet>
                        <h:outputText value="#{p.lastName}" />
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputLabel value="Date of Birth" />
                        </f:facet>
                        <h:outputText value="#{p.dateOfBirth}" />
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputLabel value="Email" />
                        </f:facet>
                        <h:outputText value="#{p.email}" />
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputLabel value="License Number" />
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
                            <h:outputLabel value="Username" />
                        </f:facet>
                        <h:outputText value="#{p.username}" />
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputLabel value="Status" />
                        </f:facet>
                        <h:outputText value="#{p.status}" />
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputLabel value="Phone Number" />
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
                    <h:column>
                        <f:facet name="header">
                            <h:outputLabel value="Address" />
                        </f:facet>
                        <h:outputText value="#{p.address}" />
                    </h:column>
                    <h:column>
                        <f:facet name="header">
                            <h:outputLabel value="Is Active" />
                        </f:facet>
                        <h:outputText value="#{p.isActive}" />
                    </h:column>
                </h:dataTable>
                <!--The paging buttons-->
            <h:commandButton value="first" action="#{paginationDaoJ.pageFirst}"
                             disabled="#{paginationDaoJ.firstRow == 0}" />
            <h:commandButton value="prev" action="#{paginationDaoJ.pagePrevious}"
                             disabled="#{paginationDaoJ.firstRow == 0}" />
            <h:outputText value="&nbsp;" escape="false"/>
            <h:commandButton value="next" action="#{paginationDaoJ.pageNext}"
                             disabled="#{paginationDaoJ.firstRow + paginationDaoJ.rowsPerPage >= paginationDaoJ.totalRows}" />
            <h:outputText value="&nbsp;" escape="false"/>
            <h:commandButton value="last" action="#{paginationDaoJ.pageLast}"
                             disabled="#{paginationDaoJ.firstRow + paginationDaoJ.rowsPerPage >= paginationDaoJ.totalRows}" />
            <h:outputText value="&nbsp;" escape="false"/>
            <h:outputText value="Page #{paginationDaoJ.currentPage} / #{paginationDaoJ.totalPages}" />
            <br />
            <!-- Set rows per page -->
            <h:outputLabel for="rowsPerPage" value="Rows per page" />
            <h:inputText id="rowsPerPage" value="#{paginationDaoJ.rowsPerPage}" size="3" maxlength="3" />
            <h:commandButton value="Set" action="#{paginationDaoJ.pageFirst}" />
            <h:message for="rowsPerPage" errorStyle="color: red;" />
            
            </center>
            </h:form>
        </body>
    </html>
</f:view>
