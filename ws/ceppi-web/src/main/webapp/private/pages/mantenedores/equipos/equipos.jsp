<section id="main" role="main">
    <div class="container-fluid">
        <div class="page-header page-header-block">
            <div class="page-header-section">
                <h4 class="title semibold">Equipos</h4>
            </div>
            <div class="page-header-section">
                <div class="toolbar">
                    <div class="col-md-6 col-md-offset-6">
                        <div class="panel-toolbar">
                            <div class="input-group">
                                <div class="has-icon">
                                    <input type="text" ng-model="q" placeholder="buscar" class="form-control" />
                                    <i class="ico-search form-control-icon"></i>
                                </div>
                                <div class="input-group-btn">
                                	<a href="inicio#/mantenedores/equipos/nuevo" class="btn btn-default">Nuevo</a>
                                    	                                        
                                </div>
                            </div>
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>
        
        <div class="row" >
        
        	
        
        	<div class="col-md-3" ng-repeat="e in equipos | filter:q as results">
               <div class="thumbnail thumbnail-album animation animating delay fadeInLeft">
                   <div class="media">
                       <div class="indicator"><span class="spinner"></span></div>
                       <div class="overlay">
                           <div class="toolbar">
                               <a href="inicio#/mantenedores/equipos/{{e.oid}}" class="btn btn-default" title="upload to collection"><i class="ico-eye"></i></a>
                               <a href="inicio#/mantenedores/equipos/edit/{{e.oid}}" class="btn btn-success" title="watch collection"><i class="ico-edit"></i></a>
                               <a href="javascript:void(0);" class="btn btn-default" ng-click="eliminar(e)"><i class="ico-remove4"></i></a>
                           </div>
                       </div>
                       <img data-toggle="unveil" src="<%=request.getContextPath() %>/public/image/background/background-basketball.jpg" 
                       		data-src="<%=request.getContextPath() %>/public/image/background/background-basketball.jpg" alt="Cover" width="100%" class="unveiled">
                   </div>
                   <div class="caption">
                       <h5 class="semibold mt0 mb5">{{e.nombre}}</h5>
                       <p class="text-muted mb5 ellipsis">
                       	{{e.descripcion}} </br>
                       	{{e.genero}}
                       </p>
                   </div>
               </div>
           </div>
           
           
           
           
        
        </div>
        
    </div>
</section>