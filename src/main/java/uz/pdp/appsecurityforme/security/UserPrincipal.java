package uz.pdp.appsecurityforme.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.pdp.appsecurityforme.entity.User;

import java.util.Collection;
import java.util.Collections;


public record UserPrincipal(User user) implements UserDetails {


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
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


    public boolean allOk() {
        return isAccountNonExpired() &&
                isCredentialsNonExpired() &&
                isAccountNonLocked() &&
                isEnabled();
    }
}
