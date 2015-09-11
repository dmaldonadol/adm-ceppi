app.controller("UsuarioController", function($scope, $http)
{
	$scope.usuarios = [];
	
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
		var request = $http.get( CONSTANTS.contextPath + "/api/private/usuario/listar" );
		request.success( function( response )
		{
			$scope.usuarios = response;
			console.log( response );
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
	$scope.eliminar = function( objeto )
	{
		var request = $http.delete( CONSTANTS.contextPath + "/api/private/usuario/"+objeto.oid );
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
	
	
	
	$scope.initialize();
});



/*************************************************************
 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
 * @desc 
 *************************************************************/
app.controller("CrearUsuarioController", function($scope, $http)
{
	
	$scope.perfiles = [];
	$scope.tiposSocio = [];
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.initialize = function()
	{
		NProgress.configure({ parent: '#main' });
		NProgress.start();
		$scope.obtenerPerfiles( function()
		{
			$scope.obtenerTipoSocio( function()
			{
				NProgress.done();
			} );
			
		});
	};
	
	
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.obtenerPerfiles = function( callback )
	{
		var request = $http.get( CONSTANTS.contextPath + "/api/private/perfil/listar" );
		request.success( function( response )
		{
			$scope.perfiles = response;
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
			$scope.tiposSocio = response;
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
	$scope.guardar = function()
	{
		NProgress.configure({ parent: '#main' });
		NProgress.start();
		
		
		var validateUser   = $("#form-create-user").parsley().validate();
		var validatePeople = $("#form-create-person").parsley().validate();
		
		if( validateUser && validatePeople )
		{
			$scope.usuario.persona = $scope.persona;
			console.log( $scope.usuario );
			
			
			var request = $http.put( CONSTANTS.contextPath + "/api/private/usuario", $scope.usuario );
			request.success( function( response )
			{
				console.log( response );
				NProgress.done();
			} );
			request.error( function( error )
			{
				console.log(error);
				NProgress.done();
			});
		}
		else
		{
			NProgress.done();
		}
	};
	
	$scope.initialize();
	
});





/*************************************************************
 * @author 	: Juan Francisco ( juan.maldonado.leon@gmail.com )
 * @desc 	: Controlador de perfiles.
 *************************************************************/
app.controller("EditarUsuarioController", function($scope, $http, $routeParams)
{
	$scope.usuario = {};
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.initialize = function()
	{
		NProgress.configure({ parent: '#main' });
		NProgress.start();
		$scope.params = $routeParams;
		$scope.params.id;
		$scope.obtener( $scope.params.id, function()
		{
			NProgress.done();
		} );
	};
	
	

	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.obtener = function( oid, callback )
	{
		var request = $http.get( CONSTANTS.contextPath + "/api/private/usuario/"+oid );
		request.success( function( response )
		{
			$scope.usuario = response;
			console.log( response );
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
	$scope.actualizar = function( objeto )
	{
		console.log( objeto );
		var request = $http.post( CONSTANTS.contextPath + "/api/private/usuario" , $scope.objUpdate );
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
	
	$scope.initialize();
});