<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
		
		function sendDataToAction1(){
		
		var moduleList = document.getElementById("moduleId");
			
			$("div.resultModule").load("<%=application.getContextPath()%>/admin/loadmoduledataform.action",
			{
			moduleId: moduleList.options[moduleList.selectedIndex].value
			});

			return false;
		}
		
			function sendDataToAction2(){
		
			var analysisList = document.getElementById("analysisId");
			
			$("div.resultAnalysis").load("<%=application.getContextPath()%>/admin/loadanalysisdataform.action",
			{
			analysisId: analysisList.options[analysisList.selectedIndex].value
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
<h3>Заповнення модуля:</h3><br/>
<form id="loadModuleDataForm" onsubmit="return sendDataToAction1();" >
	<select id="moduleId">
		<s:iterator value="#session['CURRENT_VIEW_CARD'].department.modules" id="module">
				<option value="<s:property value='#module.id' />"><s:property value='#module.moduleName' /></option>
		</s:iterator>		
	</select>
<input type="submit"   value="загрузити форму модуля"/>

<div class="resultModule" style="text-align: center;"></div>
</form>
<br/><br/>
<h3>Заповнення аналіз:</h3><br/>
<form id="loadAnalysisDataForm" onsubmit="return sendDataToAction2();" >
	<select id="analysisId">
		<s:iterator value="#session['CURRENT_VIEW_CARD'].department.analyses" id="analysis">
				<option value="<s:property value='#analysis.id' />"><s:property value='#analysis.moduleName' /></option>
		</s:iterator>		
	</select>
<input type="submit"   value="загрузити форму аналізу"/>

<div class="resultAnalysis" style="text-align: center;"></div>
</form>
</div>
</div>
</div>
</div>
</div>
</div>
