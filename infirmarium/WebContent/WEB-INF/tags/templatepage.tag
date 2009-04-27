
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">

<%@ tag display-name="templatePage"%>
<%@ taglib prefix="s"	uri="/struts-tags"%>
<%@ attribute name="head" fragment="true"%>
<%@ attribute name="listBox" fragment="true"%>
<%@ attribute name="addBox" fragment="true"%>
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
		<link rel="stylesheet" type="text/css" href="../css/hworker.css" />
		<link type="text/css" href="../css/left_buttons.css"	rel="Stylesheet" />	
    	<link rel="stylesheet" type="text/css" href="../css/navbuttons.css" />
		<link type="text/css" href="../js/jquery/theme/ui.all.css"	rel="Stylesheet" />
		<link type="text/css" href="../css/select_window.css"	rel="Stylesheet" />
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

		$(".navButton").click( function() {
			//$(this).effect("highlight", {}, 1000);
				$(this).effect("pulsate", {
					times :0
				}, 200);
			});

		$(".ui-tabs .ui-tabs-nav li a").mouseover( function() {
			$(this).animate( {
				opacity :"1"
			}, {
				duration :0
			}).animate( {
				opacity :"0.6"
			}, "slow");
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

											<img src="../images/logo_large.gif" alt="Logo">
								</div>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>

			<div class="topPanel">
				<div class="navButtonCenter">
					<a href="cards.jsp"><div class="navButton"><div class="navCard"></div></div></a>
					<a href="patients.jsp"><div class="navButton" ><div class="navPatient"></div></div></a>
					<a href='<s:url action="ViewHW"/>'><div class="navButton"><div class="navDoctor"></div></div></a>
					<a href="analysis.jsp"><div class="navButton"><div class="navAnlysis"></div></div></a>
					<a href='<s:url action="ViewDepartments"/>'><div class="navButton"><div class="navDep"></div></div></a>
					<a href="modules.jsp"><div class="navButton"><div class="navModule"></div></div></a>
				</div>
			</div>

			<div class="tabsPanel">
				<div class="tabsPanelTop">

					<div id="tabs">

						<ul class="tabsPanelMiddle">
							<li>
								<a href="#tabs-1"><span class="recordButtonIcoMain"></span>
								</a>
							</li>
							<li>
								<a href="#tabs-2"><span class="recordButtonIcoAdd"></span>
								</a>
							</li>
						</ul>

						<div id="tabs-1">
							<div class="contentb">
								<div class="contentt">
									<div class="contentl">
										<div class="contentr">
											<div class="contentbr">
												<div class="contenttl">
													<div class="contentContent">
														
														<jsp:invoke fragment="listBox"/>
														
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div id="tabs-2">
							<div class="contentb">
								<div class="contentt">
									<div class="contentl">
										<div class="contentr">
											<div class="contentbr">
												<div class="contenttl">
													<div class="contentContent">
														
														<jsp:invoke fragment="addBox"/>
														
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						
					</div>
				</div>

			</div>
		</div>
		<div id="windowShade"></div>


</body>
</html>