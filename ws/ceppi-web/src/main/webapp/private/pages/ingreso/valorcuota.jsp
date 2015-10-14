<section id="main" role="main">
    <div class="container-fluid">
        <div class="page-header page-header-block">
            <div class="page-header-section">
                <h4 class="title semibold">Valor Cuota</h4>
            </div>
            <div class="page-header-section">
                <div class="toolbar">
                    <ol class="breadcrumb breadcrumb-transparent nm">
                        <li class="active">Valor Cuota</li>
                    </ol>
                </div>
            </div>
        </div>
        
        
        <div class="row">
	        <div class="col-md-12">
	            <div class="panel panel-default" id="toolbar-showcase">
	                <div class="panel-heading">
	                    <h3 class="panel-title"><span class="panel-icon mr5"><i class="ico-equalizer"></i></span> Valor Cuota</h3>
	                    <div class="panel-toolbar text-right">
	                        <div class="option">
	                        	<button class="btn" ng-click="initialize()" ><i class="reload"></i> </button>
	                            <button class="btn up" data-toggle="panelcollapse"><i class="arrow"></i></button>
	                        </div>
	                    </div>
	                </div>
	                <div class="panel-toolbar-wrapper pl10 pr0 pt5 pb5">	                    
	                    <div class="panel-toolbar text-right">
	                    	<div class="col-sm-8" >
	                    	</div>
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
	                                <th>Tipo Socio</th>
	                                <th>Categoria Socio</th>
	                                <th>Valor Cuota</th>
	                                <th width="10%">Opciones</th>
	                            </tr>
	                        </thead>
	                        <tbody>	                            
	                            <tr ng-repeat="c in listaValorCuota | filter:q as results">	                                                               
	                                    <td>{{c.tipoSocio.nombre}}</td>
	                                    <td>{{c.categoriaSocio.nombre}}</td>
	                                    <td>{{c.valor}}</td>
	                                    <td class="text-center">
	                                        <div class="toolbar">
	                                            <div class="btn-group">
	                                                <button type="button" class="btn btn-sm btn-default">Acción</button>
	                                                <button type="button" class="btn btn-sm btn-default dropdown-toggle" data-toggle="dropdown">
	                                                    <span class="caret"></span>
	                                                </button>
	                                                <ul class="dropdown-menu dropdown-menu-right">
	                                                    <li><a href="javascript:void(0);" ng-click="selecionActualizar( c )"><i class="icon ico-pencil"></i>Editar</a></li>
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
	                </div>
	            </div>
	        </div>
        
        	<div id="modal-create" class="modal fade" aria-hidden="true" style="display: none;">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header text-center">
                            <button type="button" class="close" data-dismiss="modal">×</button>
                            <h3 class="semibold modal-title">Nueva Valor Cuota</h3>
                        </div>
                        <div class="modal-body">
                            <form class="form-horizontal form-bordered" action="">
	                            <div class="form-group">
	                                <label class="col-sm-3 control-label">Tipo Socio</label>
                                    <div class="col-sm-9">
                                        <select class="form-control" ng-model="valorcuota.tipoSocio"  ng-options="tipoSocios.nombre for tipoSocios in tipoSocios"></select>
                                    </div>
	                            </div>
	                            <div class="form-group">
	                                <label class="col-sm-3 control-label">Categoria Socio</label>
                                    <div class="col-sm-9">
                                        <select class="form-control" ng-model="valorcuota.categoriaSocio"  ng-options="categoriaSocios.nombre for categoriaSocios in categoriaSocios"></select>
                                    </div>
	                            </div>
	                            <div class="form-group">
	                            	<label class="col-sm-3 control-label">Valor</label>
	                            	<div class="col-sm-9">
	                            		<input type="text" class="form-control" ng-model="valorcuota.valor" placeholder="Monto" 
                                    		data-parsley-error-message="Por favor ingrese valor cuota" data-parsley-required is-number maxlength="6">
	                            	</div>
                                </div>
                                <div class="form-group" ng-show="ismensaje">
			        				<label class="col-sm-8 control-label parsley-custom-error-message">{{mensaje}}</label>
			        			</div>
                            </form>
                            
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                            <button type="button" class="btn btn-primary" ng-click="nuevo();">Guardar</button>
                        </div>
                    </div>
                </div>
            </div>
            
            
            
            <div id="modal-update" class="modal fade" aria-hidden="true" style="display: none;">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header text-center">
                            <button type="button" class="close" data-dismiss="modal">×</button>
                            <h3 class="semibold modal-title">Editar Valor Cuota</h3>
                        </div>
                        <div class="modal-body">
                            <form class="form-horizontal form-bordered" action="">
	                            <div class="form-group">
	                                <label class="col-sm-3 control-label">Tipo Socio</label>
                                    <div class="col-sm-9">
                                        <input type="text" class="form-control" ng-model="objUpdate.tipoSocio.nombre" disabled>
                                    </div>
	                            </div>
	                            <div class="form-group">
	                                <label class="col-sm-3 control-label">Categoria Socio</label>
                                    <div class="col-sm-9">
                                    	<input type="text" class="form-control" ng-model="objUpdate.categoriaSocio.nombre" disabled>
                                    </div>
	                            </div>
	                            <div class="form-group">
	                                <label class="col-sm-3 control-label">Valor</label>
	                            	<div class="col-sm-9">
	                            		<input type="text" class="form-control" ng-model="objUpdate.valor" placeholder="Monto" 
                                    		data-parsley-error-message="Por favor ingrese valor cuota" data-parsley-required is-number maxlength="6">
	                            	</div>
	                            </div>
                            </form>
                            
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                            <button type="button" class="btn btn-primary" ng-click="actualizar();">Guardar</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div>
        
    </div>
</section>