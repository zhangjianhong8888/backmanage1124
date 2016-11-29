package org.qydata.config;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.Properties;

/**
 * Created by jonhn on 2016/11/29.
 */
@Configuration
@Controller
public class ErrorConfig implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @Bean
    public SimpleMappingExceptionResolver simpleMappingExceptionResolver(){
        SimpleMappingExceptionResolver mappingExceptionResolver = new SimpleMappingExceptionResolver();
        mappingExceptionResolver.setExceptionMappings(properties());
        return mappingExceptionResolver;
    }
    @Bean
    public Properties properties(){
        Properties propertiesSet = new Properties();
        propertiesSet.put("org.apache.shiro.authz.UnauthenticatedException","pages/403");
        propertiesSet.put("org.apache.shiro.authz.UnauthorizedException","pages/403");
        propertiesSet.put("org.apache.shiro.authc.LockedAccountException","pages/locked");
        propertiesSet.put("java.lang.Throwable","pages/500");
        return propertiesSet;
    }
    @RequestMapping(value=ERROR_PATH)
    public String handleError(){
        return "pages/404";
    }
    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
