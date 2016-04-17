package main.filter;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

@Component
public class CorsFilter implements Filter {

    private final Logger logger=Logger.getLogger(CorsFilter.class);
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        String url=null;
        String queryString=null;
        if (req instanceof HttpServletRequest) {
            url = ((HttpServletRequest)req).getRequestURL().toString();
            queryString = ((HttpServletRequest)req).getQueryString();
        }
        Map<String, String[]> map=req.getParameterMap();
        logger.info("\n");
        logger.info(new Date() +url+",  with query string as :- "+queryString+" and params as follows ");
        for(String s:map.keySet()){
            StringBuilder val=new StringBuilder();
            for(String s1:map.get(s)){
                val.append(s1+", ");
            }
            logger.info("Name :-" + s + ", Value :-" + val);

        }
        logger.info("\n");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, x-requested-with, Content-Country , Content-Region, X-Auth-Token, Cache-Control");
        chain.doFilter(req, res);
    }

    public void init(FilterConfig filterConfig) {
    }

    public void destroy() {
    }

}