<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="br.usjt.arqdesis.model.Empresa" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Visualizar Empresa</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <%Empresa empresa=( Empresa)request.getAttribute( "empresa"); %>
        <!-- Barra superior com os menus de navegação -->

        <!-- Container Principal -->
        <div id="main" class="container">
            <h3 class="page-header">Visualizar Empresa #<%=empresa.getIdEmpresa() %></h3>
            <div class="row">
                <div class="col-md-6">
                    <p><strong>Razao Social</strong>
                    </p>
                    <p>
                        <%=empresa.getRazaoSocial() %>
                    </p>
                </div>
                <div class="col-md-6">
                    <p><strong>CNPJ</strong>
                    </p>
                    <p>
                        <%=empresa.getCnpj() %>
                    </p>
                </div>
            </div>
            <div class="row">
				<div class="col-md-6">
                    <p><strong>Horario De Funcionamento</strong>
                    </p>
                    <p>
                        <%=empresa.getHorarioDeFuncionamento() %>
                    </p>
                </div>
                <div class="col-md-6">
                    <p><strong>Temperatura Maxima do Ar</strong>
                    </p>
                    <p>
                        <%=empresa.getTemperaturaMaximaAr() %>													
                    </p>
                </div>
            </div>
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <a href="cadastro-empresa.html" class="btn btn-default">Voltar</a>
                </div>
            </div>
        </div>
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
</body>

</html>