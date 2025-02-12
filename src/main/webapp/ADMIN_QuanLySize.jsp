<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QUẢN LÝ SIZE</title>
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
						<li class="nav-item"><a class="nav-link" href="QuanLySanPham">QUẢN LÝ SẢN PHẨM</a></li>
						<li class="nav-item"><a class="nav-link" href="QuanLyLoai">QUẢN LÝ LOẠI</a></li>
						<li class="nav-item"><a class="nav-link" href="QuanLyMau">QUẢN LÝ MÀU</a></li>
						<li class="nav-item"><a class="nav-link active active-style" aria-current="page"  href="QuanLySize">QUẢN LÝ SIZE</a></li>
						<li class="nav-item"><a class="nav-link" href="QuanLyTaiKhoan">QUẢN LÝ TÀI KHOẢN</a></li>
						<li class="nav-item"><a class="nav-link" href="QuanLyDonHang">QUẢN LÝ ĐƠN HÀNG</a></li>
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
        <h2 class="text-center">DANH SÁCH KÍCH THƯỚC</h2>
        <div class="d-flex">
		    <a href="ThemKichThuoc" class="btn btn-outline-success me-3 mb-3">
		        <span class="bi bi-plus-circle"> THÊM KÍCH THƯỚC</span>
		    </a>
		
		    <form class="d-flex" role="search">
		        <input 
		            class="form-control mb-3" 
		            type="search" 
		            placeholder="Nhập tên kích thước" 
		            name="txtTimKiem"
		            value="${param.txtTimKiem != null ? param.txtTimKiem : ''}">
		        <button class="btn btn-outline-dark mb-3 ms-2" type="submit"><i class="bi bi-search"></i></button>
		    </form>
		</div>

        <table class="table table-bordered table-striped text-center">
            <thead class="table-dark">
                <tr class="align-middle">
                    <th>Mã Kích Thước</th>
                    <th>Tên Kích Thước</th>
                    <th>Hành Động</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="kt" items="${dsKichThuoc}">
                    <tr class="align-middle">
                        <td>${kt.maKichThuoc}</td>
                        <td>${kt.tenKichThuoc}</td>
                        <td>
							<div class="d-inline-flex align-items-center">
							    <!-- Form chỉnh sửa -->
							    <form action="SuaKichThuoc_HienThiForm" method="post" class="me-2">
							        <input type="hidden" name="chinhsua" value="edit"> 
							        <input type="hidden" name="makichthuocsua" value="${kt.getMaKichThuoc() }">
							        <button type="submit" class="btn btn-outline-primary">
							            <i class="bi bi-pencil"></i>
							        </button>
							    </form> 
							
							    <!-- Form xóa -->
							    <form action="XoaKichThuoc" method="post">
							        <input type="hidden" name="delete" value="delete"> 
							        <input type="hidden" name="makichthuocxoa" value="${kt.getMaKichThuoc() }">
							        <button type="submit" class="btn btn-outline-danger" onclick="return confirm('Bạn có chắc muốn xóa kích thước này?');">
							            <i class="bi bi-trash3"></i>
							        </button>
							    </form>
							</div>
						</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>