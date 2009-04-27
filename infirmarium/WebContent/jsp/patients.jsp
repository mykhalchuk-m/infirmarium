<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template"%>

<template:templatepage title="Пацієнти">



	<jsp:attribute name="listBox">
	<h3>
															Patients
														</h3>
														This section represents all patients
														<table>
															<thead>
																<tr>
																	<td>
																		ID
																	</td>
																	<td>
																		Name
																	</td>
																	<td>
																		Birth date
																	</td>
																	<td>
																		Address
																	</td>
																	<td>
																		Gender
																	</td>
																	<td>
																		Blood
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
																	Jhon Doe
																</td>
																<td>19.12.76</td>
																<td>New-York 13th street/24</td>
																<td>m</td>
																<td>I+</td>
																<td>
				<div class="modifyIcon"> </div>
				<div class="deleteIcon"> </div></td>
															</tr>
															<tr>
																<td>0002</td>
																<td>Anna Hill</td>
																<td>13.05.63</td>																
																<td>
																	Washigton 45th street/17
																</td>
																<td>f</td>
																<td>II+</td>
																<td>
				<div class="modifyIcon"> </div>
				<div class="deleteIcon"> </div></td>
															</tr>
															<tr>
																<td>0003</td>
																<td>Jhon Richardson</td>
																<td>06.02.98</td>		
																<td>
																	Washigton 45th street/18
																</td>
																<td>m</td>
																<td>II+</td>
																<td>
				<div class="modifyIcon"> </div>
				<div class="deleteIcon"> </div></td>
															</tr>
															<tr>
																<td>0004</td>
																<td>Bred Ferguison</td>
																<td>12.23.49</td>	
																<td>
																	Filadelphia 49th street/20
																</td>
																<td>m</td>
																<td>I-</td>
																<td>
				<div class="modifyIcon"> </div>
				<div class="deleteIcon"> </div></td>
															</tr>
															<tr>
																<td>0005</td>
																<td>James Bond</td>
																<<td>06.02.88</td>	
																<td>
																	Georgia Linkoln st./89
																</td>
																<td>m</td>
																<td>IV+</td>
																<td>
				<div class="modifyIcon"> </div>
				<div class="deleteIcon"> </div></td>
															</tr>														
														</table>
	</jsp:attribute>

	<jsp:attribute name="addBox">
													
																<h3>
															New health worker
														</h3>
														<form>
														<div class="newPanel">
															<div class="newParam">Name</div>
															<div class="newValue"><input></div>
															<div class="newParam">Middle name</div>
															<div class="newValue"><input></div>
															<div class="newParam">Last name</div>
															<div class="newValue"><input></div>
															<div class="newParam">Birth date</div>
															<div class="newValue"><input></div>
															<div class="newParam">Address</div>
															<div class="newValue"><input></div>
															<div class="newParam">Gender</div>
															<div class="newValue"><select>
																						<option value="Male">
																						Male
																						</option>
																						<option value="Female">
																						Female
																						</option>																																		
																						</select></div>
															<div class="newParam">Blood</div>
															<div class="newValue"><select>
																						<option value="I+">
																						I+
																						</option>
																						<option value="I-">
																						I-
																						</option>
																						<option value="II+">
																						II+
																						</option>
																						<option value="II-">
																						II-
																						</option>
																						<option value="III+">
																						III+
																						</option>
																						<option value="III-">
																						III-
																						</option>
																						<option value="IV+">
																						IV+
																						</option>
																						<option value="IV-">
																						IV-
																						</option>																																	
																						</select></div>
															<div class="newParam">&nbsp;</div>
															<div class="newValue">
		<button>add</button></div>
															</div>
															</form>
	</jsp:attribute>


</template:templatepage>
