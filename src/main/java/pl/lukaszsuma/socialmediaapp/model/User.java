package pl.lukaszsuma.socialmediaapp.model;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Data
@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String login;
    @NotNull
    private String password;
    @NotNull
    private String email;
    @Enumerated(EnumType.STRING)
    private AccountRole role;
    @Enumerated(EnumType.STRING)
    private AccountType type;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
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

    public enum AccountRole {
        ADMIN,
        USER
    }

    public enum AccountType {
        PUBLIC,
        PRIVATE
    }

}
