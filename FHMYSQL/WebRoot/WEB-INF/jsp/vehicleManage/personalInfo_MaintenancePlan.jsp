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

	<link type="text/css" href="<%=basePath %>/static/vehicleManage/date/css/jquery-ui-1.11.4.css" rel="stylesheet" />

	<link type="text/css" href="<%=basePath %>/static/vehicleManage/date/css/jquery-ui-timepicker-addon.css" rel="stylesheet" />
	<script src="<%=basePath %>/static/vehicleManage/js/jquery.min.js"></script>
	<script src="<%=basePath %>/static/vehicleManage/js/main.js"></script>
	<script src="<%=basePath %>/static/vehicleManage/js/bootstrapValidator.js"></script>

	<script type="text/javascript" src="<%=basePath %>/static/vehicleManage/date/js/jquery-ui-1.11.4.js"></script>
	<script type="text/javascript" src="<%=basePath %>/static/vehicleManage/date/js/jquery-ui-timepicker-addon.js"></script>
	<script type="text/javascript" src="<%=basePath %>/static/vehicleManage/date/js/jquery-ui-timepicker-zh-CN.js"></script>

	<script type="text/javascript">
		$(function () {
			$("#jhsj").datetimepicker({
				defaultDate: $('#jhsj').val(),
				dateFormat: "yy-mm-dd",
				//	timeOnlyShowDate:true,
				showHour: false,
				showMinute: false,
				showSecond: false,
//				timeFormat: 'HH:mm:ss',
//				stepHour: 1,
//				stepMinute: 1,
				stepSecond: 1
			})
		})
	</script>
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
				<li>维修计划</li>
			</ul>
			<div class="vms-inner">
				<%--	<div class="vms-inner-hd">
                        <button class="btn btn-primary " onclick="openPlan()">建立计划</button>
                     <button class="btn btn-primary" onclick="openDeletePlan()">删除计划</button>
				</div>--%>
				<div class="vms-inner-bd">
					<table class="table table-center">
						<thead>
							<tr>
								<td>选择</td>
								<td>车牌号</td>
								<td>出厂时间</td>
								<td>所属单位</td>
								<td>最近等级评价</td>
								<td>最近维修时间</td>
								<td>年度维修次数</td>
								<td>年度维修计划</td>
							</tr>
						</thead>
						<tbody>
							<tr>
							<%--	<td>
									<div class="checkbox">
										<input class="input hidden" type="checkbox" name="" id="c1">
										<label class="label" for="c1"></label>
									</div>
								</td>--%>
								<c:choose>
								<c:when test="${not empty dataList}">
								<c:forEach items="${dataList}" var="user" varStatus="vs">
							<tr>
								<td>
									<%--<div class="checkbox">
									<input class="input hidden" type="checkbox" name="" id="c1" value="${user.plateNumber}">
									<label class="label" for="c1"></label></div>--%>
								<a style="cursor:pointer" plateNumber="${user.plateNumber}" onclick="openDeletePlan(this)">建立计划|删除计划</a>

								</td>
								<td><a style="cursor:pointer" plateNumber="${user.plateNumber}" <%--onclick="queryPlanList(this)"--%>>${user.plateNumber}</a></td>
								<td>${user.releaseDate}</td>
								<td>${user.affiliatedFirm}</td>
								<td>${user.reviewTime}</td>
								<td>${user.recentMaintenanceTime}</td>
								<td>${user.annualMaintenanceTimes}</td>
								<td>${user.annualMaintenancePlan}</td>
							</tr>

							</c:forEach>
							</c:when>
							</c:choose>

							</tr>
						</tbody>
						<%--<tbody id="planTr">
						</tbody>--%>
					</table>
				</div>
			</div>
		</div>

		<%--st--%>
		<div class="modal fade" id="myinfo" data-backdrop="static" >
			<div class="modal-dialog">
				<div class="modal-content">
					<button type="button" class="close vms-modal-close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span>
					</button>
					<div class="modal-body">
						<div id="dlag_edit" class="editor-form">
							<div class="container-fluid">
							<%--	<form id="planForm" class="form-horizontal" method="post" action="<%=basePath%>/maintainPlanVehicleClient/saveMaintainPlan">--%>
									<div class="row login-form-item form-group">
										<div class="col-xs-4 col-left">
											<label for="jhsj">计划时间:</label>
										</div>
										<div class="col-xs-7 col-right">
											<input id="jhsj" type="text" name="planTime" class="form-control-lg" >
										</div>
									</div>
									<input id="plateNumber" name="plateNumber" hidden="hidden" class="form-control-lg" type="text" >
									<div class="row login-form-item form-group">
										<div class="col-xs-4 col-left">
											<label for="remark">备注:</label>
										</div>
										<div class="col-xs-7 col-right">
											<textarea id="remark" name="remark" rows="4" class="form-control-lg" value=""></textarea>
										</div>
									</div>
									<div class="row login-form-item">
										<div class="col-xs-4 col-left"></div>
										<div class="col-xs-7 col-right">
											<div class="row">
												<div class="col-xs-6">
													<button class="btn btn-primary btn-lg btn-block" id="logic-editor-submit" onclick="addPlan()">确 认</button>
												</div>
												<div class="col-xs-6">
													<button class="btn btn-secondary btn-lg btn-block" data-dismiss="modal">取 消</button>
												</div>
											</div>
										</div>
									</div>
								<%--</form>--%>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%--ed--%>


		<div class="modal fade" id="deletemyinfo" data-backdrop="static" >
			<div class="modal-dialog">
				<div class="modal-content">
					<button type="button" class="close vms-modal-close" data-dismiss="modal">
						<span aria-hidden="true">&times;</span>
					</button>
					<div class="modal-body">
						<div id="deletemyinfo_edit" class="editor-form">
							<div class="container-fluid">
			<div class="vms-inner-bd">
		<div class="vms-inner">
			<div class="vms-inner-hd">
				<button class="btn btn-primary"  onclick="openPlan()">建立计划</button>
			<%--	<button class="btn btn-primary" onclick="openDeletePlan()">删除计划</button>--%>
			</div>
		<div class="vms-inner-bd">
			<table class="table table-center">

				<thead>
				<tr>
					<td>计划时间</td>
					<td>备注</td>
					<td>操作</td>
				</tr>
				</thead>
				<tbody id="planTr">

				</tbody>
			</table>
		</div>

							</div>
						</div>
					</div>
				</div>
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


	<script type="text/javascript">
		var ss=1;
	function	checkChoose(){

			var count=0;
			var a = document.getElementsByTagName("input");
			for(var i = 0;i<a.length;i++){
				if(a[i].type == "checkbox"){
					if(a[i].checked==true){
						$("#plateNumber").val(a[i].value);
						count++;
					}
				}
			}
			if(count==0){
				alert("请选择一条记录新增");
				ss=0;
				return false;
			}
			if(count>1){
				alert("请选择一条记录新增");
				ss=0;
				return false;
			}
			ss=1;
		}

		function openPlan(){
		//	checkChoose();
		//	if(ss==1){
			$('#myinfo').modal('show');
			$('#deletemyinfo').modal('hide');
		//	}
		}


		function addPlan(){
			var planTime=$("#jhsj").val();
			var remark=$("#remark").val();
			var plateNumber=$("#plateNumber").val();
			$.ajax({
				type: "POST",
				url: '<%=basePath%>/maintainPlanVehicleClient/saveMaintainPlan',
				data: {planTime:planTime,remark:remark,plateNumber:plateNumber},
				async:false,
				cache: false,
				dataType:'json',
				success: function(msg){
				//	alert(msg.msg);
					$('#myinfo').modal('hide');
					queryPlan(plateNumber);
				}
			});
		}

		function queryPlan(plateNumber){

			$.ajax({
				type: "POST",
				url: '<%=basePath%>/maintainPlanVehicleClient/findMaintainPlan',
				data: {plateNumber:plateNumber},
				async:false,
				cache: false,
				dataType:'json',
				success: function(msg){
					planlist(msg.list);

				}
			});

		}

		//查看车辆变更记录
		function planlist(_vcrList){
			var dataArray=eval(_vcrList);
			var aaa=""; //<tr><td>计划时间</td><td>备注</td><td>操作</td></tr>
			for(var i in dataArray)
			{
				aaa+="<tr id="+dataArray[i].id+">";
				aaa+="<td>"+dataArray[i].plan_time+"</td>";
				aaa+="<td>"+dataArray[i].remark+"</td>";
				aaa+="<td><a style=\"cursor:pointer\"   plateNumber="+dataArray[i].plate_number+"   \"\" planid="+dataArray[i].id+"  onclick=\"deletePlan(this)\">删除</a></td>";
				aaa+="<tr/>";
			}
			$('#planTr').html(aaa);
			$('#deletemyinfo').modal('show');
		}


		function deletePlan(val){
			if (confirm('是否确认删除？')){
				var plateNumber=val.getAttribute("plateNumber");
				var id=val.getAttribute("planid");
				$.ajax({
					type: "POST",
					url: '<%=basePath%>/maintainPlanVehicleClient/deleteAllMaintainPlan',
					data: {plateNumber:plateNumber,id:id},
					async:false,
					cache: false,
					dataType:'json',
					success: function(msg){

		//				alert(msg.msg);

						var tr = document.getElementById(id);
						tr.parentNode.removeChild(tr);  //动态删除行标签
					}
				});
			}

		}


		function	queryPlanList(val){
			var plateNumber=val.getAttribute("plateNumber");
			$.ajax({
				type: "POST",
				url: '<%=basePath%>/maintainPlanVehicleClient/findMaintainPlan',
				data: {plateNumber:plateNumber},
				async:false,
				cache: false,
				dataType:'json',
				success: function(msg){
					planlist(msg.list);
				}
			});
		}


		function openDeletePlan(val){
		//	checkChoose();
		//	if(ss==1) {
				$('#deletemyinfo').modal('show');
		//		var plateNumber=$("#plateNumber").val();
			var plateNumber=val.getAttribute("plateNumber");
			$("#plateNumber").val(plateNumber);
				queryPlan(plateNumber);
		//	}
		}

	</script>


</body>
</html>