<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<f:view>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>OTP Verification Form</title>
    
    
<link href="https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css" rel="stylesheet" />
    
</head>
<body>
    <div class="container">
        <header>
            <i class="bx bxs-check-shield"></i>
        </header>
        <h4>Enter OTP Code</h4>
        <h:outputLabel value="A verification code has been sent to #{admin2.email}" />
          
        <h:form id="form">
            <div class="otp-field">
                 <h:inputText id="digit1" maxlength="1" value="#{daoImp.enteredOtp1}"/>
                 <h:inputText id="digit2" maxlength="1" value="#{daoImp.enteredOtp2}"/>
                 <h:inputText id="digit3" maxlength="1" value="#{daoImp.enteredOtp3}"/>
                 <h:inputText id="digit4" maxlength="1" value="#{daoImp.enteredOtp4}"/>
            </div>
            <div class="message"><h:message for="digit1" style="color: red; font: 12px"/></div>
            <h:commandButton styleClass="btn1" action="#{daoImp.validateResetOtp()}" value="Verify OTP" />
        </h:form>
    </div>
</body>
<style>
body {
    margin: 0;
    font-family: "Poppins", sans-serif;
     background-image: url('hospital.jpg');
     background-size:cover;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    height: 100vh;
    
}
.message{
align-content: center;
font-size: adjust;
font-style:inherit;
}
.container {
  background: #fff;
  padding: 30px 65px;
  border-radius: 10px;
  row-gap: 20px;
  box-shadow: 0 5px 10px rgba(0, 0, 0, 0.1);
}
.container header {
  height: 65px;
  width: 65px;
  background: #4070f4;
  color: #fff;
  font-size: 2.5rem;
  border-radius: 50%;
  align-items: center;
}
:where(.container, form, .input-field, header) {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

h4{text-align:center;
    font-size: 1.5rem;
    text-transform: uppercase;
    align-self: center;
    color: black;
    }
 h5{text-align:center;
    font-size: 12px;
    align-self: center;
    color: black;
    } 


.btn1 {
    border: 0;
    background: #7f5feb;
    color: #dfdeee;
    border-radius: 10px;
    width: 100%; /* Adjusted width to take full width */
    height: 35px;
    font-size: 16px;
    margin: 20px auto;
    transition: 0.3s;
    cursor: pointer;
}
.otp-field {
    display: flex;
}

.otp-field input {
    width: 65px;
    font-size: 32px;
    padding: 10px;
    text-align: center;
    border-radius: 5px;
    margin: 2px;
    border: 2px solid #55525c;
    background: #21232d;
    font-weight: bold;
    color: #fff;
    outline: none;
    transition: all 0.1s;
}

.otp-field input:focus {
    border: 2px solid #a527ff;
    box-shadow: 0 0 2px 2px #a527ff6a;
}

.disabled {
    opacity: 0.5;
}

.space {
    margin-right: 1rem !important;
}


</style>

</html>
</f:view>