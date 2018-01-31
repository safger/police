<%@ page language="java"
	import="java.util.*" pageEncoding="UTF-8"%> 
<%
String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path ; 
%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 

<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="<%=basePath%><c:choose><c:when test="${empty sessionScope.headImg}">/images/user.png</c:when><c:otherwise>/upload/L_${sessionScope.headImg }</c:otherwise></c:choose>" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>${sessionScope.username }</p>
           <p>${sessionScope.departmentname }</p>
        </div>
      </div>
        
      <!-- sidebar menu: : style can be found in sidebar.less --> 
      <ul class="sidebar-menu">
        <li class="header">菜单</li>  
        
        <c:forEach items="${parentList }" var="list">
        	<c:choose>
			<c:when test="${list.menuName=='首页' }">
			<li class="treeview">   
	          <a href="<%=basePath %>system/index.html">
	            <i class="fa fa-dashboard"></i> <span>首页</span> 
	            <span class="pull-right-container">
	              <i class="fa fa-angle-left pull-right"></i>
	            </span>
	          </a>
	          <ul class="treeview-menu">
	            <li id="index"><a href="<%=basePath %>/system/index.html"><i class="fa fa-circle-o"></i> 控制台</a></li>
	          </ul> 	
	        </li>
			</c:when>
			<c:otherwise>
				<li>
						<c:choose> 
							<c:when test="${list.menuUrl == 'javascript:void(0)'}">
								   <a href="javascript:void(0)"> 
								</c:when>
								<c:otherwise>
								 <a href="<%=basePath%>${list.menuUrl }">
								</c:otherwise>
								</c:choose>
	        	
	        	   <i class="fa fa-th"></i> 
	        	   <span>${list.menuName }</span>
	        	    <span class="pull-right-container">
		              <i class="fa fa-angle-left pull-right"></i>
		            </span>
		          </a>
		          <c:if test="${list.children!=null }">
		           	<ul class="treeview-menu"> 
						<c:forEach items="${list.children }" var="clist">
							<c:choose>
								<c:when test="${clist.menuUrl == 'javascript:void(0)'}">
								 <li >
								 <a href="javascript:void(0)"><i class="fa fa-th"></i> ${clist.menuName}</a>
									 <c:if test="${clist.children!=null }">
							           	<ul class="treeview-menu">  
											<c:forEach items="${clist.children }" var="cclist">
												<c:choose>
													<c:when test="${cclist.menuUrl == 'javascript:void(0)'}">
													 <li ><a href="javascript:void(0)"><i class="fa fa-circle-o"></i> ${cclist.menuName}</a></li>
													</c:when>
													<c:otherwise>
													 <li ><a href="<%=basePath%>${cclist.menuUrl }"><i class="fa fa-circle-o"></i> ${cclist.menuName}</a></li>
													</c:otherwise>
													</c:choose>
												
											</c:forEach>
							         	 </ul>
							          </c:if>
								 </li>
								</c:when>
								<c:otherwise>
								 <li ><a href="<%=basePath%>${clist.menuUrl }"><i class="fa fa-circle-o"></i> ${clist.menuName}</a></li>
								</c:otherwise>
								</c:choose>
							
						</c:forEach>
		         	 </ul>
		          </c:if>
        		</li>
			</c:otherwise>
			</c:choose>
            </c:forEach> 
      </ul>
    </section> 
    <!-- /.sidebar -->
  </aside> 
  	<script src="<%=basePath%>/Bootstrap_AdminLTE_2.3.6/plugins/jQuery/jquery-2.2.3.min.js"></script>
  <script>
		$(function() {
			var hh=window.location.href; 
			$(".treeview-menu").find("a").each(function (){
				var href=$(this).attr("href");  
				<%if(request.getServerPort()==80){ %>
					href=href.replace(":80","");
				<%}%>   
				hh=hh.replace("#","");   
				if(href==hh){   
					$(this).parent().attr("class","active");
					$(this).parent().parent().parent().attr("class","active treeview")
					if($(this).parent().parent().parent().parent().parent().is('li')){
						$(this).parent().parent().parent().parent().parent().attr("class","active treeview")
					}
				}
			})  
		})
	</script>
