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
                        <li><a href="#/administracion/perfiles">Usuarios</a></li>
                        <li class="active">Crear</li>
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
		        				<form class="form-horizontal form-bordered" >
			        				<h4 class="text-primary mt0">Informacion Personal</h4>
			        				<p class="pb10">Indique los perfiles que poseera el perfil.</p>
			        				
	                                <div class="form-group">
	                                    <label class="col-sm-3 control-label">Rut</label>
	                                    <div class="col-sm-9">
	                                        <input type="text" class="form-control" ng-model="rut">
	                                    </div>
	                                </div>
	                                
	                                <div class="form-group">
	                                    <label class="col-sm-3 control-label">Nombre</label>
	                                    <div class="col-sm-9">
	                                        <input type="text" class="form-control" ng-model="nombre">
	                                    </div>
	                                </div>
	                                
	                                <div class="form-group">
	                                    <label class="col-sm-3 control-label">Apellido <br> Paterno</label>
	                                    <div class="col-sm-9">
	                                        <input type="text" class="form-control" ng-model="apellidoPaterno">
	                                    </div>
	                                </div>
	                                
	                                <div class="form-group">
	                                    <label class="col-sm-3 control-label">Apellido Materno</label>
	                                    <div class="col-sm-9">
	                                        <input type="text" class="form-control" ng-model="apellidoMaterno">
	                                    </div>
	                                </div>
	                                
	                                <div class="form-group">
	                                    <label class="col-sm-3 control-label">Email</label>
	                                    <div class="col-sm-9">
	                                        <input type="email" class="form-control" ng-model="email">
	                                    </div>
	                                </div>
	                                
	                                <div class="form-group">
	                                    <label class="col-sm-3 control-label">Tipo Socio</label>
	                                    <div class="col-sm-9">
	                                        <select class="form-control">
                                                <option value="1">Option 1</option>
                                                <option value="2">Option 2</option>
                                                <option value="3">Option 3</option>
                                                <option value="4">Option 4</option>
                                                <option value="5">Option 5</option>
                                            </select>
	                                    </div>
	                                </div>
	                                
	                                <div class="form-group">
	                                    <label class="col-sm-3 control-label">Género</label>
	                                    <div class="col-sm-9">
                                            <label class="radio-inline">
                                                <input type="radio" value="option1">Masculino
                                            </label>
                                            <label class="radio-inline">
                                                <input type="radio" value="option1">Femenino
                                            </label>
                                        </div>
	                                </div>
			        				
		        				</form>
		        			</div>
		        			<div class="col-md-6" style="border-right:1px solid #e0e7e8;">
		        				<form class="form-horizontal form-bordered" >
		        					<h4 class="text-primary mt0">Información Básica</h4>
		        					<p class="pb10">Complete la informacion básica del perfil.</p>
		        					
		        					<div class="form-group">
	                                    <label class="col-sm-3 control-label">Username</label>
	                                    <div class="col-sm-9">
	                                        <input type="text" class="form-control" ng-model="nombreUsuario" placeholder="Nombre de Usuario">
	                                    </div>
	                                </div>
		        					
		        					<div class="form-group">
	                                    <label class="col-sm-3 control-label">Password</label>
	                                    <div class="col-sm-9">
	                                        <input type="password" class="form-control" ng-model="password">
	                                    </div>
	                                </div>
	                                
	                                <div class="form-group">
	                                    <label class="col-sm-3 control-label">Confirmar Password</label>
	                                    <div class="col-sm-9">
	                                        <input type="password" class="form-control" ng-model="passwordConfirmed">
	                                    </div>
	                                </div>
	                                
	                                
	                                <div class="form-group">
	                                    <label class="col-sm-3 control-label">Perfil</label>
	                                    <div class="col-sm-9">
	                                        <select class="form-control">
                                                <option value="1">Option 1</option>
                                                <option value="2">Option 2</option>
                                                <option value="3">Option 3</option>
                                                <option value="4">Option 4</option>
                                                <option value="5">Option 5</option>
                                            </select>
	                                    </div>
	                                </div>
		        					
		        				</form>
		        			</div>
		        		</div>
		        		<div class="row" style="border-top:1px solid #e0e7e8;">
		        			<div class="col-md-12 text-right pt5 pb0">
		        				<button class="btn btn-success mb5 mb5"  value="button">Guardar <i class="ico-save"></i></button>
		        			</div>
		        		</div>
	               </div>   
                </div> 
	        
	        
	        </div>
 		</div>
        
        
        
        
    </div>
</section>