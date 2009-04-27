<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template"%>

<template:templatepage title="Модулі">

	<jsp:attribute name="head">
		<link type="text/css" href="../css/module_building.css" rel="Stylesheet" />
		<script type="text/javascript" src="../js/module_building.js"></script>
	</jsp:attribute>
	
	<jsp:attribute name="listBox">
															<h3>
															Modules
														</h3>
														Filter <input></input>
														
		
		<table>
															<thead>
																<tr>
																	<td>
																		ID
																	</td>
																	<td>
																		Module
																	</td>
																	<td>
																		Mod
																	</td>																
																</tr>
															</thead>
															<tr>
																<td>
																	0001
																</td>
																<td>
																	Common
																</td>
																<td>
				<div class="modifyIcon"> </div>
				<div class="deleteIcon"> </div></td>
														</tr>
															<tr>
																<td>0002</td>
																<td>Operation result</td>
															    <td>
				<div class="modifyIcon"> </div>
				<div class="deleteIcon"> </div></td>
													
															</tr>
															<tr>
																<td>0003</td>
																<td>Diagnos</td>
																<td>
				<div class="modifyIcon"> </div>
				<div class="deleteIcon"> </div></td>
													
															</tr>
																													
														</table>
	</jsp:attribute>


	<jsp:attribute name="addBox">
															<h3>
															New module name
														</h3>
														<form>
														<div class="parametr" id="param_1">
															<div class="deleteParametr" id="delParam_1"></div>
															<div class="parametrName">
																Назва <input>
															</div>
															<div class="parametrType" id="varType_1">
																<input type="radio" name="type_1" value="field">Поле
																<input type="radio" name="type_1" value="variants"
			id="varId_1">Варіанти	
																<input type="radio" name="type_1" value="checkbox">Відмітка																
															</div>
																														
															<div class="parametrVariants" id="varPanel_1">
																<div class="parametrVariant"><input><span
			class="deleteButtonSmall"></div>
																<div class="parametrVariant"><input><span
			class="deleteButtonSmall"></div>
																<div class="parametrVariant"><input><span
			class="deleteButtonSmall"></div>
																<div class="parametrVariant"><input><span
			class="deleteButtonSmall"></div>
																<div class="parametrVariant"><input><span
			class="deleteButtonSmall"></div>
																<div class="parametrVariant"><input><span
			class="deleteButtonSmall"></div>
																<div class="parametrVariant"><input><span
			class="deleteButtonSmall"></div>
																<span class="addButtonSmall">			
															</div>	
																																								
														</div>
														<div class="parametr">
															<div class="deleteParametr"></div>
															<div class="parametrName">
																Назва <input>
															</div>
															<div class="parametrType">
																<input type="radio" name="type_1" value="field">Поле
																<input type="radio" name="type_1" value="variants"
			id="varId_1">Варіанти	
																<input type="radio" name="type_1" value="checkbox">Відмітка																
															</div>
																														
															<div class="parametrVariants" id="varPanel_1">
															<div class="parametrVariant"><input><span
			class="deleteButtonSmall"></div>
																<div class="parametrVariant"><input><span
			class="deleteButtonSmall"></div>
																<div class="parametrVariant"><input><span
			class="deleteButtonSmall"></div>
																<span class="addButtonSmall">			
															</div>	
																																								
														</div>
														<div class="parametr">
															<div class="deleteParametr"></div>
															<div class="parametrName">
																Назва <input>
															</div>
															<div class="parametrType">
																<input type="radio" name="type_1" value="field">Поле
																<input type="radio" name="type_1" value="variants"
			id="varId_1">Варіанти	
																<input type="radio" name="type_1" value="checkbox">Відмітка																
															</div>
																														
															<div class="parametrVariants" id="varPanel_1">
																<div class="parametrVariant"><input><span
			class="deleteButtonSmall"></div>
																<div class="parametrVariant"><input><span
			class="deleteButtonSmall"></div>
																<div class="parametrVariant"><input><span
			class="deleteButtonSmall"></div>
																<div class="parametrVariant"><input><span
			class="deleteButtonSmall"></div>
																<div class="parametrVariant"><input><span
			class="deleteButtonSmall"></div>
																<span class="addButtonSmall">			
															</div>	
																																								
														</div>
														<div class="parametr">
															<div class="deleteParametr"></div>
															<div class="parametrName">
																Назва <input>
															</div>
															<div class="parametrType">
																<input type="radio" name="type_1" value="field">Поле
																<input type="radio" name="type_1" value="variants"
			id="varId_1">Варіанти	
																<input type="radio" name="type_1" value="checkbox">Відмітка																
															</div>
																														
															<div class="parametrVariants" id="varPanel_1">
																<div class="parametrVariant"><input><span
			class="deleteButtonSmall"></div>
																<div class="parametrVariant"><input><span
			class="deleteButtonSmall"></div>
																<div class="parametrVariant"><input><span
			class="deleteButtonSmall"></div>
																<div class="parametrVariant"><input><span
			class="deleteButtonSmall"></div>
																<span class="addButtonSmall">			
															</div>	
																																								
														</div>
														<div class="parametr">
															<div class="deleteParametr"></div>
															<div class="parametrName">
																Назва <input>
															</div>
															<div class="parametrType">
																<input type="radio" name="type_1" value="field">Поле
																<input type="radio" name="type_1" value="variants"
			id="varId_1">Варіанти	
																<input type="radio" name="type_1" value="checkbox">Відмітка																
															</div>
																														
															<div class="parametrVariants" id="varPanel_1">
																<div class="parametrVariant"><input><span
			class="deleteButtonSmall"></div>
																<div class="parametrVariant"><input><span
			class="deleteButtonSmall"></div>
																<span class="addButtonSmall">			
															</div>	
																																								
														</div>
														
														</form>
	</jsp:attribute>


</template:templatepage>