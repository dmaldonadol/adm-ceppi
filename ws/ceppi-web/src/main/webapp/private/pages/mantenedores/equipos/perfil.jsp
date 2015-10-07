<section id="main" role="main">
    <div class="container-fluid">
    
    	
		<section class="jumbotron jumbotron-bg11 mt-15 mb15 mr-15 ml-15" data-stellar-background-ratio="0.4" style="min-height: 320px; background-position: 50% 30px;">
		    <div class="overlay pattern pattern10"></div>
		    <div class="container" style="padding-top:8%;">
		        <h1 class="thin text-white text-center font-alt">Create your application in an instant.</h1>
		        <h4 class="thin text-white text-center">Adminre is a clean and flat backend and frontend theme build with Twitter bootstrap</h4>
		        <div class="text-center pt15">
		            <a href="javascript:void(0);" class="btn btn-primary">Learn More <i class="ico-angle-right"></i></a>
		        </div>
		    </div>
		</section>
    
    
    
    
    
        <div class="page-header page-header-block">
            <div class="page-header-section">
                <h4 class="title semibold">{{equipo.nombre}}</h4>
            </div>
            <div class="page-header-section">
                <div class="toolbar">
                    <ol class="breadcrumb breadcrumb-transparent nm">
                        <li><a href="inicio#/mantenedores/equipos/edit/{{equipo.oid}}">Editar</a></li>
                        <li><a href="inicio#/mantenedores/equipos">Todos los Equipos</a></li>
                    </ol>
                </div>
            </div>
        </div>
        
        <div class="row" >
        	<div class="col-md-6">
        		<div class="panel panel-default" id="toolbar-showcase">
	                <div class="panel-heading">
	                    <h3 class="panel-title"><span class="panel-icon mr5"><i class="ico-list22"></i></span> Información</h3>
	                </div>
	               <div class="panel-body panel-collapse pull out">
	               		<div class="row">
	               			<div class="col-md-12"> {{equipo.descripcion}} </div>
	               		</div>
	               		<hr/>
	               		<div class="row">
	               			<div class="col-md-6">
	               				<b>Año limite</b> <br/>{{equipo.anioLimite}} 
	               			</div>
	               			<div class="col-md-6">
	               				<b>Equipo</b> <br/>{{equipo.genero}}
	               			</div>
	               		</div>
	               		
						<!-- form class="form-horizontal form-bordered" id="form-crear-equipo">
			        		<div class="form-group">
			                    <label class="col-sm-3 control-label">Nombre</label>
			                    <div class="col-sm-9 control-label" style="text-align:left;">
			                        {{equipo.nombre}}
			                    </div>
			                </div>
			                
			                <div class="form-group">
			                    <label class="col-sm-3 control-label">Descripción</label>
			                    <div class="col-sm-9 control-label" style="text-align:left;">
			                        {{equipo.descripcion}}
			                    </div>
			                </div>
			                
			                <div class="form-group">
			                    <label class="col-sm-3 control-label">Año Limite</label>
			                    <div class="col-sm-9 control-label" style="text-align:left;">
			                        
			                    </div>
			                </div>
			                
			                <div class="form-group">
			                    <label class="col-sm-3 control-label">Género</label>
			                    <div class="col-sm-9 control-label" style="text-align:left;">                           
			                            {{equipo.genero}}
			                    </div>
			                </div>
		                </form-->
	               </div>
            </div>
        	
        	</div>
 	       	<div class="col-md-6">
 	       	
 	       	
 	       	<div class="panel panel-default" id="toolbar-showcase">
	                <div class="panel-heading">
	                    <h3 class="panel-title"><span class="panel-icon mr5"><i class="ico-list22"></i></span> Jugadores</h3>
	                </div>
	                <div class="panel-body panel-collapse pull out" style="padding:0px;">
        				<div class="media-list">
							<a href="javascript:void(0);" class="media border-dotted" ng-show="equipo.juagadores.length==0">		                      
		                      <span class="media-body">
		                          <span class="media-text ellipsis nm">No se han asignado jugadores al equipo.</span>		                          
		                      </span>
		                  	</a>
			        		<a href="javascript:void(0);" class="media border-dotted" ng-repeat="playeers in equipo.juagadores | filter:q as results">
			                      <span class="pull-left">
			                          <img src="<%=request.getContextPath() %>/public/image/avatar/avatar6.jpg" class="media-object" alt="">
			                      </span>
			                      <span class="media-body">
			                          <span class="media-heading">Arthur Abbott</span>
			                          <span class="media-text ellipsis nm">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod.</span>
			                          <!-- meta icon -->
			                          <span class="media-meta">2m</span>
			                          <!--/ meta icon -->
			                      </span>
			                  </a>
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