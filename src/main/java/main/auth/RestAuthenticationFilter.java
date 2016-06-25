package main.auth;

import main.globalexception.BadRequestException;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@Component
public class RestAuthenticationFilter implements javax.servlet.Filter {
	public static final String AUTHENTICATION_HEADER = "Authorization";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filter) throws IOException, ServletException {

		String url = null;
		String queryString = null;
		String authCredentials = null;


		if (request instanceof HttpServletRequest) {
			url = ((HttpServletRequest) request).getRequestURL().toString();
			queryString = ((HttpServletRequest) request).getQueryString();


			HttpServletRequest httpServletRequest = (HttpServletRequest) request;

			authCredentials = httpServletRequest
					.getHeader(AUTHENTICATION_HEADER);
			System.out.println("Filter works AUTHENTICATION_HEADER : "+AUTHENTICATION_HEADER);
		}

		Map<String, String[]> map = request.getParameterMap();
		System.out.println(new Date() + url + ",  with query string as :- " + queryString + " and params as follows ");
		for (String s : map.keySet()) {
			StringBuilder val = new StringBuilder();
			for (String s1 : map.get(s)) {
				val.append(s1 + ", ");
			}
		}

		// better injected
			AuthenticationService authenticationService = new AuthenticationService();

			boolean authenticationStatus = authenticationService
					.authenticate(authCredentials);

			if (authenticationStatus) {
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Authorize @@@@@@@@@@@@@@@@@@@@@@");
				filter.doFilter(request, response);
			} else {
				System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Not Authorize @@@@@@@@@@@@@@@@@@@@@@@");
				if (response instanceof HttpServletResponse) {
					HttpServletResponse httpServletResponse = (HttpServletResponse) response;
					httpServletResponse
							.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
					throw new BadRequestException();
				}
			}
	}

	@Override
	public void destroy() {
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
}