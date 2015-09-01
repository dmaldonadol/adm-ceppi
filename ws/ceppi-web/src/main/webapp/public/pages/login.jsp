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
            <section class="container">
                <!-- START row -->
                <div class="row">
                    <div class="col-lg-4 col-lg-offset-4">
                        <!-- Brand -->
                        <div class="text-center" style="margin-bottom:40px;">
                            <span class="logo-figure inverse"></span>
                            <span class="logo-text inverse"></span>
                            <h5 class="semibold text-muted mt-5">Iniciar sesión con tu cuenta.</h5>
                        </div>
                        <!--/ Brand -->

                        <hr><!-- horizontal line -->

                        <!-- Login form -->
                        <form class="panel" name="form-login" action="">
                            <div class="panel-body">
                                <!-- Alert message -->
                                <div class="alert alert-info" id="info-login">
                                	Ingresa tus datos para acceder
                                </div>
                                 
                                 
                              
                                <div class="form-group">
                                    <div class="form-stack has-icon pull-left">
                                        <input name="username" type="text" class="form-control input-lg" 
                                        	placeholder="Nombre usuario" data-parsley-errors-container="#error-container" 
                                        	data-parsley-error-message="Por favor ingrese su Nombre de Usuario" data-parsley-required>
                                        <i class="ico-user2 form-control-icon"></i>
                                    </div>
                                    <div class="form-stack has-icon pull-left">
                                        <input name="password" type="password" 
                                        class="form-control input-lg" placeholder="Password" 
                                        data-parsley-errors-container="#error-container" 
                                        data-parsley-error-message="Por favor ingrese su password" data-parsley-required>
                                        <i class="ico-lock2 form-control-icon"></i>
                                    </div>
                                </div>

                                <!-- Error container -->
                                <div id="error-container"class="mb15"></div>
                                <!--/ Error container -->

                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-xs-6">
                                            <div class="checkbox custom-checkbox">  
                                                <input type="checkbox" name="remember" id="remember" value="1">  
                                                <label for="remember">&nbsp;&nbsp;Recordarme</label>   
                                            </div>
                                        </div>
                                        <div class="col-xs-6 text-right">
                                            
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group nm">
                                    <button type="submit" class="btn btn-block btn-success"><span class="semibold">Iniciar Sesión</span></button>
                                </div>
                            </div>
                        </form>
                        <!-- Login form -->
                        <hr><!-- horizontal line -->
                        
                    </div>
                </div>
            </section>
        </section>
        <script type="text/javascript">
        	var CONSTANTS = 
        	{
        		contextPath : "<%=request.getContextPath() %>"
        	};
        </script>
        
        <script type="text/javascript" src="<%=request.getContextPath() %>/public/javascript/vendor.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath() %>/public/javascript/core.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath() %>/public/javascript/backend/app.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath() %>/public/plugins/parsley/js/parsley.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath() %>/public/plugins/nprogress/js/nprogress.js"></script>
        <script type="text/javascript" src="<%=request.getContextPath() %>/public/javascript/backend/pages/login.js"></script>
        
        
        
        
        
    </body>
    <!--/ END Body -->
</html>