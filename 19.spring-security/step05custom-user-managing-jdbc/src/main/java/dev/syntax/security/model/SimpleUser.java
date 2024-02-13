package dev.syntax.security.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.List;

public class SimpleUser implements UserDetails {
    private final String username;
    private final String password;

    @Autowired
    PasswordEncoder passwordEncoder;

    public SimpleUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void pwdEnc() {
        String encodedPwd = passwordEncoder.encode(password);
        System.out.println(encodedPwd);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> "READ");
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
