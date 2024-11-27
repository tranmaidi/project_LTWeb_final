
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart</title>
        <link rel="icon" href="images/logo2.png" type="image/x-icon">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <body >
        <jsp:include page="Menu.jsp"></jsp:include>
            <div class="shopping-cart">
                <div class="px-4 px-lg-0">

                    <div class="pb-5">

                        <div class="container">
                            <div class="row" style="margin-top:35px">
                                <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

                                    <!-- Shopping cart table -->
                                    <div class="table-responsive">
                                        <table class="table table-hover table-striped text-center">
                                            <thead>
                                            <c:if test="${error!=null }">
                                            <div class="alert alert-danger" role="alert">
                                                ${error}
                                            </div>
                                        </c:if>
                                        <c:if test="${mess!=null }">
                                            <div class="alert alert-success" role="alert">
                                                ${mess}
                                            </div>
                                        </c:if>
                                        <tr>
                                            <th scope="col" class="border-0 bg-light">
                                                <div class="p-2 px-3 text-uppercase">Sản Phẩm</div>
                                            </th>
                                            <th scope="col" class="border-0 bg-light">
                                                <div class="py-2 text-uppercase">Đơn Giá</div>
                                            </th>
                                            <th scope="col" class="border-0 bg-light">
                                                <div class="py-2 text-uppercase">Màu Sắc</div>
                                            </th>
                                            
                                            <th scope="col" class="border-0 bg-light">
                                                <div class="py-2 text-uppercase">Kích Thước</div>
                                            </th>
                                            <th scope="col" class="border-0 bg-light">
                                                <div class="py-2 text-uppercase">Số Lượng</div>
                                            </th>
                                            <th scope="col" class="border-0 bg-light">
                                                <div class="py-2 text-uppercase">Xóa</div>
                                            </th>
                                        </tr>
                                        </thead>

                                        <tbody>
                                            <c:forEach items="${listCart}" var="o">
                                                <c:forEach items="${listProduct}" var="p">
                                                    <c:if test="${o.productID == p.id}">

                                                        <tr>
                                                            <th scope="row">
                                                                <div class="p-2">

                                                                    <img src="${p.image}" alt="" width="70" class="img-fluid rounded shadow-sm">

                                                                    <div class="ml-3 d-inline-block align-middle">
                                                                        <h5 class="mb-0"> <a href="#" class="text-dark d-inline-block">${p.name}</a></h5><span class="text-muted font-weight-normal font-italic"></span>
                                                                    </div>
                                                                </div>
                                                            </th>
                                                            <td class="align-middle"><strong>${p.price} VND</strong></td>
                                                            <td class="align-middle"><strong>${p.color}</strong></td>
                                                            
                                                            <td class="align-middle">
                                                                <strong>${o.size}</strong>
                                                            </td>

                                                            <td class="align-middle">
                                                                <a href="subAmountCart?productID=${o.productID}&amount=${o.amount}"><button class="btnSub">-</button></a> 
                                                                <strong>${o.amount}</strong>
                                                                <a href="addAmountCart?productID=${o.productID}&amount=${o.amount}"><button class="btnAdd">+</button></a>
                                                            </td>
                                                            <td class="align-middle"><a href="deleteCart?productID=${o.productID }" class="text-dark">
                                                                    <button type="button" class="btn btn-danger btn-sm">Xóa</button>
                                                                </a>
                                                            </td>
                                                        </tr>
                                                    
                                                </c:if>
                                            </c:forEach>
                                        </c:forEach>

                                        </tbody>

                                    </table>
                                </div>
                                <!-- End -->
                            </div>
                        </div>
                        
                        <div class="row py-5 p-4 bg-white rounded shadow-sm">
                            <div class="col-lg-6">
                                <a href="shop" class="btn btn-outline-primary rounded-pill py-2 btn-block">Tiếp Tục Mua Hàng</a><br>
                                <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thành tiền</div>

                                <div class="p-4">
                                    <ul class="list-unstyled mb-4" id="contentTotalMoney">
                                        <li class="d-flex justify-content-between py-3 border-bottom">
                                            <strong class="text-muted">Tổng tiền hàng</strong>
                                            <strong>${totalMoney} VND</strong>
                                        </li>
                                        <li class="d-flex justify-content-between py-3 border-bottom">
                                            <strong class="text-muted">Phí vận chuyển</strong>
                                            <strong>Free ship</strong>
                                        </li>
                                        <li class="d-flex justify-content-between py-3 border-bottom">
                                            <strong class="text-muted">VAT</strong>
                                            <strong>10%</strong>
                                        </li>
                                        <li class="d-flex justify-content-between py-3 border-bottom">
                                            <strong class="text-muted">Tổng thanh toán</strong>
                                            <h5 class="font-weight-bold">${totalMoneyVAT} VND</h5>
                                        </li>
                                    </ul>
                                    </ul>
                                    <a href="order" class="btn btn-dark rounded-pill py-2 btn-block text-white">Thanh Toán</a>
                                    
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </body>

</html>
</html>
