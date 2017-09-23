<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <link type="text/css" href="/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
<h2>Doctor Login Page</h2>
<form action="/app/login" method="post">
    <table class="table table-bordered">
        <tbody>
            <tr><th>Login Id</th><td><input type="text" name="name" required="required"> </td></tr>
            <tr><th>Password</th><td><input type="password" name="password" required="required"></td></tr>
            <tr><td colspan="2"><input type="submit" value="Log In" class="btn btn-success">${errMsg}</tr>
        </tbody>
    </table>
</form>
<a href="/app/register" class="btn btn-success">Add Doctor</a>
<script type="application/javascript" src="js/jquery.js"></script>
<script type="application/javascript" src="js/bootstrap.js"></script>


</body>
</html>