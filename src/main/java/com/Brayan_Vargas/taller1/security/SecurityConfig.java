package com.Brayan_Vargas.taller1.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoggingAccessDeniedHandler accessDeniedHandler;

	@Autowired
	private MyCustomUserDetailsService userDetailsService;

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.authenticationProvider(authenticationProvider());
//	}

//	@Bean
//	public DaoAuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//		authProvider.setUserDetailsService(userDetailsService);
//		authProvider.setPasswordEncoder(encoder());
//		return authProvider;
//	}
//
//	@Bean
//	public PasswordEncoder encoder() {
//		return new BCryptPasswordEncoder(11);
//	}

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
/*
        httpSecurity.formLogin().loginPage("/login").permitAll().and().authorizeRequests()
                .antMatchers("/frontapi/index").permitAll()
                .antMatchers("/frontapi/Institution/**").hasAnyRole("admin")
                .antMatchers("/frontapi/PhysicalSpace/**").hasAnyRole("Operator")
                .antMatchers("/frontapi/PhysicalSpaceType/**").hasAnyRole("admin")
                .antMatchers("/frontapi/Campus/**").hasRole("Operator")
                .anyRequest().authenticated().and().httpBasic().and().logout()
                .invalidateHttpSession(true).clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout")
                .permitAll().and().exceptionHandling().accessDeniedHandler(accessDeniedHandler);*/

        httpSecurity.csrf().disable().authorizeRequests().antMatchers("/", "index").permitAll()
//				 .antMatchers("/institution/**")
//				 .hasRole(ApplicationUserRole.ADMIN.name()).antMatchers("/poll/**")
//				 .hasRole(ApplicationUserRole.ADMIN.name()).antMatchers("/question/**")
//				 .hasRole(ApplicationUserRole.OPERATOR.name()).antMatchers("/question-weight/**")
//				 .hasRole(ApplicationUserRole.OPERATOR.name()).anyRequest().authenticated()
                .and().formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/", true).and().logout()
                .logoutUrl("/logout").clearAuthentication(true).invalidateHttpSession(true).logoutSuccessUrl("/login");
/*
        httpSecurity.authorizeRequests().antMatchers("/**").authenticated()
                .antMatchers("/Institution/**").hasRole("admin")
                .antMatchers("/PhysicalSpace/**").hasRole("Operator")
                .antMatchers("/PhysicalSpaceType/**").hasRole("admin")
                .antMatchers("/Campus/**").hasRole("Operator")
                .antMatchers("/login","/").authenticated().anyRequest().permitAll()

                .and()

                .formLogin().loginPage("/login").permitAll().and()
                .logout().invalidateHttpSession(true).clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout")
                .permitAll().and().exceptionHandling().accessDeniedHandler(accessDeniedHandler);*/

    }
    }