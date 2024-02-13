package dev.syntax.security;

import dev.syntax.security.model.SimpleUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // debug=true 옵션 적용 가능
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.formLogin(Customizer.withDefaults());

        http.authorizeRequests()
                .anyRequest()
                .authenticated();

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        /*
            사용자 정보를 보관하는 방식
            1. 메모리 상에서 임시로 관리
            2. DB 상에서 관리
            3. 그 외 볼트(Vault)나 다른 서버
         */
        // 임시로 메모리에서 관리할 UserDetailsService 객체인 InMemoryUserDetailsManager 생성(학습용)
        var userDetailsService = new InMemoryUserDetailsManager();
        // var - 우측에 있는 인스턴스의 타입을 가지고 변수의 타입을 추론

        // UserDetails 인터페이스를 구현한 구현체인 User 클래스를 통해 임시 사용자 엔티티 생성
        // User 클래스는 시큐리티에서 기본으로 제공하는 객체
        var user1 = User.withUsername("gugu")
                .password("1234")
                .authorities("read")
                .build();

        SimpleUser user2 = new SimpleUser("sungmin", "1234");

        // userDetailsService에게 사용자 객체를 관리하도록 추가
        userDetailsService.createUser(user1); // 메모리 상에서 user1을 관리하도록 등록(추가)
        userDetailsService.createUser(user2);
        return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // NoOpPasswordEncoder는 별도의 암호화나 해시를 적용하지 않고 일반 텍스트(평문)으로 처리
        // 운영 단계에서는 이용하면 안됨(Deprecated)
        return NoOpPasswordEncoder.getInstance();
    }
}
