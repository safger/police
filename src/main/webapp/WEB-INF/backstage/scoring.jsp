 
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
<title>警务督察</title>
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<link rel="stylesheet" href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/datatables/dataTables.bootstrap.css">
  <link rel="stylesheet" href="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/iCheck/all.css">
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
					警务督察 <small>记分通知书</small>
				</h1>
				<ol class="breadcrumb">
					<li><a href="<%=basePath%>backstage/index.html"><i class="fa fa-dashboard"></i> 首页</a></li>
					<li><a href="<%=basePath%>backstage/scoring/show.html">管理</a></li>
					<li class="active">列表</li>
				</ol>
			</section>

			<!-- content -->
			<section class="content">
				<div class="box box-default collapsed-box">
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
		                   <span class="sp" >职务类型：</span> 	  <input type="radio" name="ischief" class="minimal" checked="checked" value="2"> 所有 <input type="radio" name="ischief" class="minimal"   value="2">&nbsp; 中层正职 &nbsp; <input type="radio" name="ischief"  class="minimal" value="1" >&nbsp;中层副职&nbsp;<input type="radio" name="ischief"  class="minimal" value="0" >&nbsp;无 
		                </div>    
		               <div class="col-xs-3">
		               	 <span class="sp" >是否民警：</span>  <input type="radio" name="ispolice" class="minimal" checked="checked" value="2"> 所有 <input type="radio" name="ispolice" class="minimal"   value="1">&nbsp; 是&nbsp; <input type="radio" name="ispolice"  class="minimal" value="0" >&nbsp;否&nbsp;
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
		                 	<button onclick="gsearch()" style="width: 100px;display: inline;" class="btn btn-block btn-primary">查询</button>
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
			                        <a href="javascript:void(0)" class="btn btn-primary btn-xs p310" data-toggle="modal" data-target="#myModal"><i class="fa fa-plus"></i> 新增</a> 
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
							<div class="form-group" style="clear:both;height: 59px">
								<label for="exampleInputEmail1"  style="clear:both;display: block;">对象部门 </label>  
								    <select  id="department" class="form-control select2" style="width: 45%;float: left;"> 
								    	<option value="0">请选择</option> 
									  	<c:forEach var="list" items="${oragenizeAll }">
									  		<option value="${list.fuid }">${list.fullname }</option>
									  	</c:forEach>
								  </select>   
								  <div id="child" style="float: left;width: 45%"  ></div>
								  <input type="hidden"  value=""  id="department22"  name="jdepartmentname"  />
								  <input type="hidden" value=""  id="jdepartmentid"  name="jdepartmentid" /> 
								   <input type="hidden" value=""  id="jqdepartmentname"   name="jqdepartmentname" /> 
								  <input type="hidden" value=""  id="jqdepartmentid"  name="jqdepartmentid" />
							</div>
							<div class="form-group">  
								<label for="exampleInputEmail1">对象 </label> <input type="text" class="form-control" id="jname" name="jname" placeholder="">
								<input type="hidden" value="<%=type %>" name="type" /> 
							</div> 
							<div class="form-group">
								<label for="exampleInputEmail1">是否民警 </label> <input type="radio" class="minimal"  checked="checked"  value="1" name="ispolice"  > 是&nbsp;&nbsp;&nbsp;<input type="radio" class="minimal"    value="0" name="ispolice"  > 否
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">性&nbsp;&nbsp;别 </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" checked="checked"  class="minimal"  value="1" name="sex"  > 男&nbsp;&nbsp;&nbsp;<input type="radio" class="minimal"   value="0" name="sex"  > 女
							</div>
							
							<%if(type!=null&&type.equals("002001")){ %>
							<div class="form-group">
								<label for="exampleInputEmail1">分值 </label> <input type="number" class="form-control" id="score" name="score" placeholder="">
							</div>
							<%} %>
							<div class="form-group">
								<label for="exampleInputEmail1">职务类型</label> <input type="radio" class="minimal"   value="2" name="ischief"  > 中层正职&nbsp;&nbsp;&nbsp; <input type="radio" class="minimal"    value="1" name="ischief"  > 中层副职&nbsp;&nbsp;&nbsp;<input type="radio" class="minimal"  checked="checked"   value="0" name="ischief"  >  无
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">职务 </label> <input type="text" class="form-control" id="duties" name="duties" placeholder="">
							</div>
							<%if(type!=null&&type.equals("002002")){ %>
							<div class="form-group">
								<label for="exampleInputEmail1">停职时间  </label>
								<div style="width: 100%">
								 <input style="width: 40%;display:inline" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" type="text" class="form-control" id="dstime" name="dstime" placeholder="请选择开始时间"  >&nbsp; - &nbsp;<input  style="width: 40%;display:inline"  onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" type="text" class="form-control" id="detime" name="detime"  placeholder="请选择结束时间"  >
								</div>
								   
							</div> 
							<%} %>
							<%if(type!=null&&type.equals("002003")){ %>
							<div class="form-group">
								<label for="exampleInputEmail1">禁闭时间  </label>
								<div style="width: 100%">
								 <input style="width: 40%;display:inline" onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" type="text" class="form-control" id="dstime" name="dstime" placeholder="请选择开始时间"  >&nbsp; - &nbsp;<input  style="width: 40%;display:inline"  onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" type="text" class="form-control" id="detime" name="detime"  placeholder="请选择结束时间"  >
								</div>
								   
							</div> 
							<%} %>
							<div class="form-group">
								<label for="exampleInputEmail1" style="clear: both;">督察人员 </label> <input type="text" class="form-control" id="inspectors" name="inspectors" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">签发人 </label> <input type="text" class="form-control" id="signer" name="signer" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">签发时间 </label> <input onFocus="WdatePicker({dateFmt:'yyyy-MM-dd'})" type="text" class="form-control" id="stime" name="stime" placeholder="">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">原因 </label> 
								<textarea rows="3" cols="4" class="form-control" id="reason" name="reason" placeholder="请输入原因"></textarea>
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
							<dt>所属部门</dt>
							<dd id="d_departmentname"></dd>
							<dt>对象</dt>
							<dd id="d_jname"></dd>
							<dt>性别</dt>
							<dd id="d_sex"></dd>
							<dt>职务类别</dt>
							<dd id="d_ischief"></dd>
							<dt>职务</dt>
							<dd id="d_duties"></dd>
							<%if(type!=null&&type.equals("002001")){ %>
							<dt>记分分值</dt>
							<dd id="d_score"></dd>
							<%} %>
							<%if(type!=null&&type.equals("002003")){ %>
							<dt>禁闭时间</dt>
							<dd id="d_dstime"></dd>&nbsp;-&nbsp;<dd id="d_detime"></dd>
							<%} %>
							<%if(type!=null&&type.equals("002002")){ %>
							<dt>停职时间</dt>
							<dd ><span id="d_dstime"></span>&nbsp;-&nbsp;<span id="d_detime"></span></dd>
							<%} %>
							<dt>原因</dt>
							<dd id="d_reason"></dd>
							<dt>督察人员</dt>
							<dd id="d_inspectors"></dd>
							<dt>签发人</dt>
							<dd id="d_signer"></dd>
							<dt>签发时间</dt>
							<dd id="d_stime"></dd>
							
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
		<!-- iCheck 1.0.1 --> 
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/iCheck/icheck.min.js"></script>
	<script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/dist/js/demo.js"></script> 
		<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
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
		 "aaSorting" : [[1, "desc"]],    //默认按此列排序
        "ajax": "<%=basePath%>backstage/scoring/getDate.html?type=<%=type%>",
        "columns": [{ "data": null, 
       	  			"title" : "<input id='changeAll'  onclick='changeAll()' type='checkbox'/>",
       	  			"createdCell" : function(nTd, sData, oData,
								iRow, iCol) {
							var startnum = this.api().page()
									* (this.api().page.info().length);   
							$(nTd).html("<input name='_change' value='"+oData.fuid+"'  type='checkbox'/>"); // 分页行号累加：$(nTd).html(iRow+1);
						}},
						{ "data": "jqdepartmentname",
							"title" : "县市公安局" },
						{ "data": "jdepartmentname",
							"title" : "对象部门" },
						  { "data": "jname",
								"title" : "对象" },
						 { "data": "sex",
									"title" : "性别" },
									{ "data": "ispolice",
										"title" : "是否民警" },
							{ "data": "score",
										"title" : "被记分数" },
						  { "data": "duties",
								"title" : "职务" },
						  { "data": "reason", 
								"title" : "原因" },
						 
						  { "data": "inspectors",
								"title" : "督察人员" },
						  { "data": "signer",
								"title" : "签发人" },
						  { "data": "stime",
								"title" : "签发时间" },
						
					  { "data" : null,
						"title" : "操作"
						}],
		"columnDefs": [ 
					{ "bSortable": false, "aTargets": [ 0,2,8,10,12 ] },   //不排序的列
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
							  data=data==1?"是":"否";
							  return data;
						  }
					  }, 
					  { 
						  targets: 4,
						  render: function(data,type,row,meta){ 
							  data=data==1?"男":"女";
							  return data;
						  }
					  }, 
					  { 
						  targets: 8,
						  render: function(data,type,row,meta){ 
							 if(data!=null&&data.length>=15){
								 data=data.substring(0,15)+"...";
							 }
							  return data;
						  }
					  }, 
					  { 
						  targets: 11,
						  render: function(data,type,row,meta){ 
							 if(data!=null){
								 data=timeForm(data);
							 }
							  return data;
						  }
					  }, 
					  { 
	                        targets:12, 
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
	 
	 $("input[type=search]").css("display","none");
	 
	 $("#department").change(function (){
		 var pid=$(this).val(); 
		 $("input[name='jqdepartmentname']").val($("#department option:selected").text()); 
		 $("input[name='jqdepartmentid']").val($(this).val());
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
	            		 $("input[name='jdepartmentname']").val($("#department1 option:selected").text());
	            		 $("input[name='jdepartmentid']").val($(this).val());
	            	 })
	            }
	        });
		 
	 })
	 
	 
	
 })

 	 
 	/**
     * 添加数据
     **/
    function add() {
	
		if(!vi()){
			return; 
		}
        $.ajax({
            url:"/backstage/scoring/edit.html",
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
    		url:"<%=basePath%>backstage/scoring/getEditData.html",
    		data:{"fuid":fuid},
    		dataType:"json",
    		success:function(res){
    			var s = res.data.scoring;
    			editFlag = true;
    	        $("#myModalLabel").text("修改");
    	        $("#fuid").val(s.fuid); 
    	        $("#jname").val(s.jname);
    	        $("#duties").val(s.duties);
    	        $("#reason").val(s.reason);
    	        $("#score").val(s.score); 
    	        $("#inspectors").val(s.inspectors);
    	        $("#signer").val(s.signer);
    	        $("#dstime").val(timeForm(s.dstime));
    	        $("#detime").val(timeForm(s.detime));
    	        $("#stime").val(timeForm(s.stime));
    	        $("#department22").val(s.jdepartmentname);
    	        $("#jdepartmentid").val(s.jdepartmentid);
     	        
    	        $("input[name='sex']").each(function (){
    	        	if($(this).val()==s.sex){ 
    	        		$(this).iCheck('check');
    	        	}
    	        })
				$("input[name='ispolice']").each(function (){
    	        	if($(this).val()==s.ispolice){ 
    	        		$(this).iCheck('check');
    	        	}
    	        }) 
    	        $("input[name='ischief']").each(function (){
    	        	if($(this).val()==s.ischief){  
    	        		$(this).iCheck('check');
    	        	}
    	        }) 
     	        $("#myModal").modal("show"); 
    		}
    	});
    }

    /**
     * 字段验证
     */ 
  function vi(){
	  var t=true;
	  if($("input[name='jname']").val().length == 0){
		 layer.msg("请输入被记分人员");
		 t=false;
	  } 
	  if($("input[name='duties']").val().length == 0){
		 layer.msg("请输入职务");
		 t=false;
	  }  
	  /* if($("input[name='score']").val().length == 0){
		 layer.msg("请输入分值");
		 t=false;
	  }  */
	  if($("input[name='inspectors']").val().length == 0){
		 layer.msg("请输入督察人员");
		 t=false;
	  } 
	  if($("input[name='signer']").val().length == 0){
		 layer.msg("请输入签发人");
		 t=false;
	  }  
	  return t;
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
            url: "<%=basePath%>backstage/scoring/delete.html",
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
	 		url:"<%=basePath%>backstage/scoring/getEditData.html",
	 		type: 'post',
	 		data:{"fuid":fuid},
	 		dataType:"json",
	 		success:function(res){
	 			var s = res.data.scoring;
	 				$("#d_fuid").html(s.fuid);  
	 				$("#d_jname").html(s.jname);
	 				if(s.ischief==2){
	 					$("#d_ischief").html("中层正职");
	 				}else if(s.ischief==1){
	 					$("#d_ischief").html("中层副职");
	 				}else{
	 					$("#d_ischief").html("无");
	 				}
	 				$("#d_duties").html(s.duties);  
	 				$("#d_reason").html(s.reason);  
	 				$("#d_score").html(s.score);  
	 				$("#d_inspectors").html(s.inspectors);  
	 				$("#d_signer").html(s.signer);  
	 				$("#d_stime").html(timeForm(s.stime));  
	 				$("#d_dstime").html(timeForm(s.dstime));  
	 				$("#d_detime").html(timeForm(s.detime));  
	 				
	 				$("#d_departmentname").html(s.jdepartmentname);
	 				 
	 				var sex=s.sex;
	 				sex=sex==1?"男":"女"; 
	 				$("#d_sex").html(sex);  
	 	        $("#Modal_detail").modal("show");  
	 		}
	 	}); 
	} 
    
    //时间格式化
    function timeForm(date){ 
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
    	     bdate = bdate.getFullYear() + "-" + mm + "-" + d;
        	return bdate;
    	}else{
    		return "";
    	}
    	
    }
    
     function gsearch(){
	var sdepartment=$("#sdepartment option:selected").val();
	var ischief=$("input[name='ischief']:checked").val();
	var ispolice=$("input[name='ispolice']:checked").val();
	var stime=$("#stime").val()+" ";
	var etime=$("#setime").val()+" ";
	var dstime=$("#dstime").val()+" ";
	var detime=$("#detime").val()+" ";
	var data=sdepartment+","+ischief+","+ispolice+","+stime+","+etime+","+dstime+","+detime;
	table.fnFilter(data); 
} 
 	
	</script>

</body>
</html>
	 
