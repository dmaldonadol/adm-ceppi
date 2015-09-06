/*************************************************************
 * @author 	: Juan Francisco ( juan.maldonado.leon@gmail.com )
 * @desc 	: Controlador de perfiles.
 *************************************************************/
app.controller("PerfilController", function($scope, $http)
{
	$scope.listaTipoSocio = [];
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.initialize = function()
	{
		NProgress.start();
		var request = $http.get( CONSTANTS.contextPath + "/api/private/tipo/socio" );
		request.success( function( response )
		{
			$scope.listaTipoSocio = response;
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