<section id="main" role="main">
    <div class="container-fluid">
        <div class="page-header page-header-block">
            <div class="page-header-section">
                <h4 class="title semibold">Ingresos</h4>
            </div>
            <div class="page-header-section">
                <div class="toolbar">
                    <ol class="breadcrumb breadcrumb-transparent nm">
                    	<li><a class="active">Otros Ingresos</a></li>
                    </ol>
                </div>
            </div>
        </div>
        
        <div class="row">
	        <div class="col-md-12">
	        
	    		<div class="panel panel-default" id="toolbar-showcase">
	    			
	    			<div class="panel-heading">
	                    <h3 class="panel-title"><span class="panel-icon mr5"><i class="ico-equalizer"></i></span> Otros ingresos</h3>
	                    <div class="panel-toolbar text-right">
	                        <div class="option">
	                            <button class="btn" ng-click="initialize()" ><i class="reload"></i></button>
	                            <button class="btn up" data-toggle="panelcollapse"><i class="arrow"></i></button>
	                        </div>
	                    </div>
	                </div>
	                <div class="panel-toolbar-wrapper pl10 pr0 pt5 pb5">	                    
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
	                                        <button type="button" class="btn btn-default" data-toggle="modal" data-target="#modal-create" ng-click="clearform();"><i class="ico-plus"></i></button>	                                        
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
	                                <th>Fecha</th>
	                                <th>Tipo Ingreso</th>
	                                <th>Socio</th>
	                                <th width="10%">Opciones</th>
	                            </tr>
	                        </thead>
	                        <tbody>	                            
	                            <tr ng-repeat="c in listaIngreso | filter:q as results">	                                                               
	                                    <td>{{c.fecha}}</td>
	                                    <td>{{c.tipoIngreso.nombre}}</td>
	                                    <td>{{c.socio.persona.nombre}}&nbsp;{{c.socio.persona.apellidoPaterno}}</td>
	                                    <td class="text-center">
	                                        <div class="toolbar">
	                                            <div class="btn-group">
	                                                <button type="button" class="btn btn-sm btn-default">Acci�n</button>
	                                                <button type="button" class="btn btn-sm btn-default dropdown-toggle" data-toggle="dropdown">
	                                                    <span class="caret"></span>
	                                                </button>
	                                                <ul class="dropdown-menu dropdown-menu-right">
	                                                    <li><a href="javascript:void(0);" ng-click="selecionVer( c )"><i class="icon ico-pencil"></i>Ver</a></li>
	                                                    <li class="divider"></li>
	                                                    <li><a href="javascript:void(0);" ng-click="eliminar( c )" class="text-danger"><i class="icon ico-remove3"></i>Eliminar</a></li>
	                                                </ul>
	                                            </div>
	                                        </div>
	                                    </td>
	                                </tr>
	                            </tbody>
	                        </table>
	                    </div>
	    		
	    			                
	                
              
	               <div class="panel-body panel-collapse pull out">
	               		<div class="row">
		        			<div class="col-md-6">
		        				
		        			</div>
		        		</div>
	               </div>   
                </div> 
	        </div>
 		</div>
 		
 		
 		<div id="modal-create" class="modal fade" aria-hidden="true">
			<div class="modal-dialog">
            	<div class="modal-content">
                	<div class="modal-header text-center">
                    	<button type="button" class="close" data-dismiss="modal">�</button>
                        <h3 class="semibold modal-title">Nuevo Ingreso</h3>
					</div>
                    <div class="modal-body">
               			<form class="form-horizontal form-bordered" id="form-create">
	        				
                               <div class="form-group">
                                   <div class="col-sm-3">
			        				<button class="btn btn-success mb5 mb5" data-toggle="modal" data-target="#modal-find" type="button" ng-click="obtenerSocios();">Buscar Socio &nbsp;<i class="ico-search"></i></button>
			        			</div>
			        			<div class="col-sm-9" ng-show="continuar">
                                       <label class="control-label">{{socio.persona.nombre}}&nbsp;{{socio.persona.apellidoPaterno}}</label>
                                   </div>
                               </div>
                               
                               <div ng-show="continuar">
                                
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Tipo Ingreso</label>
                                    <div class="col-sm-9">
                                        <select class="form-control" ng-model="ingreso.tipoIngreso"  ng-options="tipoIngresos.nombre for tipoIngresos in tipoIngresos"></select>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Fecha</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" ng-model="ingreso.fecha" placeholder="yyyy-mm-dd" 
                                        	id="fecha" data-parsley-error-message="Ingrese fecha" data-parsley-required=""/>
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Monto</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" ng-model="ingreso.monto" placeholder="Monto" 
                                        data-parsley-error-message="Por favor ingrese monto" data-parsley-required is-number maxlength="9">
                                    </div>
                                </div>
                                
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">Detalle</label>
                                    <div class="col-sm-9">
                                        <textarea class="form-control" ng-model="ingreso.detalle" maxlength="255"></textarea>
                                    </div>
                                </div>
                                
                                <div class="row" style="border-top:1px solid #e0e7e8;">
				        			<div class="col-md-12 text-right pt5 pb0">
				        				<button class="btn btn-success mb5 mb5"  value="button"  ng-click="guardar()">Guardar <i class="ico-save"></i></button>
				        			</div>
				        		</div>
                                
                               </div>
        				</form>
					</div>
				</div>
			</div>
		</div>
 		
    	
    	<div id="modal-find" class="modal fade" aria-hidden="true">
			<div class="modal-dialog">
            	<div class="modal-content">
                	<div class="modal-header text-center">
                    	<button type="button" class="close" data-dismiss="modal">�</button>
                        <h3 class="semibold modal-title">Buscar Socio</h3>
					</div>
                    <div class="modal-body">
            			<div class="panel panel-default" id="toolbar-showcase">
                			<div class="panel-heading">
                    			<h3 class="panel-title"><span class="panel-icon mr5"><i class="ico-equalizer"></i></span> Lista de Socios</h3>
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
                            			</tr>
                        			</thead>
                        			<tbody>	                            
                            			<tr ng-repeat="p in socios | filter:q as results" ng-click="selectSocio(p);">	                                                               
                                    		<td>{{p.persona.rut}}-{{p.persona.dv}}</td>
                                    		<td>{{p.persona.nombre}}&nbsp;{{p.persona.apellidoPaterno}}</td>
                                		</tr>
                            		</tbody>
                        		</table>
                    		</div>
                		</div>
					</div>
				</div>
			</div>
		</div>
		
		
		<div id="modal-view" class="modal fade" aria-hidden="true">
			<div class="modal-dialog">
            	<div class="modal-content">
                	<div class="modal-header text-center">
                    	<button type="button" class="close" data-dismiss="modal">�</button>
                        <h3 class="semibold modal-title">Detalle Ingreso</h3>
					</div>
                    <div class="modal-body">
               			<form class="form-horizontal form-bordered" id="form-create">
               				<div class="form-group">
                            	<label class="col-sm-3 control-label">Socio:</label>
                               	<div class="col-sm-9">
                               		<label class="control-label">{{objView.socio.persona.nombre}}&nbsp;{{objView.socio.persona.apellidoPaterno}}</label>
                              	</div>
							</div>
							
							<div class="form-group">
                            	<label class="col-sm-3 control-label">Tipo Ingreso:</label>
                                <div class="col-sm-9">
                                	<label class="control-label">{{objView.tipoIngreso.nombre}}</label>
                                </div>
							</div>
                                
							<div class="form-group">
                            	<label class="col-sm-3 control-label">Fecha:</label>
                                <div class="col-sm-9">
                                	<label class="control-label">{{objView.fecha}}</label>
                                </div>
							</div>
                                
							<div class="form-group">
                            	<label class="col-sm-3 control-label">Monto:</label>
                                <div class="col-sm-9">
                                	<label class="control-label">{{formatNumber(objView.monto)}}</label>
                                </div>
							</div>
                                
                            <div class="form-group">
                            	<label class="col-sm-3 control-label">Detalle:</label>
                                <div class="col-sm-9">
                                	<label class="control-label">{{objView.detalle}}</label>
                                </div>
							</div>
        				</form>
					</div>
				</div>
			</div>
		</div>
		
    </div>
</section>