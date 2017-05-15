<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Visualizar Empresas</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Lista de Empresas</h3>
		<div class="row">
			<div class="col-md-12">
				<a href="cadastro-empresa.html"><button type="button" class="btn btn-primary">Novo Item</button></a>
			</div>
		</div>
		<hr />
		<div class="row">
			<div class="col-md-12">
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>Razão social</th>
							<th>Cnpj</th>
							<th>Horário de funcionamento</th>
							<th>Temperatura maxima ar</th>
							<th>Ações</th>
						</tr>
					</thead>
					<c:forEach var="empresa" items="${lista}">
						<tr>
							<th>${empresa.idEmpresa}
							</th>
							<td>${empresa.razaoSocial}</td>
							<td>${empresa.cnpj}</td>
							<td>${empresa.horarioDeFuncionamento}</td>
							<td>${empresa.temperaturaMaximaAr}</td>
							<td><a href="ConsultarEmpresa.do?id-empresa=${empresa.idEmpresa}&btn=visualizar" class="btn btn-success">Visualizar</a>
								<a href="ConsultarEmpresa.do?id-empresa=${empresa.idEmpresa}&btn=editar" class="btn btn-warning">Editar</a>
								<a href="RemoverEmpresa.do?id-empresa=${empresa.idEmpresa}"class="btn btn-danger btn-delete">Excluir</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<hr />
		<div id="actions" class="row">
			<div class="col-md-12">
				<a href="index.jsp" class="btn btn-default">Voltar</a>
			</div>
		</div>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>

</html>