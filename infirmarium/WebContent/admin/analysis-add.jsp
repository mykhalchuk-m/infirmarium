<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript" src="../js/analysis_building.js"></script>
<script type="text/javascript" src="../js/jquery/jquery.form.js"></script>

<script type="text/javascript">

$(document).ready( function() {
	var options = { 		
	success: showResponse // post-submit callback 
}; 
	$('#analysisForm').ajaxForm(options); 
	
});


function showResponse(responseText, statusText)  { 
	$("div.result").html(responseText);
} 


</script>

<div class="contentb">
<div class="contentt">
<div class="contentl">
<div class="contentr">
<div class="contentbr">
<div class="contenttl">
<div class="contentContent"><s:form id="analysisForm"
	action="/admin/addanalysis.action">
	<div class="parametr" id="param_1"></div>
	<div class="newParam">Назва аналізу</div>
	<div class="newValue"><input maxlength="120" type="text"
		name="analysis.moduleName" /> <s:submit value="Додати аналіз" /></div>
	<div class="newParam">Відділення</div>
	<div class="newValue"><s:bean
		name="com.hospital.service.DbService" id="DbService"></s:bean> <s:select
		list="#DbService.departmentsNames" name="department" id="department" /></div>
</s:form>
<div><span class="addButtonParam" /></div>
<div class="result" style="text-align: center;"></div>



</div>
</div>
</div>
</div>
</div>
</div>