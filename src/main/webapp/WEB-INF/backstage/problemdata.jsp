
<%@ page import="java.util.*" contentType="text/html;charset=UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>廉政防疫 | 管理系统</title>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="stylesheet"
	href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/datatables/dataTables.bootstrap.css">
<link rel="stylesheet"
	href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/iCheck/all.css">
<link rel="stylesheet"
	href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/jQueryUI/jquery-ui.min.css">
<link rel="stylesheet"
	href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/select2/select2.min.css">
<script type="text/javascript"
	src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>

<style>
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

.ui-widget {
	z-index: 1051;
}

.head-find {
	padding: 0 20px;
}

.head-find .row {
	margin-bottom: 15px;
}

.head-find .form-new-input {
	position: relative;
	font-family: "Microsoft YaHei";
}

.head-find .form-new-input span { /*position: absolute;*/
	width: 77px;
	height: 32px;
	background: #ecf0f5;
	font-size: 14px;
	color: #000;
	line-height: 32px; /* left: 1px; top: 1px; */
	padding-left: 5px;
	float: left;
	border: 1px solid #d2d6de;
	border-right: none;
}

.head-find .form-new-input .fis {
	float: left;
	width: 110px;
	border: 1px solid #d2d6de;
	font-size: 14px;
	color: #000;
	height: 32px;
	line-height: 30px;
	padding-left: 5px;
	padding-right: 5px;
	padding-top: 0;
	padding-bottom: 0;
}

.head-find .form-new-input.form-new-input-date .fis {
	width: 110px;
}

.head-find .form-new-input.form-new-input-date b {
	display: block;
	float: left;
	padding: 0 5px;
	height: 32px;
	line-height: 32px;
}

.head-find .form-new-input-date .fis.fis2 {
	padding-left: 5px;
	width: 110px;
}
</style>

<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	margin: 0;
}

#main {
	height: 1800px;
	padding-top: 90px;
	text-align: center;
}

#fullbg {
	background-color: gray;
	left: 0;
	opacity: 0.5;
	position: absolute;
	top: 0;
	z-index: 3;
	filter: alpha(opacity = 50);
	-moz-opacity: 0.5;
	-khtml-opacity: 0.5;
}

#dialog {
	background-color: #fff;
	border: 5px solid rgba(0, 0, 0, 0.4);
	height: 400px;
	left: 50%;
	margin: -200px 0 0 -200px;
	padding: 1px;
	position: fixed !important; /* 浮动对话框 */
	position: absolute;
	top: 50%;
	width: 400px;
	z-index: 5;
	border-radius: 5px;
	display: none;
}

#dialog p {
	margin: 0 0 12px;
	height: 24px;
	line-height: 24px;
	background: #CCCCCC;
}

#dialog p.close {
	text-align: right;
	padding-right: 10px;
}

