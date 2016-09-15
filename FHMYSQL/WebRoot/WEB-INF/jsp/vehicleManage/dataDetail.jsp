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



<style type="text/css">

	.title-color {
		background-color: #048;
		color: #fff;
	}
</style>
</head>
<body>
<div class="header">
	<div class="topnav">
		<div class="inner">
			<c:if test="${sessionScope.sessionUser.USERNAME != null }"><a href="#">${sessionScope.sessionUser.USERNAME}</a></c:if>
			<c:if test="${sessionScope.sessionUser.USERNAME == null }"><a href="<%=basePath%>/registerVehicleClient/registerPage">注册</a>|<a href="<%=basePath%>/loginVehicleClient/loginPage">登录</a></c:if>
			<a href="<%=basePath%>/loginVehicleClient/loginOut">退出</a>
		</div>
	</div>
	<div class="logo">西安市道路运输车辆技术管理档案信息系统</div>
</div>
<div class="main">
	<div class="content">
		<ul class="crumb">
			<li>首页</li>
			<li>个人信息</li>
			<li>车辆详情</li>
		</ul>
		<div class="list-tabs">
			<ul class="nav-tabs logic-tab">
				<li class="active">
					<a href="#vehicle">基本信息</a>
				</li>
				<li>

					<input id="user" name="messageID" hidden="hidden" class="form-control-lg" type="text" value="${baseInfo.messageID}">
					<a href="#ChangeRecord" value="changeRecord" onclick="getSearchUrl('queryVehicleChangeRecord')">车辆变更记录</a>

				</li>
				<li>
					<input id="plateNumber" name="plateNumber" hidden="hidden" class="form-control-lg" type="text" value="${baseInfo.plateNumber}">
					<a href="#FuelTestingRecord"  value="fuelTestingRecord" onclick="getSearchUrl('queryFuelTestingRecord')">燃油检测记录</a>
				</li>
				<li>
					<a href="#SecondMaintenanceRecords" value="secondMaintenanceRecords" onclick="getSearchUrl('querySecondMaintenanceRecords')">二级维护记录</a>
				</li>
				<li>
					<a href="#VehicleDetectionRecords" onclick="getSearchUrl('queryVehicleDetectionRecords')">车辆检测记录</a>
				</li>
				<li>
					<a href="#CertificateReceivingRecords" onclick="getSearchUrl('queryCertificateReceivingRecords')">合格证领取记录</a>
				</li>
				<li>
					<a href="#RoutineMaintenanceRecords" onclick="getSearchUrl('queryRoutineMaintenanceRecords')">日常维护记录</a>
				</li>
			</ul>
			<div class="tab-content logic-tab-content">
				<div class="tab-pane active" id="vehicle">
					<table class="table table-center">
						<tr>
							<td class="title-color">车牌号</td>
							<td>${baseInfo.plateNumber}</td>
							<td class="title-color">道路运输证号</td>
							<td>${baseInfo.roadTransportNo}</td>
							<td class="title-color">燃油类型</td>
							<td>${baseInfo.fuelType}</td>
							<td class="title-color">企业许可证号</td>
							<td>${baseInfo.businessLicenseNo}</td>
						</tr>
						<tr>
							<td class="title-color">车辆种类</td>
							<td>${baseInfo.vehicleType}</td>
							<td class="title-color">车辆颜色</td>
							<td>${baseInfo.vehicleColor}</td>
							<td class="title-color">发动机号</td>
							<td>${baseInfo.engineNo}</td>
							<td class="title-color">车辆类型</td>
							<td>${baseInfo.vehicleType}</td>
						</tr>
						<tr>
							<td class="title-color">车辆型号</td>
							<td>${baseInfo.vehicleTypeNo}</td>
							<td class="title-color">底盘号</td>
							<td>${baseInfo.chassisNo}</td>
							<td class="title-color">所属运管站</td>
							<td>${baseInfo.affiliationStation}</td>
							<td class="title-color">核定吨位</td>
							<td>${baseInfo.checkTonnage}</td>
						</tr>
						<tr>
							<td class="title-color">联系电话</td>
							<td>${baseInfo.contactPhone}</td>
							<td class="title-color">所属单位</td>
							<td>${baseInfo.subordinateUnits}</td>
							<td class="title-color">车辆登记日期</td>
							<td>${baseInfo.vehicleRegistrationDate}</td>
							<td class="title-color">车辆状态</td>
							<td>${baseInfo.vehicleState}</td>
						</tr>

					</table>
				</div>
				<div class="tab-pane" id="ChangeRecord">
					<table class="table table-center">
						<thead>
						<tr>
							<td>车牌号</td>
							<td>车架号</td>
							<td>车属单位</td>
							<td>变更内容</td>
							<td>审核</td>
						</tr>
						</thead>
						<tbody id="changeRecordTr">
						</tbody>
					</table>
				</div>
				<div class="tab-pane" id="FuelTestingRecord">
					<div >
						<span style="float:right;margin-bottom:5px">
							送检人 <input type="text">
							检测单位 <input type="text">
							核查时间 <input type="text">
							<button >搜索</button>
						</span>
					</div>
					<table class="table table-center">
						<thead>
						<tr>
							<td>车牌号</td>
							<td>车架号</td>
							<td>车属单位</td>
							<td>送检人</td>
							<td>检测单位</td>
							<td>检测时间</td>
							<td>审核</td>
							<td>操作</td>
						</tr>
						</thead>
						<tbody id="fuelTestingRecordTr">
						</tbody>
					</table>
				</div>
				<div class="tab-pane" id="SecondMaintenanceRecords">
					<div >
						<span style="float:right;margin-bottom:5px">
							送检人 <input type="text">
							检测单位 <input type="text">
							核查时间 <input type="text">
							<button >搜索</button>
						</span>
					</div>
					<table class="table table-center">
						<thead>
						<tr>
							<td>IC号</td>
							<td>车架号</td>
							<td>车牌颜色</td>
							<td>车辆类型</td>
							<td>道路运输许可证号</td>
							<td>维护次数</td>
							<td>维护登记时间</td>
							<td>维护状态</td>
							<td>操作</td>
						</tr>
						</thead>
						<tbody id="secondMaintenanceRecordTr">
						</tbody>
					</table>
				</div>
				<div class="tab-pane" id="VehicleDetectionRecords">
					<table class="table table-center">
						<thead>
						<tr>
							<td>IC号</td>
							<td>车架号</td>
							<td>车牌颜色</td>
							<td>车辆类型</td>
							<td>道路运输许可证号</td>
							<td>维护次数</td>
							<td>维护登记时间</td>
							<td>维护二维企业</td>
							<td>维护状态</td>
							<td>操作</td>
						</tr>
						</thead>
						<tbody id="vehicleDetectionRecordTr">
						</tbody>
					</table>
				</div>
				<div class="tab-pane" id="CertificateReceivingRecords">
					<div >
						<span style="float:right;margin-bottom:5px">
							送检人 <input type="text">
							检测单位 <input type="text">
							进厂时间 <input type="text">
							<button >搜索</button>
						</span>
					</div>
					<table class="table table-center">
						<thead>
						<tr>
							<td>托修方</td>
							<td>车牌号码</td>
							<td>车型</td>
							<td>维修类别</td>
							<td>维修合同编号</td>
							<td>出厂里程表示值</td>
							<td>进厂日期</td>
							<td>出厂日期</td>
							<td>操作</td>
						</tr>
						</thead>
						<tbody id="certificateReceivingRecordTr">
						</tbody>
					</table>
				</div>
				<div class="tab-pane" id="RoutineMaintenanceRecords">
				<div><span style="float:left;margin-bottom:5px"><button onclick="addRoutineMaintenanceRecords()">新增</button></span></div>
					<div id="dlag_edit" style="display:none;width:300px;height:300px;margin-top:100px;margin-left:400px;margin-right:auto;z-index:99;position:absolute;border:#000000 solid; border-right-width:1px;border-left-width:1px;border-bottom-width:1px; border-top-width:1px;background-color:#cccccc" >
						<div id="close" style="float:right;margin-top:0px;cursor:pointer;" onclick="close_dialog()" >×</div>
						<div id="content" style="padding:50px;margin-top:0">
							<form id="edit_form"  >
								<input type="text" name="datetime" class="ui_timepicker" value="">


								</span><br>
								<span style="margin-top:10px ">维修项目:<input type="text" id="userName" name="userName"  value="" > </span><br>
								<span  style="margin-top:10px ">维修内容：<input type="text" id="password" name="password"  value="" > </span><br>
								<span  style="margin-top:10px ">备注<input type="textarea" id="mobile" name="mobile" style="height:50px;width:200px"> </span><br>
								<span  style="margin-top:10px ">	<input type="button" id="cancel" value="取消" onClick="updateUserInformation()">
								<input type="button" id="submit" style="margin-left:50px " value="确认" onClick="updateUserInformation()"></span>
							</form>

						</div>  <label id="msg" style="color:red;"></label>
					</div>
					<table class="table table-center">
						<thead>
						<tr>
							<td>车牌号码</td>
							<td>车牌颜色</td>
							<td>维修时间</td>
							<td>维修项目</td>
							<td>维修内容</td>
							<td>备注</td>
							<td>操作</td>
						</tr>
						</thead>
						<tbody id="routineMaintenanceRecordTr">
						</tbody>
					</table>
				</div>

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
<script src="<%=basePath %>/static/vehicleManage/js/dataDetail.js"></script>


<script type="text/javascript">





	var messageID=$("#user").val();
	var plateNumber=$("#plateNumber").val();
	function getSearchUrl(url){


		$.ajax({
			type: "GET",
			url: '<%=basePath%>/searchVehicleInfo/'+url,
			data: {messageID:messageID,plateNumber:plateNumber},
			async:true,
			cache: false,
			dataType:'json',
			success: function(msg){
				if(msg._vcrList!=""){
					if(msg.msg=='请登录并付费查看'){
						window.location.assign("<%=basePath%>/loginVehicleClient/loginPage");
					}
					chooseUrl(url,msg._vcrList);

				}else {

				}
			}
		});
	}





</script>
</body>
</html>