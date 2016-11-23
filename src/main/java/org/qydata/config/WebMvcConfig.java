package org.qydata.config;

import org.qydata.freemarker.ShiroTagFreeMarkerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/11/20.
 */

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

   @Bean
    public ShiroTagFreeMarkerConfigurer shiroTagFreeMarkerConfigurer(){
       ShiroTagFreeMarkerConfigurer bean =new ShiroTagFreeMarkerConfigurer();
       bean.setTemplateLoaderPath("classpath:/templates");
       Map<String,Object> map = new HashMap<String,Object>();
       map.put("defaultEncoding","UTF-8");
       map.put("classic_compatible","true");
       bean.setFreemarkerVariables(map);
       return bean;
   }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}
