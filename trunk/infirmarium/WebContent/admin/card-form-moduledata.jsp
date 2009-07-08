<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@page import="com.hospital.modulecreator.field.FieldTypes"%>
<%@page import="com.hospital.modulecreator.field.Field"%>
<script type="text/javascript" src="../js/jquery/jquery.form.js"></script>

<script type="text/javascript">
$(document).ready(function(){

   var options = { 
              success:       showResponse  // post-submit callback 
     }; 
  $('#moduleDataForm').ajaxForm(options); 
  
  function showResponse(responseText, statusText)  { 
    $("#resultmoduleDataForm").html(responseText);
}
});
	
	
</script>
<br/>
<h1> <s:property value='formModule.moduleName' /></h1>
<s:form id="moduleDataForm" action="/admin/savemoduledata.action" >
				<input style="display: none;"  type="text" name="moduleData.name"	value='<s:property value="formModule.moduleName" />'/>
				<input style="display: none;"  type="text" name="abstractModuleId"	value='<s:property value="formModule.id" />'/>

	<table class="formTable">
				
				<tr style="display: none;">
					<td class="param">Імя модуля :</td>
					<td class="value"><input  maxlength="100"  type="text" name="moduleData.name"	value='<s:property value="formModule.moduleName" />'/></td>

				</tr>
		<s:iterator value="formModule.parameters" id="parameter">
				<tr>
					<td class="param"><s:property value='#parameter.name' />:</td>
					<td class="value">
					
					<% if(((Field)request.getAttribute("parameter")).getType().name().equals(FieldTypes.TEXTBOX.name())) {%>

							<input type="text"  maxlength="50" name="moduleData.parameters['<s:property value="#parameter.name" />']"/>
					<% }else if(((Field)request.getAttribute("parameter")).getType().name().equals(FieldTypes.SELECTBOX.name())){%>
							<select name="moduleData.parameters['<s:property value="#parameter.name" />']">
								<s:iterator value="#parameter.values" id="value">
									<option ><s:property value='#value' /></option>
								</s:iterator>
							</select>
							
												
					<%} %>					
					
					</td>

				</tr>
				
		</s:iterator>	
	
	
	</table>

<s:submit  value="Додати модуль"/>
</s:form>
<div id="resultmoduleDataForm" style="text-align: center;"></div>
