	<table id="example" class="display" style="width:100%; margin-bottom: 2rem;">
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
	       	 	<tr>
	                <td></td>
	                <td><input placeholder="Nombre"></td>
	                <td><input placeholder="DNI"></td>		
	                <td></td>
	                <td></td>
	                <td></td>
	                <td></td>
	                <td></td>		               
	            </tr>
                <c:forEach var="cliente" items="${clientes}">
                <tr>
		            <td><a href="Cliente/Editar.html?idCliente=${cliente.getId_Cliente()} }"><i class="fa fa-pencil" aria-hidden="true"></i></a></td>
		                <td>${cliente.getNombre_Apellido()}</td>
		                <td>${cliente.getDni()}</td>
		                <td>${cliente.getFecha_Nacimiento()}</td>
		                <td>${cliente.getDireccion()}</td>
		                <td>${cliente.getLocalidad()}</td>
		                <td>${cliente.getProvincia()}</td>
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