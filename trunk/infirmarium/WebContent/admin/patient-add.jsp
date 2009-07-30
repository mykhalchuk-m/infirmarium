<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript">
	function sendDataToAction(){
	
		var listbloodGroups = document.getElementById("bloodGroups");
			var listSex = document.getElementById("sexString");
			
			//alert("start request");
			$("div.result").load("<%=application.getContextPath()%>/admin/addpatient.action",
			{
    			lastName: document.getElementById("lastName").value,
    			firstName: document.getElementById("firstName").value,
    			middleName:	document.getElementById("middleName").value,
				country: document.getElementById("country").value,
				region: document.getElementById("region").value,
				district:	document.getElementById("district").value,
				city: document.getElementById("city").value,
				street: document.getElementById("street").value,
				home: document.getElementById("home").value,
				flatNumber: document.getElementById("flatNumber").value,
    			birthdayString: document.getElementById("birthdayStringdd").value+"-"+
    							document.getElementById("birthdayStringmm").value+"-"+
    							document.getElementById("birthdayStringyyyy").value,
    			bloodGroupString: listbloodGroups.options[listbloodGroups.selectedIndex].value,
    			sexString: listSex.options[listSex.selectedIndex].value
    		});
			//alert("end request");
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
<h3>Новий пацієнт</h3>
<form method="post" onsubmit="return sendDataToAction();"><!-- action="AddHW" method="post" -->
<div class="newPanel">
<div class="newParam">Прізвище</div>
<div class="newValue"><input type="text" maxlength="30"
	name="lastName" id="lastName" /></div>
<div class="newParam">Ім'я</div>
<div class="newValue"><input type="text" maxlength="30"
	name="firstName" id="firstName" /></div>
<div class="newParam">По-батькові</div>
<div class="newValue"><input type="text" maxlength="30"
	name="middleName" id="middleName" /></div>
<div class="newParam">Країна</div>
<div class="newValue"><input type="text" maxlength="30"
	name="country" id="country" /></div>
<div class="newParam">Область</div>
<div class="newValue"><input type="text" maxlength="30"
	name="region" id="region" /></div>
<div class="newParam">Район</div>
<div class="newValue"><input type="text" maxlength="30"
	name="district" id="district" /></div>
<div class="newParam">Населений путкт</div>
<div class="newValue"><input type="text" maxlength="50"
	name="city" id="city" /></div>
<div class="newParam">Вулиця</div>
<div class="newValue"><input type="text" maxlength="30"
	name="street" id="street" /></div>
<div class="newParam">Будинок</div>
<div class="newValue"><input type="text" maxlength="30"
	name="home" id="home" /></div>
<div class="newParam">Квартира</div>
<div class="newValue"><input type="text" maxlength="30"
	name="flatNumber" id="flatNumber" /></div>
<div class="newParam">Дата народження</div>
<div class="newValue"><!-- <input type="text" name="birthdayString"	id="birthdayString" value="дд-мм-рррр" size=""/> -->
<input type="text" value="mm" id="birthdayStringdd" size="2"
	maxlength="2" /> - <input type="text" value="mm" id="birthdayStringmm"
	size="2" maxlength="2" /> - <input type="text" value="yyyy"
	id="birthdayStringyyyy" size="4" maxlength="4" />(дд-мм-рррр)</div>

<div class="newParam">Група крові</div>
<div class="newValue"><s:bean
	name="com.hospital.service.DbService" id="DbService">
</s:bean> <s:select list="#DbService.bloodGroupsName" name="bloodGroups"
	id="bloodGroups" /></div>

<div class="newParam">Стать</div>
<div class="newValue"><select name="sexString" id="sexString">
	<option value="MALE">чоловіча</option>
	<option value="FEMALE">жіноча</option>
</select></div>


<div class="newParam"></div>
<div class="newValue"><input type="submit" value="Додати пацієнта" /></div>
</div>


<div class="result" style="text-align: center;"></div>
</form>
</div>
</div>
</div>
</div>
</div>
</div>