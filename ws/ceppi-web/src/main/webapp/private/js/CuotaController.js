/*************************************************************
 * @author 	: Juan Francisco ( juan.maldonado.leon@gmail.com )
 * @desc 	: Controlador de perfiles.
 *************************************************************/
app.controller("CuotaController", function($scope, $http, $location)
{
	$scope.listaSocios = [];
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.initialize = function()
	{
		NProgress.configure({ parent: '#main' });
		NProgress.start();
		$scope.obtener( function()
		{
			NProgress.done();
		});
	};
	
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.obtener = function( callback )
	{
		var request = $http.get( CONSTANTS.contextPath + "/api/private/socio" );
		request.success( function( response )
		{
			$scope.listaSocios = response;
			callback();
		} );
		request.error( function( error )
		{
			console.log(error);
			callback();
		});
	};
	
	$scope.selectSocio = function ( obj )
	{
		
	};
	
	$scope.initialize();
});



/*************************************************************
 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
 * @desc 
 *************************************************************/
app.controller("AdmCuotaController", function( $scope, $http, $location, $routeParams )
{
	$scope.listaanual = [];
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.initialize = function()
	{
		$scope.params = $routeParams;
		$scope.anio = (new Date).getFullYear();
		$scope.idsocio = $scope.params.id;
		NProgress.configure({ parent: '#main' });
		NProgress.start();
		$scope.obtenerListaAnual( $scope.params.id, $scope.anio,  function()
		{
			$scope.obtenerSocio( function()
			{
				NProgress.done();
			});
		});
	};
	
	
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.obtenerListaAnual = function( socio, anio,  callback )
	{
		var request = $http.get( CONSTANTS.contextPath + "/api/private/cuota/registroCuotas/" + parseInt(socio) + "/" + parseInt(anio) );
		request.success( function( response )
		{
			$scope.listaanual = response;
			
			$scope.createtable( $scope.listaanual );
			
			callback();
		} );
		request.error( function( error )
		{
			console.log(error);
			callback();
		});
	};
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.obtenerSocio = function( callback )
	{
		var request = $http.get( CONSTANTS.contextPath + "/api/private/socio/byID/" + $scope.idsocio);
		request.success( function( response )
		{
			$scope.socio = response;
			callback();
		} );
		request.error( function( error )
		{
			console.log(error);
			callback();
		});
	};
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.createtable = function ( lista )
	{
		$scope.table = $scope.inittable();
		
		for ( var i=0; i < $scope.table.length; i++ )
		{
			for ( var a=0; a < lista.length; a++ )
			{
				if ( lista[a].cuota.mes == $scope.table[i].mes )
				{
					$scope.table[i].estado = true;
					break;
				}
			}
		}
	};
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.inittable = function ()
	{
		var table = [{name:"Enero",mes:"1", estado:false}
					,{name:"Febrero",mes:"2", estado:false}
					,{name:"Marzo",mes:"3", estado:false}
					,{name:"Abril",mes:"4", estado:false}
					,{name:"Mayo",mes:"5", estado:false}
					,{name:"Junio",mes:"6", estado:false}
					,{name:"Julio",mes:"7", estado:false}
					,{name:"Agosto",mes:"8", estado:false}
					,{name:"Septiembre",mes:"9", estado:false}
					,{name:"Octubre",mes:"10", estado:false}
					,{name:"Noviembre",mes:"11", estado:false}
					,{name:"Diciembre",mes:"12", estado:false}];
		return table;
	};
	
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.pagar = function ( obj )
	{
		NProgress.configure({ parent: '#main' });
		NProgress.start();
		
		var request = $http.put( CONSTANTS.contextPath + "/api/private/cuota/pagar/" + $scope.anio + "/" + obj.mes + "/" + $scope.idsocio);
		request.success( function( response )
		{
			$scope.registro = response;
			console.log( response );
			$('#modal-comprobante').modal('show');
			NProgress.done();
		} );
		request.error( function( error )
		{
			console.log(error);
			$scope.errorMsg= "Ocurrio un error al pagar la cuota, intente mas tarde";
			$scope.diplayError = true;
			NProgress.done();
		});
	};
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.verComprobante = function ( obj )
	{
		NProgress.configure({ parent: '#main' });
		NProgress.start();
		
		var request = $http.get( CONSTANTS.contextPath + "/api/private/cuota/verRegistro/" + $scope.anio + "/" + obj.mes + "/" + $scope.idsocio);
		request.success( function( response )
		{
			$scope.registro = response;
			console.log( response );
			$('#modal-comprobante').modal('show');
			NProgress.done();
		} );
		request.error( function( error )
		{
			console.log(error);
			$scope.errorMsg= "Ocurrio un error al ver la cuota, intente mas tarde";
			$scope.diplayError = true;
			NProgress.done();
		});
	};
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.formatNumber = function( num ) 
	{
		if ( num )
		{
			return num.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1.");
		}
	    
	};

	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.getMonth = function(mm)
	{
		var monthNames = [ 'Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre' ];
		return monthNames[ parseInt(mm) - 1];
	};
	
	$scope.initialize();
	
});
