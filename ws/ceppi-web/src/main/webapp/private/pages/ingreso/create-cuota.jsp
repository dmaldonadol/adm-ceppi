<section id="main" role="main">
    <div class="container-fluid">
        <div class="page-header page-header-block">
            <div class="page-header-section">
                <h4 class="title semibold">Administraci&oacute;n de Cuotas Socio</h4>
            </div>
            <div class="page-header-section">
                <div class="toolbar">
                    <ol class="breadcrumb breadcrumb-transparent nm">
                        <li class="active">Administraci&oacute;n de Cuotas Socio</li>
                    </ol>
                </div>
            </div>
        </div>
        
        
        <div class="row">
        
	        <div class="col-md-3">
	            <div class="panel panel-default" id="toolbar-showcase">
	                <div class="panel-collapse pull out">
	                    <table class="table table-bordered table-hover">
	                        <thead>
	                        	<tr>
	                        		<th colspan="2">
	                        			
	                        			<div id="spinner4">
								        	<div class="input-group" style="width:210px;">
								            	<div class="spinner-buttons input-group-btn">
								                	<button type="button" class="btn spinner-down btn-primary" ng-click="suma(false);">
								                    	<i class="fa fa-chevron-left"></i>
								                    </button>
								                </div>
								                <input type="text" class="spinner-input form-control" maxlength="3" readonly ng-model="anio" style="padding-left: 53px;"> 
								                <div class="spinner-buttons input-group-btn">
								                    <button type="button" class="btn spinner-up btn-primary" ng-click="suma(true);">
								                        <i class="fa fa-chevron-right"></i>
								                    </button>
								                </div>
								            </div>
							            </div>
	                        			
	                        		
	                        		</th>
	                        	</tr>
	                            <tr>
	                            	<th>MES</th>
	                                <th>Estado</th>
	                            </tr>
	                        </thead>
	                        <tbody>	                            
	                            <tr ng-repeat="c in table">
	                            	<td>{{c.name}}</td>
	                                <td>
	                                	<a ng-show="!c.estado" ng-click="pagar(c)" class="label label-primary">Pagar</a>
	                                	<a ng-show="c.estado" ng-click="verComprobante(c)" class="label label-success ">Ver detalle</a>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            
            <div class="col-md-5">
	            <div class="panel panel-default" id="toolbar-showcase">
	                <div class="panel-collapse pull out">
	                    <div class="modal-body">
	                    	<form class="form-horizontal form-bordered" id="form-create">
		                    	<div class="form-group">
		                        	<label class="col-sm-3 control-label">Socio:</label>
		                            <div class="col-sm-9">
		                            	<label class="control-label">{{socio.persona.nombre}}&nbsp;{{socio.persona.apellidoPaterno}}</label>
		                            </div>
		                        </div>
		                        <div class="form-group">
		                        	<label class="col-sm-3 control-label">RUT:</label>
		                            <div class="col-sm-9">
		                            	<label class="control-label">{{formatNumber(socio.persona.rut)}}-{{socio.persona.dv}}</label>
		                            </div>
		                        </div>
		                        <div class="form-group">
		                        	<label class="col-sm-3 control-label">Tipo:</label>
		                            <div class="col-sm-9">
		                            	<label class="control-label">{{socio.tipoSocio.nombre}}</label>
		                            </div>
		                        </div>
		                        <div class="form-group">
		                        	<label class="col-sm-3 control-label">Categoria:</label>
		                            <div class="col-sm-9">
		                            	<label class="control-label">{{socio.categoriaSocio.nombre}}</label>
		                            </div>
		                        </div>
                       		</form>
                       	</div>
                    </div>
                </div>
            </div>
        </div>
        
        
        <div id="modal-comprobante" class="modal fade" aria-hidden="true" style="display: none;">
			<div class="modal-dialog">
            	<div class="modal-content">
                	<div class="modal-header text-center">
                    	<button type="button" class="close" data-dismiss="modal" ng-click="initialize()">×</button>
                        <h3 class="semibold modal-title">Detalle</h3>
					</div>
                    <div class="modal-body">
                    	<form class="form-horizontal form-bordered" id="form-create">
                    	<div class="form-group">
                        	<label class="col-sm-3 control-label">Socio:</label>
                            <div class="col-sm-9">
                            	<label class="control-label">{{registro.cuota.socio.persona.nombre}}&nbsp;{{registro.cuota.socio.persona.apellidoPaterno}}</label>
                            </div>
                        </div>
                        <div class="form-group">
                        	<label class="col-sm-3 control-label">Año:</label>
                            <div class="col-sm-9">
                            	<label class="control-label">{{registro.cuota.anio}}</label>
                            </div>
                        </div>
                        <div class="form-group">
                        	<label class="col-sm-3 control-label">Mes:</label>
                            <div class="col-sm-9">
                            	<label class="control-label">{{getMonth(registro.cuota.mes)}}</label>
                            </div>
                        </div>
                        <div class="form-group">
                        	<label class="col-sm-3 control-label">Monto:</label>
                            <div class="col-sm-9">
                            	<label class="control-label">{{formatNumber(registro.cuota.valor.valor)}}</label>
                            </div>
                        </div>
                        <div class="form-group">
                        	<label class="col-sm-3 control-label">Fecha Emisi&oacute;n:</label>
                            <div class="col-sm-9">
                            	<label class="control-label">{{registro.fechaCobro | date:'dd-MM-yyyy HH:mm:ss'}}</label>
                            </div>
                        </div>
                        </form>
					</div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" ng-click="imprimir();">Imprimir</button>
					</div>
				</div>
			</div>
		</div>

    </div>
</section>