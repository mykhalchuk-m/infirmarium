<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
	function sendDataToAction(){
	
			$("div.result").load("<%=application.getContextPath()%>/admin/addaddress.action",
			{
				country: document.getElementById("country").value,
				region: document.getElementById("region").value,
				distinct:	document.getElementById("distinct").value,
				city: document.getElementById("city").value,
				street: document.getElementById("street").value,
				home: document.getElementById("home").value,
				flatNumber: document.getElementById("flatNumber").value
    		});
		
			return false;
			
	}
	function closeWindow(){
		$(document.getElementById("divForm")).hide();
		location.reload();
	}

</script>
<div id="divForm"  style="position: fixed; width: 300px; border:2px solid #ff5a00; background-color: white; color:black;">

<div class="deleteIcon" onclick="closeWindow();" style="float:none; margin-top: 3px;"></div>
<form method="post" onsubmit="return sendDataToAction();">

	<div class="newPanel">
	<div class="newParam">Країна</div>
	<div class="newValue">
		<input type="text" maxlength="30" name="country" id="country" />
	</div>
	<div class="newParam">Область</div>
	<div class="newValue">
		<input type="text" maxlength="30" name="region" id="region" />
	</div>
	<div class="newParam">Район</div>
	<div class="newValue">
		<input type="text" maxlength="30" name="distinct" id="distinct" />
	</div>
	<div class="newParam">Населений путкт</div>
	<div class="newValue">
		<input type="text" maxlength="50" name="city" id="city" />
	</div>
	<div class="newParam">Вулиця</div>
	<div class="newValue">
		<input type="text" maxlength="30" name="street" id="street" />
	</div>
	<div class="newParam">Будинок</div>
	<div class="newValue">
		<input type="text" maxlength="30" name="home" id="home" />
	</div>
	<div class="newParam">Квартира</div>
	<div class="newValue">
		<input type="text" maxlength="30" name="flatNumber" id="flatNumber" />	
	</div>

	<div class="newParam"></div>
	<div class="newValue">
		<input type="submit" value="Додати адрес" /></div>
	</div>

	<div class="result" style="text-align: center;"></div>
</form>

</div>