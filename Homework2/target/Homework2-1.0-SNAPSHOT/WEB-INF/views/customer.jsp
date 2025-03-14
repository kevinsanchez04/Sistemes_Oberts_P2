<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
            <title>Customer</title>
            <link rel="icon" href="https://static.vecteezy.com/system/resources/previews/002/206/011/original/article-icon-free-vector.jpg">
            <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
            <!-- FontAwesome -->
            <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
                  rel="stylesheet"
                  integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
                  crossorigin="anonymous"/>
            <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.0/font/bootstrap-icons.min.css" rel="stylesheet">
            <link rel="preconnect" href="https://fonts.googleapis.com">
            <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
            <link href="https://fonts.googleapis.com/css2?family=Parkinsans:wght@300..800&display=swap" rel="stylesheet">
            <style>
                *{
                    color: black;
                }
                body{
                    background: lightgray;
                }
                *{
                  font-family: 'Parkinsans';
                }
            </style>
    </head>
    <body class="d-flex flex-column min-vh-100">
         <jsp:include page="/WEB-INF/views/layout/nav.jsp" />
        <div class="container mt-4 mb-4">
            <div class="card bg-secondary shadow-sm mb-4">
                <div class="card-header bg-dark text-center py-3">
                    <h1 class="card-title text-white mb-0">${customer.username}</h1>
                </div>
                <div class="card-body text-center">
                    <img src="${customer.profilePhoto}" alt="Imatge usuari" class="card-img-top img-thumbnail mb-4" style="max-width: fit-content;"/>
                    <p class="text-light">${customer.description}</p>
                    <p class="card-text mb-1">Data creacio: ${customer.dataCreacio}</p>
                    <p class="card-text">Tipus d'usuari: ${customer.tipusUsuari}</p>
                    <c:if test="${customer.author}">
                             <a class="btn btn-primary mt-3" href="#article${customer.links.id}">Ultim article publicat</a>
                    </c:if>        
                </div>
            </div>    
            <c:if test="${customer.author}">
                <h3 class="text-center mb-4 border border-dark border-5 p-4 m-4">Llistat d'articles</h3>    
                <div class="row">
                        <div class="col-12">
                            <c:forEach var="article" items="${customer.articles}">
                                <a id="article${article.id}" href="/Homework2/Web/Article/${article.id}" class="card bg-secondary text-white mb-4 shadow-sm text-decoration-none">
                                    <img class="card-img-top" style="height: 15rem; object-fit: cover;" src="${article.imatge}" alt="Imagen Articulo">
                                    <div class="card-body text-center">
                                        <h2 class="card-title">${article.titol}</h2>
                                        <p class="text-light">Data creacio: ${article.data}</p>
                                        <p class="card-text">${article.resum}</p>
                                        <p class="card-text">Visualitacions: ${article.visualitzacions}</p>
                                        <p>Topics: ${article.topics}</p>                                    
                                    </div>
                                </a>
                            </c:forEach>
                        </div>
                </div>
            </c:if>  
        </div>
        <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
    </body>
</html>

