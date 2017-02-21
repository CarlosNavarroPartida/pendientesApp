<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta name="viewport" content="width=device-width">
		<link rel="stylesheet" href="app/resourses/bootstrap/css/bootstrap.min.css">
		<link rel="stylesheet" href="app/resourses/css/style.css">
		<link rel="stylesheet" href="app/resourses/bootstrap/css/bootstrap-theme.min.css">
		
		<link rel="stylesheet" href="app/resourses/font-awesome/css/font-awesome.min.css">
		

		<script src="app/resourses/jquery/jQuery.js"></script>
		<script src="app/js/homeController.js"></script>
		<script src="app/resourses/bootstrap/js/bootstrap.js"></script>

		<title>Pendientes</title>

	</head>
	<body>
		<div class="container marginBodyTop" style="text-align:center">
			<div class="panel panel-primary">
				<!-- Default panel contents -->
				<div class="panel-heading">
					<div class="row">
						<div class="col-md-10 leftAlign"><h4>Tareas Pendientes</h4></div>
						<div class="col-md-1 rightAlign">
							<h4 class="colorFontRed">Total: ${pendienteCount}</h4>
						</div>
						<div class="col-md-1 rightAlign marginTop">
							<button id="btnShow" onclick="formShow()" type="button" class="btn btn-success " aria-label="Left Align" data-toggle="tooltip" title="Agregar Pendiente">
								<i class="fa fa-plus-square" aria-hidden="true"></i>
							</button>
							<button id="btnHide" onclick="formHide()" type="button" class="btn btn-danger " aria-label="Left Align" data-toggle="tooltip" title="Agregar Pendiente">
								<i class="fa fa-minus-square-o" aria-hidden="true"></i>
							</button>
						</div>
					</div>
				</div>
				<div class="panel-body">
					<div class="row" id="logoFamsa">
						<div class="col-md-2"></div>
						<div class="col-md-8">
							<img src="app/resourses/img/famsa.png" class="img-responsive centerImg" alt="Responsive image">
						</div>
						<div class="col-md-2"></div>
					</div>
					<div class="row" id="pendienteForm">
						<form action="save" method="POST" commandName="pendiente">
							<div class="col-md-6">
								<div class="form-group leftAlign">
									<input type="hidden" class="form-control" id="idPendiente"name="idPendiente" value="${pendiente.idPendiente}">
								</div>
								<div class="form-group leftAlign">
									<label for="nombre" class="leftText">Nombre</label>
									<input type="text" required class="form-control" id="nombre" placeholder="Nombre del pendiente" name="nombre" value="${pendiente.nombre}">
								</div>
								<div class="form-group leftAlign">
									<label for="descripcion">Descripci&oacute;n</label>
									<textarea class="form-control" required rows="3" placeholder="Descripci&oacute;n del pendiente" name="descripcion">${pendiente.descripcion}</textarea>
								</div>
								<div class="form-group leftAlign">
									<button type="submit" class="btn btn-success " aria-label="Left Align">
										<i class="fa fa-floppy-o" aria-hidden="true"></i><span> Guardar</span>
									</button>
								</div>
							</div>
							<div class="col-md-6">
								<img src="app/resourses/img/famsa.png" class="img-responsive" alt="Responsive image">
							</div>
						</form>
					</div>
				</div>
				
				<hr>

				<!-- Table -->
				<table class="table table-striped">
					<tr>
						<td class="leftAlign"><label>Nombre</label></td>
						<td class="leftAlign"><label>Descripci&oacute;n</label></td>
						<td><label>Acci&oacute;n</label></td>
					</tr>

					<c:forEach items="${pendienteList}" var="pendiente">
						<tr>
							<td class="leftAlign">${pendiente.nombre}</td>
							<td class="leftAlign">${pendiente.descripcion}</td>		
							<td>
								<div class="row">
									<div class="col-md-6 rightAlign">
										<a href="${pendiente.idPendiente}" onclick="formShow()" class="btn btn-warning active btn-xs" role="button" data-toggle="tooltip" title="Editar">
											<i class="fa fa-pencil" aria-hidden="true"></i>
											<!-- Editar  -->
										</a>
									</div>
									<div class="col-md-6 leftAlign">
										<a href="#" onclick="deletePendiente(${pendiente.idPendiente})" class="btn btn-danger active btn-xs" data-toggle="tooltip" title="Eliminar">
											<i class="fa fa-trash" aria-hidden="true"></i>
											<!--  Eliminar -->
										</a>
									</div>
								</div>
							</td>
						</tr>		    
					</c:forEach>
				</table>
			</div>

		</div>
	</body>
</html>