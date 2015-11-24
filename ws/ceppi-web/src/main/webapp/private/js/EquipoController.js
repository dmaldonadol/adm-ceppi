/*************************************************************
 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
 * @desc Controlador PerfilEquipoController
 *************************************************************/
app.controller("EquipoController", function($scope, $http)
{
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
		var request = $http.get( CONSTANTS.contextPath + "/api/private/equipo" );
		request.success( function( response )
		{
			console.log( response );
			$scope.equipos = response;			
			callback();
		} );
		request.error( function( error )
		{
			console.log(error);
			callback
		});
	};
	
	
	$scope.initialize();
});



/*************************************************************
 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
 * @desc Controlador CrearEquipoController
 *************************************************************/
app.controller("CrearEquipoController", function($scope, $http, $location)
{
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.initialize = function()
	{
		
	};
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.guardar = function()
	{
		NProgress.configure({ parent: '#main' });
		NProgress.start();
		
		if( $("#form-crear-equipo").parsley().validate() )
		{
			var request = $http.put( CONSTANTS.contextPath + "/api/private/equipo", $scope.equipo );
			request.success( function( response )
			{
				console.log( response );
				NProgress.done();
				$location.path('/mantenedores/equipos');
			} );
			request.error( function( error )
			{
				console.log(error);
				$scope.errorMsg= "Ocurrio un error al ingresar el equipo, intente más tarde";
				$scope.diplayError = true;
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
 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
 * @desc Controlador PerfilEquipoController
 *************************************************************/
app.controller("PerfilEquipoController", function($scope, $http, $routeParams)
{
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.initialize = function()
	{
		NProgress.start();
		$scope.params = $routeParams;
		$scope.getPerfilEquipo( $scope.params.id, function()
		{
			console.log( $scope.equipo );
			NProgress.done();
		});
	};
	
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.getPerfilEquipo = function( IdEquipo, callback )
	{
		var request = $http.get( CONSTANTS.contextPath + "/api/private/equipo/"+ IdEquipo );
		request.success( function( response )
		{
			$scope.equipo = response;
			callback();
		});
		request.error( function( error )
		{
			console.log(error);
			callback();
		});
	};
	
	
	
	$scope.initialize();
});




/*************************************************************
 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
 * @desc Controlador PerfilEquipoController
 *************************************************************/
app.controller("EditarEquipoController", function($scope, $http, $routeParams)
{
	$scope.button = {male:'', female:''};

	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.initialize = function()
	{
		NProgress.start();
		$scope.params = $routeParams;
		$scope.getPerfilEquipo( $scope.params.id, function()
		{
			$scope.obtenerJugadores( function()
			{
				NProgress.done();
				if( $scope.equipo.genero == "MASCULINO" )
					$scope.button.male='btn-primary';
				else
					$scope.button.female='btn-primary';
			});
		});
	};
	
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.getPerfilEquipo = function( IdEquipo, callback )
	{
		var request = $http.get( CONSTANTS.contextPath + "/api/private/equipo/"+ IdEquipo );
		request.success( function( response )
		{
			$scope.equipo = response;
			callback();
		});
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
	$scope.obtenerJugadores = function( callback )
	{
		var request = $http.get( CONSTANTS.contextPath + "/api/private/jugador" );
		request.success( function( response )
		{
			console.log( response );
			$scope.jugadores = response;			
			callback();
		} );
		request.error( function( error )
		{
			console.log(error);
			callback
		});
	};
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.seleccionarJugador = function( jugador )
	{
		jugador.selected = !jugador.selected;
		if ( jugador.selected )
		{
			$scope.equipo.juagadores.push( jugador );
		}
		console.log( $scope.equipo );
	};
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.actualizar = function()
	{
		alert("TODO:");
	};
	
	
	$scope.initialize();
});