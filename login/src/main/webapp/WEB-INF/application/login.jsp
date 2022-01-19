<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="utils.UrlConst"%>
<!doctype html>
<html lang="en">
<head>
<title>Login</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
	<div style="width: 30%; margin-inline: 35%;">
		<h1 style="text-align: center;">Login</h1>
		<c:if test="${message!= null}">
			<div class="form-text text-danger">${message}</div>
		</c:if>
		<form action="<%=request.getContextPath() + UrlConst.LOGIN %>"
			method="post">
			<div class="mb-3">
				<label for="exampleInputEmail1" class="form-label">Email address</label> 
				<input name="email" type="email" class="form-control"
					id="exampleInputEmail1"
					value='<%=request.getParameter("email") == null ? "" : request.getParameter("email")%>'
					required />
				<c:if test="${errEmail != null}">
					<div class="form-text text-danger">${errEmail}</div>
				</c:if>
			</div>
			<div class="mb-3">
				<label for="exampleInputPassword1" class="form-label">Password</label>
				<input name="password" type="password" class="form-control"
					id="exampleInputPassword1"
					value='<%=request.getParameter("password") == null ? "" : request.getParameter("password")%>'
					required />
				<c:if test="${errPassword != null}">
					<div class="form-text text-danger">${errPassword}</div>
				</c:if>
			</div>
			<button type="submit" class="btn btn-primary">Login</button>
		</form>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>