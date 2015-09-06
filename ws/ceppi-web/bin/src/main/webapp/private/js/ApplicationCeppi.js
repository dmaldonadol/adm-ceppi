var app = angular.module('CeppiApp', ['ngRoute']).config(function($routeProvider, $controllerProvider) 
{
	app.registerCtrl = $controllerProvider.register;
	$routeProvider
    .when('/', 
    {
    	controller:'MainController',
    	templateUrl:  CONSTANTS.contextPath + '/private/pages/inicio.jsp' 	
    })
    .when('/administracion/usuarios', 
    {
    	controller:'UsuarioController',
    	templateUrl:  CONSTANTS.contextPath + '/private/pages/administracion/usuarios.jsp'    	
    })
    .when('/administracion/perfiles', 
    {
    	controller:'PerfilController',
    	templateUrl:  CONSTANTS.contextPath + '/private/pages/administracion/perfiles.jsp'    	
    })
    .otherwise(
    {
    	redirectTo:'/'
    });
})
.controller("MainController", function($scope)
{
	
});