<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log In</title>
        <link rel="icon" href="https://static.vecteezy.com/system/resources/previews/002/206/011/original/article-icon-free-vector.jpg">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        </style>
        
    </head>
    <body class="d-flex flex-column min-vh-100">
        <jsp:include page="/WEB-INF/views/layout/nav.jsp" />
        
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <strong>${errorMessage}</strong>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        </c:if>
        <h2 class="text-center m-0 mt-3">Login with your Account</h2>
        <form action="${pageContext.request.contextPath}/Web/LogIn/article" method="GET" class="d-flex flex-column align-items-center justify-content-center">
          <div class="w-75 m-3 d-flex align-items-center border border-dark rounded bg-dark text-white">
            <i class="p-1 bi bi-person"></i>
            <input class="form-control input" type="text" name="username" placeholder="Enter your username" >
          </div>
          <div class="w-75 m-3 d-flex align-items-center border border-dark rounded bg-dark text-white">
            <i class="p-1 bi bi-key"></i>
            <input class="form-control input" type="password" name="password" placeholder="Enter your password" >
          </div>
          <input type="hidden" name="id" value="${valor}">
          <button class="w-75 border border-dark rounded bg-dark text-white" id="enviar" type="submit">LOGIN NOW</button>
        </form>
        
        <footer class="fixed-bottom">
            <jsp:include page="/WEB-INF/views/layout/footer.jsp"/>
        </footer>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
