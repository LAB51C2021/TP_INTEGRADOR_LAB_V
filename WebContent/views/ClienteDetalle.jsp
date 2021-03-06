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
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/selectize.js/0.13.3/css/selectize.bootstrap4.min.css" integrity="sha512-MMojOrCQrqLg4Iarid2YMYyZ7pzjPeXKRvhW9nZqLo6kPBBTuvNET9DBVWptAo/Q20Fy11EIHM5ig4WlIrJfQw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
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
                  <form autocomplete="off" id="mainForm" action="Editar.html" method="POST">
                  <input id="idCliente" name="idCliente" type="hidden" value="${cliente.getId_Cliente() != null ? cliente.getId_Cliente() : 0}">
                  <div class="row">
	                  <div class="col-md-2">
	                  	<h4>Nombre y Apellido</h4>                  
                  	  </div>
	                  <div class="col-md-4">
	                    <div class="service-item second-item" style="padding-top: 1.5rem;">
	                    	<input required class="form-control" style="width:80%;" id="nombre_apellido" placeholder="Ingrese nombre y apellido" name="nombre_apellido" value="${cliente.getNombre_Apellido()}">
	                    </div>
	                  </div>
                	</div>
                  <div class="row">
	                  <div class="col-md-2">
	                  	<h4>DNI</h4>                  
                  	  </div>
	                  <div class="col-md-4">
	                    <div class="service-item second-item" style="padding-top: 1.5rem;">
	                    	<input required class="form-control" style="width:80%;" id="dni" placeholder="Ingrese dni" name="dni" value="${cliente.getDni()}">
	                    	<div id="errorDNIduplicado"></div>
	                    </div>
	                  </div>
                	</div>
                	<div class="row">
	                  <div class="col-md-2">
	                  	<h4>Fecha de Nacimiento</h4>                  
                  	  </div>
	                  <div class="col-md-4">
	                    <div class="service-item second-item" style="padding-top: 1.5rem;">
	                    	<input required class="form-control" style="width:80%;" type="date" id="fechaNac" placeholder="Ingrese fecha de nacimiento" name="fechaNac" value="${cliente.getFecha_Nacimiento()}">
	                    </div>
	                  </div>
                	</div>
                	<div class="row">
	                  <div class="col-md-2">
	                  	<h4>Sexo</h4>                  
                  	  </div>
	                  <div class="col-md-4">
	                    <div class="service-item second-item" style="padding-top: 1.5rem;">
	                    	<select required style="width:80%;" id="sexo" name="sexo">
	                    		<c:if test="${cliente.getSexo() == 'M'}">
                    				<option selected value="M">Masculino </option>
                    				<option value="F">Femenino</option>
			                  	</c:if>
			                  	<c:if test="${cliente.getSexo() == 'F'}">
			                  		<option value="M">Masculino </option>
                    				<option selected value="F">Femenino</option>
			                  	</c:if>
			                  	<c:if test="${cliente.getSexo() == null}">
                    				<option value="M">Masculino </option>
                    				<option value="F">Femenino</option>
			                  	</c:if>
	                    	
	                    		
	                    	</select>
	                    </div>
	                  </div>
                	</div>
                	<div class="row">
	                  <div class="col-md-2">
	                  	<h4>Direcci?n</h4>                  
                  	  </div>
	                  <div class="col-md-4">
	                    <div class="service-item second-item" style="padding-top: 1.5rem;">
	                    	<input required id="direccion" placeholder="Ingrese direccion" name="direccion" class="form-control" style="width:80%;" value="${cliente.getDireccion()}">
	                    </div>
	                  </div>
                	</div>
                	<div class="row">
	                  <div class="col-md-2">
	                  	<h4>Localidad</h4>                  
                  	  </div>
	                  <div class="col-md-4">
	                    <div class="service-item second-item" style="padding-top: 1.5rem;">
	                    	<input required id="localidad" placeholder="Ingrese localidad" name="localidad" class="form-control" style="width:80%;" value="${cliente.getLocalidad()}">
	                    </div>
	                  </div>
                	</div>
                	<div class="row">
	                  <div class="col-md-2">
	                  	<h4>Provincia</h4>                  
                  	  </div>
	                  <div class="col-md-4">
	                    <div class="service-item second-item" style="padding-top: 1.5rem;">
	                    	<select required style="width:80%;" id="provincia" name="provincia">
		                    	<c:forEach var="provincia" items="${provincias}">
		                    		<c:if test="${cliente.getProvincia().getId_Provincia() == provincia.getId_Provincia()}">
	                    				<option selected value="${provincia.getId_Provincia()}">${provincia.getNombre()}</option>
				                  	</c:if>
				                  	<c:if test="${cliente.getProvincia().getId_Provincia() != provincia.getId_Provincia()}">
				                  		<option value="${provincia.getId_Provincia()}">${provincia.getNombre()}</option>
				                  	</c:if>
					                
	        					</c:forEach>
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
	                    	<select required style="width:80%;" id="pais" name="pais">
		                    	<c:forEach var="pais" items="${paises}">
		                    		<c:if test="${cliente.getPais().getId_Pais() == pais.getId_Pais()}">
	                    				<option selected value="${pais.getId_Pais()}">${pais.getNombre()}</option>
				                  	</c:if>
				                  	<c:if test="${cliente.getPais().getId_Pais() != pais.getId_Pais()}">
				                  		<option value="${pais.getId_Pais()}">${pais.getNombre()}</option>
				                  	</c:if>
					                
	        					</c:forEach>
        					</select>
	                    </div>
	                  </div>
                	</div>
                <div class="row">
                  <div class="row" style="text-align: center;">
                  	<div class="col">
	                  	<div class="primary-button">
	                        <a id="saveClient" href="Guardar.html">Guardar</a>
	               		</div>   
                  	</div>
                  	<c:if test="${cliente.getId_Cliente() != null}">
                  		<div class="col">
		                  	<div class="primary-button">
		                  		<c:if test="${cliente.isHabilitado() == true}">
		                  			<a href="#" id="eliminarCliente">Eliminar</a>	
		                  		</c:if>
		                        <c:if test="${cliente.isHabilitado() == false}">
		                  			<a href="#" id="habilitarCliente">Habilitar</a>	
		                  		</c:if>
		               		</div>   
	                  	</div>
                  	</c:if>
                  	<div class="col">
	                  	<div class="primary-button">
	                        <a href="./Clientes.html">Volver</a>
	               		</div> 
                  	</div>
                  </div>
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
                <li><a href="Clientes.html">Clientes</a></li>
                <li><a href="Cuentas.html">Cuentas</a></li>
                <li><a href="Logout.html">Salir</a></li>
              </ul>
            </nav>

            <!-- Footer -->
            <footer id="footer">
              <p class="copyright">Laboratorio de Computaci?n 5
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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/selectize.js/0.13.3/js/standalone/selectize.js" integrity="sha512-pF+DNRwavWMukUv/LyzDyDMn8U2uvqYQdJN0Zvilr6DDo/56xPDZdDoyPDYZRSL4aOKO/FGKXTpzDyQJ8je8Qw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="./js/jquery-validation-1.19.3/dist/jquery.validate.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.3/localization/messages_es_AR.min.js" integrity="sha512-IeJBPMkrv1HBLwIVpXQ2kEh24ocSZGuSXx6Jl5SIbeLoOtkXnEBghoSVmeJQerm3cRK9uKb1xxuHAEdxuVsBxg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    
    <script type="text/javascript">
    	$(() =>{
    		$('#sexo').selectize({
    		    placeholder: 'Seleccione...'
    		});
    		
    		$('#provincia').selectize({
    		    placeholder: 'Seleccione...'
    		})
    		
    		$('#pais').selectize({
    		    placeholder: 'Seleccione...'
    		})
    		
    		$('#saveClient').click((e)=>{
    			e.preventDefault()
    			
    			if($('#mainForm').valid() && !$('#errorDNI').text()){
    				$.post('./Grabar.html', $('#mainForm').serialize(), (resp) => { 
    					
    					alert(resp)
    					location.href = "./Clientes.html" 
    					
    				})
    			}
    		});
    		
    		$('#eliminarCliente').click((e)=>{
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
    			    		var code = ${cliente.getId_Cliente() != null ? cliente.getId_Cliente() : 0};
    			    		var status = ${!cliente.isHabilitado()};
    			    		$.post('./Eliminar.html', { idCliente: code, habilitado: status }, (data) => {
    			    			alert(data)
    			    			location.href = "./Clientes.html"
    			    		})
    			    	}
    			    }
    			});
    		})
    		
    		$('#habilitarCliente').click((e)=>{
    			e.preventDefault()
    			
    			var code = ${cliente.getId_Cliente() != null ? cliente.getId_Cliente() : 0};
    			var status = ${!cliente.isHabilitado()};
	    		
    			$.post('./Eliminar.html', { idCliente: code, habilitado: status }, (data) => {
    					alert(data) 
	    				location.href = "./Clientes.html"
	    			});
    			})
    		
    		$('#dni').focusout((e) => {
    			if(e.target.value.trim()){
    				$.get('./ValidaDuplicateDNI.html', {dni : e.target.value.trim() }, (resp) => {
    					$('#errorDNIduplicado').html(resp);
    				})
    			}
    			
    		})
    		
    	})
    
    </script>
  </body>
</html>