<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TRANG THANH TOÁN ONLINE</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js" integrity="sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container border rounded shadow p-4 mt-5">
		<form action="DatHangThanhCongController">
			<h3 style="color:red; margin-left: 30%">QUÉT MÃ SAU ĐỂ THANH TOÁN HÓA ĐƠN ${requestScope.maHoaDon }</h3>
			<img alt="MaQR" src="image/MaQR.png">
			<input type="hidden" name="maHoaDon" value="${requestScope.maHoaDon}" />
			<button type="submit" class="btn btn-danger">XÁC NHẬN ĐÃ QUÉT</button>
		</form>
	</div>
</body>
</html>