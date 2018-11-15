<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Deltagerliste</title>
</head>
<body>
	<h2>Deltagerliste</h2>
	<table class="pure-table">
		<tr bgcolor="#cccccc">
			<th>Kj�nn</th>
			<th align="left">Navn</th>
			<th align="left">Mobil</th>
		</tr>
		<c:forEach items="${list}" var="p">
			<tr
				bgcolor=<c:choose>
				<c:when test="${p.mobil == bruker}">
					"#008000"
				</c:when>
				<c:otherwise>
					"#ffffff"
				</c:otherwise>
			</c:choose>>
			<c:choose>
				<c:when test="${p.kjonn == 'kvinne'}">
					<td align="center">&#9792</td>
				</c:when>
				<c:otherwise>
					<td align="center">&#9794</td>
				</c:otherwise>
			</c:choose>
				<td>${p.fornavn}  ${p.etternavn}</td>
				<td>${p.mobil}</td>
			</tr>
		</c:forEach>
	</table>
	<p>
		<a href="ferdigServlet">Ferdig</a>
	</p>
</body>
</html>


<!--  kvinne: &#9792
	  mann:   &#9794 -->

