<section id="main" role="main">
    <div class="container-fluid">
        <div class="page-header page-header-block">
            <div class="page-header-section">
                <h4 class="title semibold">Profesores</h4>
            </div>
            <div class="page-header-section">
                <div class="toolbar">
                    <ol class="breadcrumb breadcrumb-transparent nm">
                    	<li><a href="">Equipos</a></li>
                        <li><a href="#/mantenedores/profesores">Profesores</a></li>
                        <li class="active">Editar</li>
                    </ol>
                </div>
            </div>
        </div>
        
        <div class="row">
	        <div class="col-md-12">
	        
	    		<div class="panel panel-default" id="toolbar-showcase">
	                <div class="panel-heading">
	                    <h3 class="panel-title"><span class="panel-icon mr5"><i class="ico-equalizer"></i></span> Editar Profesor</h3>
	                </div>
	                
              
	               <div class="panel-body panel-collapse pull out">
	               		<div class="row">
		        			<div class="col-md-6">
		        				<form class="form-horizontal form-bordered" id="form-create-person">
			        				<h4 class="text-primary mt0">Informacion Personal</h4>
			        				<p class="pb10">Indique el tipo de profesor.</p>
			        				
	                                <div class="form-group">
	                                    <label class="col-sm-3 control-label">Rut</label>
	                                    <div class="col-sm-9">
	                                        <input type="text" class="form-control" ng-model="profesor.persona.rut" placeholder="ej. 11111111-1" disabled="disabled">
	                                    </div>
	                                </div>
	                                
	                                <div class="form-group">
	                                    <label class="col-sm-3 control-label">Nombre</label>
	                                    <div class="col-sm-9">
	                                        <input type="text" class="form-control" ng-model="profesor.persona.nombre" placeholder="Nombres"
	                                        data-parsley-errors-container="#error-container" data-parsley-error-message="Por favor ingrese su nombre" data-parsley-required>
	                                    </div>
	                                </div>
	                                
	                                <div class="form-group">
	                                    <label class="col-sm-3 control-label">Apellido <br> Paterno</label>
	                                    <div class="col-sm-9">
	                                        <input type="text" class="form-control" ng-model="profesor.persona.apellidoPaterno" placeholder="Apellido Paterno"
	                                        data-parsley-errors-container="#error-container" data-parsley-error-message="Por favor ingrese su apellido paterno" data-parsley-required>
	                                    </div>
	                                </div>
	                                
	                                <div class="form-group">
	                                    <label class="col-sm-3 control-label">Apellido Materno</label>
	                                    <div class="col-sm-9">
	                                        <input type="text" class="form-control" ng-model="profesor.persona.apellidoMaterno" placeholder="Apeliido Materno"
	                                        data-parsley-errors-container="#error-container" data-parsley-error-message="Por favor ingrese su apellido Materno" data-parsley-required>
	                                    </div>
	                                </div>
	                                
	                                <div class="form-group">
	                                    <label class="col-sm-3 control-label">Email</label>
	                                    <div class="col-sm-9">
	                                        <input type="email" class="form-control" ng-model="profesor.persona.email" placeholder="ejemplo@mail.com"
	                                        data-parsley-errors-container="#error-container" data-parsley-error-message="Por favor ingrese su email" data-parsley-required data-parsley-type="email">
	                                    </div>
	                                </div>
	                                
	                               <div class="form-group">
	                                    <label class="col-sm-3 control-label">Género</label>
	                                    <div class="col-sm-9">
                                           <div class="btn-group">
	                                            <button type="button" class="btn btn-default {{button.male}}"   ng-click="profesor.persona.genero='MASCULINO';button.male='btn-primary';button.female='';"  >Masculino</button>	                                            
	                                            <button type="button" class="btn btn-default {{button.female}}" ng-click="profesor.persona.genero='FEMENINO';button.female='btn-primary';button.male='';">Femenino</button>
	                                        </div>
                                        </div>
	                                </div>
	                                
	                                <div class="form-group">
	                                    <label class="col-sm-3 control-label">Fecha Nacimiento</label>
	                                    <div class="col-sm-9">
	                                        <input type="text" class="form-control" ng-model="profesor.persona.fechaNacimiento" placeholder="yyyy-mm-dd" id="fechaNacimiento"
	                                        data-parsley-errors-container="#error-container" data-parsley-error-message="Por favor ingrese su apellido Materno" data-parsley-required>
	                                    </div>
	                                </div>
	                                
	                                
			        				
		        				</form>
		        			</div>
		        			<div class="col-md-6" style="border-right:1px solid #e0e7e8;">
		        				<form class="form-horizontal form-bordered" id="form-create-user">
		        					<h4 class="text-primary mt0">Información Profesor</h4>
		        					
		        					<div class="form-group">
	                                    <label class="col-sm-3 control-label">Tipo de Profesor</label>
	                                    <div class="col-sm-9">
	                                        <select class="form-control" ng-model="profesor.tipo" ng-options="tipo.nombre for tipo in tipoProfesor track by tipo.oid"></select>
	                                    </div>
	                                </div>
	                                
	                                <div ng-show="diplayError" class="alert alert-danger">{{errorMsg}}</div>
		        					
		        				</form>
		        			</div>
		        		</div>
		        		<div class="row" style="border-top:1px solid #e0e7e8;">
		        			<div class="col-md-12 text-right pt5 pb0">
		        				<a href="#/mantenedores/profesores" class="btn btn-default">Cancelar</a>
		        				<button class="btn btn-success"  value="button"  ng-click="actualizar()">Guardar</button>
		        			</div>
		        		</div>
	               </div>   
                </div> 
	        
	        
	        </div>
 		</div>
        
        
        
        
    </div>
</section>