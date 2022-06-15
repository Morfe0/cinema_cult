package com.azienda.webapp.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.DispatcherType;
import com.azienda.webapp.entity.Utente;


@WebFilter(filterName = "adminFilter", urlPatterns = {"/InserisciFilm","/InserisciSpettacolo","/RimuoviSpettacolo","/AbilitaDisabilita"}, dispatcherTypes = {DispatcherType.REQUEST})
public class AdminFilter extends HttpFilter implements Filter {
	private static final long serialVersionUID = 1L;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String ruolo = "";

		if(httpRequest.getSession().getAttribute("utente")!= null) {
			Utente utenteLoggato = (Utente)httpRequest.getSession().getAttribute("utente");
			ruolo = utenteLoggato.getRuolo().getRuolo();	

			if (ruolo.equals("admin")) {
				chain.doFilter(request, response); 
			}else{
				HttpServletResponse httpResponse = (HttpServletResponse)response;
				httpResponse.sendRedirect("Login");
			}
			
		}
		else {
			HttpServletResponse httpResponse = (HttpServletResponse)response;
			httpResponse.sendRedirect("Login");
		}

	}

}





