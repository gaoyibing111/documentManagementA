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
			<a href="<%=basePath%>/myInfoVehicleClient/myInfoPage">${sessionScope.sessionUser.USERNAME} </a>
			<a href="<%=basePath%>/loginVehicleClient/loginOut">退出</a>
		</div>
	</div>
	<div class="logo">西安市道路运输车辆技术管理档案信息系统</div>
</div>
<div class="main">
	<div class="content">
		<ul class="crumb">
			<li>首页</li>
			<li>个人信息</li>
			<li>付费车辆</li>
		</ul>
		<div class="my-info-wrap">
			<div class="title">
				${sessionScope.sessionUser.USERNAME} 用户 你好
			</div>
			<ul class="my-info-home">
				<li class="mih-item-1">
					<a class="mih-link" href="<%=basePath%>/myInfoVehicleClient/getmyInfoPageJsp">
						<span class="mih-icon"></span>
						<span class="mih-title">个人信息</span>
					</a>
				</li>
				<li class="mih-item-2">
					<a class="mih-link" href="<%=basePath%>/followVehicleClient/queryUserfollowVehicle">
						<span class="mih-icon"></span>
						<span class="mih-title">关注车辆</span>
					</a>
				</li>
				<li class="mih-item-3">
					<a class="mih-link" href="<%=basePath%>/myInfoVehicleClient/queryPayVehicle">
						<span class="mih-icon"></span>
						<span class="mih-title">付费车辆</span>
					</a>
				</li>
				<li class="mih-item-4">
					<a class="mih-link" href="">
						<span class="mih-icon"></span>
						<span class="mih-title">维修计划</span>
					</a>
				</li>
				<li class="mih-item-5">
					<a class="mih-link" href="">
						<span class="mih-icon"></span>
						<span class="mih-title">消息管理</span>
					</a>
				</li>
				<li class="mih-item-6">
					<a class="mih-link" href="">
						<span class="mih-icon"></span>
						<span class="mih-title">维护升级</span>
					</a>
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