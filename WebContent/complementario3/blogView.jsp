<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Blog Main View</title>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<!-- Navegación Superior -->
	<nav class="navbar navbar-default" >
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li><a href="blogView.jsp">Main View</a></li>
				<li><a href="crearComentario.jsp">Comentar</a></li>
				<c:if test = "${username == null}">
					<li><a href="login.jsp">Login</a></li>
				</c:if>
				<c:if test = "${username != null}">
					<li><a href=<%=request.getContextPath()+"/logout"%>>Logout</a></li>
				</c:if>
			</ul>
		</div>
	</nav>
	
	
	<!-- Comments -->
	<div class="container" id="contenedor-principal">
	    <h2>Comentarios</h2>
	    <div class="row ">
			<jsp:useBean id="commentsDatabase" class="com.uniovi.sdi.complementario3.CommentsDatabase" />
			<c:forEach var="comment" begin="0" items="${commentsDatabase.comments}">
			    <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3">
			    	<div>
			            <div>
			                User: <c:out value="${comment.username}" />
			                - <c:out value="${comment.content}" />
			            </div>
			        </div>
			    </div>
			</c:forEach>
	    </div>
    </div>
	    
</body>

</html>