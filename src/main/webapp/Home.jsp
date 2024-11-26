<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link rel="icon" href="images/logo2.png" type="image/x-icon">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!------ Include the above in your HEAD tag ------>
        <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/> 
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css" />
        <!-- Google Fonts Roboto -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" /> 
        <!-- MDB -->
        <link rel="stylesheet" href="css/mdb.min.css" />
        Custom styles 
        <link rel="stylesheet" href="css/style.css" />
        <link href="css/login.css" rel="stylesheet" type="text/css"/>
        <!-- Roboto Font -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700&display=swap"> 
        Font Awesome
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
        Bootstrap core CSS
        <link rel="stylesheet" href="https://mdbootstrap.com/previews/ecommerce-demo/css/bootstrap.min.css">
        Material Design Bootstrap
        <link rel="stylesheet" href="https://mdbootstrap.com/previews/ecommerce-demo/css/mdb-pro.min.css">
        Material Design Bootstrap Ecommerce
        <link rel="stylesheet" href="https://mdbootstrap.com/previews/ecommerce-demo/css/mdb.ecommerce.min.css"> 
        <!-- Your custom styles (optional) -->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"> 

        <style>
            /* Carousel styling */
            #introCarousel,
            .carousel-inner,
            .carousel-item,
            .carousel-item.active {
                height: 90vh;
            }

            .carousel-item:nth-child(1) {
                background-image: url('https://img2.dilyno.com/jQPPl2ZzTYNpxS_pZd2GKQbFcD-asEDxyG1lNPUH-Bk/rs:fill:1920:0:0/aHR0cHM6Ly9zMy1kaWx5LXdlYi5kaWx5bm8uY29tL3dlYmVjb20vMjAyNC8xMS85YmJjYjZhMGQ2ZWY1MGY5MWZmYzZhNGE0NGFkZmVhOS5wbmc.webp');
                background-repeat: no-repeat;
                background-size: 100% 100%;
                background-position: center center;
            }

            .carousel-item:nth-child(2) {
                background-image: url('https://img.mwc.com.vn/giay-thoi-trang?w=1920&h=0&FileInput=/Resources/Silde/2024/11/04/z5981481292145_6ef08c59d7f600522fd5b511651ba286.jpg');
                background-repeat: no-repeat;
                background-size: 100% 100%;
                background-position: center center;
            }

            .carousel-item:nth-child(3) {
                background-image: url('https://www.vascara.com/uploads/web/900/landing-page/Collection-soiree-glamour/TOP-BANNER1-1-2x.png');
                background-repeat: no-repeat;
                background-size: 100% 100%;
                background-position: center center;
            }

            /* Height for devices larger than 576px */
            @media (min-width: 992px) {
                #introCarousel {
                    margin-top: -58.59px;
                }
            }

            .navbar .nav-link {
                color: #000 !important;

            }
            


        </style>

    </head>
    <body class="skin-light" onload="loadAmountCart()">
        <jsp:include page="Menu.jsp"></jsp:include>
            <!-- Carousel wrapper -->
            <div id="introCarousel" class="carousel slide carousel-fade shadow-2-strong" data-mdb-ride="carousel" style="margin-top:35px;">
                <!-- Indicators -->
                
                <ol class="carousel-indicators">
                    <li data-mdb-target="#introCarousel" data-mdb-slide-to="0" class="active"></li>
                    <li data-mdb-target="#introCarousel" data-mdb-slide-to="1"></li>
                    <li data-mdb-target="#introCarousel" data-mdb-slide-to="2"></li>
                </ol>
                
                <!-- Inner -->
                <div class="carousel-inner">
                    <!-- Single item -->
                    <div class="carousel-item active">

                    </div>

                    <!-- Single item -->
                    <div class="carousel-item">
                       
                    </div>

                    <!-- Single item -->
                    <div class="carousel-item">

                    </div>
                     
                </div>
                <!-- Inner -->

                <!-- Controls -->
                <a class="carousel-control-prev" href="#introCarousel" role="button" data-mdb-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#introCarousel" role="button" data-mdb-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
                
            </div>
            
            <!-- Carousel wrapper -->

            <div class="card-group" style="margin-top:10px;">
                <div class="card" style="border-style: none; height:160px; background-image: url('https://file.hstatic.net/1000373795/article/he_ban_chua_biet_toi_hang_giay_cao_got_viet_nam_chat_luong_cao_nay__8__76a99c352a534cc8809f59f966a1a11f_master.png'); background-size: 100% 100%;">
