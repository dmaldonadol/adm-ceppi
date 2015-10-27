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
		var request = $http.get( CONSTANTS.contextPath + "/api/private/usuario/" );
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
app.controller("CrearUsuarioController", function( $scope, $http, $location )
{
	
	$scope.perfiles = [];
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.initialize = function()
	{
		$('#fechaNacimiento').datepicker({altFormat: "yy-mm-dd", dateFormat: "yy-mm-dd"});
		NProgress.configure({ parent: '#main' });
		NProgress.start();
		$scope.obtenerPerfiles( function()
		{
			
			NProgress.done();
			
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
	$scope.guardar = function()
	{
		NProgress.configure({ parent: '#main' });
		NProgress.start();
		
		var validateUser   = $("#form-create-user").parsley().validate();
		var validatePeople = $("#form-create-person").parsley().validate();
		
		if( validateUser && validatePeople )
		{			
			console.log( $scope.usuario );
			if( $scope.validate() )
			{
				$scope.usuario.persona.fechaNacimiento = $('#fechaNacimiento').val();
				delete $scope.usuario.passwordConfirmed;
				var request = $http.put( CONSTANTS.contextPath + "/api/private/usuario", $scope.usuario );
				request.success( function( response )
				{
					console.log( response );
					NProgress.done();
					$location.path('/administracion/usuarios');
				} );
				request.error( function( error )
				{
					console.log(error);
					$scope.errorMsg= "Ocurrio un error al ingresar el usuario, intente más tarde";
					$scope.diplayError = true;
					NProgress.done();
					
				});
			}
			else
			{
				NProgress.done();
			}
			
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
		if( $scope.usuario.password != $scope.usuario.passwordConfirmed )
		{
			$scope.errorMsg= "las password no coinciden";
			$scope.diplayError = true;
			return false;
		}
		
		if(! $scope.usuario.perfil )
		{
			$scope.errorMsg= "Seleccione un perfil";
			$scope.diplayError = true;
			return false;
		}
			
		$scope.diplayError = false;
		$scope.errorMsg="";
		return true;
		
	};
	
	$scope.initialize();
	
});





/*************************************************************
 * @author 	: Juan Francisco ( juan.maldonado.leon@gmail.com )
 * @desc 	: Controlador de perfiles.
 *************************************************************/
app.controller("EditarUsuarioController", function($scope, $http, $routeParams, $location)
{
	$scope.usuario = {};
	$scope.button = {};
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.initialize = function()
	{
		$('#fechaNacimiento').datepicker({altFormat: "yy-mm-dd", dateFormat: "yy-mm-dd"});
		NProgress.configure({ parent: '#main' });
		NProgress.start();
		$scope.params = $routeParams;
		$scope.params.id;
		
		$scope.obtenerPerfiles( function()
		{
			$scope.obtener( $scope.params.id, function()
			{
				$scope.usuario.password = "";
				if($scope.usuario.persona.genero === "MASCULINO" )
					$scope.button.male='btn-primary';
				else
					$scope.button.female='btn-primary';	
				
				NProgress.done();
			});
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
	$scope.obtener = function( oid, callback )
	{
		var request = $http.get( CONSTANTS.contextPath + "/api/private/usuario/"+oid );
		request.success( function( response )
		{
			$scope.usuario = response;
			$scope.usuario.persona.rut = $scope.usuario.persona.rut + "-" + $scope.usuario.persona.dv; 
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
	$scope.actualizar = function( )
	{
		var validateUser   = $("#form-create-user").parsley().validate();
		var validatePeople = $("#form-create-person").parsley().validate();
		var validate = $scope.validate();
		$scope.usuario.persona.fechaNacimiento = $('#fechaNacimiento').val();
		delete $scope.usuario.passwordConfirmed;
		
		if( validateUser && validatePeople && validate )
		{
			var request = $http.post( CONSTANTS.contextPath + "/api/private/usuario" , $scope.usuario );
			NProgress.configure({ parent: '#main' });
			NProgress.start();
			request.success( function( response )
			{
				console.log( response );
				NProgress.done();
				$location.path('/administracion/usuarios');
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
		if( $scope.usuario.password != $scope.usuario.passwordConfirmed )
		{
			$scope.errorMsg= "las password no coinciden";
			$scope.diplayError = true;
			return false;
		}
		
		if(! $scope.usuario.perfil )
		{
			$scope.errorMsg= "Seleccione un perfil";
			$scope.diplayError = true;
			return false;
		}
		
		$scope.diplayError = false;
		$scope.errorMsg="";
		return true;
		
	};
	
	$scope.initialize();
});