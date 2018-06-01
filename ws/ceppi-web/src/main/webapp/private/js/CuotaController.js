/*************************************************************
 * @author 	: Juan Francisco ( juan.maldonado.leon@gmail.com )
 * @desc 	: Controlador de perfiles.
 *************************************************************/
app.controller("CuotaController", function($scope, $http, $location)
{
	$scope.listaSocios = [];
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.initialize = function()
	{
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
	$scope.obtener = function( callback )
	{
		var request = $http.get( CONSTANTS.contextPath + "/api/private/socio" );
		request.success( function( response )
		{
			$scope.listaSocios = response;
			callback();
		} );
		request.error( function( error )
		{
			console.log(error);
			callback();
		});
	};
	
	$scope.selectSocio = function ( obj )
	{
		
	};
	
	$scope.initialize();
});



/*************************************************************
 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
 * @desc 
 *************************************************************/
app.controller("AdmCuotaController", function( $scope, $http, $location, $routeParams, $filter )
{
	$scope.buttonTotal = 'btn-primary';
	$scope.showMonto = false;
	$scope.buttonParcial = '';
	
	$scope.listaanual = [];
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.initialize = function()
	{
		$scope.params = $routeParams;
		if ( $scope.anio == undefined )
		{
			$scope.anio = (new Date).getFullYear();
		}
		
		$scope.idsocio = $scope.params.id;
		NProgress.configure({ parent: '#main' });
		NProgress.start();
		
		$scope.obtenerSocio( function()
		{
			$scope.obtenerListaAnual( $scope.params.id, $scope.anio,  function()
			{
				NProgress.done();
			});
		});
	};
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.suma = function( suma )
	{
		var anio = parseInt($filter('date')($scope.socio.fechaIngreso, 'yyyy'));
		
		if ( parseInt($scope.anio) > anio || suma )
		{
			$scope.anio = suma ? parseInt($scope.anio) + 1 : parseInt($scope.anio) - 1;
			
			$scope.obtenerListaAnual( $scope.params.id, $scope.anio,  function()
			{
				NProgress.done();
			});
		}
	};
	
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.obtenerListaAnual = function( socio, anio,  callback )
	{
		var request = $http.get( CONSTANTS.contextPath + "/api/private/cuota/registroCuotas/" + parseInt(socio) + "/" + parseInt(anio) );
		request.success( function( response )
		{
			$scope.listaanual = response;
			
			$scope.createtable( $scope.listaanual );
			
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
	$scope.obtenerSocio = function( callback )
	{
		var request = $http.get( CONSTANTS.contextPath + "/api/private/socio/byID/" + $scope.idsocio);
		request.success( function( response )
		{
			$scope.socio = response;
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
	$scope.createtable = function ( lista )
	{
		$scope.table = $scope.inittable();
		
		var mes = parseInt($filter('date')($scope.socio.fechaIngreso, 'MM'));
		var anio = parseInt($filter('date')($scope.socio.fechaIngreso, 'yyyy'));
		
		for ( var i=0; i < $scope.table.length; i++ )
		{
			if ( anio == $scope.anio && $scope.table[i].mes < mes )
			{
				$scope.table[i].show = false;
			}
			
			if ( $scope.anio < anio )
			{
				$scope.table[i].show = false;
			}
			
			for ( var a=0; a < lista.length; a++ )
			{
				if ( lista[a].cuota.mes == $scope.table[i].mes )
				{
					$scope.table[i].estado = lista[a].estadoCuota;
					$scope.table[i].monto = lista[a].cuota.valor;
					break;
				}
			}
		}
	};
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.inittable = function ()
	{
		var table = [{name:"Enero",mes:"1", estado:"PENDIENTE", monto:0, show: true}
					,{name:"Febrero",mes:"2", estado:"PENDIENTE", monto:0, show: true}
					,{name:"Marzo",mes:"3", estado:"PENDIENTE", monto:0, show: true}
					,{name:"Abril",mes:"4", estado:"PENDIENTE", monto:0, show: true}
					,{name:"Mayo",mes:"5", estado:"PENDIENTE", monto:0, show: true}
					,{name:"Junio",mes:"6", estado:"PENDIENTE", monto:0, show: true}
					,{name:"Julio",mes:"7", estado:"PENDIENTE", monto:0, show: true}
					,{name:"Agosto",mes:"8", estado:"PENDIENTE", monto:0, show: true}
					,{name:"Septiembre",mes:"9", estado:"PENDIENTE", monto:0, show: true}
					,{name:"Octubre",mes:"10", estado:"PENDIENTE", monto:0, show: true}
					,{name:"Noviembre",mes:"11", estado:"PENDIENTE", monto:0, show: true}
					,{name:"Diciembre",mes:"12", estado:"PENDIENTE", monto:0, show: true}];
		return table;
	};
	
	/**
	 * 
	 */
	$scope.irPagar = function( c )
	{
		$scope.msgInfo = "";
		$scope.showmsg = false;
		$scope.montoParcial = "";
		$scope.comentario = "";
		$scope.buttonParcial='';
		$scope.showMonto = false;
		
		$scope.montoPago = $scope.socio.valorCuota
		$scope.objpago = c;
		$scope.periodo = c.name + ' ' + $scope.anio;
		$scope.buttonTotal='btn-primary';
		$scope.socio.valorCuota;
		
		if ( c.estado == 'PARCIAL' )
		{
			$scope.montoPago = parseInt($scope.socio.valorCuota) - parseInt(c.monto);
		}
		
		$('#modal-confirmacion').modal('show');
		NProgress.done();
	};
	
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.pagar = function (  )
	{
		NProgress.configure({ parent: '#main' });
		NProgress.start();
		$('#modal-confirmacion').modal('hide');
		var pojo = {
			anio: $scope.anio
			,mes: $scope.objpago.mes
			,estado: $scope.buttonTotal == '' ? 'PARCIAL' : 'PAGADA'
			,monto: $scope.buttonTotal == '' ? $scope.montoParcial : $scope.montoPago
			,idSocio: $scope.idsocio
			,comentario: $scope.comentario
		};
		var request = $http.post( CONSTANTS.contextPath + "/api/private/cuota/pagar", pojo);
		request.success( function( response )
		{
			$scope.registro = response;
			console.log( response );
			$('#modal-comprobante').modal('show');
			NProgress.done();
		} );
		request.error( function( error )
		{
			console.log(error);
			$scope.errorMsg= "Ocurrio un error al pagar la cuota, intente mas tarde";
			$scope.diplayError = true;
			NProgress.done();
		});
	};
	
	/****************************************************************
	 * condiciones para acceder a pago
	 ****************************************************************/
	$scope.validacionPago = function( )
	{		
		var estado = $scope.objpago.estado;
		var tipopago = $scope.buttonTotal == '' ? 'PARCIAL' : 'TOTAL';
		
		if ( tipopago == 'PARCIAL' && parseInt($scope.montoParcial) < 1 )
		{
			$scope.msgInfo = 'El monto de pago no debe ser inferior a cero';
		}
		
		if ( estado == 'PENDIENTE' && tipopago == 'PARCIAL' && parseInt($scope.montoParcial) > parseInt($scope.socio.valorCuota) )
		{
			$scope.msgInfo = 'El monto de pago no debe ser superior al valor cuota';
		}
		
		if ( estado == 'PARCIAL' && tipopago == 'PARCIAL' && parseInt($scope.montoParcial) > parseInt($scope.montoPago) )
		{
			$scope.msgInfo = 'El monto de pago no debe ser superior al Monto Pendiente';
		}
		
		$scope.showmsg = $scope.msgInfo != '';
		
		if ( !$scope.showmsg )
		{
			$scope.pagar();
		}
		
	};
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.verComprobante = function ( obj )
	{
		NProgress.configure({ parent: '#main' });
		NProgress.start();
		
		$scope.periodo = obj.name + ' ' + $scope.anio;
		
		var request = $http.get( CONSTANTS.contextPath + "/api/private/cuota/verRegistro/" + $scope.anio + "/" + obj.mes + "/" + $scope.idsocio);
		request.success( function( response )
		{
			$scope.registro = response;
			console.log( response );
			$('#modal-comprobante').modal('show');
			NProgress.done();
		} );
		request.error( function( error )
		{
			console.log(error);
			$scope.errorMsg= "Ocurrio un error al ver la cuota, intente mas tarde";
			$scope.diplayError = true;
			NProgress.done();
		});
	};
	
	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.formatNumber = function( num ) 
	{
		if ( num )
		{
			return num.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1.");
		}
	    
	};

	/*************************************************************
	 * @author Juan Francisco ( juan.maldonado.leon@gmail.com )
	 * @desc 
	 *************************************************************/
	$scope.getMonth = function(mm)
	{
		var monthNames = [ 'Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre' ];
		return monthNames[ parseInt(mm) - 1];
	};
	
	/*******************************************************************
	 * @author dmaldonado
	 * @desc Imprime detalle pago
	 *****************************************************************/
	$scope.imprimir = function(registro)
	{
		var table = "<table><tr><td colspan='2'><h3>Comprobante de Pago</h3></td></tr>" + 
			"<tr><td>Nombre:</td><td>" + registro.cuota.socio.persona.nombre + " " + registro.cuota.socio.persona.apellidoPaterno + " " + registro.cuota.socio.persona.apellidoMaterno + "</td></tr>" +
			"<tr><td>Periodo:</td><td>" + $scope.getMonth(registro.cuota.mes) + " " + registro.cuota.anio + "</td></tr>" + 
			"<tr><td>Monto:</td><td>" + $scope.formatNumber(registro.cuota.valor.valor) + "</td></tr>" + 
			"<tr><td>Fecha Emisi&oacute;n:</td><td>" + $filter('date')(registro.fechaCobro, 'dd-MM-yyyy HH:mm:ss') + "</td></tr>" + 
			"<tr><td>Comentario:</td><td></td></tr></table>";

		var popupWin = window.open('', '_blank', 'width=900,height=900');
		popupWin.document.open();
		popupWin.document.write('<html><head></head><body onload="window.print()">' + table + '</body></html>');
		popupWin.document.close();
	};
	
	$scope.initialize();
	
});
