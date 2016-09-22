<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<base href="<%=basePath%>">
		<meta charset="utf-8" />
		<title></title>
		<meta name="description" content="overview & stats" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link href="static/css/bootstrap.min.css" rel="stylesheet" />
		<link href="static/css/bootstrap-responsive.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="static/css/font-awesome.min.css" />
		<!-- 下拉框 -->
		<link rel="stylesheet" href="static/css/chosen.css" />
		
		<link rel="stylesheet" href="static/css/ace.min.css" />
		<link rel="stylesheet" href="static/css/ace-responsive.min.css" />
		<link rel="stylesheet" href="static/css/ace-skins.min.css" />
		
		<link rel="stylesheet" href="static/css/datepicker.css" /><!-- 日期框 -->
		<script type="text/javascript" src="static/js/jquery-1.7.2.js"></script>
		<script type="text/javascript" src="static/js/jquery.tips.js"></script>
		
<script type="text/javascript">
	
	
	//保存
	function save(){
			if($("#USERNAME").val()==""){
			$("#USERNAME").tips({
				side:3,
	            msg:'请输入用户名',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#USERNAME").focus();
			return false;
		}
		if($("#NAME").val()==""){
			$("#NAME").tips({
				side:3,
	            msg:'请输入用户昵称',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#NAME").focus();
			return false;
		}
		if($("#START_TIME").val()==""){
			$("#START_TIME").tips({
				side:3,
	            msg:'请输入注册时间',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#START_TIME").focus();
			return false;
		}
		if($("#COUNT_PAY_VEHICLE").val()==""){
			$("#COUNT_PAY_VEHICLE").tips({
				side:3,
	            msg:'请输入付费车辆数',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#COUNT_PAY_VEHICLE").focus();
			return false;
		}
		$("#Form").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
</script>
	</head>
<body>
	<form action="customermanagement/${msg }.do" name="Form" id="Form" method="post">
		<input type="hidden" name="CUSTOMERMANAGEMENT_ID" id="CUSTOMERMANAGEMENT_ID" value="${pd.CUSTOMERMANAGEMENT_ID}"/>
		<div id="zhongxin">
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<thead>
			<tr>
				<%--	<th class="center">
                    <label><input type="checkbox" id="zcheckbox" /><span class="lbl"></span></label>
                    </th>--%>
				<th class="center">序号</th>
				<th class="center">车牌号</th>
				<th class="center">所属公司</th>
				<th class="center">付费时间</th>
				<th class="center">到期时间</th>
			<%--	<th class="center">操作</th>--%>
			</tr>
			</thead>

			<tbody>

			<!-- 开始循环 -->
			<c:choose>
				<c:when test="${not empty _pdList}">
					<c:if test="${QX.cha == 1 }">
						<c:forEach items="${_pdList}" var="var" varStatus="vs">
							<tr>
									<%--<td class='center' style="width: 30px;">
                                        <label><input type='checkbox' name='ids' value="${var.CUSTOMERMANAGEMENT_ID}" /><span class="lbl"></span></label>
                                    </td>--%>
								<td class='center' style="width: 30px;">${vs.index+1}</td>
										<td>${var.PLATE_NUMBER}</td>
										<td>${var.affiliatedFirm}</td>
									<%--	<td>${var.USERNAME}</td>--%>
										<td>${var.PAY_TIME}</td>
										<td>${var.EXP_DATE}</td>
							</tr>

						</c:forEach>
					</c:if>
					<c:if test="${QX.cha == 0 }">
						<tr>
							<td colspan="100" class="center">您无权查看</td>
						</tr>
					</c:if>
				</c:when>
				<c:otherwise>
					<tr class="main_info">
						<td colspan="100" class="center" >没有相关数据</td>
					</tr>
				</c:otherwise>
			</c:choose>


			</tbody>
		</table>
		</div>
		
		<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green">提交中...</h4></div>
		
	</form>
	
	
		<!-- 引入 -->
		<script type="text/javascript">window.jQuery || document.write("<script src='static/js/jquery-1.9.1.min.js'>\x3C/script>");</script>
		<script src="static/js/bootstrap.min.js"></script>
		<script src="static/js/ace-elements.min.js"></script>
		<script src="static/js/ace.min.js"></script>
		<script type="text/javascript" src="static/js/chosen.jquery.min.js"></script><!-- 下拉框 -->
		<script type="text/javascript" src="static/js/bootstrap-datepicker.min.js"></script><!-- 日期框 -->
		<script type="text/javascript">
		$(top.hangge());
		$(function() {
			
			//单选框
			$(".chzn-select").chosen(); 
			$(".chzn-select-deselect").chosen({allow_single_deselect:true}); 
			
			//日期框
			$('.date-picker').datepicker();
			
		});
		
		</script>
</body>
</html>