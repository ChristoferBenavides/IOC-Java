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
        <section>
            <div class="jumbotron">
                <div class="container">
                    <h1> ${banner} </h1>
                    <p> ${tagline} </p>
                </div>
            </div>
        </section>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h1>Venda</h1>
                    <p>Heu de canviar la URL per aquest patró</p>
                    <p>vendaXollo/codi</p>
                    <p>Per exemple, si voleu fer una venda pel vol0 seria vendaXollo/vol0</p>
                    <p>
                        <a href="<spring:url value='/vendaXollo/vol0'/>" class="btn btn-primary">
                            <span class="glyphicon-info-sign glyphicon"/> Go
                        </a>
                    </p>
                </div>
            </div>
        </div>
    </body>
</html>

