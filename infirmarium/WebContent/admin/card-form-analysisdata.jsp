<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@page import="com.hospital.modulecreator.field.FieldTypes"%>
<%@page import="com.hospital.modulecreator.field.Field"%>
<%@page import="com.hospital.cards.Card"%>
<%@page import="com.hospital.hr.SexTypes"%>
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
<h1> <s:property value='formAnalysis.moduleName' /></h1>
<s:form id="moduleDataForm" action="/admin/saveanalysisdata.action" >

<input style="display: none;" type="text" name="analysisData.name"	value='<s:property value="formAnalysis.moduleName" />'/>
<input style="display: none;" type="text" name="abstractModuleId"	value='<s:property value="formAnalysis.id" />'/>
	<table class="formTable">
				
		<s:iterator value="formAnalysis.parameters" id="parameter">
				<tr>
					<td class="param"><s:property value='#parameter.name' />:</td>
					<td class="value">
					
					<% Field selectedField =((Field)request.getAttribute("parameter"));%>
					<% if(selectedField.getType().name().equals(FieldTypes.TEXTBOX.name())) {%>

							<input type="text" maxlength="50"  name="analysisData.parameters['<s:property value="#parameter.name" />']"/>
					<% }else if(selectedField.getType().name().equals(FieldTypes.SELECTBOX.name())){%>
							<select name="analysisData.parameters['<s:property value="#parameter.name" />']">
								<s:iterator value="#parameter.values" id="value">
									<option ><s:property value='#value' /></option>
								</s:iterator>
							</select>
							
												
					<%} else if(selectedField.getType().name().equals(FieldTypes.NORM.name())){%>
							<input type="text" maxlength="5" name="analysisData.normParameters['<s:property value="#parameter.name" />']"/> <%=selectedField.getNorm().getUnit()%>  ( <%= selectedField.getNorm().getMinValue()%> - <%= selectedField.getNorm().getMaxValue()%> )
												
					<%} else if(selectedField.getType().name().equals(FieldTypes.SEX_NORM.name())){%>
							<input type="text" maxlength="5"   name="analysisData.normParameters['<s:property value="#parameter.name" />']"/>
							<%=selectedField.getSexNorm().getUnit()%>  
							<% String sexValue = ((Card)session.getAttribute("CURRENT_VIEW_CARD")).getPatient().getSex().name();%>
							( <%= sexValue.equals(SexTypes.MALE.name())? selectedField.getSexNorm().getMinMaleValue():selectedField.getSexNorm().getMinFemaleValue()%> - <%= sexValue.equals(SexTypes.MALE.name())? selectedField.getSexNorm().getMaxMaleValue():selectedField.getSexNorm().getMaxFemaleValue()%> )
												
					<%} %>	
										
					
					</td>

				</tr>
				
		</s:iterator>	
	
	
	</table>

<s:submit  value="Додати модуль"/>
</s:form>
<div id="resultmoduleDataForm" style="text-align: center;"></div>
