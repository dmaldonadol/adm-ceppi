var app = angular.module('CeppiApp', ['ngRoute']).config(function($routeProvider, $controllerProvider) 
{
	app.registerCtrl = $controllerProvider.register;
	$routeProvider
    .when('/', 
    {
    	controller:'DashboardController',
    	templateUrl:  CONSTANTS.contextPath + '/private/pages/inicio.jsp' 	
    })
    .when('/administracion/usuarios',{controller:'UsuarioController',templateUrl:  CONSTANTS.contextPath + '/private/pages/administracion/usuarios/usuarios.jsp'})
    .when('/administracion/usuarios/crear',{controller:'UsuarioController',templateUrl:  CONSTANTS.contextPath + '/private/pages/administracion/usuarios/crear-usuario.jsp'})
    .when('/administracion/perfiles',{controller:'PerfilController',templateUrl:  CONSTANTS.contextPath + '/private/pages/administracion/perfiles/perfiles.jsp'})
    .when('/administracion/perfiles/crear',{controller:'PerfilController',templateUrl:  CONSTANTS.contextPath + '/private/pages/administracion/perfiles/crear-perfiles.jsp'})
    
    .when('/mantenedores/equipos',{controller:'EquipoController',templateUrl:  CONSTANTS.contextPath + '/private/pages/mantenedores/equipos/equipos.jsp'})
    .when('/mantenedores/equipos/:id',{controller:'PerfilEquipoController',templateUrl:  CONSTANTS.contextPath + '/private/pages/mantenedores/equipos/perfil.jsp'})
    .when('/mantenedores/equipos/edit/:id',{controller:'EquipoController',templateUrl:  CONSTANTS.contextPath + '/private/pages/mantenedores/equipos/editar.jsp'})
    
    
    .when('/mantenedores/jugadores',{controller:'PerfilController',templateUrl:  CONSTANTS.contextPath + '/private/pages/mantenedores/jugadores.jsp'})
    
    .otherwise(
    {
    	redirectTo:'/'
    });
});