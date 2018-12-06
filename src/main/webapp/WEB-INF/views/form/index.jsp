<%@include file="../admin/shared/header.jsp" %>
<div class="jumbotron">
    <h1 class="display-4">${requestScope.event.title}</h1>
    <hr class="my-4">
    <p class="lead">${requestScope.event.description}</p>
</div>
<form  method="post" action="">
    <div class="form-group">
        <label>Firstname</label>
        <input type="text" name="first_name" required="required" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Lastname</label>
        <input type="text" name="last_name" required="required" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Email id</label>
        <input type="email" name="email_id" required="required" class="form-control"/>
    </div>
    <div class="form-group">
        <label>Contact no</label>
        <input type="number" name="contact_no" required="required" class="form-control"/>
    </div>

    <button type="submit" class="btn btn-success">Save</button>
    <a href="${SITE_URL}/admin/event" class="btn btn-danger">Back</a>
</form>
<%@include file="../admin/shared/footer.jsp" %>

