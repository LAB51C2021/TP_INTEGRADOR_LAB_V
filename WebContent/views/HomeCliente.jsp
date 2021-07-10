<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="es-AR">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700" rel="stylesheet">
	<link rel="stylesheet" href="./css/fontawesome.css">
	<link rel="stylesheet" href="./css/flex-slider.css">
	<link rel="stylesheet" href="./css/owl.css">
	<link rel="stylesheet" href="./css/style.css">
    <title></title>
  </head>
  <body>
	
   <div id="wrapper">

      <!-- Main -->
        <div id="main">
          <div class="inner">
            <!-- Header -->
            <header id="header">
              <div class="logo">
              	 <a href="HomeCliente.html">Home Banking</a>
              </div>
            </header>
            <section class="services">
              <div class="container-fluid">
                
                <div class="row" style="margin-bottom: 2rem;">
                <c:set var="contador" value="${1}" />
	                <c:forEach var="dato" items="${lista}">
	       				<tr>
		                  	<div class="col-md-4 offset-1">
								<a href="Movimientos.html?id=${dato.getId_Cuenta()}" class="cuenta">
				                    <div class="service-item second-item" >
					                      	<h1>CUENTA ${contador}</h1>
					                      	<p>${dato.getNombre()}</p>
					                      	<h4>N° ${dato.getNumero_Cuenta()}</h4>
					                      	<p>${dato.getTipo_Cuenta().getMoneda()} ${dato.getSaldo()}</p>
					                      	<p>CBU ${dato.getCbu()}</p>
					                    	<c:set var="contador" value="${contador + 1}" />
				                    </div>
	             				</a>
		                  	</div>
	       				</tr>
	        		</c:forEach>
                  </div>
              </div>
            </section>
          </div>
        </div>

       <!-- Sidebar -->
        <div id="sidebar">
          <div class="inner">
            <!-- Menu -->
            <nav id="menu">
            	<span>Bienvenido de nuevo ${sessionScope.sessionUser.toString()}</span>
              <ul>
                <li><a href="HomeCliente.html">Inicio</a></li>
                <li><a href="Transferencia.html">Nueva Transferencia</a></li>
                <li><a href="Logout.html">Salir</a></li>
              </ul>
            </nav>

            <!-- Footer -->
            <footer id="footer">
              <p class="copyright">Laboratorio de Computación 5
              <br><a rel="nofollow" href="https://frgp.cvg.utn.edu.ar/course/view.php?id=2614">UTN FRGP</a></p>
            </footer>

          </div>
        </div>

    </div>
   
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    <script src="./js/browser.min.js"></script>
    <script src="./js/breakpoints.min.js"></script>
    <script src="./js/transition.js"></script>
    <script src="./js/owl-carousel.js"></script>
    <script src="./js/custom.js"></script>
  </body>
</html>