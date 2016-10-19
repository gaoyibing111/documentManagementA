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
				<c:if test="${sessionScope.sessionUser.USERNAME == null }">
				<a href="<%=basePath%>/loginVehicleClient/loginPage">登录</a>
				<a href="<%=basePath%>/registerVehicleClient/registerPage">注册</a>
			</c:if>
				<c:if test="${sessionScope.sessionUser.USERNAME != null }">
					<a href="<%=basePath%>/myInfoVehicleClient/myInfoPage">用户：${sessionScope.sessionUser.USERNAME}</a>
				</c:if>
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
								<a href="#business" onclick="hide_user()">所属企业</a>
							</li>
						</ul>

						<div class="tab-content">
							<form action="<%=basePath%>/searchVehicleInfo/queryVehicleByPlate" onsubmit="return checkIsChooseVehicleColor(this)" method="post" name="userForm" id="queryVehicleByPlate">
							<div class="tab-pane active" id="vehicle">
								<div class="row">
									<div class="col-xs-7 col-left">
										<input id="user" name="plateNumber" class="form-control-lg" type="text"  >
									</div>
									<div class="col-xs-3 col-left" >
										<select  id="vehicleColor1" name="vehiclePlateColor" title="" class="form-control-lg">
										</select>
									</div>
									<div class="col-xs-2 col-right">
										<button id="userText" class="btn btn-primary btn-lg btn-block"<%-- onclick="queryVehicleByPlate()"--%>>查 询</button>
									</div>
								</div>
							</div>
								</form>
							<form action="<%=basePath%>/searchVehicleInfo/queryVehicleByCompany" onsubmit="return checkIsChooseVehicleColor(this)" method="post" name="userForm" id="queryVehicleByCompany">
							<div class="tab-pane" id="business">
								<div class="row">
									<div class="col-xs-7 col-left">
										<input id="user2" class="form-control-lg" type="text" name="plateNumber">
									</div>
									<div class="col-xs-3 col-left">
										<select id="vehicleColor2" name="vehiclePlateColor" title="" class="form-control-lg">
										</select>
									</div>
									<div class="col-xs-2 col-right">
										<button  id="userText2" class="btn btn-primary btn-lg btn-block" <%--onclick="queryVehicleByCompany()"--%>>查 询</button>
									</div>
								</div>
							</div>
								</form>

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
	<script type="text/javascript">


		//1.	简要车辆查询接口
		function queryVehicleByPlate(){
		 $('#queryVehicleByPlate').submit();
		}
		//2.	简要所属企业查询接口
		function queryVehicleByCompany(){
			$('#queryVehicleByCompany').submit();
		}
		function hide_user(){
			$('#user').hide();
			$('#userText').hide();
			$('#vehicleColor1').hide();
			$('.help-block').hide();
		}

		jQuery(function($) {
			/*首页查询车牌颜色记录集*/
			$.ajax({
				type: "GET",
				url: '<%=basePath%>/colormanage/getVehicleColorDataList',
				data: {},
				async:true,
				cache: false,
				dataType:'json',
				success: function(msg){
					var dataArray=eval(msg.colorList);
						console.log(dataArray);
						$("select[name='vehiclePlateColor']").append("<option value=\"请选择车牌颜色\">请选择车牌颜色</option>");
						for (var i = 0; i < dataArray.length; i++) {
							$("select[name='vehiclePlateColor']").append("<option name=\"plateColor\" value=" + dataArray[i].COLOR+ ">" + dataArray[i].COLOR + "</option>");
						}
				}
			});

		});


		function checkIsChooseVehicleColor(v){
			var id=v.getAttribute("id");
			if(id=='queryVehicleByPlate'){
				if($('#user').val().trim()==''){
					alert('请输入车牌号');
					return false;
				}
				if($(vehicleColor1).val()=='请选择车牌颜色'){
					alert('必须选择车牌颜色');
					return false;
				}
			}
			if(id=='queryVehicleByCompany'){
				if($('#user2').val().trim()==''){
					alert('请输入车牌号');
					return false;
				}
				if($(vehicleColor2).val()=='请选择车牌颜色'){
					alert('必须选择车牌颜色');
					return false;
				}
			}

		}


	</script>
</body>
</html>