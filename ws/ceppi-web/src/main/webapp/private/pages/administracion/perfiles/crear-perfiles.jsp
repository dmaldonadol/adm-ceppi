<section id="main" role="main">
    <div class="container-fluid">
        <div class="page-header page-header-block">
            <div class="page-header-section">
                <h4 class="title semibold">Perfiles</h4>
            </div>
            <div class="page-header-section">
                <div class="toolbar">
                    <ol class="breadcrumb breadcrumb-transparent nm">
                    	<li><a href="">Administración</a></li>
                        <li><a href="#/administracion/perfiles">Perfiles</a></li>
                        <li class="active">Crear</li>
                    </ol>
                </div>
            </div>
        </div>
        
        <div class="row">
	        <div class="col-md-12">
	        
	    		<div class="panel panel-default" id="toolbar-showcase">
	                <div class="panel-heading">
	                    <h3 class="panel-title"><span class="panel-icon mr5"><i class="ico-plus"></i></span> Nuevo Perfil</h3>
	                </div>
	                
              
	               <div class="panel-body panel-collapse pull out">
	               		<div class="row">
		        			<div class="col-md-6" style="border-right:1px solid #e0e7e8;">
		        				<form class="form-horizontal form-bordered" id="form-crear-perfil">
		        					<h4 class="text-primary mt0">Información Básica</h4>
		        					<p class="pb10">Complete la informacion básica del perfil.</p>
		        					
		        					<div class="form-group">
	                                    <label class="col-sm-3 control-label">Código</label>
	                                    <div class="col-sm-9">
	                                        <input type="text" class="form-control" ng-model="perfil.codigo"
	                                        data-parsley-errors-container="#error-container" data-parsley-error-message="ingrese el código de perfil" data-parsley-required>
	                                    </div>
	                                </div>
		        					
		        					<div class="form-group">
	                                    <label class="col-sm-3 control-label">Nombre</label>
	                                    <div class="col-sm-9">
	                                        <input type="text" class="form-control" ng-model="perfil.nombre"
	                                        data-parsley-errors-container="#error-container" data-parsley-error-message="ingrese el nombre del perfil" data-parsley-required>
	                                    </div>
	                                </div>
	                                
	                                <div class="form-group">
	                                    <label class="col-sm-3 control-label">Descripción</label>
	                                    <div class="col-sm-9">
	                                        <textarea class="form-control" ng-model="perfil.descripcion"
	                                        data-parsley-errors-container="#error-container" data-parsley-error-message="ingrese una descripción" data-parsley-required></textarea>
	                                    </div>
	                                </div>
		        				</form>
		        			</div>
		        			
		        			<div class="col-md-6">
		        				<form class="form-horizontal form-bordered" >
			        				<h4 class="text-primary mt0">Permisos del Perfil</h4>
			        				<p class="pb10">Indique los permisos que poseera el nuevo perfil.</p>
									
			        				<div class="form-group col-md-12" ng-repeat="item in menuObj">
	                                    <div class="col-md-12">
                                        	<span class="text" style="padding: 7px 0px 7px 0px; font-weight: 600;color: #6f6f6f;">{{item.nombre}}</span>
	                                    </div>
	                                    <div class="col-md-12" ng-repeat="subItem in item.itemMenu">
		                                    <div class="col-md-2"><input type="checkbox" name="{{subItem.codigo}}" id="{{subItem.codigo}}" ng-model="subItem.permiso" ng-change="addPermiso(subItem);"></div>
		                                    <div class="col-md-10"><span class="text">{{subItem.nombre}}</span></div>
								        </div>
	                                </div>
			        				
		        				</form>
		        			</div>
		        		</div>
		        		<div class="row" style="border-top:1px solid #e0e7e8;">
		        			<div class="col-md-12 text-right pt5 pb0">
		        				<button class="btn btn-success mb5 mb5"  value="button" ng-click="guardar()">Guardar <i class="ico-save"></i></button>
		        			</div>
		        		</div>
	               </div>   
                </div> 
	        
	        
	        </div>
 		</div>
        
        
        
        
    </div>
</section>