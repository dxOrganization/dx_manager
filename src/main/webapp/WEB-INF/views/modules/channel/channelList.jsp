<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>渠道信息管理</title>
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
		<li class="active"><a href="${ctx}/channel/channel/">渠道信息列表</a></li>
		<shiro:hasPermission name="channel:channel:edit"><li><a href="${ctx}/channel/channel/form">渠道信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="channel" action="${ctx}/channel/channel/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>渠道名称</th>
				<th>渠道负责人</th>
				<th>创建时间</th>
				<shiro:hasPermission name="channel:channel:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="channel">
			<tr>
				<td><a href="${ctx}/channel/channel/form?id=${channel.id}">
					${channel.channelName}
				</a></td>
				<td>
					${channel.manager}
				</td>
				<td>
					<fmt:formatDate value="${channel.created}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="channel:channel:edit"><td>
    				<a href="${ctx}/channel/channel/form?id=${channel.id}">修改</a>
					<a href="${ctx}/channel/channel/delete?id=${channel.id}" onclick="return confirmx('确认要删除该渠道信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>