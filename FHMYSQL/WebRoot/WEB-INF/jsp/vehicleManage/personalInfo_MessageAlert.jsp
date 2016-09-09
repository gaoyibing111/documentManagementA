<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html class="bg2" lang="zh-CN">
<head>
	<meta charset="UTF-8">
	<title>西安市道路运输车辆技术管理档案信息系统</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/static/vehicleManage/css/style.css" />
</head>
<body>
	<div class="header">
		<div class="topnav">
			<div class="inner">
				<a href="">超级管理员</a>
				<a href="">退出</a>
			</div>
		</div>
		<div class="logo">西安市道路运输车辆技术管理档案信息系统</div>
	</div>
	<div class="main">
		<div class="content">
			<ul class="crumb">
				<li>首页</li>
				<li>个人信息</li>
				<li>我的信息</li>
			</ul>
			<div class="vms-inner">
				<ul class="msg-list">
					<li>
						<a href=""><span class="read">已读</span><span class="time">2016年6月8日 12:12:12</span> 这个是第一条消息提示</a>
					</li>
					<li>
						<a href=""><span class="read">未读</span><span class="time">2016年6月8日 12:12:12</span> 这个是第一条消息提示</a>
					</li>
					<li>
						<a href=""><span class="read">已读</span><span class="time">2016年6月8日 12:12:12</span> 这个是第一条消息提示</a>
					</li>
					<li>
						<a href=""><span class="read">已读</span><span class="time">2016年6月8日 12:12:12</span> 这个是第一条消息提示</a>
					</li>
				</ul>
			</div>
		</div>
		<div class="bg"></div>
	</div>
	<div class="footer">
		版权所有©西安市汽车维修行业管理处 陕ICP备14011688号-1 <br>
		地址: 西安市建设西路111号
	</div>

	<script src="<%=basePath %>/static/vehicleManage/js/jquery.min.js"></script>
	<script src="<%=basePath %>/static/vehicleManage/js/main.js"></script>
	<script src="<%=basePath %>/static/vehicleManage/js/bootstrapValidator.js"></script>
</body>
</html>