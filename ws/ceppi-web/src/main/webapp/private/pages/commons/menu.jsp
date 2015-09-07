<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<aside class="sidebar sidebar-left sidebar-menu">
    <!-- START Sidebar Content -->
    <section class="content slimscroll">	
	<h5 class="heading">Main Menu</h5>
    <ul class="topmenu topmenu-responsive" data-toggle="menu">
    
    
    	<li >
            <a href="javascript:void(0);" data-target="#dashboard" data-toggle="submenu" data-parent=".topmenu">
                <span class="figure"><i class="ico-dashboard2"></i></span>
                <span class="text">Administración</span>
                <span class="arrow"></span>
            </a>
            <ul id="dashboard" class="submenu collapse ">
                <li class="submenu-header ellipsis">Administración</li>
                <li >
                    <a href="inicio#/administracion/usuarios"><span class="text">Usuarios</span></a>
                </li>
                <li >
                    <a href="inicio#/administracion/perfiles"><span class="text">Perfiles</span></a>
                </li>
            </ul>
        </li>
        
        <li >
            <a href="javascript:void(0);" data-target="#teams" data-toggle="submenu" data-parent=".topmenu">
                <span class="figure"><i class="ico-dashboard2"></i></span>
                <span class="text">Equipos</span>
                <span class="arrow"></span>
            </a>
            <ul id="teams" class="submenu collapse ">
                <li class="submenu-header ellipsis">Equipos</li>
                <li >
                    <a href="inicio#/mantenedores/equipos"><span class="text">Equipos</span></a>
                </li>
                <li >
                    <a href="inicio#/mantenedores/jugadores"><span class="text">Jugadores</span></a>
                </li>
            </ul>
        </li>
            
        <li>
            <a href="javascript:void(0);" data-target="#components" data-toggle="submenu" data-parent=".topmenu">
                <span class="figure"><i class="ico-screwdriver"></i></span>
                <span class="text">Mantenedores</span>
                <span class="arrow"></span>
            </a>
            <ul id="components" class="submenu collapse ">
                <li class="submenu-header ellipsis">Mantenedores</li>
                <li >
                    <a href="inicio#/mantenedor/categoria"><span class="text">Categoria Socio</span></a>
                </li>
                <li >
                    <a href="inicio#/mantenedor/centrocosto"><span class="text">Centro Costo</span></a>
                </li>
                <li >
                    <a href="inicio#/mantenedor/profesion"><span class="text">Profesi&oacute;n</span></a>
                </li>
                <li >
                    <a href="inicio#/mantenedor/tipogasto"><span class="text">Tipo Gasto</span></a>
                </li>
                <li >
                    <a href="inicio#/mantenedor/tipoingreso"><span class="text">Tipo Ingreso</span></a>
                </li>
                <li >
                    <a href="inicio#/mantenedor/tiposocio"><span class="text">Tipo Socio</span></a>
                </li>
            </ul>
        </li>
    
		<li >
		    <a href="javascript:void(0);" data-toggle="submenu" data-target="#form" data-parent=".topmenu">
		        <span class="figure"><i class="ico-quill2"></i></span>
		        <span class="text">Ingresos</span>
		        <span class="arrow"></span>
		    </a>
		    <ul id="form" class="submenu collapse ">
		        <li class="submenu-header ellipsis">Registro</li>
		        <li >
		            <a href="#"> <span class="text">Cuotas</span> </a>
		        </li>
		        <li >
		            <a href="#"> <span class="text">Otros Ingresos</span> </a>
		        </li>
		        <li >
		            <a href="#"> <span class="text">Gastos</span> </a>
		        </li>
		    </ul>
		</li>
		
		<li >
	        <a href="javascript:void(0);" data-toggle="submenu" data-target="#chart" data-parent=".topmenu">
	            <span class="figure"><i class="ico-stats-up"></i></span>
	            <span class="text">Reportes</span>
	            <span class="arrow"></span>
	        </a>
	        <ul id="chart" class="submenu collapse ">
	            <li class="submenu-header ellipsis">Reportes</li>
	            <li >
	                <a href="#"> <span class="text">Reporte 1</span> </a>
	            </li>
	            <li >
	                <a href="#"> <span class="text">Reporte 2</span> </a>
	            </li>
	            <li >
	                <a href="#"> <span class="text">Reporte 3</span> </a>
	            </li>
	        </ul>
	    </li>
