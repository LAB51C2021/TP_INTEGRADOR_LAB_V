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
	<link rel="stylesheet" href="//cdn.datatables.net/1.10.25/css/jquery.dataTables.min.css">
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
              <div class="row">
                  <div class="col-md-12">
                    <div class="down-content">
	                    <h1>Movimientos</h1>
	                    <hr>
	                    <h6>${datosCuenta}</h6>
	                    <h6>${datoCbu}</h6>
	                    <h6>${datoSaldo}</h6>
                    </div>
                    </div>
                  </div>
                <hr>
                <div class="row">
                  <div class="col-md-12" style="margin-bottom: 2rem;">
                    <div class="down-content">
                    <div class="primary-button">
                        <a href="Transferencia.html">Nueva Transferencia</a>
                      </div>
                      </div>
                    </div>
                  <div class="col-md-10 offset-0">
                  	<table id="data" class="display" style="width:120%; margin-bottom: 1rem; padding-top: 2rem;">
				        <thead>
				            <tr>
				                <th>Fecha movimiento</th>
				                <th>Tipo operación</th>
				                <th>Cuenta Cbu</th>
				                <th>Monto</th>
				            </tr>
				        </thead>
				        <tbody>
				        	<c:forEach var="dato" items="${listaMovimientos}">
					            <tr>
					                <td>${dato.getFecha()}</td>
					                <td>${dato.getTipo_Movimiento().getNombre()}</td>
					                <td>${dato.getCbuCuentaOrigen()}</td>
					                <td>${dato.getMonto()}</td>
					            </tr>
				            </c:forEach>
			            </tbody>
		            </table>
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
        
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    <script src="./js/browser.min.js"></script>
    <script src="./js/breakpoints.min.js"></script>
    <script src="./js/transition.js"></script>
    <script src="./js/owl-carousel.js"></script>
    <script src="./js/custom.js"></script>
    
	
	<script src="//cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
    <script>
		 $(document).ready(function() {
			 $('#data').DataTable(
				{
					language: {
			            url: './js/datatable-esp.json'
			        }
				}
			 );
		 });			 
    </script>
    
  </body>
</html>