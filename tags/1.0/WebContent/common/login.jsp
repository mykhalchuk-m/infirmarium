
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="../css/generic.css" />
<link rel="stylesheet" type="text/css" href="../css/login.css" />

<link type="text/css" href="../js/jquery/theme/ui.all.css"
	rel="Stylesheet" />
<link type="text/css" href="../css/select_w
		indow.css"
	rel="Stylesheet" />
<script type="text/javascript" src="../js/jquery/jquery-1.3.2.min.js"></script>

<script type="text/javascript"
	src="../js/jquery/jquery-ui-1.7.custom.min.js"></script>
<script type="text/javascript" src="../js/interface.js"></script>
<script type="text/javascript" src="../js/select_window.js"></script>
<script type="text/javascript"></script>
<title>Login</title>
</head>
<body>
<div class="loginMain">
<div class="logo"></div>

<s:form action="/common/Login.action" method="post">
	<p>Логін</p>
	<s:textfield name="login" cssClass="input"></s:textfield>
	<p>Пароль</p>
	<s:password name="password" cssClass="input"></s:password>

	<s:if test="hasErrors()">

		<s:if test="hasActionErrors()">
			<s:iterator value="actionErrors">
				<p style="color: #FF5A00;"><s:property /></p>
			</s:iterator>
			</s:if>
			
			<s:if test="hasFieldErrors()">
				<s:iterator value="fieldErrors">
					<s:iterator value="value">
						<p style="color: #FF5A00;"><s:property /></p>
					</s:iterator>
				</s:iterator>
			</s:if>

		</s:if>

		<s:submit type="button" value="ENTER" cssClass="submitButton"></s:submit>
</s:form></div>



</body>
</html>