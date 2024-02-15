package dev.syntax.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring Security 와 관련된 Bean 들을 설정하는 파일
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        HTTP Basic 인증 방식을 적용하기 위해 해당 필터 추가
        http.formLogin(Customizer.withDefaults());

        http.authorizeRequests() // 요청에 대해 권한을 확인할 것
                .anyRequest() // 서버에 존재하는 모든 경로의 요청에 대해
                .hasAnyAuthority("DELETE", "WRITE");

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        UserDetails user1 = User.withUsername("kim")
                .password("1234")
                .authorities("READ")
                .build();

        UserDetails user2 = User.withUsername("yoo")
                .password("1234")
                .authorities("WRITE")
                .build();

        UserDetails user3 = User.withUsername("kang")
                .password("1234")
                .authorities("DELETE")
                .build();

        manager.createUser(user1);
        manager.createUser(user2);
        manager.createUser(user3);

        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
