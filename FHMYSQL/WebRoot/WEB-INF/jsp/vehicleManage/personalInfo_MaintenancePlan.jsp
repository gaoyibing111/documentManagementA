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
				<c:if test="${sessionScope.sessionUser.USERNAME != null }">
					<a href="<%=basePath%>/myInfoVehicleClient/myInfoPage">${sessionScope.sessionUser.USERNAME}</a>
					<a href="<%=basePath%>/loginVehicleClient/loginOut">退出</a>
				</c:if>
				<c:if test="${sessionScope.sessionUser.USERNAME == null }"><a href="<%=basePath%>/registerVehicleClient/registerPage">注册</a>|<a href="<%=basePath%>/loginVehicleClient/loginPage">登录</a></c:if>

			</div>
		</div>
		<div class="logo">西安市道路运输车辆技术管理档案信息系统</div>
	</div>
	<div class="main">
		<div class="content">
			<ul class="crumb">
				<li>首页</li>
				<li>个人信息</li>
				<li>维修计划</li>
			</ul>
			<div class="vms-inner">
				<div class="vms-inner-hd">
					<button class="btn btn-primary btn-sm">建立计划</button>
					<button class="btn btn-primary btn-sm">删除计划</button>
				</div>
				<div class="vms-inner-bd">
					<table class="table table-center">
						<thead>
							<tr>
								<td>序号</td>
								<td>车牌号</td>
								<td>出场时间</td>
								<td>所属企业</td>
								<td>最近等级评价</td>
								<td>最近维修时间</td>
								<td>操作</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>
									<div class="checkbox">
										<input class="input hidden" type="checkbox" name="" id="c1">
										<label class="label" for="c1"></label>
									</div>
								</td>
								<td>陕A12456</td>
								<td>2016年6月6日</td>
								<td>陕西汽车总公司</td>
								<td>2016年6月6日</td>
								<td>2016年6月6日</td>
								<td>
									<a href="">详情</a>
									<a href="">导出</a>
									<a href="">续费</a>
								</td>
							</tr>
							<tr>
								<td>
									<div class="checkbox">
										<input class="input hidden" type="checkbox" name="" id="c2">
										<label class="label" for="c2"></label>
									</div>
								</td>
								<td>陕A12456</td>
								<td>2016年6月6日</td>
								<td>陕西汽车总公司</td>
								<td>2016年6月6日</td>
								<td>2016年6月6日</td>
								<td>
									<a href="">详情</a>
									<a href="">导出</a>
									<a href="">续费</a>
								</td>
							</tr>
							<tr>
								<td>
									<div class="checkbox">
										<input class="input hidden" type="checkbox" name="" id="c3">
										<label class="label" for="c3"></label>
									</div>
								</td>
								<td>陕A12456</td>
								<td>2016年6月6日</td>
								<td>陕西汽车总公司</td>
								<td>2016年6月6日</td>
								<td>2016年6月6日</td>
								<td>
									<a href="">详情</a>
									<a href="">导出</a>
									<a href="">续费</a>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
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