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
    <body>
        <jsp:include page="/WEB-INF/views/layout/nav.jsp" />
        
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
    </body>
</html>
