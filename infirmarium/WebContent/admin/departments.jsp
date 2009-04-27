<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="template"%>
<%@ taglib prefix="s"	uri="/struts-tags"%>
<script type="text/javascript">
	function sendDataToAction(){
	

			$("div.result").load("<%=application.getContextPath()%>/admin/AddDepartment.action",
			{
    			name: document.getElementById("departmentName").value
    					});
		
			return false;
			
	}

</script>
<template:templatepage title="Відділи">



	<jsp:attribute name="listBox">
	
															<h3>
															Відділи
														</h3>
														Filter <input> </input>
														
		
		<table>
															<thead>
																<tr>
																	<td>
																		ID
																	</td>
																	<td>
																		Відділи
																	</td>
																	<td>
																		опції
																	</td>																
																</tr>
															</thead>
							
							<s:iterator value="departments" id="department">									
							<tr>
								<td><s:property value="#department.id"/></td>
								<td><s:property value="#department.name"/></td>
								<td><div class="modifyIcon"> </div>	<div class="deleteIcon"> </div></td>
							</tr>
							</s:iterator>						
															
																													
														</table>
		
		
	</jsp:attribute>

	<jsp:attribute name="addBox">
																<h3>
															New department
														</h3>
													<s:form method="post" onsubmit="return sendDataToAction();">
														

															<div class="newPanel">
																<div class="newParam">Назва відділу</div>
																<div class="newValue">
																<input type="text" name="departmentName" id="departmentName"/></div>
																
																<div class="newParam"></div>
																<div class="newValue">
																<input type="submit" value="Додати відділ"  /> 					
																</div>
															
															</div>
															<div class="result" style="text-align: center;"></div>
													</s:form>
		
	</jsp:attribute>


</template:templatepage>
