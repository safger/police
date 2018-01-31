<%@ page language="java" import="java.util.*,com.sn.entity.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<!-- saved from url=(0023)http://10.1.4.171/jwdc/ -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=GBK">
    <!--<base href="http://10.1.4.171/jwdc/">--><base href=".">
    
    <title>警务督察管理信息系统</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->  
	<link rel="stylesheet" type="text/css" href="<%=basePath %>images/login/login.css">
  </head>
  
  <body  topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0">
    <form action="<%=basePath%>system/oplogin.html" method="post">
    	<table cellpadding="0" cellspacing="0" width="100%" height="100%">
    		<tbody><tr>
    			<td background="<%=basePath %>images/login/leftslide.jpg">&nbsp;</td>
    			<td background="<%=basePath %>images/login/logincenter.jpg" width="916" height="100%">
    				<table align="center" cellpadding="10px" cellspacing="0" height="100%">
    					
    					<tbody><tr height="50">
							<td height="400" valign="top" style="padding-top: 240px;"><img src="<%=basePath %>images/login/logo.png" width="78" height="85">&nbsp;&nbsp;</td>
						  <td valign="top" style="padding-top: 270px;"><div id="logo">台州市公安局廉政防疫系统</div></td>
						</tr>
						<tr height="20">
							<td colspan="2" align="center" valign="top" style="padding-top: 1px;">
								<table border="0">
									<tbody><tr>
										<td style="padding-left: 15px; width: 60px;">
											<div style=" font-family:&#39;宋体&#39;; font-size:14px;">用户名:</div>
										</td>
										<td>
											<input type="text" name="username" style="width: 156px; height=25">
										</td> 
									</tr>
									<tr>
										<td style="padding-left: 15px; width: 60px;">
											<div style=" font-family:&#39;宋体&#39;; font-size:14px;">密&nbsp;码:</div>
										</td>
										<td>
											<input type="password" name="password" style="width: 156px; height=25">
										</td>
									</tr>
								</tbody></table>
							</td>
						</tr>
						<tr height="30">
							<td colspan="2" style="padding-left: 187px;">
								<span class="cxqk">
						 			<input type="submit" name="submitbtn" class="buttoncss" value="登录"  >
								</span>
								<span class="cxqk"><input type="reset" name="resetbtn" class="buttoncss" value="重置"></span>
							</td>
						</tr>
						<tr height="30">
							<td colspan="2">
								<div id="wangji">
									<ul><br>
										<li>
										<a  >请使用IE9及以上浏览器</a> 
										</li>
									</ul>
									<ul>
										<li>
											<a >或者使用谷歌浏览器</a>
											
										</li>
									</ul>
								</div>
								<div id="sugdiv">
									<ul>
											建议最小分辨率：1024*768
									</ul>
								</div>
							</td>
						</tr>
						<tr>
							<td colspan="2"></td>
						</tr>
    				</tbody></table>
    				
    			</td>
    			<td background="<%=basePath %>images/login/rightslide.jpg">&nbsp;</td>
    		</tr>
   	  </tbody></table>
    </form>
  <script src="<%=basePath%>Bootstrap_AdminLTE_2.3.6/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/common/jquery.cookie.js"></script>
	<script>
		$(function() {
			$("input[name='acount']").focus(); 
		});

		function keyLogin() {
			if (event.keyCode == 13)
				$("form").submit();
		}
	</script>

</body></html>