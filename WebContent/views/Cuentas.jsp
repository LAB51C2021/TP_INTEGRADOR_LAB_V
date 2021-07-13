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
              <div class="container-fluid">
              <div class="row">
                  <div class="col-md-12">
                    <div class="down-content">
	                    <h1>Cuentas</h1>
                    </div>
                    </div>
                  </div>
                <div class="row">
                  <div class="col-md-12" style="margin-bottom: 2rem;">
                    <div class="down-content">
                    <div class="primary-button">
                        <a href="EditarCuenta.html">Nueva Cuenta</a>
                      </div>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-10 offset-1">
                  	<table id="data" class="display" style="width:100%; margin-bottom: 2rem; padding-top: 2rem;">
				        <thead>
				            <tr>
				            	<th></th>
				                <th>Nro Cuenta</th>
				                <th>Tipo Cuenta</th>
				                <th>Cliente</th>
				                <th>Fecha Creación</th>
				                <th>CBU</th>
				                <th>Saldo</th>
				                <th>Activo</th>
				            </tr>
				        </thead>
				        <tbody>
			                <c:forEach var="cuenta" items="${cuentaListado}">
			                <tr>
					            <td><a href="./EditarCuenta.html?idCuenta=${cuenta.getId_Cuenta()}"><i class="fa fa-pencil" aria-hidden="true"></i></a></td>
					                <td>${cuenta.getNumero_Cuenta()}</td>
					                <td>${cuenta.getTipo_Cuenta().getNombre()}</td>
					                <td>${cuenta.getUsuario().getPersona().getNombre_Apellido()}</td>
					                <td>${cuenta.getFecha_Creacion()}</td>
					                <td>${cuenta.getCbu()}</td>
					                <td>${cuenta.getTipo_Cuenta().getMoneda()} ${cuenta.getSaldo()}</td>
					                <c:if test="${cuenta.isHabilitado()}">
					                	<td>SI</td>
					                </c:if>
					                <c:if test="${!cuenta.isHabilitado()}">
					                	<td>NO</td>
					                </c:if>
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
                <li><a href="Clientes.html">Clientes</a></li>
                <li><a href="Cuentas.html">Cuentas</a></li>
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
					lengthMenu: [ 5, 10, 20],
					language: {
			            url: './js/datatable-esp.json'
			        }
				}
			 );
		 });			 
    </script>
  </body>
</html>