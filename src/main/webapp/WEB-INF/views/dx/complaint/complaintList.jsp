<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>会议投诉建议管理</title>
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
		<li class="active"><a href="${ctx}/complaint/complaint/">会议投诉建议列表</a></li>
		<shiro:hasPermission name="complaint:complaint:edit"><li><a href="${ctx}/complaint/complaint/form">会议投诉建议添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="complaint" action="${ctx}/complaint/complaint/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>投诉建议类型：</label>
				<form:input path="type" htmlEscape="false" maxlength="4" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>会员</th>
				<th>投诉建议类型</th>
				<th>投诉建议内容</th>
				<th>创建时间</th>
				<shiro:hasPermission name="complaint:complaint:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="complaint">
			<tr>
				<td><a href="${ctx}/complaint/complaint/form?id=${complaint.id}">
					${complaint.memberId}
				</a></td>
				<td>
					${complaint.type}
				</td>
				<td>
					${complaint.remark}
				</td>
				<td>
					<fmt:formatDate value="${complaint.created}" pattern="yyyy-MM-dd HH:mm:ss"/>
				</td>
				<shiro:hasPermission name="complaint:complaint:edit"><td>
    				<a href="${ctx}/complaint/complaint/form?id=${complaint.id}">修改</a>
					<a href="${ctx}/complaint/complaint/delete?id=${complaint.id}" onclick="return confirmx('确认要删除该会议投诉建议吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>