<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="contentb">
<div class="contentt">
<div class="contentl">
<div class="contentr">
<div class="contentbr">
<div class="contenttl">
<div class="contentContent">

<script type="text/javascript" src="../js/table.js"></script>

<h3>Пацієнти</h3>


<table>
	<thead>
		<tr>
			<td>№</td>
			<td>Прізвище</td>
			<td>Ім'я</td>
			<td>По-батькові</td>
			<td>Адреса</td>
			<td>день народження</td>
			<td>група крові</td>
		</tr>
	</thead>

	<s:iterator value="patients" id="patient" status="iterator">


		<tr>
			<td><s:property value="#iterator.count" /></td>
			<td><s:property value="#patient.lastName" /></td>
			<td><s:property value="#patient.firstName" /></td>
			<td><s:property value="#patient.middleName" /></td>
			<td><s:property value="#patient.address" /></td>
			<td><s:property value="#patient.birthday" /></td>
			<td><s:property value="#patient.bloodGroup.bloodGroupValue" /></td>
		</tr>

	</s:iterator>




</table>
</div>
</div>
</div>
</div>
</div>
</div>