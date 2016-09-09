<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html class="bg2 bg21" lang="zh-CN">
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
				<a href="">${sessionScope.sessionUser.USERNAME}</a>
				<a href="<%=basePath%>/loginVehicleClient/loginOut">退出</a>
			</div>
		</div>
		<div class="logo">西安市道路运输车辆技术管理档案信息系统</div>
	</div>
	<div class="main">
		<div class="content">
			<ul class="crumb">
				<li>首页</li>
				<li>查询</li>
			</ul>
			<div class="vms-inner">
				<div class="vms-inner-bd">
					<table class="table table-center">
						<thead>
							<tr>
								<td>序号</td>
								<td>车牌号</td>
								<td>出厂时间</td>
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
									<form action="getDataDetail" method="post" name="userForm" id="getDataDetail" style="display:inline">
										<input id="user" name="messageID" hidden="hidden" class="form-control-lg" type="text" value="${user.messageID}">
									<a class="btn btn-primary btn-sm" onclick="getDataDetail()">查看详情</a>
									</form>
									<c:if test="${user.follow == '0' }"><button class="btn btn-primary btn-sm"    value="${user.messageID}" onclick="follow()">关注</button></c:if>
									<c:if test="${user.follow == '1' }"><button class="btn btn-primary btn-sm"    value="${user.messageID}" style="background-color:#cccccc">已关注</button></c:if>
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
	<script  type="text/javascript">
	function getDataDetail(){
	 	$("#getDataDetail").submit();
	}

	</script>
</body>
</html>