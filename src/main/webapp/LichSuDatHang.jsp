<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LỊCH SỬ ĐẶT HÀNG</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</head>
<style>
	.style-nav {
		padding: 10px 50px 10px 50px;
	}
	.active-style {
		color: red !important;
		font-weight: bold;
	}
	.item {
        display: flex;
        align-items: center;
        justify-content: space-between;
        border: 1px solid #ddd;
        border-radius: 10px;
        padding: 15px;
        margin-bottom: 20px;
        box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    }

    .item img {
        width: 120px;
        height: 120px;
        object-fit: cover;
        border-radius: 10px;
        border: 1px solid #ccc;
    }

    .item-info {
        flex: 1;
        margin-left: 20px;
    }

    .item-info h5 {
        margin: 0;
        font-size: 20px;
        font-weight: bold;
        color: #333;
    }

    .item-info p {
        margin: 5px 0;
        font-size: 16px;
        color: #666;
    }

    .item-total {
        text-align: right;
    }

    .item-total h5 {
        color: #ff5722;
        font-weight: bold;
        margin: 0;
    }

    .item-total p {
        margin: 0;
        font-size: 14px;
        color: #666;
    }
</style>
<body>
	<div>
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
						<li class="nav-item"><a class="nav-link" href="GioHangDayDuController">GIỎ HÀNG</a></li>
						<li class="nav-item"><a class="nav-link active active-style" aria-current="page" href="LichSuDatHangController">LỊCH SỬ ĐẶT HÀNG</a></li>
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
	</div>
	<div class="container mt-4">
		<h1 class="mb-3">Lịch Sử Đặt Hàng</h1>
		<c:forEach var="hd" items="${dsHoaDon }">
			<div class="item">
		        <img src="${hd.anh }" alt="Sản phẩm">
		        <div class="item-info">
		        	<h5>MÃ ĐƠN HÀNG: ${hd.maHoaDon }</h5>
		            <p>${hd.tenSanPham }</p>
		            <p>Số lượng: ${hd.soLuong }</p>
		            <p>Giá sản phẩm: ${hd.gia }</p>
		            <p>Size: ${hd.tenSize }</p>
		            <p>Màu: ${hd.tenMau }</p>
		            <p>Ngày mua: ${hd.ngayLap }</p>
		        </div>
		        <div class="item-total">
		            <h5>Tổng tiền: <fmt:formatNumber value="${hd.tongTien}" type="number" pattern="#,##0"/>₫</h5>
		            <p>(Đã bao gồm VAT)</p>
		        </div>
		    </div>
		</c:forEach>
	</div>
</body>
</html>