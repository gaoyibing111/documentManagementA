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
				<li>付费车辆</li>
			</ul>
			<div class="vms-inner">
				<div class="vms-inner-hd">
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
								<td>车辆状态</td>
								<td>年度维修次数</td>
								<td>年度维修计划</td>
								<td>到期时间</td>
								<td>操作</td>
							</tr>
						</thead>
						<tbody>
						<c:choose>
							<c:when test="${not empty dataList}">
								<c:forEach items="${dataList}" var="user" varStatus="vs">
									<tr>
										<td class='center' style="width: 30px;">${vs.index+1}</td>
										<td  >${user.plateNumber}</td>
										<td  >${user.releaseDate}</td>
										<td  >${user.affiliatedFirm}</td>
										<td>${user.reviewTime}</td>
										<td>${user.vehicleState}</td>
										<td>${user.annualMaintenanceTimes}</td>
										<td>${user.annualMaintenancePlan}</td>
										<td>${user.dueDate}</td>
										<td  style="width:240px;">
											<form action="<%=basePath%>/searchVehicleInfo/getDataDetail" method="post" name="userForm" id="getDataDetail" style="display:inline">
											<input id="user" name="messageID" hidden="hidden" class="form-control-lg" type="text" value="${user.messageID}">
												<input id="plateNumber" name="plateNumber" hidden="hidden" class="form-control-lg" type="text" value="${user.plateNumber}">
												<a id="isFollow" class="btn btn-primary btn-sm"  plateNumber="${user.plateNumber}"  messageID="${user.messageID}"
												   session="${sessionScope.sessionUser.USERNAME}"  onclick="queryDetail(this)">查看详情</a>
											</form>

											 <a class="btn btn-primary btn-sm"    value="${user.messageID}" plateNumber="${user.plateNumber}" onclick="exportTable(this)">导出</a>

											 <a class="btn btn-primary btn-sm"     value="${user.messageID}" >续费</a>
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

	function exportTable(val){
		var messageID=val.getAttribute("value");
		window.location.href='<%=basePath%>/myInfoVehicleClient/excel?messageID='+messageID;
	}
	function  queryDetail(val){
		$("#getDataDetail").submit();
	}
</script>

</body>
</html>