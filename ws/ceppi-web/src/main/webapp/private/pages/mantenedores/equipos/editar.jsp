<section id="main" role="main">
    <div class="container-fluid">
    
    
    	<section class="jumbotron jumbotron-bg11 mt-15 mb15 mr-15 ml-15" data-stellar-background-ratio="0.4" style="min-height: 320px; background-position: 50% 30px;">
		    <div class="overlay pattern pattern10"></div>
		    <div class="container" style="padding-top:8%;">
		        <h1 class="thin text-white text-center font-alt">Create your application in an instant.</h1>
		        <h4 class="thin text-white text-center">Adminre is a clean and flat backend and frontend theme build with Twitter bootstrap</h4>
		        <div class="text-center pt15">
		            <a href="javascript:void(0);" class="btn btn-primary">Learn More <i class="ico-angle-right"></i></a>
		        </div>
		    </div>
		</section>
    
    
    
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
		        		<form class="form-horizontal form-bordered" id="form-crear-equipo">
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
		                  	
		                  <a href="javascript:void(0);" class="media border-dotted" ng-repeat="playeers in equipo.juagadores | filter:q as results">
		                      <span class="pull-left">
		                          <img src="<%=request.getContextPath() %>/public/image/avatar/avatar6.jpg" class="media-object" alt="">
		                      </span>
		                      <span class="media-body">
		                          <span class="media-heading">Arthur Abbott</span>
		                          <span class="media-text ellipsis nm">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod.</span>
		                          <!-- meta icon -->
		                          <span class="media-meta">2m</span>
		                          <!--/ meta icon -->
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
		                <form class="form-horizontal form-bordered" action="">
		                 <div class="form-group">
		                     <label class="col-sm-3 control-label">Rut</label>
		                     <div class="col-sm-5">
		                         <input type="text" class="form-control" ng-model="objUpdate.rut">
		                     </div>
		                     <div class="col-sm-2">
		                         <input type="text" class="form-control" ng-model="objUpdate.dv">
		                     </div>
		                 </div>
		                 <div class="form-group">
                             <label class="col-sm-3 control-label">Nombre</label>
                             <div class="col-sm-9">
                                 <input type="text" class="form-control" ng-model="usuario.persona.nombre" placeholder="Nombres"
                                 data-parsley-error-message="Por favor ingrese su nombre" data-parsley-required>
                             </div>
                         </div>
                         
                         <div class="form-group">
                             <label class="col-sm-3 control-label">Apellido <br> Paterno</label>
                             <div class="col-sm-9">
                                 <input type="text" class="form-control" ng-model="usuario.persona.apellidoPaterno" placeholder="Apellido Paterno"
                                 data-parsley-error-message="Por favor ingrese su apellido paterno" data-parsley-required>
                             </div>
                         </div>
                         
                         <div class="form-group">
                             <label class="col-sm-3 control-label">Apellido Materno</label>
                             <div class="col-sm-9">
                                 <input type="text" class="form-control" ng-model="usuario.persona.apellidoMaterno" placeholder="Apeliido Materno"
                                 data-parsley-error-message="Por favor ingrese su apellido Materno" data-parsley-required>
                             </div>
                         </div>
                         
                         <div class="form-group">
                             <label class="col-sm-3 control-label">Email</label>
                             <div class="col-sm-9">
                                 <input type="email" class="form-control" ng-model="usuario.persona.email" placeholder="ejemplo@mail.com"
                                 data-parsley-error-message="Por favor ingrese su email" data-parsley-required data-parsley-type="email">
                             </div>
                         </div>
                         
                         <div class="form-group">
                             <label class="col-sm-3 control-label">Género</label>
                             <div class="col-sm-9">
                                    <div class="btn-group">
                                     <button type="button" class="btn btn-default {{button.male}}"   ng-click="usuario.persona.genero='MASCULINO';button.male='btn-primary';button.female='';"  >Masculino</button>	                                            
                                     <button type="button" class="btn btn-default {{button.female}}" ng-click="usuario.persona.genero='FEMENINO';button.female='btn-primary';button.male='';">Femenino</button>
                                 </div>
                                </div>
                         </div>
		                </form>
		                
		            </div>
		            <div class="modal-footer">
		                <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
		                <button type="button" class="btn btn-primary" ng-click="agregarJugador();">Agregar</button>
		            </div>
		        </div><!-- /.modal-content -->
		    </div><!-- /.modal-dialog -->
		</div>
        
        
        
        
    </div>
</section>