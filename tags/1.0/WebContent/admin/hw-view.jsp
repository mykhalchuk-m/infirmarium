<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="contentb">
<div class="contentt">
<div class="contentl">
<div class="contentr">
<div class="contentbr">
<div class="contenttl">
<div class="contentContent"><script type="text/javascript"
	src="../js/table.js"></script> <script type="text/javascript">

	function deleteHw(hw_id){
		if(confirm("видалити?")){
			$.post("<%=application.getContextPath()%>/admin/deletehw.action",
			{
				id: ""+hw_id
			});
			location.reload();
		}
	}
	function addUpdateHwPanel(hw_id){
		$(document.getElementById("idUpdatePanel")).load("<%=application.getContextPath()%>/admin/updatehwdata.action",
		{
			hwId: ""+hw_id
		});
	}

</script>

<h3>Медичні працівники</h3>
<table  class="items-table">

	<thead>
		<tr>
			<td>№</td>
			<td>Прізвище</td>
			<td>Ім'я</td>
			<td>По-батькові</td>
			<td>Спеціалізація</td>
			<td>Роль</td>
			<td>опції</td>
			<div id="idUpdatePanel"></div>
		</tr>
	</thead>

	<s:iterator value="healthWorkers" id="hw" status="iterator">


		<tr>
			<td><s:property value="#iterator.count" /></td>
			<td><s:property value="#hw.lastName" /></td>
			<td><s:property value="#hw.firstName" /></td>
			<td><s:property value="#hw.middleName" /></td>
			<td><s:property value="#hw.speciality" /></td>
			<td><s:property value="#hw.role" /></td>
			<td>
			<div class="modifyIcon"
				onclick='addUpdateHwPanel(<s:property value="#hw.id" />)'></div>
			<div class="deleteIcon"
				onclick='deleteHw(<s:property value="#hw.id" />)'></div>
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