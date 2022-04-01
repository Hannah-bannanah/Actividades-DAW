package com.ite.libreria_jmp.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class DatabaseWebSecurity extends WebSecurityConfigurerAdapter{
	
	@Bean
	public BCryptPasswordEncoder pwdEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired private DataSource ds;	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
				.dataSource(ds)
				.usersByUsernameQuery("select username,password,enabled from Usuarios where username=?")
				.authoritiesByUsernameQuery("select u.username, p.descripcion from Usuario_Perfiles up " + 
						"inner join Usuarios u on u.username = up.username " +
						"inner join Perfiles p on p.id_perfil = up.id_Perfil " +
						"where u.username = ?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
//			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/css/**", "/images/**").permitAll()
			.antMatchers("/", "/login", "/logout", "/alta", "/novedades", "/inicializar/**").permitAll()
			.antMatchers("/cliente/tema", "/cliente/buscar", "/cliente/verDetalle/**").hasAnyAuthority("ROL_ADMON", "ROL_CLIENTE")
			.antMatchers("/admon/**").hasAnyAuthority("ROL_ADMON")
			.antMatchers("/cliente/**").hasAnyAuthority("ROL_CLIENTE")
			.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/login/success")
				.failureUrl("/login/error")
				.permitAll();
			
	}
}