<!--                    <img class="card-img-top" style="height:55px; width:100px; margin: auto;" src="images/money.png" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title" style="text-align:center">THANH TOÁN KHI NHẬN HÀNG</h5>
                        <p class="card-text" style="text-align:center">Nhận hàng tại nhà rồi thanh toán</p>
                    </div>-->
                    <div class="">
                                
    
                                <div class="mb-0 text-right">
                                    <a href="shop" class="btn btn-modern btn-md btn-dark">
                                        Buy NOW!
                                    </a>
                                </div>
                            </div>
                </div>
                <div class="card" style="border-style: none; height:160px; background-image: url('https://portotheme.com/html/porto_ecommerce/assets/images/demoes/demo6/banners/banner-2.jpg'); background-size: 100% 100%;">
<!--                    <img style="height:55px; width:64px; margin: auto;" src="images/truck.png">
                    <div class="card-body">
                        <h5 class="card-title" style="text-align:center">GIAO HÀNG TOÀN QUỐC</h5>
                        <p class="card-text" style="text-align:center">Vận chuyển khắp Việt Nam</p>
                    </div>-->
                    <div class="">
                                <h2 class="ls-n-20 m-b-2 text-right text-primary">FLASH SALE</h2>
                                <h3 class="ls-n-20 m-b-2 text-right">TOP GIÀY<br>SIÊU SALE</h3>
                                <div class="mb-0 text-right">
                                    <a href="shop" class="btn btn-modern btn-md btn-light">
                                        View Sale
                                    </a>
                                </div>
                            </div>
                </div>
                <div class="card" style="border-style: none; height:160px; background-image: url('https://portotheme.com/html/porto_ecommerce/assets/images/demoes/demo6/banners/banner-3.jpg'); background-size: 100% 100%;">
<!--                    <img class="card-img-top" style="height:55px; width:64px; margin: auto;" src="images/tool.png" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title" style="text-align:center">BẢO HÀNH DÀI HẠN</h5>
                        <p class="card-text" style="text-align:center">Bảo hàng lên đến 60 ngày</p>
                    </div>-->
                    <div class="">
                                <h2 class="m-b-1 font3 text-left">BẢO HÀNH DÀI HẠN</h2>
                                <h3 class="m-b-3 text-left">60 NGÀY</h3>
                                <div class="vc_btn3-container mb-0 vc_btn3-inline">
                                    <a href="shop" class="btn btn-modern btn-md btn-dark ls-10">
                                        Get Yours!
                                    </a>
                                </div>
                            </div>
                </div>
                <div class="card" style="border-style: none; height:160px;background-image: url('https://portotheme.com/html/porto_ecommerce/assets/images/demoes/demo6/banners/banner-4.jpg'); background-size: 100% 100%;">
