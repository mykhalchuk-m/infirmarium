<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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

<h3>Медичні картки</h3>
Фільтр <input>
<table>
	<thead>
		<tr>
			<td>№</td>
			<td>Пацієнт</td>
			<td>створений</td>
			<td>закритий</td>
			<td>Відділ</td>
			<td>Лікар</td>
			<td>Опції</td>
		</tr>
	</thead>
	
	<s:iterator value="cards" id="card" status="iterator">
	<tr>
		<td><s:property value="#card.id" /></td>
		<td>
		
		
		<a href='<s:url action="cardexplorer"/>?cardId=<s:property value="#card.id" />' title="перейти на медичну картку"> <s:property value="#card.patient.firstName" /> <s:property value="#card.patient.middleName" /> <s:property value="#card.patient.lastName" /> </a>
		</td>
		<td><s:property value="#card.start" /></td>
		<td><s:property value="#card.end" /></td>
		<td><s:property value="#card.department.name" /></td>
		<td><b><s:property value="#card.healthWorker.firstName" /> <s:property value="#card.healthWorker.middleName" /> <s:property value="#card.healthWorker.lastName" /></b></td>
		<td><a href="cardExplorer.html">
		<div class="modifyIcon"></div>
		</a>
		<div class="deleteIcon"></div>
		</td>
	</tr>
	</s:iterator>
	</table>
</div>
</div>
</div>
</div>
</div>
</div>