<!--                     <li > -->
<!--                         <a href="javascript:void(0);" data-toggle="submenu" data-target="#table" data-parent=".topmenu"> -->
<!--                             <span class="figure"><i class="ico-table22"></i></span> -->
<!--                             <span class="text">Tables</span> -->
<!--                             <span class="arrow"></span> -->
<!--                         </a> -->
<!--                         START 2nd Level Menu -->
<!--                         <ul id="table" class="submenu collapse "> -->
<!--                             <li class="submenu-header ellipsis">Tables</li> -->
<!--                             <li > -->
<!--                                 <a href="table-default.html"> -->
<!--                                     <span class="text">Default</span> -->
<!--                                 </a> -->
<!--                             </li> -->
<!--                             <li> -->
<!--                                 <a href="table-datatable.html"> -->
<!--                                     <span class="text">Datatable</span> -->
<!--                                 </a> -->
<!--                             </li> -->
<!--                         </ul> -->
<!--                         / END 2nd Level Menu -->
<!--                     </li> -->
<!--                     <li > -->
<!--                         <a href="javascript:void(0);" data-toggle="submenu" data-target="#page" data-parent=".topmenu"> -->
<!--                             <span class="figure"><i class="ico-file6"></i></span> -->
<!--                             <span class="text">Pages</span> -->
<!--                             <span class="arrow"></span> -->
<!--                         </a> -->
<!--                         START 2nd Level Menu -->
<!--                         <ul id="page" class="submenu collapse "> -->
<!--                             <li class="submenu-header ellipsis">Pages</li> -->
<!--                             <li > -->
<!--                                 <a href="page-task.html"> -->
<!--                                     <span class="text">Task</span> -->
<!--                                     <span class="number"><span class="label label-success">N</span></span> -->
<!--                                 </a> -->
<!--                             </li> -->
<!--                             <li > -->
<!--                                 <a href="page-starter.html"> -->
<!--                                     <span class="text">Blank / starter</span> -->
<!--                                 </a> -->
<!--                             </li> -->
<!--                             <li > -->
<!--                                 <a href="page-calendar.html"> -->
<!--                                     <span class="text">Calendar</span> -->
<!--                                 </a> -->
<!--                             </li> -->
<!--                             <li > -->
<!--                                 <a href="page-profile.html"> -->
<!--                                     <span class="text">Profile</span> -->
<!--                                 </a> -->
<!--                             </li> -->
<!--                             <li > -->
<!--                                 <a href="page-login.html"> -->
<!--                                     <span class="text">Login</span> -->
<!--                                 </a> -->
<!--                             </li> -->
<!--                             <li > -->
<!--                                 <a href="page-login-returned.html"> -->
<!--                                     <span class="text">Returned login</span> -->
<!--                                 </a> -->
<!--                             </li> -->
<!--                             <li > -->
<!--                                 <a href="page-register.html"> -->
<!--                                     <span class="text">Register</span> -->
<!--                                 </a> -->
<!--                             </li> -->
<!--                             <li > -->
<!--                                 <a href="page-people-directory-v1.html"> -->
<!--                                     <span class="text">People directory v1</span> -->
<!--                                 </a> -->
<!--                             </li> -->
<!--                             <li > -->
<!--                                 <a href="page-invoice.html"> -->
<!--                                     <span class="text">Invoice</span> -->
<!--                                 </a> -->
<!--                             </li> -->
<!--                             <li > -->
<!--                                 <a href="page-faq.html"> -->
<!--                                     <span class="text">FAQ</span> -->
<!--                                 </a> -->
<!--                             </li> -->
<!--                             <li > -->
<!--                                 <a href="javascript:void(0);" data-toggle="submenu" data-target="#timeline" data-parent="#page"> -->
<!--                                     <span class="text">Timeline</span> -->
<!--                                     <span class="arrow"></span> -->
<!--                                 </a> -->
<!--                                 START 2nd Level Menu -->
<!--                                 <ul id="timeline" class="submenu collapse "> -->
<!--                                     <li > -->
<!--                                         <a href="page-timeline-v1.html"><span class="text">Version 1</span></a> -->
<!--                                     </li> -->
<!--                                     <li > -->
<!--                                         <a href="page-timeline-v2.html"><span class="text">Version 2</span></a> -->
<!--                                     </li> -->
<!--                                 </ul> -->
<!--                                 / END 2nd Level Menu -->
<!--                             </li> -->
<!--                             <li > -->
<!--                                 <a href="javascript:void(0);" data-toggle="submenu" data-target="#error" data-parent="#page"> -->
<!--                                     <span class="text">Error</span> -->
<!--                                     <span class="arrow"></span> -->
<!--                                 </a> -->
<!--                                 START 2nd Level Menu -->
<!--                                 <ul id="error" class="submenu collapse "> -->
<!--                                     <li > -->
<!--                                         <a href="page-error-404.html"><span class="text">Not Found (404)</span></a> -->
<!--                                     </li> -->
<!--                                     <li > -->
<!--                                         <a href="page-error-403.html"><span class="text">Forbidden (403)</span></a> -->
<!--                                     </li> -->
<!--                                     <li > -->
<!--                                         <a href="page-error-500.html"><span class="text">Server Error (500)</span></a> -->
<!--                                     </li> -->
<!--                                 </ul> -->
<!--                                 / END 2nd Level Menu -->
<!--                             </li> -->
<!--                             <li > -->
<!--                                 <a href="javascript:void(0);" data-toggle="submenu" data-target="#media" data-parent="#page"> -->
<!--                                     <span class="text">Media</span> -->
<!--                                     <span class="arrow"></span> -->
<!--                                 </a> -->
<!--                                 START 2nd Level Menu -->
<!--                                 <ul id="media" class="submenu collapse "> -->
<!--                                     <li > -->
<!--                                         <a href="page-media-album.html"><span class="text">Media album</span></a> -->
<!--                                     </li> -->
<!--                                     <li > -->
<!--                                         <a href="page-media-gallery.html"><span class="text">Media gallery</span></a> -->
<!--                                     </li> -->
<!--                                 </ul> -->
<!--                                 / END 2nd Level Menu -->
<!--                             </li> -->
<!--                             <li > -->
<!--                                 <a href="javascript:void(0);" data-toggle="submenu" data-target="#message" data-parent="#page"> -->
<!--                                     <span class="text">Message</span> -->
<!--                                     <span class="arrow"></span> -->
<!--                                 </a> -->
<!--                                 START 2nd Level Menu -->
<!--                                 <ul id="message" class="submenu collapse "> -->
<!--                                     <li > -->
<!--                                         <a href="page-message-bubble.html"><span class="text">Bubble message</span></a> -->
<!--                                     </li> -->
<!--                                     <li > -->
<!--                                         <a href="page-message-rich.html"><span class="text">Rich message</span></a> -->
<!--                                     </li> -->
<!--                                 </ul> -->
<!--                                 / END 2nd Level Menu -->
<!--                             </li> -->
<!--                             <li > -->
<!--                                 <a href="javascript:void(0);" data-toggle="submenu" data-target="#email" data-parent="#page"> -->
<!--                                     <span class="text">Email</span> -->
<!--                                     <span class="arrow"></span> -->
<!--                                 </a> -->
<!--                                 START 2nd Level Menu -->
<!--                                 <ul id="email" class="submenu collapse "> -->
<!--                                     <li > -->
<!--                                         <a href="page-email-inbox.html"><span class="text">Inbox</span></a> -->
<!--                                     </li> -->
<!--                                     <li > -->
<!--                                         <a href="page-email-view.html"><span class="text">View</span></a> -->
<!--                                     </li> -->
<!--                                 </ul> -->
<!--                                 / END 2nd Level Menu -->
<!--                             </li> -->
<!--                             <li > -->
<!--                                 <a href="javascript:void(0);" data-toggle="submenu" data-target="#blog" data-parent="#page"> -->
<!--                                     <span class="text">Blog page</span> -->
<!--                                     <span class="arrow"></span> -->
<!--                                 </a> -->
<!--                                 START 2nd Level Menu -->
<!--                                 <ul id="blog" class="submenu collapse "> -->
<!--                                     <li > -->
<!--                                         <a href="page-blog-default.html"><span class="text">Blog default</span></a> -->
<!--                                     </li> -->
<!--                                     <li > -->
<!--                                         <a href="page-blog-grid.html"><span class="text">Blog grid</span></a> -->
<!--                                     </li> -->
<!--                                     <li > -->
<!--                                         <a href="page-blog-single.html"><span class="text">Single post</span></a> -->
<!--                                     </li> -->
<!--                                 </ul> -->
<!--                                 / END 2nd Level Menu -->
<!--                             </li> -->
<!--                         </ul> -->
<!--                         / END 2nd Level Menu -->
<!--                     </li> -->
                    
