package com.dj.web.autoconfig;

import com.dj.web.filter.XssServletFilter;
import com.dj.web.xss.XssHttpServletRequestWrapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/8/10
*/
@ConditionalOnClass({XssServletFilter.class, XssHttpServletRequestWrapper.class})
public class XssServletFilterAutoConfiguration {

    @Bean
    public XssServletFilter xssServletFilter() {
        return new XssServletFilter();
    }
}
