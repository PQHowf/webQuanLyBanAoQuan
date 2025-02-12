<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TRANG CHỦ</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
<style>
	.style-nav {
		padding: 10px 50px 10px 50px;
	}
	.active-style {
		color: red !important;
		font-weight: bold;
	}
	.border-style {
		border: 3px solid #ccc;
		border-radius: 15px;
		padding: 2px;
		text-align: center;
		margin: 10px;
		transition: all 0.3s ease;
	}
	.border-style:hover {
		box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.5);
	    transform: scale(1.09);
	}
	.product-name {
	    display: block;
	    font-weight: bold;
	    white-space: nowrap;
	    overflow: hidden;
	    text-overflow: ellipsis;
	    width: 100%;
	}
</style>
</head>
<body>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
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
						<li class="nav-item"><a class="nav-link active active-style" aria-current="page" href="SanPhamController">TRANG CHỦ</a></li>
						<li class="nav-item"><a class="nav-link" href="GioHangDayDuController">GIỎ HÀNG</a></li>
						<li class="nav-item"><a class="nav-link" aria-current="page" href="LichSuDatHangController">LỊCH SỬ ĐẶT HÀNG</a></li>
					</ul>

					<!-- Phần bên phải -->
					<div class="d-flex ms-auto align-items-center">
						<!-- Ô tìm kiếm -->
						<form class="d-flex me-3" role="search">
							<input 
								class="form-control me-2" 
								type="search" 
								placeholder="Nhập tên sản phẩm" 
								name="txtTimKiem"
								value="${param.txtTimKiem != null ? param.txtTimKiem : ''}">
							<button class="btn btn-outline-success" type="submit">Tìm</button>
						</form>
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
	<div class="p-2">
		<div class="row">
			<div class="col-sm-2 mt-3 ms-5 me-2">
				<div style="margin-bottom: 10px; font-weight: bold; font-size:20px">DANH MỤC SẢN PHẨM:</div>
				<a class="btn btn-outline-dark mb-2" style="width: 150px;" href="SanPhamController">Tất cả sản phẩm</a> <br>
				<c:forEach var="l" items="${dsLoai}">
					<a class="btn btn-outline-dark mb-2" style="width: 150px;" href="SanPhamController?maLoai=${l.getMaLoai()}">${l.getTenLoai()} </a> <br>
				</c:forEach>
			</div>
			<div class="col-sm-9">
				<div class="row">
					<c:forEach var="s" items="${dsSanPham}">
						<div class="col-sm-2 border-style">
							<img src="${s.getAnh() }" style="heigth: 200px; width: 90%; margin-top: 5px"> <br>
							<b class="product-name">${s.getTenSanPham() }</b>
							<span style="font-weight: bold; font-size:13px; color:red; display: inline-block; margin: 10px">${s.getGiaDinhDang() }đ</span>
							<a 
								href="GioHangController?masp=${s.getMaSanPham() }&tensp=${s.getTenSanPham()}&giasp=${s.getGia()}&anhsp=${s.getAnh()}" 
								class="bi bi-cart-plus btn btn-outline-success mb-2"> 
								THÊM VÀO GIỎ
							</a>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
	<nav aria-label="Page navigation" class="d-flex justify-content-center mt-3">
	    <ul class="pagination">
	        <c:forEach var="i" begin="1" end="${SoTrang}">
	            <li class="page-item ${i == currentPage ? 'active' : ''}">
	                <a class="page-link me-2 text-center" 
	                   href="SanPhamController?page=${i}${not empty maLoai ? '&maLoai=' + maLoai : ''}">
	                   ${i}
	                </a>
	            </li>
	        </c:forEach>
	    </ul>
	</nav>

	

</body>
</html>