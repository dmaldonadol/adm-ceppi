app.controller("SocioController", function($scope, $http)
{
	$scope.socios = [];
	
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
		var request = $http.get( CONSTANTS.contextPath + "/api/private/socio/" );
		request.success( function( response )
		{
			$scope.socios = response;
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
		var request = $http.delete( CONSTANTS.contextPath + "/api/private/socio/"+objeto.oid );
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
app.controller("CrearSocioController", function( $scope, $http, $location )
{
	$scope.tiposSocio = [];
	$scope.categoriaSocio = [];
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.initialize = function()
	{
		$('#fechaNacimiento').datepicker({altFormat: "yy-mm-dd", dateFormat: "yy-mm-dd"});
		NProgress.configure({ parent: '#main' });
		NProgress.start();
		$scope.obtenerCategorias( function()
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
	$scope.obtenerCategorias = function( callback )
	{
		var request = $http.get( CONSTANTS.contextPath + "/api/private/tipo/categoria" );
		request.success( function( response )
		{
			$scope.categoriaSocio = response;
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
	$scope.buscarSocio = function ( rut )
	{
		if ( $scope.continuar )
		{
			return;
		}
		$scope.msjSocioExiste = "";
		$scope.socioExiste = false;
		var request = $http.get( CONSTANTS.contextPath + "/api/private/socio/byRut/" + rut );
		request.success( function( data, status )
		{
			if ( status == 200 )
			{
				$scope.continuar = false;
				$scope.msjSocioExiste = "Socio ya existe en el sistema.";
				$scope.socioExiste = true;
			}
		} );
		request.error( function( data, status )
		{
			if ( status == 404 )
			{
				$scope.continuar = true;
				$scope.buscarPersona(rut);
			}
			else
			{
				$scope.continuar = false;
				console.log(error);
			}
		});
	};
	
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.buscarPersona = function ( rut )
	{
		var request = $http.get( CONSTANTS.contextPath + "/api/private/socio/personaByRut/" + rut );
		request.success( function( data, status )
		{
			if ( status == 200 )
			{
				$scope.socio.persona = data;
			}
		} );
		request.error( function( data, status )
		{
			if ( status == 404 )
			{
				$scope.continuar = true;
			}
			else
			{
				$scope.continuar = false;
				console.log(error);
			}
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
				
		var validatePeople = $("#form-create-person").parsley().validate();
		
		if( validatePeople )
		{			
			console.log( $scope.socio );
			if( $scope.validate() )
			{
				$scope.socio.persona.fechaNacimiento = $('#fechaNacimiento').val();
				var request = $http.put( CONSTANTS.contextPath + "/api/private/socio/save", $scope.socio );
				request.success( function( response )
				{
					console.log( response );
					NProgress.done();
					$location.path('/administracion/socios');
				} );
				request.error( function( error )
				{
					console.log(error);
					$scope.errorMsg= "Ocurrio un error al ingresar el socio, intente mas tarde";
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
		if(! $scope.socio.categoriaSocio )
		{
			$scope.errorMsg= "Seleccione una Categoria";
			$scope.diplayError = true;
			return false;
		}
		
		if(! $scope.socio.tipoSocio )
		{
			$scope.errorMsg= "Seleccione el tipo de socio";
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
app.controller("EditarSocioController", function($scope, $http, $routeParams)
{
	$scope.socio = {};
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
		
		$scope.obtenerCategorias( function()
		{
			$scope.obtenerTipoSocio( function()
			{
				$scope.obtener( $scope.params.id, function()
				{
					if($scope.socio.persona.genero === "MASCULINO" )
						$scope.button.male='btn-primary';
					else
						$scope.button.female='btn-primary';	
					
					NProgress.done();
				});
			} );
		});
	};
	
	
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.obtenerCategorias = function( callback )
	{
		var request = $http.get( CONSTANTS.contextPath + "/api/private/tipo/categoria" );
		request.success( function( response )
		{
			$scope.categoriaSocio = response;
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
	$scope.obtener = function( oid, callback )
	{
		var request = $http.get( CONSTANTS.contextPath + "/api/private/socio/"+oid );
		request.success( function( response )
		{
			$scope.socio = response;
			$scope.socio.persona.rut = $scope.socio.persona.rut + "-" + $scope.socio.persona.dv; 
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
		var request = $http.post( CONSTANTS.contextPath + "/api/private/socio" , $scope.objUpdate );
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