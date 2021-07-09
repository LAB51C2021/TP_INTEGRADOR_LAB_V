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
                <a href="HomeRepresentante.html">Home Banking</a>
              </div>
            </header>

            <!-- Banner -->
            <section class="top-image">
              <div class="container-fluid">
              <div class="row">
                  <div class="col-md-12">
                    <div class="down-content">
	                    <h1>Clientes</h1>
                    </div>
                    </div>
                  </div>
                <div class="row">
                  <div class="col-md-12" style="margin-bottom: 2rem;">
                    <div class="down-content">
                    <div class="primary-button">
                        <a href="ClienteDetalle.html">Nuevo Cliente</a>
                      </div>
                      </div>
                    </div>
                  </div>
                  <div class="col-md-10 offset-1">
                  	<table id="table" class="display" style="width:100%; margin-bottom: 2rem;">
	        <thead>
	            <tr>
	            	<th></th>
	                <th>Nombre</th>
	                <th>DNI</th>
	                <th>Fec. Nacimiento</th>
	                <th>Direccion</th>
	                <th>Localidad</th>
	                <th>Provincia</th>	
	                <th>Activo</th>			                
	            </tr>
	        </thead>
	        <tbody>
	       	 	<tr id="notHidden">
	                <td></td>
	                <td><input id="nombre" placeholder="Nombre" onkeyup="BusquedaNombreApellido()"></td>
	                <td><input id="DNI" placeholder="DNI" onkeyup="BusquedaDNI()"></td>		
	                <td></td>
	                <td></td>
	                <td></td>
	                <td></td>
	                <td></td>		               
	            </tr>
                <c:forEach var="cliente" items="${clientes}">
                <tr>
		            <td><a href="./Editar.html?idCliente=${cliente.getId_Cliente()}"><i class="fa fa-pencil" aria-hidden="true"></i></a></td>
		                <td>${cliente.getNombre_Apellido()}</td>
		                <td>${cliente.getDni()}</td>
		                <td>${cliente.getFecha_Nacimiento()}</td>
		                <td>${cliente.getDireccion()}</td>
		                <td>${cliente.getLocalidad()}</td>
		                <td>${cliente.getProvincia().getNombre()}</td>
		                <td>
							<label class="switch">
							<c:if test="${cliente.isHabilitado()}">
								<input type="checkbox" checked>
							</c:if>
							<c:if test="${!cliente.isHabilitado()}">
								<input type="checkbox">
							</c:if>
						    <span class="slider round"></span>
							</label>
						</td>
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
  </body>
  
  <script>
  function BusquedaNombreApellido() {
      var input, filter, table, tr, td, i, txtValue;
      input = document.getElementById("nombre");
      filter = input.value.toUpperCase();
      table = document.getElementById("table");
      tr = table.getElementsByTagName("tr");
      for (i = 0; i < tr.length; i++) {
    	  if(tr[i].id != 'notHidden'){
	          td = tr[i].getElementsByTagName("td")[1];
	          if (td) {
	              txtValue = td.textContent || td.innerText;
	              if (txtValue.toUpperCase().indexOf(filter) > -1) {
	                  tr[i].style.display = "";
	              } else {
	                  tr[i].style.display = "none";
	              }
	          }    		  
    	  }
      }
  }

  
  function BusquedaDNI() {
      var input, filter, table, tr, td, i, txtValue;
      input = document.getElementById("DNI");
      filter = input.value.toUpperCase();
      table = document.getElementById("table");
      tr = table.getElementsByTagName("tr");
      for (i = 0; i < tr.length; i++) {
    	  if(tr[i].id != 'notHidden'){
	          td = tr[i].getElementsByTagName("td")[2];
	          if (td) {
	              txtValue = td.textContent || td.innerText;
	              if (txtValue.toUpperCase().indexOf(filter) > -1) {
	                  tr[i].style.display = "";
	              } else {
	                  tr[i].style.display = "none";
	              }
	          }    		  
    	  }
      }
  }

  
  	$(() =>{
  		
  	})
  </script>
</html>