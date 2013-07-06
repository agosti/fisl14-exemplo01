<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" 
    uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

  <table>
     <tr>
     	<td>Código</td>
     	<td>Nome</td>
     	<td>Alterar</td>
     	<td>Excluir</td>
     </tr>
     <c:forEach items="${pessoas}" var="pessoa">
     	<tr>
     		<td>${pessoa.codigo} </td>
     		<td>${pessoa.nome} </td>
			<td><a href="<c:url value='/pessoa/editar/${pessoa.codigo}'/>">Editar</a></td>
			<td><a href="<c:url value='/pessoa/excluir/${pessoa.codigo}'/>">Excluir</a></td>
     	</tr>
     </c:forEach>
     
  </table>

<a href='<c:url value='/pessoa/formulario'/>'>Novo</a>

</body>
</html>