package com.hedon.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @author Hedon Wang
 * @create 2020-10-05 17:41
 */
@Configuration
@EnableResourceServer  //资源服务器
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {


    //配置资源服务的ID
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId("order-server");  //这里要跟认证服务器配置的 resourcesId 里面的一样
    }


    //控制权限 => 默认所有服务都需要携带token
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/haha/haha").permitAll()  //除了 /haha 之外都需要请求
                //根据 scope 来控制权限
                .antMatchers(HttpMethod.POST).access("#oauth2.hasScope('write')")
                .antMatchers(HttpMethod.GET).access("#oauth2.hasScope('read')")
                .anyRequest().authenticated();
    }
}
