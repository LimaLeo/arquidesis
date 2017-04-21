<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="br.usjt.arqdesis.model.Empresa" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Alterar Empresa</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
	<%Empresa empresa=( Empresa)request.getAttribute( "empresa"); %>
	  <!-- Barra superior com os menus de navegação -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="cadastro-empresa.html">Cadastrar</a>
            	<a class="navbar-brand" href="consulta-empresa.html">Consultar</a>
            	<a class="navbar-brand" href="altera-empresa.html">Alterar</a>
            	<a class="navbar-brand" href="remove-empresa.html">Remover</a>	
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="cadastro-usuario.html">Usuario</a></li>
               		<li><a href="cadastro-empresa.html">Empresa</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Alterar Empresa</h3>
        <!-- Formulario para inclusao de Empresas -->
        <form action="AlterarEmpresa.do" method="post">
            <!-- area de campos do form -->
            <div class="row">
           		<div class="form-group col-md-6">
                    <label for="id-empresa">Id Empresa</label>
                    <input type="number"  value= "${empresa.idEmpresa}" class="form-control" name="id-empresa" id="id-empresa" disabled>
                </div>
                <div class="form-group col-md-6">
                    <label for="razao-social">Razao Social</label>
                    <input type="text" value= "${empresa.razaoSocial}" class="form-control" name="razao-social" id="razao-social" required maxlength="100" placeholder="razao social obrigatória">
                </div>
                <div class="form-group col-md-6">
                    <label for="cnpj">CNPJ</label>
                    <input type="text" value= "${empresa.cnpj}" required class="form-control" name="cnpj" id="cnpj" pattern="^(\d{2}\.\d{3}\.\d{3}/\d{4}-\d{2})|(\d{14})$" placeholder="cnpj obrigatório">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                   <label for="horario-de-funcionamento">Horario de Funcionamento</label>
                   <input type="text" value= "${empresa.horarioDeFuncionamento}" class="form-control" name="horario-de-funcionamento" id="horaio-de-funcionamento" required maxlength="20" placeholder="horario de funcionamento obrigatório">
                </div>
                <div class="form-group col-md-6">
                    <label for="temperatura-maxima-ar">Temperatura Maxima do Ar</label>
                    <input type="text" value= "${empresa.temperaturaMaximaAr}" required class="form-control" name="temperatura-maxima-ar" id="temperatura-maxima-ar" placeholder="temperatura maxima do ar obrigatória">
                </div>
            </div>
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="acao" value="Criar">Salvar</button>
                    <a href="index.html" class="btn btn-default">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
	
</body>
</html>