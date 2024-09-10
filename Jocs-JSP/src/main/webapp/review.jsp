<%-- 
    Document   : review
    Created on : 09-09-2019
    Author     : Germán Flores
--%>
<%@page import="java.util.Map"%>
<%@page import="java.text.DecimalFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    /*
     TODO
     Si s'està executant aquesta pàgina perquè l'usuari ha donat a un dels
     enllaços Eliminar, llavors la url serà .../review.jsp?joc=xxx, on xxx
     és el nom del joc.
     A la variable Java joc, hem recuperat aquest nom del joc amb
     request.getParameter("joc") 
     I a la variable Java puntuacions, hem recuperat la llista de puntuacions
      amb session.getAttribute("reviews");     
     Què heu de fer?
     Elimineu el joc de la llista de puntuacions
     */
    String joc = request.getParameter("joc");
    Map<String, Double>  puntuacions = (Map) session.getAttribute("puntuacions");
    puntuacions.remove(joc);    
    
    /* 
     TODO
     Necessitareu la variable jocs de la pàgina biblioteca.jsp per calcular les mitges a les files JSTL
    */
    List<String> jocs = (List) session.getAttribute("jocs");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Puntuacions</title>
        <!-- CSS -->
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- css propis -->
        <link href="owncss/biblioteca.css" rel="stylesheet">

        <!-- JAVA SCRIPT -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>


    </head>
    <body>
        <c:set var="test" value="Valor d'una variable d'àmbit de sessió"
               scope="session" />
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-10">
                    <h1>Puntuacions realitzades</h1>
                </div>
            </div>                
            <div class="row">
                <div class="col-md-8">
                    <table class="table table-hover table-striped">
                        <thead class="thead-inverse">
                            <tr>
                                <th></th>
                                <th>Joc</th>
                                <th>Puntuació</th>
                                <th></th>
                            </tr>
                        </thead>
                        <!--
                        TODO
                        Amb JSTL heu de desenvolupar les files de la table que es pot veure a l'enunciat.
                        El contingut són els jocs que s'han puntuat
                        No cal que sigui exacte a la que veieu, però el contingut ha de ser el mateix.
                        L'enllaç Eliminar de cada fila, és l'element
                            <a  href='xxx'>Eliminar</a>
                                on xxx l'heu de construir amb JSTL i la url ha de ser review.jsp?joc=yyy
                                    on yyy és l'article de la fila
                        Per a la imatge, podeu fer servir la classe css ownImgTable
                        
                        Heu definir i calcular la variable JSTL PuntuacioMitjana com la mitjana de totes les puntuacions.
                        Aquesta variable l'utilitzareu per mostrar aquesta mitjana.
                        -->                       
                        <%
                            Double totalpunts = 0.0;
                            Double quantitat = 0.0;
                        %>
                        <tbody>                       
                            <c:forEach items="${puntuacions}" var="punts">
                                <c:set value="${punts.value}" var="valor"></c:set> 
                                <%                                  
                                Double puntsValor = (Double) pageContext.getAttribute("valor");                                                               
                                totalpunts = puntsValor + totalpunts;
                                quantitat++;
                                %>
                                <tr>
                                    <td><img src='img/${punts.key}.jpg' class="ownImgTable"></td>
                                    <td><c:out value="${punts.key}"/></td>
                                    <td><c:out value="${punts.value}"/></td>
                                    <td><a href='<c:url value = "review.jsp?joc=${punts.key}"/>'>Eliminar</a></td>
                                </tr>
                            </c:forEach>
                                <%
                                    Double resultatPuntuacio = totalpunts/quantitat;
                                %>
                                <c:set value="<%=resultatPuntuacio%>" var="resultat"></c:set>
                                <c:set var="PuntuacioMitjana" value="${resultat}" scope="page" />    
                        </tbody>                       
                        <tfoot>
                            <tr>     
                                <th></th>
                                <th class="text-right">Puntuació mitjana</th>                                                                        
                                <th>
                                    <<fmt:setLocale value="es_ES"/>
                                    <!-- 
                                    TODO
                                    heu de mostrar la mitjana de puntuacions al final de la taula
                                    -->
                                    
                                    
                                    < <fmt:formatNumber value="${PuntuacioMitjana}" type="number"/></th>
                                                                       
                                <th></th>
                            </tr>
                        </tfoot>
                    </table>                    
                </div>
                <div class="col-md-2">
                   <h4><a href='<c:url value="biblioteca.jsp"/>'>Tornar</a></h4>
                </div>
            </div>
        </div>
    </body>
</html>
