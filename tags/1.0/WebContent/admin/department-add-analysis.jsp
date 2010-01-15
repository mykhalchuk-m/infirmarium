<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
		
		function sendDataToAction(){
		
		var analysesList = document.getElementById("analyses");
			
			$.post("<%=application.getContextPath()%>/admin/updatedepartmentanalyses.action",
			{
			departmentId: "<%=request.getParameter("departmentId") %>",
			analysisId: analysesList.options[analysesList.selectedIndex].value
			});

			
		}
</script>

<s:bean name="com.hospital.service.DbService" id="DbService"></s:bean>
<form onsubmit="return  sendDataToAction();" method="post"><select
	id="analyses">
	<s:iterator value="#DbService.existAnalyses" id="analysis">
		<option value="<s:property value='#analysis.id' />"><s:property
			value='#analysis.moduleName' /></option>
	</s:iterator>
</select> <input type="submit" value="додати аналіз" /><span class="result"></span>
</form>