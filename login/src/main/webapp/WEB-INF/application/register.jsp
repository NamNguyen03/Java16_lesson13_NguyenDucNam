<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="utils.UrlConst"%>
<!doctype html>
<html lang="en">
<head>
<title>Register</title>
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
		<h1 style="text-align: center;">Register</h1>
		<form action="<%=request.getContextPath() + UrlConst.REGISTER %>"
			method="post">
			<div class="mb-3">
				<label for="fullname" class="form-label">Full Name</label> <input
					name="fullname" type="text" class="form-control"
					id="exampleInputEmail1"
					value='<%=request.getParameter("fullname") == null ? "" : request.getParameter("fullname") %>'
					required />
				<c:if test="${errFullname != null}">
					<div class="form-text text-danger">${errFullname}</div>
				</c:if>
			</div>
			<div class="mb-3">
				<label for="phone" class="form-label">Phone</label> 
				<input
					name="phone" type="text" class="form-control"
					id="exampleInputEmail1"
					value='<%=request.getParameter("phone") == null ? "" : request.getParameter("phone")%>'
					required />
				<c:if test="${errPhone != null}">
					<div class="form-text text-danger">${errPhone}</div>
				</c:if>
			</div>
			<div class="mb-3">
				<label for="email" class="form-label">Email address</label> 
				<input
					name="email" type="email" class="form-control"
					id="exampleInputEmail1"
					value='<%=request.getParameter("email") == null ? "" : request.getParameter("email")%>'
					required />
				<c:if test="${errEmail != null}">
					<div class="form-text text-danger">${errEmail}</div>
				</c:if>
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">Password</label> 
				<input
					name="password" type="password" class="form-control"
					id="exampleInputPassword1"
					value='<%=request.getParameter("password") == null ? "" : request.getParameter("password")%>'
					required />
				<c:if test="${errPassword != null}">
					<div class="form-text text-danger">${errPassword}</div>
				</c:if>
			</div>
			<div class="mb-3">
				<label for="rpassword" class="form-label">Repeat Password</label> 
				<input
					name="rpassword" type="password" class="form-control"
					id="exampleInputPassword1"
					value='<%=request.getParameter("rpassword") == null ? "" : request.getParameter("rpassword")%>'
					required />
				<c:if test="${errRpassword != null}">
					<div class="form-text text-danger">${errRpassword}</div>
				</c:if>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
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