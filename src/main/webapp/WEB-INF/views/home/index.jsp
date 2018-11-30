<%-- 
    Document   : index
    Created on : Nov 29, 2018, 1:35:10 PM
    Author     : Mnzit
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body class="text-center">
        <h1>Welcome ${requestScope.name}</h1>
        <c:if test ="${param.error != null}"> 
            <div class="alert alert-danger" role="alert">
                Your username/password is incorrect
            </div> 
        </c:if>
        <div class="container pt-3">
            <div class="row justify-content-sm-center">
                <div class="col-sm-6 col-md-4">

                    <div class="card border-info text-center">
                        <div class="card-header">
                            Sign in to continue
                        </div>
                        <div class="card-body">
                            <img src="https://placeimg.com/128/128/tech/sepia">
                            <h4 class="text-center">Hunger & Debt Ltd</h4>
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
                    <a href="#" class="float-right">Create an account </a>
                </div>
            </div>
        </div>

    </body>
</html>
