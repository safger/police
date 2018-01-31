<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
<link rel="stylesheet"
	href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/iCheck/all.css">
<script type="text/javascript"
	src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
	
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<jsp:include page="../system/head.jsp" />
		<!-- Left side column. contains the logo and sidebar -->
		<c:import url="/system/menuData.html"></c:import>
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					廉政防疫 <small>管理系统</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
					<li class="active">控制台</li>
				</ol>
			</section>
			<!-- Main content -->
			<section class="content">
				<div class="box box-default collapsed-box">
					<div class="box-header with-border">
						<h3 class="box-title">高级条件</h3>
						<div class="box-tools pull-right">
							<button type="button" class="btn btn-box-tool"
								data-widget="collapse">
								<i class="fa fa-plus"></i>
							</button>
						</div>
					</div>
					<div class="box-body">
						<div class="row">
							<div class="comment-text"
								style="margin: 5px 20px;font-weight: bolder;font-size: 12px">
								<span class="username"> 自定义时间区间查询 </span>
							</div>
							<div class="col-xs-2">
								<input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
									value="<fmt:formatDate value="${stime}" pattern="yyyy-MM-dd"/>"
									class="form-control" id="stime" placeholder="请选择开始时间">
							</div>
							<div class="col-xs-2">
								<input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})"
									value="<fmt:formatDate value="${etime}" pattern="yyyy-MM-dd"/>"
									class="form-control" id="etime" placeholder="请选择结束时间">
							</div>
							<button type="button" onclick="search('zdy')"
								style="float: left!important;" class="btn btn-info pull-right">查询</button>
						</div>
						<div class="row" style="margin-top: 10px">
							<div class="comment-text"
								style="margin: 5px 20px;font-weight: bolder;font-size: 12px">
								<span class="username"> 快捷查询 </span>
							</div>
							<div class="col-xs-2">
								<button type="button" onclick="search('thisMonth')"
									class="btn btn-block btn-default btn-sm">本月</button>
							</div>
							<div class="col-xs-2">
								<button type="button" onclick="search('lastMonth')"
									class="btn btn-block btn-default btn-sm">上一月</button>
							</div>
							<div class="col-xs-2">
								<button type="button" onclick="search('threeMonth')"
									class="btn btn-block btn-default btn-sm">近三个月</button>
							</div>
							<div class="col-xs-2">
								<button type="button" onclick="search('year')"
									class="btn btn-block btn-default btn-sm">今年</button>
							</div>
						</div>
					</div>
				</div>
				</form>
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
				<!-- /.row (main row) -->
			</section>

			<!-- right col -->
		</div>
		</section>
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->
	<jsp:include page="../system/foot.jsp" />
	<!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
	<div class="control-sidebar-bg"></div>

	<!-- modal -->




	</div>
	<!-- ./wrapper -->
	<script
		src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/iCheck/icheck.min.js"></script>
	<script src="<%=basePath%>js/echarts-2.2.7/build/dist/echarts.js"></script>
	<script type="text/javascript">
		$(function() {
			 

		});
		function search(type){
			  if(type=='zdy'){
				  var stime=$("#stime").val();
				  var etime=$("#etime").val();
				  window.location.href="<%=basePath%>backstage/statistics/stInspector.html?stime="+stime+"&etime="+etime+"&type="+type;
			  }else{
				  window.location.href="<%=basePath%>backstage/statistics/stInspector.html?type="+type;
			  } 
		  }
		function ext(){
			var hr=window.location.href; 
			if(hr.indexOf("?") != -1){
				window.location.href=window.location.href+"&ext=ext"
			}else{
				window.location.href=window.location.href+"?ext=ext"
			}
			
		}
	</script>
</body>
</html>
