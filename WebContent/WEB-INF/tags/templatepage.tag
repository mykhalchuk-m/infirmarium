
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">

<%@ tag display-name="templatePage"%>
<%@ taglib prefix="s"	uri="/struts-tags"%>
<%@ attribute name="head" fragment="true"%>
<%@ attribute name="urlTab1"  fragment="true" %>
<%@ attribute name="logo"  fragment="true" %>
<%@ attribute name="urlTab2"  fragment="true"%>
<%@ attribute	name="title" required="true"%>
<%@ attribute name="description"%>
<%@ attribute	name="keywords"%>


<html>
<head>
	
	<title>
		${title}
	</title>
		<link rel="stylesheet" type="text/css" href="../css/generic.css" />
		<link rel="stylesheet" type="text/css" href="../css/common.css" />
		<link type="text/css" href="../css/left_buttons.css"	rel="Stylesheet" />	
    	<link rel="stylesheet" type="text/css" href="../css/navbuttons.css" />
		<link type="text/css" href="../js/jquery/theme/ui.all.css"	rel="Stylesheet" />
		<link type="text/css" href="../css/select_window.css"	rel="Stylesheet" />
		<link type="text/css" href="../css/module_building.css"	rel="Stylesheet" />
		<link type="text/css" href="../css/ui.datepicker.css""	rel="Stylesheet" />
			<link type="text/css" href="../css/validation.css""	rel="Stylesheet" />
		<script type="text/javascript" src="../js/jquery/jquery-1.3.2.min.js"></script>

		<script type="text/javascript"
			src="../js/jquery/jquery-ui-1.7.custom.min.js"></script>
		<script type="text/javascript" src="../js/interface.js"></script>
		<script type="text/javascript" src="../js/select_window.js"></script>
		
			
<script type="text/javascript">

	$(document)
			.ready( function() {
				$('tr:odd').addClass('odd');
				$('tr:even').addClass('even');
				
				});

	$( function() {
		$('#tabs').tabs( {
			fx : [ null, {
				height :'show',
				opacity :'show'
			} ]
		});

		$(".ui-tabs .ui-tabs-nav li a").mouseover( function() {
			$(this).animate( {
				opacity :"0.6"
			}, "fast");
		});
		$(".ui-tabs .ui-tabs-nav li a").mouseout( function() {
			$(this).animate( {
				opacity :"1"
			}, "fast");
		});

	});
</script>

<jsp:invoke fragment="head"/>
	
</head>
<body>

		<div class="main">
			<div class="infoPanel">
				<div class="infoPanelb">
					<div class="infoPanelt">
						<div class="infoPanell">
							<div class="infoPanelr">
								<div class="infoPanelbr">
									<div class="infoPaneltl">
										<div class="infoPanelContent">
											<jsp:invoke fragment='logo'/>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="topPanel">
				<span><s:property value="#session['ENTERED_HEALTH_WORKER'].firstName"/>&nbsp;
					<s:property value="#session['ENTERED_HEALTH_WORKER'].lastName"/>&nbsp; 
					<s:a href="/infirmarium/common/Logout.action" title="вилогінитися">вийти</s:a>
				</span>
				<div class="navButtonCenter">
					<a href='<s:url action="card"/>'><div class="navButton"><div class="navCard"></div></div></a>
					<a href='<s:url action="patient"/>'><div class="navButton" ><div class="navPatient"></div></div></a>
					<a href='<s:url action="hw"/>'><div class="navButton"><div class="navDoctor"></div></div></a>
					<a href='<s:url action="department"/>'><div class="navButton"><div class="navDep"></div></div></a>
					<a href='<s:url action="module"/>'><div class="navButton"><div class="navModule"></div></div></a>
					<a href='<s:url action="analysis"/>'><div class="navButton"><div class="navAnlysis"></div></div></a>
				</div>
			</div>

			<div class="tabsPanel">
				<div class="tabsPanelTop">

					<div id="tabs">

						<ul class="tabsPanelMiddle">
							<li>
								<a href="<%=application.getContextPath()%><jsp:invoke fragment='urlTab1'/>"><span class="recordButtonIcoMain"></span>
								</a>
							</li>
							<li>
								<a href="<%=application.getContextPath()%><jsp:invoke fragment='urlTab2'/>"><span class="recordButtonIcoAdd"></span>
								</a>
							</li>
						</ul>

						<div id="tabs-1">

						</div>
						<div id="tabs-2">
			
						</div>
						
					</div>
				</div>

			</div>
		</div>
		<div id="windowShade"></div>


</body>
</html>