<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="com.hospital.module.AnalysisData"%>
<%@page import="com.hospital.modulecreator.field.Field"%>
<%@page import="com.hospital.modulecreator.field.FieldTypes"%>
<%@page import="web.security.Constants"%>
<%@page import="com.hospital.cards.Card"%>
<%@page import="com.hospital.hr.SexTypes"%>
<script type="text/javascript" src="../js/table.js"></script>
<script type="text/javascript">
				
		
		
</script>
<div class="contentb">
<div class="contentt">
<div class="contentl">
<div class="contentr">
<div class="contentbr">
<div class="contenttl">
<div class="contentContent">

<s:iterator value="#session['CURRENT_VIEW_CARD'].modulesData" id="moduleData">
<h3>Модуль: <b>"<s:property value="#moduleData.name"/>"</b></h3> (заповнений: <s:property value="#moduleData.creationDate"/> ) 
 <table>
	<thead>
		<tr>
			<td>№</td>
			<td>параметр</td>
			<td>значення</td>
	
		</tr>
	</thead>
	
	<s:iterator value="#moduleData.parameters" status="stat">
	<tr>
		<td><s:property value="#stat.count" /></td>
		<td><s:property value="key"/></td>
		<td><s:property value="value"/></td>
		
	</tr>
	</s:iterator>
	</table>
	<br/>
</s:iterator>

	<hr/>


<s:iterator value="#session['CURRENT_VIEW_CARD'].analysesData" id="analysesData">
<h3>Аналіз: <b>"<s:property value="#analysesData.name"/>"</b></h3> (заповнений: <s:property value="#analysesData.creationDate"/> ) 
 <table>
	<thead>
		<tr>
			<td>№</td>
			<td>параметр</td>
			<td>значення</td>
			<td>додаток</td>
		</tr>
	</thead>
		<s:iterator value="#analysesData.parameters" status="stat">
	<tr>
		<td><s:property value="#stat.count" /></td>
		<td><s:property value="key"/></td>
		<td><s:property value="value"/></td>
			<td></td>
	</tr>
	</s:iterator>
	
	<s:iterator value="#analysesData.normParameters" status="stat">
	<tr>
		<td><s:property value="#stat.count+#analysesData.parameters.size" /></td>
		<td><s:property value="key"/></td>
		<td><s:property value="value"/></td>
		
		<%
		AnalysisData aDt = (AnalysisData)request.getAttribute("analysesData");
		String name = (String)request.getAttribute("key");
		Field fieldDt= aDt.getAbstractModule().getParameter(name);
		
		String result = "";
		 if(fieldDt.getType().name().equals(FieldTypes.NORM.name())) {
			 result=fieldDt.getNorm().getUnit()+"  ("+fieldDt.getNorm().getMinValue()+" - "+fieldDt.getNorm().getMaxValue()+" )";
		} else if(fieldDt.getType().name().equals(FieldTypes.SEX_NORM.name())){
			SexTypes sex = ((Card)session.getAttribute(Constants.CURRENT_VIEW_CARD.name())).getPatient().getSex();
		
			if(sex.name().equals(SexTypes.MALE.name())){
				 result=fieldDt.getSexNorm().getUnit()+"  ("+fieldDt.getSexNorm().getMinMaleValue()+" - "+fieldDt.getSexNorm().getMaxMaleValue()+" )";
			}else{
				result=fieldDt.getSexNorm().getUnit()+"  ("+fieldDt.getSexNorm().getMinFemaleValue()+" - "+fieldDt.getSexNorm().getMaxFemaleValue()+" )";
			}
		}
		%>
		
		<td><%=result %></td>	
		
	</tr>
	</s:iterator>
	</table>
	<br/>
</s:iterator>

	
</div>
</div>
</div>
</div>
</div>
</div>