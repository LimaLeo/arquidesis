<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cadastrar Empresa</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
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
                <a class="navbar-brand" href="index.jsp">Controle Predial</a>
            </div>
            <div id="navbar" class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="ListarEmpresas">Empresas</a>
                    </li>
                    <li><a href="ListarUsuarios">Usuarios</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Cadastrar Empresa</h3>
        <!-- Formulario para inclusao de Empresas -->
        <form action="controller.do" method="post">
            <!-- area de campos do form -->
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="razao-social">Razao Social</label>
                    <input type="text" class="form-control" name="razao-social" id="razao-social" required maxlength="100" placeholder="razao social obrigatória">
                </div>
                <div class="form-group col-md-6">
                    <label for="cnpj">CNPJ</label>
                    <input type="text" required class="form-control" name="cnpj" id="cnpj" pattern="^(\d{2}\.\d{3}\.\d{3}/\d{4}-\d{2})|(\d{14})$" placeholder="cnpj obrigatório">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                   <label for="horario-de-funcionamento">Horario de Funcionamento</label>
                   <input type="text" class="form-control" name="horario-de-funcionamento" id="horaio-de-funcionamento" required maxlength="20" placeholder="horario de funcionamento obrigatório">
                </div>
                <div class="form-group col-md-6">
                    <label for="temperatura-maxima-ar">Temperatura Maxima do Ar</label>
                    <input type="text" required class="form-control" name="temperatura-maxima-ar" id="temperatura-maxima-ar" placeholder="temperatura maxima do ar obrigatória">
                </div>
            </div>
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="command" value="CriarEmpresa">Salvar</button>
                    <a href="index.jsp" class="btn btn-default">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>