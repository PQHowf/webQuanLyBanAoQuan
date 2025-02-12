<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ĐĂNG NHẬP</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<style>
	.form {
		width: 300px;
		padding: 20px;
		margin-top: 10px;	
	}
</style>
</head>
<body>
	<div class="container">
		<div class="d-flex justify-content-center align-items-center" style="height: 100vh;">
			<form action="DangNhapController" method="post" class="form form-control">
			  	<div class="mb-3">
			    	<label class="form-label">TÊN TÀI KHOẢN</label>
			    	<input type="text" class="form-control" name="txtTenTaiKhoan">
			  </div>
			  <div class="mb-3">
			    	<label class="form-label">MẬT KHẨU</label>
			    	<input type="password" class="form-control" name="txtMatKhau">
			  </div>
			  <div class="mb-3">
			    	<img src="simpleCaptcha.jpg" />
			    	<input type="text" name="answer" /><br>
			  </div>			  
			  <button type="submit" class="btn btn-success" style="margin-right: 30px">Đăng nhập</button>
			  <a href="DangKyController" class="btn btn-primary">Đăng ký</a>
			</form>
		</div>
		<c:if test="${not empty errorMessage}">
		    <p style="color: red;">${errorMessage}</p>
		</c:if>
	</div>
</body>
</html>