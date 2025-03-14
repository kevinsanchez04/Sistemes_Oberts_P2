<%-- 
    Document   : article.jsp
    Created on : 14 Dec 2024, 17:21:52
    Author     : iulia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Article</title>
        <link rel="icon" href="https://static.vecteezy.com/system/resources/previews/002/206/011/original/article-icon-free-vector.jpg">
        <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <!-- FontAwesome -->
        <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous"/>
        <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.0/font/bootstrap-icons.min.css" rel="stylesheet">
        
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Parkinsans:wght@300..800&display=swap" rel="stylesheet">
        
        <style>
            body{
                background: lightgray;
            }
            
            *{
              font-family: 'Parkinsans';
            }
            
            a{
                text-decoration: none;
                color : black;
            }
            
        </style>
        
    </head>
    <body>
        <jsp:include page="/WEB-INF/views/layout/nav.jsp" />
        <div class="container mt-2 mt-lg-5 ">
            <div class="d-flex justify-content-center">
                <div class="col-12 col-lg-6 border border-dark border-5 rounded p-4 bg-white">
                    <img class="card-img-top mb-4" style="height: 15rem; object-fit: contain;" src="${article.imatge}" alt="Imagen Articulo">
                    <h2 class="card-title">${article.titol}</h2>
                    <div class="d-flex justify-content-between">
                        <div class="">
                          <a class="d-flex" href="${pageContext.request.contextPath}/Web/Customer/name/${article.autor}">
                            <img style="height:2rem; aspect-ratio: 1; object-fit: cover;" class="img-fluid rounded-circle me-3" src="${article.imatgeAutor}" alt="Imagen Autor">
                            <p class="text-center mb-0">${article.autor}</p>
                          </a>
                          <div class="d-flex justify-content-between">
                            <div class="d-flex me-3">
                                <i class="bi bi-eye-fill me-2"></i>
                                <p>${article.visualitzacions}</p>
                            </div>
                            <div>
                                <p>${article.splitData()}</p>
                            </div>
                          </div>
                        </div>
                        <div class="text-primary">
                          <p class="mb-0">${article.topics.get(0)}</p>
                          <p>${article.topics.get(1)}</p>
                        </div>
                      </div>
                    <p class="card-text">
                        ${article.text}
                    </p>
                    <a type="button" href="${pageContext.request.contextPath}/Web/Article/Delete/${article.id}" class="btn btn-dark w-100">
                    DELETE
                    </a>
                </div>
            </div>
        </div>
        <footer class="fixed-bottom">
            <jsp:include page="/WEB-INF/views/layout/footer.jsp"/>
        </footer>      
    </body>
</html>