#dialog p.close a {
	color: #fff;
	text-decoration: none;
}
</style>
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<jsp:include page="../system/head.jsp" />
		<c:import url="/system/menuData.html"></c:import>
		<div class="content-wrapper">
			<section class="content-header">
				<h1>
					警员记分 <small>管理</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="<%=basePath%>backstage/index.html"><i
							class="fa fa-dashboard"></i> 首页</a></li>
					<li><a href="<%=basePath%>backstage/problemdata/show.html">管理</a></li>
					<li class="active">列表</li>
				</ol>
			</section>

			<!-- content -->
			<section class="content">
				<c:if test="${dc=='dc' }">
				<div class="box box-default collapsed-box">
					<div class="box-header with-border">
						<h3 class="box-title">高级搜索</h3>
						<div class="box-tools pull-right">
							<button type="button" class="btn btn-box-tool"
								data-widget="collapse">
								<i class="fa fa-plus"></i>
							</button>
						</div>
					</div>
					<div class="box-body">
							<div class="head-find">
								<div class="row">
									<div class="col-xs-3">
										<div class="form-new-input">
											<span>文件号：</span> <input type="text" id="wjh" class="fis">
										</div>
									</div>
									
									<div class="col-xs-3">
										<div class="form-new-input">
											<span class="sp">部门类型：</span>
											 <select class="form-control" style="width:120px;" name="sdtype">
													<option value="2">所有部门</option>
													<option value="1">职能部门</option>
													<option value="0">普通部门</option>
													</select>
										</div>
									</div>
									<div class="col-xs-6">
										<div class="form-new-input">
											<span class="sp" style="display: block;float: left;">违规条款：</span>
												<select class="fis"  
													name="bjbm"><option value="-1">请选择</option>
													<option value="001001">第一节 值班备勤</option>
													<option value="001002">第二节 接警处警</option>
													<option value="001003">第三节 执法办案</option>
													<option value="001004">第四节 警用装备和警用车辆管理</option>
													<option value="001005">第五节 日常内部管理</option>
													<option value="001006">第六节 保密与信息安全管理</option>
													<option value="001007">第七节 监管执法管理</option>
													<option value="001008">第八节 办案功能区管理</option>
													<option value="001009">第九节 窗口接待</option>
													<option value="001010">第十节 其 他</option></select>
												<div id="sse"></div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-xs-3"> 
										<div class="form-new-input">
											<span>姓名：</span> <input type="text" id="xm" class="fis">
										</div>
									</div> 
									<div class="col-xs-3">  
										<div class="form-new-input">
											<span>是否民警：</span> <select name="sispolice"
												class="fis">
												<option value="2">所有</option>
												<option value="1">是</option>
												<option value="0">不是</option>
											</select>
										</div>
									</div>
									<div class="col-xs-6">
										<div class="form-new-input">
											<span class="sp" style="display: block;float: left;">被记部门： </span> 
											<select id="sodepartment" class="form-control select2" style="width: 150px;float: left;"> 
												<option value="-1">请选择</option>
												<c:forEach var="list" items="${oragenizeAll }">
													<option value="${list.fuid }">${list.fullname }</option>
												</c:forEach>
											</select>
										</div>	
										<div id="sochild" style="float: left;width: 45%"></div>
										<input type="hidden" value="-1" id="sodepartmentid" name="sodepartmentid" />
										<input type="hidden" value="-1" id="csodepartmentid"  name="csodepartmentid" />
									</div>
								</div>
								<div class="row">
									<div class="col-xs-12">
										<div class="form-new-input form-new-input-date">
											<span>发生日期：</span> <input style="width: 150px" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" id="sstime" class="fis">
											<b>:</b> <input style="width: 150px" type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm'})" id="setime" class="fis fis2">
										</div>
									</div>
								</div>
								 <div class="row" 　 > 
					              <div style="width: 90%;text-align: center;">
					                 	<button type="button" style="width: 100px;display: inline;" onclick="gsearch()"  class="btn btn-block btn-primary">查询</button>
					                 </div>
					              </div>
							</div>

							<!--修改区域end-->
						</div>
					<%-- <div class="box-body">
						<div class="row">
							<div class="comment-text"
								style="margin: 5px 20px;font-weight: bolder;font-size: 12px">
								<span class="username"> </span>
							</div>
							<div class="col-xs-6">
								<span class="sp"
									style="display: block;float: left;line-height: 30px">被记分部门：
									&nbsp;&nbsp; </span> 
									<select
										id="sodepartment" class="form-control select2"
										style="width: 150px;float: left;"> 
										<option value="-1">请选择</option>
										<c:forEach var="list" items="${oragenizeAll }">
											<option value="${list.fuid }">${list.fullname }</option>
										</c:forEach>
									</select>
									<div id="sochild" style="float: left;width: 45%"></div>
									<input type="hidden" value="-1" id="sodepartmentid" name="sodepartmentid" />
									<input type="hidden" value="-1" id="csodepartmentid"  name="csodepartmentid" />
							</div>
							<div class="col-xs-4">
								<span class="sp">部门类型：</span> <input type="radio" name="sdtype"
									class="minimal" checked="checked" value="2"> 所有 <input
									type="radio" name="sdtype" class="minimal" value="1">&nbsp;
								职能部门 &nbsp; <input type="radio" name="sdtype" class="minimal"
									value="0">&nbsp;普通部门&nbsp;
							</div>

						</div>
						<div class="row" style="margin-top: 20px">
							<div class="col-xs-6">
								<span class="sp" style="display: block;float: left;">违规条款：</span>
								<select class="form-control" style="width:200px;float: left;;"
									name="bjbm"><option value="-1">请选择</option>
									<option value="001001">第一节 值班备勤</option>
									<option value="001002">第二节 接警处警</option>
									<option value="001003">第三节 执法办案</option>
									<option value="001004">第四节 警用装备和警用车辆管理</option>
									<option value="001005">第五节 日常内部管理</option>
									<option value="001006">第六节 保密与信息安全管理</option>
									<option value="001007">第七节 监管执法管理</option>
									<option value="001008">第八节 办案功能区管理</option>
									<option value="001009">第九节 窗口接待</option>
									<option value="001010">第十节 其 他</option></select>
								<div id="sse"></div>
							</div>
							<div class="col-xs-4">
								<span class="sp">是否民警：</span> <input type="radio"
									name="sispolice" class="minimal" checked="checked" value="2">
								所有 <input type="radio" name="sispolice" class="minimal"
									value="1">&nbsp; 是&nbsp; <input type="radio"
									name="sispolice" class="minimal" value="0">&nbsp;否&nbsp;
							</div>

						</div>
						<div class="row" style="margin-top: 20px">
							<div class="col-xs-6">
								<span class="sp" style="display: block;float: left;">文件号：</span>
								  <input type="text" id="wjh"  class="form-control" style="width: 200px;float: left;">
							</div>

						</div>
						<div class="row" style="margin-top: 20px">
							<div class="col-xs-6"></div>
						</div>
						<div class="row" style="margin-top: 20px">
							<div style="width: 90%;text-align: center;">
								<button type="button" style="width: 100px;display: inline;"
									onclick="gsearch()" class="btn btn-block btn-primary">查询</button>
							</div>
						</div>
					</div> --%>
				</div>
				</c:if> 	
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<h3 class="box-title">列表</h3> <span style="color: red;">当前被记总分：<span id="zf"></span></span>
								<div class="ibox-tools rboor"> 
								 <c:if test="${com.hisAdd}">  
									<a href="#" class="btn btn-primary btn-xs p310"
										data-toggle="modal" onclick="showM()" ><i
										class="fa fa-plus"></i> 新增</a>
								</c:if>		
								</div>
							</div>
							<!-- /.box-header -->
							<div class="box-body"
								style="border-style: solid solid none;border-color: #e7eaec;border-width: 1px 0px;">
								<table id="newAttributeTable"
									class="table table-bordered table-hover" style="width: 100%">
									<thead>
										<tr>
											<th></th>
											<th></th>
											<th></th>
											<th></th>
											<th></th>
											<th></th>
											<th></th>
											<th></th>
											<th></th>
											<th></th>
											<th></th>
										</tr>
									</thead>
								</table>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
		<jsp:include page="../system/foot.jsp" />
	</div>

	<!-- Modal2 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">新增</h4>
				</div>
				<form id="editForm" class="form-horizontal">
					<div class="modal-body">
						<div class="box-body">

							<div class="row" style="margin-bottom:15px">
								<div class="col-xs-6" style="padding-left: 0px">
									<span style="font-weight: 700">文书号 </span> <input type="text"
										class="form-control" name="hmd" value="${hmd }" placeholder="">
								</div>
								<div class="col-xs-6">
									<span style="font-weight: 700"> 被记分部门类型</span>
									<div style="border: 0px" class="form-control">
										<input type="radio" name="dtype" class="minimal"
											checked="checked" value="1"> 职能部门 <input type="radio"
											name="dtype" class="minimal" value="0">&nbsp; 普通部门
									</div>
								</div>

							</div>
							<div class="row" style="margin-bottom:15px">
								<div class="col-xs-6" style="padding-left: 0px">
									<span style="font-weight: 700">被记分人</span> <input type="text"
										id="name" name="name" class="form-control">
								</div>
								<div class="col-xs-3">
									<span style="font-weight: 700"> 重点督办</span>
									<div style="border: 0px" class="form-control">
										<input type="radio" name="supervision" class="minimal"
											 value="1"> 是 <input type="radio"
											name="supervision" class="minimal" checked="checked" value="0">&nbsp; 否
									</div>
								</div> 	
								<div class="col-xs-3">
									<span style="font-weight: 700"> 是否民警</span>
									<div style="border: 0px" class="form-control">
										<input type="radio" name="ispolice" class="minimal"
											checked="checked" value="1"> 是 <input type="radio"
											name="ispolice" class="minimal" value="0">&nbsp; 否
									</div>
								</div>
								

							</div>
							<div class="form-group" style="clear:both;height: 59px">
								<label for="exampleInputEmail1"
									style="clear:both;display: block;">部门 </label> 
									
								<c:choose>  
								   <c:when test="${dc=='dc' }">     
								   		<select
										id="sdepartment" class="form-control select2"
										style="width: 45%;float: left;">
										<option value="0">请选择</option>
										<c:forEach var="list" items="${oragenizeAll }">
											<option value="${list.fuid }">${list.fullname }</option>
										</c:forEach>
									</select>
									<div id="child" style="float: left;width: 45%"></div>
									<input type="hidden" value="" id="department" name="department" />
									<input type="hidden" value="" id="departmentid" name="departmentid" />
									<input type="hidden" value="" id="cdepartment" name="cdepartment" /> 
									<input type="hidden" value="" id="cdepartmentid" name="cdepartmentid" />
								   </c:when>  
								   <c:otherwise>    
								   <input type="text"   clear="no" name="cdepartment" readonly="readonly" value="${cdepartmentname }" class="form-control">
								   <input type="hidden" clear="no" name="cdepartmentid"   value="${cdepartmentid }" >
								   <input type="hidden"  clear="no" value="${ departmentname}" name="department"   /> 
									<input type="hidden"  clear="no" value="${ departmentid}" name="departmentid"   />
								   </c:otherwise>  
								</c:choose> 
								
							</div>


							<div class="form-group">
								<label for="exampleInputEmail1">发生时间 </label> <input
									name="orrurdate"
									onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:true})"
									type="text" class="form-control" readonly="readonly"
									placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">违规章节 </label>
								<div id="_select"></div>
							</div>

							<div class="form-group">
								<label for="exampleInputEmail1">条款 </label>
								<div id="te" name="te">
									<select id="terms" name="terms" class="form-control">
									</select>
								</div>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">记分 </label> <input type="text"
									class="form-control" 　 id="score" name="score" placeholder="">
							</div>
							<div class="row" style="margin-bottom:15px">
								<div class="col-xs-6" style="padding-left: 0px">
									<span style="font-weight: 700">记分人姓名 </span> <input type="text"
										name="scoringper" class="form-control">
								</div>
								<div class="col-xs-6" style="padding-left: 0px">
									<span style="font-weight: 700">记分部门 </span> <input type="text"
										name="jdepartment" class="form-control">
								</div>

							</div>
							<!-- <div class="form-group">
								<label for="exampleInputEmail1">记分人姓名 </label> <input type="text" class="form-control"   name="scoringper" placeholder="">
							</div> -->
							<div class="form-group">
								<label for="exampleInputEmail1">备注 </label>
								<textarea rows="3" cols="4" class="form-control" id="remarks"
									name="remarks" placeholder="请填写记分人意见、部门负责人意见、领导意见等"></textarea>
							</div>
							<input type="hidden" id="fuid" name="fuid">
						</div>
					</div>
				</form>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" id="save">保存</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Modal2 -->


	<!-- Modal detail -->
	<div class="modal fade" id="Modal_detail" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<div class="box-header with-border" style="border-bottom:0px">
						<button type="button" class="close" style="z-index: 1000"
							data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<i class="fa fa-tv"></i>
						<h3 class="box-title">详情</h3>
					</div>
				</div>
				<div class="modal-body">
					<div class="panel-body" style="padding: 0px;font-size: 12px">
						<dl class="dl-horizontal">
							<dt>文件号</dt>
							<dd id="d_hmd"></dd>
							<dt>被记分人</dt>
							<dd id="d_name"></dd>
							<dt>是否民警</dt>
							<dd id="d_ispolice"></dd>
							<dt>被记分部门</dt>
							<dd id="d_department"></dd>
							<dt>被记分部门类型</dt>
							<dd id="d_dtype"></dd>
							<dt>发生日期</dt>
							<dd id="d_orrurdate"></dd>
							<dt>违法章节</dt>
							<dd id="d_chapter"></dd>
							<dt>条款</dt>
							<dd id="d_terms"></dd>
							<dt>分值</dt>
							<dd id="d_score"></dd>
							<dt>记分人员</dt>
							<dd id="d_scoringper"></dd>
							<dt>记分部门</dt>
							<dd id="d_jdepartment"></dd>
							<dt>备注</dt>
							<dd id="d_remarks"></dd>
							<!-- <dt>记分人意见</dt>
							<dd id="d_jopinion"></dd>
							<dt>部门负责人意见</dt>
							<dd id="d_bopinion"></dd>
							<dt>分局领导意见</dt>
							<dd id="d_fopinion"></dd>
							<dt>局长意见</dt>
							<dd id="d_zopinion"></dd> -->
							<dt>创建时间</dt>
							<dd id="d_createdate"></dd>
							<dt>处理部门</dt>
							<dd id="d_zfdepartment"></dd>
							<dt>指派部门</dt>
							<dd id="d_zhcdepartment"></dd>
							<dt>指派人</dt>
							<dd id="d_commander"></dd>
							<dt>指派说明</dt>
							<dd id="d_zdescription"></dd>
							<dt>处理结果</dt>
							<dd id="d_process"></dd>
						</dl>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="zfprocess" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">转派处理</h4>
				</div>
				<form id="proform" method="post">
					<div class="modal-body">
						<div class="box-body">
							<div class="form-group" style="clear:both;height: 59px">
								<label for="exampleInputEmail1"
									style="clear:both;display: block;">处理部门 </label> <select
									id="zpdepartment" class="form-control select2"
									style="width: 45%;float: left;">
									<option value="0">请选择</option>
									<c:forEach var="list" items="${oragenizeAll }">
										<option value="${list.fuid }">${list.fullname }</option>
									</c:forEach>
								</select>
								<div id="zfchild" style="float: left;width: 45%"></div>
								<input type="hidden" value="" id="cfuid" name="fuid" /> <input
									type="hidden" value="" id="zfdepartment" name="zfdepartment" />
								<input type="hidden" value="" id="zfdepartmentid"
									name="zfdepartmentid" /> <input type="hidden" value=""
									id="zfcdepartment" name="zfcdepartment" /> <input
									type="hidden" value="" id="zfcdepartmentid"
									name="zfcdepartmentid" />
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">指派人 </label> <input type="text"
									class="form-control" name="commander" placeholder="">
							</div>
							<div class="form-group" style="clear:both;height: 59px">
								<label for="exampleInputEmail1"
									style="clear:both;display: block;">指派部门 </label> <select
									id="zhdepartment" class="form-control select2"
									style="width: 45%;float: left;">
									<option value="0">请选择</option>
									<c:forEach var="list" items="${oragenizeAll }">
										<option value="${list.fuid }">${list.fullname }</option>
									</c:forEach>
								</select>
								<div id="zhchild" style="float: left;width: 45%"></div>
								<input type="hidden" value="" id="zhdepartment"
									name="zhdepartment" /> <input type="hidden" value=""
									id="zhdepartmentid" name="zhdepartmentid" /> <input
									type="hidden" value="" id="zhcdepartment" name="zhcdepartment" />
								<input type="hidden" value="" id="zhcdepartmentid"
									name="zhcdepartmentid" />

							</div>
							<div class="form-group" style="clear: both;margin-top: 15px">
								<label for="exampleInputEmail1">指派说明</label>
								<textarea rows="3" cols="4" class="form-control"
									name="zdescription"></textarea>
							</div>
							<!--  <div class="form-group" style="clear: both;margin-top: 15px">
								<label for="exampleInputEmail1">处理情况</label>
				 				<textarea rows="3" cols="4" class="form-control" id="process" name="process" ></textarea>
							</div> -->
						</div>
					</div>
				</form>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" onclick="updateZf()" class="btn btn-primary">保存</button>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="dealwith" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">处理</h4>
				</div>
				<form id="zhform" method="post">
					<div class="modal-body">
						<div class="box-body">
							<div class="form-group">
								<label for="exampleInputEmail1">指派人 </label> <input type="text"
									class="form-control" disabled="disabled" id="zpf"
									placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">指派部门</label> <input type="text"
									class="form-control" disabled="disabled" id="zpbm"
									placeholder="">
							</div>

							<div class="form-group" style="clear: both;margin-top: 15px">
								<label for="exampleInputEmail1">指派说明</label>
								<textarea rows="3" cols="4" disabled="disabled"
									class="form-control" id="zpsm"></textarea>
							</div>
							<div class="form-group" style="clear: both;margin-top: 15px">
								<label for="exampleInputEmail1">处理结果</label> <input
									type="hidden" value="" id="clfuid" name="fuid" />
								<textarea rows="3" cols="4" class="form-control" id="process"
									name="process"></textarea>
							</div>
						</div>
					</div>
				</form>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" onclick="ZHCL()" class="btn btn-primary">保存</button>
				</div>
			</div>
		</div>
	</div>


	<div id="fullbg"></div>
	<div id="dialog" style="z-index: 1000">
		<div style="text-align: center;">
			<h3 style="font-weight: bold;">温馨提醒</h3>
			<div class="box-body" id="cco" style="margin: 0 20px;text-align: left;">
				您的部门已经连续三个月未对本部门民警进行记分。 根据第一种形态记分条例，应对本部门主要负责人记3分 。
			</div>
			<button type="button" onclick="closeBg()"
				style="width: 120px;margin: 0 auto;margin-bottom: 10px"
				class="btn btn-block btn-primary btn-xs">关闭</button>
		</div>

	</div>
	<!-- Modal detail -->

	<!-- DataTable插件 -->
	<script
		src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/datatables/jquery.dataTables.min.js"></script>
	<script
		src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/datatables/dataTables.bootstrap.min.js"></script>
	<!-- iCheck 1.0.1 -->
	<script
		src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/iCheck/icheck.min.js"></script>
	<!-- js分页模板 -->
	<script
		src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/handlebars-v3.0.1.js"></script>
	<!--定义操作列按钮模板-->
	<script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/dist/js/demo.js"></script>
	<script src="<%=basePath%>js/layer/layer.js"></script>
	<script type="text/javascript" language="javascript"
		src="<%=basePath%>system/JsContext/DictionaryData.html"></script>
	<script src="<%=basePath%>js/common/AutoSelect2.js"></script>
	<script
		src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/select2/select2.full.min.js"></script>

	<script id="tpl" type="text/x-handlebars-template">
    <div class="btn-group">
  		<button type="button" class="btn btn-sm btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 
   		 操作 <span class="caret"></span>
  		</button>
  		<ul class="dropdown-menu"> 
		{{#each func}}
		<li><a href="#" onclick="{{this.fn}}">{{this.name}}</a></li>
    	{{/each}}
  		</ul>
	</div>
	</script>

	<script>
 $(function() {
	 
	 <%-- $.fn.modal.Constructor.prototype.enforceFocus = function () {
	     $("#pname").select2({
	    	 ajax: {
			     url: "<%=basePath%>/backstage/policeofficer/autoData.html",
			     dataType: 'json',
			     delay: 250,
			     data: function (params) {
			       return {
			    	  term: params.term, 
			       };
			     },
			     processResults: function (data) {
			       return {
			         results: data
			       };
			     }, 
			     cache: true
			   },
			   minimumInputLength: 1
	    	 
	     }); 
	  }; --%>
	   
	  $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
	      checkboxClass: 'icheckbox_minimal-blue',
	      radioClass: 'iradio_minimal-blue'
	    });
	  
	   $("#_select").AutoSelect({ 
			data : basetemp, // 数据源  
			initCode : "001", // 初始代码值
			showNum : 2, // 第几级开始显示 
			name : "chapter", // 生成select name属性
			disabled : 0,     // 能否选择 数字为极数
			style:"width:100%;"
		}); 
	  
	   $("select[name='bjbm']").change(function (){
		   var val = $(this).val();   
			  $.ajax({
		            url:"/backstage/deductionrules/getTerms.html",
		            data: "code="+val, 
		            dataType:"json",
		            success: function (data) { 
		            			var ht='<select style="width:200px" id="sterms" name="sterms"  class="form-control">';
				            	ht+='<option score="0" value="-1">请选择</option>';
				            	for(var a=0;a<data.length;a++){
				            		ht+='<option score="'+data[a].score+'" value="'+data[a].fuid+'">'+data[a].title+'</option>';
				            	}  
				            	ht+=' </select>';
		            	 $("#sse").html(ht);
		            }
		 	 });   
		});  
	   $("#sdepartment").change(function (){
			 var pid=$(this).val(); 
			 $("input[name='department']").val($("#sdepartment option:selected").text()); 
			 $("input[name='departmentid']").val($(this).val());
			 $.ajax({
		            url:"/backstage/inspector/getOrChild.html",
		            data: "parentid="+pid,
		            dataType:"json",
		            success: function (data) {
		            	var ht="";
		            	 if(data!=null&&data.length>0){
		            	 	ht=' <select  id="department1" class="form-control select2" style="width: 100%"> ';
		            	 	 ht+='<option value="0">请选择</option>';
		            		 for(var a=0;a<data.length;a++){
		            			 ht+='<option value="'+data[a].fuid+'">'+data[a].fullname+'</option>'
		            		 }
		            		 ht+=' </select>'
		            	 }   
		            	 $("#child").html(ht);  
		            	 
		            	 $("#department1").change(function (){
		            		 $("input[name='cdepartment']").val($("#department1 option:selected").text());
		            		 $("input[name='cdepartmentid']").val($(this).val());
		            	 })
		            }
		        });
			 
		 })
		 
		  $("#sodepartment").change(function (){
			 var pid=$(this).val();  
			 if(pid==0){
				 $("input[name='sodepartmentid']").val("-1"); 
				 $("input[name='csodepartmentid']").val("-1"); 
			 }
			 $("input[name='sodepartmentid']").val($(this).val()); 
			 $.ajax({
		            url:"/backstage/inspector/getOrChild.html",
		            data: "parentid="+pid,
		            dataType:"json",
		            success: function (data) {
		            	var ht="";
		            	 if(data!=null&&data.length>0){
		            	 	ht=' <select  id="sodepartment1" class="form-control select2" style="width: 170px"> ';
		            	 	 ht+='<option value="-1">请选择</option>';
		            		 for(var a=0;a<data.length;a++){
		            			 ht+='<option value="'+data[a].fuid+'">'+data[a].fullname+'</option>'
		            		 }
		            		 ht+=' </select>'
		            	 }   
		            	 $("#sochild").html(ht);  
		            	 
		            	 $("#sodepartment1").change(function (){
		            		 $("input[name='csodepartmentid']").val($(this).val());
		            	 })
		            }
		        });
			 
		 })
	    $("#zpdepartment").change(function (){
				 var pid=$(this).val(); 
				 $("input[name='zfdepartment']").val($("#zpdepartment option:selected").text()); 
				 $("input[name='zfdepartmentid']").val($(this).val());
				 $.ajax({
			            url:"/backstage/inspector/getOrChild.html",
			            data: "parentid="+pid, 
			            dataType:"json",
			            success: function (data) {
			            	var ht=""; 
			            	 if(data!=null&&data.length>0){
			            	 	ht=' <select  id="zfdepartment1" class="form-control select2" style="width: 100%"> ';
			            	 	 ht+='<option value="0">请选择</option>';
			            		 for(var a=0;a<data.length;a++){
			            			 ht+='<option value="'+data[a].fuid+'">'+data[a].fullname+'</option>'
			            		 }
			            		 ht+=' </select>'
			            	 }   
			            	 $("#zfchild").html(ht);  
			            	 $("#zfdepartment1").change(function (){
			            		 $("input[name='zfcdepartment']").val($("#zfdepartment1 option:selected").text());
			            		 $("input[name='zfcdepartmentid']").val($(this).val());
			            	 })
			            }
			        }); 
	  			  })
	  			   $("#zhdepartment").change(function (){
				 var pid=$(this).val(); 
				 $("input[name='zhdepartment']").val($("#zhdepartment option:selected").text()); 
				 $("input[name='zhdepartmentid']").val($(this).val());
				 $.ajax({
			            url:"/backstage/inspector/getOrChild.html",
			            data: "parentid="+pid, 
			            dataType:"json",
			            success: function (data) {
			            	var ht=""; 
			            	 if(data!=null&&data.length>0){
			            	 	ht=' <select  id="zhdepartment1" class="form-control select2" style="width: 100%"> ';
			            	 	 ht+='<option value="0">请选择</option>';
			            		 for(var a=0;a<data.length;a++){
			            			 ht+='<option value="'+data[a].fuid+'">'+data[a].fullname+'</option>'
			            		 }
			            		 ht+=' </select>'
			            	 }    
			            	 $("#zhchild").html(ht);  
			            	 $("#zhdepartment1").change(function (){
			            		 $("input[name='zhcdepartment']").val($("#zhdepartment1 option:selected").text());
			            		 $("input[name='zhcdepartmentid']").val($(this).val());
			            	 })
			            }
			        }); 
	  			  })
	  			  
	  			
})
 
 var test;
 var table;
 var editFlag = false;
 
