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
<title>廉政防疫 |管理系统</title>
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<link rel="stylesheet" href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/datatables/dataTables.bootstrap.css"> 
</head> 
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper"> 

		<jsp:include page="head.jsp" />    
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
				<!-- Small boxes (Stat box) -->
				<div class="row">
					<div class="col-lg-3 col-xs-6">
						<!-- small box -->
						<div class="small-box bg-aqua">
							<div class="inner">
								<h3>${policeNum }</h3>

								<p>警员总数</p>
							</div>
							<div class="icon">
								<i class="ion-ios-bookmarks"></i>
							</div> 
							<a href="<%=basePath%>backstage/policeofficer/show.html" class="small-box-footer">查看详情 <i class="fa fa-arrow-circle-right"></i></a>
						</div>
					</div>
					<!-- ./col -->
					<div class="col-lg-3 col-xs-6">
						<!-- small box -->
						<div class="small-box bg-green">
							<div class="inner">
								<h3>${organizeNum }</h3>

								<p>部门数量</p>
							</div>
							<div class="icon">
								<i class="ion-monitor"></i>
							</div> 
							<a href="<%=basePath%>system/organize/show.html" class="small-box-footer">查看详情 <i class="fa fa-arrow-circle-right"></i></a>
						</div>
					</div>
					<!-- ./col -->
					<div class="col-lg-3 col-xs-6">
						<!-- small box -->
						<div class="small-box bg-red">
							<div class="inner">
								<h3>${inspectorNum }</h3>
								<p>督察问题数</p>
							</div>
							<div class="icon">
								<i class="ion ion-pie-graph"></i>
							</div>
							<a href="<%=basePath%>backstage/inspector/show.html" class="small-box-footer">查看详情 <i class="fa fa-arrow-circle-right"></i></a>
						</div>
					</div>
					<!-- ./col -->
					<!-- ./col -->
					<div class="col-lg-3 col-xs-6">
						<!-- small box -->
						<div class="small-box bg-yellow">
							<div class="inner"> 
								<h3>${problemNum }</h3>

								<p>记分人员数</p>
							</div>
							<div class="icon">
								<i class="ion ion-person-add"></i>
							</div>
							<a href="<%=basePath%>backstage/problemdata/show.html" class="small-box-footer">查看详情 <i class="fa fa-arrow-circle-right"></i></a>
						</div>
					</div>

				</div>
				<!-- /.row -->
				<!-- Main row -->
				<div class="row">
					<!-- Left col -->
					<section class="col-lg-7 connectedSortable">

						<div class="box">
							<div class="box-header with-border">
								<h3 class="box-title">领导批示</h3>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<table class="table table-bordered" id="leadershipTable" style="font-size: 1.5rem;margin-bottom: 0px;"> 
									<thead>
										<tr>
											<th style="width: 10px">#</th>
											<th></th>
											<th></th>
											<th></th> 
											<th></th>
											<th></th>
										</tr>
									</thead> 
								</table>
							</div>
							<!-- /.box-body -->
							<!-- <div class="box-footer clearfix">
								<ul class="pagination pagination-sm no-margin pull-right">
									<li><a href="#">«</a></li>
									<li><a href="#">1</a></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">»</a></li>
								</ul>
							</div> -->
						</div>
						<div class="box">
							<div class="box-header with-border">
								<h3 class="box-title">人员记分列表</h3>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<table class="table table-bordered" id="problemdataTable" style="font-size: 1.5rem;margin-bottom: 0px;"> 
									<thead>
										<tr>
											<th style="width: 10px">#</th>
											<th></th>
											<th></th> 
											<th></th>
											<th></th>
											<th></th>
										</tr>
									</thead> 
								</table>
							</div>
							<!-- /.box-body -->
							<!-- <div class="box-footer clearfix">
								<ul class="pagination pagination-sm no-margin pull-right">
									<li><a href="#">«</a></li>
									<li><a href="#">1</a></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">»</a></li>
								</ul>
							</div> -->
						</div>



					</section>
					<!-- /.Left col -->
					<!-- right col (We are only adding the ID to make the widgets sortable)-->
					<section class="col-lg-5 connectedSortable">
						<!-- <div class="box box-info">
							<div class="box-header">
								<i class="glyphicon glyphicon-cloud"></i>

								<h3 class="box-title">云管理</h3>
								tools box
								<div class="pull-right box-tools">
									<button type="button" class="btn btn-info btn-sm" data-widget="remove" data-toggle="tooltip" title="Remove">
										<i class="fa fa-times"></i>
									</button>
								</div>
								/. tools
							</div> 
							  
							<div class="box-body" >
									<input id="mySwitch" class="form-control" data-off-color="warning"  data-off-text="关闭" data-on-text="开启"  type="checkbox"> <span style="font-size: 12px;margin-left: 20px">注：此开关为一键开启或关闭所有网吧的云端维护功能</span> 
							</div>
						</div>   -->
						<!-- solid sales graph -->
						  <%-- <div class="box box-info">
							<div class="box-header with-border">
								<h3 class="box-title">问题数量趋势</h3>

								<div class="box-tools pull-right">
									<button type="button" class="btn btn-box-tool" data-widget="collapse">
										<i class="fa fa-minus"></i>
									</button>
									<button type="button" class="btn btn-box-tool" data-widget="remove">
										<i class="fa fa-times"></i>
									</button>
								</div>
							</div>
							<div class="box-body chart-responsive">
								<div class="chart" id="line-chart" style="height: 300px; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);">
									<svg height="300" version="1.1" width="582" xmlns="http://www.w3.org/2000/svg" style="overflow: hidden; position: relative;">
										<desc style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">Created with Raphaël 2.1.0</desc>
										<defs style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></defs>
										<text x="48.5" y="263" text-anchor="end" font="10px &quot;Arial&quot;" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-style: normal; font-variant: normal; font-weight: normal; font-stretch: normal; font-size: 12px; line-height: normal; font-family: sans-serif;" font-size="12px" font-family="sans-serif" font-weight="normal">
										<tspan dy="4" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">0</tspan></text>
										<path fill="none" stroke="#aaaaaa" d="M61,263H557" stroke-width="0.5" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path>
										<text x="48.5" y="203.5" text-anchor="end" font="10px &quot;Arial&quot;" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-style: normal; font-variant: normal; font-weight: normal; font-stretch: normal; font-size: 12px; line-height: normal; font-family: sans-serif;" font-size="12px" font-family="sans-serif" font-weight="normal">
										<tspan dy="4" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">50</tspan></text>
										<path fill="none" stroke="#aaaaaa" d="M61,203.5H557" stroke-width="0.5" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path>
										<text x="48.5" y="144" text-anchor="end" font="10px &quot;Arial&quot;" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-style: normal; font-variant: normal; font-weight: normal; font-stretch: normal; font-size: 12px; line-height: normal; font-family: sans-serif;" font-size="12px" font-family="sans-serif" font-weight="normal">
										<tspan dy="4" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">100</tspan></text>
										<path fill="none" stroke="#aaaaaa" d="M61,144H557" stroke-width="0.5" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path>
										<text x="48.5" y="84.5" text-anchor="end" font="10px &quot;Arial&quot;" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-style: normal; font-variant: normal; font-weight: normal; font-stretch: normal; font-size: 12px; line-height: normal; font-family: sans-serif;" font-size="12px" font-family="sans-serif" font-weight="normal">
										<tspan dy="4" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">150</tspan></text>
										<path fill="none" stroke="#aaaaaa" d="M61,84.5H557" stroke-width="0.5" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path>
										<text x="48.5" y="24.99999999999997" text-anchor="end" font="10px &quot;Arial&quot;" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: end; font-style: normal; font-variant: normal; font-weight: normal; font-stretch: normal; font-size: 12px; line-height: normal; font-family: sans-serif;" font-size="12px" font-family="sans-serif" font-weight="normal">
										<tspan dy="3.9999999999999716" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">200</tspan></text>
										<path fill="none" stroke="#aaaaaa" d="M61,24.99999999999997H557" stroke-width="0.5" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path>
										<text x="465.99635479951394" y="275.5" text-anchor="middle" font="10px &quot;Arial&quot;" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-style: normal; font-variant: normal; font-weight: normal; font-stretch: normal; font-size: 12px; line-height: normal; font-family: sans-serif;" font-size="12px" font-family="sans-serif" font-weight="normal" transform="matrix(1,0,0,1,0,6)">
										<tspan dy="4" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">2013</tspan></text>
										<text x="245.4179829890644" y="275.5" text-anchor="middle" font="10px &quot;Arial&quot;" stroke="none" fill="#888888" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-style: normal; font-variant: normal; font-weight: normal; font-stretch: normal; font-size: 12px; line-height: normal; font-family: sans-serif;" font-size="12px" font-family="sans-serif" font-weight="normal" transform="matrix(1,0,0,1,0,6)">
										<tspan dy="4" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">2012</tspan></text>
										<path fill="none" stroke="#3c8dbc"
											d="M61,231.2746C74.86148238153098,230.9414,102.58444714459296,233.282725,116.44592952612393,229.9418C130.3074119076549,226.600875,158.0303766707169,206.02637650273223,171.89185905224787,204.5472C185.60267314702307,203.08410150273224,213.0243013365735,220.995975,226.7351154313487,218.1727C240.4459295261239,215.349425,267.8675577156743,184.77624412568306,281.57837181044954,181.961C295.43985419198054,179.11481912568308,323.1628189550425,192.56687499999998,337.0243013365735,195.527C350.88578371810445,198.487125,378.60874848116646,219.70539398907104,392.4702308626974,205.642C406.18104495747264,191.73146898907103,433.60267314702304,92.4066788674033,447.31348724179827,83.63129999999998C460.8736330498177,74.9523538674033,487.9939246658566,126.05476730769232,501.55407047387604,135.8247C515.415552855407,145.81174230769233,543.138517618469,155.95057500000001,557,162.6592"
											stroke-width="3" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path>
										<circle cx="61" cy="231.2746" r="4" fill="#3c8dbc" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="116.44592952612393" cy="229.9418" r="4" fill="#3c8dbc" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="171.89185905224787" cy="204.5472" r="4" fill="#3c8dbc" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="226.7351154313487" cy="218.1727" r="4" fill="#3c8dbc" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="281.57837181044954" cy="181.961" r="4" fill="#3c8dbc" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="337.0243013365735" cy="195.527" r="4" fill="#3c8dbc" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="392.4702308626974" cy="205.642" r="4" fill="#3c8dbc" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="447.31348724179827" cy="83.63129999999998" r="4" fill="#3c8dbc" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="501.55407047387604" cy="135.8247" r="4" fill="#3c8dbc" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle>
										<circle cx="557" cy="162.6592" r="4" fill="#3c8dbc" stroke="#ffffff" stroke-width="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></circle></svg>
									<div class="morris-hover morris-default-style" style="left: 14.5px; top: 157px; display: none;">
										<div class="morris-hover-row-label">2011 Q1</div>
										<div class="morris-hover-point" style="color: #3c8dbc">Item 1: 2,666</div>
									</div>
								</div>
							</div>
							<!-- /.box-body -->
						</div>   --%>

						<div class="box box-info">
							<div class="box-header with-border">
								<h3 class="box-title">督察问题类型分析</h3>

								<div class="box-tools pull-right">
									<button type="button" class="btn btn-box-tool" data-widget="collapse">
										<i class="fa fa-minus"></i>
									</button>
									<button type="button" class="btn btn-box-tool" data-widget="remove">
										<i class="fa fa-times"></i>
									</button>
								</div>
							</div>
							<div class="box-body chart-responsive">
								<div  id="re" style="width: 100%;height: 300px">
									 
								</div>
							</div>
							<!-- /.box-body -->
						</div>  

 	

						<!-- /.box -->

					</section>
					<!-- right col -->
				</div>
				<!-- /.row (main row) -->

			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
		<jsp:include page="foot.jsp" />
		<!-- Add the sidebar's background. This div must be placed
       immediately after the control sidebar -->
		<div class="control-sidebar-bg"></div>
		
		<!-- modal -->
		<div class="modal fade" id="Modal_detail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<div class="box-header with-border" style="border-bottom:0px">
						<button type="button" class="close" style="z-index: 1000" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<i class="fa fa-tv"></i>
						<h3 class="box-title">详情</h3>
					</div>
				</div>
				<div class="modal-body">
					<div class="panel-body" style="padding: 0px;font-size: 12px">
						<dl class="dl-horizontal">
							<dt>信访编号</dt>
							<dd id="d_xno"></dd>
							<dt>信访人</dt>
							<dd id="d_fname"></dd>
							<dt>信访人户籍</dt>
							<dd id="d_household"></dd>
							<dt>问题发生地</dt>
							<dd id="d_adress"></dd>
							<dt>信访类别</dt>
							<dd id="d_xcode"></dd>
							<dt>人数</dt>
							<dd id="d_pnumber"></dd>
							<dt>信访目的</dt>
							<dd id="d_purpose"></dd>
							<dt>信访日期</dt>
							<dd id="d_xdate"></dd>
							<dt>信访状态</dt>
							<dd id="d_xstatus"></dd>
							<dt>限结天数</dt>
							<dd id="d_xdays"></dd>
							<dt>登记人</dt>
							<dd id="d_rperson"></dd>
							<dt>信访内容</dt>
							<dd id="d_fcontet"></dd>
							<dt>办结状态</dt>
							<dd id="d_bstatus"></dd>
							<dt>办结时间</dt>
							<dd id="d_bdate"></dd>
							<dt>承办单位</dt>
							<dd id="d_contractors"></dd>
							<dt>办理过程</dt>
							<dd id="d_process"></dd>
							<dt>领导批示</dt>
							<dd id="d_instructions" style="color: red;"></dd>
							<dt>修改时间</dt>
							<dd id="d_modifydate"></dd>
							
						</dl>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog"  >
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">批示</h4>
				</div>
				<form id="editForm"  class="form-horizontal"> 
					<div class="modal-body">
						<div class="box-body">
						      <div class="form-group">
				                  <textarea class="form-control" id="instructions" rows="4" placeholder="请输入批示..."></textarea>
				                  <input type="hidden" value=""  id="fuid" />
				                </div>
						</div>
					</div> 
				</form>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="re()">保存</button>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="poModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<div class="box-header with-border" style="border-bottom:0px">
						<button type="button" class="close" style="z-index: 1000" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<i class="fa fa-tv"></i>
						<h3 class="box-title">详情</h3>
					</div>
				</div>
				<div class="modal-body">
					<div class="panel-body" style="padding: 0px;font-size: 12px">
						<dl class="dl-horizontal">
							<dt>姓名</dt>
							<dd id="d_name"></dd>
							<dt>违法章节</dt>
							<dd id="d_chapter"></dd>
							<dt>条款</dt>
							<dd id="d_terms"></dd>
							<dt>分值</dt>
							<dd id="d_score"></dd>
							<dt>记录人员</dt>
							<dd id="d_recorder"></dd>
							<dt>备注</dt>
							<dd id="d_remarks"></dd>
							<dt>修改时间</dt>
							<dd id="d_modifydate"></dd>
							<dt>创建时间</dt>
							<dd id="d_createdate"></dd>
							
						</dl>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	
	</div>
	<!-- ./wrapper -->
	
	<!-- DataTable插件 -->
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/datatables/jquery.dataTables.min.js"></script>
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/datatables/dataTables.bootstrap.min.js"></script>
	<!-- js分页模板 --> 
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/handlebars-v3.0.1.js"></script> 
	  <script src="<%=basePath%>js/echarts-2.2.7/build/dist/echarts.js"></script>
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
	<script type="text/javascript">
	 var table;
	 var editFlag = false;
	$(function() {
		 var tpl = $("#tpl").html();
		    //预编译模板
		    var template = Handlebars.compile(tpl);
		 table = $('#leadershipTable').dataTable( { 
			 "processing": true, 
			 "serverSide": true, 
			 "searchable": false, 
			 "searching": false,
			 "bAutoWidth" : true, //是否自适应宽度
			 "bFilter" : false,
			 "drawCallback": function( settings ) {
				  
		     },
			 "aaSorting" : [[4, "desc"]],    //默认按此列排序
	        "ajax": "<%=basePath%>backstage/fvisits/getDate.html?ps=1&page=5",
	        "columns": [{ "data": null, 
	       	  			"title" : "<input id='changeAll'  onclick='changeAll()' type='checkbox'/>",
	       	  			"createdCell" : function(nTd, sData, oData,
									iRow, iCol) {
								var startnum = this.api().page()
										* (this.api().page.info().length);   
								$(nTd).html("<input name='_change' value='"+oData.fuid+"'  type='checkbox'/>"); // 分页行号累加：$(nTd).html(iRow+1);
							}},
							  { "data": "fname",
									"title" : "信访人" },
							  { "data": "xdate", 
									"title" : "信访日期" },
							  { "data": "purpose",
									"title" : "信访目的" },
							  { "data": "rperson",
									"title" : "登记人" },
						  { "data" : null,
							"title" : "操作"
							}],
			"columnDefs": [ 
						{ "bSortable": false, "aTargets": [ 0 ,5] },   //不排序的列
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
						 { 
							  targets: 2,
							  render: function(data,type,row,meta){ 
						            return timeForm(data,"day");
							  }
						  }, 
						  { 
		                        targets:5, 
		                        render: function (data, type, row,   meta) {
		                            var context =
		                            {
		                            		 func: [
			   	                                     {"name": "查看详情", "fn": "showDetail(\'" + row.fuid + "\')", "type": "info"} ,
			   	                                  {"name": "批示","fn": "reported(\'" + row.fuid + "\')", "type": "primary"}
			   	                                ]
		                            };
		                            
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
		 
		 var problemdata = $('#problemdataTable').dataTable( { 
			 "processing": true, 
			 "serverSide": true, 
			 "searchable": false, 
			 "searching": false,
			 "bAutoWidth" : true, //是否自适应宽度
			 "bFilter" : false,
			 "drawCallback": function( settings ) {
				  
		     },
			 "aaSorting" : [[1, "desc"]],    //默认按此列排序
	        "ajax": "<%=basePath%>backstage/problemdata/getDate.html?page=5",
	        "columns": [{ "data": null, 
	       	  			"title" : "<input id='changeAll'  onclick='changeAll()' type='checkbox'/>",
	       	  			"createdCell" : function(nTd, sData, oData,
									iRow, iCol) {
								var startnum = this.api().page()
										* (this.api().page.info().length);   
								$(nTd).html("<input name='_change' value='"+oData.fuid+"'  type='checkbox'/>"); // 分页行号累加：$(nTd).html(iRow+1);
							}},
							  { "data": "name",
									"title" : "姓名" },
							  { "data": "chapter", 
									"title" : "违反章节" },
							  { "data": "terms",
									"title" : "条款" },
							  { "data": "score",
									"title" : "记分" },
						  { "data" : null,
							"title" : "操作"
							}],
			"columnDefs": [ 
						{ "bSortable": false, "aTargets": [ 0,5 ] },   //不排序的列
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
						 { 
							  targets: 2,
							  render: function(data,type,row,meta){ 
						            return data.length>6?data.substring(0,6)+"...":data;
							  }
						  }, 
						  { 
		                        targets:5, 
		                        render: function (data, type, row,   meta) {
		                            var context =
		                            {
		                            		 func: [
		   	                                     {"name": "查看详情", "fn": "showDetailPo(\'" + row.fuid + "\')", "type": "info"} 
		   	                                ]
		                            };
		                            
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
	     
	     
	      require.config({
         paths: {
             echarts: '<%=basePath%>js/echarts-2.2.7/build/dist'
         }
     });
	 //接收后台数据-------
	 var leData = new Array(  
			 <%   
			 String[] costList = (String[])request.getAttribute("bt");  
			 for(int i=0; i<costList.length; i++)  
			 {  
				 if(i==costList.length-1){
					 out.print("'"+costList[i]+"'");
				 }else{
					 out.print("'"+costList[i]+"',");
				 }
			 }  
			 %>   
		) 
	 //-------------
	 require(
	            [
	                'echarts',
	                'echarts/chart/pie' // 使用柱状图就加载bar模块，按需加载
	            ],
	            function (ec) { 
	                // 基于准备好的dom，初始化echarts图表
	                var myChart = ec.init(document.getElementById('re')); 
	                
	                var option = {
	                	    title : {
	                	        text: '督察问题类型',
	                	        subtext: '占比分析',
	                	        x:'center'
	                	    },
	                	    tooltip : {
	                	        trigger: 'item',
	                	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	                	    },
	                	    legend: {
	                	        orient : 'vertical',
	                	        x : 'left',
	                	        data:leData
	                	    },
	                	    toolbox: {
	                	        show : true,
	                	        feature : {
	                	            restore : {show: true},
	                	            saveAsImage : {show: true}
	                	        }
	                	    },
	                	    calculable : true,
	                	    series : [
	                	        { 
	                	            name:'问题类型',
	                	            type:'pie',
	                	            radius : '55%',
	                	            center: ['50%', '60%'],
	                	            data: ${e_data}
	                	        }
	                	    ]
	                	};
	                // 为echarts对象加载数据 
	                myChart.setOption(option); 
	            }
	        );
	 
	 
		 
	 })
	 
	 function showDetail(fuid){
		$.ajax({
	 		url:"<%=basePath%>backstage/fvisits/getEditData.html",
	 		type: 'post',
	 		data:{"fuid":fuid},
	 		dataType:"json",
	 		success:function(res){
	 			var s = res.data.fvisits; 
	 				$("#d_xno").html(s.xno);  
	 				$("#d_fname").html(s.fname);  
	 				$("#d_household").html(s.household);  
	 				$("#d_adress").html(s.adress);  
	 				$("#d_xcode").html(s.xcode);  
	 				$("#d_pnumber").html(s.pnumber);  
	 				$("#d_purpose").html(s.purpose);  
	 				$("#d_xdate").html(timeForm(s.xdate));  
	 				$("#d_xstatus").html(s.xstatus);  
	 				$("#d_xdays").html(s.xdays);  
	 				$("#d_rperson").html(s.rperson);  
	 				$("#d_fcontet").html(s.fcontet);  
	 				$("#d_bstatus").html(s.bstatus);  
	 				$("#d_bdate").html(timeForm(s.bdate));  
	 				$("#d_contractors").html(s.contractors);  
	 				$("#d_process").html(s.process);   
	 				$("#d_modifydate").html(timeForm(s.modifydate));  
	 				$("#d_instructions").html(s.instructions);  
	 	        $("#Modal_detail").modal("show");  
	 		}
	 	}); 
	} 
	 function showDetailPo(fuid){
			$.ajax({
		 		url:"<%=basePath%>backstage/problemdata/getEditData.html",
		 		type: 'post',
		 		data:{"fuid":fuid},
		 		dataType:"json",
		 		success:function(res){
		 			var s = res.data.problemdata;
		 				$("#d_name").html(s.name);  
		 				$("#d_chapter").html(s.chapter);  
		 				$("#d_terms").html(s.terms);  
		 				$("#d_score").html(s.score);   
		 				$("#d_recorder").html(s.recorder);  
		 				$("#d_modifydate").html(timeForm(s.modifydate));  
		 				$("#d_createdate").html(timeForm(s.createdate));  
		 				$("#d_remarks").html(s.remarks);  
		 	        $("#poModal").modal("show");  
		 		}
		 	}); 
		} 
	function re(){
		var fuid=$("#fuid").val();
		var instructions=$("#instructions").val();
		 $.ajax({ 
	 		url:"<%=basePath%>backstage/fvisits/inst.html",
	 		type: 'post',
	 		data:{"fuid":fuid,"instructions":instructions},
	 		dataType:"text",
	 		success:function(res){ 
	 			$("#myModal").modal("hide");
	 		}
	 	}); 
		
	}
	 function reported(fuid) {
		 $("#fuid").val(fuid);
		 $.ajax({
		 		url:"<%=basePath%>backstage/fvisits/getEditData.html",
		 		type: 'post',
		 		data:{"fuid":fuid},
		 		dataType:"json",
		 		success:function(res){
		 			var s = res.data.fvisits; 
		 			$("#instructions").val(s.instructions);  
		 	       	 $("#myModal").modal("show");  
		 		}
		 	}); 
	    }
	   //时间格式化
    function timeForm(date,type){ 
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
    	 if(type=='day'){
		     bdate = bdate.getFullYear() + "-" + mm + "-" + d;    		  
    	 }else{
		     bdate = bdate.getFullYear() + "-" + mm + "-" + d+ " " +h + ":" + m + ":" + s;
    	 }
    	return bdate;
    }
	</script>
</body>
</html>
