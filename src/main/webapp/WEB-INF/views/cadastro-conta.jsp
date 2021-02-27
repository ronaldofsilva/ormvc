<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inserir Conta</title>

<link href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
	<h3>Inserir Conta</h3>
	<c:forEach items="${requesScope['org.springframework.validation.BindingResult.conta'].allErrors}" var="error">
		${error.code}
	
	</c:forEach>
	<form action="save">
		<input class="form-control" type="text" name="nome" id="name" /><br /> <input type="text"
			name="numero" id="numero" /><br /> <input type="submit"
			value="Salvar" />
	</form>
	<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/script.js"></script>
</body>
</html>