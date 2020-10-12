package com.dj.web.xss;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/7/30
 */
public class XssHttpServletRequestWrapper extends HttpServletRequestWrapper {
    Logger log = LoggerFactory.getLogger(getClass());
    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request The request to wrap
     * @throws IllegalArgumentException if the request is null
     */
    public XssHttpServletRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        String parameter = super.getParameter(name);
        if (StringUtils.isNotBlank(parameter)) {
            parameter = StringEscapeUtils.escapeHtml4(parameter);
        }
        log.info("parameter");
        return parameter;
    }
}
