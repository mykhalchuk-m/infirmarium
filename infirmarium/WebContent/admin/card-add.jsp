<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="../js/jquery/jquery.form.js"></script>

<script type="text/javascript">
$(document).ready(function(){

   var options = { 
              success:       showResponse  // post-submit callback 
     }; 
  $('#cardForm').ajaxForm(options); 
  
  function showResponse(responseText, statusText)  { 
  $("div.result").html(responseText);
 // alert(responseText);
 	//if(statusText=='success'){
 //		document.location.href='<%=application.getContextPath()%>/admin/cardexplorer.action';
 	//}else{
   // 	$("div.result").html(responseText);
  //  }
} 
});
	
	
</script>
<div class="contentb">
<div class="contentt">
<div class="contentl">
<div class="contentr">
<div class="contentbr">
<div class="contenttl">
<div class="contentContent">
<h3>Нова медична карта:</h3>
<s:form id="cardForm" method="post" action="/admin/addcard.action">
<div class="newPanel">
<div class="newParam">Назва відділу</div>
<div class="newValue">
<s:bean	name="com.hospital.service.DbService" id="DbService"></s:bean>
<select name="departmentId" id="departmentId">
<s:iterator value="#DbService.departments" id="department" status="iterator">
	<option value='<s:property value="#department.id" />'><s:property value="#department.name" /></option>
</s:iterator>
</select>	
</div>


<div class="newParam">Пацієнт</div>
<div class="newValue">
<s:bean	name="com.hospital.service.DbService" id="DbService"></s:bean>
<select name="patientId" id="patientId">
<s:iterator value="#DbService.patients" id="patient" status="iterator">
	<option value='<s:property value="#patient.id" />'><s:property value="#patient.firstName" /> <s:property value="#patient.middleName" /> <s:property value="#patient.lastName" /></option>
</s:iterator>
</select>	
</div>



<div class="newParam"></div>
<div class="newValue"><input type="submit" value="Додати мед.карту" />
</div>
</div>
<div class="result" style="text-align: center;"></div>
</s:form>
</div>
</div>
</div>
</div>
</div>
</div>