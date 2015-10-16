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
    .when('/administracion/usuarios/crear',{controller:'CrearUsuarioController',templateUrl:  CONSTANTS.contextPath + '/private/pages/administracion/usuarios/crear-usuario.jsp'})
    .when('/administracion/usuarios/editar/:id',{controller:'EditarUsuarioController',templateUrl:  CONSTANTS.contextPath + '/private/pages/administracion/usuarios/editar-usuario.jsp'})
    .when('/administracion/perfiles',{controller:'PerfilController',templateUrl:  CONSTANTS.contextPath + '/private/pages/administracion/perfiles/perfiles.jsp'})
    .when('/administracion/perfiles/crear',{controller:'CrearPerfilController',templateUrl:  CONSTANTS.contextPath + '/private/pages/administracion/perfiles/crear-perfiles.jsp'})
    .when('/administracion/perfiles/editar/:id',{controller:'EditarPerfilController',templateUrl:  CONSTANTS.contextPath + '/private/pages/administracion/perfiles/editar-perfiles.jsp'})
    
    .when('/administracion/socios',{controller:'SocioController',templateUrl:  CONSTANTS.contextPath + '/private/pages/administracion/socio/socios.jsp'})
    .when('/administracion/socios/crear',{controller:'CrearSocioController',templateUrl:  CONSTANTS.contextPath + '/private/pages/administracion/socio/crear-socio.jsp'})
    .when('/administracion/socios/editar/:id',{controller:'EditarSocioController',templateUrl:  CONSTANTS.contextPath + '/private/pages/administracion/socio/editar-socio.jsp'})
    
    
    .when('/mantenedores/equipos',{controller:'EquipoController',templateUrl:  CONSTANTS.contextPath + '/private/pages/mantenedores/equipos/equipos.jsp'})
    .when('/mantenedores/equipos/nuevo',{controller:'CrearEquipoController',templateUrl:  CONSTANTS.contextPath + '/private/pages/mantenedores/equipos/nuevo.jsp'})
    .when('/mantenedores/equipos/:id',{controller:'PerfilEquipoController',templateUrl:  CONSTANTS.contextPath + '/private/pages/mantenedores/equipos/perfil.jsp'})
    .when('/mantenedores/equipos/edit/:id',{controller:'EditarEquipoController',templateUrl:  CONSTANTS.contextPath + '/private/pages/mantenedores/equipos/editar.jsp'})
    
    
    .when('/mantenedores/jugadores',{controller:'PerfilController',templateUrl:  CONSTANTS.contextPath + '/private/pages/mantenedores/jugadores.jsp'})
    
    .when('/mantenedores/profesores',{controller:'ProfesorController',templateUrl:  CONSTANTS.contextPath + '/private/pages/mantenedores/profesor/profesores.jsp'})
    .when('/mantenedores/profesores/crear',{controller:'CrearProfesorController',templateUrl:  CONSTANTS.contextPath + '/private/pages/mantenedores/profesor/crear-profesor.jsp'})
    .when('/mantenedores/profesores/editar/:id',{controller:'EditarProfesorController',templateUrl:  CONSTANTS.contextPath + '/private/pages/mantenedores/profesor/editar-profesor.jsp'})
    
    .when('/mantenedor/categoria', 		{controller:'CategoriaController',templateUrl:  CONSTANTS.contextPath + '/private/pages/mantenedores/categoria.jsp'})
    .when('/mantenedor/centrocosto', 	{controller:'CentroCostoController',templateUrl:  CONSTANTS.contextPath + '/private/pages/mantenedores/centrocosto.jsp'})
    .when('/mantenedor/profesion', 		{controller:'ProfesionController',templateUrl:  CONSTANTS.contextPath + '/private/pages/mantenedores/profesion.jsp'})
    .when('/mantenedor/tipogasto', 		{controller:'TipoGastoController',templateUrl:  CONSTANTS.contextPath + '/private/pages/mantenedores/tipogasto.jsp'})
    .when('/mantenedor/tipoingreso', 	{controller:'TipoIngresoController',templateUrl:  CONSTANTS.contextPath + '/private/pages/mantenedores/tipoingreso.jsp'})
    .when('/mantenedor/tiposocio', 		{controller:'TipoSocioController',templateUrl:  CONSTANTS.contextPath + '/private/pages/mantenedores/tiposocio.jsp'})
    .when('/mantenedor/tipoprofesor', 	{controller:'TipoProfesorController',templateUrl:  CONSTANTS.contextPath + '/private/pages/mantenedores/tipoprofesor.jsp'})
    
    .when('/ingreso/otros',  {controller:'IngresoController',templateUrl:  CONSTANTS.contextPath + '/private/pages/ingreso/ingreso.jsp'})
    .when('/ingreso/cuotas', {controller:'CuotaController',templateUrl:  CONSTANTS.contextPath + '/private/pages/ingreso/cuota.jsp'})
    .when('/ingreso/cuotas/adm/:id',{controller:'AdmCuotaController',templateUrl:  CONSTANTS.contextPath + '/private/pages/ingreso/create-cuota.jsp'})
    .when('/ingreso/valorCuota', {controller:'ValorCuotaController',templateUrl:  CONSTANTS.contextPath + '/private/pages/ingreso/valorcuota.jsp'})
    .when('/ingreso/gastos', {controller:'GastoController',templateUrl:  CONSTANTS.contextPath + '/private/pages/ingreso/gasto.jsp'})
    
    .otherwise(
    {
    	redirectTo:'/'
    });
	
	
	app.directive('myMaxlength', function() 
	{
		var dir = 
		{
		    require: 'ngModel',
		    link: function (scope, element, attrs, ngModelCtrl) 
		    {
		    	var maxlength = Number(attrs.myMaxlength);
		    	function fromUser(text) 
		    	{
		    		if (text.length > maxlength) 
		    		{
		    			var transformedInput = text.substring(0, maxlength);
		    			ngModelCtrl.$setViewValue(transformedInput);
		    			ngModelCtrl.$render();
		    			return transformedInput;
		    		} 
		    		return text;
		    	}
		    	ngModelCtrl.$parsers.push(fromUser);
		    }
		};
		
		return dir;
	});
	
});