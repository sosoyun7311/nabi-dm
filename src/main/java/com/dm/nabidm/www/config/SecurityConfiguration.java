package com.dm.nabidm.www.config;

import com.dm.nabidm.www.login.LoginService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

import javax.annotation.Resource;

@Configuration
@ConditionalOnClass(DefaultAuthenticationEventPublisher.class)
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Resource
	private AdminAuthenticationSuccessHandler authenticationSuccessHandler;

	@Resource
	private UserLoginFailHandler userLoginFailHandler;

	@Resource
	private LoginService userDetailsService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(WebSecurity web) throws Exception{
		super.configure(web);
		web.ignoring().antMatchers(
			new String[]{
				"/favicon.ico",
				"/css/**",
				"/images/**",
				"/js/**",
				"/assets/**",
				"/font/**",
			}
		)
			.and()
			.httpFirewall(allowUrlEncodedPercentAndSemicolonHttpFirewall());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// authorize - requests
		//http.addFilterBefore(authenticationFilterObtainUsername(),UsernamePasswordAuthenticationFilter.class);
		http
			.authorizeRequests()
			.antMatchers(new String[]{
				"/board/**" , "/main","/api/**"
			}).access("hasRole('ADMIN')")
			.antMatchers(new String[]{
				"/","/login.do","/join"
			}).permitAll()
		.and()
			// form - login
			.formLogin()
			.loginPage("/")
			.loginProcessingUrl("/login.do")
			.defaultSuccessUrl("/main",true)
			.usernameParameter("encId")
			.passwordParameter("password")
			.successHandler(authenticationSuccessHandler)
			.failureUrl("/")
			.failureHandler(userLoginFailHandler)
		.and()
			.logout()
			.logoutUrl("/security_logout")
			.logoutSuccessUrl("/")
			.invalidateHttpSession(true)
			.deleteCookies("JSESSIONID")
		.and()
			.anonymous()
		.and()
			.sessionManagement()
			.maximumSessions(1)
			.expiredUrl("/")
			.maxSessionsPreventsLogin(false).and()
		.and()
			.sessionManagement()
			.invalidSessionUrl("/")
			.sessionFixation().none()
		.and()
			.httpBasic().disable()
			.csrf().disable()
			.headers()
			.frameOptions().sameOrigin()
			.httpStrictTransportSecurity()
			.maxAgeInSeconds(0)
			.includeSubDomains(true);
		// remember-me
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder());
		//Spring Security password 관련 추가
		auth.eraseCredentials(false).inMemoryAuthentication().withUser("user").password("password").roles();
	}

	@Bean
	public HttpFirewall allowUrlEncodedPercentAndSemicolonHttpFirewall() {
		StrictHttpFirewall firewall = new StrictHttpFirewall();
		firewall.setAllowUrlEncodedPercent(true);
		firewall.setAllowSemicolon(true);
		return firewall;
	}

}
