<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html class="bg2 bg21" lang="zh-CN">
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
				<li><a href="<%=basePath%>/searchVehicleInfo/query">首页</a></li>
				<li><a href="#">查询</a></li>
			</ul>
			<div class="vms-inner">
				<div class="vms-inner-bd">
					<table class="table table-center">
						<thead>
							<tr>
								<td>序号</td>
								<td>车牌号</td>
								<td>出厂时间</td>
								<td>所属企业</td>
								<td>最近等级评价</td>
								<td>最近维修时间</td>
								<td>操作</td>
							</tr>
						</thead>
						<tbody>
						<c:choose>
							<c:when test="${not empty dataList}">
								<c:forEach items="${dataList}" var="user" varStatus="vs">
							<tr>
								<td class='center' style="width: 30px;">${vs.index+1}</td>
								<td>${user.plateNumber}</td>
								<td>${user.releaseDate}</td>
								<td>${user.affiliatedFirm}</td>
								<td>${user.reviewTime}</td>
								<td>${user.recentMaintenanceTime}</td>
								<td>
									<form action="getDataDetail" method="post" name="userForm" id="getDataDetail" style="display:inline">
										<input id="messageID" name="messageID" hidden="hidden" class="form-control-lg" type="text" value="${user.messageID}">
										<input id="plateNumber" name="plateNumber" hidden="hidden" class="form-control-lg" type="text" value="${user.plateNumber}">
										<%--<input id="session" name="session" hidden="hidden" class="form-control-lg" type="text" value="${sessionScope.sessionUser.USERNAME}">--%>
										<%--<input id="isPay" name="isPay" hidden="hidden" class="form-control-lg" type="text" value="${user.isPay}">--%>
										<a id="isFollow" class="btn btn-primary btn-sm" follow="${user.follow}"  plateNumber="${user.plateNumber}" messageID="${user.messageID}"
										   session="${sessionScope.sessionUser.USERNAME}" isPay="${user.isPay}" onclick="getDataDetail(this)">查看详情</a>
									</form>

										<input id="user2" name="messageID" hidden="hidden" class="form-control-lg" type="text" value="${user.messageID}">
									<c:if test="${user.follow != '1' }"><button class="btn btn-primary btn-sm"    value="${user.messageID}" plateNumber="${user.plateNumber}" onclick="follow(this)">关注</button></c:if>

									<c:if test="${user.follow == '1' }"><button class="btn btn-primary btn-sm"    value="${user.messageID}" style="background-color:#cccccc">已关注</button></c:if>
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
								<div class="row login-form-item">
									<div class="col-xs-3 col-left"></div>
									<div class="col-xs-7 col-right">
									<div class="row">
									<div class="col-xs-12">
										<label  >该条详细信息需要付费查看，请付费。</label>
									</div>
								</div>
								</div>
								</div>
									<input id="payPlateNumber" name="payPlateNumber" hidden="hidden" class="form-control-lg" type="text" >
								<div class="row login-form-item">
									<div class="col-xs-4 col-left"></div>
									<div class="col-xs-7 col-right">
										<div class="row">
											<div class="col-xs-6">
												<button class="btn btn-primary btn-lg btn-block" id="logic-editor-submit" onclick="pay()">付 费</button>
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

		<div class="bg"></div>
	</div>




	<div class="footer">
		版权所有©西安市汽车维修行业管理处 陕ICP备14011688号-1 <br>
		地址: 西安市建设西路111号
	</div>
	<div id="payPanel"></div>
	<script src="<%=basePath %>/static/vehicleManage/js/jquery.min.js"></script>
	<script src="<%=basePath %>/static/vehicleManage/js/main.js"></script>
	<script src="<%=basePath %>/static/vehicleManage/js/bootstrapValidator.js"></script>

	<script  type="text/javascript">

		//获取车辆基本信息
	function getDataDetail(val){
		//var session=$("#session").val();
		var messageID=val.getAttribute("messageID");
		var plateNumber=val.getAttribute("plateNumber");
		var session=val.getAttribute("session");
			if(session.length==0){
				alert('请登录,再查看');
				return false;
			}
		var isFollow=val.getAttribute("isFollow");
		if(isFollow=='0'){
			alert('请关注后,再查看');
			return false;
		}
		var isPay=val.getAttribute("isPay");
		if(isPay=='0'){
	//	if($("#isPay").attr("value")=='0'){
			$("#payPlateNumber").val(plateNumber);
			$('#myinfo').modal('show');


		/*	$("#payPanel").css("width","300");
			$("#payPanel").css("height","200");
			$("#payPanel").css("background-color","white");
			$("#payPanel").html("该条详细信息需要付费查看，请付费。<br><button onclick='alert(\"传送付费接口\")'>付费</button><button onclick='javascript: document.getElementById(\"payPanel\").style.display=\"none\"'>X</button>");
			$("#payPanel").css({
				index:99,
				position:'absolute',
				left: ($(window).width() - $("#payPanel").outerWidth())/2,
				top: ($(window).height() - $("#payPanel").outerHeight())/2 + $(document).scrollTop(),

			});
			document.getElementById("payPanel").style.zIndex=99;
			$("#payPanel").show();
	*/
			return false;
		}
		$('#messageID').val(messageID);
		$('#plateNumber').val(plateNumber);
	 	$("#getDataDetail").submit();
	}


	/*关注车辆*/
		function follow(val){
			// 	$("#followVehicle").submit();
			var messageID=val.getAttribute("value");
			var plateNumber=val.getAttribute("plateNumber");

			$.ajax({
				type: "POST",
				url: '<%=basePath%>/followVehicleClient/followVehicle',
				data: {messageID:messageID,plateNumber:plateNumber},
				async:true,
				cache: false,
				dataType:'json',
				success: function(msg){
				 alert(msg.msg);
				if(msg.msg=='关注成功'){
					$('button').each(function(){//遍历
						if($(this).val()==messageID){
							$(this).html("已关注");
							$(this).css("background-color","#cccccc");
							$(this).attr("disabled", true);
						}
					})
				}
				window.location.assign=("<%=basePath%>/vehicleManage/showQueryDataList");
				}
			});

		}

		//打开对话框对话框
		function closePayPanel(){
			 document.getElementById("payPanel").style.display="none";
			return ;
		}

		function pay(){
			window.location.href=("<%=basePath%>/myInfoVehicleClient/payPage?plateNumber="+$("#payPlateNumber").val());
			//console.log( "<%=basePath%>/myInfoVehicleClient/payPage?plateNumber="+$("#payPlateNumber").val());
		}


	</script>
</body>
</html>