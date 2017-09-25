<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>会员信息管理</title>
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
		<li class="active"><a href="${ctx}/memeber/memeber/">会员信息列表</a></li>
		<shiro:hasPermission name="memeber:memeber:edit"><li><a href="${ctx}/memeber/memeber/form">会员信息添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="memeber" action="${ctx}/memeber/memeber/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>手机号：</label>
				<form:input path="mobile" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>用户昵称：</label>
				<form:input path="nickName" htmlEscape="false" maxlength="60" class="input-medium"/>
			</li>
			<li><label>用户来源：</label>
				<form:input path="source" htmlEscape="false" maxlength="4" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>手机号</th>
				<th>用户昵称</th>
				<th>用户类型</th>
				<th>用户来源</th>
				<th>推荐人</th>
				<th>用户积分</th>
				<th>金币总数量</th>
				<th>成为会员时间</th>
				<shiro:hasPermission name="memeber:memeber:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="memeber">
			<tr>
				<td><a href="${ctx}/memeber/memeber/form?id=${memeber.id}">
					${memeber.mobile}
				</a></td>
				<td>
					${memeber.nickName}
				</td>
				<td>
					${memeber.type}
				</td>
				<td>
					${memeber.source}
				</td>
				<td>
					${memeber.recommendUid}
				</td>
				<td>
					${memeber.score}
				</td>
				<td>
					${memeber.gold}
				</td>
				<td>
					<fmt:formatDate value="${memeber.vipTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="memeber:memeber:edit"><td>
    				<a href="${ctx}/memeber/memeber/form?id=${memeber.id}">修改</a>
					<a href="${ctx}/memeber/memeber/delete?id=${memeber.id}" onclick="return confirmx('确认要删除该会员信息吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>