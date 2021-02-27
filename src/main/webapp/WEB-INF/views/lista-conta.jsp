<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listar contas</title>
<link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<h2>Listando das contas</h2>
<table class="table">
	<thead>
	<tr>
	<th scope="col">Cliente</th>
	<th scope="col">Conta</th>
	</tr>
	</thead>
	<c:forEach items="${contas }" var="c">
		
		<tr>
			<td>${c.nome }</td>
			<td>${c.numero }</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</body>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/jquery.js"></script>
</html>