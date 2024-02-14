package dev.syntax.security.config;

// Ctrl + Alt + O

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // form-login 적용
        http.formLogin()
                // .defaultSuccessUrl("/products", true) // 인증이 성공할 경우 리다이렉트할 url 지정 가능
                .loginPage("/custom/login")
                .permitAll(); // 해당 경로는 별도의 인증 없이 모두 접근 허용

        http.logout()
                .logoutUrl("/custom/logout") // 로그아웃 처리를 수행할 URL(POST: /custom/logout)
                .logoutSuccessUrl("/main"); // 로그아웃 처리가 완료되었을 경우 리다이렉트할 URL

        http.authorizeRequests()
                .mvcMatchers("/main")// 8080/main 경로로 요청 시
                .permitAll(); // 접근 허용

        // 그 외 다른 모든 경로는 인증된 사용자만 접근할 수 있도록 적용
        http.authorizeRequests()
                .anyRequest()
                .authenticated();

        return http.build();
    }

    // 시큐리티에서 제공하는 인코더 적용(BCrypt, SCrypt)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}