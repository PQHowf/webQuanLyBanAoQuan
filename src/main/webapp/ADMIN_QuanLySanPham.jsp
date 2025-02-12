<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QUẢN LÝ SẢN PHẨM</title>
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
						<li class="nav-item"><a class="nav-link active active-style" aria-current="page" href="QuanLySanPham">QUẢN LÝ SẢN PHẨM</a></li>
						<li class="nav-item"><a class="nav-link" href="QuanLyLoai">QUẢN LÝ LOẠI</a></li>
						<li class="nav-item"><a class="nav-link" href="QuanLyMau">QUẢN LÝ MÀU</a></li>
						<li class="nav-item"><a class="nav-link" href="QuanLySize">QUẢN LÝ SIZE</a></li>
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
        <h2 class="text-center">DANH SÁCH SẢN PHẨM</h2>
        <div class="d-flex">
		    <a href="ThemSanPham" class="btn btn-outline-success me-3 mb-3">
		        <span class="bi bi-plus-circle"> THÊM SẢN PHẨM</span>
		    </a>
		
		    <form class="d-flex" role="search">
		        <input 
		            class="form-control mb-3" 
		            type="search" 
		            placeholder="Nhập tên sản phẩm" 
		            name="txtTimKiem"
		            value="${param.txtTimKiem != null ? param.txtTimKiem : ''}">
		        <button class="btn btn-outline-dark mb-3 ms-2" type="submit"><i class="bi bi-search"></i></button>
		    </form>
		</div>

        <table class="table table-bordered table-striped text-center">
            <thead class="table-dark">
                <tr class="align-middle">
                    <th>Mã Sản Phẩm</th>
                    <th>Tên Sản Phẩm</th>
                    <th>Giá</th>
                    <th>Mô Tả</th>
                    <th>Ảnh</th>
                    <th>Mã Loại</th>
                    <th>Hành Động</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="sp" items="${dsSanPham}">
                    <tr class="align-middle">
                        <td>${sp.maSanPham}</td>
                        <td>${sp.tenSanPham}</td>
                        <td>${sp.getGiaDinhDang()}</td>
                        <td>${sp.moTa}</td>
                        <td>
                            <img src="${sp.anh}" alt="Ảnh sản phẩm" style="width: 100px; height: auto;">
                        </td>
                        <td>${sp.maLoai}</td>
                        <td>
						<div class="d-inline-flex align-items-center">
						    <!-- Form chỉnh sửa -->
						    <form action="SuaSanPham_HienThiForm" method="post" class="me-2">
						        <input type="hidden" name="chinhsua" value="edit"> 
						        <input type="hidden" name="maspsua" value="${sp.getMaSanPham() }">
						        <button type="submit" class="btn btn-outline-primary">
						            <i class="bi bi-pencil"></i>
						        </button>
						    </form> 
						
						    <!-- Form xóa -->
						    <form action="XoaSanPham" method="post">
						        <input type="hidden" name="delete" value="delete"> 
						        <input type="hidden" name="mspxoa" value="${sp.getMaSanPham() }">
						        <button type="submit" class="btn btn-outline-danger" onclick="return confirm('Bạn có chắc muốn xóa sản phẩm này?');">
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
    <nav aria-label="Page navigation" class="d-flex justify-content-center mt-3">
        <ul class="pagination">
            <c:forEach var="i" begin="1" end="${SoTrang}">
                <li class="page-item ${i == currentPage ? 'active' : ''}">
                    <a class="page-link me-2" href="QuanLySanPham?page=${i}">${i}</a>
                </li>
            </c:forEach>
        </ul>
    </nav>
</body>
</html>