<section id="main" role="main">
    <div class="container-fluid">
        <div class="page-header page-header-block">
            <div class="page-header-section">
                <h4 class="title semibold">Jugadores</h4>
            </div>
            <div class="page-header-section">
                <div class="toolbar">
                    <ol class="breadcrumb breadcrumb-transparent nm">
	                    <li><a href="">Jugadores</a></li>
	                    <li class="active">Administración</li>
	                </ol>
                </div>
            </div>
        </div>
        
        <!-- div class="row shuffle" style="position: relative; overflow: hidden; height: 1015px; transition: height 250ms ease-out;">
        
        	<div class="col-sm-6 col-md-4 shuffle shuffle-item filtered" style="position: absolute; top: 0px; left: 0px; visibility: visible; transition: transform 250ms ease-out, opacity 250ms ease-out;">
                        
                        <div class="panel widget" ng-repeat="jugador in jugadores">
                            <div class="table-layout nm"  >
                                <div class="col-xs-4 text-center"><img src="<%=request.getContextPath() %>/public/image/avatar/avatar.png" width="100%"></div>
                                <div class="col-xs-8 valign-middle">
                                    <div class="panel-body">
                                        <h5 class="semibold mt0 mb5"><a href="javascript:void(0);">{{jugador.persona.nombre}} {{jugador.persona.apellidoPaterno}} {{jugador.persona.apellidoMaterno}}</a></h5>
                                        <p class="ellipsis text-muted mb5"><i class="ico-envelop mr5"></i> Posición <b> {{jugador.posicion}}</b></p>
                                        <p class="text-muted nm"><i class="ico-location2 mr5"></i> Numero camiseta <b>{{jugador.numero}}</b></p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
        
        </div-->
        
        
        <div class="row">
	        <div class="col-md-12">
	            <div class="panel panel-default" id="toolbar-showcase">
	                <div class="panel-heading">
	                    <h3 class="panel-title"><span class="panel-icon mr5"><i class="ico-equalizer"></i></span> Lista de Jugadores</h3>
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
	                                    	<a href="inicio#/mantenedores/jugadores/nuevo" class="btn btn-default">Nuevo</a>	                                        	                                       
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
	                            	<th>Rut</th>
	                                <th>Nombre</th>
	                                <th>Posición</th>
	                                <th>Estatura</th>
	                                <th>Peso</th>
	                                <th width="10%">Opciones</th>
	                            </tr>
	                        </thead>
	                        <tbody>	                            
	                            <tr ng-repeat="jugador in jugadores | filter:q as results">	                                                               
	                                    <td>{{jugador.persona.rut}}-{{jugador.persona.dv}}</td>
	                                    <td>{{jugador.persona.nombre}} {{jugador.persona.apellidoPaterno}}</td>
	                                    <td>{{jugador.posicion}}</td>
	                                    <td>{{jugador.estatura}}m</td>
	                                    <td>{{jugador.peso}}kg</td>
	                                    <td class="text-center">
	                                        <div class="toolbar">
	                                            <div class="btn-group">
	                                                <button type="button" class="btn btn-sm btn-default">Acción</button>
	                                                <button type="button" class="btn btn-sm btn-default dropdown-toggle" data-toggle="dropdown">
	                                                    <span class="caret"></span>
	                                                </button>
	                                                <ul class="dropdown-menu dropdown-menu-right">	                                                    
	                                                    <li><a href="#/mantenedores/jugadores/editar/{{jugador.oid}}"><i class="icon ico-pencil"></i>Editar</a></li>
	                                                    <li class="divider"></li>
	                                                    <li><a href="javascript:void(0);" ng-click="eliminar(jugador)" class="text-danger"><i class="icon ico-remove3"></i>Eliminar</a></li>
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
</section>