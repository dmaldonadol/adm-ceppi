<section id="main" role="main">
    <div class="container-fluid">
    
        <div class="page-header page-header-block">
            <div class="page-header-section">
                <h4 class="title semibold">Editar Equipo</h4>
            </div>
            <div class="page-header-section">
                <div class="toolbar">
                    <ol class="breadcrumb breadcrumb-transparent nm">
                        <li><a href="inicio#/">Ceppi</a></li>
                        <li><a href="inicio#/mantenedores/equipos">Equipos</a></li>
                        <li class="active">Editar Equipo</li>
                    </ol>
                </div>
            </div>
        </div>
        
        <div class="row" >
        	<div class="col-md-6">
        	
        		<div class="panel panel-default" id="toolbar-showcase">
	                <div class="panel-heading">
	                    <h3 class="panel-title"><span class="panel-icon mr5"><i class="ico-list22"></i></span> Información</h3>
	                </div>
	               <div class="panel-body panel-collapse pull out" style="padding-top:0px;">
		        		<form class="form-horizontal form-bordered" id="form-editar-equipo">
		        		<div class="form-group">
		                    <label class="col-sm-3 control-label">Nombre</label>
		                    <div class="col-sm-9">
		                        <input type="text" class="form-control" ng-model="equipo.nombre"
		                        data-parsley-errors-container="#error-container" data-parsley-error-message="ingrese el nombre del equipo" data-parsley-required>
		                    </div>
		                </div>
		                
		                <div class="form-group">
		                    <label class="col-sm-3 control-label">Descripción</label>
		                    <div class="col-sm-9">
		                        <textarea class="form-control" ng-model="equipo.descripcion"
		                        data-parsley-errors-container="#error-container" data-parsley-error-message="ingrese una descripción" data-parsley-required></textarea>
		                    </div>
		                </div>
		                
		                <div class="form-group">
		                    <label class="col-sm-3 control-label">Año Limite</label>
		                    <div class="col-sm-9">
		                        <input type="text" class="form-control" ng-model="equipo.anioLimite"
		                        data-parsley-errors-container="#error-container" data-parsley-error-message="ingrese el Año limite del equipo" data-parsley-required>
		                    </div>
		                </div>
		                
		                <div class="form-group">
		                    <label class="col-sm-3 control-label">Género</label>
		                    <div class="col-sm-9">
		                           <div class="btn-group">
		                            <button type="button" class="btn btn-default {{button.male}}"   ng-click="equipo.genero='MASCULINO';button.male='btn-primary';button.female='';"  >Masculino</button>	                                            
		                            <button type="button" class="btn btn-default {{button.female}}" ng-click="equipo.genero='FEMENINO';button.female='btn-primary';button.male='';">Femenino</button>
		                        </div>
		                       </div>
		                </div>
		                	<div class="form-group">
		                		<div class="col-md-12 text-right pt5 pb0">
			        				<a href="#/mantenedores/equipos/{{equipo.oid}}" class="btn btn-default">Cancelar</a>
			        				<button class="btn btn-success"  value="button"  ng-click="actualizar()">Guardar</button>
			        			</div>
		                	</div>
		                </form>
	                </div>
                </div>
        	
        	</div>
 	       	<div class="col-md-6">
	 	       	<div class="panel panel-default" id="toolbar-showcase">
	                <div class="panel-heading">
	                    <h3 class="panel-title"><span class="panel-icon mr5"><i class="ico-list22"></i></span> Jugadores</h3>
	                    <div class="panel-toolbar text-right">                            
                        	<button type="button" data-toggle="modal" data-target="#modal-add" class="btn btn-sm btn-default">Agregar <i class="ico-plus"></i></button>                                                         
                        </div>
	                </div>
	               <div class="panel-body panel-collapse pull out" style="padding:0px;">
		        		<div class="media-list">
		        			<a href="javascript:void(0);" class="media border-dotted" ng-show="equipo.juagadores.length==0">		                      
		                      <span class="media-body">
		                          <span class="media-text ellipsis nm">No se han asignado jugadores al equipo.</span>		                          
		                      </span>
		                  	</a>
		                  	
		                  <a href="#/mantenedores/jugadores/editar/{{player.oid}}" class="media border-dotted" ng-repeat="player in equipo.juagadores | filter:q as results">
		                      <span class="pull-left">
		                          <img src="<%=request.getContextPath() %>/public/image/avatar/avatar.png" class="media-object" alt="">
		                      </span>
		                      <span class="media-body">
		                          <span class="media-heading">{{player.persona.nombre}} {{player.persona.apellidoPaterno}} {{player.persona.apellidoMaterno}}</span>
		                          <span class="media-text ellipsis nm">{{player.posicion}}</span>
		                          <span class="media-meta">{{player.numero}}</span>
		                      </span>
		                  </a>
		              </div>
					</div>
	      		</div>
	      		
	      		
	      		
	      		
	      		<div class="panel panel-default" id="toolbar-showcase">
	                <div class="panel-heading">
	                    <h3 class="panel-title"><span class="panel-icon mr5"><i class="ico-list22"></i></span> Staff Técnico</h3>
	                    <div class="panel-toolbar text-right">                            
                        	<button type="button" data-toggle="modal" data-target="#modal-add-staff" class="btn btn-sm btn-default">Agregar <i class="ico-plus"></i></button>                                                         
                        </div>
	                </div>
	               <div class="panel-body panel-collapse pull out" style="padding:0px;">
		        		<div class="media-list">
		        			<a href="javascript:void(0);" class="media border-dotted" ng-show="equipo.profesores.length==0">		                      
		                      <span class="media-body">
		                          <span class="media-text ellipsis nm">No se ha asignado staff al equipo.</span>		                          
		                      </span>
		                  	</a>
		                  	
		                  <a href="#/mantenedores/jugadores/editar/{{player.oid}}" class="media border-dotted" ng-repeat="staff in equipo.profesores | filter:q as results">
		                      <span class="pull-left">
		                          <img src="<%=request.getContextPath() %>/public/image/avatar/avatar.png" class="media-object" alt="">
		                      </span>
		                      <span class="media-body">
		                          <span class="media-heading">{{staff.persona.nombre}} {{staff.persona.apellidoPaterno}} {{staff.persona.apellidoMaterno}}</span>
		                          <span class="media-text ellipsis nm">{{staff.tipoProfesor.nombre}}</span>
		                      </span>
		                  </a>
		              </div>
					</div>
	      		</div>

        	</div>
        </div>
        
        
        
        
		<div id="modal-add" class="modal fade" aria-hidden="true" style="display: none;">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header text-center">
		                <button type="button" class="close" data-dismiss="modal">×</button>
		                <h3 class="semibold modal-title">Agregar Jugador</h3>
		            </div>
		            <div class="modal-body">
		            
		            	<div class="input-group">
                             <div class="has-icon">
                                 <input type="text" ng-model="qj" placeholder="buscar" class="form-control" />
                                 <i class="ico-search form-control-icon"></i>
                             </div>
                             <div class="input-group-btn">
                             	<a href="#/mantenedores/jugadores/nuevo" class="btn btn-default">Nuevo</a>	                                        	                                       
                             </div>
                         </div>
		            	
		            	<table class="table table-bordered table-hover">
	                        <thead>
	                            <tr>
	                            	<th>Rut</th>
	                                <th>Nombre</th>
	                                <th>Posición</th>
	                            </tr>
	                        </thead>
	                        <tbody style="background:white;" >	                            
	                            <tr ng-repeat="jugador in jugadores | filter:qj as results" ng-click="seleccionarJugador( jugador )" ng-class="{'success' : jugador.selected}">
	                            	<td>{{jugador.persona.rut}}-{{jugador.persona.dv}}</td>
                                    <td>{{jugador.persona.nombre}} {{jugador.persona.apellidoPaterno}}</td>
                                    <td>{{jugador.posicion}}</td>
	                            </tr>
                            </tbody>
                         </table>    
		            </div>
		            <div class="modal-footer">
		                <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
		            </div>
		        </div>
		    </div>
		</div>
		
		
		
		
		
		<div id="modal-add-staff" class="modal fade" aria-hidden="true" style="display: none;">
		    <div class="modal-dialog">
		        <div class="modal-content">
		            <div class="modal-header text-center">
		                <button type="button" class="close" data-dismiss="modal">×</button>
		                <h3 class="semibold modal-title">Agregar Jugador</h3>
		            </div>
		            <div class="modal-body">
		            
		            	<div class="input-group">
                             <div class="has-icon">
                                 <input type="text" ng-model="qj" placeholder="buscar" class="form-control" />
                                 <i class="ico-search form-control-icon"></i>
                             </div>
                             <div class="input-group-btn">
                             	<a href="#/mantenedores/jugadores/nuevo" class="btn btn-default">Nuevo</a>	                                        	                                       
                             </div>
                         </div>
                         <hr/>
		            	
		            	<table class="table table-bordered table-hover">
	                        <thead>
	                            <tr>
	                            	<th>Rut</th>
	                                <th>Nombre</th>
	                                <th>Tipo</th>
	                            </tr>
	                        </thead>
	                        <tbody style="background:white;" >	                            
	                            <tr ng-repeat="s in staff | filter:qj as results" ng-click="seleccionarStaff( s )" ng-class="{'success' : s.selected}">
	                            	<td>{{s.persona.rut}}-{{s.persona.dv}}</td>
                                    <td>{{s.persona.nombre}} {{s.persona.apellidoPaterno}}</td>
                                    <td>{{s.tipoProfesor.nombre}}</td>
	                            </tr>
                            </tbody>
                         </table>    
		            </div>
		            <div class="modal-footer">
		                <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
		            </div>
		        </div>
		    </div>
		</div>
        
        
        
        
    </div>
</section>