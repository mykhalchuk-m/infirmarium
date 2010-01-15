

<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template"%>
<%@ taglib prefix="s"	uri="/struts-tags"%>

<script type="text/javascript">
	function sendDataToAction(){
	
			var listDep = document.getElementById("department");
			var listRole = document.getElementById("roleString");
			

			$("div.result").load("<%=application.getContextPath()%>/admin/AddHW.action",
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
<template:templatepage title="Медичні працівники">



	<jsp:attribute name="listBox">
	
	

	<h3>
															Health Workers
														</h3>
														This section represents all health workers
														
														<table>
															<thead>
																<tr>
																	<td>№</td>
																	<td>Прізвище</td>
																	<td>Ім'я</td>
																	<td>По-батькові</td>
																	<td>Спеціалізація</td>
																	<td>Роль</td>
																	<td>опції</td>
																</tr>
															</thead>
															
	<s:iterator value="healthWorkers" id="hw">
					
		
			<tr>
				<td><s:property value="#hw.id"/></td>
				 <td><s:property value="#hw.lastName"/> </td>
				<td> <s:property value="#hw.firstName"/> </td>
				 <td><s:property value="#hw.middleName"/></td>
				<td><s:property value="#hw.speciality"/></td>
				<td><s:property value="#hw.role"/></td>
				<td><!-- <div class="modifyIcon"> </div> -->
				
				<s:url action="DeleteHW" id="DeleteHWUrl">
					<s:param name="id" value="#hw.id"/>
				</s:url>

				<a href='<s:property value="#DeleteHWUrl" />'><div class="deleteIcon"> </div></a></td>
			</tr>
					
	</s:iterator>

											
														
																													
														</table>Nullam lorem urna, suscipit eget, suscipit at,
														facilisis et, justo.
		
	</jsp:attribute>

	<jsp:attribute name="addBox">

														<h3>
															Новий медичний пацівник
														</h3>
														<s:form method="post" onsubmit="return sendDataToAction();"><!-- action="AddHW" method="post" -->
														<div class="newPanel">
															<div class="newParam">Прізвище</div>
															<div class="newValue"><input type="text" name="lastName" id="lastName"/></div>
															<div class="newParam">Ім'я</div>
															<div class="newValue"><input type="text" name="firstName" id="firstName"/></div>
															<div class="newParam">По-батькові</div>
															<div class="newValue"><input type="text" name="middleName" id="middleName"/></div>
															<div class="newParam">Спеціалізація</div>
															<div class="newValue"><input type="text" name="speciality" id="speciality"/></div>
															<div class="newParam">Логін</div>
															<div class="newValue"><input type="text" name="login" id="login"/></div>
															<div class="newParam">Пароль</div>
															<div class="newValue"><input type="text" name="password" id="password"/></div>
															<div class="newParam">Роль</div>
															
															 <div class="newValue">
																<s:select list="{'WORKER','ADMIN'}" name="roleString" id="roleString"/>  
															</div>
															<div class="newParam">Відділення</div>
															<div class="newValue">
																<s:bean name="com.hospital.service.DbService" id="DbService">
																</s:bean>
															<s:select list="#DbService.departmentsNames" name="department" id="department"/> 
															</div>
															
															<div class="newParam"></div>
															<div class="newValue">
																<input type="submit" value="Додати працівника"  /> 					
															</div>
															</div>
																
															
															<div class="result" style="text-align: center;"></div>
															</s:form>
															
															
													

	</jsp:attribute>


</template:templatepage>
