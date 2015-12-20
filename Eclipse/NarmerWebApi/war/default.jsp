<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.ardevcenter.lnbexplorer.rest.*" %>    
    
    
    
 <%
 
 String date = request.getParameter("date");
 Draws d = new Draws();
 String jsonResp = "";
 
if (date != null)
	jsonResp = d.getDraws(date);
%>   
    
    
<!DOCTYPE html>
<html>

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Multi-page template</title>
<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.3/jquery.mobile-1.4.3.min.css" />
<!-- <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>-->

<script src="//ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.3/jquery.mobile-1.4.3.min.js"></script>
<script type="text/javascript">
	var draw = <%=jsonResp%>;
	$( document ).ready(function() {
		$("#p1Value").text(draw.firstNumber);
		$("#p2Value").text(draw.secondNumber);
		$("#p3Value").text(draw.thirdNumber);
		});

</script>
</head>

<body>

<div data-role="page">

	<div data-role="header">
		<h1><%=date%></h1>
	</div><!-- /header -->

	<div role="main" class="ui-content">
		
	<div class="ui-grid-a">
    	<div class="ui-block-a">P1</div>
    	<div class="ui-block-b" id="p1Value"></div>
    	
    	<div class="ui-block-a">P2</div>
    	<div class="ui-block-b" id="p2Value"></div>
    	
    	<div class="ui-block-a">P3</div>
    	<div class="ui-block-b" id="p3Value"></div>
	</div>
	
	
		<div  class="ui-grid-a center">
    <div class="ui-block-a">
    	<a href="index.html" class="ui-btn ui-shadow ui-corner-all ui-icon-arrow-l ui-btn-icon-left">Anterior</a>
	</div>
    <div class="ui-block-b">
		<a href="index.html" class="ui-btn ui-shadow ui-corner-all ui-icon-arrow-r ui-btn-icon-right">Siguiente</a>
	</div>
	</div>
	<!-- 
	<div class="ui-grid-b center">
    <div class="ui-block-a"><a class="ui-shadow ui-btn ui-corner-all ui-icon-home ui-btn-icon-notext ui-btn-inline">Button</a></div>
    <div class="ui-block-b"><a class="ui-shadow ui-btn ui-corner-all ui-icon-arrow-l ui-btn-icon-notext ui-btn-inline">Button</a></div>
    <div class="ui-block-c"><a class="ui-shadow ui-btn ui-corner-all ui-icon-grid ui-btn-icon-notext ui-btn-inline">Button</a></div>

</div>
	

	<div data-role="footer">
		<h4><%=jsonResp%></h4>
	</div>!-- /footer --
	 -->

</div><!-- /page -->

</body>
</html>
