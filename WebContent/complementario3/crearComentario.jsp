<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <title>Comment</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>
	<%
		Object nombre = request.getSession().getAttribute("username");
		if (nombre == null) {
			response.sendRedirect("login.jsp");
		}
	%>

    <!-- Contenido -->
    <div class="container" id="contenedor-principal">
        <h2>Comentar</h2>
        <form class="form-horizontal" method="post" action=<%=request.getContextPath()+"/newComment"%>>
            <div class="form-group">
                <label class="control-label col-sm-2" for="content">Contenido:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" name="content" required="true" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-primary">Agregar</button>
                </div>
            </div>
        </form>
    </div>
</body>
</html>