package com.qubitfaruk.bookstore.core.security.config;

import com.qubitfaruk.bookstore.core.entity.Role;
import com.qubitfaruk.bookstore.core.security.CustomUserDetailsService;
import com.qubitfaruk.bookstore.core.security.InternalApiAuthenticationFilter;
import com.qubitfaruk.bookstore.core.security.jwt.JwtAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    @Value("${authentication.internal-api-key}")
    private String internalApiKey;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.cors();
       http.csrf().disable();
       http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); //jwt kullanaca????m??z i??in gerek yok.

        http.authorizeRequests()
                .antMatchers("/api/authentication/**").permitAll()
                .antMatchers("/api/internal/**").hasRole(Role.SYSTEM_MANAGER.name())
                .antMatchers(HttpMethod.GET,"/api/books").permitAll()   //get operasyonlar??na herkese izin ver.
                .antMatchers(HttpMethod.POST,"/api/books").hasRole(Role.ADMIN.name())
                .anyRequest().authenticated();

        http.addFilterBefore(jwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(internalApiAuthenticationFilter(),JwtAuthorizationFilter.class);
    }

    public WebMvcConfigurer corsConfigurer(){
        return  new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
              registry.addMapping("/**")
                      .allowedOrigins("*")
                      .allowedMethods("*");
            }
        };
    }


    @Bean
    public JwtAuthorizationFilter jwtAuthorizationFilter(){

        return new JwtAuthorizationFilter();
    }

    @Override
    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    @Bean
    public InternalApiAuthenticationFilter internalApiAuthenticationFilter(){
        return new InternalApiAuthenticationFilter(internalApiKey);
    }
}
