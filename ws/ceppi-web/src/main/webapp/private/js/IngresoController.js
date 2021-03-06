/*************************************************************
 * @author 	: Juan Francisco ( juan.maldonado.leon@gmail.com )
 * @desc 	: Controlador de perfiles.
 *************************************************************/
app.controller("IngresoController", function($scope, $http, $location)
{
	$scope.listaIngreso = [];
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.initialize = function()
	{
		$('#fecha').datepicker({altFormat: "yy-mm-dd", dateFormat: "yy-mm-dd"});		
		$scope.obtenerTiposIngreso();
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
	$scope.obtenerSocios = function( )
	{
		$scope.continuar = false;
		var request = $http.get( CONSTANTS.contextPath + "/api/private/socio/" );
		request.success( function( response )
		{
			$scope.socios = response;
		} );
		request.error( function( error )
		{
			console.log(error);
		});
	};
	
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.obtener = function( callback )
	{
		var request = $http.get( CONSTANTS.contextPath + "/api/private/ingreso/lista" );
		request.success( function( response )
		{
			$scope.listaIngreso = response;
			callback();
		} );
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
	$scope.nuevo = function()
	{
		var objeto = 
		{ 
			monto: $scope.monto, 
			fecha : $scope.nombre, 
			detalle : $scope.descripcion,
			tipoIngreso: $scope.tipoIngreso,
			idSocio: $scope.socio
		};
		var request = $http.put( CONSTANTS.contextPath + "/api/private/ingreso/save", objeto );
		NProgress.configure({ parent: '.modal-body' });
		NProgress.start();
		request.success( function( response )
		{
			console.log( response );
			NProgress.done();
			$('#modal-find').modal('hide');
			$scope.initialize();
		} );
		request.error( function( error )
		{
			console.log(error);
			NProgress.done();
		});
	};
	
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.selecionVer = function( objeto )
	{
		$scope.objView = angular.copy(objeto);
		$('#modal-view').modal('show');
		
	};
	
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.actualizar = function( objeto )
	{
		console.log( objeto );
		var request = $http.post( CONSTANTS.contextPath + "/api/private/ingreso/update" , $scope.objUpdate );
		NProgress.configure({ parent: '.modal-body' });
		NProgress.start();
		request.success( function( response )
		{
			console.log( response );
			NProgress.done();
			$('#modal-update').modal('hide');
			$scope.initialize();
		} );
		request.error( function( error )
		{
			console.log(error);
			NProgress.done();
		});
		
	};
	
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.eliminar = function( objeto )
	{
		var request = $http.delete( CONSTANTS.contextPath + "/api/private/ingreso/delete/" + objeto.oid );
		NProgress.configure({ parent: '#main' });
		NProgress.start();
		request.success( function( response )
		{
			console.log( response );
			NProgress.done();
			$scope.initialize();
		} );
		request.error( function( error )
		{
			console.log(error);
			NProgress.done();
		});
	};
	
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.obtenerTiposIngreso = function()
	{
		var request = $http.get( CONSTANTS.contextPath + "/api/private/tipo/ingreso" );
		request.success( function( response )
		{
			$scope.tipoIngresos = response;
		} );
		request.error( function( error )
		{
			console.log(error);
		});
	};
	
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.clearform= function()
	{
		$scope.continuar = false;
		$('#fecha').datepicker({altFormat: "yy-mm-dd", dateFormat: "yy-mm-dd"});
		$scope.ingreso = undefined;
		$scope.socio = undefined;
		$scope.$apply;
	};
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.buscar= function( rut )
	{
		var request = $http.get( CONSTANTS.contextPath + "/api/private/socio/byRut/" + rut );
		request.success( function( response )
		{
			$scope.socio = response;
		} );
		request.error( function( error )
		{
			console.log(error);
		});
	};
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.selectSocio = function ( socio )
	{
		$('#modal-find').modal('hide');
		$scope.socio = socio;
		$scope.continuar = true;
	};
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.guardar = function()
	{
		NProgress.configure({ parent: '#main' });
		NProgress.start();
		
		var validateUser   = $("#form-create").parsley().validate();
		
		if( validateUser )
		{			
			console.log( $scope.ingreso );
			if( $scope.validate() )
			{
				$scope.ingreso.fecha = $('#fecha').val();
				$scope.ingreso.socio = $scope.socio;
				var request = $http.put( CONSTANTS.contextPath + "/api/private/ingreso/save", $scope.ingreso );
				request.success( function( response )
				{
					console.log( response );
					NProgress.done();
					$scope.continuar = false;
					$scope.ingreso = undefined;
					$('#modal-find').modal('hide');
					$('#modal-create').modal('hide');
					$scope.initialize();
				} );
				request.error( function( error )
				{
					console.log(error);
					$scope.errorMsg= "Ocurrio un error al ingresar el Registro, intente mas tarde";
					$scope.diplayError = true;
					NProgress.done();
					
				});
			}
			else
			{
				NProgress.done();
			}
			
		}
		else
		{
			NProgress.done();
		}
	};
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.validate = function()
	{
		
		if(! $scope.ingreso.tipoIngreso )
		{
			$scope.errorMsg= "Seleccione el tipo de ingreso";
			$scope.diplayError = true;
			return false;
		}
			
		$scope.diplayError = false;
		$scope.errorMsg="";
		return true;
		
	};
	
	$scope.formatNumber = function( num ) 
	{
		if ( num )
		{
			return "$ " + num.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1.");
		}
	    
	}
	
	$scope.initialize();
});

app.directive('isNumber', function () 
{
	return {
	     require: 'ngModel',
	     link: function(scope, element, attrs, modelCtrl) 
	     {
	    	 modelCtrl.$parsers.push(function (inputValue) 
			 {
	    		 if (inputValue == undefined) return '';
	    		 
	    		 var transformedInput = inputValue.replace(/[^0-9+.]/g, ''); 
	    		 if (transformedInput!=inputValue) 
	    		 {
	    			 modelCtrl.$setViewValue(transformedInput);
	    			 modelCtrl.$render();
	    		 }         
	    		 return transformedInput;         
			 });
	     }
	};
});