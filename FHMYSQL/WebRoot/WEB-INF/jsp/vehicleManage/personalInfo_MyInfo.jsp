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
				<c:if test="${sessionScope.sessionUser.USERNAME == null }">
					<a href="<%=basePath%>/loginVehicleClient/loginPage">登录</a>
					<a href="<%=basePath%>/registerVehicleClient/registerPage">注册</a>
				</c:if>
				<c:if test="${sessionScope.sessionUser.USERNAME != null }">
					<a  href="<%=basePath%>/myInfoVehicleClient/myInfoPage">用户：${sessionScope.sessionUser.USERNAME}</a>
				</c:if>
			</div>
		</div>
		<div class="logo">西安市道路运输车辆技术管理档案信息系统</div>
	</div>
	<div class="main">
		<div class="content">
			<ul class="crumb">
				<li><a href="<%=basePath%>/searchVehicleInfo/query">首页</a></li>
				<li><a href="<%=basePath%>/myInfoVehicleClient/myInfoPage">个人主页</a></li>
				<li><a href="<%=basePath%>/myInfoVehicleClient/getmyInfoPageJsp">我的信息</a></li>
			</ul>
			<div class="vms-inner">
				<div class="my-info">
					<img class="img" src="images/bg1.jpg" alt="">
					<ul>
						<li>账号：${sessionScope.sessionUser.USERNAME}</li>
						<li><a id="updateName">昵称：${sessionScope.sessionUser.NAME}</a></li>
					</ul>
					<button class="btn btn-primary logic-editor-myinfo">编 辑</button>
				</div>
			</div>
		</div>
		<div class="bg"></div>
	</div>

	<!-- Modal -->	
	<div class="modal fade" id="myinfoEditorModal" data-backdrop="static">
		<div class="modal-dialog">
			<div class="modal-content">
				<button type="button" class="close vms-modal-close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span>
				</button>
				<div class="modal-body">
					<div class="editor-form">
						<div class="container-fluid">
							<form id="myinfoEditorForm" class="form-horizontal" method="post">
								<div class="row login-form-item">
									<div class="col-xs-4 col-left">
										<label for="user">用户账号：</label>
									</div>
									<div class="col-xs-7 col-right">
										<div class="form-control-key">
											${sessionScope.sessionUser.USERNAME}
										</div>
									</div>
								</div>
								<div class="row login-form-item form-group">
									<div class="col-xs-4 col-left">
										<label for="user">用户昵称：</label>
									</div>
									<div class="col-xs-7 col-right">
										<input id="user" name="user" class="form-control-lg" type="text">
									</div>
								</div>
								<div class="row login-form-item form-group">
									<div class="col-xs-4 col-left">
										<label for="npw">新密码：</label>
									</div>
									<div class="col-xs-7 col-right">
										<input id="npw" name="npw" class="form-control-lg" type="password">
									</div>
								</div>
								<div class="row login-form-item form-group">
									<div class="col-xs-4 col-left">
										<label for="cpw">确认新密码：</label>
									</div>
									<div class="col-xs-7 col-right">
										<input id="cpw" name="cpw" class="form-control-lg" type="password">
									</div>
								</div>
								<div class="row login-form-item">
									<div class="col-xs-4 col-left"></div>
									<div class="col-xs-7 col-right">
										<div class="row">
											<div class="col-xs-6">
												<button class="btn btn-primary btn-lg btn-block" id="logic-editor-submit" onclick="submitUpdateNameAndPass()">确 认</button>
											</div>
											<div class="col-xs-6">
												<button class="btn btn-secondary btn-lg btn-block" data-dismiss="modal">取 消</button>
											</div>
										</div>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /Modal -->	

	<div class="footer">
		版权所有©西安市汽车维修行业管理处 陕ICP备14011688号-1 <br>
		地址: 西安市建设西路111号
	</div>

	<script src="<%=basePath %>/static/vehicleManage/js/jquery.min.js"></script>
	<script src="<%=basePath %>/static/vehicleManage/js/main.js"></script>
	<script src="<%=basePath %>/static/vehicleManage/js/bootstrapValidator.js"></script>

<script type="text/javascript">


	//提交修改昵称密码信息
	function submitUpdateNameAndPass(){
		var name = $("#user").val();
		var npw = $("#npw").val();
		if($("#cpw").val().length<8 || $("#npw").val().length<8 ){
			alert("密码不能少于8位");
			return  false;
		}
		$.ajax({
			type: "POST",
			url: '<%=basePath%>/myInfoVehicleClient/getMyInfoPageJsp',
			data: {name:name,password:npw},
			async:true,
			cache: false,
			dataType:'json',
			success: function(msg){
				if(msg.msg=='密码修改成功'){
				alert("信息修改成功!");
					$('#myinfoEditorModal').modal('hide');

					location.reload();
				}else {
					alert(msg.msg);
				}
			}
		});

	}
</script>
</body>
</html>