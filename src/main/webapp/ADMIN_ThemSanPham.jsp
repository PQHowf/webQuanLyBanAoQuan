<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>THÊM SẢN PHẨM</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
<style>
	.container {
		width: 30%;
	}
</style>
</head>
<body>
	<div class="container mt-4">
		<h2 class="text-center">THÊM SẢN PHẨM</h2>
		<form action="ThemSanPham" method="post" enctype="multipart/form-data">
			<div class="mb-3">
		    	<label class="form-label">Tên sản phẩm:</label>
		    	<input type="text" class="form-control" name="tensp" required>
			</div>
			<div class="mb-3">
		    	<label class="form-label">Giá:</label>
		    	<input type="text" class="form-control" name="giasp" required>
			</div>
			<div class="mb-3">
		    	<label class="form-label">Mô tả:</label>
		    	<textarea class="form-control" name="motasp" rows="3"></textarea>
			</div>
			<div class="mb-3">
		    	<label class="form-label">Ảnh</label>
		    	<input type="file" class="form-control" name="anhsp" required>
			</div>
			<div class="mb-3">
		    	<label class="form-label">Loại</label>
		    	<select class="form-select" name="maloai" required>
					<option value="" disabled>-- Chọn loại --</option>
					<c:forEach var="loai" items="${dsLoai}">
	                    <option value="${loai.maLoai}">${loai.tenLoai}</option>
	                </c:forEach>
				</select>
			</div>
			<div class="text-end">
				<button type="submit" class="btn btn-success px-5"><i class="bi bi-plus-circle"></i> THÊM</button>
				<a href="QuanLySanPham" class="btn btn-danger px-5"><i class="bi bi-x-circle"></i> HỦY</a>
			</div>
		</form>
	</div>
</body>
</html>