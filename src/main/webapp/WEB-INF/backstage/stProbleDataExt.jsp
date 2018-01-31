<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	   response.setContentType("application/vnd.ms-excel");
	   String attr="attachment;filename="+new Date().getTime()+".xls"; 
	   	response.addHeader("Content-Disposition", attr);     
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>廉政防疫 |管理系统</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport"> 
<link rel="stylesheet"
	href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/datatables/dataTables.bootstrap.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<div class="content-wrapper">
			 
				<!-- /.row -->
				<!-- Main row -->
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-body"
								style="border-style: solid solid none;border-color: #e7eaec;border-width: 1px 0px;">
								<table class="table">
									<caption>第一种形态实施办法统计</caption>
									<thead>
										<tr>
											<th>部门名称</th>
											<th>值班备勤</th>
											<th>接警处警</th>
											<th>执法办案</th>
											<th>警用装备和警用车辆管理</th>
											<th>日常内部管理</th>
											<th>保密与信息安全管理</th>
											<th>监管执法管理</th>
											<th>办案功能区管理</th>
											<th>窗口接待</th>
											<th>其他</th>
											<th>附则</th>
											<th>合计</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${all_list }" var="list">
											<tr>
												<td >${list.department }</td> 
												<td>${list.code1 }</td>
												<td>${list.code2 }</td>
												<td>${list.code3 }</td>
												<td>${list.code4 }</td>
												<td>${list.code5 }</td>
												<td>${list.code6 }</td>
												<td>${list.code7 }</td>
												<td>${list.code8 }</td>
												<td>${list.code9 }</td>
												<td>${list.code10 }</td>
												<td>${list.code11 }</td>
												 <td style="font-weight: bold;">${list.code10+list.code1+list.code2+list.code3+list.code4+list.code5+list.code6+list.code7+list.code8+list.code9+list.code11 }</td>
											</tr> 
										</c:forEach> 
									</tbody>
								</table>
								
							</div>
						</div>
					</div>
				</div>
				<!-- /.row (main row) -->
			</section>

			<!-- right col -->
		</div>
		</section>
		<!-- /.content -->
	</div>
	<!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
	<div class="control-sidebar-bg"></div>

	<!-- modal -->




	</div>
	 
</body>
</html>
