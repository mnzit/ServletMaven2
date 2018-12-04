
<%@include file="../shared/header.jsp" %>
<div class="page-header">
    <h1>Add Mail Template</h1>
</div>
<form  method="post" action="">
      <div class="row">
          <div class="form-group">
              <label>Name</label>
              <input type="text" name="name" required="required" class="form-control"/>
          </div>
    </div>
    <div class="row"> 
          <div class="form-group">
              <label>Description</label>
              <textarea type="text" name="description" required="required" class="form-control" style="height:150px;"></textarea>
          </div>
    </div>
    <div class="row">
          <div class="form-inline">
              <label>Status</label>
              <label><input type="checkbox" name="status" required="required" class="status"/>Active</label>
          </div>
    </div>
    <button type="submit" class="btn btn-success">Save</button>
    <a href="${SITE_URL}/admin/mailtemplate" class="btn btn-danger">Back</a>
</form>
<%@include file="../shared/footer.jsp" %>

