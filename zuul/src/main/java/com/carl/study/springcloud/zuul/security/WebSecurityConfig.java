package com.carl.study.springcloud.zuul.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author changez
 * @desc
 * @datetime 2019/8/15 20:57
 */
@Configuration
//开启Spring Security的功能
@EnableWebSecurity
//可以开启security的注解，我们可以在需要控制权限的方法上面使用@PreAuthorize，@PreFilter这些注解
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // 开启Spring Security的功能
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }
// AuthenticationManagerConfiguration
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
        // TODO 添加后使用在配置文件中配置的用户名密码也不能访问了
        auth.inMemoryAuthentication()
                .withUser("root").password("pwd")/*.roles()*/.authorities("root")
                .and().withUser("zona").password("ddd").authorities("admin", "sell");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

}
