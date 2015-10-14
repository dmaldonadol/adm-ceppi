/*************************************************************
 * @author 	: Juan Francisco ( juan.maldonado.leon@gmail.com )
 * @desc 	: Controlador de perfiles.
 *************************************************************/
app.controller("ValorCuotaController", function($scope, $http)
{
	$scope.listaValorCuota = [];
	
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
			$scope.obtenerTipoSocio( function()
			{
				$scope.obtenerCategoriaSocio( function()
				{
					NProgress.done();
				} );
				
			});
		});
	};
	
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.obtener = function( callback )
	{
		var request = $http.get( CONSTANTS.contextPath + "/api/private/cuota/listaValorCuota" );
		request.success( function( response )
		{
			$scope.listaValorCuota = response;
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
	$scope.obtenerTipoSocio = function( callback )
	{
		var request = $http.get( CONSTANTS.contextPath + "/api/private/tipo/socio" );
		request.success( function( response )
		{
			$scope.tipoSocios = response;
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
	$scope.obtenerCategoriaSocio = function( callback )
	{
		var request = $http.get( CONSTANTS.contextPath + "/api/private/tipo/categoria" );
		request.success( function( response )
		{
			$scope.categoriaSocios = response;
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
	$scope.nuevo = function()
	{
		$scope.ismensaje = false;
		var validate = $http.get( CONSTANTS.contextPath + "/api/private/cuota/findValorCuota/" + $scope.valorcuota.tipoSocio.oid + "/" + $scope.valorcuota.categoriaSocio.oid );
		validate.success( function( data, status )
		{
			if ( status == 200 )
			{
				var request = $http.put( CONSTANTS.contextPath + "/api/private/cuota/saveValorCuota", $scope.valorcuota );
				NProgress.configure({ parent: '.modal-body' });
				NProgress.start();
				request.success( function( response )
				{
					console.log( response );
					NProgress.done();
					$('#modal-create').modal('hide');
					$scope.initialize();
				} );
				request.error( function( error )
				{
					console.log(error);
					NProgress.done();
				});
			}
			/* Valor ya creado */
			if ( status == 201 )
			{
				$scope.ismensaje = true;
				$scope.mensaje = "El valor cuota y existe.";
			}
			
			console.log( status );
			
		} );
		validate.error( function( error )
		{
			console.log(error);
			NProgress.done();
		});
	};
	
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.selecionActualizar = function( objeto )
	{
		$scope.objUpdate = angular.copy(objeto);
		$('#modal-update').modal('show');
		
	};
	
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.actualizar = function( objeto )
	{
		console.log( objeto );
		var request = $http.post( CONSTANTS.contextPath + "/api/private/cuota/updateValorCuota" , $scope.objUpdate );
		NProgress.configure({ parent: '.modal-body' });
		NProgress.start();
		request.success( function( response )
		{
			console.log( response );
			NProgress.done();
			$('#modal-update').modal('hide');
			$scope.initialize();
		} );
		request.error( function( error )
		{
			console.log(error);
			NProgress.done();
		});
		
	};
	
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.eliminar = function( objeto )
	{
		var request = $http.delete( CONSTANTS.contextPath + "/api/private/tipo/categoria/"+objeto.oid );
		NProgress.configure({ parent: '#main' });
		NProgress.start();
		request.success( function( response )
		{
			console.log( response );
			NProgress.done();
			$scope.initialize();
		} );
		request.error( function( error )
		{
			console.log(error);
			NProgress.done();
		});
	};
	
	$scope.clearform= function()
	{
		$scope.codigo = "";
		$scope.nombre = "";
		$scope.descripcion = "";
		$scope.$apply;
	};
	
	
	$scope.initialize();
});