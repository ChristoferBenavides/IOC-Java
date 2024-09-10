<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
                <h1> Pàgina restringida! </h1>          
            </div>
        </div>                            
        <div class="container">
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title">Si us plau, proporcioni les seves dades</h3>
                        </div>
                        <div class="panel-body">
                            <c:if test="${not empty error}">
                                <div class="alert alert-danger">
                                    Credencials incorrectes
                                </div>
                            </c:if>
                            <form action="<c:url value="/j_spring_security_check"> </c:url>" method="post">
                                <fieldset>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Usuari" name='j_username' type="text">
                                    </div>
                                    <div class="form-group">
                                        <input class="form-control" placeholder="Contrasenya" name='j_password' type="password">
                                    </div>
                                    <input class="btn btn-lg btn-success btn-block" type="submit" value="Connectar">
                                </fieldset>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>