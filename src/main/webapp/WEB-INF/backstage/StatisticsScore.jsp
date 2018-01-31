<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"> 
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>廉政防疫 |管理系统</title>
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<link rel="stylesheet" href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/datatables/dataTables.bootstrap.css"> 
  <link rel="stylesheet" href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/iCheck/all.css">
	<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
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
				<form action="" method="post" id="myform" >
				<div class="box box-default ">
		            <div class="box-header with-border">
		              <h3 class="box-title">高级搜索</h3>
		              <div class="box-tools pull-right">
		                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i>
		                </button>
		              </div>
		            </div>
		            <div class="box-body">
		              <div class="row">
			             <div class="comment-text" style="margin: 5px 20px;font-weight: bolder;font-size: 12px">
	                      <span class="username">
	                        	 
	                        </span>
	               		 </div>
	               		  <div class="col-xs-3">
		                  	 <span class="sp" style="display: block;float: left;line-height: 30px">所属部门： &nbsp;&nbsp; </span>	 
		                  	 <select  id="sdepartment" name="jqdepartmentid" class="form-control select2" style="width: 55%;float: left;"> 
								    	<option value="0">请选择</option> 
									  	<c:forEach var="list" items="${oragenizeAll }">
									  		<c:choose>  
											    <c:when test="${scoring.jqdepartmentid==list.fuid }">  
											       <option selected="selected" value="${list.fuid }">${list.fullname }</option>
											    </c:when>  
											    <c:otherwise>   
											        <option   value="${list.fuid }">${list.fullname }</option>                               
												</c:otherwise>
												</c:choose>
									  	</c:forEach> 
								  </select>  
		                </div>
		                <div class="col-xs-5">
		                   <span class="sp" >职务类型：</span> 	  <input type="radio" name="ischief" class="minimal" checked="checked" value=""> 所有 <input type="radio" name="ischief" class="minimal"   value="2">&nbsp; 中层正职 &nbsp; <input type="radio" name="ischief"  class="minimal" value="1" >&nbsp;中层副职&nbsp;<input type="radio" name="ischief"  class="minimal" value="0" >&nbsp;无 
		                </div>    
		               <div class="col-xs-3">
		               	 <span class="sp" >是否民警：</span>  <input type="radio" name="ispolice" class="minimal" checked="checked" value=""> 所有 <input type="radio" name="ispolice" class="minimal"   value="1">&nbsp; 是&nbsp; <input type="radio" name="ispolice"  class="minimal" value="0" >&nbsp;否&nbsp;
		               </div>
		              </div> 
		              <div class="row" style="margin-top: 20px">
		             	 <div class="col-xs-6">
		                	 <span class="sp" >签发时间区间：</span>
		                	  <input type="text"  value="<fmt:formatDate value="${ scoring.stime }"  type="date" dateStyle="default"/>" style="width: 150px;display: inline;" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="form-control" id="stime" name="stime" placeholder="请选择开始时间" >
		                	   <input type="text" value="<fmt:formatDate value="${ scoring.createdate }"  type="date" dateStyle="default"/>"   style="width: 150px;display: inline;" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="form-control" id="setime" name="createdate"   placeholder="请选择结束时间" >
		                 </div>
		                  <div class="col-xs-6">
		                	  <span class="sp" >停职时间区间：</span>
		                	  <input type="text"  value="<fmt:formatDate value="${ scoring.dstime }"  type="date" dateStyle="default"/>" style="width: 150px;display: inline;" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="form-control" id="dstime" name="dstime" placeholder="请选择开始时间" >
		                	   <input type="text"  value="<fmt:formatDate value="${ scoring.detime }"  type="date" dateStyle="default"/>"  style="width: 150px;display: inline;" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="form-control" id="detime" name="detime"   placeholder="请选择结束时间" >
		                 </div>
		                  
		              </div> 
		              <div class="row" style="margin-top: 20px" > 
		              <div style="width: 90%;text-align: center;">
		                 	<button type="submit" style="width: 100px;display: inline;" class="btn btn-block btn-primary">查询</button>
		                 </div>
		              </div>
		              </div>
		            <!-- /.box-body -->
		          </div>
		          </form>
				<!-- /.row -->
				<!-- Main row -->
				<div class="row">
			        <!-- /.col -->
			        <div class="col-md-4 col-sm-6 col-xs-12">
			          <div class="info-box">
			            <span class="info-box-icon bg-red"><i class="ion ion-ios-people-outline"></i></span>
			
			            <div class="info-box-content">
			              <span class="info-box-text">停止执行任务人数</span>
			              <span class="info-box-number">${tz }</span>
			            </div> 
			            <!-- /.info-box-content -->
			          </div>
			          <!-- /.info-box -->
			        </div>
			        <!-- /.col -->
					<div class="col-md-4 col-sm-6 col-xs-12">
			          <div class="info-box">
			            <span class="info-box-icon bg-yellow"><i class="ion ion-ios-people-outline"></i></span>
			
			            <div class="info-box-content">
			              <span class="info-box-text">禁闭人数</span>
			              <span class="info-box-number">${jb }</span>
			            </div>
			            <!-- /.info-box-content -->
			          </div>
			          <!-- /.info-box -->
			        </div>
			        <!-- fix for small devices only -->
			        <div class="clearfix visible-sm-block"></div>
			
			        <div class="col-md-4 col-sm-6 col-xs-12">
			          <div class="info-box">
			            <span class="info-box-icon bg-green"><i class="ion ion-ios-people-outline"></i></span>
			
			            <div class="info-box-content">
			              <span class="info-box-text">督察记分人数</span>
			              <span class="info-box-number">${jf }</span>
			            </div>
			            <!-- /.info-box-content -->
			          </div>
			          <!-- /.info-box -->
			        </div> 
			        <!-- /.col -->
			        
			        <!-- /.col -->
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
		<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/iCheck/icheck.min.js"></script>
	  <script src="<%=basePath%>js/echarts-2.2.7/build/dist/echarts.js"></script>
	<script type="text/javascript">
	 $(function() { 
		 $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
		      checkboxClass: 'icheckbox_minimal-blue',
		      radioClass: 'iradio_minimal-blue'
		    });
		 
		 var ischief='${scoring.ischief}';
		 $("input[name='ischief']").each(function (){
			 if($(this).val()==ischief){
				 $(this).iCheck('check');
			 }
		 })
		 var ispolice='${scoring.ispolice}';
		  $("input[name='ispolice']").each(function (){
			 if($(this).val()==ispolice){
				 $(this).iCheck('check');
			 }
		 })
		
	 });
	</script>
</body>
</html>
