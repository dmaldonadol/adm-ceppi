<section id="main" role="main">
	<div class="container-fluid">
	    <div class="page-header page-header-block">
	        <div class="page-header-section">
	            <h4 class="title semibold">Usuarios</h4>
	        </div>
	        <div class="page-header-section">
	            <div class="toolbar">
	                <ol class="breadcrumb breadcrumb-transparent nm">
	                    <li><a href="">Usuarios</a></li>
	                    <li class="active">Administración</li>
	                </ol>
	            </div>
	        </div>
	    </div>
	    
	    
	    <div class="row">
	        <div class="col-md-12">
	            <div class="panel panel-default" id="toolbar-showcase">
	                <div class="panel-heading">
	                    <h3 class="panel-title"><span class="panel-icon mr5"><i class="ico-equalizer"></i></span> Usuarios</h3>
	                    <div class="panel-toolbar text-right">
	                        <div class="option">
	                            <button class="btn up" data-toggle="panelcollapse"><i class="arrow"></i></button>
	                            <button class="btn" data-toggle="panelremove" data-parent=".col-md-12"><i class="remove"></i></button>
	                        </div>
	                    </div>
	                </div>
	                <div class="panel-toolbar-wrapper pl10 pr10 pt5 pb5">
	                    <div class="panel-toolbar hide" id="toolbar-toshow">
	                        <button type="button" class="btn btn-sm btn-danger"><i class="ico-remove3"></i></button>
	                        <div class="btn-group">
	                            <button type="button" class="btn btn-sm btn-default">Action</button>
	                            <button type="button" class="btn btn-sm btn-default dropdown-toggle" data-toggle="dropdown">
	                                <span class="caret"></span>
	                            </button>
	                            <ul class="dropdown-menu">
	                                <li><a href="javascript:void(0);"><i class="icon ico-pencil"></i>Update</a></li>
	                                <li><a href="javascript:void(0);"><i class="icon ico-print3"></i>Print</a></li>
	                                <li class="divider"></li>
	                                <li><a href="javascript:void(0);" class="text-danger"><i class="icon ico-remove3"></i>Delete</a></li>
	                            </ul>
	                        </div>
	                    </div>
	                    <div class="panel-toolbar text-right">
	                        <div class="btn-group">
	                            <button type="button" class="btn btn-sm btn-default"><i class="ico-upload22"></i></button>
	                            <button type="button" class="btn btn-sm btn-default"><i class="ico-archive2"></i></button>
	                        </div>
	                    </div>
	                </div>
	
	                <div class="panel-collapse pull out">
	                    <table class="table table-bordered table-hover">
	                        <thead>
	                            <tr>
	                                <th width="3%" class="text-center">
	                                    <div class="checkbox custom-checkbox pull-left" data-toggle="tooltip" data-placement="right" title="" data-original-title="Check all">  
	                                        <input type="checkbox" id="customcheckbox-two0" value="1" data-toggle="checkall" data-target="#toolbar-showcase">  
	                                        <label for="customcheckbox-two0"></label>  
	                                    </div>
	                                </th>
	                                <th width="5%"></th>
	                                <th>Nombre</th>
	                                <th>Edad</th>
	                                <th>Email</th>
	                                <th width="10%">Opciones</th>
	                            </tr>
	                        </thead>
	                        <tbody>
	                            <tr class="success" >
	                                <td>
	                                    <div class="checkbox custom-checkbox nm">  
	                                        <input type="checkbox" id="customcheckbox-two1" value="1" data-toggle="selectrow" data-target="tr" data-contextual="info">  
	                                        <label for="customcheckbox-two1"></label>   
	                                    </div>
	                                </td>
	                                <td><div class="media-object"><img src="<%=request.getContextPath() %>/public/image/avatar/avatar.png" alt="" class="img-circle"></div>
	                                </td>
	                                <td>Short, Cheyenne E.</td>
	                                <td>Bangladesh</td>
	                                <td>quis.diam@gravida.net</td>
	                                <td class="text-center">
	                                    <div class="toolbar">
	                                        <div class="btn-group">
	                                            <button type="button" class="btn btn-sm btn-default">Action</button>
	                                            <button type="button" class="btn btn-sm btn-default dropdown-toggle" data-toggle="dropdown">
	                                                <span class="caret"></span>
	                                            </button>
	                                            <ul class="dropdown-menu dropdown-menu-right">
	                                                <li><a href="javascript:void(0);"><i class="icon ico-pencil"></i>Update</a></li>
	                                                <li><a href="javascript:void(0);"><i class="icon ico-print3"></i>Print</a></li>
	                                                <li class="divider"></li>
	                                                <li><a href="javascript:void(0);" class="text-danger"><i class="icon ico-remove3"></i>Delete</a></li>
	                                            </ul>
	                                        </div>
	                                    </div>
	                                </td>
	                            </tr>
	                            <tr>
	                                <td>
	                                    <div class="checkbox custom-checkbox nm">  
	                                        <input type="checkbox" id="customcheckbox-two2" value="1" data-toggle="selectrow" data-target="tr" data-contextual="info">  
	                                        <label for="customcheckbox-two2"></label>   
	                                    </div>
	                                </td>
	                                <td><div class="media-object"><img src="<%=request.getContextPath() %>/public/image/avatar/avatar.png" alt="" class="img-circle"></div></td>
	                                    <td>Acosta, Isaiah V.</td>
	                                    <td>Turkmenistan</td>
	                                    <td>ac.mattis@Maecenas.ca</td>
	                                    <td class="text-center">
	                                        <div class="toolbar">
	                                            <div class="btn-group">
	                                                <button type="button" class="btn btn-sm btn-default">Action</button>
	                                                <button type="button" class="btn btn-sm btn-default dropdown-toggle" data-toggle="dropdown">
	                                                    <span class="caret"></span>
	                                                </button>
	                                                <ul class="dropdown-menu dropdown-menu-right">
	                                                    <li><a href="javascript:void(0);"><i class="icon ico-pencil"></i>Update</a></li>
	                                                    <li><a href="javascript:void(0);"><i class="icon ico-print3"></i>Print</a></li>
	                                                    <li class="divider"></li>
	                                                    <li><a href="javascript:void(0);" class="text-danger"><i class="icon ico-remove3"></i>Delete</a></li>
	                                                </ul>
	                                            </div>
	                                        </div>
	                                    </td>
	                                </tr>
	                            </tbody>
	                        </table>
	                    </div>
	                </div>
	            </div>
	        </div>
	        
	    </div>
	    
	    <a href="#" class="totop animation" data-toggle="waypoints totop" data-showanim="bounceIn" data-hideanim="bounceOut" data-offset="50%"><i class="ico-angle-up"></i></a>
	</section>
	
