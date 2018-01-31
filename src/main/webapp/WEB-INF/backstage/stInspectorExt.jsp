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
<link rel="stylesheet" href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/bootstrap/css/bootstrap.min.css">

</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<div class="content-wrapper" style="margin-left: 0px">
			<!-- Main content -->
				<!-- /.row -->
				<!-- Main row -->
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<div class="ibox-tools rboor"> 
			                        <a href="javascript:void(0)" onclick="ext()" class="btn btn-primary btn-xs p310" data-toggle="modal" >  导出EXCEL</a> 
			                    </div> 
							</div>
							<div class="box-body"
								style="border-style: solid solid none;border-color: #e7eaec;border-width: 1px 0px;">
								<table class="table">
									<caption>网上督察人员问题统计</caption>
									<thead>
										<tr>
											<th>部门名称</th>
											<th>玩手机</th>
											<th>睡觉</th>
											<th>坐姿不正</th>
											<th>单人审讯</th>
											<th>抽烟</th>
											<th>无人看管</th>
											<th>其他</th>
											<th>问题总数</th>
											<th>处理问题数</th>
											<th>处理率</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${rall_list }" var="list">
											<tr>
												<td >${list.qdepartment }</td>
												<td>${list.wsj }</td>
												<td>${list.sj }</td>
												<td>${list.zzbz }</td>
												<td>${list.drsx }</td> 
												<td>${list.cq }</td>
												<td>${list.wrkg }</td>
												<td>${list.qt }</td>
												<td>${list.isp }</td>
												<td>${list.cold }</td>
												<td>   
														<c:choose>
														   <c:when test="${list.isp!=0 }">    
														   <fmt:formatNumber type="number" value="${ list.cold div   list.isp *100}" maxFractionDigits="1"/>
														   	%
														   </c:when>
														   <c:otherwise>   
														   	0 %
														   </c:otherwise>
														</c:choose>
												</td>
											</tr> 
										</c:forEach> 
									</tbody>
								</table>
								
							</div>
							<div class="box-body"
								style="border-style: solid solid none;border-color: #e7eaec;border-width: 1px 0px;">
								<table class="table">
									<caption>网上督察视频问题统计</caption>
									<thead>
										<tr>
											<th>部门名称</th>
											<th>视频模糊</th>
											<th>级联取流失败</th>
											<th>无视频信号</th>
											<th>黑屏</th>
											<th>监控地址错误</th>
											<th>问题总数</th>
											<th>处理问题数</th>
											<th>处理率</th>
										</tr>
									</thead>  
									<tbody> 
										<c:forEach items="${sall_list }" var="list">
											<tr>
												<td  >${list.qdepartment }</td>
												<td>${list.spmh }</td>
												<td>${list.jlsb }</td>
												<td>${list.wsp }</td>
												<td>${list.hp }</td>
												<td>${list.ddcw }</td>
												<td>${list.isp }</td>
												<td>${list.cold }</td>
												<td>
														<c:choose>
														   <c:when test="${list.isp!=0 }">    
														   <fmt:formatNumber type="number" value="${ list.cold div   list.isp*100}" maxFractionDigits="1"/>
														   %
														   </c:when>
														   <c:otherwise>   
														   	0%
														   </c:otherwise>
														</c:choose>
												</td>
											</tr> 
										</c:forEach> 
									</tbody>
								</table> 
								
							</div>
						</div>
					</div>
				</div>
		</div>
	</div>
</body>
</html>
