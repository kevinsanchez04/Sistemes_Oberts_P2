<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Articles</title>
        <link rel="icon" href="https://th.bing.com/th/id/R.d77e50fa135055406fbeadb0b22b3a1d?rik=IKd5fSdJqcvPCw&pid=ImgRaw&r=0">
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
        
        <button class="btn btn-dark w-100 rounded-bottom text-white" href="#" data-bs-toggle="offcanvas" data-bs-target="#filtre" style="font-family:'Parkinsans'">Filtre</button>
	
        <div class="offcanvas offcanvas-start" tabindex="-1" id="filtre" >
            <div class="offcanvas-header pb-0">
                    <h5 class="offcanvas-title">Filtre Articles</h5>
            </div>
            <div class="offcanvas-body">
                <jsp:include page="/WEB-INF/views/layout/form.jsp" />
            </div>
        </div>
            
        <c:if test="${not empty message}">
            <div class="alert alert-danger" role="alert">
                ${message}        
            </div>
        </c:if> 
                    
        <div class="container-fluid">
            <div class="row row-cols-1 row-cols-sm-1 row-cols-md-1 row-cols-xl-2 row-cols-xxl-3">
                <c:forEach var="art" items="${articles}">
                        <div class="col pt-3">
                            <div class="card border border-dark m-1 p-0">
                                <a href="${pageContext.request.contextPath}/Web/Article/${art.id}" style="text-decoration: none;">
                                <img class="card-img-top p-3" style="height: 15rem; object-fit: contain;" src="${art.imatge}" alt="Imagen Articulo">
                                <div class="card-body pt-0 pb-3 pr-3 pl-3">
                                    <h5 class="card-title">${art.titol}</h5>
                                    <p class="card-text">${art.resum}</p>
                                    <div class="d-flex justify-content-between">
                                        <div class="d-flex justify-content-center align-items-center mb-2">
                                          <img style="height:2rem; aspect-ratio: 1; object-fit: cover;" class="img-fluid rounded-circle me-3" src="https://static.vecteezy.com/system/resources/previews/001/131/187/large_2x/serious-man-portrait-real-people-high-definition-grey-background-photo.jpg" alt="Imagen Autor">
                                          <p class="text-center mb-0">${art.autor}</p>
                                        </div>
                                        <div class="d-flex justify-content-between">
                                          <div class="d-flex me-3">
                                            <c:if test="${art.privacitat == true}">
                                                <i class="bi bi-key-fill me-2"></i>
                                            </c:if>
                                            <p>${art.visualitzacions}</p>
                                          </div>
                                          <div>
                                            <p>${art.splitData()}</p>
                                          </div>
                                        </div>
                                    </div>
                                </div>
                                </a>
                                <a type="button" href="lamamas" class="btn btn-dark">
                                  DELETE
                                </a>
                            </div>
                        </div>
                </c:forEach>
            </div>  
        </div>
        <jsp:include page="/WEB-INF/views/layout/footer.jsp" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
