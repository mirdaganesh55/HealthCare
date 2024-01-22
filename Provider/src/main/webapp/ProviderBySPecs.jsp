<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

    <f:view>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h:selectOneMenu id="localCode" value="#{providerImpl.localcode}" onchange="submit()"
	valueChangeListener="#{providerImpl.specialityLocaleCodeChanged()}">
    <f:selectItems value="#{providerImpl.showSpeciality()}"/>
</h:selectOneMenu>

</body>
</html>
</f:view>