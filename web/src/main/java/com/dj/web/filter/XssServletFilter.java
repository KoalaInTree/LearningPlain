package com.dj.web.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import com.dj.web.xss.XssHttpServletRequestWrapper;
import org.springframework.stereotype.Component;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/7/30
 */
@WebFilter(filterName = "xssFilterName",urlPatterns = "/*")
public class XssServletFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
        FilterChain filterChain) throws IOException, ServletException {
        XssHttpServletRequestWrapper req = new XssHttpServletRequestWrapper((HttpServletRequest)servletRequest);
        filterChain.doFilter(req,servletResponse);
    }
}
