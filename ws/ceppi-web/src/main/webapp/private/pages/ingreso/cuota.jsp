<section id="main" role="main">
    <div class="container-fluid">
        <div class="page-header page-header-block">
            <div class="page-header-section">
                <h4 class="title semibold">Ingreso de Cuota</h4>
            </div>
            <div class="page-header-section">
                <div class="toolbar">
                    <ol class="breadcrumb breadcrumb-transparent nm">
                        <li class="active">Cuotas</li>
                    </ol>
                </div>
            </div>
        </div>
        
        
        <div class="row">
	        <div class="col-md-12">
	            <div class="panel panel-default" id="toolbar-showcase">
	                <div class="panel-heading">
	                    <h3 class="panel-title"><span class="panel-icon mr5"><i class="ico-equalizer"></i></span> Seleccionar Socio</h3>
	                    <div class="panel-toolbar text-right">
	                        <div class="option">
	                        	<button class="btn" ng-click="initialize()" ><i class="reload"></i> </button>
	                            <button class="btn up" data-toggle="panelcollapse"><i class="arrow"></i></button>
	                        </div>
	                    </div>
	                </div>
	                <div class="panel-toolbar-wrapper pl10 pr0 pt5 pb5">	                    
	                    <div class="panel-toolbar text-right">
	                    	<div class="col-sm-8" >
	                    	</div>
	                    	<div class="col-sm-4" >
	                        	<div class="panel-toolbar">
	                                <div class="input-group">
	                                    <div class="has-icon">
	                                        <input type="text" ng-model="q" placeholder="buscar" class="form-control" />
	                                        <i class="ico-search form-control-icon"></i>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
	
	                <div class="panel-collapse pull out">
	                    <table class="table table-bordered table-hover">
	                        <thead>
	                            <tr>
	                            	<th>RUT</th>
	                                <th>Nombre</th>
	                                <th></th>
	                            </tr>
	                        </thead>
	                        <tbody>	                            
	                            <tr ng-repeat="c in listaSocios | filter:q as results" ng-click="selectSocio(c)">	                                                               
	                                    <td>{{c.persona.rut}}-{{c.persona.dv}}</td>
	                                    <td>{{c.persona.nombre}}&nbsp;{{c.persona.apellidoPaterno}}</td>
	                                    <td><a href="#/ingreso/cuotas/adm/{{c.oid}}"><i class="icon"></i>Seleccionar</a></td>
	                                </tr>
	                            </tbody>
	                        </table>
	                    </div>
	                </div>
	            </div>
	        </div>
    </div>
</section>