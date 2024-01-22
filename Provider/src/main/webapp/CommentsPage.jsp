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
            body {
                font-family: 'Arial', sans-serif;
                background: url('Regis.jpg') center center fixed;
                background-size: cover;
                margin: 0;
                padding: 0;
            }

            h2 {
                text-align: center;
                color: #333;
            }

            hr {
                border: 1px solid #ddd;
            }

            .form-container {
                max-width: 400px;
                margin: 20px auto;
                background-color: #fff;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                padding: 20px;
                border-radius: 5px;
            }

            label {
                display: block;
                margin-bottom: 8px;
                color: #555;
            }

            input[type="text"] {
                width: 100%;
                padding: 8px;
                margin-bottom: 16px;
                box-sizing: border-box;
                border: 1px solid #ccc;
                border-radius: 4px;
            }

            .submit-btn {
                background-color: #4CAF50;
                color: #fff;
                padding: 10px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            .submit-btn:hover {
                background-color: #45a049;
            }
        </style>
        
        
    </head>
    <body>
    	<h:form>
    	<div class="form-container">
    	<h2 style="text-align: center" class="col-sm-4">Reason For Reject</h2>
    	 <hr/>
    	
    	 <h:outputText value="#{Ids}"></h:outputText>
    	 <h:outputLabel value="Comments" />
    	 <h:inputText id="comments" value="#{provider.comments}"/><br>	
    	 
    	 <h:commandButton action="#{providerImpl.commentsPage(Ids,provider)}" value="Submit" />
    	 </div>
    	</h:form>
    </body>
	</html>
</f:view>