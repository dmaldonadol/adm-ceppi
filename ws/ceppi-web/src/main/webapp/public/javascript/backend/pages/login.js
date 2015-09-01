/* ========================================================================
 * login.js
 * Page/renders: page-login.html
 * Plugins used: parsley
 * ======================================================================== */
var URL_PAGE_INDEX = CONSTANTS.contextPath + '/private/inicio';
var URL_SERVICE_AUTHENTICATION = CONSTANTS.contextPath + '/api/authentication';


'use strict';

(function (factory) {
    if (typeof define === 'function' && define.amd) {
        define([
            'parsley'
        ], factory);
    } else {
        factory();
    }
}(function () {

    $(function () 
    {
        var $form = $('form[name=form-login]');
        $form.on('click', 'button[type=submit]', function (e) 
        {
            var $this = $(this);
			if ($form.parsley().validate()) 
			{
			    $this.prop('disabled', true);
			    NProgress.start();
			    
			    
			    var user = 
			    { 
		    		username: $('input[name=username]').val(), 
		    		password:$('input[name=password]').val() 
			    };
			    
			    $.ajax(
			    {
                    url: URL_SERVICE_AUTHENTICATION,
                    cache: false,
                    type: 'POST',
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
							  $("#info-login").html("Usuario y/o contraseña no son validos.");
							  $("#info-login").removeClass("alert-info");
							  $("#info-login").addClass("alert-danger");
							  $this.prop('disabled', false);
						  }
						  NProgress.done();
					}
                });
			
				
			} 
            else 
            {
                $form
                    .removeClass('animation animating shake')
                    .addClass('animation animating shake')
                    .one('webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend', function () {
                        $(this).removeClass('animation animating shake');
                    });
            }
            e.preventDefault();
        });
    });

}));