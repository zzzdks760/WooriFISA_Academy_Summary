package dev.syntax.security.service;

import dev.syntax.security.entity.User;
import dev.syntax.security.entity.CustomUserDetails;
import dev.syntax.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// JPA를 통해 사용자 정보를 조회할 수 있도록 UserDetailsService를 구현
@Service
@RequiredArgsConstructor
public class CustomJpaUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // User의 타입은 JPA에서 사용할 Entity
        User user = userRepository.findUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("해당하는 사용자가 없음"));

        // loadUserByUsername()의 반환 타입은 시큐리티에서 관리하는 UserDetails 타입

        return new CustomUserDetails(user);
    }
}