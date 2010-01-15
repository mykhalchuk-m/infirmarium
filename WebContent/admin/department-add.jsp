<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
	function sendDataToAction(){
					
		$("div.result").load("<%=application.getContextPath()%>/admin/adddepartment.action",
		{
			name: document.getElementById("departmentName").value
		});
		return false;
	}
</script>
<div class="contentb">
<div class="contentt">
<div class="contentl">
<div class="contentr">
<div class="contentbr">
<div class="contenttl">
<div class="contentContent">
<h3>Новий відділ:</h3>
<form method="post" onsubmit="return sendDataToAction();">
<div class="newPanel">
<div class="newParam">Назва відділу</div>
<div class="newValue"><input type="text"  maxlength="40" name="departmentName"
	id="departmentName" /></div>

<div class="newParam"></div>
<div class="newValue"><input type="submit" value="Додати відділ" />
</div>
</div>
<div class="result" style="text-align: center;"></div>
</form>
</div>
</div>
</div>
</div>
</div>
</div>