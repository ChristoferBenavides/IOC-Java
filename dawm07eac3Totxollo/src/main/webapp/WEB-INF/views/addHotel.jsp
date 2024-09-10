<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
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
            <form:form modelAttribute="newXollo" class="form-horizontal">
                <fieldset>
                    <legend>Afegir Hotel</legend>
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="codi">Codi</label>
                        <div class="col-lg-10">
                            <form:input id="codi" path="codi" type="text" class="form:input-large"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="titol">Titol</label>
                        <div class="col-lg-10">
                            <form:input id="titol" path="titol" type="text" class="form:input-large"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="numeroUnitats">Nombre d'unitats</label>
                        <div class="col-lg-10">
                            <form:input id="numeroUnitats" path="numeroUnitats" type="text" class="form:input-large"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="nom">Nom</label>
                        <div class="col-lg-10">
                            <form:input id="nom" path="nom" type="text" class="form:input-large"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="habitacio">Habitació</label>
                        <div class="col-lg-10">
                            <form:input id="habitacio" path="habitacio" type="text" class="form:input-large"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="direccio">Direcció</label>
                        <div class="col-lg-10">
                            <form:input id="direccio" path="direccio" type="text" class="form:input-large"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-lg-2 col-lg-2" for="descripcio">Descripció</label>
                        <div class="col-lg-10">
                            <form:textarea id="descripcio" path="descripcio" rows="4" maxlength="100" class="form-control"/>
                        </div>
                    </div>    
                    <div class="form-group">
                        <div class="col-lg-offset-2 col-lg-10">
                            <input type="submit" id="btnAdd" class="btn btn-primary"
                                   value ="Crear"/>
                        </div>
                    </div>
                </fieldset>
            </form:form>
        </section>
    </body>
</html>
