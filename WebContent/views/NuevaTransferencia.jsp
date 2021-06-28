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

		<!-- Banner -->
          <section class="top-image">
   			<form autocomplete="on" class="ConfirmarTransferencia-form" action="ConfirmarTransferencia.html" method="POST">
                <div class="row">
                  <div class="col-md-15" style="margin-bottom: 2rem;">
                    <div class="down-content">
	                    <h1>Transferencia</h1>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                  <div class="col-md-2">
                  	<h4>Cuenta origen: </h4>                  
                  </div>
                  <div class="col-md-4">
                    <div class="service-item second-item" style="padding-top: 1.5rem;">
                    	<select id="cuentaorigen" style="width: 80%" onchange="getSelectValue();">
				        	<c:forEach var="cuentaItem" items="${cuentaList}">
                    			<option value="${cuentaItem.getId_Cuenta()}">${cuentaItem}</option>
				        	</c:forEach>
				        </select>
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-2">
                  	<h4>Cuenta destino: </h4>                  
                  </div>
                  <div class="col-md-4">
                    <div class="service-item second-item" style="padding-top: 1.5rem;">
                    	 <input required autocomplete="off" style="width: 80%" type="text" id="cbu" placeholder="Ingrese el cbu" name="cbu" />
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-2">
                  	<h4>Monto:</h4>                  
                  	</div>
                  <div class="col-md-4">
                    <div class="service-item second-item"  style="padding-top: 1.5rem;">
                    	 <input required autocomplete="off" style="width: 80%" type="number" id="monto" placeholder="Ingrese el monto" name="monto"/>
                    </div>
                  </div>
                </div><br><br>
                <div align="center" style="width: 469px; ">
             		<button style="color: black; width: 158px">Transferir</button>
    				<button style="color: black; width: 158px">Cancelar</button>
                </div>
    			</form>   
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
                <li><a href="HomeCliente.html">Cuentas</a></li>
                <li><a href="NuevaTransferencia.html">Nueva Transferencia</a></li>
                <!-- <li>Tarjetas</li>
                <li>Beneficios</li>
                <li>Configuración</li> -->
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