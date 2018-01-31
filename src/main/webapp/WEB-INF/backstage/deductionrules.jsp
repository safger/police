 
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
</style>
</head>
<body class="hold-transition skin-blue sidebar-mini"> 
	<div class="wrapper">

		<jsp:include page="../system/head.jsp" />
		<c:import url="/system/menuData.html"></c:import> 
		<div class="content-wrapper">
			<section class="content-header">
				<h1>
					警队数据管理 <small>记分依据</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="<%=basePath%>backstage/index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
					<li><a href="<%=basePath%>backstage/deductionrules/show.html">记分依据管理</a></li>
					<li class="active">数据列表</li>
				</ol>
			</section>

			<!-- content -->
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header">
								<h3 class="box-title">规章记分列表</h3>
								<div class="ibox-tools rboor">
			                        <a href="#" class="btn btn-primary btn-xs p310" data-toggle="modal" data-target="#myModal"><i class="fa fa-plus"></i> 新增</a> 
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
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">新增</h4>
				</div>
				<form id="editForm">
					<div class="modal-body">
						<div class="box-body">
							<div class="form-group">
								<label for="exampleInputEmail1">标题 </label> <input type="text" class="form-control"  id="title" name="title" placeholder="请输入标题">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">规章 </label> <div id="_select"></div>
							</div>
							<div class="form-group"> 
								<label for="exampleInputEmail1">分值 </label> <input type="text"  class="form-control" id="score" name="score" placeholder="请输入分值">
							</div>
							<div class="form-group"> 
								<label for="exampleInputEmail1">排序 </label> <input type="number"  class="form-control" id="sortcode" name="sortcode" placeholder="请输入排序码">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">内容 </label>
								<textarea rows="3" cols="4" class="form-control" id="content" name="content" placeholder="请输入内容"></textarea>
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
							<dt>标题</dt>
							<dd id="d_title"></dd>
							<dt>规章</dt>
							<dd id="d_regulations"></dd>
							<dt>分值</dt>
							<dd id="d_score"></dd>
							<dt>内容</dt>
							<dd id="d_content"></dd>
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
	<!-- Modal detail -->

	<!-- DataTable插件 -->
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/datatables/jquery.dataTables.min.js"></script>
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/datatables/dataTables.bootstrap.min.js"></script>
	<!-- js分页模板 --> 
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/handlebars-v3.0.1.js"></script>
	<!--定义操作列按钮模板-->
	<script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/dist/js/demo.js"></script> 
	<script type="text/javascript" language="javascript" src="<%=basePath%>system/JsContext/DictionaryData.html"></script>
	 <script src="<%=basePath%>js/common/AutoSelect.js"></script> 
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
	  
	 $("#_select").AutoSelect({ 
			data : basetemp, // 数据源  
			initCode : "001", // 初始代码值
			showNum : 2, // 第几级开始显示 
			name : "regulations", // 生成select name属性
			disabled : 0      // 能否选择 数字为极数
		}); 
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
						 url:"<%=basePath%>backstage/deductionrules/change.html",
						 data:{"fuid":this.value,"state":state},
						 dataType:"json",
						 success:function(res){
						 }
					 }); 
				});
			 });
	     }, 
		 "aaSorting" : [[4, " asc"]],    //默认按此列排序
        "ajax": "<%=basePath%>backstage/deductionrules/getDate.html",
        "columns": [{ "data": null, 
       	  			"title" : "<input id='changeAll'  onclick='changeAll()' type='checkbox'/>",
       	  			"createdCell" : function(nTd, sData, oData,
								iRow, iCol) {
							var startnum = this.api().page()
									* (this.api().page.info().length);   
							$(nTd).html("<input name='_change' value='"+oData.fuid+"'  type='checkbox'/>"); // 分页行号累加：$(nTd).html(iRow+1);
						}},
						  { "data": "title",
								"title" : "标题" },
						  { "data": "regulations",
								"title" : "规章" },
						  { "data": "score",
								"title" : "分值" },
							{ "data": "sortcode",
									"title" : "排序" },
						  { "data": "content",
								"title" : "内容" },
						  { "data": "modifydate",
								"title" : "修改时间" },
					  { "data" : null,
						"title" : "操作"
						}],
		"columnDefs": [ 
					{ "bSortable": false, "aTargets": [ 0,7 ] },   //不排序的列
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
						  targets: 5,
						  render: function(data,type,row,meta){ 
							  	if(data!=null&&data.length>25){
							  		data=data.substring(0,25)+"...";
							  	}
					            return data;
						  }
					  }, 
					 { 
						  targets: 6,
						  render: function(data,type,row,meta){ 
							  var javascriptDate = new Date(data);
					            javascriptDate = javascriptDate.getFullYear() + "/" + (javascriptDate.getMonth()  + 1) + "/" + javascriptDate.getDate() + " " + javascriptDate.getHours() + ":" + javascriptDate.getMinutes() + ":" + javascriptDate.getSeconds();
					            return javascriptDate;
						  }
					  }, 
					  {
	                        targets:7, 
	                        render: function (data, type, row,   meta) {
	                            var context =
	                            {
	                            		 func: [
	   	                                     {"name": "查看详情", "fn": "showDetail(\'" + row.fuid + "\')", "type": "info"} ,
	   	                                    {"name": "修改","fn": "edit(\'" + row.fuid + "\')", "type": "primary"},
	   	                                    {"name": "删除", "fn": "del(\'" + row.fuid + "\')", "type": "danger"}
	   	                                   
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
	 
	 $("input[type=search]").attr("placeholder","请输入名称");
 })

 	 
 	/**
     * 添加数据
     **/
    function add() {
		if(!vi()){
			return; 
		}
        $.ajax({
            url:"/backstage/deductionrules/edit.html",
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

    /**
     *编辑方法 
     **/
    function edit(fuid) {
    	$.ajax({
    		url:"<%=basePath%>backstage/deductionrules/getEditData.html",
    		data:{"fuid":fuid},
    		dataType:"json",
    		success:function(res){
    			var s = res.data.deductionrules;
    			editFlag = true;
    	        $("#myModalLabel").text("修改");
    	        $("#fuid").val(s.fuid);
    	        $("#title").val(s.title);
    	        $("#_select").AutoSelect({ 
    				data : basetemp, // 数据源   
    				initCode :  res.data.deductionrulesData, // 初始代码值
    				showNum : 2, // 第几级开始显示 
    				name : "regulations", // 生成select name属性
    				disabled : 0      // 能否选择 数字为极数
    			}); 
    	        $("#score").val(s.score);
    	        $("#sortcode").val(s.sortcode);
    	        
    	        $("#content").val(s.content);
     	        $("#myModal").modal("show"); 
    		}
    	});
    }
    
    /**
     * 字段验证
     */ 
  function vi(){
    	var t=true;
	  if($("input[name='title']").val().length == 0){
			layer.msg("请输入标题");
			t=false;
		} 
		if($("select[name='regulations']").val() == -1){
			layer.msg("请选择规章"); 
			t=false; 
		} 
		if($("select[name='number']").val() == -1){
			layer.msg("请输入分值"); 
			t=false;
		}
		return t;
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
            url: "<%=basePath%>backstage/deductionrules/delete.html",
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
	 		url:"<%=basePath%>backstage/deductionrules/getEditData.html",
	 		type: 'post',
	 		data:{"fuid":fuid},
	 		dataType:"json",
	 		success:function(res){
	 			var s = res.data.deductionrules;
	 				$("#d_fuid").html(s.fuid);  
	 				$("#d_title").html(s.title);  
	 				$("#d_regulations").html(s.regulations);  
	 				$("#d_score").html(s.score);  
	 				$("#d_content").html(s.content);  
	        		var cdate = new Date(s.modifydate);
	        		$("#d_modifydate").html(cdate.getFullYear()+"-"+(cdate.getMonth()+1)+"-"+cdate.getDate());
	 	        $("#Modal_detail").modal("show");  
	 		}
	 	}); 
	}
	</script>

</body>
</html>
	 
