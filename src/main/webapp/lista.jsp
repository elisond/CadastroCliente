<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de Clientes</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="CreateAndFind1">Lista de Clientes</a>
        </li>
      </ul>
      <form action="CreateAndFind1" method="GET" class="d-flex">
        <input name="pesquisa" class="form-control me-2" type="search" placeholder="Digite o Nome ou CPF" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Buscar</button>
      </form>
    </div>
  </div>
</nav>
<br>
<div class="container">
	<div class="row">
		<div class="cold-md-7">
			<hr>
			<h3>Clientes Cadastrados</h3>
			<hr>
			<table class="table">
				<thead>
					<tr>
						<th>#</th>
						<th>Nome</th>
						<th>Endereço</th>
						<th>Modalidade</th>
						<th>Situação</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${clientes}" var="cliente">
							<tr>
								<td>${cliente.id}</td>
								<td>${cliente.nomeCliente}</td>
								<td>${cliente.enderecoCliente}</td>
								<td>${cliente.modalidadeCliente}</td>
								<td>${cliente.situacaoCliente}</td>
								<td>
									<a href="ClienteDestroy?clienteId=${cliente.id}">deletar</a> |
									<a href="ClienteUpdate?clienteId=${cliente.id}">atualizar</a>
								</td>
							</tr>
						</c:forEach>
				</tbody>
			</table>
			<h5><a href="index.jsp">Voltar para o Cadastro de Clientes</a></h5>
		</div>
	</div>
</div>
<!-- JavaScript Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js">
		crossorigin="anonymous"></script>
</body>
</html>