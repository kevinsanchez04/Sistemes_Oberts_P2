<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Customers</title>
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
        <!--Section-->
        <div class="container mt-4 mb-2">
        <div class="row justify-content-center">
            <!-- Inicializar el contador -->
            <c:set var="comptador" value="1" />
            <!-- Customers, crearem un per cada que en tinguem en la nostra BD -->
            <c:forEach var="csts" items="${customers}">   
                <div class="col-sm-6 col-md-4 col-lg-3">
                    <div class="card shadow-lg p-3 mb-3 bg-body rounded">
                        <a href="Customer/${csts.id}" class="text-decoration-none text-black">
                            <img src="${csts.profilePhoto}" alt="Imatge usuari" class="card-img-top img-fluid img-thumbnail" style="max-width: 400px; object-fit: cover" />
                            <div class="card-body">
                                <h3 id="username${comptador}">${csts.username}</h3>
                                <p>Customer amb id: ${csts.id}</p>
                                <p>Tipus usuari: ${csts.tipusUsuari}</p>
                            </div>
                        </a>
                        <c:if test="${csts.author}">
                            <a href="Article/${csts.links.id}" class="btn btn-primary mt-2">Link de l'�ltim article</a>
                        </c:if>
                    </div>
                </div>
                <!-- Incrementar el contador -->
                <c:set var="comptador" value="${comptador + 1}" />
            </c:forEach>  
        </div>
    </div>

        <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
