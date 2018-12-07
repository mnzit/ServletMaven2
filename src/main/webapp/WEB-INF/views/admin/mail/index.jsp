<%@include file="../shared/header.jsp" %>
<div class="page-header">
    <h1>Mail Manager</h1>
</div>
<form  method="post" action="">
    <div class="form-group">
        <label>Select Template</label>
        <select class="form-control" name="template">
            <c:forEach items="${templates}" var="t">
                <option value="${t.id}">${t.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label>Select event</label>
        <select class="form-control" name="event">
            <c:forEach items="${events}" var="e">
                <option value="${e.id}">${e.title}</option>
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-success">Send Email</button>
    <a href="${SITE_URL}/admin/mail" class="btn btn-danger">Back</a>
</form>
<br/>
<table class="table">
    <thead>
        <tr>
            <th>Event Name</th>
            <th>Total Registered</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="r" items="${requestScope.registered}">
            <tr>
                <td>${r.key}</td>
                <td>${r.value}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<%@include file="../shared/footer.jsp" %>

