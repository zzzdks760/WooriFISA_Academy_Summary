package dev.syntax.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
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
        http.httpBasic(Customizer.withDefaults());

        http.authorizeRequests() // 요청에 대해 권한을 확인할 것
                .anyRequest() // 서버에 존재하는 모든 경로의 요청에 대해
                .authenticated(); // 인증된 사용자만 접근할 수 있어야 함

        return http.build();
    }
}
