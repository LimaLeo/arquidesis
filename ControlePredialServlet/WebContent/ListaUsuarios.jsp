<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Visualizar Usuarios</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>

<body>
	<!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp" />
	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Lista de Usuarios</h3>
		<div class="row">
			<div class="col-md-12">
				<a href="cadastro-usuario.html"><button type="button" class="btn btn-primary">Novo Item</button></a>
			</div>
		</div>
		<hr />
		<div class="row">
			<div class="col-md-12">
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>Nome Usuário</th>
							<th>Cpf</th>
							<th>Login</th>
							<th>Tipo de Usuario</th>
							<th>Ações</th>
						</tr>
					</thead>
					<c:forEach var="usuario" items="${lista}">
						<tr>
							<th>${usuario.idUsuario}
							</th>
							<td>${usuario.nomeUsuario}</td>
							<td>${usuario.cpf}</td>
							<td>${usuario.login}</td>
							<td>${usuario.tipoUsuario}</td>
							<td><a href="ConsultarUsuario.do?id-usuario=${usuario.idUsuario}" class="btn btn-success">Visualizar</a>
								<a href="ConsultarUsuarioAlterar.do?id-usuario=${usuario.idUsuario}" class="btn btn-warning">Editar</a>
								<a href="RemoverUsuario.do?id-usuario=${usuario.idUsuario}"class="btn btn-danger btn-delete">Excluir</a></td>
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