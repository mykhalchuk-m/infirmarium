<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
	function sendDataToAction(){
	
			var listDep = document.getElementById("department");
			var listRole = document.getElementById("roleString");
			

			$("div.result").load("<%=application.getContextPath()%>/admin/addhw.action",
			{
    			lastName: document.getElementById("lastName").value,
    			firstName: document.getElementById("firstName").value,
    			middleName:	document.getElementById("middleName").value,
    			speciality: document.getElementById("speciality").value,
    			login: document.getElementById("login").value,
    			password: document.getElementById("password").value,
    			roleString: listRole.options[listRole.selectedIndex].value,
    			department: listDep.options[listDep.selectedIndex].value
    					});
		
			return false;
			
	}

</script>
<div class="contentb">
<div class="contentt">
<div class="contentl">
<div class="contentr">
<div class="contentbr">
<div class="contenttl">
<div class="contentContent">
<h3>Новий медичний пацівник</h3>
<s:form method="post" onsubmit="return sendDataToAction();">
	<!-- action="AddHW" method="post" -->
	<div class="newPanel">
	<div class="newParam">Прізвище</div>
	<div class="newValue"><input type="text" maxlength="30" name="lastName"
		id="lastName" /></div>
	<div class="newParam">Ім'я</div>
	<div class="newValue"><input type="text" maxlength="30" name="firstName"
		id="firstName" /></div>
	<div class="newParam">По-батькові</div>
	<div class="newValue"><input type="text" maxlength="30" name="middleName"
		id="middleName" /></div>
	<div class="newParam">Спеціалізація</div>
	<div class="newValue"><input type="text" maxlength="50" name="speciality"
		id="speciality" /></div>
	<div class="newParam">Логін</div>
	<div class="newValue"><input type="text" maxlength="30" name="login" id="login" /></div>
	<div class="newParam">Пароль</div>
	<div class="newValue"><input type="text" maxlength="30" name="password"
		id="password" /></div>
	<div class="newParam">Роль</div>

	<div class="newValue"><s:select list="{'WORKER','ADMIN'}"
		name="roleString" id="roleString" /></div>
	<div class="newParam">Відділення</div>
	<div class="newValue"><s:bean
		name="com.hospital.service.DbService" id="DbService">
	</s:bean> <s:select list="#DbService.departmentsNames" name="department"
		id="department" /></div>

	<div class="newParam"></div>
	<div class="newValue"><input type="submit"
		value="Додати працівника" /></div>
	</div>


	<div class="result" style="text-align: center;"></div>
</s:form></div>
</div>
</div>
</div>
</div>
</div>