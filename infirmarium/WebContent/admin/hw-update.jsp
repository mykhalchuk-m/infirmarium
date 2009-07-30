<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
	function sendDataToAction(){
	
			var listRole = document.getElementById("roleString");
			

			$("div.result").load("<%=application.getContextPath()%>/admin/addressupdate.action",
			{
				id: "<s:property value='hwData.id' />",
    			lastName: document.getElementById("lastName").value,
    			firstName: document.getElementById("firstName").value,
    			middleName:	document.getElementById("middleName").value,
    			speciality: document.getElementById("speciality").value,
    			login: document.getElementById("login").value,
    			password: document.getElementById("password").value,
    			roleString: listRole.options[listRole.selectedIndex].value
    					});
		
			return false;
			
	}
	function closeWindow(){
		$(document.getElementById("divForm")).hide();
		location.reload();
	}

</script>
<div id="divForm"  style="position: fixed; width: 300px; border:2px solid #ff5a00; background-color: white; color:black;">

<div class="deleteIcon" onclick="closeWindow();" style="float:none; margin-top: 3px;"></div>
<form method="post" onsubmit="return sendDataToAction();">

	<div class="newPanel">
	<div class="newParam">Прізвище</div>
	<div class="newValue"><input type="text" maxlength="30" name="lastName"
		id="lastName" value="<s:property value='hwData.lastName' />"/></div>
	<div class="newParam">Ім'я</div>
	<div class="newValue"><input type="text" maxlength="30" name="firstName"
		id="firstName" value="<s:property value='hwData.firstName' />"/></div>
	<div class="newParam">По-батькові</div>
	<div class="newValue"><input type="text" maxlength="30" name="middleName"
		id="middleName" value="<s:property value='hwData.middleName' />"/></div>
	<div class="newParam">Спеціалізація</div>
	<div class="newValue"><input type="text" maxlength="50" name="speciality"
		id="speciality" value="<s:property value='hwData.speciality' />"/></div>
	<div class="newParam">Логін</div>
	<div class="newValue"><input type="text" maxlength="30" name="login" id="login" value="<s:property value='hwData.login' />"/></div>
	<div class="newParam">Пароль</div>
	<div class="newValue"><input type="text" maxlength="30" name="password"
		id="password" value="<s:property value='hwData.password' />"/></div>
	<div class="newParam">Роль</div>

	<div class="newValue">
		<s:select list="{'WORKER','ADMIN'}" name="roleString" id="roleString" /></div>

	<div class="newParam"></div>
	<div class="newValue">
		<input type="submit" value="Обновити дані" /></div>
	</div>

	<div class="result" style="text-align: center;"></div>
</form>

</div>
