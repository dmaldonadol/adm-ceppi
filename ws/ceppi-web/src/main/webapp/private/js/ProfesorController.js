app.controller("ProfesorController", function($scope, $http)
{
	$scope.profesores = [];
	
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
		var request = $http.get( CONSTANTS.contextPath + "/api/private/profesor/" );
		request.success( function( response )
		{
			$scope.profesores = response;
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
		var request = $http.delete( CONSTANTS.contextPath + "/api/private/profesor/"+objeto.oid );
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
app.controller("CrearProfesorController", function( $scope, $http, $location )
{
	$scope.tipoProfesor = [];
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.initialize = function()
	{
		$('#fechaNacimiento').datepicker({altFormat: "yy-mm-dd", dateFormat: "yy-mm-dd"});
		NProgress.configure({ parent: '#main' });
		NProgress.start();
		$scope.obtenerTipoProfesor( function()
		{
			NProgress.done();
		});
	};
	
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.obtenerTipoProfesor = function( callback )
	{
		var request = $http.get( CONSTANTS.contextPath + "/api/private/tipo/profesor" );
		request.success( function( response )
		{
			$scope.tipoProfesor = response;
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
		
		var validateProfesor   = $("#form-create-profesor").parsley().validate();
		var validatePeople = $("#form-create-person").parsley().validate();
		
		if( validateProfesor && validatePeople )
		{			
			console.log( $scope.profesor );
			if( $scope.validate() )
			{
				$scope.profesor.persona.fechaNacimiento = $('#fechaNacimiento').val();
				var request = $http.put( CONSTANTS.contextPath + "/api/private/profesor", $scope.profesor );
				request.success( function( response )
				{
					console.log( response );
					NProgress.done();
					$location.path('/mantenedores/profesores');
				} );
				request.error( function( error )
				{
					console.log(error);
					$scope.errorMsg= "Ocurrio un error al ingresar el profesor, intente mas tarde";
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
		if(! $scope.profesor.tipo )
		{
			$scope.errorMsg= "Seleccione un tipo de profesor";
			$scope.diplayError = true;
			return false;
		}
			
		$scope.diplayError = false;
		$scope.errorMsg="";
		return true;
		
	};
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.buscar = function ( rut )
	{
		var request = $http.get( CONSTANTS.contextPath + "/api/private/socio/personaByRut/" + rut );
		request.success( function( data, status )
		{
			if ( status == 200 )
			{
				$scope.persona = data;
				$scope.existe = true;
			}
		} );
		request.error( function( data, status )
		{
			console.log(status);
			$scope.persona = undefined;
			$scope.existe = false;
		});
	};
	
	$scope.initialize();
	
});





/*************************************************************
 * @author 	: Juan Francisco ( juan.maldonado.leon@gmail.com )
 * @desc 	: Controlador de perfiles.
 *************************************************************/
app.controller("EditarProfesorController", function($scope, $http, $routeParams, $location)
{
	$scope.profesor = {};
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
		
		$scope.obtenerTipoProfesor( function()
		{
			$scope.obtener( $scope.params.id, function()
			{
				if($scope.profesor.persona.genero === "MASCULINO" )
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
	$scope.obtenerTipoProfesor = function( callback )
	{
		var request = $http.get( CONSTANTS.contextPath + "/api/private/tipo/profesor" );
		request.success( function( response )
		{
			$scope.tipoProfesor = response;
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
	$scope.validate = function()
	{
		if(! $scope.profesor.tipo )
		{
			$scope.errorMsg= "Seleccione un tipo de profesor";
			$scope.diplayError = true;
			return false;
		}
			
		$scope.diplayError = false;
		$scope.errorMsg="";
		return true;
		
	};
	
	$scope.initialize();
});