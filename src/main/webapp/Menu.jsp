<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--begin of menu-->
<nav class="navbar navbar-expand-md navbar-light bg-light" style="position: fixed; top: 0; width:100%; z-index: 100000;">
    <div class="container">
        <a class="" href="home">
            <img class="card-img-top" style="height:60px; width:120px; margin:0px; padding:0px" src="images/logo3.png" alt="Card image cap">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
            <ul class="navbar-nav m-auto">
                <li class="nav-item">
                    <a class="nav-link font-weight-bold" href="home">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link font-weight-bold" href="shop">Shop</a>
                </li>
            </ul>
            <form action="search" method="post" class="form-inline my-2 my-lg-0">
                <a class="btn-success btn-sm ml-3 m-auto" href="managerCart" style="transform: scale(1); transition: transform 0.2s ease; text-decoration: none;">
                    <i class="fa fa-shopping-cart"></i> 
                    <span style="font-size: 14px;">Cart</span>
                    <b><span id="amountCart" class="badge badge-light" style="color:black; font-size: 12px;"></span></b>
                </a>
            </form>
            <ul class="navbar-nav">
                <!-- Dropdown menu for logged-in user -->
                <c:if test="${sessionScope.acc != null}">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle font-weight-bold" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Hello ${sessionScope.acc.user}
                        </a>
                        <div class="dropdown-menu" aria-labelledby="userDropdown">
                            <a class="dropdown-item" href="editProfile">Edit Profile</a>
                            <c:if test="${sessionScope.acc.isAdmin == 1}">
                                <a class="dropdown-item" href="manager" target="_blank">Manager Product</a>
                                <a class="dropdown-item" href="admin" target="_blank">Statistic</a>
                            </c:if>
                            <a class="dropdown-item" href="logout">Logout</a>
                            <a class="dropdown-item" href="managerHistory">History</a>
                        </div>
                    </li>
                </c:if>
                <!-- Login link for guest user -->
                <c:if test="${sessionScope.acc == null}">
                    <li class="nav-item">
                        <a class="nav-link font-weight-bold" href="login"><i class="fas fa-user-circle fa-2x"></i></a>
                    </li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
