<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript"
	src='<c:url value="../js/jquery/jquery.validate.js"/>'></script>
<script type="text/javascript">
	$(document).ready(function() {
		//	$("#birthday").datepicker();
		   
	var validator = $("#addUser").validate({
		rules: {		
			firstName: {
				required: true					
			},
			lastName: {
				required: true				
			},
			middleName: {
				required: true
			},
			birthday: {
				required: true,
				date: true
			}
		},
		messages: {
			
			firstName: {
				required: "Це поле обов'язкове до заповнення."
			},
			lastName: {
				required: "Це поле обов'язкове до заповнення."
			},
			middleName: {
				required: "Це поле обов'язкове до заповнення."			
			},
			birthday: {
				required: "Це поле обов'язкове до заповнення.",
				date: "Формат дати має бути таким дд/мм/рррр."				
			}
		},
		// the errorPlacement has to take the table layout into account
		errorPlacement: function(error, element) {		
				$("#validation_"+element.attr("id")).append(error);
				
				// element.addClass("validationInputError");
				// error.appendTo( element.next() );
		},
		// specifying a submitHandler prevents the default submit, good for the
		// demo
				// set this class to error-labels to indicate valid fields
		submitHandler: function(form) {
			submitData();
 		},
				
		success: function(label) {
			// set &nbsp; as text for IE
			//sendDataToAction();
			label.html("&nbsp;").addClass("validationHelp");
		}
	});
	});
	
	function submitData(){
		var listbloodGroups = document.getElementById("bloodGroups");
			var listSex = document.getElementById("sexString");
			
			//alert("start request");
			$("div.result").load("<%=application.getContextPath()%>/admin/addpatient.action",
						{
							lastName : document.getElementById("lastName").value,
							firstName : document.getElementById("firstName").value,
							middleName : document.getElementById("middleName").value,
							country : document.getElementById("country").value,
							region : document.getElementById("region").value,
							district : document.getElementById("district").value,
							city : document.getElementById("city").value,
							street : document.getElementById("street").value,
							home : document.getElementById("home").value,
							flatNumber : document.getElementById("flatNumber").value,
							birthdayString : document.getElementById("birthday").value,
							bloodGroupString : listbloodGroups.options[listbloodGroups.selectedIndex].value,
							sexString : listSex.options[listSex.selectedIndex].value
						});
		//alert("end request");
		document.getElementById("lastName").value="";
		document.getElementById("firstName").value="";
		document.getElementById("middleName").value="";
		document.getElementById("country").value="";
		document.getElementById("region").value="";
		document.getElementById("district").value="";
		document.getElementById("city").value="";
		document.getElementById("street").value="";
		document.getElementById("home").value="";
		document.getElementById("flatNumber").value="";
		document.getElementById("birthday").value="";
		listSex.selectedIndex=0;
		listbloodGroups.selectedIndex=0;
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
<div class="result" style="text-align: center;"></div>
<form id="addUser" method="post"><!-- action="AddHW" method="post" -->

<table class="form">
	<tr>
		<td class="form-name">Прізвище</td>
		<td><input type="text" maxlength="30" name="lastName"
			id="lastName" /></td>
		<td>*</td>
		<td id="validation_lastName"></td>
	</tr>
	<tr>
		<td class="form-name">Ім'я</td>
		<td><input type="text" maxlength="30" name="firstName"
			id="firstName" /></td>
		<td>*</td>
		<td id="validation_firstName"></td>
	</tr>
	<tr>
		<td class="form-name">По-батькові</td>
		<td><input type="text" maxlength="30" name="middleName"
			id="middleName" /></td>
		<td>*</td>
		<td id="validation_middleName"></td>
	</tr>
	<tr>
		<td class="form-name">Дата народження</td>
		<td><input title="Дата у форматі дд-мм-рррр." type="text"
			value="" name="birthday" id="birthday" maxlength="10" /></td>
		<td>*</td>
		<td id="validation_birthday"></td>
	</tr>
	<tr>
		<td class="form-name">Стать</td>
		<td><select name="sexString" id="sexString">
			<option value="MALE">чоловіча</option>
			<option value="FEMALE">жіноча</option>
		</select></td>
		<td></td>
		<td id="validation_sexString"></td>
	</tr>
	<tr>
		<td class="form-name">Група крові</td>
		<td><s:bean name="com.hospital.service.DbService" id="DbService"></s:bean>
		<s:select list="#DbService.bloodGroupsName" name="bloodGroups"
			id="bloodGroups" /></td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td class="form-name">Країна</td>
		<td><input type="text" maxlength="30" name="country" id="country" />
		</td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td class="form-name">Область</td>
		<td><input type="text" maxlength="30" name="region" id="region" />
		</td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td class="form-name">Район</td>
		<td><input type="text" maxlength="30" name="district"
			id="district" /></td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td class="form-name">Населений пункт</td>
		<td><input type="text" maxlength="50" name="city" id="city" /></td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td class="form-name">Вулиця</td>
		<td><input type="text" maxlength="30" name="street" id="street" />
		</td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td class="form-name">Будинок</td>
		<td><input type="text" maxlength="30" name="home" id="home" /></td>
		<td></td>
		<td></td>
	</tr>
	<tr>
		<td class="form-name">Квартира</td>
		<td><input type="text" maxlength="30" name="flatNumber"
			id="flatNumber" /></td>
		<td></td>
		<td></td>
	</tr>
</table>

<input type="submit" value="Додати пацієнта" /></form>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
