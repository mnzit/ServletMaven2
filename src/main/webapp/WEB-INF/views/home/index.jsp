<%@include file="../admin/shared/header.jsp" %>
<c:if test ="${param.error != null}"> 
    <div class="alert alert-danger" role="alert">
        Your username/password is incorrect
    </div> 
</c:if>


    ${requestScope.message}
<div class="container pt-3">
    <div class="row justify-content-sm-center">
        <div class="col-sm-6 col-md-4">

            <div class="card border-info text-center">
                <div class="card-header">
                    Sign in to continue
                </div>
                <div class="card-body">
                    <form action="" method="post">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Username</label>
                            <input type="text" name = "username" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">
                            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Password</label>
                            <input type="password" name = "password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                        </div>
                        <button type="submit" class="btn btn-primary">Submit</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="../admin/shared/footer.jsp" %>