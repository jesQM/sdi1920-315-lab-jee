<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Productos</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<c:forEach var="producto" begin="0" items="${productosTienda}">
	    <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
	        <div>
	            <img src="<c:out value=" ${producto.imagen}" />" />
	            <div>
	                <c:out value="${producto.nombre}" />
	            </div>
	            <a href="incluirEnCarrito?producto=<c:out value="${producto.nombre}"/>" class="btn btn-default">
	            	<c:out value="${producto.precio}" /> €
	            </a>
	        </div>
	    </div>
	</c:forEach>
</body>

</html>