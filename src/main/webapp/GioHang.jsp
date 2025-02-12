<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GIỎ HÀNG</title>
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
	.gioHangTitle {
		display: inline-block; 
		margin: 10px;
		font-size: 30px;
		font-weight: bold;
	}
	.img-style {
		width: 120px;
		height: 150px;
		margin: 15px;
	}
	.col-2-style {
    	flex: 0 0 auto;
    }
    .custom-select {
	    width: 40%;
	    padding: 5px;
	    border: 2px solid #ddd;
	    border-radius: 5px;
	    background-color: #f9f9f9;
	    font-size: 14px;
	    transition: border-color 0.3s ease;
	    outline: none;
	}
	
	.custom-select:hover {
	    border-color: #007bff;
	}
	
	.custom-select:focus {
	    border-color: #007bff;
	    box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
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
						<li class="nav-item"><a class="nav-link active active-style" aria-current="page" href="GioHangDayDuController">GIỎ HÀNG</a></li>
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
	</div>
	<div class="container">
	    <span class="gioHangTitle">GIỎ HÀNG</span>
	    <c:if test="${not empty errorMessage}">
		    <div class="alert alert-danger m-5" role="alert">
		        ${errorMessage}
		    </div>
		</c:if>
	    <div class="row">
		    <!-- Form đầu tiên: Xử lý các hành động liên quan đến giỏ hàng -->
		    <form action="XoaSua_DatHangController" method="post" accept-charset="UTF-8">
		        <c:if test="${not empty sessionScope.gioHang}">
		            <div class="col-12">
		            	<c:if test="${not empty sessionScope.gioHang.getDsGioHang()}">
		                    <div class="m-3">
				                <button type="submit" name="action" value="deleteSelected" class="btn btn-outline-danger">Xóa các sản phẩm đã chọn</button>
				                <button type="submit" name="action" value="deleteAll" class="btn btn-outline-warning">Xóa toàn bộ sản phẩm trong giỏ</button>
			                </div>
		                </c:if>
		                <c:forEach var="h" items="${sessionScope.gioHang.getDsGioHang()}">
		                    <div class="row align-items-center mb-3 border-bottom pb-3">
		                        
		                        <div class="col-1 text-center">
		                            <input type="checkbox" name="spDaChon" value="${h.getMaSanPham()}">
		                        </div>
		                        <div class="col-1">
		                            <img src="${h.getAnh()}" class="img-fluid img-thumbnail" style="max-width: 100px; border-radius: 8px;">
		                        </div>
		                        <div class="col-4">
		                            <div class="mb-2">
		                                <strong style="font-size: 16px;">${h.getTenSanPham()}</strong>
		                            </div>
		                            <div class="mb-2">
		                                <span style="font-weight: bold; font-size: 14px; color: #ff4500;">${h.getGiaDinhDang()} đ</span>
		                            </div>
		                            <div class="product-options">
		                                <select class="custom-select" name="mau_${h.getMaSanPham()}">
		                                    <option value="" disabled selected>Chọn màu sắc</option>
		                                    <c:forEach var="m" items="${dsMau}">
		                                        <option value="${m.getMaMau()}">${m.getTenMau()}</option>
		                                    </c:forEach>
		                                </select>
		                                
		                                <select class="custom-select" name="kichCo_${h.getMaSanPham()}">
		                                    <option value="" disabled selected>Chọn kích cỡ</option>
		                                    <c:forEach var="kt" items="${dsKichThuoc}">
		                                        <option value="${kt.getMaKichThuoc()}">${kt.getTenKichThuoc()}</option>
		                                    </c:forEach>
		                                </select>
		                                
		                            </div>
		                        </div>
		                        <div class="col-3 align-items-center">
		                            <div class="row">
		                                <button type="submit" class="btn btn-outline-secondary btn-sm col-1 me-1" name="action" value="decrease">-</button>
		                                <input type="text" name="quantity_${h.getMaSanPham()}" value="${h.getSoLuong()}" class="form-control text-center col-1" style="width: 50px;" readonly>
		                                <button type="submit" class="btn btn-outline-secondary btn-sm col-1 ms-1" name="action" value="increase">+</button>
		                            </div>
		                            <input type="hidden" name="masp" value="${h.getMaSanPham()}">
		                        </div>
		                    </div>
		                </c:forEach>
		            </div>
		        </c:if>
		        <!-- Form thứ hai: Đặt hàng -->
			    <div class="col-4">
			        <div class="order-summary p-3 border rounded">
			            <h5>Chi tiết đơn hàng</h5>
			            <div class="summary-item d-flex justify-content-between mt-3">
			                <span>Tổng số sản phẩm</span>
			                <span>${sessionScope.gioHang.TongSoLuongSanPham()} sản phẩm</span>
			            </div>
			            <div class="summary-item d-flex justify-content-between">
			                <span>Tổng giá trị sản phẩm</span>
			                <span>${sessionScope.gioHang.TongThanhTien()} đ</span>
			            </div>
			            <div class="summary-item d-flex justify-content-between">
			                <span>Vận chuyển</span>
			                <span>20.000 đ</span>
			            </div>
			            <div class="summary-item d-flex justify-content-between">
			                <span>Giảm giá vận chuyển</span>
			                <span>-20.000 đ</span>
			            </div>
			            <div class="summary-item total d-flex justify-content-between mt-3">
			                <strong>Tổng thanh toán</strong>
			                <strong style="color: #ff4500;">${sessionScope.gioHang.TongThanhTien()} đ</strong>
			            </div>
			            <button type="submit" class="btn btn-warning mt-3" name="action" value="placeOrder">Đặt hàng</button>
			        </div>
			    </div>
		    </form>
		</div>
	</div>
</body>
</html>