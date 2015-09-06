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
    .when('/mantenedor/categoria', 
    {
    	controller:'CategoriaController',
    	templateUrl:  CONSTANTS.contextPath + '/private/pages/mantenedores/categoria.jsp'    	
    })
    .when('/mantenedor/centrocosto', 
    {
    	controller:'CentroCostoController',
    	templateUrl:  CONSTANTS.contextPath + '/private/pages/mantenedores/centrocosto.jsp'    	
    })
    .when('/mantenedor/profesion', 
    {
    	controller:'ProfesionController',
    	templateUrl:  CONSTANTS.contextPath + '/private/pages/mantenedores/profesion.jsp'    	
    })
    .when('/mantenedor/tipogasto', 
    {
    	controller:'TipoGastoController',
    	templateUrl:  CONSTANTS.contextPath + '/private/pages/mantenedores/tipogasto.jsp'    	
    })
    .when('/mantenedor/tipoingreso', 
    {
    	controller:'TipoIngresoController',
    	templateUrl:  CONSTANTS.contextPath + '/private/pages/mantenedores/tipoingreso.jsp'    	
    })
    .when('/mantenedor/tiposocio', 
    {
    	controller:'TipoSocioController',
    	templateUrl:  CONSTANTS.contextPath + '/private/pages/mantenedores/tiposocio.jsp'    	
    })
    .otherwise(
    {
    	redirectTo:'/'
    });
})
.controller("MainController", function($scope)
{
	
});