var Utils = 
{
	/**
	 * 
	 * @param title
	 * @param message
	 * @param className
	 * @param sticky
	 */
	messageGritter : function( title, message, className, sticky )
	{
		$.gritter.add({title:title,text: message,'class_name': className,sticky: sticky});
	},
	/**
	 * @param message
	 */
	messageErrorGritter : function( message )
	{
		$.gritter.add({title:'Ocurrio un error',text: message,'class_name': 'gritter-error' ,sticky: true});
	},
	
	
	/**
	 * @param status
	 */
	messageHttpErrorGritter : function( status, window )
	{
		console.log(status);
		if( status === 401 )
		{
			//No autorizado sin sesión.
			bootbox.alert('Su sesión ha finalizado, por favor inicie sesión nuevamente.', function()
			{
				window.location.href = CONSTANTS.contextPath;  
			});
	        
		}
		else
		{
			$.gritter.add({title:'Ocurrio un error',text: 'Ocurrio un error desconocido, por favor intente más tarde','class_name': 'gritter-error' ,sticky: true});
		}
	}
	
};


