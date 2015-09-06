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
	
	
	
	$scope.initialize();
});