$(function() {

	 var tpl = $("#tpl").html();
    //预编译模板 
    var template = Handlebars.compile(tpl);
	 
	 table = $('#newAttributeTable').dataTable( { 
		 "processing": true, 
		 "serverSide": true,
		 "searchable": true,
		 "searching": true,
		 "bAutoWidth" : true, //是否自适应宽度
		 "bFilter" : false,
		 "drawCallback": function( settings ) {
	     },
		 "aaSorting" : [[9, "desc"]],    //默认按此列排序
        "ajax": "<%=basePath%>backstage/problemdata/getDate.html",
        'fnDrawCallback': function(table) {    
           $("#zf").html(table.json.zf); 
        },  
        "columns": [{ "data": null, 
       	  			"title" : "<input id='changeAll'  onclick='changeAll()' type='checkbox'/>",
       	  			"createdCell" : function(nTd, sData, oData,
								iRow, iCol) {
							var startnum = this.api().page()
									* (this.api().page.info().length);   
							$(nTd).html("<input name='_change' value='"+oData.fuid+"'  type='checkbox'/>"); // 分页行号累加：$(nTd).html(iRow+1);
						}},
						  { "data": "hmd",
							"title" : "文件号" },
						  { "data": "name",
								"title" : "姓名" },
						  { "data": "chapter",
								"title" : "违规章节" },
						  { "data": "terms",
								"title" : "条款" },
						  { "data": "score",
								"title" : "记分" },
								/* { "data": "zstatus",
									"title" : "指派状态" }, */
									{ "data": "jtype",
										"title" : "记分部门类型" },
						  { "data": "jftype",
								"title" : "自主记分" },
								  { "data": "orrurdate",
									"title" : "发生日期" },
									  { "data": "modifydate",
										"title" : "记分日期" },
					  { "data" : null,
						"title" : "操作"
						}],
		"columnDefs": [ 
					{ "bSortable": false, "aTargets": [ 0,6,7,9 ] },   //不排序的列
					{  
					    "targets": [1],  
					    "render": function (data,type, row,   meta) { 
					    	 if(row.hardwareInfo!=null){
						         return '<a href=javascript:showDetail("'+row.fuid+'")>'+data+'</a>';
					    	 }else{
					    		 return data;  
					    	 }	 
					    }  
					},
					/*  { 
						  targets: 6,
						  render: function(data,type,row,meta){ 
							  if(data=='1'){
								  return "指派中";
							  }else 
							  if(data=='2'){
								  return "指派已处理";
							  }else{
								  return "无指派";
							  }
							 
						  }
					  },  */ 
					  { 
						  targets: 6,
						  render: function(data,type,row,meta){ 
							  if(row.dtype==1){
								  return "职能部门";
							  }  else{  
								  return "普通部门"; 
							  }
							 
						  }
					  }, 
					  { 
						  targets: 7,
						  render: function(data,type,row,meta){ 
							  if(row.jftype==1){
								  return "是";
							  }else{
							  return "否"; 
							  } 
						  } 
					  }, 
					  {  
						  targets: 8,
						  render: function(data,type,row,meta){ 
							  return timeForm(data);
						  }
					  }, 
					  {  
						  targets: 9,
						  render: function(data,type,row,meta){ 
							  return timeForm(data);
						  }
					  }, 
					  {
	                        targets:10, 
	                        render: function (data, type, row,   meta) {
	                        	var functional='${sessionScope.functional}';
	                        	var jtype=row.jtype;
	                        	 var context;
	                        	if(functional!=1&&jtype==1){
	                        		 context =
	 	                            {
	 	                            		 func: [ 
	 	                            		        {"name": "查看详情", "fn": "showDetail(\'" + row.fuid + "\')", "type": "info"} 
	 	   	                                ]
	 	                            };
	                        	}else{
	                        		 context =
	 	                            {
	 	                            		 func: [
	 	                            		        {"name": "查看详情", "fn": "showDetail(\'" + row.fuid + "\')", "type": "info"} ,
	 	  	   	                                  <c:if test="${com.hisUpdate}">  
	 	  	   	                             {"name": "修改","fn": "edit(\'" + row.fuid + "\')", "type": "primary"},
	 	  	   	                            		  </c:if>
	 	  	   	                              	<c:if test="${com.hisDelete}">  
	 	  	   	                           {"name": "删除", "fn": "del(\'" + row.fuid + "\')", "type": "danger"},
	 	    	                            		  </c:if>
	 	  	   	                             	 <c:if test="${com.hisOther['bu_zfprocess']}">   
	 	  	   	                            {"name": "指派","fn": "zp(\'" + row.fuid + "\')", "type": "primary"},
	 	   	                            		  </c:if>
	 			  	   	                    	 <c:if test="${com.hisOther['bu_zhprocess']}">   
	 		 	  	   	                            {"name": "指派处理","fn": "dealwith(\'" + row.fuid + "\')", "type": "primary"}
	 		 	   	                            		  </c:if>
	 	   	                                   
	 	   	                                   
	 	   	                                ]
	 	                            };
	                        	}
	                             
	                            
	                            var html = template(context);
	                            return html;
	                        }
	                    },
                ],
                "language": {
                    "lengthMenu": "_MENU_ 条记录每页",
                    "zeroRecords": "没有找到记录",
                    "info": "第 _PAGE_ 页 ( 总共 _PAGES_ 页 ,共 _MAX_ 条)",
                    "infoEmpty": "无记录",
                    "infoFiltered": "(从 _MAX_ 条记录过滤)",
                    "paginate": {
                        "previous": "上一页", 
                        "next": "下一页"
                    },
                    "search": " _INPUT_"
                },
                initComplete: function () {     
                }
                
                
     } );
	 
	 $("#save").click(add);
	  
	 $("input[type=search]").css("display","none");
	 

		var jg='${sessionScope.jg }';
		var tx='${tx}';
		if(jg=='jg'||tx.length>0){
			showBg(tx);
		}
 })

 	 
 	/**
     * 添加数据
     **/
    function add() {
		if(!vi()){
			return; 
		}
        $.ajax({
            url:"/backstage/problemdata/edit.html",
            data: $("#editForm").serialize(),
            dataType:"json",
            success: function (data) {
            	table.api().ajax.reload(null, false); 
                $("#myModal").modal("hide");
                $("#myModalLabel").text("新增");
                clear();
            }
        });
    }
    
