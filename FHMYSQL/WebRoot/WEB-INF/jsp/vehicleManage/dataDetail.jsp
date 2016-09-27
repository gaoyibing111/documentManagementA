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


	<script src="<%=basePath %>/static/vehicleManage/js/jquery.min.js"></script>
	<script src="<%=basePath %>/static/vehicleManage/js/main.js"></script>
	<script src="<%=basePath %>/static/vehicleManage/js/bootstrapValidator.js"></script>
	<script src="<%=basePath %>/static/vehicleManage/js/dataDetail.js"></script>


	<link type="text/css" href="<%=basePath %>/static/vehicleManage/date/css/jquery-ui-1.11.4.css" rel="stylesheet" />
	<link type="text/css" href="<%=basePath %>/static/vehicleManage/date/css/jquery-ui-timepicker-addon.css" rel="stylesheet" />
	<%--<script type="text/javascript" src="<%=basePath %>/static/vehicleManage/date/js/jquery-1.11.1.js"></script>--%>
	<script type="text/javascript" src="<%=basePath %>/static/vehicleManage/date/js/jquery-ui-1.11.4.js"></script>
	<script type="text/javascript" src="<%=basePath %>/static/vehicleManage/date/js/jquery-ui-timepicker-addon.js"></script>
	<script type="text/javascript" src="<%=basePath %>/static/vehicleManage/date/js/jquery-ui-timepicker-zh-CN.js"></script>
	<script type="text/javascript">
		$(function () {
			$("#wxsj").datetimepicker({
				defaultDate: $('#wxsj').val(),
//				dateFormat: "yy-mm-dd",
				showSecond: true,
				timeFormat: 'HH:mm:ss',
//				stepHour: 1,
//				stepMinute: 1,
				stepSecond: 1
			})
		})
	</script>

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
			<c:if test="${sessionScope.sessionUser.USERNAME != null }"><a href="<%=basePath%>/myInfoVehicleClient/myInfoPage">${sessionScope.sessionUser.USERNAME}</a>
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
			<li><a href="#">车辆详情</a></li>
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
				<div><span style="float:left;margin-bottom:5px"><button class="btn btn-primary logic-editor-myinfo">新增</button></span></div>


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


<%--st--%>
<div class="modal fade" id="myinfoEditorModal" data-backdrop="static">
	<div class="modal-dialog">
		<div class="modal-content">
			<button type="button" class="close vms-modal-close" data-dismiss="modal">
				<span aria-hidden="true">&times;</span>
			</button>
			<div class="modal-body">
				<div id="dlag_edit" class="editor-form">
					<div class="container-fluid">
						<form id="myinfoEditorForm" class="form-horizontal" method="post">
							<input id="editMaintainId"   hidden="hidden" class="form-control-lg" type="text" >
							<div class="row login-form-item form-group">
								<div class="col-xs-4 col-left">
									<label for="wxsj">维修时间:</label>
								</div>
								<div class="col-xs-7 col-right">
							 	<input id="wxsj" type="text"    class="form-control-lg">
								</div>

							</div>
							<div class="row login-form-item form-group">
								<div class="col-xs-4 col-left">
									<label for="wxxm">维修项目:</label>
								</div>
								<div class="col-xs-7 col-right">
									<input id="wxxm"  class="form-control-lg" type="text">
								</div>
							</div>
							<div class="row login-form-item form-group">
								<div class="col-xs-4 col-left">
									<label for="wxnr">维修内容:</label>
								</div>
								<div class="col-xs-7 col-right">
									<input id="wxnr"   class="form-control-lg" type="text">
								</div>
							</div>
							<div class="row login-form-item form-group">
								<div class="col-xs-4 col-left">
									<label for="bz">备注:</label>
								</div>
								<div class="col-xs-7 col-right">
									<textarea id="bz"   rows="4" class="form-control-lg"></textarea>
								</div>
							</div>
							<div class="row login-form-item">
								<div class="col-xs-4 col-left"></div>
								<div class="col-xs-7 col-right">
									<div class="row">
										<div class="col-xs-6">
											<button class="btn btn-primary btn-lg btn-block" id="logic-editor-submit" onclick="saveOrUpdatemaintain()">确 认</button>
										</div>
										<div class="col-xs-6">
											<button class="btn btn-secondary btn-lg btn-block" data-dismiss="modal" onclick="cancelEditForm()">取 消</button>
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
<%--ed--%>

<div class="footer">
	版权所有©西安市汽车维修行业管理处 陕ICP备14011688号-1 <br>
	地址: 西安市建设西路111号
</div>





<script type="text/javascript">


	var messageID=$("#user").val();
	var plateNumber=$("#plateNumber").val();
	function getSearchUrl(url){
		$.ajax({
			type: "GET",
			url: '<%=basePath%>/searchVehicleInfo/'+url,
			data: {messageID:messageID,plateNumber:plateNumber,id:''},
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


	//修改日常维护记录时先展示要修改的数据
	function editmaintain(val){
		var id=val.getAttribute("id");
		var plateNumber=val.getAttribute("plateNumber");
		$.ajax({
			type: "GET",
			url: '<%=basePath%>/searchVehicleInfo/queryRoutineMaintenanceRecords',
			data: {id:id,plateNumber:plateNumber,messageID:messageID},
			async:true,
			cache: false,
			dataType:'json',
			success: function(msg){
				if(msg._vcrList!=""){
					if(msg.msg=='请登录并付费查看'){
						window.location.assign("<%=basePath%>/loginVehicleClient/loginPage");
					}
					queryRoutineMaintenanceRecord(msg._vcrList);

				}else {

				}
			}
		});
	}
	//修改新增日常维护记录
	function saveOrUpdatemaintain(){
		var  maintain_time=$('#wxsj').val();
		var  maintain_project=$("#wxxm").val();
		var maintain_content=$("#wxnr").val();
		var remark=$("#bz").val();
		var id=$("#editMaintainId").val();

		$.ajax({
			type: "GET",
			url: '<%=basePath%>/searchVehicleInfo/updateOrSaveRoutineMaintenance',
			data: {id:id,plateNumber:plateNumber,messageID:messageID,remark:remark
				,maintain_content:maintain_content,maintain_project:maintain_project,maintain_time:maintain_time},
			async:true,
			cache: false,
			dataType:'json',
			success: function(msg){
				cancelEditForm();
				$('#myinfoEditorModal').modal('hide');
				getSearchUrl('queryRoutineMaintenanceRecords');
			}
		});
	}



</script>
</body>
</html>