/*************************************************************
 * @author 	: Juan Francisco ( juan.maldonado.leon@gmail.com )
 * @desc 	: Controlador de perfiles.
 *************************************************************/
app.controller("PerfilController", function($scope, $http)
{
	$scope.perfiles = [];
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.initialize = function()
	{
		NProgress.configure({ parent: '#main' });
		NProgress.start();
		var request = $http.get( CONSTANTS.contextPath + "/api/private/perfil/listar" );
		request.success( function( response )
		{
			$scope.perfiles = response;
			console.log( response );
			NProgress.done();
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
		var request = $http.delete( CONSTANTS.contextPath + "/api/private/perfil/"+objeto.oid );
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
 * @author 	: Juan Francisco ( juan.maldonado.leon@gmail.com )
 * @desc 	: Controlador de perfiles.
 *************************************************************/
app.controller("CrearPerfilController", function($scope, $http, $location)
{
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.initialize = function()
	{
		$scope.permisos=[];
		$scope.getOpcionesMenu(function()
		{
			NProgress.done();
		});
	};
	
	$scope.getOpcionesMenu = function( callback )
	{
		
		var request = $http.get( CONSTANTS.contextPath + "/api/private/perfil/opciones/menu");
		request.success( function( response )
		{
			console.log( response );
			$scope.menuObj = response;
			callback();
			
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
	$scope.guardar = function()
	{
		NProgress.configure({ parent: '#main' });
		NProgress.start();
		if( $scope.validate() )
		{
			$scope.perfil.permisos = $scope.permisos;
			console.log( $scope.perfil );
			
			var request = $http.put( CONSTANTS.contextPath + "/api/private/perfil", $scope.perfil );
			request.success( function( response )
			{
				console.log( response );
				NProgress.done();
				$location.path('/administracion/perfiles');
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
	
	$scope.addPermiso = function ( obj )
	{
		if ( obj.permiso )
		{
			$scope.permisos.push( obj.codigo );
		}
		else
		{
			var index = $scope.permisos.indexOf(obj.codigo);
			$scope.permisos.splice(index, 1);
		}
		
		console.log($scope.permisos);
	};
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.validate = function()
	{
		return $("#form-crear-perfil").parsley().validate();
	};
	
	$scope.initialize();
});







/*************************************************************
 * @author 	: Juan Francisco ( juan.maldonado.leon@gmail.com )
 * @desc 	: Controlador Edicion de perfil.
 *************************************************************/
app.controller("EditarPerfilController", function($scope, $http, $routeParams, $location)
{
	$scope.perfil = {};
	
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
			$scope.getOpcionesMenu( function()
			{
				NProgress.done();
			});
		} );
	};
	
	
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.obtener = function( oid, callback )
	{
		var request = $http.get( CONSTANTS.contextPath + "/api/private/perfil/"+oid );
		request.success( function( response )
		{
			$scope.perfil = response;
			console.log( response );
			callback();
		} );
		request.error( function( error )
		{
			console.log(error);
			callback();
		});
	};
	
	/**
	 * 
	 */
	$scope.getOpcionesMenu = function( callback )
	{
		
		var request = $http.get( CONSTANTS.contextPath + "/api/private/perfil/opciones/menu");
		request.success( function( response )
		{
			$scope.menuObj = response;
			$scope.permisos=[];
			for ( var i=0; i < $scope.perfil.permisos.length; i++ )
			{
				$scope.permisos.push($scope.perfil.permisos[i]);
				for ( var a=0; a < $scope.menuObj.length; a++ )
				{
					for ( var e=0; e < $scope.menuObj[a].itemMenu.length; e++ )
					{
						if ( $scope.perfil.permisos[i] == $scope.menuObj[a].itemMenu[e].codigo)
						{
							$scope.menuObj[a].itemMenu[e].permiso = true;
						}
					}
				}
			}
			
			callback();
			
		} );
		request.error( function( error )
		{
			console.log(error);
			NProgress.done();
		});
	};
	
	/**
	 * 
	 */
	$scope.addPermiso = function ( obj )
	{
		if ( obj.permiso )
		{
			$scope.permisos.push( obj.codigo );
		}
		else
		{
			var index = $scope.permisos.indexOf(obj.codigo);
			$scope.permisos.splice(index, 1);
		}
		
		console.log($scope.permisos);
	};

	
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.actualizar = function(  )
	{
		if( $scope.validate() )
		{
			$scope.perfil.permisos = $scope.permisos;
			var request = $http.post( CONSTANTS.contextPath + "/api/private/perfil" , $scope.perfil );
			NProgress.configure({ parent: '#main' });
			NProgress.start();
			request.success( function( response )
			{
				console.log( response );
				NProgress.done();			
				$location.path('/administracion/perfiles');
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
	
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.validate = function()
	{
		return $("#form-update-profile").parsley().validate();
	};
	
	$scope.initialize();
});