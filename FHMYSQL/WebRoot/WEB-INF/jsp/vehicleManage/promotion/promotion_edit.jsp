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
			if($("#COMPANY_NAME").val()==""){
			$("#COMPANY_NAME").tips({
				side:3,
	            msg:'请输入公司名',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#COMPANY_NAME").focus();
			return false;
		}
		if($("#PROMOTION_URL").val()==""){
			$("#PROMOTION_URL").tips({
				side:3,
	            msg:'请输入推广链接',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#PROMOTION_URL").focus();
			return false;
		}
		if($("#STATUS").val()==""){
			$("#STATUS").tips({
				side:3,
	            msg:'请输入状态 1生效，0取消',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#STATUS").focus();
			return false;
		}
		if($("#PROMOTION_REMARK").val()==""){
			$("#PROMOTION_REMARK").tips({
				side:3,
	            msg:'请输入渠道备注',
	            bg:'#AE81FF',
	            time:2
	        });
			$("#PROMOTION_REMARK").focus();
			return false;
		}
		$("#Form").submit();
		$("#zhongxin").hide();
		$("#zhongxin2").show();
	}
	
</script>
	</head>
<body>
	<form action="promotion/${msg }.do" name="Form" id="Form" method="post">
		<input type="hidden" name="PROMOTION_ID" id="PROMOTION_ID" value="${pd.PROMOTION_ID}"/>
		<div id="zhongxin">
		<table id="table_report" class="table table-striped table-bordered table-hover">
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">公司名:</td>
				<td><input type="text" name="COMPANY_NAME" id="COMPANY_NAME" value="${pd.COMPANY_NAME}" maxlength="32" placeholder="这里输入公司名" title="公司名"/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">推广链接:</td>
				<td><input type="text" name="PROMOTION_URL" id="PROMOTION_URL" value="${pd.PROMOTION_URL}" maxlength="32" placeholder="这里输入推广链接" title="推广链接"/></td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">状态:</td>
				<td>
				<select name="STATUS" title="状态">
					<option value="1" <c:if test="${pd.STATUS == '1' }">selected</c:if> >正常</option>
					<option value="0" <c:if test="${pd.STATUS == '0' }">selected</c:if> >停用</option>
				</select>
			</td>
			</tr>
			<tr>
				<td style="width:70px;text-align: right;padding-top: 13px;">渠道备注:</td>
				<td><input type="text" name="PROMOTION_REMARK" id="PROMOTION_REMARK" value="${pd.PROMOTION_REMARK}" maxlength="32" placeholder="这里输入渠道备注" title="渠道备注"/></td>
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