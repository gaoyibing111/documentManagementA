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
					<form id="registerForm" method="post" action="">
						<div class="row login-form-item form-group">
							<div class="col-xs-3 col-left">
								<label for="user">手机号码：</label>
							</div>
							<div class="col-xs-7 col-right">
								<input id="user" name="user" class="form-control-lg" type="text">
							</div>
						</div>
						<div class="row login-form-item">
							<div class="col-xs-3 col-left">
								<label for="code">验证码：</label>
							</div>
							<div class="col-xs-7 col-right">
							<div class="row form-group">
									<div class="col-xs-6">
										<input id="code" name="code" class="form-control-lg" type="text">
									</div>
									<div class="col-xs-6">
										<button class="btn btn-secondary btn-lg btn-block" onclick="sendVcode()">发送短信获取验证码</button>
									</div>
								</div>
							</div>
						</div>
						<div class="row login-form-item form-group">
							<div class="col-xs-3 col-left">
								<label for="npw">新密码：</label>
							</div>
							<div class="col-xs-7 col-right">
								<input id="npw" name="npw" class="form-control-lg" type="password" maxlength="12">
							</div>
						</div>
						<div class="row login-form-item form-group">
							<div class="col-xs-3 col-left">
								<label for="cpw">确认新密码：</label>
							</div>
							<div class="col-xs-7 col-right">
								<input id="cpw" name="cpw" class="form-control-lg" type="password" maxlength="12">
							</div>
						</div>
						<div class="row login-form-item">
							<div class="col-xs-3 col-left"></div>
							<div class="col-xs-7 col-right">
								<div class="row">
									<div class="col-xs-6">
										<button class="btn btn-primary btn-lg btn-block" type="submit" onclick="submitReg()">提 交</button>
									</div>
								</div>
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

	<script src="<%=basePath %>/static/vehicleManage/js/jquery.min.js"></script>
	<script src="<%=basePath %>/static/vehicleManage/js/main.js"></script>
	<script src="<%=basePath %>/static/vehicleManage/js/bootstrapValidator.js"></script>
<script type="text/javascript">

	//获取验证码
	function sendVcode(){
		var phone = $("#user").val();
		$.ajax({
			type: "POST",
			url: '<%=basePath%>/registerVehicleClient/getRegisterCode',
			data: {phone:phone,forget:0},
			async:false,
			cache: false,
			dataType:'json',
			success: function(msg){
				alert(msg.msg);
			}
		});
	}
	//提交注册信息
	function submitReg(){
		var phone = $("#user").val();
		var code = $("#code").val();
		var npw = $("#npw").val();
		if($("#cpw").val().length<8 || $("#npw").val().length<8 ){
			alert("密码不能少于8位");
			return  false;
		}
		$.ajax({
			type: "POST",
			url: '<%=basePath%>/registerVehicleClient/submitRegister',
			data: {phone:phone,password:npw,code:code,forget:0},
			async:true,
			cache: false,
			dataType:'json',
			success: function(msg){
				window.location.assign("<%=basePath%>/loginVehicleClient/loginPage");
			}
		});

	}


</script>
</body>
</html>