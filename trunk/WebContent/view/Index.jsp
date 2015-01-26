

<%@page import="br.com.saat.core.Constants"%>

<%-- <%@include file='../layout/head.jsp'%> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pr">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sistema de Acompanhamento de Atleta de Tênis</title>

    <!-- Bootstrap -->
    <link href="<%=Constants.CSS%>/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

	<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-4 column">
			</div>
			<div class="col-md-4 column">
				<h3 class="text-center">
					SAAT
					<div>
						<span>Sistema de Acompanhamento de Atletas de Tênis</span>
					</div>
				</h3>
				<form role="form" action="view/SecretariaAtleta.jsp">
					<div class="form-group">
						 <label for="exampleInputEmail1">Usuário</label><input type="email" class="form-control" id="exampleInputEmail1">
					</div>
					<div class="form-group">
						 <label for="exampleInputPassword1">Senha</label><input type="password" class="form-control" id="exampleInputPassword1">
					</div> 
					
					<div class="form-group">
							<label class="checkbox-inline">
						      <input type="checkbox" value="">Lembre-me
						    </label>
							<a href="#" style="float:right;">Esqueci minha senha</a>
					</div>
				</form>
				<select id="selectInicio" class="form-control">
					<option selected value="#">Selecione</option>
					<option value="view/SecretariaPrincipal.jsp">Secretaria</option>
					<option value="view/FisioterapiaAtleta.jsp">Fisioterapia</option>
					<option value="view/PsicologiaAtleta.jsp">Psicologia</option>
					<option value="view/NutricionistaAtleta.jsp">Nutricionista</option>
					<option value="#">Técnico</option>
					<option value="#">Técnico Avaliador</option>
				</select>
				
			</div>
			<div class="col-md-4 column">
			</div>
		</div>
	</div>
	
<%-- 	<%@include file="../layout/footer.jsp"%> --%>
	
	<script type="text/javascript" src="http://cidades-estados-js.googlecode.com/files/cidades-estados-v0.2.js"></script>
	
	
	<script type="text/javascript" src="<%=Constants.JS%>/jquery-2.1.3.js"></script>
	
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script type="text/javascript" src="<%=Constants.JS%>/bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=Constants.JS%>/script.js"></script>
	
  </body>
</html>