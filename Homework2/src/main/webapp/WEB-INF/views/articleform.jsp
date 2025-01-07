<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Article Form</title>
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
    <body>
        <jsp:include page="/WEB-INF/views/layout/nav.jsp" />
        <div class="container mt-5">
            <section class="row justify-content-center">
                <form class="col col-lg-6" action="${mvc.uri('/insert')}" method="POST">
                    <label class="d-block text-center">Introdueix Un Article</label>
                    <section>
                        <!-- Titol -->
                        <section class="d-flex flex-column mt-3">
                            <label for="HTML" class="mb-0">Titol</label>
                            <input type="text" name="titol" class="border border-2 border-dark rounded">
                        </section>
                        <!-- Text -->
                        <section class="d-flex flex-column mt-3">
                            <label for="HTML" class="mb-0">Text</label>
                            <textarea type="text" name="text" rows="4" class="border border-2 border-dark rounded"></textarea>
                        </section>
                        <!-- Resum -->
                        <section class="d-flex flex-column mt-3">
                            <label for="HTML" class="mb-0">Resum</label>
                            <textarea type="text" name="resum" rows="2" class="border border-2 border-dark rounded"></textarea>
                        </section>
                        <!-- Username -->
                        <section class="d-flex flex-column mt-3">
                            <!--<label for="HTML" class="mb-0">Username</label>-->
                            <input type="hidden" value="" name="autor" class="border border-2 border-dark rounded">
                        </section>
                        <!-- Imatge -->
                        <section class="d-flex flex-column mt-3">
                            <label for="HTML" class="mb-0">Imatge</label>
                            <input type="url" name="imatge" placeholder="https://example.com" class="border border-2 border-dark rounded">
                        </section>
                        <!-- Topics -->
                        <section class="d-flex flex-column mt-3">
                            <label for="HTML" class="mb-0">Topics</label>
                            <select name="topics" id="topics" class="border border-2 border-dark rounded">
                                <option value="HTML">HTML</option>
                                <option value="CSS">CSS</option>
                                <option value="Java">Java</option>
                                <option value="JavaScript">JavaScript</option>
                                <option value="Python">Python</option>
                                <option value="Web_Programming">Web_Programming</option>
                                <option value="C">C</option>
                            </select>
                            <select name="topics" id="topics" class="border border-2 border-dark rounded mt-2">
                                <option value="HTML">HTML</option>
                                <option value="CSS">CSS</option>
                                <option value="Java">Java</option>
                                <option value="JavaScript">JavaScript</option>
                                <option value="Python">Python</option>
                                <option value="Web_Programming">Web_Programming</option>
                                <option value="C">C</option>
                            </select>
                        </section>
                        <!-- Privacitat -->
                        <section class="d-flex mt-3">
                            <label for="HTML" class="mb-0 me-2">Privat</label>
                            <input name="privacitat" type="checkbox">
                        </section>
                        <input class="d-flex mt-3 mb-3 w-100 bg-dark text-white border border-dark rounded" type="submit">
                    </section>
                </form>
            </section>
        </div>
        <jsp:include page="/WEB-INF/views/layout/alert.jsp"/>
         <footer class="fixed-bottom">
            <jsp:include page="/WEB-INF/views/layout/footer.jsp"/>
        </footer>     
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
