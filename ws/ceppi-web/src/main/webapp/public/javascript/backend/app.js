/* ========================================================================
 * App.js v1.3.0
 * Copyright 2015
 * ======================================================================== */
var URL_SERVICE_AUTHENTICATION = CONSTANTS.contextPath + '/api/authentication';

'use strict';

(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define([
            'core'
        ], factory);
    } else {
        factory();
    }
}(function () {

    var APP = {
        // Core init
        // NOTE: init at html element
        // ================================
        init: function () 
        {
            $('html').Core({
                loader: false,
                console: false
            });
        },
        
        logout: function()
        {
        	$.ajax(
		    {
                url: URL_SERVICE_AUTHENTICATION,
                cache: false,
                type: 'DELETE',
                dataType: "application/json",
                contentType : "application/json",
                data : JSON.stringify(user),
                error : function(xhr, ajaxOptions, thrownError)
				{
					  if( xhr.status == "200" )
					  {
						  location.href =  URL_PAGE_INDEX;
					  }
					  else
					  {
						  alert("Inicio de sesion no valido");
						  $this.prop('disabled', false);
					  }
					  NProgress.done();
				}
            });
        },

        // Template sidebar sparklines
        // NOTE: require sparkline plugin
        // ================================
        sidebarSparklines: {
            init: function () {
                $('aside .sidebar-sparklines').sparkline('html', { enableTagOptions: true });
            }
        }
    };

    $(function () 
    {
        APP.init();
        APP.sidebarSparklines.init();
    });
    
}));