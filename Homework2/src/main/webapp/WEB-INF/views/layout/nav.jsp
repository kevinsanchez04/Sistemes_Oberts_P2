<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<nav class="navbar navbar-expand-xl navbar-dark bg-dark" style="position:relative;">
    <div class="container">
        <a class="navbar-brand fs-2 fw-bold">BLOG SOB</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarDark" aria-controls="navbarDark" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse show" id="navbarDark">
          <ul class="navbar-nav ms-auto mb-2 mb-xl-0 fs-5 ms-auto p-2 text-center">
            <li class="nav-item me-3">
              <a class="nav-link active" href="${pageContext.request.contextPath}/Web/Article">Home</a>
            </li>
            <li class="nav-item me-3">
              <a class="nav-link active" href="${pageContext.request.contextPath}/Web/Login">LogIn</a>
            </li>
            <li class="nav-item me-3">
              <a class="nav-link active" href="${mvc.uri('addArticle')}">Add Article</a>
            </li>
          </ul>
        </div>
    </div>
</nav>
   
             
