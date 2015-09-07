<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="CeppiApp" class="backend">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>CEPPI - backend</title>
        <meta name="author" content="Maldonado León">
        <meta name="description" content="Portal de administracion ceppi">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="<%=request.getContextPath() %>/public/image/touch/apple-touch-icon-144x144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="<%=request.getContextPath() %>/public/image/touch/apple-touch-icon-114x114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="<%=request.getContextPath() %>/public/image/touch/apple-touch-icon-72x72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="<%=request.getContextPath() %>/public/image/touch/apple-touch-icon-57x57-precomposed.png">
        <link rel="shortcut icon" href="<%=request.getContextPath() %>/public/image/favicon.ico">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/public/stylesheet/bootstrap.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/public/stylesheet/layout.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/public/stylesheet/uielement.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/public/stylesheet/themes/theme2.css">
        <link rel="stylesheet" href="<%=request.getContextPath() %>/public/plugins/nprogress/css/nprogress.css">
        <script type="text/javascript" src="<%=request.getContextPath() %>/public/plugins/modernizr/js/modernizr.js"></script>
    </head>
    
    <body ng-controller="MainController">
        
  		<jsp:include page="/private/pages/commons/header.jsp" />
  		<jsp:include page="/private/pages/commons/menu.jsp" />

        <section id="main" role="main" >
        	<div ng-view></div>
            <a href="javascript:void();" class="totop animation" data-toggle="waypoints totop" data-showanim="bounceIn" data-hideanim="bounceOut" data-offset="50%"><i class="ico-angle-up"></i></a>
        </section>
        <script type="text/javascript">
        	var CONSTANTS = 
        	{
        		contextPath : "<%=request.getContextPath() %>"
        	};
        </script>
        <script type="text/javascript" src="<%=request.getContextPath() %>/public/javascript/angular.min.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath() %>/public/javascript/angular-resource.min.js"></script>
    	<script type="text/javascript" src="<%=request.getContextPath() %>/public/javascript/angular-route.min.js"></script>
        <!-- Descomentar si ambiente tiene conexion a internet -->
        <!-- script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-resource.min.js"></script>
    	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-route.min.js"></script-->
        <script type="text/javascript" src="<%=request.getContextPath() %>/public/javascript/vendor.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath() %>/public/javascript/core.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath() %>/public/javascript/backend/app.js"></script>
        
        <script type="text/javascript" src="<%=request.getContextPath() %>/public/plugins/nprogress/js/nprogress.js"></script>
        
        <script type="text/javascript" src="<%=request.getContextPath() %>/private/js/ApplicationCeppi.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath() %>/private/js/UsuarioController.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath() %>/private/js/PerfilController.js"></script>
        
    </body>
    <!--/ END Body -->
</html>