<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<f:view>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Reset Password</title>
		 <script>
            function clearFields() {
                document.getElementById('form:oldpassword').value = '';
                document.getElementById('form:newpassword').value = '';
                document.getElementById('form:retypepassword').value = '';
            }
        </script>
        <style>
           body {
    font-family: 'Arial', sans-serif;
    background-image: url("reset.jpg");
    background-size: auto; /* Use cover to make sure the background image covers the entire container */
    background-repeat: no-repeat;
    background-color: #e0f7fa;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100vh;
    margin: 0;
}

.container-box {
    background-color: #ffffff;
    border-radius: 8px;
    padding: 20px;
    box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
    max-width: 400px; /* Added max-width for better responsiveness */
    margin: 0 auto; /* Center the container */
}

h2 {
    font-size: 28px;
    color: #01579b;
    text-align: center;
    margin-bottom: 20px;
}

label {
    font-weight: bold;
    color: #333; /* Adjusted label color */
}

.form-group {
    margin-bottom: 20px;
}

input[type="password"] {
    width: 100%;
    padding: 12px;
    margin-top: 8px;
    border: 1px solid #26c6da;
    border-radius: 5px;
    transition: border-color 0.3s;
    box-sizing: border-box; /* Added box-sizing for consistent sizing */
}

input[type="password"]:focus {
    border-color: #01579b;
}

.btn-container {
    margin-top: 20px;
    text-align: center;
}

.custom-button {
    background-color: #01579b;
    color: white;
    padding: 12px 24px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s;
}

.custom-button:hover {
    background-color: #002f6c;
}

/* Style for error messages */
.error-message {
    color: #d32f2f;
    font-weight: bold;
    font-size: 15px;
    display: block;
    margin-top: 10px;
    white-space: pre-line;
    text-align: center; /* Center the error message */
}

        </style>
    </head>
    <body>
        <div class="container-box">
            <h2>Reset Password</h2>
            <h:form id="form">
		<div class="form-group">
    			<label for="oldpassword">Old Password</label>
   				 <h:inputSecret id="oldpassword" value="#{reset.old_password}" required="true" requiredMessage="Old Password cannot be null" />
   				 <h:message for="form:oldpassword" styleClass="error-message" />
		</div>

               <div class="form-group">
    			<label for="newpassword">New Password</label>
    			<h:inputSecret id="newpassword" value="#{reset.new_password}"  required="true" requiredMessage="Please Enter Confirm password"/>
    			<h:message for="form:newpassword" styleClass="error-message"/>    			
				</div>

                <div class="form-group">
                    <label for="retypepassword">Confirm Password</label>
                    <h:inputSecret id="retypepassword" value="#{reset.retype_password}"  required="true" requiredMessage="Please Enter Confirm password"/>
                    <h:message for="form:retypepassword" styleClass="error-message" />
                </div>
                <div class="btn-container form-group">
                     <h:commandButton type="reset" value="Clear" styleClass="custom-button" onclick="clearFields()" />
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <h:commandButton action="#{controller.addAdminReset(reset)}" value="Change Password" styleClass="custom-button" />
                    <h:message for="form:messages" styleClass="error-message" />
                </div>
                 <div style="text-align: center; margin-top: 20px;">
                <h:outputLink value="AdminForgotPassword.jsf">Forgot Password?</h:outputLink>
            </div>
            </h:form>
        </div>
    </body>
    </html>
</f:view>