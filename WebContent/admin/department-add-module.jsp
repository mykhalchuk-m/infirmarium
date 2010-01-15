<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
		
		function sendDataToAction(){
		
		var modulesList = document.getElementById("modules");
			
			$.post("<%=application.getContextPath()%>/admin/updatedepartmentmodules.action",
			{
			departmentId: "<%=request.getParameter("departmentId") %>",
			moduleId: modulesList.options[modulesList.selectedIndex].value
			});

			
		}
</script>

<s:bean name="com.hospital.service.DbService" id="DbService"></s:bean>
<form onsubmit="return  sendDataToAction();" method="post">
	<select id="modules">
		<s:iterator value="#DbService.existModules" id="module">
				<option value="<s:property value='#module.id' />"><s:property value='#module.moduleName' /></option>
		</s:iterator>		
	</select>
<input type="submit"  value="додати модуль"/><span class="result"></span>
</form>