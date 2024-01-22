<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
<html>
<head>
    <meta charset="UTF-8">
    <title>Password Change Successful</title>
    <style>
        body {
            background-color: rgba(255, 255, 255, 0.8); /* Transparent white background */
            font-family: Arial, sans-serif;
        }
 
        .container {
            text-align: center;
            margin-top: 100px;
        }
 
        .tick-icon {
            color: #4CAF50; /* Green color for tick icon */
            font-size: 150px;
        }
 
        .message {
            font-size: 24px;
            margin-top: 20px;
        }
 
        .login-link {
            font-size: 18px;
            text-decoration: none;
            color: #333;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="tick-icon">&#10004;</div>
        <div class="message">
            <h:outputLabel value="Password changed successfully for #{username}  " />
        </div>
        <a href="AdminLogin.jsf" class="login-link">Click here to login</a>
    </div>
</body>
</html>
</f:view>