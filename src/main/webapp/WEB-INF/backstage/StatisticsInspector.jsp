<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"> 
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>廉政防疫 |管理系统</title>
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<link rel="stylesheet" href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/datatables/dataTables.bootstrap.css"> 
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
				  <div class="box box-default collapsed-box">
		            <div class="box-header with-border">
		              <h3 class="box-title">高级条件</h3>
		              <div class="box-tools pull-right">
		                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i>
		                </button>
		              </div>
		            </div>
		            <div class="box-body">
		              <div class="row">
			             <div class="comment-text" style="margin: 5px 20px;font-weight: bolder;font-size: 12px">
	                      <span class="username">
	                        	自定义时间区间查询
	                        </span>
	               		 </div>
		                <div class="col-xs-2">
		                  <input type="text"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<fmt:formatDate value="${stime}" pattern="yyyy-MM-dd"/>" class="form-control" id="stime"  placeholder="请选择开始时间" >
		                </div>    
		                <div class="col-xs-2">
		                  <input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" value="<fmt:formatDate value="${etime}" pattern="yyyy-MM-dd"/>" class="form-control" id="etime"  placeholder="请选择结束时间" >
		                </div><button type="button" onclick="search('zdy')" style="float: left!important;" class="btn btn-info pull-right">查询</button>
		              </div> 
		              <div class="row" style="margin-top: 10px">
		              	<div class="comment-text" style="margin: 5px 20px;font-weight: bolder;font-size: 12px">
	                      <span class="username">
	                        	快捷查询  
	                        </span>
	               		 </div>
		             	 <div class="col-xs-2">
		                	 <button type="button" onclick="search('thisMonth')" class="btn btn-block btn-default btn-sm">本月</button>
		                 </div>
		                  <div class="col-xs-2">
		                	 <button type="button"  onclick="search('lastMonth')" class="btn btn-block btn-default btn-sm">上一月</button>
		                 </div>
		                  <div class="col-xs-2"> 
		                	 <button type="button" onclick="search('threeMonth')" class="btn btn-block btn-default btn-sm">近三个月</button>
		                 </div> 
		                  <div class="col-xs-2">
		                	 <button type="button" onclick="search('year')" class="btn btn-block btn-default btn-sm">今年</button>
		                 </div>
		              </div> 
		              </div>
		          </div> 
		            
				<!-- /.row -->
				<!-- Main row -->
				<div class="row">
					<!-- Left col -->
					<section class="col-lg-6 connectedSortable">

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

 	

					</section> 
					<section class="col-lg-6 connectedSortable">
						  <div class="box box-info">
							<div class="box-header with-border">
								<h3 class="box-title">区域分布占比分析</h3>

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
								<div  id="ga" style="width: 100%;height: 300px">
									 
								</div>
							</div>
							<!-- /.box-body -->
						</div>  
						 
					</section>
					<!-- right col -->
				</div>
				<!-- /.row (main row) -->
				<div class="row">
					<!-- Left col -->
					<section class="col-lg-6 connectedSortable">

						<div class="box box-info">
							<div class="box-header with-border">
								<h3 class="box-title">监控问题类型分析</h3>

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
								<div  id="jk" style="width: 100%;height: 300px">
									 
								</div>
							</div>
							<!-- /.box-body -->
						</div>  

 	

					</section> 
					<section class="col-lg-6 connectedSortable">
						  <div class="box box-info">
							<div class="box-header with-border">
								<h3 class="box-title">监控人员问题占比分析</h3>

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
								<div  id="jkry" style="width: 100%;height: 300px">
									 
								</div>
							</div>
							<!-- /.box-body -->
						</div>  
						 
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
	  <script src="<%=basePath%>js/echarts-2.2.7/build/dist/echarts.js"></script>
	<script type="text/javascript">
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
	 
	 
	 //接收后台数据-------
	 var lxData = new Array(  
			 <%   
			 String[] lxlist = (String[])request.getAttribute("lx");  
			 for(int i=0; i<lxlist.length; i++)  
			 {  
				 if(i==lxlist.length-1){ 
					 out.print("'"+lxlist[i]+"'");
				 }else{
					 out.print("'"+lxlist[i]+"',");
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
	                var myChart = ec.init(document.getElementById('ga')); 
	                
	                var option = {
	                	    title : {
	                	        text: '区域分布',
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
	                	        data:lxData
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
	                	            name:'所属公安',
	                	            type:'pie',
	                	            radius : '55%',
	                	            center: ['50%', '60%'],
	                	            data: ${lx_data}
	                	        } 
	                	    ]
	                	};
	                // 为echarts对象加载数据 
	                myChart.setOption(option); 
	            }
	        );
	 //-------------
	  var jkData = new Array(  
			 <%   
			 String[] jklist = (String[])request.getAttribute("jk");  
			 for(int i=0; i<jklist.length; i++)  
			 {  
				 if(i==jklist.length-1){
					 out.print("'"+jklist[i]+"'");
				 }else{
					 out.print("'"+jklist[i]+"',");
				 }
			 }  
			 %>   
		) 
	 require(
	            [
	                'echarts',
	                'echarts/chart/pie' // 使用柱状图就加载bar模块，按需加载
	            ],
	            function (ec) { 
	                // 基于准备好的dom，初始化echarts图表
	                var myChart = ec.init(document.getElementById('jk')); 
	                
	                var option = {
	                	    title : {
	                	        text: '监控问题',
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
	                	        data:jkData
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
	                	            name:'监控问题',
	                	            type:'pie',
	                	            radius : '55%',
	                	            center: ['50%', '60%'],
	                	            data: ${jk_data}
	                	        } 
	                	    ]
	                	};
	                // 为echarts对象加载数据 
	                myChart.setOption(option); 
	            }
	        );
	  //-------------
	  var jkryData = new Array(  
			 <%   
			 String[] jkrylist = (String[])request.getAttribute("jkry");  
			 for(int i=0; i<jkrylist.length; i++)  
			 {  
				 if(i==jkrylist.length-1){
					 out.print("'"+jkrylist[i]+"'");
				 }else{
					 out.print("'"+jkrylist[i]+"',");
				 }
			 }  
			 %>   
		) 
	 require(
	            [
	                'echarts',
	                'echarts/chart/pie' // 使用柱状图就加载bar模块，按需加载
	            ],
	            function (ec) { 
	                // 基于准备好的dom，初始化echarts图表
	                var myChart = ec.init(document.getElementById('jkry')); 
	                
	                var option = {
	                	    title : {
	                	        text: '监控问题',
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
	                	        data:jkryData
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
	                	            name:'监控问题',
	                	            type:'pie',
	                	            radius : '55%',
	                	            center: ['50%', '60%'],
	                	            data: ${jkryecharts_data}
	                	        } 
	                	    ]
	                	};
	                // 为echarts对象加载数据 
	                myChart.setOption(option); 
	            }
	        );
	  
	  
	  function search(type){
		  if(type=='zdy'){
			  var stime=$("#stime").val();
			  var etime=$("#etime").val();
			  window.location.href="<%=basePath%>backstage/statistics/showInspector.html?stime="+stime+"&etime="+etime+"&type="+type;
		  }else{
			  window.location.href="<%=basePath%>backstage/statistics/showInspector.html?type="+type;
		  }
		  
		  
	  }
	</script>
</body>
</html>
