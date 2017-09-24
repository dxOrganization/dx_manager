<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>订单信息（充值）管理</title>
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
		<li class="active"><a href="${ctx}/order/order/">订单信息（充值）列表</a></li>
		<shiro:hasPermission name="order:order:edit"><li><a href="${ctx}/order/order/form">订单信息（充值）添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="order" action="${ctx}/order/order/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>订单编号：</label>
				<form:input path="orderNum" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>用户ID：</label>
				<form:input path="memberId" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>付款方式：</label>
				<form:input path="paymentType" htmlEscape="false" maxlength="4" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>订单编号</th>
				<th>用户ID</th>
				<th>付款方式</th>
				<th>订单金额</th>
				<th>订单类型</th>
				<shiro:hasPermission name="order:order:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="order">
			<tr>
				<td><a href="${ctx}/order/order/form?id=${order.id}">
					${order.orderNum}
				</a></td>
				<td>
					${order.memberId}
				</td>
				<td>
					${order.paymentType}
				</td>
				<td>
					${order.payment}
				</td>
				<td>
					${order.type}
				</td>
				<shiro:hasPermission name="order:order:edit"><td>
    				<a href="${ctx}/order/order/form?id=${order.id}">修改</a>
					<a href="${ctx}/order/order/delete?id=${order.id}" onclick="return confirmx('确认要删除该订单信息（充值）吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>