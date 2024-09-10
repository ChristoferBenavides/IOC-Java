<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <title>Home</title>
    </head>
    <body>
        <div class="row">
            <div class="col-md-2">
               <img id="logo" style="width: 128px;" src="${pageContext.request.contextPath}/views/img/totxollo.png"/>
            </div>
            <div class="col-md-10">  
                <nav>
                   <ul class="nav nav-pills">
                      <li role="presentation" class="active">
                         <a href="<spring:url value= '/'/>">Inici</a>
                      </li>
                      <sec:authorize access="isAuthenticated()">
                        <li role="Presentation" class="active">
                            <a href="<spring:url value='/j_spring_security_logout' />" class="btn btn-danger btn-mini pull-right">Desconnectar</a>
                        </li>
                      </sec:authorize> 
                   </ul>    
                 </nav>
            </div>
        </div>
        <div class="jumbotron">
            <div class="container">
                <h1> ${banner} </h1>
                <p> ${tagline} </p>
            </div>
        </div>
        <section class="container">
            <div class="row">
                <c:forEach items="${xollo}" var="xollo">
                    <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                        <div class="thumbnail">
                            <div class="caption">
                                <h3>${xollo.titol}</h3>
                                <p>${xollo.codi}</p>
                                <p>${xollo.descripcio}</p>
                                <p>Hi ha ${xollo.numeroUnitats} exemplars</p>
                                <p>Hi ha ${xollo.numeroReserves} exemplars reservats</p>                               
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </section>    
    </body>
</html>
