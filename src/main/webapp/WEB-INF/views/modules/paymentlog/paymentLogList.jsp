<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>会员消费记录管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/paymentlog/paymentLog/">会员消费记录列表</a></li>
		<shiro:hasPermission name="paymentlog:paymentLog:edit"><li><a href="${ctx}/paymentlog/paymentLog/form">会员消费记录添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="paymentLog" action="${ctx}/paymentlog/paymentLog/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>用户：</label>
				<form:input path="memberId" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>消费类型：</label>
				<form:input path="type" htmlEscape="false" maxlength="4" class="input-medium"/>
			</li>
			<li><label>直播间：</label>
				<form:input path="roomId" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>用户</th>
				<th>消费类型</th>
				<th>直播间</th>
				<th>消费金币数量</th>
				<shiro:hasPermission name="paymentlog:paymentLog:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="paymentLog">
			<tr>
				<td><a href="${ctx}/paymentlog/paymentLog/form?id=${paymentLog.id}">
					${paymentLog.memberId}
				</a></td>
				<td>
					${paymentLog.type}
				</td>
				<td>
					${paymentLog.roomId}
				</td>
				<td>
					${paymentLog.payment}
				</td>
				<shiro:hasPermission name="paymentlog:paymentLog:edit"><td>
    				<a href="${ctx}/paymentlog/paymentLog/form?id=${paymentLog.id}">修改</a>
					<a href="${ctx}/paymentlog/paymentLog/delete?id=${paymentLog.id}" onclick="return confirmx('确认要删除该会员消费记录吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>