<%-- 
    Document   : index
    Created on : Mar 5, 2022, 2:32:30 PM
    Author     : hyngu
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </head>
    <body>
        <!--menu-->
        <nav class="navbar navbar-expand-md bg-dark navbar-dark">
            <!-- Brand -->
            <c:url value="/" var="homePage"/>
            <a class="navbar-brand" href="${homePage}">E-commerce Website</a>

            <!-- Toggler/collapsibe Button -->
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>

            <!-- Navbar links -->

            <div class="collapse navbar-collapse" id="collapsibleNavbar">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="${homePage}">Home</a>
                    </li>
                    <c:forEach items="${categories}" var="c">
                        <li class="nav-item">
                            <a class="nav-link" href="#">${c.name}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
            <c:url value="/" var="homeAction"/>
            <form class="form-inline" action="${homeAction}">
                <input class="form-control mr-sm-2" 
                       name="kw"
                       type="text" 
                       placeholder="nhap tu khoa">
                <button class="btn btn-success" type="submit">Search</button>
            </form>
        </nav>

        <!--body-->

        <div class="container">
            <h1 class="text-center text-info" >Product list </h1>

            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                    <c:forEach begin="1" end="${Math.ceil(productCounter/6)}" var="i">
                        <c:url value="/" var="myAction">
                            <c:param name="page" value="${i}"/>
                        </c:url>
                    <li class="page-item"><a class="page-link" href="${myAction}">${i}</a></li>
                    </c:forEach>
                <li class="page-item"><a class="page-link" href="#">Next</a></li>
            </ul>
            <div class="row">
                <c:forEach items="${products}" var="p">
                    <div class="col-md-4 col-sm-12" style="padding: 10px">
                        <div class="card">
                            <img class="card-img-top" src="${p.image}" alt="${p.name}">
                            <div class="card-body">
                                <h4 class="card-title">${p.name}</h4>
                                <p class="card-text">${p.price} VND</p>
                                <a href="#" class="btn btn-primary">See Detail</a>
                                <a href="#" class="btn btn-danger">add to card</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

        <!--footer-->
        <div class="jumbotron">
            <h1>E-commer Website</h1>
            <p>Nguyen gia hy &copy; 2022</p>
        </div>

    </body>
</html>
