<section id="main" role="main">
    <div class="container-fluid">
        <div class="page-header page-header-block">
            <div class="page-header-section">
                <h4 class="title semibold">Usuarios</h4>
            </div>
            <div class="page-header-section">
                <div class="toolbar">
                    <ol class="breadcrumb breadcrumb-transparent nm">
                    	<li><a href="">Administración</a></li>
                        <li><a href="#/administracion/usuarios">Usuarios</a></li>
                        <li class="active">Editar</li>
                    </ol>
                </div>
            </div>
        </div>
        
        <div class="row">
	        <div class="col-md-12">
	        
	    		<div class="panel panel-default" id="toolbar-showcase">
	                <div class="panel-heading">
	                    <h3 class="panel-title"><span class="panel-icon mr5"><i class="ico-equalizer"></i></span> Nuevo Usuario</h3>
	                </div>
	                
              
	               <div class="panel-body panel-collapse pull out">
	               		<div class="row">
		        			<div class="col-md-6">
		        				<form class="form-horizontal form-bordered" id="form-create-person">
			        				<h4 class="text-primary mt0">Informacion Personal</h4>
			        				<p class="pb10">Indique los perfiles que poseera el perfil.</p>
			        				
	                                <div class="form-group">
	                                    <label class="col-sm-3 control-label">Rut</label>
	                                    <div class="col-sm-9">
	                                        <input type="text" class="form-control" ng-model="usuario.persona.rut" placeholder="ej. 11111111-1" disabled="disabled">
	                                    </div>
	                                </div>
	                                
	                                <div class="form-group">
	                                    <label class="col-sm-3 control-label">Nombre</label>
	                                    <div class="col-sm-9">
	                                        <input type="text" class="form-control" ng-model="usuario.persona.nombre" placeholder="Nombres"
	                                        data-parsley-errors-container="#error-container" data-parsley-error-message="Por favor ingrese su nombre" data-parsley-required>
	                                    </div>
	                                </div>
	                                
	                                <div class="form-group">
	                                    <label class="col-sm-3 control-label">Apellido <br> Paterno</label>
	                                    <div class="col-sm-9">
	                                        <input type="text" class="form-control" ng-model="usuario.persona.apellidoPaterno" placeholder="Apellido Paterno"
	                                        data-parsley-errors-container="#error-container" data-parsley-error-message="Por favor ingrese su apellido paterno" data-parsley-required>
	                                    </div>
	                                </div>
	                                
	                                <div class="form-group">
	                                    <label class="col-sm-3 control-label">Apellido Materno</label>
	                                    <div class="col-sm-9">
	                                        <input type="text" class="form-control" ng-model="usuario.persona.apellidoMaterno" placeholder="Apeliido Materno"
	                                        data-parsley-errors-container="#error-container" data-parsley-error-message="Por favor ingrese su apellido Materno" data-parsley-required>
	                                    </div>
	                                </div>
	                                
	                                <div class="form-group">
	                                    <label class="col-sm-3 control-label">Email</label>
	                                    <div class="col-sm-9">
	                                        <input type="email" class="form-control" ng-model="usuario.persona.email" placeholder="ejemplo@mail.com"
	                                        data-parsley-errors-container="#error-container" data-parsley-error-message="Por favor ingrese su email" data-parsley-required data-parsley-type="email">
	                                    </div>
	                                </div>
	                                
	                                <div class="form-group">
	                                    <label class="col-sm-3 control-label">Tipo Socio</label>
	                                    <div class="col-sm-9">
	                                        <select class="form-control" ng-model="usuario.persona.tipoSocio"  ng-options="tipoSocio.nombre for tipoSocio in tiposSocio track by tiposSocio.oid"></select>
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
	                                
	                                <div class="form-group">
	                                    <label class="col-sm-3 control-label">Fecha Nacimiento</label>
	                                    <div class="col-sm-9">
	                                        <input type="text" class="form-control" ng-model="usuario.persona.fechaNacimiento" placeholder="yyyy-mm-dd" id="fechaNacimiento"
	                                        data-parsley-errors-container="#error-container" data-parsley-error-message="Por favor ingrese su apellido Materno" data-parsley-required>
	                                    </div>
	                                </div>
	                                
	                                
			        				
		        				</form>
		        			</div>
		        			<div class="col-md-6" style="border-right:1px solid #e0e7e8;">
		        				<form class="form-horizontal form-bordered" id="form-create-user">
		        					<h4 class="text-primary mt0">Información Básica</h4>
		        					<p class="pb10">Complete la informacion básica del perfil.</p>
		        					
		        					<div class="form-group">
	                                    <label class="col-sm-3 control-label">Username</label>
	                                    <div class="col-sm-9">
	                                        <input type="text" class="form-control" ng-model="usuario.username" placeholder="Nombre de Usuario" disabled="disabled">
	                                    </div>
	                                </div>
		        					
		        					<div class="form-group">
	                                    <label class="col-sm-3 control-label">Password</label>
	                                    <div class="col-sm-9">
	                                        <input type="password" class="form-control" ng-model="usuario.password" placeholder="Password" 
	                                        data-parsley-errors-container="#error-container" data-parsley-error-message="Por favor ingrese su password" data-parsley-required>
	                                    </div>
	                                </div>
	                                
	                                <div class="form-group">
	                                    <label class="col-sm-3 control-label">Confirmar Password</label>
	                                    <div class="col-sm-9">
	                                        <input type="password" class="form-control" ng-model="usuario.passwordConfirmed" placeholder="Confirmar Password"
	                                        data-parsley-errors-container="#error-container" data-parsley-error-message="Por favor confirme su password" data-parsley-required>
	                                    </div>
	                                </div>
	                                
	                                
	                                <div class="form-group">
	                                    <label class="col-sm-3 control-label">Perfil</label>
	                                    <div class="col-sm-9">
	                                        <select class="form-control" ng-model="usuario.perfil" ng-options="perfil.nombre for perfil in perfiles track by perfil.oid"></select>
	                                    </div>
	                                </div>
		        					
		        				</form>
		        			</div>
		        		</div>
		        		<div class="row" style="border-top:1px solid #e0e7e8;">
		        			<div class="col-md-12 text-right pt5 pb0">
		        				<a href="#/administracion/usuarios" class="btn btn-default">Cancelar</a>
		        				<button class="btn btn-success"  value="button"  ng-click="actualizar()">Guardar</button>
		        			</div>
		        		</div>
	               </div>   
                </div> 
	        
	        
	        </div>
 		</div>
        
        
        
        
    </div>
</section>