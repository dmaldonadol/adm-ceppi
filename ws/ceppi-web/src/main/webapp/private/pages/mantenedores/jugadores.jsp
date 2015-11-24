<section id="main" role="main">
    <div class="container-fluid">
        <div class="page-header page-header-block">
            <div class="page-header-section">
                <h4 class="title semibold">Jugadores</h4>
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
                                	<a href="inicio#/mantenedores/jugadores/nuevo" class="btn btn-default">Nuevo</a>
                                    	                                        
                                </div>
                            </div>
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>
        
        <div class="row shuffle" style="position: relative; overflow: hidden; height: 1015px; transition: height 250ms ease-out;">
        
        	<div class="col-sm-6 col-md-4 shuffle shuffle-item filtered" style="position: absolute; top: 0px; left: 0px; visibility: visible; transition: transform 250ms ease-out, opacity 250ms ease-out;">
                        <div class="panel widget">
                            <div class="table-layout nm">
                                <div class="col-xs-4 text-center"><img src="<%=request.getContextPath() %>/public/image/avatar/avatar.png" width="100%"></div>
                                <div class="col-xs-8 valign-middle">
                                    <div class="panel-body">
                                        <h5 class="semibold mt0 mb5"><a href="javascript:void(0);">Violet Kidd</a></h5>
                                        <p class="ellipsis text-muted mb5"><i class="ico-envelop mr5"></i> libero.Integer@turpis.org</p>
                                        <p class="text-muted nm"><i class="ico-location2 mr5"></i> Bahamas</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
        
        </div>
        
        
        
                
    </div>
</section>