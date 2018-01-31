 
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
 <link rel="stylesheet" href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/select2/select2.min.css">
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
 
input{ 
	width: auto!important;
} 
.form-group label{
	width: 100px!important;
	font-weight: normal!important;
}

textarea{
text-align: left!important; 
}

.col-xs-4{ 
width: auto!important; 
padding-left: 1px!important;
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
					管理系统 <small>风险排查管理</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="<%=basePath%>backstage/index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
					<li><a href="<%=basePath%>backstage/policeofficer/show.html">警员管理</a></li>
					<li class="active">警员列表</li>
				</ol>
			</section>

			<!-- content -->
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<h3 class="box-title">警员列表</h3>
								<div class="ibox-tools rboor">
			                        <!-- <a href="#" class="btn btn-primary btn-xs p310" data-toggle="modal" data-target="#myModal"><i class="fa fa-plus"></i> 新增</a> --> 
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
	 
	<!-- Modal -->
	<div class="modal fade" id="myModal"  tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" style="width:970px">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">新增</h4>
				</div>
				<form id="editForm"  class="form-horizontal"> 
					<div class="modal-body">
						<div class="box-body">
							<blockquote>
						      <p>基础信息</p>
						    </blockquote>
							<div class="form-group">
						        <label for="inputPassword3" class="col-sm-2 control-label">姓名</label>
						         <div class="col-xs-4">   
						        	 <input type="text" class="form-control" id="name" name="name" placeholder="">
								  </div> 
								   <label for="inputPassword3" class="col-sm-2 control-label">职务</label>
								  <div class="col-xs-4">
								    <input type="text" class="form-control" id="duties" name="duties" placeholder="">
								  </div>
								  <label for="inputPassword3" class="col-sm-2 control-label">所在部门</label>
								  <div class="col-xs-4">
								    <input type="text" class="form-control" id="unit" name="unit" placeholder="">
								  </div>
						      </div>
						       <div class="form-group">
								  <label for="inputPassword3" class="col-sm-2 control-label">岗位职责</label>
								  <div class="col-xs-4"> 
								    <textarea rows="4" id="responsibilities" name="responsibilities"  class="form-control" cols="90"></textarea>
								  </div>
						      </div>
						      <blockquote>
						      <p>思想道德风险</p>
						    </blockquote>
						       <div class="form-group">
								  <label for="inputPassword3" class="col-sm-2 control-label">风险点描述</label>
								  <div class="col-xs-4"> 
								    <textarea rows="4" id="srisk" name="srisk"  style="width: 100%"  class="col-sm-5 control-label" cols="50" ></textarea>
								  </div>
								   <label for="inputPassword3" class="col-sm-3 control-label">防范措施</label>
								  <div class="col-xs-4"> 
								    <textarea rows="4" id="sriskprevention" name="sriskprevention" style="width: 100%"   class="col-sm-5 control-label" cols="50"></textarea>
								  </div>
						      </div>
						      <blockquote>
						      <p>履行职权风险</p>
						    </blockquote>
						       <div class="form-group">
								  <label for="inputPassword3" class="col-sm-2 control-label">风险点描述</label>
								  <div class="col-xs-4"> 
								    <textarea rows="4" id="zrisk" name="zrisk"  style="width: 100%"  class="col-sm-5 control-label" cols="50" ></textarea>
								  </div>
								   <label for="inputPassword3" class="col-sm-3 control-label">防范措施</label>
								  <div class="col-xs-4"> 
								    <textarea rows="4" id="zriskprevention" name="zriskprevention" style="width: 100%"   class="col-sm-5 control-label" cols="50"></textarea>
								  </div>
						      </div>
						       <blockquote>
						      <p>底线红线风险</p>
						    </blockquote>
						       <div class="form-group">
								  <label for="inputPassword3" class="col-sm-2 control-label">风险点描述</label>
								  <div class="col-xs-4"> 
								    <textarea rows="4" id="drisk" name="drisk"  style="width: 100%"  class="col-sm-5 control-label" cols="50" ></textarea>
								  </div>
								   <label for="inputPassword3" class="col-sm-3 control-label">防范措施</label>
								  <div class="col-xs-4"> 
								    <textarea rows="4" id="driskprevention" name="driskprevention" style="width: 100%"   class="col-sm-5 control-label" cols="50"></textarea>
								  </div>
						      </div>
						       <blockquote>
						      <p>社会交往风险</p>
						    </blockquote>
						       <div class="form-group">
								  <label for="inputPassword3" class="col-sm-2 control-label">风险点描述</label>
								  <div class="col-xs-4"> 
								    <textarea rows="4" id="jrisk" name="jrisk"  style="width: 100%"  class="col-sm-5 control-label" cols="50" ></textarea>
								  </div>
								   <label for="inputPassword3" class="col-sm-3 control-label">防范措施</label>
								  <div class="col-xs-4"> 
								    <textarea rows="4" id="jriskprevention" name="jriskprevention" style="width: 100%"   class="col-sm-5 control-label" cols="50"></textarea>
								  </div>
						      </div>
							<input type="hidden" id="fuid" name="fuid">
							<input type="hidden" id="perid" name="perid">
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
	<div class="modal fade" id="Modal_detail" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<div class="box-header with-border" style="border-bottom:0px">
						<button type="button" class="close" style="z-index: 1000" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<i class="fa fa-tv"></i>
						<h3 class="box-title">人员详情</h3>
					</div>
				</div>
				<div class="modal-body">
					<div class="panel-body" style="padding: 0px;font-size: 12px">
						<dl class="dl-horizontal">
							<dt>姓名</dt>
							<dd id="d_name"></dd>
							<dt>警号</dt>
							<dd id="d_policenum"></dd>
							<dt>办公内线</dt>
							<dd id="d_inside"></dd>
							<dt>职务</dt>
							<dd id="d_duties"></dd>
							<dt>办公外线</dt>
							<dd id="d_outside"></dd>
							<dt>短号</dt>
							<dd id="d_cornet"></dd>
							<dt>邮箱</dt>
							<dd id="d_email"></dd>
							<dt>手机</dt>
							<dd id="d_iphone"></dd>
							<dt>房间号</dt>
							<dd id="d_roomnumber"></dd>
							<dt>传真</dt>
							<dd id="d_fax"></dd>
							<dt>单位</dt>
							<dd id="d_unit"></dd>
							<dt>身份证</dt> 
							<dd id="d_idcard"></dd>
						</dl>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				</div>
			</div>
		</div>
	</div>
	  
	  
	<!-- DataTable插件 -->
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/datatables/jquery.dataTables.min.js"></script>
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/datatables/dataTables.bootstrap.min.js"></script>
	<!-- js分页模板 -->  
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/handlebars-v3.0.1.js"></script>
	<!--定义操作列按钮模板--> 
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/bootstrap-switch-master/dist/js/bootstrap-switch.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/dist/js/demo.js"></script> 
	<!-- Select2 -->
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/select2/select2.full.min.js"></script>
	
	<script id="tpl" type="text/x-handlebars-template">
    <div class="btn-group"> 
		<button type="button" class="btn btn-sm btn-primary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> 
   		 操作<span class="caret"></span>
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
	 
	$.fn.modal.Constructor.prototype.enforceFocus = function () {$(".select2").select2(); };
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
			 $("input[name='mySwitch']").each(function(){
				 $(this).bootstrapSwitch({
					});   
				 $(this).on('switchChange.bootstrapSwitch', function(event, state) {
					 $.ajax({
						 url:"<%=basePath%>backstage/policeofficer/change.html",
						 data:{"fuid":this.value,"state":state},
						 dataType:"json",
						 success:function(res){
						 }
					 }); 
				});
			 });
	     },
		 "aaSorting" : [[2, "desc"]],    //默认按此列排序
        "ajax": "<%=basePath%>backstage/policeofficer/getDate.html",
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
						  { "data": "policenum",
								"title" : "警号" },
						  { "data": "duties",
								"title" : "职务" },
						  { "data": "cornet",
								"title" : "短号" },
						  { "data": "iphone",
								"title" : "手机" }, 
						  { "data": "unit",
								"title" : "所属单位" },
					  { "data" : null,
						"title" : "操作"
						}],
		"columnDefs": [ 
					{ "bSortable": false, "aTargets": [ 0,4,5,7 ] },   //不排序的列
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
	                        targets:7, 
	                        render: function (data, type, row,   meta) {
	                            var context =
	                            {
	                                func: [
	                                    {"name": "风险排查","fn": "edit(\'" + row.fuid + "\')", "type": "primary"}
	                                   
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
	 
	 $("#save").click(add); 
	  
	 $("input[type=search]").attr("placeholder","请输入名称或警号或手机");
 })

 	 
 	/**
     * 添加数据
     **/
    function add() {
        $.ajax({
            url:"/backstage/policeofficer/savePC.html",
            data: $("#editForm").serialize(),
            dataType:"text",
            success: function (data) { 
            	table.api().ajax.reload(null, false); 
                $("#myModal").modal("hide");
            }
        });
    }

    /**
     *编辑方法
     **/
    function edit(fuid) {
    	$.ajax({
    		url:"<%=basePath%>backstage/policeofficer/RiskPc.html",
    		data:{"fuid":fuid},
    		dataType:"json",
    		success:function(s){
    	        $("#myModalLabel").text("风险排查");
    	        $("#name").val(s.name);
    	        $("#fuid").val(s.fuid);  
    	        $("#perid").val(s.perid);
    	        $("#duties").val(s.duties);
    	        $("#unit").val(s.unit);
    	        $("#responsibilities").val(s.responsibilities);
    	        $("#cornet").val(s.srisk);
    	        $("#sriskprevention").val(s.sriskprevention);
    	        $("#zrisk").val(s.zrisk);
    	        $("#zriskprevention").val(s.zriskprevention);
    	        $("#drisk").val(s.drisk);
    	        $("#driskprevention").val(s.driskprevention);
    	        $("#jrisk").val(s.jrisk);    
    	        $("#jriskprevention").val(s.jriskprevention);    
    	        $("#myModal").modal("show"); 
    		}
    	});
    }
 
    /**
     * 清除
     */ 
    function clear() {
    	$(".modal-content").find("input").each(function (){
    		$(this).val("");
    	}) 
    	$(".modal-content").find("textarea").each(function (){
    		$(this).val("");
    	})
    	
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
            url: "<%=basePath%>backstage/policeofficer/delete.html",
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
	 		url:"<%=basePath%>backstage/policeofficer/getEditData.html",
	 		type: 'post',
	 		data:{"fuid":fuid},
	 		dataType:"json", 
	 		success:function(res){
	 			var s = res.data.policeofficer;
	 				$("#d_name").html(s.name);  
	 				$("#d_policenum").html(s.policenum);  
	 				$("#d_inside").html(s.inside);  
	 				$("#d_duties").html(s.duties);  
	 				$("#d_outside").html(s.outside);  
	 				$("#d_cornet").html(s.cornet);  
	 				$("#d_email").html(s.email);  
	 				$("#d_iphone").html(s.iphone);  
	 				$("#d_roomnumber").html(s.roomnumber);  
	 				$("#d_fax").html(s.fax);  
	 				$("#d_unit").html(s.unit);  
	 				$("#d_idcard").html(s.idcard);  
	 	        $("#Modal_detail").modal("show");  
	 		}
	 	}); 
	}
	</script>
</body>
</html>
	 
