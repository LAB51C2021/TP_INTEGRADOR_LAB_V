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
	                    <h1>Cuenta</h1>
                      </div>
                    </div>
                  </div>
                  
                  <form autocomplete="off" id="mainForm" action="GuardarCuenta.html" method="POST">
                  <input id="idCuenta" name="idCuenta" type="hidden" value="${cuenta.getId_Cuenta() != null ? cuenta.getId_Cuenta() : 0}">
                  <div class="row">
	                  <div class="col-md-2">
	                  	<h4>Tipo de Cuenta</h4>                  
                  	  </div>
	                  <div class="col-md-4">
	                    <div class="service-item second-item" style="padding-top: 1.5rem;">
	                    	<select required id="tiposCuenta" style="width: 80%" name="tiposCuenta">
	                    		<c:forEach var="tipoCuenta" items="${tiposCuenta}">
	                    			<c:if test="${cuenta.getTipo_Cuenta().getId_Tipo_Cuenta() == tipoCuenta.getId_Tipo_Cuenta()}">
	                    				<option selected value="${tipoCuenta.getId_Tipo_Cuenta()}">${tipoCuenta.getNombre()}</option>
				                  	</c:if>
				                  	<c:if test="${cuenta.getTipo_Cuenta().getId_Tipo_Cuenta() != tipoCuenta.getId_Tipo_Cuenta()}">
				                  		<option value="${tipoCuenta.getId_Tipo_Cuenta()}">${tipoCuenta.getNombre()}</option>
				                  	</c:if>
				        		</c:forEach>	
	                    	</select>
	                    </div>
	                  </div>
                	</div>
                  <div class="row">
	                  <div class="col-md-2">
	                  	<h4>Numero de Cuenta</h4>                  
                  	  </div>
	                  <div class="col-md-4">
	                    <div class="service-item second-item" style="padding-top: 1.5rem;">
	                    	<input required class="form-control" style="width:80%;" type="text" minlength="5" maxlength="5" id="nroCuenta" name="nroCuenta" value="${cuenta.getNumero_Cuenta()}">
	                    	<div id="errorNroCuentaduplicado"></div>
	                    </div>
	                  </div>
                	</div>
                <div class="row">
	                  <div class="col-md-2">
	                  	<h4>CBU</h4>                  
                  	  </div>
	                  <div class="col-md-4">
	                    <div class="service-item second-item" style="padding-top: 1.5rem;">
	                    	<input required class="form-control" style="width:80%;" type="number" minlength="14" maxlength="14" name="cbu" value="${cuenta.getCbu()}">
	                    </div>
	                  </div>
                	</div>
                <div class="row">
	                  <div class="col-md-2">
	                  	<h4>Cliente</h4>                  
                  	  </div>
	                  <div class="col-md-4">
	                    <div class="service-item second-item" style="padding-top: 1.5rem;">
	                    	<select required id="clienteID" style="width: 80%" name="clienteID">
	                    		<c:forEach var="cliente" items="${clientes}">
	                    			<c:if test="${cuenta.getUsuario().getId_Usuario() == cliente.getUsuario().getId_Usuario()}">
				                  		<option idUser="${cliente.getUsuario().getId_Usuario()}" selected value="${cliente.getId_Cliente()}_${cliente.getUsuario().getId_Usuario()}">${cliente.getNombre_Apellido()} (DNI ${cliente.getDni()})</option>
				                  	</c:if>
				                  	<c:if test="${cuenta.getUsuario().getId_Usuario() != cliente.getUsuario().getId_Usuario()}">
				                  		<option idUser="${cliente.getUsuario().getId_Usuario()}" value="${cliente.getId_Cliente()}_${cliente.getUsuario().getId_Usuario()}">${cliente.getNombre_Apellido()} (DNI ${cliente.getDni()})</option>
				                  	</c:if>
	                    			
				        		</c:forEach>	
	                    	</select>
	                    </div>
	                  </div>
                	</div>
                <div class="row">
	                  <div class="col-md-2">
	                  	<h4>Saldo</h4>                  
                  	  </div>
	                  <div class="col-md-4">
	                    <div class="service-item second-item" style="padding-top: 1.5rem;">
	                    	<input required class="form-control" style="width:80%;" type="number" name="saldo" value="${cuenta.getId_Cuenta() != null ? cuenta.getSaldo() : 10000}">
	                    	<div id="errorCantCuentasAsignadas"></div>
	                    </div>
	                  </div>
                	</div>
                	</form>
                <div class="row">
                  <div class="row" style="text-align: center;">
                  	<div class="col">
	                  	<div class="primary-button">
	                        <a id="saveCuenta" href="GuardarCuenta.html">Guardar</a>
	               		</div>   
                  	</div>
                  	<c:if test="${cuenta.getId_Cuenta() != null}">
                  		<div class="col">
		                  	<div class="primary-button">
		                  		<c:if test="${cuenta.isHabilitado() == true}">
		                  			<a href="#" id="eliminarCuenta">Eliminar</a>	
		                  		</c:if>
		                        <c:if test="${cuenta.isHabilitado() == false}">
		                  			<a href="#" id="habilitarCuenta">Habilitar</a>	
		                  		</c:if>
		               		</div>   
	                  	</div>
                  	</c:if>
                  	<div class="col">
	                  	<div class="primary-button">
	                        <a href="./Cuentas.html">Volver</a>
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
	    function getFormData($form){
	        var unindexed_array = $form.serializeArray();
	        var indexed_array = {};
	
	        $.map(unindexed_array, function(n, i){
	            indexed_array[n['name']] = n['value'];
	        });
	
	        return indexed_array;
	    }
	    
	    function validaCantCuentasAsignadas(){
	    	var a = $('#clienteID').find(":selected")
	    	var code = a[0].value.split('_')[1];
	    	
	    	$.get('./ValidaCantCuentasAsignadasPorCliente.html', { userID : code }, (resp) => {
				$('#errorCantCuentasAsignadas').html(resp);
			});
	    }
    
    	$(() =>{
    		$('#tiposCuenta').selectize({
    		    placeholder: 'Seleccione...'
    		});
    		
    		$('#clienteID').selectize({
    		    placeholder: 'Seleccione...',
    		    render: {
                    item: function (item) {
                    	var codes = item.value.split('_')
                    	
                        return '<div userid="' + codes[1] + '" id="' + codes[0] + '" data-value="' + codes[0] + '" class="item">' + item.text + '</div>';
                    },
                    option: function (item) {
                    	var codes = item.value.split('_')
                    	
                        return '<div userid="' + codes[1] + '" id="' + codes[0] + '" data-value="' + codes[0] + '" data-selectable="" class="option">' + item.text + '</div>';
                    }
                },
    		    onChange: (val) => {
    		    	if(val){
    		    		validaCantCuentasAsignadas()
    		    	}
    		    }
    		})
    		
    		$('#saveCuenta').click((e)=>{
    			e.preventDefault()
    			
    			if($('#mainForm').valid() && !$('#errorNroCuenta').text() && !$('#errorMaxCuentasAsignadas').text()){
    				var a = $('#clienteID').find(":selected")
    		    	var code = a[0].value.split('_')[0];
    				a[0].value = code
    				
    				$.post('GuardarCuenta.html', $("#mainForm").serialize(), (resp) => {
				    	alert(resp)
			    		location.href = 'Cuentas.html'
				    })
    			}
    		})
    		
    		$('#eliminarCuenta').click((e)=>{
    			e.preventDefault()
    			
    			bootbox.confirm({
    			    message: "?Est? seguro que desea eliminar la cuenta?",
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
    			    		var code = ${cuenta.getId_Cuenta() != null ? cuenta.getId_Cuenta() : 0 };
    			    		var status = ${!cuenta.isHabilitado()};
    			    		$.post('EliminarCuenta.html', { idCuenta: code, habilitado: status }, (data) => {
    			    			alert(data)
    			    			location.href = "Cuentas.html"
    			    		})
    			    	}
    			    }
    			});
    		})
    		
    		$('#habilitarCuenta').click((e)=>{
    			e.preventDefault();
    			var code = ${cuenta.getId_Cuenta() != null ? cuenta.getId_Cuenta() : 0 };
    			var status = ${!cuenta.isHabilitado()};
    			$.post('EliminarCuenta.html', { idCuenta: code, habilitado: status }, (data) => {
    					alert(data)	
 			    		location.href = "Cuentas.html"
  			    })
    		})
    		
    		$('#nroCuenta').focusout((e) => {
    			if(e.target.value.trim()){
    				$.get('./ValidaDuplicateNroCuenta.html', { nroCuenta : e.target.value.trim() }, (resp) => {
    					$('#errorNroCuentaduplicado').html(resp);
    				})
    			}
    			
    		})
    		
    		validaCantCuentasAsignadas();
    		
    	})
    
    </script>
  </body>
</html>