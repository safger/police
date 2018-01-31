<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>廉政防疫 | 管理系统</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="stylesheet"
	href="<%=basePath%>js/jsTree/themes/default/style.min.css" />

<style type="text/css">
.panel {
	display: inline-block;
	width: 35%;
	vertical-align: top;
}

.panel.pa {
	display: inline-block;
	width: 60%;
	margin-left: 2%;
}

.panel-title {
	display: inline-block;
}

.ibox-tools {
	display: inline-block;
	float: right;
	margin-top: 0;
	position: relative;
	padding: 0;
}

.ibox-tools a {
	cursor: pointer;
	margin-left: 5px;
}

.btn-primary {
	background-color: #1ab394;
	border-color: #1ab394;
	color: #FFFFFF;
}
</style>

</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<jsp:include page="head.jsp" />
		<c:import url="/system/menuData.html"></c:import>
		<div class="content-wrapper">
					<!-- Content Header (Page header) -->

					<!-- Main content -->
					<section class="content">

						<div class="error-page">
							<!-- <h2 class="headline text-red">500</h2>
 -->
							<div class="error-content" style="margin-left: 0px;margin-top: 100px">
								<c:if test="${type=='dj' }">
									<h4>
										<i class="fa fa-warning "></i> 未完成数据对接
									</h4>
									<p>
										因部门无法提供接口，故尚未完成对接
									</p>
								</c:if>
								<c:if test="${type=='2' }">
									<h4>
										<i class="fa fa-warning "></i> 本功能属二期功能
									</h4>
									<p> 
										此功能为二期功能，等待二期开发完成。
									</p>
								</c:if>
							</div>
						</div>
						<!-- /.error-page -->

					</section>
					<!-- /.content -->
				</div>
		<!-- /.content-wrapper -->
		<jsp:include page="foot.jsp" />
	</div>

	<!-- ./wrapper -->

	<script type="text/javascript">
		 
	
	</script>
</body>
</html>
