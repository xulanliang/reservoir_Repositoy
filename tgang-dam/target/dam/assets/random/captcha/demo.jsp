<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath() + "/";
%>
<!DOCTYPE >
<html>
<head>
<base href="<%=basePath%>" />
<script type="text/javascript" src="assets/jquery/jquery-1.9.1.js"></script>

<script type="text/javascript">
	function refreshCode() {
		$("#RandCode").attr("src", "jf/DseRandCode/loadImage?t=" + Date.parse(new Date()));
	}
</script>
</head>
<body>
	<div class="txtCaptcha">
		<img id="RandCode" src="jf/DseRandCode/loadImage" class="RandCode" />
		<a href="javascript:void(0)" onclick="refreshCode()">换一个</a>
	</div>
</body>
</html>