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
	<script src="./js/jquery-validation-1.19.3/dist/jquery.validate.min.js">
	</script><link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/selectize.js/0.13.3/css/selectize.bootstrap4.min.css" integrity="sha512-MMojOrCQrqLg4Iarid2YMYyZ7pzjPeXKRvhW9nZqLo6kPBBTuvNET9DBVWptAo/Q20Fy11EIHM5ig4WlIrJfQw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
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
   			<form id="formTransferencia" autocomplete="on" class="confirmartransferencia-form" action="NuevaTransferencia.html" method="POST">
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
                    	<select id="cuentaOrigen" name="cuentaOrigen" style="width: 80%">
				        	<c:forEach var="cuentaItem" items="${cuentaListado}">
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
                   	<div class="service-item second-item"  style="padding-top: 1.5rem;">
                    	 <input required class="form-control" autocomplete="off" style="width: 80%" type="number" id="cbuDestino" placeholder="Ingrese un CBU" name="cbuDestino" value="${cbuDestino}"/>
                    </div>
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-2">
                  	<h4>Monto:</h4>                  
                  	</div>
                  <div class="col-md-4">
                    <div class="service-item second-item"  style="padding-top: 1.5rem;">
                    	 <input required class="form-control" autocomplete="off" style="width: 80%" type="number" id="monto" placeholder="0.00" name="monto" value="${monto}"/>
                    </div>
                  </div>
                </div><br><br>
      				<p class="message" style="color: #dc3545;">${error}</p>
                <br><br>
                <div align="center" style="width: 469px; ">
             		<button style="color: black; width: 158px" id="transferirButton" type="submit">Transferir</button>
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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/selectize.js/0.13.3/js/standalone/selectize.js" integrity="sha512-pF+DNRwavWMukUv/LyzDyDMn8U2uvqYQdJN0Zvilr6DDo/56xPDZdDoyPDYZRSL4aOKO/FGKXTpzDyQJ8je8Qw==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    
    <script>
   		 $(document).ready(function() {

   			$('#cuentaOrigen').selectize({
    		    placeholder: 'Seleccione...'
    		});
   			 
   		  $('form[id="formTransferencia"]').validate({
   			    rules: {
   			      cuentaOrigen: { required: true },
   			      cbuDestino: { required: true },
   			   	  monto:{ required: true, montoMaximo: true}
   			    },
   			    messages: {
   			      cuentaOrigen: { required: 'Campo requerido' },
   			   	  cbuDestino: { required: 'Campo requerido' },
   			      monto: {
   			    	required: 'Campo requerido',
   			    	montoMaximo: 'El monto ingresado no puede superar el saldo'
   			      }
   			    },
   			    submitHandler: function(form) {
   			    	$.post('NuevaTransferencia.html',  $('#formTransferencia').serialize(), (resp) => { 
    					
    					alert(resp)
    					location.href = "./Movimientos.html?id=" + $('#cuentaOrigen').val()
    					
    				})
   			    }
   			  });
   	  	});
    
   		jQuery.validator.addMethod("montoMaximo", function(value, element) {
   		  return value <= parseFloat(document.getElementById("cuentaOrigen")[document.getElementById("cuentaOrigen").selectedIndex].innerText.split(" ").slice(-1));
   		}, "El monto ingresado no puede superar el saldo.");
    </script>
  </body>
</html>