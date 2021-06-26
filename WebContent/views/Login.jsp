<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Banco</title>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="./css/login.css">
</head>
<body>
<div class="login-page">
  <div class="form">

    <form class="login-form" action="Login.html" method="POST">
      <input type="text" id="username" placeholder="usuario" name="username" value="${pageContext.request.getAttribute("username")}"/>
      <input type="password" placeholder="contraseña" name="password" value="${pageContext.request.getAttribute("password")}"/>
      <button style="color: white">INGRESAR</button>
      <p class="message" style="color: #dc3545;">${pageContext.request.getAttribute("error")}</p>
    </form>
  </div>
</div>
<script>
$('.message a').click(function(){
	   $('form').animate({height: "toggle", opacity: "toggle"}, 400);
	});
</script>
</body>
</html>