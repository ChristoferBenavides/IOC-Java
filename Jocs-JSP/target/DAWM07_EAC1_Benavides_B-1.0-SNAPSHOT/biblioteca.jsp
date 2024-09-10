<%-- 
    Document   : biblioteca
    Created on : 08-sep-2019
    Author     : Germán Flores
--%>
<%@page import="java.text.DecimalFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    Map<String, Double> puntuacions = new HashMap();
    List<String> jocs = new ArrayList();
%>
<%
    //Definim aquestes variables per fer-les servir al BODY
    String jocDiv = "";

    /*
     TODO
     Els jocs són els que podeu veure a la carpeta img 
     (excepte check.png i logo png)
     Fem coincidir el nom del joc amb el nom del fitxer sense l'extensió
     (spiderman, godofwar, fortnite,...)
     
     Què heu de fer?
     Afegir tots els jocs
     */
    jocs.add("fortnite");
    jocs.add("godofwar");
    jocs.add("hellblade");
    jocs.add("mario");
    jocs.add("reddeadredemption2");
    jocs.add("spiderman");
    jocs.add("tetris");
    jocs.add("uncharted4");              

    /*
     TODO
     Si s'està executant aquesta pàgina és perquè l'usuari ha fet clic a un dels
     enllaços de Puntuació, llavors la url serà: 
     .../biblioteca.jsp?joc=xxx&puntuacio=yyy
     on xxx és el nom del joc i 'yyy' és la puntuació que li volem donar.
     A la variable Java joc, hem recuperat de quin joc es tracta, 
     concretament amb  request.getParameter("joc").
     Hem fet coincidir el nom del paràmetre  amb el nom de la variable Java, 
     però és casualitat. Hem fet el mateix amb puntuació.
     Què heu de fer?
     Afegiu el joc i la puntuació a les puntuacions
        (si no és null)
     */
    String joc = request.getParameter("joc");
    String puntuacio = request.getParameter("puntuacio");
    if(joc != null && puntuacio != null){
        puntuacions.put(joc, Double.valueOf(puntuacio));
    }   
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Biblioteca</title>
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
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-8">
                    <h1>Jocs</h1>
                </div>
                <div class="col-md-2">
                    <h1>Puntuacions</h1>
                </div>
            </div>                
            <div class="row">
                <div class="col-md-8">
                    <div class="row">
                        <div class="col-md-3 divJoc">
                            <div class="row">
                                <%  
                                    jocDiv = "spiderman";
                                    pageContext.setAttribute("jocDiv", jocDiv);
                                %>                               
                                <img class="img-responsive" src='img/<%=jocDiv%>.jpg'/> 
                            </div>
                            <div class="row">
                                <%
                                    if(puntuacions.get(jocDiv) != null) {
                                        puntuacio = String.valueOf(puntuacions.get(jocDiv));
                                    } else {
                                        puntuacio = "";
                                    }
                                %>
                                <div class="col-md-12">
                                    <h4>Puntuació: <%=puntuacio%> punts</h4>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <h5>Quantitat:</h5>
                                </div>
                                 <!--
                                TODO
                                Si ja s'han afegit jocs, com podeu veure a les imatges de l'enunciat,
                                es mostra un check i si no, mostren l'enllaç 1,2,3,4 o 5
                                Què heu de fer?
                                Mostrar el check o els enllaços depenent de si el joc està afegit o no.
                                Com?
                                Heu de mirar si el Map conté l'element jocDiv,
                                    Si el conté, llavors
                                        heu de mostrar tal qual 
                                            <div class="col-md-6">

                                            </div>
                                            <div class="col-md-2">
                                                <img class = "img-responsive" src='img/check.png'/>
                                            </div>
                                    Si no el conté, llavors
                                        heu de mostrar 
                                            <div class="col-md-5">
                                                <h4><a href='xxx'>1</a></h4>
                                                <h4><a href='xxx'>2</a></h4>
                                                <h4><a href='xxx'>3</a></h4>
                                                <h4><a href='xxx'>4</a></h4>
                                                <h4><a href='xxx'>5</a></h4>
                                            </div>
                                            <div class="col-md-3">

                                            </div>                                        
                                            on xxx l'heu de construir amb JSTL i la url ha de ser:
                                            biblioteca.jsp?joc=yyy&puntuacio=zzz
                                                on yyy és el joc d'aquesta div
                                                i  zzz és la puntuació (pot ser: 1,2,3,4, o 5).
                                            Feu un bucle for del 1 al 5 per construir amb JSTL 
                                            les url amb els enllaços anteriors.
                                --> 
                                <c:choose>
                                    <c:when test="${puntuacions.containsKey(jocDiv)}">
                                        <div class="col-md-6">
                                        </div>
                                        <div class="col-md-2">
                                            <img class = "img-responsive" src='img/check.png'/>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="col-md-5">
                                            
                                        </div>
                                        <c:forEach var="counter" begin="1" end="5">                                           
                                            <a href="<c:url value = "biblioteca.jsp?joc=${jocDiv}&puntuacio= ${counter}"/>">${counter}</a>
                                                                                                                                                                                  
                                        </c:forEach> 
                                    <div class="col-md-3">
                                    </div> 
                                    </c:otherwise>    
                                </c:choose>                                                                               
                            </div>                            
                        </div>
                        <!--
                            TODO
                            Un cop fet la div del joc spiderman, copieu-la per a cada joc.
                            Recordeu que a cada div heu de canviar el valor jocDiv.
                            Poseu 4 jocs en aquesta <div class="row"> i els altres quatre en altra nova.
                            Us ha de quedar aquesta estructura:
                                <div class="col-md-8">
                                    <div class="row">
                                        divs de 4 jocs
                                    </div>
                                    <div class="row">
                                        divs de 4 jocs
                                    </div>
                                </div>
                            -->
                                
                        <!-- TODO Aqui els altres tres jocs de la primera row -->      
                         <div class="col-md-3 divJoc">
                            <div class="row">
                                <%  
                                    jocDiv = "hellblade";
                                    pageContext.setAttribute("jocDiv", jocDiv);
                                %>                               
                                <img class="img-responsive" src='img/<%=jocDiv%>.jpg'/> 
                            </div>
                            <div class="row">
                                <%
                                    if(puntuacions.get(jocDiv) != null) {
                                        puntuacio = String.valueOf(puntuacions.get(jocDiv));
                                    } else {
                                        puntuacio = "";
                                    }
                                %>
                                <div class="col-md-12">
                                    <h4>Puntuació: <%=puntuacio%> punts</h4>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <h5>Quantitat:</h5>
                                </div>
                                
                                <c:choose>
                                    <c:when test="${puntuacions.containsKey(jocDiv)}">
                                        <div class="col-md-6">
                                        </div>
                                        <div class="col-md-2">
                                            <img class = "img-responsive" src='img/check.png'/>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="col-md-5">
                                            
                                        </div>
                                        <c:forEach var="counter" begin="1" end="5">                                           
                                            <a href="<c:url value = "biblioteca.jsp?joc=${jocDiv}&puntuacio= ${counter}"/>">${counter}</a>
                                                                                                                                                                                  
                                        </c:forEach> 
                                    <div class="col-md-3">
                                    </div> 
                                    </c:otherwise>    
                                </c:choose>                                                                               
                            </div>                            
                        </div>       
                        <div class="col-md-3 divJoc">
                            <div class="row">
                                <%  
                                    jocDiv = "godofwar";
                                    pageContext.setAttribute("jocDiv", jocDiv);
                                %>                               
                                <img class="img-responsive" src='img/<%=jocDiv%>.jpg'/> 
                            </div>
                            <div class="row">
                                <%
                                    if(puntuacions.get(jocDiv) != null) {
                                        puntuacio = String.valueOf(puntuacions.get(jocDiv));
                                    } else {
                                        puntuacio = "";
                                    }
                                %>
                                <div class="col-md-12">
                                    <h4>Puntuació: <%=puntuacio%> punts</h4>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <h5>Quantitat:</h5>
                                </div>
                                
                                <c:choose>
                                    <c:when test="${puntuacions.containsKey(jocDiv)}">
                                        <div class="col-md-6">
                                        </div>
                                        <div class="col-md-2">
                                            <img class = "img-responsive" src='img/check.png'/>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="col-md-5">
                                            
                                        </div>
                                        <c:forEach var="counter" begin="1" end="5">                                           
                                            <a href="<c:url value = "biblioteca.jsp?joc=${jocDiv}&puntuacio= ${counter}"/>">${counter}</a>
                                                                                                                                                                                  
                                        </c:forEach> 
                                    <div class="col-md-3">
                                    </div> 
                                    </c:otherwise>    
                                </c:choose>                                                                               
                            </div>                            
                        </div>        
                        <div class="col-md-3 divJoc">
                            <div class="row">
                                <%  
                                    jocDiv = "fortnite";
                                    pageContext.setAttribute("jocDiv", jocDiv);
                                %>                               
                                <img class="img-responsive" src='img/<%=jocDiv%>.jpg'/> 
                            </div>
                            <div class="row">
                                <%
                                    if(puntuacions.get(jocDiv) != null) {
                                        puntuacio = String.valueOf(puntuacions.get(jocDiv));
                                    } else {
                                        puntuacio = "";
                                    }
                                %>
                                <div class="col-md-12">
                                    <h4>Puntuació: <%=puntuacio%> punts</h4>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <h5>Quantitat:</h5>
                                </div>
                                
                                <c:choose>
                                    <c:when test="${puntuacions.containsKey(jocDiv)}">
                                        <div class="col-md-6">
                                        </div>
                                        <div class="col-md-2">
                                            <img class = "img-responsive" src='img/check.png'/>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="col-md-5">
                                            
                                        </div>
                                        <c:forEach var="counter" begin="1" end="5">                                           
                                            <a href="<c:url value = "biblioteca.jsp?joc=${jocDiv}&puntuacio= ${counter}"/>">${counter}</a>
                                                                                                                                                                                  
                                        </c:forEach> 
                                    <div class="col-md-3">
                                    </div> 
                                    </c:otherwise>    
                                </c:choose>                                                                               
                            </div>                            
                        </div>        
                                
                    </div>
                    <div class="row">
                         <!-- TODO Aqui els altres quatre jocs -->
                         <div class="col-md-3 divJoc">
                            <div class="row">
                                <%  
                                    jocDiv = "uncharted4";
                                    pageContext.setAttribute("jocDiv", jocDiv);
                                %>                               
                                <img class="img-responsive" src='img/<%=jocDiv%>.jpg'/> 
                            </div>
                            <div class="row">
                                <%
                                    if(puntuacions.get(jocDiv) != null) {
                                        puntuacio = String.valueOf(puntuacions.get(jocDiv));
                                    } else {
                                        puntuacio = "";
                                    }
                                %>
                                <div class="col-md-12">
                                    <h4>Puntuació: <%=puntuacio%> punts</h4>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <h5>Quantitat:</h5>
                                </div>
                                
                                <c:choose>
                                    <c:when test="${puntuacions.containsKey(jocDiv)}">
                                        <div class="col-md-6">
                                        </div>
                                        <div class="col-md-2">
                                            <img class = "img-responsive" src='img/check.png'/>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="col-md-5">
                                            
                                        </div>
                                        <c:forEach var="counter" begin="1" end="5">                                           
                                            <a href="<c:url value = "biblioteca.jsp?joc=${jocDiv}&puntuacio= ${counter}"/>">${counter}</a>
                                                                                                                                                                                  
                                        </c:forEach> 
                                    <div class="col-md-3">
                                    </div> 
                                    </c:otherwise>    
                                </c:choose>                                                                               
                            </div>                            
                        </div>
                        <div class="col-md-3 divJoc">
                            <div class="row">
                                <%  
                                    jocDiv = "tetris";
                                    pageContext.setAttribute("jocDiv", jocDiv);
                                %>                               
                                <img class="img-responsive" src='img/<%=jocDiv%>.jpg'/> 
                            </div>
                            <div class="row">
                                <%
                                    if(puntuacions.get(jocDiv) != null) {
                                        puntuacio = String.valueOf(puntuacions.get(jocDiv));
                                    } else {
                                        puntuacio = "";
                                    }
                                %>
                                <div class="col-md-12">
                                    <h4>Puntuació: <%=puntuacio%> punts</h4>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <h5>Quantitat:</h5>
                                </div>
                                
                                <c:choose>
                                    <c:when test="${puntuacions.containsKey(jocDiv)}">
                                        <div class="col-md-6">
                                        </div>
                                        <div class="col-md-2">
                                            <img class = "img-responsive" src='img/check.png'/>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="col-md-5">
                                            
                                        </div>
                                        <c:forEach var="counter" begin="1" end="5">                                           
                                            <a href="<c:url value = "biblioteca.jsp?joc=${jocDiv}&puntuacio= ${counter}"/>">${counter}</a>
                                                                                                                                                                                  
                                        </c:forEach> 
                                    <div class="col-md-3">
                                    </div> 
                                    </c:otherwise>    
                                </c:choose>                                                                               
                            </div>                            
                        </div>
                        <div class="col-md-3 divJoc">
                            <div class="row">
                                <%  
                                    jocDiv = "reddeadredemption2";
                                    pageContext.setAttribute("jocDiv", jocDiv);
                                %>                               
                                <img class="img-responsive" src='img/<%=jocDiv%>.jpg'/> 
                            </div>
                            <div class="row">
                                <%
                                    if(puntuacions.get(jocDiv) != null) {
                                        puntuacio = String.valueOf(puntuacions.get(jocDiv));
                                    } else {
                                        puntuacio = "";
                                    }
                                %>
                                <div class="col-md-12">
                                    <h4>Puntuació: <%=puntuacio%> punts</h4>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <h5>Quantitat:</h5>
                                </div>                              
                                <c:choose>
                                    <c:when test="${puntuacions.containsKey(jocDiv)}">
                                        <div class="col-md-6">
                                        </div>
                                        <div class="col-md-2">
                                            <img class = "img-responsive" src='img/check.png'/>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="col-md-5">
                                            
                                        </div>
                                        <c:forEach var="counter" begin="1" end="5">                                           
                                            <a href="<c:url value = 'biblioteca.jsp?joc=${jocDiv}&puntuacio= ${counter}'/>">${counter}</a>
                                                                                                                                                                                  
                                        </c:forEach> 
                                    <div class="col-md-3">
                                    </div> 
                                    </c:otherwise>    
                                </c:choose>                                                                               
                            </div>                            
                        </div>
                        <div class="col-md-3 divJoc">
                            <div class="row">
                                <%  
                                    jocDiv = "mario";
                                    pageContext.setAttribute("jocDiv", jocDiv);
                                %>                               
                                <img class="img-responsive" src='img/<%=jocDiv%>.jpg'/> 
                            </div>
                            <div class="row">
                                <%
                                    if(puntuacions.get(jocDiv) != null) {
                                        puntuacio = String.valueOf(puntuacions.get(jocDiv));
                                    } else {
                                        puntuacio = "";
                                    }
                                %>
                                <div class="col-md-12">
                                    <h4>Puntuació: <%=puntuacio%> punts</h4>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <h5>Quantitat:</h5>
                                </div>
                                
                                <c:choose>
                                    <c:when test="${puntuacions.containsKey(jocDiv)}">
                                        <div class="col-md-6">
                                        </div>
                                        <div class="col-md-2">
                                            <img class = "img-responsive" src='img/check.png'/>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="col-md-5">
                                            
                                        </div>
                                        <c:forEach var="counter" begin="1" end="5">                                           
                                            <a href="<c:url value = "biblioteca.jsp?joc=${jocDiv}&puntuacio= ${counter}"/>">${counter}</a>
                                                                                                                                                                                  
                                        </c:forEach> 
                                    <div class="col-md-3">
                                    </div> 
                                    </c:otherwise>    
                                </c:choose>                                                                               
                            </div>                            
                        </div>        
                    </div>        
                </div>
                <div class="col-md-4">
                    <div class="row">
                        <div class="col-md-6">
                            <img class = "img-responsive" src='img/logo.png'/>
                        </div>
                        <div class="col-md-4">

                            <%
                                /*
                                 TODO
                                 Calculeu el valor de totalJocsPuntuats nombre de jocs afegits a les puntuacions
                                 Calculeu el valor mitjanaPuntuacio mimtjana de les puntuacions dels jocs de la biblioteca
                                 */
                                Integer totalJocsPuntuats = 0;
                                Double mitjanaPuntuacio = 0.0;
                                
                                /*
                                TODO
                                Per calcular el total de jocs heu de recòrrer al map anomenat puntuacions.
                                Ho podeu fer amb un bucle de tipus for on a cada volta mireu si les puntuacions
                                inclouen el joc.
                                Per exemple, el for ha de ser així:
                                for (Map.Entry<String, Integer> v : puntuacions.entrySet())
                                
                                on v és l'associació <Joc, Puntuació>
                                
                                Anem comptant el numero de jocs afegits i, de pas, fem la mitjana de les puntuacions de cada un.
                                */
                                for (Map.Entry<String, Double> v : puntuacions.entrySet()){
                                    if (!v.getKey().isEmpty()){
                                        totalJocsPuntuats++;
                                    }                                    
                                    mitjanaPuntuacio = mitjanaPuntuacio + v.getValue();
                                }                                                    
                            %>
                            <h4>
                                Jocs puntuats: <h5> <%= totalJocsPuntuats%></h5>
                            </h4>
                            <h4>
                                Mitjana puntuacions: <h5> <%=mitjanaPuntuacio / totalJocsPuntuats%></h5>
                            </h4>
                            <h4><a href='<c:url value="review.jsp"/>'>Veure</a></h4>
                            <%
                                /*
                                 TODO
                                 Necessitarem que les variables jocs i puntuacions
                                 siguin accessibles desde JSTL. Ho necessitareu a review.jsp
                                 Què heu de fer?
                                 Feu que jocs i puntuacions siguin accessibles desde JSTL
                                 */
                            session.setAttribute("puntuacions",puntuacions);
                            session.setAttribute("jocs",jocs);
                            %>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </body>
</html>
