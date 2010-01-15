<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template"%>

<template:templatepage title="Аналізи">



	<jsp:attribute name="listBox">
	<h3>
															Analysis
														</h3>
														Filter <input>
														
		<table>
															<thead>
																<tr>
																	<td>
																		ID
																	</td>
																	<td>
																		Analys
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
																	Blood
																</td>
																<td>
				<div class="modifyIcon"> </div>
				<div class="deleteIcon"> </div></td>
														</tr>
															<tr>
																<td>0002</td>
																<td>Urine</td>
															    <td>
				<div class="modifyIcon"> </div>
				<div class="deleteIcon"> </div></td>
													
															</tr>
															<tr>
																<td>0003</td>
																<td>Brain autopsy</td>
																<td>
				<div class="modifyIcon"> </div>
				<div class="deleteIcon"> </div></td>
													
															</tr>
																													
														</table>
		
	</jsp:attribute>

	<jsp:attribute name="addBox">
															<h3>
															New analys
														</h3>
														<form>
														<div class="newPanel">
															
															<div class="newParam">Under</div>
															<div class="newValue">construction
															</div>															
															</div>
															</form>
		</jsp:attribute>


</template:templatepage>
