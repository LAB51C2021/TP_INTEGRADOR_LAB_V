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
    <form class="register-form">
      <input type="text" placeholder="nombre" name="txtUsername"/>
      <input type="password" placeholder="contraseña"/>
      <input type="text" placeholder="email"/>
      <button>create</button>
      <p class="message">Ya estás registrado?<a href="#">  Ingresar</a></p>
    </form>
    <form class="login-form" action="/Login" method="POST">
      <input type="text" id="username" placeholder="usuario" name="txtUsername"/>
      <input type="password" placeholder="contraseña" name="txtPassword"/>
      <button style="color: white">INGRESAR</button>
      <p class="message" style="background-color: white;">No estas registrado?<a href="#" style="background-color: white;">  Crear cuenta</a></p>
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