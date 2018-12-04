<%@include file="../shared/header.jsp" %>
<div class="page-header">
    <h1>Mail Templates</h1>
</div>

<div class="float-right">
    <p>
        <a href="${SITE_URL}/admin/mailtemplate/add" class="btn btn-primary btn-xs">
            <i class="fas fa-plus-square"></i>
        </a>
    </p>
</div>
<table class="table">
    <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="template" items="${requestScope.templates}">
            <tr>
                <td>${template.id}</td>
                <td>${template.name}</td>
                <td>${template.status}</td>
                <td>
                    <a href="${SITE_URL}/admin/mailtemplate/edit?id=${template.id}" class="btn btn-success btn-xs">
                        <i class="fas fa-edit"></i>
                    </a>
                    <a href="${SITE_URL}/admin/mailtemplate/delete?id=${template.id}" class="btn btn-success btn-xs">
                        <i class="fas fa-window-close"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<%@include file="../shared/footer.jsp" %>

