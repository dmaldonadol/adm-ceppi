<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="cl.ml.ceppi.core.model.usuario.Usuario" %>    
   
<% Usuario usuario = (Usuario)request.getSession().getAttribute("USER"); %>

    
    <header id="header" class="navbar">
            <div class="navbar-header">
                <a class="navbar-brand" href="javascript:void(0);">
                    <span class="logo-text" style="margin-top: 20px;"></span>
                </a>
            </div>

            <!-- START Toolbar -->
            <div class="navbar-toolbar clearfix">
                <!-- START Left nav -->
                <ul class="nav navbar-nav navbar-left">
                    <li class="hidden-xs hidden-sm">
                        <a href="javascript:void(0);" class="sidebar-minimize" data-toggle="minimize" title="Minimize sidebar">
                            <span class="meta">
                                <span class="icon"></span>
                            </span>
                        </a>
                    </li>

                    <li class="navbar-main hidden-lg hidden-md hidden-sm">
                        <a href="javascript:void(0);" data-toggle="sidebar" data-direction="ltr" rel="tooltip" title="Menu sidebar">
                            <span class="meta">
                                <span class="icon"><i class="ico-paragraph-justify3"></i></span>
                            </span>
                        </a>
                    </li>
                </ul>
                
                <div class="navbar-form navbar-left dropdown" id="dropdown-form">
                    <form action="" role="search">
                        <div class="has-icon">
                            <input type="text" class="form-control" placeholder="Search application...">
                            <i class="ico-search form-control-icon"></i>
                        </div>
                    </form>
                </div>

                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown profile">
                        <a href="javascript:void(0);" class="dropdown-toggle dropdown-hover" data-toggle="dropdown">
                            <span class="meta">
                                <span class="avatar"><img src="<%=request.getContextPath() %>/public/image/avatar/avatar.png" class="img-circle" alt="" /></span>
                                <span class="text hidden-xs hidden-sm pl5"><%=   usuario.getPersona().getNombre() + " " + usuario.getPersona().getApellidoPaterno()  %></span>
                                <span class="caret"></span>
                            </span>
                        </a>
                        <ul class="dropdown-menu" role="menu">
                            <li class="pa15">
                                <h5 class="semibold hidden-xs hidden-sm">
                                    <label class="text hidden-xs hidden-sm pl5">Perfil:&nbsp; <%= usuario.getPerfil().getNombre() %></label>
                                </h5>
                            </li>
                            <li class="divider"></li>
                            <li><a id="logout" href="<%=request.getContextPath() %>/logout"><span class="icon"><i class="ico-exit"></i></span> Salir</a></li>
                        </ul>
                    </li>
                </ul>
                <!--/ END Right nav -->
            </div>
            <!--/ END Toolbar -->
        </header>