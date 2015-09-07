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
		var request = $http.get( CONSTANTS.contextPath + "/api/private/perfil/listar" );
		request.success( function( response )
		{
			console.log( response );
		} );
		request.error( function( error )
		{
			console.log(error);
			NProgress.done();
		});
	};
	
	
	
	//$scope.initialize();
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
		console.log( $scope.params );
		$scope.getPerfilEquipo( $scope.params.id, function()
		{
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