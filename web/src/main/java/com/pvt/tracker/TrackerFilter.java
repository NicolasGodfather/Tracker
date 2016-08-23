package com.pvt.tracker;

import com.pvt.tracker.config.MessagesConfig;
import com.pvt.tracker.controllers.MainController;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Realization main filter that receives and processes all incoming inquiries.
 *
 * @author Nicolas Asinovich.
 */
public class TrackerFilter implements Filter{

    private static final Logger logger = Logger.getLogger(TrackerFilter.class);
    private String[] exc;
    private String encoding;

    @Override
    public void init (FilterConfig filterConfig) throws ServletException {
        exc = filterConfig.getInitParameter("exclusions").split(",");
        encoding = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter (ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        req.setCharacterEncoding(encoding);
        HttpSession session = req.getSession(true);

        if (session.getAttribute("messages") == null) {
            session.setAttribute("messages", new MessagesConfig());
        }

        String url = req.getRequestURI().replaceFirst(req.getContextPath(), "");
        logger.debug(url);

        boolean resourcesRequest = false;
        for (String exclusion : exc) {
            if (url.endsWith("." + exclusion)) {
                resourcesRequest = true;
            }
        }

        if (resourcesRequest) {
            chain.doFilter(request, response);
        } else {
            MainController mainC = new MainController(req, resp, chain);
            mainC.getResourse();
        }
    }

    @Override
    public void destroy () {
        // TODO Auto-generated method stub
    }
}