function gsearch(){
	var sodepartmentid=$("#sodepartmentid").val(); 
	var csodepartmentid=$("#csodepartmentid").val(); 
	var sispolice=$("select[name='sispolice'").val();
	var sdtype=$("select[name='sdtype']").val();
	var sterms=$("#sterms").val(); 
	sterms=sterms==null?"-1":sterms; 
	var chapter=$("select[name='bjbm']").val();
	var wjh=$("#wjh").val();
	var xm=$("#xm").val();
	var stime=$("#sstime").val();
	var setime=$("#setime").val();
	var data=sodepartmentid+","+sispolice+","+sdtype+","+sterms+","+chapter+","+csodepartmentid+","+wjh+","+xm+","+stime+","+setime+",";
	table.fnFilter(data);  
}  
    
    function update(){
    	if(!vi(1)){
			return; 
		} 
        $.ajax({
            url:"/backstage/problemdata/edit.html",
            data: $("#editForm").serialize(),
            dataType:"json",
            success: function (data) {
            	table.api().ajax.reload(null, false ); 
                $("#myModal").modal("hide");
                clear();
            }
        });
    }

    /**
     *编辑方法
     **/
    function edit(fuid) {
    	 clear();
    	$.ajax({
    		url:"<%=basePath%>backstage/problemdata/getEditData.html",
    		data:{"fuid":fuid},
    		dataType:"json",
    		success:function(res){
    			var s = res.data.problemdata;
    			editFlag = true;
    	        $("#myModalLabel").text("修改");
    	      
    	        $("#fuid").val(s.fuid); 
    	        $("input[name='remarks']").val(s.remarks);
    	        $("input[name='zopinion']").val(s.zopinion);
    	        $("input[name='scoringper']").val(s.scoringper);
    	        $("input[name='jdepartment']").val(s.jdepartment);
    	        $("#name").val(s.name);
    	        $("input[name='orrurdate']").val(timeForm(s.orrurdate));
    	        $("input[name='hmd']").val(s.hmd);
    	         
    	        $("input[name='cdepartment']").val(s.cdepartment);
    	        $("input[name='cdepartmentid']").val(s.cdepartmentid);
    	        
    	        $("#editForm").find("input[name='dtype']").each(function(){
    				if($(this).val()==s.dtype){
    					$(this).iCheck('check');
    				} 
    			})
    			 $("#editForm").find("input[name='ispolice']").each(function(){
    				if($(this).val()==s.ispolice){ 
    					$(this).iCheck('check');
    				} 
    			})
    			 $("#editForm").find("input[name='supervision']").each(function(){
    				if($(this).val()==s.supervision){ 
    					$(this).iCheck('check'); 
    				} 
    			})
    			//select 自动选择
    	        var co=s.chapter;
    	        co=(co==null||co.length==0)?"001":co;
    			 $("#_select").AutoSelect({ 
					data : basetemp, // 数据源   
					initCode : co, // 初始代码值 
					showNum : 2, // 第几级开始显示 
					name : "chapter", // 生成select name属性
					disabled : 0,     // 能否选择 数字为极数
					style:"width:100%;"
				}); 
    			 $.ajax({
    		            url:"/backstage/deductionrules/getTerms.html",
    		            data: "code="+co,
    		            dataType:"json",
    		            success: function (data) {
    		            	$("div[name='te']").each(function (){
    		            		$(this).html("");
    		            		var ht='<select  id="terms" name="terms"  class="form-control">';
    			            	ht+='<option score="0" value="">请选择</option>';
    			            	for(var a=0;a<data.length;a++){
    			            		ht+='<option score="'+data[a].score+'" value="'+data[a].fuid+'">'+data[a].title+'</option>';
    			            	} 
    			            	ht+=' </select>';
    			            	$(this).html(ht);
    			            	 $("#terms").find("option").each(function (){
    			    				 if($(this).val()==s.rulesid){
    			    					 $(this).attr("selected","selected");
    			    				 }
    			    			 })
    			            	$("select[name='terms']").each(function (){
    			            		$(this).change(function() { 
    			            			var se=$(this);
    			            			$("input[name='score']").each(function (){
    			            				$(this).val(se.find("option:selected").attr("score"));
    			            			})
    				            	 })
    			            	})
    		            	})
    		            	 
    		            }
    		        });
    			
    			$("#score").val(s.score);
     	        $("#myModal").modal("show"); 
    		}
    	});
    	$("#_upselect").AutoSelect({   
			data : basetemp, // 数据源  
			initCode : "001", // 初始代码值
			showNum : 2, // 第几级开始显示 
			name : "chapter", // 生成select name属性
			disabled : 0,     // 能否选择 数字为极数
			style:"width:100%;"
		}); 
    }

    function showM(){
    	 clear();
    	  $("#myModal").modal("show"); 
    }
    /**
     * 字段验证
     */ 
  function vi(type){
	  var t=true; 
	  if(type!=null){
		  if($("#_upselect_2").val()=='-1'||$("#_upselect_2").val().length == 0){
				 layer.msg("请选择违法章节");
				 t=false;        
			  }  
		  if($("#_score").val()==null||$("#_score").val().length==0){
				 layer.msg("请输入分值"); 
				 t=false;
			  } 
		  if($("#_score").val()!=null&&isNaN($("#_score").val())){
				 layer.msg("分值必须为数字");
				 t=false;
			  } 
	  }else{
/* 		  if($("#pname").val()==null||$("#pname").val().length == 0){
				 layer.msg("请先选择人员");
				 t=false; 
			  }    
 */			  if($("select[name='chapter']").val()==null||$("select[name='chapter']").val().length == 0){
					 layer.msg("请选择违法章节");
					 t=false;       
				  }  
		  if($("#terms").val()==null||$("#terms").val().length == 0){
				 layer.msg("请选择条款");
				 t=false;
			  } 
			    if($("#score").val()!=null&&isNaN($("#score").val())){
				 layer.msg("分值必须为数字");
				 t=false;
			  } 
	  }
	  var cdepartmentid=$("input[name='cdepartmentid']").val();
	  if(cdepartmentid==null||cdepartmentid.length==0){
		  layer.msg("请选择被记分部门");
			 t=false;
	  }
	  
	  return t;
    }  
    /**
     * 清除
     */ 
    function clear() {
    	$(".modal-content").find("input").each(function (){
    		if($(this).attr("type")!='radio'&&$(this).attr("clear")!='no'){
	    		$(this).val("");
    		}
    	}) 
    	$(".modal-content").find("textarea").each(function (){
    		$(this).val("");
    	})
    	$("#child").html("");
    	$("#sdepartment").val("0");
    	$("#_select").AutoSelect({ 
			data : basetemp, // 数据源  
			initCode : "001", // 初始代码值
			showNum : 2, // 第几级开始显示 
			name : "chapter", // 生成select name属性
			disabled : 0,     // 能否选择 数字为极数
			style:"width:100%;"
		}); 
    	$("#terms").html("");
        editFlag = false;
    }

    /**
     * 删除数据
     * @param name
     */
    function del(fuid) {
    	if (!confirm("确认要删除？")) {
            return;
        }
    	
        $.ajax({
            url: "<%=basePath%>backstage/problemdata/delete.html",
            data: {
                "fuid": fuid
            }, success: function (data) {
            	table.api().ajax.reload(null, false); 
            }
        });
    }
    
     
    function changeAll(){     
    	if($("#changeAll").is(':checked')){ 
    		$("input[name='_change']").each(function (){
    			$(this).prop("checked","checked");
    		})   
    	}else{  
    		$("input[name='_change']").each(function (){
    			$(this).removeAttr("checked");   
    		}) 
    	}
    }
    
    
    
    function showDetail(fuid){
		$.ajax({
	 		url:"<%=basePath%>backstage/problemdata/getEditData.html",
	 		type: 'post',
	 		data:{"fuid":fuid},
	 		dataType:"json",
	 		success:function(res){
	 			var s = res.data.problemdata;
	 				$("#d_name").html(s.name);  
	 				$("#d_chapter").html(s.perid);   
	 				$("#d_terms").html(s.terms);  
	 				$("#d_score").html(s.score);   
	 				$("#d_recorder").html(s.recorder);  
	 				$("#d_modifydate").html(timeForm(s.modifydate));  
	 				$("#d_createdate").html(timeForm(s.createdate));  
	 				$("#d_remarks").html(s.remarks);  
	 				var dtype=s.dtype;
	 				dtype=dtype==1?"职能部门":"普通部门";
	 				$("#d_dtype").html(dtype);  
	 				var ispolice=s.ispolice;
	 				ispolice=ispolice==1?"是":"否"; 
	 				$("#d_ispolice").html(ispolice);  
	 				$("#d_jdepartment").html(s.jdepartment);  
	 				$("#d_department").html(s.cdepartment);  
	 				$("#d_scoringper").html(s.scoringper);
	 				d_scoringper
	 				$("#d_hmd").html(s.hmd);  
	 				$("#d_orrurdate").html(timeForm(s.orrurdate));  
	 				
	 				$("#d_zfdepartment").html(s.zfcdepartment);
	 				$("#d_zhcdepartment").html(s.zhcdepartment);
	 				$("#d_commander").html(s.commander);
	 				$("#d_zdescription").html(s.zdescription);
	 				$("#d_process").html(s.process);
	 				
				  
	 				
	 	        $("#Modal_detail").modal("show");  
	 		}
	 	}); 
	} 
    
    //时间格式化
    function timeForm(date){ 
    	 var bdate = new Date(date);  
    	 var m=bdate.getMinutes().toString(); 
    	 m=m.length==1?"0"+m.toString() :m; 
    	 var h=bdate.getHours().toString(); 
    	 h=h.length==1?"0"+h.toString() :h; 
    	 var s=bdate.getSeconds().toString();  
    	 s=s.length==1?"0"+s.toString() :s;      
    	 var d=bdate.getDate().toString();  
    	 d=d.length==1?"0"+d.toString() :d;    
    	 var mm= (bdate.getMonth()  + 1).toString();  
    	 mm=mm.length==1?"0"+mm.toString() :mm;      
	     bdate = bdate.getFullYear() + "-" + mm + "-" + d+ " " +h + ":" + m + ":" + s;
    	return bdate;
    }
    
    function zp(fuid){
    	$("#cfuid").val(fuid);
    	$("#zfprocess").modal("show");    
 	}
    
    function updateZf(){
        $.ajax({ 
            url:"/backstage/problemdata/editZf.html", 
            data: $("#proform").serialize(),
            dataType:"text",
            success: function (data) {  
            	table.api().ajax.reload(null, false ); 
                $("#zfprocess").modal("hide");
                clear();
            }  
        });
    }
    
    function dealwith(fuid){
    	$("#clfuid").val(fuid);
    	$.ajax({
	 		url:"<%=basePath%>backstage/problemdata/getEditData.html",
	 		type: 'post',
	 		data:{"fuid":fuid},
	 		dataType:"json",
	 		success:function(res){ 
	 			var s = res.data.problemdata;
	 			$("#zpf").val(s.commander);	 
	 			$("#zpbm").val(s.zhcdepartment); 	 
	 			$("#zpsm").val(s.zdescription);	 
	 			$("#dealwith").modal("show");    
	 		}
	 	}); 
    	
    	
 	} 
    function ZHCL(){
        $.ajax({ 
            url:"/backstage/problemdata/editZH.html", 
            data: $("#zhform").serialize(),
            dataType:"text",
            success: function (data) {
            	table.api().ajax.reload(null, false ); 
                $("#dealwith").modal("hide");
                clear();
            }
        });
    }

	

 
function showBg(tx) {  
	if(tx!=null&&tx.length>0){ 
		$("#cco").html("请注意，您的部门被职能部门记分，您的部门记分必须大于"+tx+"以上。");
	} 
	
	var bh = $("body").height(); 
	var bw = $("body").width(); 
	$("#fullbg").css({  
	height:bh, 
	width:bw,  
	display:"block" 
	}); 
	$("#dialog").show(); 
	} 
	//关闭灰色 jQuery 遮罩 
	function closeBg() { 
	$("#fullbg,#dialog").hide(); 
	} 
</script>
</body>
</html>

