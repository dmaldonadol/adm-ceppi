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
	                    <h3 class="panel-title"><span class="panel-icon mr5"><i class="ico-equalizer"></i></span> Otros Ingresos</h3>
	                </div>
	                
              
	               <div class="panel-body panel-collapse pull out">
	               		<div class="row">
		        			<div class="col-md-6">
		        				<form class="form-horizontal form-bordered" id="form-create-person">
			        				<h4 class="text-primary mt0">Otros ingresos</h4>
			        				
	                                <div class="form-group">
	                                    <label class="col-sm-3 control-label">Rut Socio</label>
	                                    <div class="col-sm-3">
	                                        <input type="number" class="form-control" ng-model="ingreso.rut" placeholder="ej. 11111111"
	                                        data-parsley-error-message="Por favor ingrese rut" data-parsley-required maxlength="8">
	                                    </div>
	                                    <div class="col-sm-2">
	                                        <input type="text" class="form-control" ng-model="ingreso.dv" placeholder="dv"
	                                        data-parsley-error-message="Por favor ingrese dv" data-parsley-required maxlength="1">
	                                    </div>
	                                    <div>
					        				<button class="btn btn-success mb5 mb5"  value="button"  ng-click="buscar(ingreso.rut)">Buscar <i class="ico-search"></i></button>
					        			</div>
	                                </div>
	                                
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
	                                        <input type="number" class="form-control" ng-model="ingreso.monto" placeholder="Monto"
	                                        data-parsley-error-message="Por favor ingrese monto" data-parsley-required myMaxlength="7">
	                                    </div>
	                                </div>
	                                
	                                <div class="form-group">
	                                    <label class="col-sm-3 control-label">Detalle</label>
	                                    <div class="col-sm-9">
	                                        <textarea class="form-control" ng-model="ingreso.descripcion" maxlength="255"/>
	                                    </div>
	                                </div>
		        				</form>
		        			</div>
		        		</div>
		        		<div class="row" style="border-top:1px solid #e0e7e8;">
		        			<div class="col-md-12 text-right pt5 pb0">
		        				<button class="btn btn-success mb5 mb5"  value="button"  ng-click="guardar()">Guardar <i class="ico-save"></i></button>
		        			</div>
		        		</div>
	               </div>   
                </div> 
	        </div>
 		</div>
    </div>
</section>