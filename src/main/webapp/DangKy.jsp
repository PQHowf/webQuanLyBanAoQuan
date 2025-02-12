<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ĐĂNG KÝ</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
<style>
	body {
		display: grid;
		place-items: center;
		min-height: 100vh;
		margin: 0;
		background-color: #f1f1f1;
	}

	.container {
		width: 30%;
		text-align: center;
		background-color: #ffffff;
		padding: 20px;
		border-radius: 15px;
		box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.5);
	}
</style>

</head>
<body>
	<div class="container">
		<c:if test="${not empty error}">
		    <div class="alert alert-danger" role="alert">
		        ${error}
		    </div>
		</c:if>
		<form action="DangKyController" method="post">
			<h3 class="mb-4">ĐĂNG KÝ TÀI KHOẢN</h3>
			<input class="form-control mb-3" type="text" id="tentaikhoan" name="tentaikhoan" placeholder="Nhập tên tài khoản" required>
			<input class="form-control mb-3" type="password" id="matkhau" name="matkhau" placeholder="Nhập mật khẩu" required>
			<input class="form-control mb-3" type="text" id="hovaten" name="hovaten" placeholder="Nhập họ và tên" required>
			<input class="form-control mb-3" type="text" id="sodienthoai" name="sodienthoai" placeholder="Nhập số điện thoại" required>
			<input class="form-control mb-3" type="text" id="email" name="email" placeholder="Nhập địa chỉ email">
			<input class="form-control mb-3" type="text" id="thanhpho" name="thanhpho" placeholder="Nhập thành phố" required>
			<input class="form-control mb-3" type="text" id="diachinha" name="diachinha" placeholder="Nhập địa chỉ nhà" required>
			<button type="submit" class="btn btn-outline-primary" style="width: 40%; height: 50px">ĐĂNG KÝ</button>
			<a href="SanPhamController" class="btn btn-outline-danger" style="width: 40%; height: 50px; line-height: 35px;">TRỞ VỀ</a>
		</form>
	</div>
</body>
</html>