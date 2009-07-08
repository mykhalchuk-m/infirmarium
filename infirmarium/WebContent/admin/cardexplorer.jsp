<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<template:templatepage title="Огляд медичної карти">

	<jsp:attribute name="urlTab1">/admin/viewcarddata.action</jsp:attribute>
	<jsp:attribute name="urlTab2">/admin/viewmoduledataform.action</jsp:attribute>

	<jsp:attribute name="logo">
	
		<div class="infoPanelContent">
			<a href="#"><span class="icoPatient">&nbsp;</span><s:property value="#session['CURRENT_VIEW_CARD'].patient.firstName"/> <s:property value="#session['CURRENT_VIEW_CARD'].patient.middleName"/> <s:property value="#session['CURRENT_VIEW_CARD'].patient.lastName"/></a>
											<br/>
											<s:property value="#session['CURRENT_VIEW_CARD'].patient.birthday"/>
											<br/>
											<s:property value="#session['CURRENT_VIEW_CARD'].patient.bloodGroup.bloodGroupValue"/>
											<br/>
		</div>
	</jsp:attribute>
</template:templatepage>
