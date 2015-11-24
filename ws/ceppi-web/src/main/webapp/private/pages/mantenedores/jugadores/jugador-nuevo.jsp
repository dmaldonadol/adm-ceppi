<section id="main" role="main">
    <div class="container-fluid">
        <div class="page-header page-header-block">
            <div class="page-header-section">
                <h4 class="title semibold">Nuevo Jugador</h4>
            </div>
            <div class="page-header-section">
                <div class="toolbar">
                    <ol class="breadcrumb breadcrumb-transparent nm">
                        <li><a href="inicio#/">Ceppi</a></li>
                        <li><a href="inicio#/mantenedores/jugadores">Jugador</a></li>
                        <li class="active">Nuevo Jugador</li>
                    </ol>
                </div>
            </div>
        </div>
        <div class="row">
       		<div class="col-md-12">
	    		<div class="panel panel-default" id="toolbar-showcase">
	                <div class="panel-heading">
	                    <h3 class="panel-title"><span class="panel-icon mr5"><i class="ico-plus"></i></span> Nuevo Jugador</h3>
	                </div>
	               <div class="panel-body panel-collapse pull out">
	               		<div class="row">
	               			<form class="form-horizontal form-bordered" action="" id="form-crear-jugador">
	               			<div class="col-md-6">
				        		<div class="form-group">
				                     <label class="col-sm-3 control-label">Rut</label>
				                     <div class="col-sm-5">
				                         <input type="text" class="form-control" ng-model="jugador.persona.rut">
				                     </div>
				                     <div class="col-sm-2">
				                         <input type="text" class="form-control" ng-model="jugador.persona.dv">
				                     </div>
				                 </div>
				                 <div class="form-group">
		                             <label class="col-sm-3 control-label">Nombre</label>
		                             <div class="col-sm-9">
		                                 <input type="text" class="form-control" ng-model="jugador.persona.nombre" placeholder="Nombres"
		                                 data-parsley-error-message="Por favor ingrese su nombre" data-parsley-required>
		                             </div>
		                         </div>
		                         
		                         <div class="form-group">
		                             <label class="col-sm-3 control-label">Apellido Paterno</label>
		                             <div class="col-sm-9">
		                                 <input type="text" class="form-control" ng-model="jugador.persona.apellidoPaterno" placeholder="Apellido Paterno"
		                                 data-parsley-error-message="Por favor ingrese su apellido paterno" data-parsley-required>
		                             </div>
		                         </div>
		                         
		                         <div class="form-group">
		                             <label class="col-sm-3 control-label">Apellido Materno</label>
		                             <div class="col-sm-9">
		                                 <input type="text" class="form-control" ng-model="jugador.persona.apellidoMaterno" placeholder="Apeliido Materno"
		                                 data-parsley-error-message="Por favor ingrese su apellido Materno" data-parsley-required>
		                             </div>
		                         </div>
		                         
		                         <div class="form-group">
		                             <label class="col-sm-3 control-label">Email</label>
		                             <div class="col-sm-9">
		                                 <input type="email" class="form-control" ng-model="jugador.persona.email" placeholder="ejemplo@mail.com"
		                                 data-parsley-error-message="Por favor ingrese su email" data-parsley-required data-parsley-type="email">
		                             </div>
		                         </div>
		                         
		                         <div class="form-group">
		                             <label class="col-sm-3 control-label">Género</label>
		                             <div class="col-sm-9">
		                                    <div class="btn-group">
		                                     <button type="button" class="btn btn-default {{button.male}}"   ng-click="jugador.persona.genero='MASCULINO';button.male='btn-primary';button.female='';"  >Masculino</button>	                                            
		                                     <button type="button" class="btn btn-default {{button.female}}" ng-click="jugador.persona.genero='FEMENINO';button.female='btn-primary';button.male='';">Femenino</button>
		                                 </div>
		                                </div>
		                         </div>
				        	</div>
		        			<div class="col-md-6">
		        				
		                         <div class="form-group">
		                             <label class="col-sm-3 control-label">Posición</label>
		                             <div class="col-sm-9">
		                             	<select class="form-control" ng-model="jugador.posicion" ng-options="poscion for poscion in posciones"></select>
		                             </div>
		                         </div>
		                         
		                         <div class="form-group">
		                             <label class="col-sm-3 control-label">Número</label>
		                             <div class="col-sm-9">
		                             	 <input type="text" class="form-control" ng-model="jugador.numero" placeholder="Número Camiseta"
		                                 data-parsley-error-message="Por favor ingrese su apellido Materno" data-parsley-required>
		                             </div>
		                         </div>
		                         
		                          <div class="form-group">
		                             <label class="col-sm-3 control-label">Estatura</label>
		                             <div class="col-sm-9">
		                             	<input type="text" class="form-control" ng-model="jugador.estatura" placeholder="Estatura"
		                                 data-parsley-error-message="Por favor ingrese la estatura" data-parsley-required >
		                             </div>
		                         </div>
		                         
		                         <div class="form-group">
		                             <label class="col-sm-3 control-label">Peso</label>
		                             <div class="col-sm-9">
		                             	<input type="text" class="form-control" ng-model="jugador.peso" placeholder="peso"
		                                 data-parsley-error-message="Por favor ingrese el peso" data-parsley-required >
		                             </div>
		                         </div>
		        			</div>
		        			</form>
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