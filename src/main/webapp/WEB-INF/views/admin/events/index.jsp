<%@include file="../shared/header.jsp" %>
<div class="page-header">
    <h1>Event Manager</h1>
</div>
<form  method="post" action="">
    <div class="form-group">
        <label>Title</label>
        <input type="text" name="title" required="required" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Description</label>
        <textarea type="text" name="description" required="required" class="form-control" style="height:150px;"></textarea>
    </div>
    <div class="form-group">
        <label>Start date</label>
        <input type="date" name="start_date" class="form-control"/>
    </div>
    <div class="form-group">
        <label>End date</label>
        <input type="date" name="end_date" class="form-control"/>
    </div>
    <div class="form-inline">
        <label>Status</label>
        <label><input type="checkbox" name="status" required="required" class="status"/>Active</label>
    </div>

    <button type="submit" class="btn btn-success">Save</button>
    <a href="${SITE_URL}/admin/event" class="btn btn-danger">Back</a>
</form>
<br/>
<table class="table">
    <thead>
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Start date</th>
            <th>End date</th>
            <th>Status</th>
            <th>Link<th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="event" items="${requestScope.events}">
            <tr>
                <td>${event.id}</td>
                <td>${event.title}</td>
                <td>${event.startDate}</td>
                <td>${event.endDate}</td>
                <td>${event.status}</td>
                <td><a href="${SITE_URL}${event.link}" target="_blank">link</a></td>
                <td>
                    <a href="${SITE_URL}/admin/event/edit?id=${event.id}" class="btn btn-success btn-xs">
                        <i class="fas fa-edit"></i>
                    </a>
                    <a href="${SITE_URL}/admin/event/delete?id=${event.id}" class="btn btn-success btn-xs">
                        <i class="fas fa-window-close"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<%@include file="../shared/footer.jsp" %>

