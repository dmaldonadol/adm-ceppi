app.controller("UsuarioController", function($scope, $http)
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
	};
	
	
	
	//$scope.initialize();
});