<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="backend">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>CEPPI - backend</title>
        <meta name="author" content="Maldonado León">
        <meta name="description" content="Portal de administración ceppi">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%=request.getContextPath() %>/public/image/touch/apple-touch-icon-144x144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%=request.getContextPath() %>/public/image/touch/apple-touch-icon-114x114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%=request.getContextPath() %>/public/image/touch/apple-touch-icon-72x72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="<%=request.getContextPath() %>/public/image/touch/apple-touch-icon-57x57-precomposed.png">
        <link rel="shortcut icon" href="../image/favicon.ico">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/public/stylesheet/bootstrap.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/public/stylesheet/layout.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/public/stylesheet/uielement.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/public/plugins/nprogress/css/nprogress.css">
        <script type="text/javascript" src="<%=request.getContextPath() %>/public/plugins/modernizr/js/modernizr.js"></script>
    </head>
    <!--/ END Head -->

    <!-- START Body -->
    <body>
        <!-- START Template Main -->
        <section id="main" role="main">
            <!-- START Template Container -->
            <section class="container animation delay animating fadeInDown">
                <!-- START row -->
                <div class="row">
                    <div class="col-lg-6 col-lg-offset-3">
                        <div class="panel panel-minimal" style="margin-top:10%;">
                            <!-- Upper Text -->
                            <div class="panel-body text-center">
                                <i class="ico-file-remove2 longshadow fsize112 text-default"></i>
                            </div>
                            <div class="panel-body text-center">
                                <h1 class="semibold longshadow text-center text-default fsize32 mb10 mt0">WHOOPS!!</h1>
                                <h4 class="semibold text-primary text-center nm">La página que estas buscando no existe ...</h4>
                            </div>
                            <!--/ Upper Text -->

                            <!-- Button -->
                            <div class="panel-body text-center">
                                <a href="<%=request.getContextPath() %>" class="btn btn-default mb5">Ir al inicio</a>
                            </div>
                            <!--/ Button -->
                        </div>
                    </div>
                </div>
                <!--/ END row -->
            </section>
            <!--/ END Template Container -->
        </section>
        <!--/ END Template Main -->

        <!-- START JAVASCRIPT SECTION (Load javascripts at bottom to reduce load time) -->
        <script type="text/javascript" src="<%=request.getContextPath() %>/public/javascript/vendor.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath() %>/public/javascript/core.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath() %>/public/javascript/backend/app.js"></script>
        <!--/ END JAVASCRIPT SECTION -->
    </body>
    <!--/ END Body -->
</html>