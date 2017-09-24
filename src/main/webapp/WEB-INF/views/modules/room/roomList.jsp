<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>直播间管理</title>
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
		<li class="active"><a href="${ctx}/room/room/">直播间列表</a></li>
		<shiro:hasPermission name="room:room:edit"><li><a href="${ctx}/room/room/form">直播间添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="room" action="${ctx}/room/room/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>直播间名称：</label>
				<form:input path="roomName" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>直播间状态：</label>
				<form:input path="status" htmlEscape="false" maxlength="4" class="input-medium"/>
			</li>
			<li><label>直播间所在城市：</label>
				<form:input path="city" htmlEscape="false" maxlength="60" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>直播间名称</th>
				<th>直播间类型名称</th>
				<th>直播间状态</th>
				<th>进入直播间消耗金币数量</th>
				<th>直播间所在城市</th>
				<th>直播间视频URL</th>
				<th>直播间所属版块ID</th>
				<th>创建时间</th>
				<shiro:hasPermission name="room:room:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="room">
			<tr>
				<td><a href="${ctx}/room/room/form?id=${room.id}">
					${room.roomName}
				</a></td>
				<td>
					${room.type}
				</td>
				<td>
					${room.status}
				</td>
				<td>
					${room.payment}
				</td>
				<td>
					${room.city}
				</td>
				<td>
					${room.videoUrl}
				</td>
				<td>
					${room.moduleId}
				</td>
				<td>
					<fmt:formatDate value="${room.created}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="room:room:edit"><td>
    				<a href="${ctx}/room/room/form?id=${room.id}">修改</a>
					<a href="${ctx}/room/room/delete?id=${room.id}" onclick="return confirmx('确认要删除该直播间吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>