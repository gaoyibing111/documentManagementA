<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html class="bg1 round home" lang="zh-CN">
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
				<a href="">登录</a>
				<a href="">注册</a>
			</div>
		</div>
		<div class="logo">西安市道路运输车辆技术管理档案信息系统</div>
	</div>
	<div class="main">
		<div class="content">
			<div class="login-form home-form">
				<div class="container-fluid">
					<div class="vms-tabs">
						<ul class="nav-tabs logic-tab">
							<li class="active">
								<a href="#vehicle">车 辆 </a>
							</li>
							<li class="">
								<a href="#business">所属企 业</a>
							</li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active" id="vehicle">
								<div class="row">
									<div class="col-xs-10 col-left">
										<input id="user" class="form-control-lg" type="text">
									</div>
									<div class="col-xs-2 col-right">
										<button class="btn btn-primary btn-lg btn-block">查 询</button>
									</div>
								</div>
							</div>
							<div class="tab-pane" id="business">
								<div class="row">
									<div class="col-xs-10 col-left">
										<input id="user" class="form-control-lg" type="text">
									</div>
									<div class="col-xs-2 col-right">
										<button class="btn btn-primary btn-lg btn-block">查 询</button>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="bg"></div>
	</div>
	<div class="footer">
		版权所有©西安市汽车维修行业管理处 陕ICP备14011688号-1
		<br>
		地址: 西安市建设西路111号
	</div>

    <script src="<%=basePath %>/static/vehicleManage/js/jquery.min.js"></script>
 	<script src="<%=basePath %>/static/vehicleManage/js/main.js"></script>
	<script src="<%=basePath %>/static/vehicleManage/js/bootstrapValidator.js"></script>
</body>
</html>