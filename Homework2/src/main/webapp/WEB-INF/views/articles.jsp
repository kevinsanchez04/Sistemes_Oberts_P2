<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Articles</title>
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!-- FontAwesome -->
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
          rel="stylesheet"
          integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
          crossorigin="anonymous"/>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.0/font/bootstrap-icons.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <div class="row row-cols-1 row-cols-sm-1 row-cols-md-1 row-cols-xl-2 row-cols-xxl-3">
            <c:forEach var="art" items="${articles}">
                <div class="col pt-3">
                    <div class="card border border-dark m-1 p-0">
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
                                    <c:if test="${art.privacitat != false}">
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
                    </div>
                </div>
            </c:forEach>
        </div>
    </div> 
</body>
</html>