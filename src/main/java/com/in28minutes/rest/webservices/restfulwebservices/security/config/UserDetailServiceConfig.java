package com.in28minutes.rest.webservices.restfulwebservices.security.config;

import com.in28minutes.rest.webservices.restfulwebservices.security.authentication.filter.CustomAuthenticationFilter;
import com.in28minutes.rest.webservices.restfulwebservices.security.authentication.providers.CustomAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class UserDetailServiceConfig extends WebSecurityConfigurerAdapter {

    /*
     * @Autowired private DataSource dataSource;
     */

    //@Autowired
    //private CustomAuthenticationFilter filter;

    //@Autowired
    //private CustomAuthenticationProvider customAuthenticationProvider;

    /**
     * In memory implementation
     *
     * @return
     */
    // @Bean
    public UserDetailsService userDetailsService() {
        UserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
        UserDetails userDetails = User.builder().username("bill").password("12345").authorities("read").build();
        userDetailsService.createUser(userDetails);
        return userDetailsService;
    }

    /**
     * JDBC implementation used for creating the user and modifying the users it
     * also helps u to get validate the users by username and password
     *
     * @return
     */

    /*
     * @Bean("userDetailsManager") public UserDetailsManager
     * userDetailsServiceJdbc() { return new JdbcUserDetailsManager(dataSource); }
     */
    // UserDetails }
    @Bean
    public PasswordEncoder passwordEncoder() {
        // return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.csrf().disable().authorizeRequests().mvcMatchers("/user").permitAll().anyRequest().authenticated();
    }

    /**@Override
    @Bean("customAuthenticationManager")
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }*/

    /**
     * user Custom authentication filter
     * @param auth
     * @throws Exception
     */
   /** @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(customAuthenticationProvider);
    }*/

/**@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterAt(filter, BasicAuthenticationFilter.class);

        http.authorizeRequests().anyRequest().permitAll();
    }*/
}
