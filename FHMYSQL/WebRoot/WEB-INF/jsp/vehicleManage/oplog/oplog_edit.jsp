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
			if($("#LOG_TYPE").val()==""){
			$("#LOG_TYPE").tips({
				side:3,
	            msg:'请输入日志类型',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#LOG_TYPE").focus();
			return false;
		}
		if($("#LOG_CONTENT").val()==""){
			$("#LOG_CONTENT").tips({
				side:3,
	            msg:'请输入日志内容',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#LOG_CONTENT").focus();
			return false;
		}
		if($("#MODULE_LOG").val()==""){
			$("#MODULE_LOG").tips({
				side:3,
	            msg:'请输入日志所属模块',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#MODULE_LOG").focus();
			return false;
		}
		if($("#OPERATOR").val()==""){
			$("#OPERATOR").tips({
				side:3,
	            msg:'请输入操作人',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#OPERATOR").focus();
			return false;
		}
		if($("#OPERATOR_ROLE").val()==""){
			$("#OPERATOR_ROLE").tips({
				side:3,
	            msg:'请输入操作人角色',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#OPERATOR_ROLE").focus();
			return false;
		}
		if($("#USERNAME").val()==""){
			$("#USERNAME").tips({
				side:3,
	            msg:'请输入用户名（appuser表username）',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#USERNAME").focus();
			return false;
		}
		if($("#CREATE_DATE").val()==""){
			$("#CREATE_DATE").tips({
				side:3,
	            msg:'请输入记录生成时间',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#CREATE_DATE").focus();
			return false;
		}
		$("#Form").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
</script>
	</head>
<body>
	<form action="oplog/${msg }.do" name="Form" id="Form" method="post">
		<input type="hidden" name="OPLOG_ID" id="OPLOG_ID" value="${pd.OPLOG_ID}"/>
		<div id="zhongxin">
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">日志类型:</td>
				<td><input type="text" name="LOG_TYPE" id="LOG_TYPE" value="${pd.LOG_TYPE}" maxlength="32" placeholder="这里输入日志类型" title="日志类型"/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">日志内容:</td>
				<td><input type="text" name="LOG_CONTENT" id="LOG_CONTENT" value="${pd.LOG_CONTENT}" maxlength="32" placeholder="这里输入日志内容" title="日志内容"/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">日志所属模块:</td>
				<td><input type="text" name="MODULE_LOG" id="MODULE_LOG" value="${pd.MODULE_LOG}" maxlength="32" placeholder="这里输入日志所属模块" title="日志所属模块"/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">操作人:</td>
				<td><input type="text" name="OPERATOR" id="OPERATOR" value="${pd.OPERATOR}" maxlength="32" placeholder="这里输入操作人" title="操作人"/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">操作人角色:</td>
				<td><input type="text" name="OPERATOR_ROLE" id="OPERATOR_ROLE" value="${pd.OPERATOR_ROLE}" maxlength="32" placeholder="这里输入操作人角色" title="操作人角色"/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">用户名（appuser表username）:</td>
				<td><input type="text" name="USERNAME" id="USERNAME" value="${pd.USERNAME}" maxlength="32" placeholder="这里输入用户名" title="用户名"/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">记录生成时间:</td>
				<td><input type="text" name="CREATE_DATE" id="CREATE_DATE" value="${pd.CREATE_DATE}" maxlength="32" placeholder="这里输入记录生成时间" title="记录生成时间"/></td>
			</tr>
			<tr>
				<td style="text-align: center;" colspan="10">
					<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
					<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
				</td>
			</tr>
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