package com.rso.microservice.security;

import com.rso.microservice.service.UserDetailsServiceImpl;

//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    private final AuthEntryPointJwt unauthorizedHandler;

    private final UserDetailsServiceImpl userDetailsService;

    public WebSecurityConfig(AuthEntryPointJwt unauthorizedHandler, UserDetailsServiceImpl userDetailsService) {
        this.unauthorizedHandler = unauthorizedHandler;
        this.userDetailsService = userDetailsService;
    }

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.cors().and().csrf().disable()
//                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//                .authorizeRequests().antMatchers("/ping").permitAll()
//                .antMatchers("/authentication/login").permitAll()
//                .antMatchers("/authentication/register").permitAll()
//                .antMatchers("/authentication/**").authenticated()
//                .antMatchers("/profile/**").authenticated();
//
//        http.authenticationProvider(authenticationProvider());
//
//        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

//        return http.build();
//    }

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().antMatchers("/js/**", "/images/**");
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//
//        authProvider.setUserDetailsService(userDetailsService);
//        authProvider.setPasswordEncoder(passwordEncoder());
//
//        return authProvider;
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfiguration) throws Exception {
//        return authConfiguration.getAuthenticationManager();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthTokenFilter authenticationJwtTokenFilter() {
//        return new AuthTokenFilter();
//    }

}
