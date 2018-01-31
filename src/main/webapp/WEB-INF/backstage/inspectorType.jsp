 
<%@ page import="java.util.*" contentType="text/html;charset=UTF-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/"; 
	String type=request.getParameter("type");
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>廉洁防疫 | 督察记录</title>
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<link rel="stylesheet" href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/datatables/dataTables.bootstrap.css">
  <link rel="stylesheet" href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/iCheck/all.css">
  <link href="<%=basePath%>js/plupload-2.1.9/jquery.plupload.queue/css/jquery.plupload.queue.css" rel="stylesheet" />
	<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>js/zoom/zoom.css">
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
.sp{
font-weight: bold;
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
					警队问题 <small>督察记录</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="<%=basePath%>backstage/index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
					<li><a href="<%=basePath%>backstage/inspector/show.html">督察情况</a></li>
					<li class="active">督察情况列表</li>
				</ol>
			</section>

			<!-- content -->
			<section class="content">
			 
				<div class="row">
					<div class="col-xs-12">
						<div class="box">
							<div class="box-header"> 
								<h3 class="box-title">督察列表</h3> 
								<div class="ibox-tools rboor"> 
									 <c:if test="${com.hisAdd}">  
			                        <a href="javascript:void(0)" onclick="addShow()" class="btn btn-primary btn-xs p310" data-toggle="modal" ><i class="fa fa-plus"></i> 新增</a> 
			                    	</c:if>
			                    </div> 
			                   <!--  <div class="ibox-tools rboor"> 
			                        <a href="javascript:void(0)" onclick="inShow()" class="btn btn-primary btn-xs p310" data-toggle="modal" >　 导入word</a> 
			                    </div> -->
			                    
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
				 
				
				<form id="editForm" enctype="multipart/form-data">
					<div class="modal-body">
						<div class="box-body">
							<div class="form-group" style="clear:both;height: 59px">
								<label for="exampleInputEmail1"  style="clear:both;display: block;">部门 </label>  
								    <select  id="department" class="form-control select2" style="width: 45%;float: left;"> 
								    	<option value="0">请选择</option> 
									  	<c:forEach var="list" items="${oragenizeAll }">
									  		<option value="${list.fuid }">${list.fullname }</option>
									  	</c:forEach>
								  </select>  
								  <div id="child" style="float: left;width: 45%"  ></div>
								  <input type="hidden"  value=""  id="department22"  name="department"  />
								  <input type="hidden" value=""  id="departmentid"  name="departmentid" />
								   <input type="hidden" value=""  id="qdepartment"   name="qdepartment" /> 
								  <input type="hidden" value=""  id="qdepartmentid"  name="qdepartmentid" />
							</div>
							<div class="form-group"  style="clear:both">
								<label for="exampleInputEmail1"  style="clear:both">问题点名称 </label> <input type="text" class="form-control" id="paddress" name="paddress" placeholder="请输入名称">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">时间 </label> <input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',readOnly:true})"   class="form-control" id="ptime" name="ptime" placeholder="请输入名称">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">问题类型 </label>
								<div class="form-control" style="border: 0px">
								  <input type="radio" name="qtype" class="minimal" checked="checked" value="1">&nbsp; 人员违规 &nbsp; <input type="radio" name="qtype"  class="minimal" value="0" >&nbsp;视频问题&nbsp; 
								</div>
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1" style="clear: both;display: block;">问题简述(可多选) </label>
								<div style="width: 45%;float: left;" id="description"></div>
								<div style="width: 45%;float: left" id="description2"></div>
								 
							</div>
							
							<div class="form-group"> 
								<label for="exampleInputEmail1" style="clear: both;display: block;">附件 </label>
								<div id="uploader" style="width: 100%">
											<p>您的浏览器不支持Flash, Silverlight, Gears, BrowserPlus 或 HTML5 技术</p>
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
	
	<div class="modal fade" id="inModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">word导入</h4> 
				</div>
				<form   enctype="multipart/form-data" id="inform" method="post"  action="<%=basePath %>/backstage/inspector/wordIn.html" >
					<div class="modal-body">
						<div class="box-body">
							 
							<div class="form-group">
								<label for="exampleInputEmail1">选择word文件</label> <input type="file" class="form-control"  name="wordfile" >
							</div>
							 
						</div> 
					</div> 
				</form>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" onclick="subIn()" class="btn btn-primary" >保存</button>
				</div>
			</div>
		</div>
	</div>
	
	<div class="modal fade" id="process" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">问题处理</h4> 
				</div>
				<form   enctype="multipart/form-data" id="proform" method="post" >
					<div class="modal-body">
						<div class="box-body">
							 <div class="form-group" style="clear:both;height: 59px">
								<label for="exampleInputEmail1"  style="clear:both;display: block;">部门 </label>  
								    <select  id="jdepartment"  class="form-control select2" style="width: 45%;float: left;"> 
								    	<option value="0">请选择</option> 
									  	<c:forEach var="list" items="${oragenizeAll }">
									  		<option value="${list.fuid }">${list.fullname }</option>
									  	</c:forEach>
								  </select>  
								  <div id="jchild" style="float: left;width: 45%"  ></div>
								  <input type="hidden"  value=""  id="jdepartmentname"  name="jdepartmentname"  />
								  <input type="hidden" value=""  id="jdepartmentid"  name="jdepartmentid" />
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">是否属实 </label> <input type="radio" class="minimal"  checked="checked"  value="1" name="istrue"  > 是&nbsp;&nbsp;&nbsp;<input type="radio" class="minimal"    value="0" name="istrue"  > 否
							</div>
							 <div class="form-group"  style="clear:both">
								<label for="exampleInputEmail1"  style="clear:both">问题责任人/单位 </label> <input type="text" class="form-control" id="cname" name="cname" placeholder="请输入名称">
								  <input type="hidden"  value=""  id="jdepartmentname"  name="jdepartmentname"  />
								  <input type="hidden" value=""  id="jdepartmentid"  name="jdepartmentid" />
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">是否民警 </label> <input type="radio" class="minimal"  checked="checked"  value="1" name="isp"  > 是&nbsp;&nbsp;&nbsp;<input type="radio" class="minimal"    value="0" name="isp"  > 否
							</div>
							 <div class="form-group">
								<label for="exampleInputEmail1" style="clear: both;display: block;">处理结果简述 </label>
								<div style="width: 45%;float: left;" id="presult"></div>
								  <input type="hidden" value="" id="proid" name="fuid" />
							</div>
						      <div class="form-group" style="clear: both;margin-top: 15px">
								<label for="exampleInputEmail1">备注 </label>
								<textarea rows="3" cols="4" class="form-control" id="cremarks" name="cremarks" ></textarea>
							</div>
						</div>  
					</div> 
				</form>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" onclick="proSub()" class="btn btn-primary" >保存</button>
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
							<dt>部门</dt>
							<dd id="d_department"></dd>
							<dt>问题监控点名称</dt>
							<dd id="d_paddress"></dd>
							<dt>发生时间</dt>
							<dd id="p_time"></dd>
							<dt>问题简述</dt>
							<dd id="d_description"></dd>
							<dt>是否处理</dt>
							<dd id="d_twice"></dd>
							<dt>录入人</dt>
							<dd id="d_entryper"></dd>
							<dt>创建时间</dt>
							<dd id="d_createdate"></dd>
							<dt>修改时间</dt>
							<dd id="d_modifydate"></dd>
							<dt>相关图片</dt>
							<dd id="d_annex"></dd> 
						</dl>
					</div>
					<div  id="ccl" style="padding: 0px;font-size: 12px;border-top: 1px solid #e5e5e5;display: none;">
						<dl class="dl-horizontal" style="margin-top: 10px">
							<dt>是否属实</dt>
							<dd id="d_istrue"></dd>
							<dt>处理责任人/单位</dt>
							<dd id="d_cname"></dd>
							<dt>是否民警</dt>
							<dd id="d_isp"></dd>
							<dt>处理结果</dt>
							<dd id="d_presult"></dd>
							<dt>备注</dt>
							<dd id="d_cremarks"></dd>
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
	<!-- iCheck 1.0.1 -->
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/iCheck/icheck.min.js"></script>
	<!--定义操作列按钮模板-->
	<script type="text/javascript" src="<%=basePath%>js/jquery.form.js"></script>
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/dist/js/demo.js"></script> 
	
	<script type="text/javascript" src="<%=basePath%>js/plupload-2.1.9/plupload.full.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/plupload-2.1.9/jquery.plupload.queue/jquery.plupload.queue.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/plupload-2.1.9/i18n/zh_CN.js"></script> 
		<script type="text/javascript" language="javascript" src="<%=basePath%>system/JsContext/DictionaryData.html"></script>
	 <script src="<%=basePath%>js/common/AutoSelect.js"></script> 
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
	 $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
	      checkboxClass: 'icheckbox_minimal-blue',
	      radioClass: 'iradio_minimal-blue'
	    });
	
	   
	 initUploader();
		 
	 
	 $("#department").change(function (){
		 var pid=$(this).val(); 
		 $("input[name='qdepartment']").val($("#department option:selected").text()); 
		 $("input[name='qdepartmentid']").val($(this).val());
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
	            		 $("input[name='department']").val($("#department1 option:selected").text());
	            		 $("input[name='departmentid']").val($(this).val());
	            	 })
	            }
	        });
		 
	 })
	 
	  $("#jdepartment").change(function (){
		 var pid=$(this).val(); 
		 $.ajax({
	            url:"/backstage/inspector/getOrChild.html",
	            data: "parentid="+pid,
	            dataType:"json",
	            success: function (data) {
	            	var ht="";
	            	 if(data!=null&&data.length>0){
	            	 	ht=' <select  id="jdepartment1" class="form-control select2" style="width: 100%"> ';
	            	 	 ht+='<option value="0">请选择</option>';
	            		 for(var a=0;a<data.length;a++){
	            			 ht+='<option value="'+data[a].fuid+'">'+data[a].fullname+'</option>'
	            		 }
	            		 ht+=' </select>'
	            	 } 
	            	 $("#jchild").html(ht);  
	            	 $("#jdepartment1").change(function (){
	            		 $("input[name='jdepartmentname']").val($("#jdepartment1 option:selected").text());
	            		 $("input[name='jdepartmentid']").val($(this).val());
	            	 })
	            }
	        });	  
		 
	 })
	 
	 $("#sdepartment").change(function (){
		 var pid=$(this).val(); 
		 $("input[name='qdepartment']").val($("#department option:selected").text()); 
		 $("input[name='qdepartmentid']").val($(this).val());
		 $.ajax({
	            url:"/backstage/inspector/getOrChild.html",
	            data: "parentid="+pid,
	            dataType:"json",
	            success: function (data) { 
	            	var ht="";
	            	 if(data!=null&&data.length>0){
	            	 	ht=' <select  id="sdepartment1" class="form-control select2" style="width: 170px"> ';
	            	 	 ht+='<option value="0">请选择</option>';
	            		 for(var a=0;a<data.length;a++){
	            			 ht+='<option value="'+data[a].fuid+'">'+data[a].fullname+'</option>'
	            		 }
	            		 ht+=' </select>'
	            	 } 
	            	 $("#schild").html(ht);  
	            }
	        });
		 
	 })
	
	 $("input[name='qtype']").each(function (i){
		 $(this).on("ifChecked", function (ent) {
                     if($(this).val()==0){
                    	 $("#description").AutoSelect({ 
     						data : basetemp, // 数据源  
     						initCode : "004", // 初始代码值
     						showNum : 2, // 第几级开始显示 
     						name : "description", // 生成select name属性
     						disabled : 0,      // 能否选择 数字为极数
     						style:"width:100%"
     					}); 
     				 	$("#description2").css("display","none");
                     }else{
                    	 $("#description").AutoSelect({ 
      						data : basetemp, // 数据源  
      						initCode : "003", // 初始代码值
      						showNum : 2, // 第几级开始显示 
      						name : "description", // 生成select name属性
      						disabled : 0,      // 能否选择 数字为极数
      						style:"width:100%"
      					});  
                    	 $("#description2").css("display","block");
                     }
               })
		
	 })
	 
	 $("#description").AutoSelect({ 
			data : basetemp, // 数据源  
			initCode : "003", // 初始代码值
			showNum : 2, // 第几级开始显示 
			name : "description", // 生成select name属性
			disabled : 0,      // 能否选择 数字为极数
			style:"width:100%"
		}); 
	 $("#description2").AutoSelect({ 
			data : basetemp, // 数据源  
			initCode : "003", // 初始代码值
			showNum : 2, // 第几级开始显示 
			name : "description2", // 生成select name属性
			disabled : 0 ,    // 能否选择 数字为极数
			style:"width:100%"
		}); 
	/*  $("#sdescription").AutoSelect({ 
			data : basetemp, // 数据源  
			initCode : "003", // 初始代码值
			showNum : 2, // 第几级开始显示 
			name : "sdescription", // 生成select name属性
			disabled : 0,      // 能否选择 数字为极数
			style:"width:100%"
		}); */
	 $("#presult").AutoSelect({ 
			data : basetemp, // 数据源  
			initCode : "005", // 初始代码值
			showNum : 2, // 第几级开始显示 
			name : "presult", // 生成select name属性
			disabled : 0,      // 能否选择 数字为极数
			style:"width:100%"
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
						 url:"<%=basePath%>backstage/inspector/change.html",
						 data:{"fuid":this.value,"state":state},
						 dataType:"json",
						 success:function(res){
						 }
					 }); 
				});
			 });
	     }, 
		 "aaSorting" : [[8, "desc"]],    //默认按此列排序
        "ajax": "<%=basePath%>backstage/inspector/getDataType.html?type=<%=type%>",
        "columns": [{ "data": null, 
       	  			"title" : "<input id='changeAll'  onclick='changeAll()' type='checkbox'/>",
       	  			"createdCell" : function(nTd, sData, oData,
								iRow, iCol) {
							var startnum = this.api().page()
									* (this.api().page.info().length);   
							$(nTd).html("<input name='_change' value='"+oData.fuid+"'  type='checkbox'/>"); // 分页行号累加：$(nTd).html(iRow+1);
						}},
							{ "data": "qdepartment",
							"title" : "县市公安局" },
						  { "data": "department",
								"title" : "部门" },
						  { "data": "paddress",
								"title" : "问题监控地点" },
						  { "data": "ptime",
								"title" : "发生时间" },
						  { "data": "description",
								"title" : "问题简述" },
						  { "data": "twice",
								"title" : "是否处理" },
						  { "data": "entryper",
								"title" : "录入人" },
							{ "data": "createdate",
									"title" : "创建时间" },
					  { "data" : null,
						"title" : "操作"
						}],
		"columnDefs": [  
					{ "bSortable": false, "aTargets": [ 0,5,9 ] },   //不排序的列
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
						  targets: 6,
						  render: function(data,type,row,meta){ 
							  if(row.twice==1){
								  return '<small class="label label-danger"></i>是</small>';  
				 				}else{
				 					return '<small class="label label-success"></i>否</small>';  
				 				}
						  }
					  },   
					  { 
						  targets: 3,
						  render: function(data,type,row,meta){ 
							  	if(data!=null&&data.length>16){
							  		data=data.substring(0,15)+"...";
							  	}  
					            return data;
						  }
					  },
					 { 
						  targets: 4,
						  render: function(data,type,row,meta){ 
					            return timeForm(data);
						  }
					  }, 
					  { 
						  targets: 8,
						  render: function(data,type,row,meta){ 
					            return timeForm(data);
						  }
					  }, 
					  {
	                        targets:9, 
	                        render: function (data, type, row,   meta) {
	                            var context =
	                            { 
	                            		 func: [
	   	                                     {"name": "查看详情", "fn": "showDetail(\'" + row.fuid + "\')", "type": "info"} ,
	   	                                  <c:if test="${com.hisUpdate}">  
	   	                              		 {"name": "修改","fn": "edit(\'" + row.fuid + "\')", "type": "primary"},
	   	                            		  </c:if>
	   	                              	<c:if test="${com.hisDelete}">  
	   	                             		{"name": "删除", "fn": "del(\'" + row.fuid + "\')", "type": "danger"},
  	                            		  </c:if>
	   	                             	 <c:if test="${com.hisOther['bu_process']}">  
 	                            		   {"name": "问题处理","fn": "process(\'" + row.fuid + "\',\'" + row.qdepartmentid + "\')", "type": "primary"},
 	                            		  </c:if>
  	                            		
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
	  
	 $(".dataTables_filter input").css({ "display" :"none" });
 })

 function gsearch(){
	var sdepartment=$("#sdepartment option:selected").val();
	var qtype=$("input[name='tp']:checked").val();
	var scl=$("input[name='scl']:checked").val();
	var sdescription=$("select[name='sdescription']").val();
	var sdescription1=$("#sdepartment1").val(); 
	var stime=$("#sstime").val()+" ";
	var etime=$("#setime").val()+" ";
	var data=sdepartment+","+qtype+","+scl+","+sdescription+","+stime+","+etime+","+sdescription1;
	table.fnFilter(data); 
} 
 	  
 	/**
     * 添加数据
     **/
    function add() {
	if(!vi()){
		return;
	}
	 var uploader = $('#uploader').pluploadQueue();
	 //判读有无图片 
     if (uploader.files.length > 0) {
         uploader.bind('StateChanged', function() {
             if (uploader.files.length === (uploader.total.uploaded + uploader.total.failed)) {
             }
         });
         uploader.start();
     } else {
    	 $.ajax({
             url:"/backstage/inspector/edit.html",
             data: $("#editForm").serialize(),
             methor:"post",     
             dataType:"json", 
             success: function (data) {
             	table.api().ajax.reload(null, false ); 
                 $("#myModal").modal("hide");
                 $("#myModalLabel").text("新增"); 
                 $("input[name='fuid']").val(data.data['id']);
                 clear();
             }
         });
	}
       
    }

function addShow(){
	var tt=$('#uploader').pluploadQueue();
	 tt.destroy(); 
	    initUploader();
	    $("#myModal").modal("show"); 
}
function inShow(){
	    $("#inModal").modal("show"); 
}
    /**
     *编辑方法
     **/
    function edit(fuid) {
    	
    	var tt=$('#uploader').pluploadQueue();
    	 tt.destroy(); 
		    initUploader();
    	//tt.destroy();
    	//tt.init();
    	$.ajax({
    		url:"<%=basePath%>backstage/inspector/getEditData.html",
    		data:{"fuid":fuid},
    		dataType:"json",
    		success:function(res){
    			var s = res.data.inspector;
    			editFlag = true;
    			
    			$("input[name='qtype']").each(function(){
    				if($(this).val()==s.qtype){
    					$(this).iCheck('check');
    				}
    			})
    			$("#description").AutoSelect({ 
					data : basetemp, // 数据源   
					initCode : s.description, // 初始代码值
					showNum : 2, // 第几级开始显示 
					name : "description", // 生成select name属性
					disabled : 0,      // 能否选择 数字为极数
					style:"width:100%"
				}); 
    			if(s.qtype==1){
    			 var d2=s.description2;
    			 d2=d2==null?"003":d2;
    			 $("#description2").AutoSelect({ 
 					data : basetemp, // 数据源   
 					initCode : d2, // 初始代码值
 					showNum : 2, // 第几级开始显示 
 					name : "description2", // 生成select name属性
 					disabled : 0 ,     // 能否选择 数字为极数
 					style:"width:100%"
 				});
    			} 
    			 
    	        $("#myModalLabel").text("修改");
    	        $("#fuid").val(s.fuid);
    	        $("#paddress").val(s.paddress);
    	      	var cdate = new Date(s.ptime); 
	        	$("#ptime").val(timeForm(s.ptime,"ss"));
    	        $("#description").val(s.description);
    	        $("#twice").val(s.twice);  
    	        $("#entryper").val(s.entryper); 
    	        $("#department22").val(s.department); 
    	        $("#departmentid").val(s.departmentid);
    	        $("#qdepartment").val(s.qdepartment); 
    	        $("#qdepartmentid").val(s.qdepartmentid);
     	        $("#myModal").modal("show");  
     	        
    		}
    	});
    }

    /**
     * 清除
     */ 
    function clear() {
    	$(".modal-content").each(function (){
    		$(this).find("input").each(function (){
        		if($(this).attr("name")!="type"&&$(this).attr("type")!="radio"){
        			$(this).val("");
        		} 
        		
        	}) 
        	$(this).find("textarea").each(function (){
    			$(this).val("");
    		})
    	})
    	 $("input[name='fuid']").val("");  
    	$("#department option:first").prop("selected", 'selected');
    	$("#department1").remove();
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
            url: "<%=basePath%>backstage/inspector/delete.html",
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
	 		url:"<%=basePath%>backstage/inspector/getEditData.html",
	 		type: 'post',
	 		data:{"fuid":fuid},
	 		dataType:"json",
	 		success:function(res){
	 			var s = res.data.inspector;
	 				$("#d_department").html(s.department);  
	 				$("#d_paddress").html(s.paddress);  
	 				
	 				$("#d_description").html(s.entryid);
	 				
	 				$("#d_cname").html(s.cname);
	 				$("#d_cold").html(s.cold);
	 				var isp=s.isp;
	 				isp=isp==1?"是":"否"; 
	 				$("#d_isp").html(isp);
	 				
	 				var istrue=s.istrue;
	 				istrue=istrue==1?"是":"否"; 
	 				$("#d_istrue").html(istrue);
	 				$("#d_presult").html(s.presult);
	 				
	 				$("#d_cremarks").html(s.cremarks);
	 				
	 				if(s.twice==1){
	 					$("#d_twice").html('<small class="label label-danger"></i>是</small>'); 
	 					$("#ccl").css("display","block");
	 				}else{
	 					$("#d_twice").html('<small class="label label-success"></i>否</small>');  
	 					$("#ccl").css("display","none");
	 				} 
					
	 				var d_annex=s.annex; 
	 				if(d_annex!=null&&d_annex.length>0){
	 					var an=d_annex.split(",");
		 				var ht=""; 
	 					for(var a=0;a<an.length;a++){ 
		 					ht+='<div class="row">';
		 					ht+='<div class="col-xs-6"   >';
		 					ht+='<a href="#" class="thumbnail">';
		 					ht+='<img data-action="zoom" src="<%=basePath%>material/'+an[a]+'" >';
		 					ht+='</a>';
		 					ht+='</div>';  
		 					ht+='</div>';
		 					//ht+='<img alt="" width="100px" src="<%=basePath%>material/'+an[a]+'" />';
		 				}
	 					$("#d_annex").html(ht);  
	 				}else{
	 					$("#d_annex").html("暂无图片");
	 				}
	 				
	 				
	 				
	 				$("#d_entryper").html(s.entryper);   
		        	$("#p_time").html(timeForm(s.ptime));
		        	$("#d_createdate").html(timeForm(s.createdate));  
		        	$("#d_modifydate").html(timeForm(s.modifydate));
	 	        $("#Modal_detail").modal("show");  
	 		}
	 	}); 
	}
    
     
    
    var initUploader = function () {
		 $("#uploader").pluploadQueue({
	         runtimes: 'html5,gears,flash,silverlight,browserplus', // 这里是说用什么技术引擎
	         url: '<%=basePath%>backstage/inspector/upload.html', // 服务端上传路径
	         max_file_size: '3000mb', // 文件上传最大限制。
	         chunk_size: '2mb', // 上传分块每块的大小，这个值小于服务器最大上传限制的值即可。
	         unique_names: true, // 上传的文件名是否唯一
	         multi_selection:true, //选择多个文件
	         multipart:true, 
	         //// 是否生成缩略图（仅对图片文件有效） 
	         //resize: { width: 320, height: 240, quality: 90,preserve_headers: true },
	         //自定义参数
	         multipart_params: {
					 "fuid":$("#fuid").val()
				},
	         //  这个数组是选择器，就是上传文件时限制的上传文件类型
	          filters: [ 
					{ title: "Image files", extensions: "jpg,gif,png,jpeg" }
					//{ title: "Zip files", extensions: "zip,rar,7z" },
					//{ title: "iso files", extensions: "iso" }
					], 
	         // plupload.flash.swf 的所在路径
	         flash_swf_url: '<%=basePath%>js/plupload-2.1.9/Moxie.swf', 
	         // silverlight所在路径
	         silverlight_xap_url: '<%=basePath%>js/plupload-2.1.9/Moxie.xap',
	         init : {
	        	 	//上传完成保持数据
					UploadComplete : function(up, file) {
						 $.ajax({
					            url:"/backstage/inspector/saveImg.html",
					            data: "fuid="+$("input[name='fuid']").val(),
					            dataType:"json",
					            success: function (data) {
					            	 clear(); 
					            } 
					        });
						
				    },
				    //上传前事件
				    BeforeUpload: function (uploader,file){
				    	//保存现有数据
				    	 $.ajax({
				             url:"/backstage/inspector/edit.html",
				             data: $("#editForm").serialize(),
				             dataType:"json",
				             success: function (data) {
				            	 table.api().ajax.reload(null, false );  
		                         $("#myModal").modal("hide");
		                         $("#myModalLabel").text("新增");
		                         $("input[name='fuid']").val(data.data['id']);
				             }
				         });
				    }
				 } 
	     });
	 }
    
    function subIn(){
    	
    	$("#inform").submit();
    }
     
   function process(fuid,departmentid){
	   $("#proid").val(fuid);
	   $("#jdepartment").val(departmentid); 
	   $("#jdepartment").trigger('change');
	   $("#process").modal("show");  
   } 
   function proSub(){
	  /*  var cname=$("input[name='cname']").val();
	   if(cname.length==0){ 
		   layer.msg("请输入姓名");
		   return;
	   }
	   var jdepartmentname=$("#jdepartmentname").val();
	   if(cname.length==0){ 
		   layer.msg("请选择部门");
		   return;
	   } */
	   
	   $.ajax({
           url:"<%=basePath %>/backstage/inspector/process.html",
           data: $("#proform").serialize(),
           methor:"post",     
           dataType:"json", 
           success: function (data) {
           	table.api().ajax.reload(null, false ); 
               $("#process").modal("hide");
               clear();
           }
       });
   }
   
 //时间格式化
   function timeForm(date,type){ 
   	if(date!=null){
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
   	    
   	     if(type!=null){
   	    	 bdate = bdate.getFullYear() + "-" + mm + "-" + d +" "+h+":"+m+":"+s;
   	     }else{
   	    	 bdate = bdate.getFullYear() + "-" + mm + "-" + d +" "+h+":"+m;
   	     }
   	     
       	return bdate;
   	}else{
   		return "";
   	}
 }
 
   /**
     * 字段验证
     */ 
  function vi(){
	  var t=true;
	  if($("input[name='qdepartment']").val().length == 0){
		 layer.msg("请选择部门");
		 t=false;
	  } 
	  if($("input[name='paddress']").val().length == 0){
		 layer.msg("请输入问题点名称");
		 t=false;
	  }  
	   if($("input[name='ptime']").val().length == 0){
		 layer.msg("请选择时间");
		 t=false;
	  }  
	  return t;
    }  
	</script>

</body>
</html>
	 
