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
					<form id="payForm" method="post" action="pay" >
						<div class="row login-form-item form-group">
							<div class="col-xs-3 col-left">
								<label for="username">用户账号：</label>
							</div>
							<div class="col-xs-7 col-right">
								<label id="username" name="username" class="form-control-lg" >${username}</label>
								<input   name="username" hidden="hidden" class="form-control-lg" type="text" value="${username}">

							</div>
						</div>
						<div class="row login-form-item">
							<div class="col-xs-3 col-left">
								<label for="plateNumber">车牌号码：</label>
							</div>
							<div class="col-xs-7 col-right">
							<div class="row form-group">
									<div class="col-xs-6">
										<label id="plateNumber" name="plateNumber" class="form-control-lg" >${plateNumber}</label>
										<input   name="plate_number" hidden="hidden" class="form-control-lg" type="text" value="${plateNumber}">
									</div>
							</div>
							</div>
						</div>
						<div class="row login-form-item form-group">
							<div class="col-xs-3 col-left">
								<label for="charge">费用信息：</label>
							</div>
							<div class="col-xs-7 col-right">
								<label id="chargeName" name="chargeName" class="form-control-lg" >${charge.CHARGE_NAME}</label>
								<input   name="chargeName" hidden="hidden" class="form-control-lg" type="text" value="${charge.CHARGE_NAME}">

							</div>
						</div>
						<div class="row login-form-item form-group">
							<div class="col-xs-3 col-left">
								<label for="charge">费用金额：</label>
							</div>
							<div class="col-xs-7 col-right">
								<label id="charge" name="charge" class="form-control-lg" >${charge.CHARGE}元</label>
								<input   name="pay_money" hidden="hidden" class="form-control-lg" type="text" value="${charge.CHARGE}">
							</div>
						</div>
						<div class="row login-form-item form-group">
							<div class="col-xs-3 col-left">
								<label for="chargeExpDate">费率截止日期：</label>
							</div>
							<div class="col-xs-7 col-right">
								<label id="chargeExpDate" name="chargeExpDate" class="form-control-lg" >${charge.EXP_DATE}</label>
								<input   name="chargeExpDate" hidden="hidden" class="form-control-lg" type="text" value="${charge.EXP_DATE}">
							</div>
						</div>
						<div class="row login-form-item">
							<div class="col-xs-3 col-left"></div>
							<div class="col-xs-7 col-right">
								<div class="row">
									<div class="col-xs-6">
										<button class="btn btn-primary btn-lg btn-block"  onclick="submitPay()">提 交</button>
									</div>
									<div class="col-xs-6">
										<button class="btn btn-primary btn-lg btn-block"  onclick="javascript:history.go(-1)">返 回</button>
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

	function submitPay(){
		 $('#payForm').submit();
	}


</script>
</body>
</html>