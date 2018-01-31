 
<%@ page import="java.util.*" contentType="text/html;charset=UTF-8"%>

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
<title>廉政防疫 | 管理系统</title>
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<link rel="stylesheet" href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/datatables/dataTables.bootstrap.css">
	<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
<style>
.ibox-tools {
    display: inline-block;
    float: right;
    margin-top: 0;
    position: relative;
    padding: 0;
}
.ibox-tools a{
    cursor: pointer;
    margin-left: 5px;
} 

.btn-primary {
    background-color: #1ab394;   
    border-color: #1ab394;
    color: #FFFFFF;
}
.col-xs-6  {  
	position: inherit!important;
}
.zoom-img{
	z-index: 1000;
}
</style>
</head>
<body class="hold-transition skin-blue sidebar-mini"   > 
	<div class="wrapper">

		<jsp:include page="../system/head.jsp" />
		<c:import url="/system/menuData.html"></c:import> 
		<div class="content-wrapper">
			<section class="content-header">
				<h1>
					车辆问题数据 <small>管理</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="<%=basePath%>backstage/index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
					<li><a href="<%=basePath%>backstage/traffic/show.html">管理</a></li>
					<li class="active">列表</li>
				</ol>
			</section>

			<!-- content -->
			<section class="content">
				<div class="box box-default collapsed-box">
		            <div class="box-header with-border">
		              <h3 class="box-title">高级搜索 <span style="font-size: 12px;color: red;">（提示：因数据量过大，仅限统计30天内数据）</span></h3>
		              <div class="box-tools pull-right">
		                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-plus"></i>
		                </button>
		              </div>
		            </div>
		            <div class="box-body">
		              <div class="row" style="margin-top: 20px">
		             	 <div class="col-xs-4">
		                	 <span class="sp" style="float: left;display: block;" >车牌号码： &nbsp;&nbsp;</span> <input id="licenseplate" style="width: 200px" name="licenseplate" class="form-control"  type="text" value="" />
		                 </div> 
		                  <div class="col-xs-6">
		                	  <span class="sp" >出去时间区间：</span>
		                	  <input type="text"  style="width: 200px;display: inline;" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="form-control" id="sstime"  placeholder="请选择起始时间" >
		                	  <input type="text"  style="width: 200px;display: inline;" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="form-control" id="setime"   placeholder="请选择结束时间" >
		                  
		                 </div>
		              </div> 
		               <div class="row" style="margin-top: 20px">
		             	 <div class="col-xs-4">
		                	 <span class="sp" style="float: left;display: block;" >出去间隔： &nbsp;&nbsp;</span> <input id="jtimes" style="width: 200px" name="licenseplate" class="form-control"  type="number" value="" />
		                 </div> 
		                  <div class="col-xs-6">
		                	  <span class="sp" >进入时间区间：</span>
		                	  <input type="text"  style="width: 200px;display: inline;" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="form-control" id="jstime"  placeholder="请选择起始时间" >
		                	  <input type="text"  style="width: 200px;display: inline;" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})" class="form-control" id="jetime"   placeholder="请选择结束时间" >
		                  
		                 </div>
		              </div> 
		              <div class="row" style="margin-top: 20px" > 
		              <div style="width: 90%;text-align: center;">
		                 	<button type="button" style="width: 100px;display: inline;" onclick="gsearch()"  class="btn btn-block btn-primary">查询</button>
		                 </div>
		              </div>
		              </div>
		            <!-- /.box-body -->
		          </div>
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<h3 class="box-title">列表</h3>
								<div class="ibox-tools rboor">
			                    </div>
							</div>
							<!-- /.box-header -->
							<div class="box-body" style="border-style: solid solid none;border-color: #e7eaec;border-width: 1px 0px;">
								<table id="newAttributeTable" class="table table-bordered table-hover" style="width: 100%">
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

 
	<!-- Modal detail -->
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
							<dt>索引ID</dt>
							<dd id="d_id"></dd>
							<dt>过车时间</dt>
							<dd id="d_tdate"></dd>
							<dt>车牌号码</dt>
							<dd id="d_licenseplate"></dd>
							<dt>卡号</dt>
							<dd id="d_card"></dd>
							<dt>读卡时间</dt>
							<dd id="d_readertime"></dd>
							<!-- <dt>accesstype</dt>
							<dd id="d_accesstype"></dd>
							<dt>vehicletype</dt>
							<dd id="d_vehicletype"></dd>
							<dt>vehiclecolor</dt>
							<dd id="d_vehiclecolor"></dd>
							<dt>passtype</dt>
							<dd id="d_passtype"></dd>
							<dt>parktype</dt>
							<dd id="d_parktype"></dd> -->
							<dt>出入口名称</dt>
							<dd id="d_gateway"></dd>
							<dt>车道名称</dt>
							<dd id="d_lanename"></dd>
							<dt>停车场ID</dt>
							<dd id="d_parkid"></dd>
							<dt>carimg</dt>
							<dd id="d_carimg"></dd>
							<dt>brandimg</dt>
							<dd id="d_brandimg"></dd>
							<dt>同步时间</dt>
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
	<!-- Modal detail -->

	<!-- DataTable插件 -->
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/datatables/jquery.dataTables.min.js"></script>
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/datatables/dataTables.bootstrap.min.js"></script>
	<!-- js分页模板 --> 
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/handlebars-v3.0.1.js"></script>
	<!--定义操作列按钮模板-->
	<script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/dist/js/demo.js"></script> 
		<script src="<%=basePath%>js/zoom/zoom.js"></script>
	<script src="<%=basePath%>js/layer/layer.js"></script>
	 
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
		 "aaSorting" : [[2, "desc"]],    //默认按此列排序
        "ajax": "<%=basePath%>backstage/traffic/trafficProblem.html",
        "columns": [{ "data": null, 
       	  			"title" : "<input id='changeAll'  onclick='changeAll()' type='checkbox'/>",
       	  			"createdCell" : function(nTd, sData, oData,
								iRow, iCol) {
							var startnum = this.api().page()
									* (this.api().page.info().length);   
							$(nTd).html("<input name='_change' value='"+oData.fuid+"'  type='checkbox'/>"); // 分页行号累加：$(nTd).html(iRow+1);
						}},
						 { "data": "licenseplate",
							"title" : "车牌号码" },
						  { "data": "s1tdate",
								"title" : "出去时间" },
							{ "data": "s2tdate",
								"title" : "进入时间" },
							{ "data": "jtimes",
								"title" : "出去间隔" },
							{ "data": "vehicletype",
								"title" : "车辆类型" },
							{ "data": "vehiclecolor",
								"title" : "车辆颜色" },
						  { "data": "carimg",
								"title" : "车辆图片" },
						  { "data": "brandimg",
								"title" : "车牌图片" },
								{ "data": "ower",
									"title" : "车主" },
									{ "data": "phone",
										"title" : "手机" }
					 /*  { "data" : null,
						"title" : "操作"
						} */
						],
		"columnDefs": [ 
					{ "bSortable": false, "aTargets": [ 0,1,7,8,9,10] },   //不排序的列
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
							  if(data!=null){
							         return timeForm(data);
						    	 }else{
						    		 return data;  
						    	 }
						  }
					  }, 
					   { 
						  targets:3,
						  render: function(data,type,row,meta){ 
							  if(data!=null){
							         return timeForm(data);
						    	 }else{
						    		 return data;  
						    	 }
						  }
					  }, 
					   { 
						  targets:4,
						  render: function(data,type,row,meta){ 
						    		 return data+"小时";  
						  } 
					  },   
					  { 
						  targets: 7,
						  render: function(data,type,row,meta){ 
							  if(data!=null){
							  	var ht="";   
							  		ht+='<div style="width:100px">';
				 					ht+='<div class="row">';
				 					ht+='<div class="col-xs-6"  style="width:100%"  >';
				 					ht+='<a href="#" class="thumbnail"  style="margin-bottom:0px"  >';
				 					ht+='<img    data-action="zoom" src="'+data+'" >';
				 					ht+='</a>';
				 					ht+='</div>';     
				 					ht+='</div>';
				 					ht+='</div>';
							         return ht;
						    	 }else{
						    		 return data;  
						    	 }
						  }
					  },  
					  { 
						  targets:8,
						  render: function(data,type,row,meta){  
							  if(data!=null){
							         return '<img src='+data+'  style="width: 80px"  />';
						    	 }else{
						    		 return data;  
						    	 }
						  } 
					  },  
					  /* {
	                        targets:8, 
	                        render: function (data, type, row,   meta) {
	                            var context =
	                            {
	                            		 func: [
	   	                                     {"name": "查看详情", "fn": "showDetail(\'" + row.fuid + "\')", "type": "info"} 
	   	                                ]
	                            };
	                            
	                            var html = template(context);
	                            return html;
	                        }
	                    }, */
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
	 
	 //$("#save").click(add);
	 
	 $("input[type=search]").css("display","none");
 })

 	 

  
     
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
    
    
    
      function gsearch(){
		var licenseplate=$("#licenseplate").val();
		var stime=$("#sstime").val()+" ";
		var jtimes=$("#jtimes").val()+" "; 
		var etime=$("#setime").val()+" ";
		var jstime=$("#jstime").val()+" ";
		var jetime=$("#jetime").val()+" ";
		
		var data=licenseplate+","+stime+","+etime+","+jtimes+","+jstime+","+jetime; 
		table.fnFilter(data); 
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
	</script>

</body>
</html>
	 
