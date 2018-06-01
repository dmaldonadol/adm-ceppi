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
        
	        <div class="col-md-4">
	            <div class="panel panel-default" id="toolbar-showcase">
	                <div class="panel-collapse pull out">
	                    <table class="table table-bordered table-hover">
	                        <thead>
	                        	<tr>
	                        		<th colspan="3">
	                        			
	                        			<div id="spinner4">
								        	<div class="input-group" style="width:270px;">
								            	<div class="spinner-buttons input-group-btn">
								                	<button type="button" class="btn spinner-down btn-primary" ng-click="suma(false);">
								                    	<i class="fa fa-chevron-left"></i>
								                    </button>
								                </div>
								                <input type="text" class="spinner-input form-control" maxlength="3" readonly ng-model="anio" style="padding-left: 80px;"> 
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
	                                <th></th>
	                            </tr>
	                        </thead>
	                        <tbody>	                            
	                            <tr ng-repeat="c in table" ng-show="c.show">
	                            	<td>{{c.name}}</td>
	                            	<td>{{c.estado}}</td>
	                                <td>
	                                	<a ng-show="c.estado==='PENDIENTE'" ng-click="irPagar(c)" class="label label-primary">Pagar</a>
	                                	<a ng-show="c.estado==='PARCIAL'" ng-click="irPagar(c)" class="label label-warning">ir Pagar</a>
	                                	<a ng-show="c.estado==='PAGADA'" ng-click="verComprobante(c)" class="label label-success ">Ver detalle</a>
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
		                        	<label class="col-sm-3 control-label">Fecha Ingreso:</label>
		                            <div class="col-sm-9">
		                            	<label class="control-label">{{socio.fechaIngreso  | date:'dd-MM-yyyy'}}</label>
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
		                        <div class="form-group">
		                        	<label class="col-sm-3 control-label">Valor Cuota:</label>
		                            <div class="col-sm-9">
		                            	<label class="control-label">{{formatNumber(socio.valorCuota)}}</label>
		                            </div>
		                        </div>
                       		</form>
                       	</div>
                    </div>
                </div>
            </div>
        </div>
        
        <div id="modal-confirmacion" class="modal fade" aria-hidden="true" style="display: none;">
			<div class="modal-dialog">
            	<div class="modal-content" style="width: 400px;">
                	<div class="modal-header text-center">
                    	<button type="button" class="close" data-dismiss="modal" ng-click="initialize()">×</button>
                        <h3 class="semibold modal-title">Pago&nbsp;{{periodo}}</h3>
					</div>
                    <div id="modal-print" class="modal-body">
                    	<form class="form-horizontal form-bordered" id="form-create">
	                    	<div class="form-group">
	                        	<label class="col-sm-3 control-label">Tipo Pago:</label>
	                            <div class="col-sm-9">
	                            	<div class="btn-group">
                                        <button type="button" class="btn btn-default {{buttonTotal}}" ng-click="buttonTotal='btn-primary';buttonParcial='';showMonto=false;"  >Total</button>	                                            
                                        <button type="button" class="btn btn-default {{buttonParcial}}" ng-click="buttonParcial='btn-primary';buttonTotal='';showMonto=true;">Parcial</button>
                                    </div>
	                            </div>
	                        </div>
	                        <div class="form-group" ng-show="objpago.estado==='PARCIAL'">
	                        	<label class="col-sm-3 control-label">Monto Pagado:</label>
	                            <div class="col-sm-9">
	                            	<label class="control-label">{{formatNumber(objpago.monto)}}</label>
	                            </div>
	                        </div>
	                        <div class="form-group" ng-show="objpago.estado==='PARCIAL'">
	                        	<label class="col-sm-3 control-label">Monto Pendiente:</label>
	                            <div class="col-sm-9">
	                            	<label class="control-label">{{formatNumber(montoPago)}}</label>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<label class="col-sm-3 control-label">Valor:</label>
	                            <div class="col-sm-9">
	                            	<label ng-show="!showMonto" class="control-label">{{formatNumber(montoPago)}}</label>
	                            	<input ng-show="showMonto" type="text" class="form-control" ng-model="montoParcial" placeholder="Monto" maxlength="6">
	                            </div>
	                        </div>
	                        <div class="form-group">
	                        	<label class="col-sm-3 control-label">Comentario:</label>
	                            <div class="col-sm-9">
	                            	<input type="text" class="form-control" ng-model="comentario" placeholder="Comentario">
	                            </div>
	                        </div>
                        </form>
					</div>
					<div class="modal-body" ng-show="showmsg">
                        <label class="control-label text-danger">{{msgInfo}}</label>
					</div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" ng-click="validacionPago();">Confirmar</button>
					</div>
				</div>
			</div>
		</div>
        
        
        <div id="modal-comprobante" class="modal fade" aria-hidden="true" style="display: none;">
			<div class="modal-dialog">
            	<div class="modal-content" style="width: 400px;">
                	<div class="modal-header text-center">
                    	<button type="button" class="close" data-dismiss="modal" ng-click="initialize()">×</button>
                        <h3 class="semibold modal-title">Comprobante&nbsp;{{periodo}}</h3>
					</div>
                    <div id="modal-print" class="modal-body">
                    	<form class="form-horizontal form-bordered" id="form-create">
                    	<div class="form-group">
                        	<label class="col-sm-3 control-label">Socio:</label>
                            <div class="col-sm-9">
                            	<label class="control-label" style="text-align: left !important;">{{registro.cuota.socio.persona.nombre}}&nbsp;{{registro.cuota.socio.persona.apellidoPaterno}}</label>
                            </div>
                        </div>
                        <div class="form-group">
                        	<label class="col-sm-3 control-label">Año:</label>
                            <div class="col-sm-9">
                            	<label class="control-label" style="text-align: left !important;">{{registro.cuota.anio}}</label>
                            </div>
                        </div>
                        <div class="form-group">
                        	<label class="col-sm-3 control-label">Mes:</label>
                            <div class="col-sm-9">
                            	<label class="control-label" style="text-align: left !important;">{{getMonth(registro.cuota.mes)}}</label>
                            </div>
                        </div>
                        <div class="form-group">
                        	<label class="col-sm-3 control-label">Monto:</label>
                            <div class="col-sm-9">
                            	<label class="control-label" style="text-align: left !important;">{{formatNumber(registro.cuota.valor)}}</label>
                            </div>
                        </div>
                        <div class="form-group">
                        	<label class="col-sm-3 control-label">Fecha Emisi&oacute;n:</label>
                            <div class="col-sm-9">
                            	<label class="control-label" style="text-align: left !important;">{{registro.fechaCobro | date:'dd-MM-yyyy HH:mm:ss'}}</label>
                            </div>
                        </div>
                        <div class="form-group">
                        	<label class="col-sm-3 control-label">Comentario:</label>
                            <div class="col-sm-9">
                            	<label class="control-label" style="text-align: left !important;">{{registro.comentario}}</label>
                            </div>
                        </div>
                        </form>
					</div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-primary" ng-click="imprimir(registro);">Imprimir</button>
					</div>
				</div>
			</div>
		</div>

    </div>
</section>