 
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
<title>警队问题 | 管理</title>
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
 
input{ 
	width: auto!important;
} 
.form-group label{
	width: 100px!important;
	font-weight: normal!important;
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
					警队问题 <small>管理</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="<%=basePath%>backstage/index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
					<li><a href="<%=basePath%>backstage/fvisits/show.html">信访管理</a></li>
					<li class="active">列表</li>
				</ol>
			</section>

			<!-- content -->
			<section class="content">
				<div class="row">
					<div class="col-xs-12">
						<div class="box">  
							<div class="box-header">
								<h3 class="box-title">列表</h3>
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
		<div class="modal-dialog" style="width:1000px">
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
						        <label for="inputPassword3" class="col-sm-2 control-label">信访编号</label>
						         <div class="col-xs-4">   
						        	 <input type="text" class="form-control" id="xno" name="xno" placeholder="">
								  </div> 
								   <label for="inputPassword3" class="col-sm-2 control-label">信访类别</label>
								  <div class="col-xs-4">
								    <input type="text" class="form-control" id="xcode" name="xcode" placeholder="">
								  </div>
								  <label for="inputPassword3" class="col-sm-2 control-label">信访状态</label>
								  <div class="col-xs-4">
								    <input type="text" class="form-control" id="xstatus" name="xstatus" placeholder="">
								  </div>
						      </div>
						      <blockquote>
						      <p>信访人信息</p>
						    </blockquote>
						      <div class="form-group">
								  <label for="inputPassword3" class="col-sm-2 control-label">信访人</label>
								  <div class="col-xs-4">
								    <input type="text" class="form-control" id="fname" name="fname" placeholder="">
								  </div>
								  <label for="inputPassword3" class="col-sm-2 control-label">信访人户籍</label>
								  <div class="col-xs-4">
								    <input type="text" class="form-control" id="household" name="household" placeholder="">
								  </div>  
						      </div> 
						     <blockquote>  
						      <p>信访事项信息</p> 
						    </blockquote>
						    <div class="form-group">
								  <label for="inputPassword3" class="col-sm-2 control-label">来访人数</label>
								  <div class="col-xs-4">
								    <input type="number" class="form-control" id="pnumber" name="pnumber" placeholder="">
								  </div>
								  <label for="inputPassword3" class="col-sm-2 control-label">信访日期</label>
								  <div class="col-xs-4">
								    <input type="text" class="form-control" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:true})"  id="xdate" name="xdate" placeholder="">
								  </div>  
								  <label for="inputPassword3" class="col-sm-2 control-label">问题发生地</label>
								  <div class="col-xs-4">
								    <input type="text" class="form-control" id="adress" name="adress" placeholder="">
								  </div> 
						      </div>
						       <div class="form-group">
								  <label for="inputPassword3" class="col-sm-2 control-label">信访目的</label>
								  <div class="col-xs-4">
								    <input type="text" class="form-control" id="purpose" name="purpose" placeholder="">
								  </div>
						      </div>
						       <div class="form-group">
								  <label for="inputPassword3" class="col-sm-2 control-label">信访内容</label>
								  <div class="col-xs-4"> 
								    <textarea rows="4" id="fcontet" name="fcontet"  class="form-control" cols="90"></textarea>
								  </div>
						      </div>
						       <blockquote>
						      <p>信访办理</p>
						    </blockquote>
						    <div class="form-group">
								  <label for="inputPassword3" class="col-sm-2 control-label">登记人</label>
								  <div class="col-xs-4">
								    <input type="text" class="form-control" id="rperson" name="rperson" placeholder="">
								  </div>
								  <label for="inputPassword3" class="col-sm-2 control-label">限结天数</label>
								  <div class="col-xs-4">
								    <input type="number" class="form-control" id="xdays" name="xdays" placeholder="">
								  </div>  
								  <label for="inputPassword3" class="col-sm-2 control-label">承办单位</label>
								  <div class="col-xs-4">
								    <input type="text" class="form-control" id="contractors" name="contractors" placeholder="">
								  </div> 
						      </div>
						      <div class="form-group">
								  <label for="inputPassword3" class="col-sm-2 control-label">办结状态</label>
								  <div class="col-xs-4">
								    <input type="text" class="form-control" id="bstatus" name="bstatus" placeholder="">
		 						  </div>
								  <label for="inputPassword3" class="col-sm-2 control-label">办结时间</label>
								  <div class="col-xs-4">
								    <input type="text" class="form-control"  onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:true})"  id="bdate" name="bdate" placeholder="">
								  </div>  
						      </div>
						        <div class="form-group">
								  <label for="inputPassword3" class="col-sm-2 control-label">办理过程</label>
								  <div class="col-xs-4"> 
								    <textarea rows="4"  class="form-control" id="process" name="process" cols="90"></textarea>
								  </div>
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
	<!-- Modal detail -->

	<!-- DataTable插件 -->
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/datatables/jquery.dataTables.min.js"></script>
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/datatables/dataTables.bootstrap.min.js"></script>
	<!-- js分页模板 --> 
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/handlebars-v3.0.1.js"></script>
	<!--定义操作列按钮模板-->
	<script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/dist/js/demo.js"></script> 
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
		 "aaSorting" : [[4, "desc"]],    //默认按此列排序
        "ajax": "<%=basePath%>backstage/fvisits/getDate.html",
        "columns": [{ "data": null, 
       	  			"title" : "<input id='changeAll'  onclick='changeAll()' type='checkbox'/>",
       	  			"createdCell" : function(nTd, sData, oData,
								iRow, iCol) {
							var startnum = this.api().page()
									* (this.api().page.info().length);   
							$(nTd).html("<input name='_change' value='"+oData.fuid+"'  type='checkbox'/>"); // 分页行号累加：$(nTd).html(iRow+1);
						}},
						  { "data": "xno",
								"title" : "编号" },
						  { "data": "fname",
								"title" : "信访人" },
						  { "data": "xcode",
								"title" : "信访分类" },
						  { "data": "xdate",
								"title" : "信访日期" },
						  { "data": "xstatus",
								"title" : "信访状态" },
						  { "data": "xdays",
								"title" : "限结天数" },
						  { "data": "rperson",
								"title" : "登记人" },
						  { "data": "bstatus",
								"title" : "办结状态" },
						  { "data": "isreported",
								"title" : "领导批示" },
					  { "data" : null,
						"title" : "操作"
						}],
		"columnDefs": [ 
					{ "bSortable": false, "aTargets": [ 0,10 ] },   //不排序的列
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
						  targets: 4,
						  render: function(data,type,row,meta){ 
							  var javascriptDate = new Date(data);
					            javascriptDate = javascriptDate.getFullYear() + "/" + (javascriptDate.getMonth()  + 1) + "/" + javascriptDate.getDate() ;
					            return javascriptDate;
						  }
					  }, 
					  { 
						  targets: 3,
						  render: function(data,type,row,meta){ 
							  	if(data.length>7){ 
							  		 return data.substring(0,7)+"...";
							  	}else{
							  		 return data;
							  	}
					           
						  }
					  }, 
					  { 
						  targets: 9,
						  render: function(data,type,row,meta){ 
							  var context;
							  if(data==1){
								  context = '<span class="label label-warning">是</span>';  
							  }else{ 
								  context = '<span class="label label-success">否</span>';  
							  }
							  return context;
						  }
					  }, 
					  {
	                        targets:10, 
	                        render: function (data, type, row,   meta) {
	                            var context =
	                            {   
	                            		 func: [
	   	                                     {"name": "查看详情", "fn": "showDetail(\'" + row.fuid + "\')", "type": "info"} ,
	   	                                    <c:if test="${com.hisOther['bu_report']}">  
	   	                            		   {"name": "上报领导","fn": "reported(\'" + row.fuid + "\')", "type": "primary"},
	   	                            		  </c:if>
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
	 
	 $("input[type=search]").attr("placeholder","请输入信访人或编号或分类");
 })
 
 	 
 	/**
     * 添加数据
     **/
    function add() {
		if(!vi()){
			return; 
		}
        $.ajax({
            url:"/backstage/fvisits/edit.html",
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
    		url:"<%=basePath%>backstage/fvisits/getEditData.html",
    		data:{"fuid":fuid},
    		dataType:"json",
    		success:function(res){
    			var s = res.data.fvisits;
    			editFlag = true;
    	        $("#myModalLabel").text("修改");
    	        $("#fuid").val(s.fuid);
    	        $("#xno").val(s.xno);
    	        $("#fname").val(s.fname);
    	        $("#household").val(s.household);
    	        $("#adress").val(s.adress);
    	        $("#xcode").val(s.xcode);
    	        $("#pnumber").val(s.pnumber);
    	        $("#purpose").val(s.purpose);
    	        $("#xdate").val(timeForm(s.xdate));
    	        $("#xstatus").val(s.xstatus);
    	        $("#xdays").val(s.xdays);
    	        $("#rperson").val(s.rperson);
    	        $("#fcontet").val(s.fcontet);
    	        $("#bstatus").val(s.bstatus);
    	        $("#bdate").val(timeForm(s.bdate)); 
    	        $("#contractors").val(s.contractors);
    	        $("#process").val(s.process);
    	        $("#isreported").val(s.isreported);
    	        $("#instructions").val(s.instructions);
     	        $("#myModal").modal("show"); 
    		}
    	});
    }

    /**
     * 字段验证
     */ 
  function vi(){
	  var t=true;
	  if($("input[name='xno']").val().length == 0){
		 layer.msg("请输入编号");
		 t=false;
	  } 
	  if($("input[name='fname']").val().length == 0){
		 layer.msg("请输入信访人");
		 t=false;
	  } 
	  if($("input[name='xdate']").val().length == 0){
		 layer.msg("请输入信访日期");
		 t=false;
	  } 
	  if($("input[name='rperson']").val().length == 0){
		 layer.msg("请输入登记人");
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
            url: "<%=basePath%>backstage/fvisits/delete.html",
            data: {
                "fuid": fuid
            }, success: function (data) {
            	table.api().ajax.reload(null, false); 
            }
        });
    }
    
    function reported(fuid){
    	if (!confirm("确认要上报领导？")) {
            return;
        }
    	
        $.ajax({
            url: "<%=basePath%>backstage/fvisits/reported.html",
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
	        	//var cdate = new Date(s.createTime);
	        	//$("#d_createTime").html(cdate.getFullYear()+"-"+(cdate.getMonth()+1)+"-"+cdate.getDate());
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
	</script>

</body>
</html>
	 
