<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<template:templatepage title="Медичні карти">
 
	<jsp:attribute name="urlTab1">/admin/viewcard.action</jsp:attribute>
	<jsp:attribute name="urlTab2">/admin/viewcardform.action</jsp:attribute>
	
	<jsp:attribute name="logo"><img src="../images/logo_large.gif" alt="Logo"></jsp:attribute>
</template:templatepage>