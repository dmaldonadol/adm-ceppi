package cl.ml.ceppi.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.ml.ceppi.web.rest.AuthenticationRest;
import cl.ml.ceppi.web.util.Constantes;

/**
 * Servlet Filter implementation class SessionAPIFilter
 */
public class SessionAPIFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SessionAPIFilter() {
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		HttpServletRequest requestHttp = (HttpServletRequest)request;		
		if( null == requestHttp.getSession(false) || null == requestHttp.getSession(false).getAttribute( Constantes.USER_SESSION ) )
		{
			((HttpServletResponse)response).setStatus( HttpServletResponse.SC_UNAUTHORIZED  );
		}
		else
		{	
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
