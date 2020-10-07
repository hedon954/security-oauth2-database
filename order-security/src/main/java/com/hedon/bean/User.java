package com.hedon.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author Hedon Wang
 * @create 2020-10-07 15:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements UserDetails {

    private Integer id;
    private String username;
    private String password;



    //权限
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN");
    }

    //用户没过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //账户没被锁定
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //密码没过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //用户可用
    @Override
    public boolean isEnabled() {
        return true;
    }
}
