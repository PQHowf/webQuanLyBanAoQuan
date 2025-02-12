<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>THÊM TÀI KHOẢN</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</head>
<style>
	.container {
		width: 30%;
	}
</style>
<body>
	<div class="container mt-4">
		<h2 class="text-center">THÊM TÀI KHOẢN</h2>
		<form action="ThemTaiKhoan" method="post">
			<div class="mb-3">
		    	<label class="form-label">Tên tài khoản:</label>
		    	<input type="text" class="form-control" name="tentaikhoan" required>
			</div>
			<div class="mb-3">
		    	<label class="form-label">Mật khẩu:</label>
		    	<input type="text" class="form-control" name="matkhau" required>
			</div>
			<div class="mb-3">
		    	<label class="form-label">Họ và tên:</label>
		    	<input type="text" class="form-control" name="hovaten" required>
			</div>
			<div class="mb-3">
		    	<label class="form-label">Số điện thoại:</label>
		    	<input type="text" class="form-control" name="sodienthoai">
			</div>
			<div class="mb-3">
		    	<label class="form-label">Email:</label>
		    	<input type="text" class="form-control" name="email">
			</div>
			<div class="mb-3">
		    	<label class="form-label">Địa chỉ nhà:</label>
		    	<input type="text" class="form-control" name="diachinha">
			</div>
			<div class="mb-3">
		    	<label class="form-label">Thành phố:</label>
		    	<input type="text" class="form-control" name="thanhpho" required>
			</div>
			<div class="mb-3">
		    	<label class="form-label">Chức vụ:</label>
		    	<select class="form-select" name="chucvu" required>
					<option value="" disabled>-- Chọn chức vụ --</option>
	                <option value="NguoiDung">Người dùng</option>
	                <option value="Admin">ADMIN</option>
				</select>
			</div>
			<div class="text-end">
				<button type="submit" class="btn btn-success px-5"><i class="bi bi-plus-circle"></i> THÊM</button>
				<a href="QuanLyLoai" class="btn btn-danger px-5"><i class="bi bi-x-circle"></i> HỦY</a>
			</div>
		</form>
	</div>
</body>
</html>