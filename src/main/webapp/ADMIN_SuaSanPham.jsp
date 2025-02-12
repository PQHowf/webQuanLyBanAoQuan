<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SỬA SẢN PHẨM</title>
</head>
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
		<form action="SuaSanPham" method="post" enctype="multipart/form-data">
			<div class="mb-3">
		    	<label class="form-label">Mã sản phẩm:</label>
		    	<input type="text" class="form-control" name="masp" value="${spSua.maSanPham }" readonly>
			</div>
			<div class="mb-3">
		    	<label class="form-label">Tên sản phẩm:</label>
		    	<input type="text" class="form-control" name="tensp" value="${spSua.tenSanPham }" required>
			</div>
			<div class="mb-3">
		    	<label class="form-label">Giá:</label>
		    	<input type="text" class="form-control" name="giasp" value="${spSua.gia }"  required>
			</div>
			<div class="mb-3">
		    	<label class="form-label">Mô tả:</label>
		    	<textarea class="form-control" name="motasp" rows="4">${spSua.moTa }</textarea>
			</div>
			<div class="mb-3">
		    	<label class="form-label">Ảnh</label>
		    	<input type="file" class="form-control" name="anhsp" value="${spSua.anh }">
		    	<input type="hidden" name="anhspcu" value="${spSua.anh }">
		    	<img src="${spSua.anh}" alt="Ảnh sản phẩm" width="150">
			</div>
			<div class="mb-3">
		    	<label class="form-label">Loại</label>
		    	<select class="form-select" name="maloai" required>
					<option value="" disabled>-- Chọn loại --</option>
					<c:forEach var="loai" items="${dsLoai}">
	                    <option value="${loai.maLoai}" ${loai.maLoai == spSua.maLoai ? 'selected' : ''}>${loai.tenLoai}</option>
	                </c:forEach>
				</select>
			</div>
			<div class="text-end">
				<button type="submit" class="btn btn-success px-5"><i class="bi bi-pencil"></i> SỬA</button>
				<a href="QuanLySanPham" class="btn btn-danger px-5"><i class="bi bi-x-circle"></i> HỦY</a>
			</div>
		</form>
	</div>
</body>
</html>