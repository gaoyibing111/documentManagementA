<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html class="bg1 round login" lang="zh-CN">
<head>
	<meta charset="UTF-8">
	<title>西安市道路运输车辆技术管理档案信息系统</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<link rel="stylesheet" type="text/css" href="<%=basePath %>/static/vehicleManage/css/style.css" />
</head>
<body>
	<div class="header">
		<div class="topnav"></div>
		<div class="logo">西安市道路运输车辆技术管理档案信息系统</div>
	</div>
	<div class="main">
		<div class="content">
			<div class="login-form">
				<div class="container-fluid">
					<form id="loginForm" method="post">
						<div class="row login-form-item form-group">
							<div class="col-xs-3 col-left">
								<label for="user">手机号：</label>
							</div>
							<div class="col-xs-7 col-right">
								<input id="user" name="user" class="form-control-lg" type="text">
							</div>
						</div>
						<div class="row login-form-item form-group">
							<div class="col-xs-3 col-left">
								<label for="pw">密&nbsp; &nbsp;码：</label>
							</div>
							<div class="col-xs-7 col-right">
								<input id="pw" name="pw" class="form-control-lg" type="password">
							</div>
						</div>
						<div class="row login-form-item">
							<div class="col-xs-3 col-left"></div>
							<div class="col-xs-7 col-right">
								<div class="row">
									<div class="col-xs-6">
										<button class="btn btn-primary btn-lg btn-block" type="submit" onclick="login()">登录</button>
									</div>
									<div class="col-xs-6">
										<button class="btn btn-secondary btn-lg btn-block" onclick="openRegUrl()">注册</button>
									</div>
								</div>
							</div>
						</div>
						<div class="row login-form-item">
							<div class="col-xs-3 col-left">
								
							</div>
							<div class="col-xs-7 col-right">
								<div class="forgetpw"><a href="<%=basePath%>/registerVehicleClient/forgetPasswordPage">忘记密码</a></div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div class="bg"></div>
	</div>
	<div class="footer">
		版权所有©西安市汽车维修行业管理处 陕ICP备14011688号-1 <br>
		地址: 西安市建设西路111号
	</div>
	<script type="text/javascript">
		function openRegUrl(){
		window.location.href="<%=basePath%>/registerVehicleClient/registerPage";
		}


		function login(){
			var phone = $("#user").val();
			var pw = $("#pw").val();
			$.ajax({
				type: "POST",
				url: '<%=basePath%>/loginVehicleClient/login',
				data: {phone:phone,password:pw},
				async:true,
				cache: false,
				dataType:'json',
				success: function(msg){
					if(msg.msg=="success"){
						window.location.assign("<%=basePath%>/myInfoVehicleClient/myInfoPage");
						 //window.location.href="<%=basePath%>/myInfoVehicleClient/myInfoPage";
					}else{
						alert("账号密码错误");
					}
				}
			});

		}

	</script>

	<script src="<%=basePath %>/static/vehicleManage/js/jquery.min.js"></script>
	<script src="<%=basePath %>/static/vehicleManage/js/main.js"></script>
	<script src="<%=basePath %>/static/vehicleManage/js/bootstrapValidator.js"></script>
</body>
</html>