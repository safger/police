
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
</style>
</head>
<body class="hold-transition skin-blue sidebar-mini">

	<div class="wrapper">

		<jsp:include page="../system/head.jsp" />
		<c:import url="/system/menuData.html"></c:import>
		<div class="content-wrapper">
			<section class="content-header">
				<h1>
					廉政防疫 <small>管理系统</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="<%=basePath%>backstage/index.html"><i
							class="fa fa-dashboard"></i> 首页</a></li>
					<li><a href="<%=basePath%>backstage/policeofficer/show.html">管理</a></li>
					<li class="active">列表</li>
				</ol>
			</section>
			<div class="pad margin no-print">
				<div class="callout callout-info"
					style="margin-bottom: 0!important;">
					<h4>
						<i class="fa fa-info"></i> 温馨提示:
					</h4>
					导入的EXCEL格式必须和以下格式一致，否则将无法导入！若数据已存在将会覆盖原先数据.
				</div>
			</div>
			<!-- content -->
			<section class="invoice">
				<!-- title row -->
				<div class="row">
					<div class="col-xs-12">
						<h2 class="page-header">
							<i class="fa fa-globe"></i> EXCEL格式示例
						</h2>
					</div>
					<!-- /.col -->
				</div>


				<!-- Table row -->
				<div class="row">
					<div class="col-xs-12 table-responsive">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>警号</th>
									<th>姓名</th>
									<th>办公内线</th>
									<th>职务</th>
									<th>办公外线</th>
									<th>短号</th>
									<th>电子邮箱</th>
									<th>手机号</th>
									<th>房间号</th>
									<th>传真</th>
									<th>单位</th>
									<th>身份证</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>33070550</td>
									<td>张三</td>
									<td>5022</td>
									<td>民警</td>
									<td>81894572</td>
									<td>641599</td>
									<td>3143145@qq.com</td>
									<td>1382465982</td>
									<td>625</td>
									<td>无</td>
									<td>交警局直属二大队</td>
									<td>331003199203002294</td>
								</tr>
								<tr>
									<td>33070551</td>
									<td>李四</td>
									<td>5122</td>
									<td>职工</td>
									<td>81894572</td>
									<td>641599</td>
									<td>1023145@qq.com</td>
									<td>1372465982</td>
									<td>620</td>
									<td>无</td>
									<td>交警局科技局</td>
									<td>331003199203012394</td>
								</tr>
							</tbody>
						</table>
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-xs-12">
						<h2 class="page-header">
							<i class="fa fa-file-excel-o"></i> 文件上传:
						</h2>
					</div>
					<!-- /.col -->
				</div>
				<c:if test="${re==1 }">
					<div class="alert alert-info" role="alert">
			     	 <strong>成功!</strong> 数据导入成功!
			    	</div> 
				</c:if>
				<c:if test="${re==2 }"> 
					<div class="alert alert-warning" role="alert">
				      <strong>失败!</strong> 请检查EXCEL格式再试一次!
				    </div>
				</c:if>
				<div class="row no-print">
					<form action="<%=basePath%>backstage/fvisits/EImport.html" method="post" id="myform" enctype="multipart/form-data"  >
						<div class="form-group">
							<div class="col-sm-10">
									<label for="exampleInputEmail1"  style="clear:both;display: block;">请选择部门 </label>  
								<select class="form-control select2" name="orgId" style="width: 250px;float: left;">  
									  	<c:forEach var="list" items="${oragenizeAll }">
									  		<option value="${list.fuid }">${list.fullname }</option>
									  	</c:forEach>
								</select>  
								<input  type="hidden" id="organizeId" name="organizeId" />
								<div style="float: left;margin-left: 30px">
									<input type="file" name="exfile" style="float: left!important;" />
									<button type="button" onclick="sub()" class="btn btn-primary pull-right"
										style="float: left!important;">
										<i class="fa fa-download"></i> 确定上传
									</button>
								</div>
							</div>
						</div>
					</form>
				</div>
			</section>
		</div>
		<jsp:include page="../system/foot.jsp" />
	</div>

	<script type="text/javascript">
	
		function sub(){
			var orgId=$("select[name='orgId']").val();
			if(orgId==null||orgId.length==0){
				alert("请先选择部门");
				return;
			}else{
				$("#organizeId").val(orgId);
			} 
			$("#myform").submit();
		}
	</script>
</body>
</html>

