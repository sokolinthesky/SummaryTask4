package ua.nure.soklakov.SummaryTask4.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class EncodingFilter implements Filter {
	private static final Logger LOG = Logger.getLogger(EncodingFilter.class);

	/*private String encoding;

	public void destroy() {
		LOG.debug("Filter destruction starts");
		// do nothing
		LOG.debug("Filter destruction finished");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		LOG.debug("Filter starts");
		
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		LOG.trace("Request uri --> " + httpRequest.getRequestURI());
		
		String requestEncoding = request.getCharacterEncoding();
		if (requestEncoding == null) {
			LOG.trace("Request encoding = null, set encoding --> " + encoding);
			request.setCharacterEncoding(encoding);
		}
		
		LOG.debug("Filter finished");		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		LOG.debug("Filter initialization starts");
		encoding = fConfig.getInitParameter("encoding");
		LOG.trace("Encoding from web.xml --> " + encoding);
		LOG.debug("Filter initialization finished");
	}*/
	private String encoding;

	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("requestEncoding");

		if (encoding == null)
			encoding = "UTF-8";
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain next)
			throws IOException, ServletException {
		// Respect the client-specified character encoding
		// (see HTTP specification section 3.4.1)
		if (null == request.getCharacterEncoding())
			request.setCharacterEncoding(encoding);

		/**
		 * Set the default response content type and encoding
		 */
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		next.doFilter(request, response);
	}

	public void destroy() {
	}
}
