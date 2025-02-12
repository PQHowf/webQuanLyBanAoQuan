<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>XÁC NHẬN ĐẶT HÀNG</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
<style>
	.active-style {
		color: red !important;
		font-weight: bold;
	}
	
	.custom-radio .form-check-input {
        width: 20px;
        height: 20px;
        border-radius: 50%;
        border: 2px solid #ccc;
        transition: all 0.3s ease;
    }

    .custom-radio .form-check-input:checked {
        background-color: #007bff;
        border-color: #007bff;
    }

    .custom-radio .form-check-label {
        margin-left: 1rem;
        font-size: 1.1rem;
        font-weight: 500;
        color: #333;
        transition: color 0.3s ease;
    }

    .custom-radio .form-check-input:checked + .form-check-label {
        color: #007bff;
    }
</style>
</head>
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
	</div>
	<div class="p-5">
		<div class="row">
			<div class="col-2">
				
			</div>
			<div class="col-5">
				<div class="container border rounded shadow p-4">
					<span style="font-weight:bold; font-size:30px">XÁC NHẬN ĐƠN HÀNG</span>
					<hr>
					<form action="XacNhanThanhToanController" method="post">
						<h5 class="mb-3">Thông tin người nhận</h5>
						<input class="form-control mb-3" type="text" id="ten" name="ten" placeholder="Nhập tên khách hàng" required>
						<input class="form-control mb-3" type="text" id="sodienthoai" name="sodienthoai" placeholder="Nhập số điện thoại" required>
						<input class="form-control mb-3" type="text" id="email" name="email" placeholder="Nhập địa chỉ email (không bắt buộc)">
						<input class="form-control mb-3" type="text" id="thanhpho" name="thanhpho" placeholder="Nhập thành phố" required>
						<input class="form-control mb-3" type="text" id="diachinha" name="diachinha" placeholder="Nhập địa chỉ nhà" required>
						<input class="form-control mb-5" type="text" id="ghichu" name="ghichu" placeholder="Ghi chú (không bắt buộc)">
						<h5 class="mb-3">Phương thức thanh toán</h5>
						<div class="custom-radio form-check">
					        <input class="form-check-input" type="radio" id="tienMat" name="paymentMethod" value="TienMat">
					        <label class="form-check-label" for="tienMat">Thanh toán tiền mặt</label>
					    </div>
					    <div class="custom-radio form-check mt-3">
					        <input class="form-check-input" type="radio" id="theATM" name="paymentMethod" value="TheATM">
					        <label class="form-check-label" for="theATM">Thẻ tín dụng</label>
					    </div>
					    <button type="submit" class="btn btn-outline-primary mt-3" style="width: 100%; height: 50px">Xác nhận thanh toán</button>
					</form>
				</div>
			</div>
			<div class="col-5">
				<div class="container border rounded shadow p-4">
					<span style="font-weight:bold; font-size:30px">THÔNG TIN ĐƠN HÀNG</span>
					<hr>
					<c:if test="${not empty gioHang}">
						<table class="table table-bordered">
							<thead>
			                    <tr>
			                        <th>#</th>
			                        <th>Sản phẩm</th>
			                        <th>Số lượng</th>
			                        <th>Giá</th>
			                        <th>Thành tiền</th>
			                    </tr>
			                </thead>
			                <tbody>
			                    <c:forEach var="item" items="${gioHang.getDsGioHang()}" varStatus="status">
			                        <tr>
			                            <td>${status.index + 1}</td>
			                            <td>${item.getTenSanPham()}</td>
			                            <td>${item.getSoLuong()}</td>
			                            <td>${item.getGiaDinhDang()} đ</td>
			                            <td>${item.getThanhTienDinhDang()} đ</td>
			                        </tr>
			                    </c:forEach>
			                </tbody>
			                <tfoot>
			                    <tr>
			                        <th style="color:red" colspan="4" class="text-end">Tổng tiền:</th>
			                        <th style="color:red">${gioHang.TongThanhTien()} đ</th>
			                    </tr>
			                </tfoot>
						</table>
					</c:if>
			        <a href="GioHangDayDuController" class="btn btn-secondary">Quay lại giỏ hàng</a>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>