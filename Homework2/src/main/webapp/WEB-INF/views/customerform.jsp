<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Editar Perfil</title>
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
        <div class="container mt-5">
            <section class="row justify-content-center">
                <c:if test="${ok != null}">
                    <div class="alert alert-success alert-dismissible fade show" role="alert">
                        <strong>S'han modificat les dades correctament</strong>
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                </c:if>
                    <form class="col col-lg-6" action="${pageContext.request.contextPath}/Web/Customer/EditProfile" method="POST">
                    <label class="d-block text-center">Editar Perfil (les caselles en blanc mantindran les dades actuals)</label>
                    <section>
                        <!-- Username -->
                        <section class="d-flex flex-column mt-3">
                            <label for="HTML" class="mb-0">Username</label>
                            <input type="text" id="username" name="username" class="border border-2 border-dark rounded">
                        </section>
                        <!--Password-->
                        <section class="d-flex flex-column mt-3">
                            <label for="HTML" class="mb-0">Password</label>
                            <input type="password" id="password" name="password" class="border border-2 border-dark rounded"/>
                        </section>
                        <!-- Descripcio -->
                        <section class="d-flex flex-column mt-3">
                            <label for="HTML" class="mb-0">Descripcio</label>
                            <textarea type="text" id="description" name="description" rows="3" class="border border-2 border-dark rounded"></textarea>
                        </section>
                        <!-- Imatge -->
                        <section class="d-flex flex-column mt-3">
                            <label for="HTML" class="mb-0">Foto de perfil</label>
                            <input type="url" id="profilePhoto" name="profilePhoto" placeholder="https://example.com" class="border border-2 border-dark rounded">
                        </section>
                        <input class="d-flex mt-3 mb-3 w-100 bg-dark text-white border border-dark rounded" type="submit">
                    </section>
                </form>
            </section>
        </div>
        <jsp:include page="/WEB-INF/views/layout/alert.jsp"/>
            <jsp:include page="/WEB-INF/views/layout/footer.jsp"/>    
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
