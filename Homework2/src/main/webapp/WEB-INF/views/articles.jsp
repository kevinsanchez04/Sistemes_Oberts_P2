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
    <body>
        <div class="container">
            <span class="row row-cols-1 row-cols-sm-1 row-cols-md-1 row-cols-xl-2 row-cols-xxl-3">
                <form action="${mvc.uri('/filter')}" method="GET" class="col pt-3">
                  <label class="d-block text-center">Select Topic</label>
                  <span class="d-inline-flex flex-wrap justify-content-center">
                    <span class="me-3">
                      <input class="me-1" type="checkbox" id="HTML" name="topics" value="HTML">
                      <label for="HTML" class="mb-0">HTML</label>
                    </span>
                    <span class="me-3">
                      <input class="me-1" type="checkbox" id="CSS" name="topics" value="CSS">
                      <label for="CSS" class="mb-0" >CSS</label>
                    </span>
                    <span class="me-3">
                      <input class="me-1" type="checkbox" name="topics" value="Python">
                      <label for="Python" class="mb-0">Python</label>
                    </span>
                    <span class="me-3">
                      <input class="me-1" type="checkbox" name="topics" value="C">
                      <label for="C" class="mb-0">C</label>
                    </span>
                    <span class="me-3">
                      <input class="me-1" type="checkbox" name="topics" value="JavaScript">
                      <label for="JavaScript" class="mb-0">JavaScript</label>
                    </span>
                    <span class="me-3">
                      <input class="me-1" type="checkbox" name="topics" value="Java">
                      <label for="Java" class="mb-0">Java</label>
                    </span>
                    <span class="me-3">
                      <input class="me-1" type="checkbox" name="topics" value="Web_Programming">
                      <label for="Web_Programming" class="mb-0">Web_Programming</label>
                    </span>
                  </span>
                  <span class="d-flex justify-content-center align-items-center mt-2">
                    <label class="mb-0 me-2" >Name of the author</label> 
                    <input type="text" name="author" value="NULL">
                  </span>
                  <span class="d-flex justify-content-center mt-3 mb-3">
                    <input type="submit" value="Submit">
                  </span>
                </form>
                <span class="col pt-3">
                  <p>ADD Article</p>
                </span>
                <span class="col pt-3">
                  <p>Login</p>
                </span>
            </span>
            <div class="row row-cols-1 row-cols-sm-1 row-cols-md-1 row-cols-xl-2 row-cols-xxl-3">
                <c:forEach var="art" items="${articles}">
                    <a href="${pageContext.request.contextPath}/Web/Article/${art.id}" style="text-decoration: none;">
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
                            </div>
                        </div>
                    </a>
                </c:forEach>
            </div>
        </div> 
    </body>
</html>