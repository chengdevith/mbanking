//package co.istad.mobilebanking.security;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//@RequiredArgsConstructor
//public class SecurityConfig {
//
//    private final PasswordEncoder passwordEncoder;
//    private final UserDetailsService userDetailsService;
//
//    @Bean
//    public SecurityFilterChain apiSecurity(HttpSecurity http) throws Exception {
//
//        //TODO
//
//        //set all request must be authenticated
//        http.authorizeHttpRequests(request ->
//                request
//                        .requestMatchers(HttpMethod.GET,"/api/v1/customers/**").hasAnyRole("ADMIN","STAFF","CUSTOMER")
//                        .requestMatchers(HttpMethod.POST,"/api/v1/customers/**").hasAnyRole("ADMIN","STAFF")
//                        .requestMatchers(HttpMethod.PUT,"/api/v1/customers/**").hasAnyRole("ADMIN")
//                        .requestMatchers(HttpMethod.DELETE,"/api/v1/customers/**").hasAnyRole("ADMIN")
//                        .requestMatchers("/api/v1/accounts/**").hasAnyRole("USER")
//                        .anyRequest().authenticated()
//        );
//
//        // Disable firm login default
////        http.formLogin(AbstractHttpConfigurer::disable);
//
//        // Disable firm login default
//        http.csrf(AbstractHttpConfigurer::disable);
//
//        // Set security mechanism
//        //Basic Authentication (username & password)
//        http.httpBasic(Customizer.withDefaults());
//
//        // Set session Stateless
//        http.sessionManagement(session ->
//                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//        );
//
//        return http.build();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider() {
//        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider(userDetailsService);
//        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
//        return daoAuthenticationProvider;
//    }
////    @Bean
////    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
////        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
////
////        UserDetails admin = User
////                .builder()
////                .username("admin")
////                .password("{noop}admin")
////                .roles("ADMIN")
////                .build();
////        manager.createUser(admin);
////
////        UserDetails user = User
////                .builder()
////                .username("user")
////                .password("{noop}user")
////                .roles("USER")
////                .build();
////        manager.createUser(user);
////
////        UserDetails customer = User
////                .builder()
////                .username("customer")
////                .password("{noop}customer")
////                .roles("CUSTOMER")
////                .build();
////        manager.createUser(customer);
////
////        return manager;
////    }
//}
