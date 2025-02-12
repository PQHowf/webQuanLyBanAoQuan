<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ĐẶT HÀNG THÀNH CÔNG</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>

<style>
	.container {
		width: 30%;
		text-align: center;
		background-color: #f8f9fa;
	}
	p {
		font-size: 20px;
		font-weight: bold;
		color: red;
	}
</style>

</head>
<body>
	<nav class="navbar navbar-expand-lg bg-body-tertiary style-nav">
			<div class="container-fluid">
				<a class="navbar-brand" href="SanPhamController"> 
					<img src="image/logo_giohang.png" class="image" style="height: 40px; width: 40px">
					SHOP QUẦN ÁO
				</a>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<!-- Phần menu bên trái -->
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item"><a class="nav-link" href="SanPhamController">TRANG CHỦ</a></li>
						<li class="nav-item"><a class="nav-link" aria-current="page" href="GioHangDayDuController">GIỎ HÀNG</a></li>
						<li class="nav-item"><a class="nav-link" aria-current="page" href="LichSuDatHangController">LỊCH SỬ ĐẶT HÀNG</a></li>
					</ul>

					<!-- Phần bên phải -->
					<div class="d-flex ms-auto align-items-center">
						<!-- Ô tìm kiếm -->
						
						<!-- Login hoặc Xin chào -->
						<ul class="navbar-nav">
							<c:if test="${sessionScope.dn == null}">
								<li class="nav-item">
									<a class="btn btn-outline-primary" href="DangNhapController"> 
										<span class="bi bi-door-open"></span> Đăng nhập
								</a></li>
							</c:if>
							<c:if test="${sessionScope.dn != null}">
								<li class="nav-item">
									<span class="bi bi-person"></span>
									Xin chào: ${sessionScope.dn.hoVaTen} 
									<a href="DangXuatController" class="btn btn-danger" style="margin-left: 10px">
										<span class="bi bi-box-arrow-right"></span> Đăng xuất
									</a>
								</li>
							</c:if>
						</ul>
					</div>
				</div>
			</div>
		</nav>
	<div class = "container border rounded shadow p-4" style="margin-top: 14%">
		<p>ĐẶT HÀNG THÀNH CÔNG</p>
		<p>MÃ ĐƠN HÀNG CỦA BẠN LÀ: ${requestScope.maHoaDon}</p>
		<p class="bi bi-truck"> ĐƠN HÀNG SẼ ĐƯỢC GIAO SỚM !!!</p>
		<a href="SanPhamController" class="btn btn-outline-warning">QUAY LẠI TRANG CHỦ</a>
	</div>
</body>
</html>