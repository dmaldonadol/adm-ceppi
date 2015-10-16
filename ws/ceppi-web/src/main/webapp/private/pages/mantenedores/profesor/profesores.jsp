<section id="main" role="main">
	<div class="container-fluid">
	    <div class="page-header page-header-block">
	        <div class="page-header-section">
	            <h4 class="title semibold">Profesores</h4>
	        </div>
	        <div class="page-header-section">
	            <div class="toolbar">
	                <ol class="breadcrumb breadcrumb-transparent nm">
	                    <li><a href="">Profesores</a></li>
	                    <li class="active">Equipos</li>
	                </ol>
	            </div>
	        </div>
	    </div>
	    
	    
	    <div class="row">
	        <div class="col-md-12">
	            <div class="panel panel-default" id="toolbar-showcase">
	                <div class="panel-heading">
	                    <h3 class="panel-title"><span class="panel-icon mr5"><i class="ico-equalizer"></i></span> Lista de Profesores</h3>
	                    <div class="panel-toolbar text-right">
	                        <div class="option">
	                            <button class="btn" ng-click="initialize()"><i class="reload"></i> </button>
	                            <button class="btn up" data-toggle="panelcollapse"><i class="arrow"></i></button>
	                        </div>
	                    </div>
	                </div>
	                <div class="panel-toolbar-wrapper pl0 pr0 pt5 pb5">	                    
	                    <div class="panel-toolbar text-right">
	                    	<div class="col-sm-8" ></div>
	                    	<div class="col-sm-4" >
	                        	<div class="panel-toolbar">
	                                <div class="input-group">
	                                    <div class="has-icon">
	                                        <input type="text" ng-model="q" placeholder="buscar" class="form-control" />
	                                        <i class="ico-search form-control-icon"></i>
	                                    </div>
	                                    <div class="input-group-btn">
	                                    	<a href="#/mantenedores/profesor/crear" class="btn btn-default">Nuevo</a>	                                        	                                       
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	
	                <div class="panel-collapse pull out">
	                    <table class="table table-bordered table-hover">
	                        <thead>
	                            <tr>
	                            	<th>RUT</th>
	                                <th>Nombre</th>
	                                <th>Tipo</th>
	                                <th width="10%">Opciones</th>
	                            </tr>
	                        </thead>
	                        <tbody>	                            
	                            <tr ng-repeat="p in profesores | filter:q as results">	                                                               
	                                    <td>{{p.persona.rut}}-{{p.persona.dv}}</td>
	                                    <td>{{p.persona.nombre}}&nbsp;{{p.persona.apellidoPaterno}}</td>
	                                    <td>{{p.tipo.nombre}}</td>
	                                    <td class="text-center">
	                                        <div class="toolbar">
	                                            <div class="btn-group">
	                                                <button type="button" class="btn btn-sm btn-default">Acción</button>
	                                                <button type="button" class="btn btn-sm btn-default dropdown-toggle" data-toggle="dropdown">
	                                                    <span class="caret"></span>
	                                                </button>
	                                                <ul class="dropdown-menu dropdown-menu-right">	                                                    
	                                                    <li><a href="#/mantenedores/profesor/editar/{{p.oid}}"><i class="icon ico-pencil"></i>Editar</a></li>
	                                                    <li class="divider"></li>
	                                                    <li><a href="javascript:void(0);" ng-click="eliminar(p)" class="text-danger"><i class="icon ico-remove3"></i>Eliminar</a></li>
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
	
