<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Banco</title>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/jquery.validate.min.js" integrity="sha512-37T7leoNS06R80c8Ulq7cdCDU5MNQBwlYoy1TX/WUsLFC2eYNqtKlV0QjH7r8JpG/S0GUMZwebnVFLPd6SU5yg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/localization/messages_ar.min.js" integrity="sha512-bGOftAqe7xfGxaWMsVQR187i+R9E0tXZIUL0idz1NKBBZIW78hoDtFY9gGLEGJFwHPjQSmPiHdm+80QParVi1A==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<link rel="stylesheet" href="./css/login.css">
</head>
<body>
<div class="login-page">
  <div class="form">

    <form autocomplete="off" class="login-form" action="Login.html" method="POST">
      <input required autocomplete="off" type="text" id="username" placeholder="usuario" name="username" value="${pageContext.request.getAttribute("username")}"/>
      <input required autocomplete="off" type="password" placeholder="contraseña" name="password" value="${pageContext.request.getAttribute("password")}"/>
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