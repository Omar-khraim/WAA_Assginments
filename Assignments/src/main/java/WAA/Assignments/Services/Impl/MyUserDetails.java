package WAA.Assignments.Services.Impl;

import WAA.Assignments.Domain.Role;
import WAA.Assignments.Domain.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {

//    these three fields are custom and added by me
    private String email;
    @JsonIgnore
    private String password ;
    private List<Role> roles;
    public MyUserDetails(Users user) {
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.roles = user.getUserRoles();
    }

//    @Override
//    public GrantedAuthority[] getAuthorities() {
//        return new GrantedAuthority[0];
//    }

    @Override
    // will change the return type to be one of this class
    // children using wild card of generics

    public Collection<? extends GrantedAuthority> getAuthorities() {

        return roles.stream()
                .map( role -> new SimpleGrantedAuthority(role.getRole()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
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
