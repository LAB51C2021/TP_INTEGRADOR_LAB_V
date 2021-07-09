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


            <section class="top-image">
              <div class="container-fluid">
                <div class="row">
                  <div class="col-md-12" style="margin-bottom: 2rem;">
                    <div class="down-content">
	                    <h1>Cliente</h1>
                      </div>
                    </div>
                  </div>
                  <div class="row">
	                  <div class="col-md-2">
	                  	<h4>Nombre y Apellido</h4>                  
                  	  </div>
	                  <div class="col-md-4">
	                    <div class="service-item second-item" style="padding-top: 1.5rem;">
	                    	<input style="width:80%;" value="${cliente.getNombre_Apellido()}">
	                    </div>
	                  </div>
                	</div>
                  <div class="row">
	                  <div class="col-md-2">
	                  	<h4>DNI</h4>                  
                  	  </div>
	                  <div class="col-md-4">
	                    <div class="service-item second-item" style="padding-top: 1.5rem;">
	                    	<input style="width:80%;" value="${cliente.getDni()}">
	                    </div>
	                  </div>
                	</div>
                	<div class="row">
	                  <div class="col-md-2">
	                  	<h4>Fecha de Nacimiento</h4>                  
                  	  </div>
	                  <div class="col-md-4">
	                    <div class="service-item second-item" style="padding-top: 1.5rem;">
	                    	<input style="width:80%;" type="date" value="${cliente.getFecha_Nacimiento()}">
	                    </div>
	                  </div>
                	</div>
                	<div class="row">
	                  <div class="col-md-2">
	                  	<h4>Sexo</h4>                  
                  	  </div>
	                  <div class="col-md-4">
	                    <div class="service-item second-item" style="padding-top: 1.5rem;">
	                    	<select style="width:80%;">
	                    		<option>- SELECCIONAR - </option>
	                    	</select>
	                    </div>
	                  </div>
                	</div>
                	<div class="row">
	                  <div class="col-md-2">
	                  	<h4>Dirección</h4>                  
                  	  </div>
	                  <div class="col-md-4">
	                    <div class="service-item second-item" style="padding-top: 1.5rem;">
	                    	<input style="width:80%;" value="${cliente.getDireccion()}">
	                    </div>
	                  </div>
                	</div>
                	<div class="row">
	                  <div class="col-md-2">
	                  	<h4>Localidad</h4>                  
                  	  </div>
	                  <div class="col-md-4">
	                    <div class="service-item second-item" style="padding-top: 1.5rem;">
	                    	<select style="width:80%;">
	                    		<option>- SELECCIONAR - </option>
	                    	</select>
	                    </div>
	                  </div>
                	</div>
                	<div class="row">
	                  <div class="col-md-2">
	                  	<h4>Pais</h4>                  
                  	  </div>
	                  <div class="col-md-4">
	                    <div class="service-item second-item" style="padding-top: 1.5rem;">
	                    	<select style="width:80%;">
	                    		<option>- SELECCIONAR - </option>
	                    	</select>
	                    </div>
	                  </div>
                	</div>
                <div class="row">
	                  <div class="col-md-2">
	                  	<h4>Estado</h4>                  
                  	  </div>
	                  <div class="col-md-4">
	                    <div class="service-item second-item" style="padding-top: 1.5rem;">
	                    	<select style="width: 80%">
	                    		<option>ACTIVO</option>
	                    	</select>
	                    </div>
	                  </div>
                	</div>	
                <div class="row">
                  <div class="row" style="text-align: center;">
                  	<div class="col">
	                  	<div class="primary-button">
	                        <a href="NuevaTransferencia.html">Confirmar</a>
	               		</div>   
                  	</div>
                  	<div class="col">
	                  	<div class="primary-button">
	                        <a href="#" id="deleteClient">Eliminar</a>
	               		</div>   
                  	</div>
                  	<div class="col">
	                  	<div class="primary-button">
	                        <a href="./Clientes.html">Volver</a>
	               		</div> 
                  	</div>
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
        
        
    </div>
   
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
    <script src="./js/browser.min.js"></script>
    <script src="./js/breakpoints.min.js"></script>
    <script src="./js/transition.js"></script>
    <script src="./js/owl-carousel.js"></script>
    <script src="./js/custom.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootbox.js/5.5.2/bootbox.min.js" integrity="sha512-RdSPYh1WA6BF0RhpisYJVYkOyTzK4HwofJ3Q7ivt/jkpW6Vc8AurL1R+4AUcvn9IwEKAPm/fk7qFZW3OuiUDeg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    
    
    <script type="text/javascript">
    	$(() =>{
    		$('#deleteClient').click((e)=>{
    			e.preventDefault()
    			
    			
    			bootbox.confirm({
    			    message: "Esta seguro que desea eliminar el cliente y todas sus cuentas asociadas?",
    			    backdrop: true,
    			    closeButton: false,
    			    buttons: {
    			        confirm: {
    			            label: 'Aceptar',
    			            className: 'btn-success'
    			        },
    			        cancel: {
    			            label: 'Cancelar',
    			            className: 'btn-danger'
    			        }
    			    },
    			    callback: function (result) {
    			    	if(result){
    			    		$.post('./Eliminar.html', {idCliente: ${cliente.getId_Cliente()}}, (data) => {
    			    			location.href = "./Clientes.html"
    			    		})
    			    	}
    			    }
    			});
    		})
    		
    		
    	})
    
    </script>
  </body>
</html>