<!--                     <li > -->
<!--                         <a href="javascript:void(0);" data-toggle="submenu" data-target="#maps" data-parent=".topmenu"> -->
<!--                             <span class="figure"> -->
<!--                                 <i class="ico-map3"></i> -->
<!--                             </span> -->
<!--                             <span class="text">Maps</span> -->
<!--                             <span class="arrow"></span> -->
<!--                         </a> -->
<!--                         START 2nd Level Menu -->
<!--                         <ul id="maps" class="submenu collapse "> -->
<!--                             <li class="submenu-header ellipsis">Maps</li> -->
<!--                             <li > -->
<!--                                 <a href="maps-vector.html"> -->
<!--                                     <span class="text">Vector</span> -->
<!--                                     <span class="number"><span class="label label-info">U</span></span> -->
<!--                                 </a> -->
<!--                             </li> -->
<!--                             <li > -->
<!--                                 <a href="maps-google.html"> -->
<!--                                     <span class="text">Google</span> -->
<!--                                 </a> -->
<!--                             </li> -->
<!--                         </ul> -->
<!--                         / END 2nd Level Menu -->
<!--                     </li> -->
<!--                     <li > -->
<!--                         <a href="javascript:void(0);" data-toggle="submenu" data-target="#layout" data-parent=".topmenu"> -->
<!--                             <span class="figure"><i class="ico-grid"></i></span> -->
<!--                             <span class="text">Page Layout</span> -->
<!--                             <span class="arrow"></span> -->
<!--                         </a> -->
<!--                         START 2nd Level Menu -->
<!--                         <ul id="layout" class="submenu collapse "> -->
<!--                             <li class="submenu-header ellipsis">Page Layout</li> -->
<!--                             <li > -->
<!--                                 <a href="layout-default.html"> -->
<!--                                     <span class="text">Default</span> -->
<!--                                 </a> -->
<!--                             </li> -->
<!--                             <li > -->
<!--                                 <a href="layout-with-footer.html"> -->
<!--                                     <span class="text">With footer</span> -->
<!--                                     <span class="number"><span class="label label-success">N</span></span> -->
<!--                                 </a> -->
<!--                             </li> -->
<!--                             <li > -->
<!--                                 <a href="layout-reveal-header.html"> -->
<!--                                     <span class="text">Reveal header</span> -->
<!--                                     <span class="number"><span class="label label-success">N</span></span> -->
<!--                                 </a> -->
<!--                             </li> -->
<!--                             <li > -->
<!--                                 <a href="layout-fixed-header.html"> -->
<!--                                     <span class="text">Fixed header</span> -->
<!--                                 </a> -->
<!--                             </li> -->
<!--                             <li > -->
<!--                                 <a href="layout-fixed-sidebar.html"> -->
<!--                                     <span class="text">Fixed sidebar</span> -->
<!--                                 </a> -->
<!--                             </li> -->
<!--                             <li > -->
<!--                                 <a href="layout-navbar-collapse.html"> -->
<!--                                     <span class="text">Navbar Collapse</span> -->
<!--                                 </a> -->
<!--                             </li> -->
<!--                         </ul> -->
<!--                         / END 2nd Level Menu -->
<!--                     </li> -->
<!--                     <li class="active open"> -->
<!--                         <a href="javascript:void(0);" data-toggle="submenu" data-target="#theme" data-parent=".topmenu"> -->
<!--                             <span class="figure"><i class="ico-droplet3"></i></span> -->
<!--                             <span class="text">Themes</span> -->
<!--                             <span class="arrow"></span> -->
<!--                         </a> -->
<!--                         START 2nd Level Menu -->
<!--                         <ul id="theme" class="submenu collapse in"> -->
<!--                             <li class="submenu-header ellipsis">Themes</li> -->
<!--                             <li > -->
<!--                                 <a href="theme-1.html"> -->
<!--                                     <span class="text">Theme 1</span> -->
<!--                                     <span class="number"><span class="label label-success">N</span></span> -->
<!--                                 </a> -->
<!--                             </li> -->
<!--                             <li class="active"> -->
<!--                                 <a href="theme-2.html"> -->
<!--                                     <span class="text">Theme 2</span> -->
<!--                                     <span class="number"><span class="label label-success">N</span></span> -->
<!--                                 </a> -->
<!--                             </li> -->
<!--                             <li > -->
<!--                                 <a href="theme-3.html"> -->
<!--                                     <span class="text">Theme 3</span> -->
<!--                                     <span class="number"><span class="label label-success">N</span></span> -->
<!--                                 </a> -->
<!--                             </li> -->
<!--                             <li > -->
<!--                                 <a href="theme-4.html"> -->
<!--                                     <span class="text">Theme 4</span> -->
<!--                                     <span class="number"><span class="label label-success">N</span></span> -->
<!--                                 </a> -->
<!--                             </li> -->
<!--                         </ul> -->
<!--                         / END 2nd Level Menu -->
<!--                     </li> -->
<!--                 </ul> -->
                
                
                <h5 class="heading">Summary</h5>
                <div class="wrapper">
                    <div class="table-layout">
                        <div class="col-xs-5 valign-middle">
                            <span class="sidebar-sparklines" sparkType="bar" sparkBarColor="#00B1E1">1,5,3,2,4,5,3,3,2,4,5,3</span>
                        </div>
                        <div class="col-xs-7 valign-middle">
                            <h5 class="semibold nm">Server uptime</h5>
                            <small class="semibold">1876 days</small>
                        </div>
                    </div>

                    <div class="table-layout">
                        <div class="col-xs-5 valign-middle">
                            <span class="sidebar-sparklines" sparkType="bar" sparkBarColor="#91C854">2,5,3,6,4,2,4,7,8,9,7,6</span>
                        </div>
                        <div class="col-xs-7 valign-middle">
                            <h5 class="semibold nm">Disk usage</h5>
                            <small class="semibold">83.1%</small>
                        </div>
                    </div>

                    <div class="table-layout">
                        <div class="col-xs-5 valign-middle">
                            <span class="sidebar-sparklines" sparkType="bar" sparkBarColor="#ED5466">5,1,3,7,4,3,7,8,6,5,3,2</span>
                        </div>
                        <div class="col-xs-7 valign-middle">
                            <h5 class="semibold nm">Daily visitors</h5>
                            <small class="semibold">56.5%</small>
                        </div>
                    </div>
                </div>
            </section>
        </aside>