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
	                    <h3 class="panel-title"><span class="panel-icon mr5"><i class="ico-equalizer"></i></span> Nuevo Perfil</h3>
	                </div>
	                
              
	               <div class="panel-body panel-collapse pull out">
	               		<div class="row">
		        			<div class="col-md-6" style="border-right:1px solid #e0e7e8;">
		        				<form class="form-horizontal form-bordered" >
		        					<h4 class="text-primary mt0">Información Básica</h4>
		        					<p class="pb10">Complete la informacion básica del perfil.</p>
		        					
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
	                                        <textarea class="form-control" ng-model="descripcion"></textarea>
	                                    </div>
	                                </div>
		        					
		        				</form>
		        			</div>
		        			<div class="col-md-6">
		        				<form class="form-horizontal form-bordered" >
			        				<h4 class="text-primary mt0">Permisos del Perfil</h4>
			        				<p class="pb10">Indique los perfiles que poseera el perfil.</p>
			        				
			        				<div class="form-group">
	                                    <div class="col-sm-1 control-label">
                                                <input type="checkbox" name="customcheckbox1" id="customcheckbox1">
	                                    </div>
	                                    <label class="col-sm-11 control-label">Modulo Usuarios</label>
	                                </div>
	                                <div class="form-group">
	                                    <div class="col-sm-1 control-label">
                                                <input type="checkbox" name="customcheckbox1" id="customcheckbox1">
	                                    </div>
	                                    <div class="col-sm-11 control-label">Modulo Perfiles</div>
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