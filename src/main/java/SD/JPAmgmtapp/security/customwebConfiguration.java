package SD.JPAmgmtapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;


@Configuration
@EnableWebSecurity
public class customwebConfiguration{
    
    //10/17/23 Mr. Otwane, I know the issues lie here likely due to some deprecated and changed ways. 
            // Take a gander when you have the time, I will continue to work on it and flesh out the app/fix this issue
            // All this HAS to do right now to allow me to access my h2-console by bypassing spring security because h2 console
            //has its own authentication. Ideally done at production level, but any level that will allow me to continue development

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .authorizeHttpRequests(auth -> auth
                            .requestMatchers(antMatcher("/h2-console/*")).permitAll() 
                    )
                    .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()))
                    .csrf(csrf -> csrf
                            .ignoringRequestMatchers(antMatcher("/h2-console/*")))
            
                .formLogin(formLogin -> formLogin
                .loginPage("/login") //if custom login is not needed you can use the withDefaults see my example project
                .loginPage("/login.html")
                .defaultSuccessUrl("/home.html", true)            )
            .logout((logout) -> logout.permitAll());
        return http.build();
        
}
    

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

    /**added as an example testing account. You can remove it 
    @Bean
	public UserDetailsService userDetailsService() {

		UserDetails user1 = user.builder()
        .username("user")
        .password(passwordEncoder().encode("P4ssw0rd!"))
        .roles("USER")
        .build();
		return new InMemoryUserDetailsManager(user1);
	}

}
    //Action:Relying upon circular references is discouraged and they are prohibited by default. Update your application to remove the dependency cycle between beans. As a last resort, it may be possible to break the cycle automatically by setting spring.main.allow-circular-references to true.
*/