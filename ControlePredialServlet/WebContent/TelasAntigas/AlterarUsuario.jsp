<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="br.usjt.arqdesis.model.Usuario"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Alterar Usuario</title>

<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>

	<!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp" />

	<!-- Container Principal -->
	<div id="main" class="container">
		<h3 class="page-header">Alterar Usuario</h3>
		<!-- Formulario para inclusao de clientes -->
		<form action="AlterarUsuario.do" method="post">
			<!-- area de campos do form -->
			<div class="row">
				<div class="form-group col-md-12">
					<label for="nome">Id Usuario</label> <input type="number"
						value="${usuario.idUsuario}" class="form-control"
						name="id-usuario" id="id-usuario" required maxlength="100"
						placeholder="id obrigatório" readonly>
				</div>
				<div class="form-group col-md-12">
					<label for="nome">Nome</label> <input type="text"
						value="${usuario.nomeUsuario}" class="form-control" name="nome"
						id="nome" required maxlength="100" placeholder="nome completo">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="tipo-usuario">Tipo de usuario</label> <select required
						class="form-control" name="tipo-usuario" id="tipo-usuario">
						<option>SINDICO</option>
						<option>ATENDENTE</option>
						<option>FUNCIONARIO</option>
					</select>
				</div>

				<div class="form-group col-md-6">
					<label for="cpf">Cpf</label> <input type="cpf"
						value="${usuario.cpf}" required class="form-control" name="cpf"
						id="cpf" pattern="^(\d{3}\.\d{3}\.\d{3}-\d{2})|(\d{11})$"
						placeholder="cpf obrigatório">
				</div>
			</div>
			<div class="row">
				<div class="form-group col-md-6">
					<label for="login">Login</label> <input type="text"
						value="${usuario.login}" required class="form-control"
						name="login" id="login" required maxlength="100"
						placeholder="usuario obrigatório">
				</div>

				<div class="form-group col-md-6">
					<label for="senha">Senha</label> <input type="password"
						value="${usuario.senha}" required class="form-control"
						name="senha" id="senha" maxlength="60"
						placeholder="senha obrigatória">
				</div>
			</div>
			<hr />
			<div id="actions" class="row">
				<div class="col-md-12">
					<button type="submit" class="btn btn-primary" name="acao"
						value="Criar">Salvar</button>
					<a href="index.jsp" class="btn btn-default">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>