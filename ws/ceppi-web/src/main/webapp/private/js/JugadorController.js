/*************************************************************
 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
 * @desc Controlador PerfilEquipoController
 *************************************************************/
app.controller("JugadorController", function($scope, $http)
{
	
	$scope.posciones = ["Base", "Escolta", "Alero", "Ala-Pívot", "Pívot"];
	
	
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
	
	
	$scope.initialize();
});



/*************************************************************
 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
 * @desc Controlador CrearEquipoController
 *************************************************************/
app.controller("CrearJugadorController", function($scope, $http, $location)
{
	$scope.posciones = ["Base", "Escolta", "Alero", "Ala-Pívot", "Pívot"];
	
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
		
		if( $("#form-crear-jugador").parsley().validate() )
		{
			var request = $http.put( CONSTANTS.contextPath + "/api/private/jugador", $scope.jugador );
			request.success( function( response )
			{
				console.log( response );
				NProgress.done();
				$location.path('/mantenedores/jugadores');
			} );
			request.error( function( error )
			{
				console.log(error);
				$scope.errorMsg= "Ocurrio un error al ingresar el jugador, intente más tarde";
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
app.controller("PerfilJugadorController", function($scope, $http, $routeParams)
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
		var request = $http.get( CONSTANTS.contextPath + "/api/private/jugador/"+ IdEquipo );
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
app.controller("EditarJugadorController", function($scope, $http, $routeParams, $location)
{
	$scope.button = {male:'', female:''};
	$scope.posciones = ["Base", "Escolta", "Alero", "Ala-Pívot", "Pívot"];

	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.initialize = function()
	{
		NProgress.start();
		$scope.params = $routeParams;
		$scope.getPerfilJugador( $scope.params.id, function()
		{
			NProgress.done();
			
			if( $scope.jugador.persona.genero == "MASCULINO" )
				$scope.button.male='btn-primary';
			else
				$scope.button.female='btn-primary';
		});
	};
	
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.getPerfilJugador = function( IdEquipo, callback )
	{
		var request = $http.get( CONSTANTS.contextPath + "/api/private/jugador/"+ IdEquipo );
		request.success( function( response )
		{
			$scope.jugador = response;
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
	$scope.actualizar = function()
	{
		var validateForm   = $("#form-editar-jugador").parsley().validate();
		if( validateForm )
		{
			var request = $http.post( CONSTANTS.contextPath + "/api/private/jugador" , $scope.jugador );
			NProgress.configure({ parent: '#main' });
			NProgress.start();
			request.success( function( response )
			{
				console.log( response );
				NProgress.done();
				$location.path('/mantenedores/jugadores');
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