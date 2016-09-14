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
					<a href="#ChangeRecord" onclick="ChangeRecord()">车辆变更记录</a>

				</li>
				<li>
					<input id="plateNumber" name="plateNumber" hidden="hidden" class="form-control-lg" type="text" value="${baseInfo.plateNumber}">
					<a href="#FuelTestingRecord" onclick="FuelTestingRecord()">燃油检测记录</a>
				</li>
				<li>
					<a href="#SecondMaintenanceRecords">二级维护记录</a>
				</li>
				<li>
					<a href="#VehicleDetectionRecords">车辆检测记录</a>
				</li>
				<li>
					<a href="#CertificateReceivingRecords">合格证领取记录</a>
				</li>
				<li>
					<a href="#RoutineMaintenanceRecords">日常维护记录</a>
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
					<span>


					</span>
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
				<a class="btn btn-primary btn-sm">新增</a>
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
<script type="text/javascript">
	//查看车辆变更记录
	var messageID=$("#user").val();
	var plateNumber=$("#plateNumber").val();
	function ChangeRecord(){
		$.ajax({
			type: "GET",
			url: '<%=basePath%>/searchVehicleInfo/queryVehicleChangeRecord',
			data: {messageID:messageID,plateNumber:plateNumber},
			async:true,
			cache: false,
			dataType:'json',
			success: function(msg){
				if(msg._vcrList!=""){
					if(msg.msg=='请登录并付费查看'){
						window.location.assign("<%=basePath%>/loginVehicleClient/loginPage");
					}
					changeRecordShow(msg._vcrList);
				}else {

				}
			}
		});
	}
	function changeRecordShow(_vcrList){
		var dataArray=eval(_vcrList);
		var aaa="";
		for(var i in dataArray)
		{
			aaa+="<tr>";
			aaa+="<td>"+dataArray[i].plateNumber+"</td>";
			aaa+="<td>"+dataArray[i].hassisNumber+"</td>";
			aaa+="<td>"+dataArray[i].carGenusUnit+"</td>";
			aaa+="<td>"+dataArray[i].changeContent+"</td>";
			aaa+="<td>"+dataArray[i].reviewStatus+"</td>";
			aaa+="<tr/>";
		}
		$('#changeRecordTr').html(aaa);
	}

	/**
	*  查询燃油检测记录接口
	 */
	function FuelTestingRecord(){
		$.ajax({
			type: "GET",
			url: '<%=basePath%>/searchVehicleInfo/fuelTestingRecord',
			data: {messageID:messageID,plateNumber:plateNumber},
			async:true,
			cache: false,
			dataType:'json',
			success: function(msg){
				if(msg._vcrList!=""){
					if(msg.msg=='请登录并付费查看'){
						window.location.assign("<%=basePath%>/loginVehicleClient/loginPage");
					}
					fuelTestingRecord(msg._vcrList);
				}else {

				}
			}
		});
		function fuelTestingRecord(_vcrList){
			var dataArray=eval(_vcrList);
			var aaa="";
			for(var i in dataArray)
			{
				aaa+="<tr>";
				aaa+="<td>"+dataArray[i].plateNumber+"</td>";
				aaa+="<td>"+dataArray[i].hassisNumber+"</td>";
				aaa+="<td>"+dataArray[i].carGenusUnit+"</td>";
				aaa+="<td>"+dataArray[i].changeContent+"</td>";
				aaa+="<td>"+dataArray[i].reviewStatus+"</td>";
				aaa+="<tr/>";
			}
			$('#fuelTestingRecordTr').html(aaa);
		}

	}




</script>
</body>
</html>