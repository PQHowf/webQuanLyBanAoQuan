<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CHI TIẾT HÓA ĐƠN</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
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
    
    span {
    	color:red;
    }
    
    h3 h4{
    	margin: 5px;
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
						<li class="nav-item"><a class="nav-link" href="QuanLySanPham">QUẢN LÝ SẢN PHẨM</a></li>
						<li class="nav-item"><a class="nav-link" href="QuanLyLoai">QUẢN LÝ LOẠI</a></li>
						<li class="nav-item"><a class="nav-link" href="QuanLyMau">QUẢN LÝ MÀU</a></li>
						<li class="nav-item"><a class="nav-link" href="QuanLySize">QUẢN LÝ SIZE</a></li>
						<li class="nav-item"><a class="nav-link" href="QuanLyTaiKhoan">QUẢN LÝ TÀI KHOẢN</a></li>
						<li class="nav-item"><a class="nav-link active active-style" aria-current="page" href="QuanLyDonHang">QUẢN LÝ ĐƠN HÀNG</a></li>
					</ul>

					<!-- Phần bên phải -->
					<div class="d-flex ms-auto align-items-center">
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
	<div class="container mt-5">
		<c:if test="${not empty dsChiTiet}">
		    <h3>MÃ HÓA ĐƠN: <span>${dsChiTiet[0].maHoaDon}</span></h3>
		    <h3>TỔNG TIỀN: <span><fmt:formatNumber value="${dsChiTiet[0].tongTien}" type="number" pattern="#,##0"/>₫</span></h3>
		    
		    <h3>TÀI KHOẢN ĐẶT: <span>${dsChiTiet[0].hoVaTen}</span></h3>
		    <h4>DANH SÁCH SẢN PHẨM ĐÃ ĐẶT:</h4>
		</c:if>
		<c:forEach var="hd" items="${dsChiTiet }">
			<div class="item">
		        <img src="${hd.anh }" alt="Sản phẩm">
		        <div class="item-info">
		            <p>Tên sản phẩm: ${hd.tenSanPham }</p>
		            <p>Số lượng: ${hd.soLuongSanPham }</p>
		            <p>Size: ${hd.tenKichThuoc }</p>
		            <p>Màu: ${hd.tenMau }</p>
		        </div>
		    </div>
		</c:forEach>
	</div>
</body>
</html>