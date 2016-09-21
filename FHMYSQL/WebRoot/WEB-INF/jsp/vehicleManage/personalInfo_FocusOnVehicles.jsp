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
				<li><a href="<%=basePath%>/searchVehicleInfo/query">首页</a></li>
				<li><a href="<%=basePath%>/myInfoVehicleClient/myInfoPage">个人主页</a></li>
				<li><a href="<%=basePath%>/followVehicleClient/queryUserfollowVehicle">关注车辆</a></li>
			</ul>
			<div class="vms-inner">
				<div class="vms-inner-hd">
					<button class="btn btn-primary btn-sm" onclick="addFollow()">新增关注</button>
					<div class="list-search">
						<input class="text-sm" type="text" placeholder="车牌号">
						<button class="btn btn-primary btn-sm">搜 索</button>
					</div>
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
						<c:choose>
							<c:when test="${not empty dataList}">
								<c:forEach items="${dataList}" var="user" varStatus="vs">
									<tr>
										<td class='center' style="width: 30px;">${vs.index+1}</td>
										<td>${user.plateNumber}</td>
										<td>${user.releaseDate}</td>
										<td>${user.affiliatedFirm}</td>
										<td>${user.reviewTime}</td>
										<td>${user.recentMaintenanceTime}</td>
										<td>


											<input id="user2" name="messageID" hidden="hidden" class="form-control-lg" type="text" >
											<c:if test="${user.isPay != '1' }"><button class="btn btn-primary btn-sm"    plateNumber="${user.plateNumber}" onclick="follow(this)">付费</button></c:if>

											<c:if test="${user.isPay == '1' }"><button class="btn btn-primary btn-sm"     style="background-color:#cccccc">已付费</button></c:if>
										</td>
									</tr>

								</c:forEach>
							</c:when>
						</c:choose>
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
<script type="text/javascript">
	function  addFollow(){
		window.location.assign("<%=basePath%>/searchVehicleInfo/query");
	}

</script>

</body>
</html>