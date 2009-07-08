<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="../js/table.js"></script>
<script type="text/javascript">
				
		function addModulPanel(tdId){

			$(document.getElementById(tdId)).load("<%=application.getContextPath()%>/admin/department-add-module.jsp",
			{
			departmentId: ""+tdId
			});

		}
		
		function addAnalysisPanel(tdId){

			$(document.getElementById(tdId)).load("<%=application.getContextPath()%>/admin/department-add-analysis.jsp",
			{
			departmentId: ""+tdId
			});

		}
		
</script>
<div class="contentb">
<div class="contentt">
<div class="contentl">
<div class="contentr">
<div class="contentbr">
<div class="contenttl">
<div class="contentContent">

<h3>Відділи</h3>
<table>
	<thead>
		<tr>
			<td>№</td>
			<td>Відділи</td>
			<td>модулі</td>
			<td>аналізи</td>
			<td>опції</td>
			<td></td>
		</tr>
	</thead>

	<s:iterator value="departments" id="department" status="iterator">
		<tr>
			<td><s:property value="#iterator.count" /></td>
			<td><s:property value="#department.name" /></td>

			<td>
			<ul>

				<s:iterator value="#department.modules" id="module">
					<li style="float: right; width: 100%;"><s:property
						value="#module.moduleName" /></li>
				</s:iterator>
			</ul>
			</td>
			<td>
			<ul>
				<s:iterator value="#department.analyses" id="analysis">
					<li style="float: right; width: 100%;"><s:property
						value="#analysis.moduleName" /></li>
				</s:iterator>
			</ul>
			</td>
			<td>
			<div class="updateDepModIcon" title="додати модуль"
				onclick='addModulPanel("<s:property value="#department.id" />")'></div>
			<div class="updateDepAnIcon" title="додати аналіз"
				onclick='addAnalysisPanel("<s:property value="#department.id" />")'></div>
			</td>
			<td id='<s:property value="#department.id" />'></td>
		</tr>
	</s:iterator>


</table>
</div>
</div>
</div>
</div>
</div>
</div>