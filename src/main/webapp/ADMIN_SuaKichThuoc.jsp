<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SỬA KÍCH THƯỚC</title>
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
		<h2 class="text-center">SỬA KÍCH THƯỚC</h2>
		<form action="SuaKichThuoc" method="post">
			<div class="mb-3">
		    	<label class="form-label">Mã kích thước:</label>
		    	<input type="text" class="form-control" name="makichthuocsua" value="${kichthuocSua.maKichThuoc }" readonly>
			</div>
			<div class="mb-3">
		    	<label class="form-label">Tên kích thước:</label>
		    	<input type="text" class="form-control" name="tenkichthuocsua" value="${kichthuocSua.tenKichThuoc }" required>
			</div>
			<div class="text-end">
				<button type="submit" class="btn btn-success px-5"><i class="bi bi-pencil"></i> SỬA</button>
				<a href="QuanLySize" class="btn btn-danger px-5"><i class="bi bi-x-circle"></i> HỦY</a>
			</div>
		</form>
	</div>
</body>
</html>