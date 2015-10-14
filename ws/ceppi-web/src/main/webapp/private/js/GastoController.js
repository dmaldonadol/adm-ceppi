/*************************************************************
 * @author 	: Juan Francisco ( juan.maldonado.leon@gmail.com )
 * @desc 	: Controlador de gastos.
 *************************************************************/
app.controller("GastoController", function($scope, $http, $location)
{
	$scope.listaGasto = [];
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.initialize = function()
	{
		$('#fecha').datepicker({altFormat: "yy-mm-dd", dateFormat: "yy-mm-dd"});		
		NProgress.configure({ parent: '#main' });
		NProgress.start();
		$scope.obtener( function()
		{
			$scope.obtenerTipoGasto();
			$scope.obtenerCentroCosto();
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
		var request = $http.get( CONSTANTS.contextPath + "/api/private/gasto/lista" );
		request.success( function( response )
		{
			$scope.listaGasto = response;
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
		var request = $http.delete( CONSTANTS.contextPath + "/api/private/gasto/delete/" + objeto.oid );
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
	$scope.obtenerTipoGasto = function()
	{
		var request = $http.get( CONSTANTS.contextPath + "/api/private/tipo/gasto" );
		request.success( function( response )
		{
			$scope.tipoGastos = response;
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
	$scope.obtenerCentroCosto = function()
	{
		var request = $http.get( CONSTANTS.contextPath + "/api/private/tipo/centroCosto" );
		request.success( function( response )
		{
			$scope.centroCostos = response;
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
		$scope.gasto = undefined;
		$scope.socio = undefined;
		$scope.$apply;
	};
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.buscar = function( rut )
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
			console.log( $scope.gasto );
			if( $scope.validate() )
			{
				$scope.gasto.fecha = $('#fecha').val();
				$scope.gasto.socio = $scope.socio;
				var request = $http.put( CONSTANTS.contextPath + "/api/private/gasto/save", $scope.gasto );
				request.success( function( response )
				{
					console.log( response );
					NProgress.done();
					$scope.continuar = false;
					$scope.gasto = undefined;
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
		
		if(! $scope.gasto.tipoGasto )
		{
			$scope.errorMsg= "Seleccione el tipo de ingreso";
			$scope.diplayError = true;
			return false;
		}
		
		if(! $scope.gasto.centroCosto )
		{
			$scope.errorMsg= "Seleccione el Centro de Costo";
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