<!--                    <img class="card-img-top" style="height:55px; width:64px; margin: auto;" src="images/exch.png" alt="Card image cap">
                    <div class="card-body">
                        <h5 class="card-title" style="text-align:center">ĐỔI HÀNG DỄ DÀNG</h5>
                        <p class="card-text" style="text-align:center">Đổi hàng thoải mái trong 20 ngày</p>
                    </div>-->
                    <div class="row align-items-center" style="margin-top:52px">
                                <div class="col-7">
                                    <h3 class="m-b-1 text-right">DEAL PROMOS</h3>
                                    <h4 class="mb-0 text-right ls-10">STARTING AT 333VND</h4>
                                </div>
                                <div class="col-5">
                                    <div class="mb-0">
                                        <a href="shop" class="btn btn-modern btn-md btn-dark">
                                            Shop Now
                                        </a>
                                    </div>
                                </div>
                            </div>
                </div>
            </div>


            <div class="container">

                <div class="row" style="margin-top:30px">
                    <div class="display-header d-flex align-items-center justify-content-between" >
                        <h2 id="moiNhat" class="section-title text-uppercase mb-0" style="color:#FF0000;">MỚI NHẤT</h2>
                        <a href="shop" class="btn-right text-uppercase text-hover fw-bold">View all</a>
                    </div>
                    <div class="col-sm-12" style="margin-top:30px">
                        <div id="contentMoiNhat" class="row">
                        <c:forEach items="${list8Last}" var="o">
                            <div class=" col-12 col-md-6 col-lg-3">
                                <div class="card">
                                    <div class="view zoom z-depth-2 rounded">
                                        <a href="detail?pid=${o.id}" title="View Product">
                                            <img class="img-fluid w-100" src="${o.image}" alt="Card image cap">
                                        </a>
                                    </div>
                                    <div class="card-body">
                                        <h4 class="card-title show_txt"><a href="detail?pid=${o.id}" title="View Product">${o.name}</a></h4>
                                        <p class="card-text show_txt">${o.title}</p>
                                        <div class="row">
                                            <div class="col">
                                                <p class="btn btn-info btn-block">${o.price}VND</p>
                                            </div> 
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>

                </div>

            </div>
            <div class="row" style="margin-top:25px">
                <div class="display-header d-flex align-items-center justify-content-between" >
                    <h2 id="gotvuong" class="section-title text-uppercase mb-0" style="color:#FF0000;">CAO GÓT GÓT VUÔNG</h2>
                    <a href="shop" class="btn-right text-uppercase text-hover fw-bold">View all</a>
                </div>
                <div class="col-sm-12" style="margin-top:25px">
                    <div id="contentNike" class="row">
                        <c:forEach items="${list4NikeLast}" var="o">
                            <div class="productNike col-12 col-md-6 col-lg-3">
                                <div class="card">
                                    <div class="view zoom z-depth-2 rounded">
                                        <a href="detail?pid=${o.id}" title="View Product">
                                            <img class="img-fluid w-100" src="${o.image}" alt="Card image cap">
                                        </a>                                      
                                    </div>
                                    <div class="card-body">
                                        <h4 class="card-title show_txt"><a href="detail?pid=${o.id}" title="View Product">${o.name}</a></h4>
                                        <p class="card-text show_txt">${o.title}</p>
                                        <div class="row">
                                            <div class="col">
                                                <p class="btn btn-info btn-block">${o.price}VND</p>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <button onclick="loadMoreNike()" class="btn btn-outline-danger mx-auto d-block">Xem thêm</button>
                </div>
            </div>


            <div class="row" style="margin-top:25px">
                <div class="display-header d-flex align-items-center justify-content-between" >
                    <h2 id="gotnhon" class="section-title text-uppercase mb-0" style="color:#FF0000;">CAO GÓT GÓT NHỌN</h2>
                    <a href="shop" class="btn-right text-uppercase text-hover fw-bold">View all</a>
                </div>
                <div class="col-sm-12" style="margin-top:25px">
                    <div id="contentAdidas" class="row">
                        <c:forEach items="${list4AdidasLast}" var="o">
                            <div class="productAdidas col-12 col-md-6 col-lg-3">
                                <div class="card">
                                    <div class="view zoom z-depth-2 rounded">
                                        <a href="detail?pid=${o.id}" title="View Product">
                                            <img class="img-fluid w-100" src="${o.image}" alt="Card image cap">
                                        </a>
                                    </div>
                                    <div class="card-body">
                                        <h4 class="card-title show_txt"><a href="detail?pid=${o.id}" title="View Product">${o.name}</a></h4>
                                        <p class="card-text show_txt">${o.title}</p>
                                        <div class="row">
                                            <div class="col">
                                                <p class="btn btn-info btn-block">${o.price}VND</p>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <button onclick="loadMoreAdidas()" class="btn btn-outline-danger mx-auto d-block">Xem thêm</button>
                </div>
            </div>

            <div class="row" style="margin-top:25px">
                <div class="display-header d-flex align-items-center justify-content-between" >
                    <h2 id="hogot" class="section-title text-uppercase mb-0" style="color:#FF0000;">CAO GÓT HỞ GÓT</h2>
                    <a href="shop" class="btn-right text-uppercase text-hover fw-bold">View all</a>
                </div>
                <div class="col-sm-12" style="margin-top:25px">
                    <div id="contentHogot" class="row">
                        <c:forEach items="${list4hogotLast}" var="o">
                            <div class="productHogot col-12 col-md-6 col-lg-3">
                                <div class="card">
                                    <div class="view zoom z-depth-2 rounded">
                                        <a href="detail?pid=${o.id}" title="View Product">
                                            <img class="img-fluid w-100" src="${o.image}" alt="Card image cap">
                                        </a>                                      
                                    </div>
                                    <div class="card-body">
                                        <h4 class="card-title show_txt"><a href="detail?pid=${o.id}" title="View Product">${o.name}</a></h4>
                                        <p class="card-text show_txt">${o.title}</p>
                                        <div class="row">
                                            <div class="col">
                                                <p class="btn btn-info btn-block">${o.price}VND</p>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                    <button onclick="loadMoreHogot()" class="btn btn-outline-danger mx-auto d-block">Xem thêm</button>
                </div>
            </div>

            <div class="row" style="margin-top:50px">            
                <div class="col-sm-12">
                    <div id="content" class="row">

                        <div class=" col-12 col-md-12 col-lg-6" style="margin-top:150px">
                            <img class="card-img-top" src="https://pendecor.vn/uploads/files/2022/08/10/thiet-ke-shop-tui-xach-1.jpg" alt="Card image cap">        
                        </div>
                        <div class=" col-12 col-md-12 col-lg-6">
                            <div class="card-body">
                                <h4 class="card-title show_txt" style="text-align:center; font-size:18pt; color:#b57b00;">Hãy trải nghiệm</h4>
                                <h2 class="card-title show_txt" style="text-align:center; font-size:24pt;">DINNO shop</h2>
                                <p style="text-align:center;">Chào các chị em phụ nữ xinh đẹp!</p>
                                <p>DINNO Shop tự hào mang đến cho bạn bộ sưu tập giày cao gót chính hãng, được thiết kế đặc biệt dành cho những người phụ nữ hiện đại, tự tin và luôn muốn tỏa sáng. Tại DINNO, chúng tôi hiểu rằng mỗi đôi giày không chỉ là một món phụ kiện, mà còn là biểu tượng của phong cách và cá tính riêng.</p>       
                                <p>Với những kiểu dáng sang trọng, từ thanh lịch đến phá cách, cùng màu sắc đa dạng, mỗi đôi giày đều được chăm chút kỹ lưỡng, sử dụng nguyên liệu cao cấp để mang lại sự thoải mái tối đa cho đôi chân bạn. Chúng tôi cam kết giúp bạn không chỉ nâng chiều cao mà còn tôn vinh vẻ đẹp và sự tự tin của bạn trong từng bước đi.</p>
                                <p>Hãy để DINNO Shop đồng hành cùng bạn trong mọi sự kiện, từ những buổi tiệc sang trọng đến những ngày làm việc bận rộn. Ghé thăm chúng tôi ngay hôm nay để khám phá bộ sưu tập đầy ấn tượng và tìm kiếm đôi giày hoàn hảo cho riêng mình! Tỏa sáng và khẳng định phong cách của bạn với DINNO!</p>
                            </div>  
                        </div>
                    </div>
                </div>
            </div>

        </div>     
        <jsp:include page="Footer.jsp"></jsp:include>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>

                        function loadMore() {
                            var amount = document.getElementsByClassName("product").length;
                            $.ajax({
                                url: "/WebsiteBanGiay/load",
                                type: "get", //send it through get method
                                data: {
                                    exits: amount
                                },
                                success: function (data) {
                                    var row = document.getElementById("content");
                                    row.innerHTML += data;
                                },
                                error: function (xhr) {
                                    //Do Something to handle error
                                }
                            });
                        }
                        function loadMoreNike() {
                            var amountNike = document.getElementsByClassName("productNike").length;
                            $.ajax({
                                url: "/WebsiteBanGiay/loadNike",
                                type: "get", //send it through get method
                                data: {
                                    exitsNike: amountNike
                                },
                                success: function (dataNike) {
                                    document.getElementById("contentNike").innerHTML += dataNike;

                                },
                                error: function (xhr) {
                                    //Do Something to handle error
                                }
                            });
                        }
                        function loadMoreAdidas() {
                            var amountAdidas = document.getElementsByClassName("productAdidas").length;
                            $.ajax({
                                url: "/WebsiteBanGiay/loadAdidas",
                                type: "get", //send it through get method
                                data: {
                                    exitsAdidas: amountAdidas
                                },
                                success: function (dataAdidas) {
                                    document.getElementById("contentAdidas").innerHTML += dataAdidas;

                                },
                                error: function (xhr) {
                                    //Do Something to handle error
                                }
                            });
                        }
                        function loadMoreHogot() {
                            var amountHogot = document.getElementsByClassName("productHogot").length;
                            $.ajax({
                                url: "/WebsiteBanGiay/loadHogot",
                                type: "get", //send it through get method
                                data: {
                                    exitsHogot: amountHogot
                                },
                                success: function (dataHogot) {
                                    document.getElementById("contentHogot").innerHTML += dataHogot;

                                },
                                error: function (xhr) {
                                    //Do Something to handle error
                                }
                            });
                        }
                        function searchByName(param) {
                            var txtSearch = param.value;
                            $.ajax({
                                url: "/WebsiteBanGiay/searchAjax",
                                type: "get", //send it through get method
                                data: {
                                    txt: txtSearch
                                },
                                success: function (data) {
                                    var row = document.getElementById("content");
                                    row.innerHTML = data;
                                },
                                error: function (xhr) {
                                    //Do Something to handle error
                                }
                            });
                        }
                        function load(cateid) {
                            $.ajax({
                                url: "/WebsiteBanGiay/category",
                                type: "get", //send it through get method
                                data: {
                                    cid: cateid
                                },
                                success: function (responseData) {
                                    document.getElementById("content").innerHTML = responseData;
                                }
                            });
                        }
                        function loadAmountCart() {
                            $.ajax({
                                url: "/WebsiteBanGiay/loadAllAmountCart",
                                type: "get", //send it through get method
                                data: {

                                },
                                success: function (responseData) {
                                    document.getElementById("amountCart").innerHTML = responseData;
                                }
                            });
                        }
        </script>  


        <!-- MDB -->
        <script type="text/javascript" src="js/mdb.min.js"></script>
        <!-- Custom scripts -->
        <script type="text/javascript" src="js/script.js"></script>

        <!-- SCRIPTS -->
        <!-- JQuery -->
        <script src="https://mdbootstrap.com/previews/ecommerce-demo/js/jquery-3.4.1.min.js"></script>
        <!-- Bootstrap tooltips -->
        <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/popper.min.js"></script>
        <!-- Bootstrap core JavaScript -->
        <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/bootstrap.js"></script>
        <!-- MDB core JavaScript -->
        <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.min.js"></script>
        <!-- MDB Ecommerce JavaScript -->
        <script type="text/javascript" src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.ecommerce.min.js"></script>
    </body>
</html>

