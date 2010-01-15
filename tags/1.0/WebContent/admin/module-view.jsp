<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="../js/table.js"></script>
<script type="text/javascript" >
function modifyModule(id_module){
alert(id_module);
}
function deleteModule(id_module){
	if (confirm("видалити?")){
		$.post("<%=application.getContextPath()%>/admin/deletemodule.action",
		{
			id: ""+id_module
		});
		location.reload();
	}
}
</script>

<div class="contentb">
<div class="contentt">
<div class="contentl">
<div class="contentr">
<div class="contentbr">
<div class="contenttl">
<div class="contentContent">

<h3>Модулі</h3>
<table class="items-table">
	<thead>
		<tr>
			<td>№</td>
			<td>модуль</td>
			<td>опції</td>
			
		</tr>
	</thead>

	<s:iterator value="modules" id="module" status="iterator">
		<tr>
			<td><s:property value="#iterator.count" /></td>
			<td><s:property value="#module.moduleName" /></td>
			<td>
				<!--<div class="modifyIcon" onclick='modifyModule("<s:property value="#module.id" />")'> </div>-->
				<div class="deleteIcon" onclick='deleteModule("<s:property value="#module.id" />")'> </div>
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