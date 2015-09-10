<section id="main" role="main">
    <div class="container-fluid">
        <div class="page-header page-header-block">
            <div class="page-header-section">
                <h4 class="title semibold">Tipo de Ingreso</h4>
            </div>
            <div class="page-header-section">
                <div class="toolbar">
                    <ol class="breadcrumb breadcrumb-transparent nm">
                        <li><a href="#">Tipo de Ingreso</a></li>
                        <li class="active">Mantenedores</li>
                    </ol>
                </div>
            </div>
        </div>
        
        
        <div class="row">
	        <div class="col-md-12">
	            <div class="panel panel-default" id="toolbar-showcase">
	                <div class="panel-heading">
	                    <h3 class="panel-title"><span class="panel-icon mr5"><i class="ico-equalizer"></i></span>Tipo de Ingreso</h3>
	                    <div class="panel-toolbar text-right">
	                        <div class="option">
	                            <button class="btn up" data-toggle="panelcollapse"><i class="arrow"></i></button>
	                            <button class="btn" data-toggle="panelremove" data-parent=".col-md-12"><i class="remove"></i></button>
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
	                                        <button type="button" class="btn btn-default" data-toggle="modal" data-target="#modal-create"><i class="ico-plus"></i></button>	                                        
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
	                                <th>Código</th>
	                                <th>Nombre</th>
	                                <th>Descripción</th>
	                                <th width="10%">Opciones</th>
	                            </tr>
	                        </thead>
	                        <tbody>	                            
	                            <tr ng-repeat="i in listaTipoIngreso | filter:q as results">	                                                               
	                                    <td>{{i.codigo}}</td>
	                                    <td>{{i.nombre}}</td>
	                                    <td>{{i.descripcion}}</td>
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
                            <h3 class="semibold modal-title">Nuevo Tipo Ingreso</h3>
                        </div>
                        <div class="modal-body">
                            <form class="form-horizontal form-bordered" action="">
	                            <div class="form-group">
	                                <label class="col-sm-3 control-label">Código</label>
	                                <div class="col-sm-9">
	                                    <input type="text" class="form-control" ng-model="codigo">
	                                </div>
	                            </div>
	                            <div class="form-group">
	                                <label class="col-sm-3 control-label">Nombre</label>
	                                <div class="col-sm-9">
	                                    <input type="text" class="form-control" ng-model="nombre">
	                                </div>
	                            </div>
	                            <div class="form-group">
	                                <label class="col-sm-3 control-label">Descripción</label>
	                                <div class="col-sm-9">
	                                    <!-- input type="text" class="form-control" ng-model="descripcion"-->
	                                    <textarea class="form-control" ng-model="descripcion"></textarea>
	                                </div>
	                            </div>
                            </form>
                            
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                            <button type="button" class="btn btn-primary" ng-click="nuevo();">Guardar</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div>
            
            
            
            <div id="modal-update" class="modal fade" aria-hidden="true" style="display: none;">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header text-center">
                            <button type="button" class="close" data-dismiss="modal">×</button>
                            <h3 class="semibold modal-title">Editar Tipo Ingreso</h3>
                        </div>
                        <div class="modal-body">
                            <form class="form-horizontal form-bordered" action="">
	                            <div class="form-group">
	                                <label class="col-sm-3 control-label">Código</label>
	                                <div class="col-sm-9">
	                                    <input type="text" class="form-control" ng-model="objUpdate.codigo">
	                                </div>
	                            </div>
	                            <div class="form-group">
	                                <label class="col-sm-3 control-label">Nombre</label>
	                                <div class="col-sm-9">
	                                    <input type="text" class="form-control" ng-model="objUpdate.nombre">
	                                </div>
	                            </div>
	                            <div class="form-group">
	                                <label class="col-sm-3 control-label">Descripción</label>
	                                <div class="col-sm-9">
	                                    <!-- input type="text" class="form-control" ng-model="descripcion"-->
	                                    <textarea class="form-control" ng-model="objUpdate.descripcion"></textarea>
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