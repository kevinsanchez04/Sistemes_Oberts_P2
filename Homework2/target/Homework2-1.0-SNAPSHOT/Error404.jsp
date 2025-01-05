<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Ups Error</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
    <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <style>
        .card {
            position: relative;
            display: flex;
            flex-direction: column;
            min-width: 0;
            word-wrap: break-word;
            background-color: #fff;
            background-clip: border-box;
            border: 1px solid rgba(0, 0, 0, 0.04);
            border-radius: .25rem;
        }

        .card .card-header {
            background-color: #fff;
            border-bottom: none;
        }
    </style>
  </head>
<body>
    <div class="container d-flex justify-content-center align-items-center min-vh-100">
        <div class="row text-center w-100">
            <div class="col-md-6 col-sm-12">
                <div class="card shadow-lg border-0 rounded-lg mt-5 mx-auto">
                    <h3 class="card-header display-4 text-muted text-center">
                        Ups, hi hagut un error
                    </h3>
                    <div class="card-body">
                        <a href="<c:url value='/Web/Article' />" class="btn btn-info text-white w-100">Tornar a la web</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
