package dev.syntax.security.service;

import dev.syntax.security.entity.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/*
 AuthenticationProvider 인터페이스를 직접 구현한 클래스(구현체)

 UserDetailsService에게 사용자 정보를 DB에서 조회하는 처리를 위임시키는 역할
 -> 우리는 직접 작성한 CustomJpaUserDetailsService가 있음
 */

@RequiredArgsConstructor
@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final CustomJpaUserDetailsService userDetailsService;

    private final PasswordEncoder bcryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // Filter - Manager로부터 전달받은 자격증명(username, password 등)을 추출
        String username = authentication.getName();
        System.out.println("username = " + username); // soutv

        String password = authentication.getCredentials().toString();
        System.out.println("password = " + password);

        // DB에서 사용자 정보 조회
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

        // 패스워드 비교
        return checkPassword(password, userDetails);
    }

    private Authentication checkPassword(String password, UserDetails userDetails) {
        if (bcryptPasswordEncoder.matches(password, userDetails.getPassword())) {
            // Token은 Authentication의 구현체 중 하나
            return new UsernamePasswordAuthenticationToken(
                    userDetails.getUsername(),
                    userDetails.getPassword(),
                    userDetails.getAuthorities()
            );
        } else {
            throw new BadCredentialsException("Bad Credential");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
    }

}