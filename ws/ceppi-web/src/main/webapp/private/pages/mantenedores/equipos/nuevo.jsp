<section id="main" role="main">
    <div class="container-fluid">
        <div class="page-header page-header-block">
            <div class="page-header-section">
                <h4 class="title semibold">Nuevo Equipo</h4>
            </div>
            <div class="page-header-section">
                <div class="toolbar">
                    <ol class="breadcrumb breadcrumb-transparent nm">
                        <li><a href="inicio#/">Ceppi</a></li>
                        <li><a href="inicio#/mantenedores/equipos">Equipos</a></li>
                        <li class="active">Nuevo Equipo</li>
                    </ol>
                </div>
            </div>
        </div>
        <div class="row">
       		<div class="col-md-12">
	        
	    		<div class="panel panel-default" id="toolbar-showcase">
	                <div class="panel-heading">
	                    <h3 class="panel-title"><span class="panel-icon mr5"><i class="ico-plus"></i></span> Nuevo Equipo</h3>
	                </div>
	                
              
	               <div class="panel-body panel-collapse pull out">
	               		<div class="row">
	               			<div class="col-md-6">
	               			
	               				<section class="jumbotron jumbotron-bg10" data-stellar-background-ratio="0.4" style="min-height:320px;">
	               					<div class="pattern pattern2 overlay overlay-primary"></div>
	               					<div class="container" style="padding-top:8%;">
				                        <h1 class="thin text-white text-center font-alt">Nuevo equipo.</h1>
				                        <h4 class="thin text-white text-center">El talento gana juegos, pero el trabajo de equipo y la inteligencia ganan campeonatos</h4>				                        
				                    </div>
	               				</section>
	               				
		        			</div>
		        			<div class="col-md-6" style="border-right:1px solid #e0e7e8;">
		        				<form class="form-horizontal form-bordered" id="form-crear-equipo">
		        					<h4 class="text-primary mt0">Información Básica</h4>
		        					<p class="pb10">Complete la informacion básica del equipo.</p>
		        					
		        					<div class="form-group">
	                                    <label class="col-sm-3 control-label">Nombre</label>
	                                    <div class="col-sm-9">
	                                        <input type="text" class="form-control" ng-model="equipo.nombre"
	                                        data-parsley-errors-container="#error-container" data-parsley-error-message="ingrese el nombre del equipo" data-parsley-required>
	                                    </div>
	                                </div>
	                                
	                                <div class="form-group">
	                                    <label class="col-sm-3 control-label">Descripción</label>
	                                    <div class="col-sm-9">
	                                        <textarea class="form-control" ng-model="equipo.descripcion"
	                                        data-parsley-errors-container="#error-container" data-parsley-error-message="ingrese una descripción" data-parsley-required></textarea>
	                                    </div>
	                                </div>
	                                
	                                <div class="form-group">
	                                    <label class="col-sm-3 control-label">Año Limite</label>
	                                    <div class="col-sm-9">
	                                        <input type="text" class="form-control" ng-model="equipo.anioLimite"
	                                        data-parsley-errors-container="#error-container" data-parsley-error-message="ingrese el Año limite del equipo" data-parsley-required>
	                                    </div>
	                                </div>
	                                
	                                <div class="form-group">
	                                    <label class="col-sm-3 control-label">Género</label>
	                                    <div class="col-sm-9">
                                            <div class="btn-group">
	                                            <button type="button" class="btn btn-default {{button.male}}"   ng-click="equipo.genero='MASCULINO';button.male='btn-primary';button.female='';"  >Masculino</button>	                                            
	                                            <button type="button" class="btn btn-default {{button.female}}" ng-click="equipo.genero='FEMENINO';button.female='btn-primary';button.male='';">Femenino</button>
	                                        </div>
                                        </div>
	                                </div>
	                                
	                                <div ng-show="diplayError" class="alert alert-danger">{{errorMsg}}</div>
		        					
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

<script>
$.stellar({horizontalScrolling: false});
</script>