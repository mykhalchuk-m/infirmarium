<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s"	uri="/struts-tags"%>
	<div> 
	<h2> <s:property value="result"/> </h2>

											
												<s:if test="hasErrors()">

		<s:if test="hasActionErrors()">
			<s:iterator value="actionErrors">
				<p style="color: #FF5A00;"><s:property /></p>
			</s:iterator>
			</s:if>
			
			<s:if test="hasFieldErrors()">
				<s:iterator value="fieldErrors">
					<s:iterator value="value">
						<p style="color: #FF5A00;"><s:property /></p>
					</s:iterator>
				</s:iterator>
			</s:if>

		</s:if>
											
											
											</div>	