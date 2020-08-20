package com.minghui.util;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @auther chenqinglin
 * @create 2018/12/13
 */
@Data
public class LoginUserInfo extends SysUserPO implements UserDetails,Serializable {

    private static final long serialVersionUID = -1981739120137740944L;

    private Set<SysRolePO> sysRoles;

    private Set<String> permissions;

    /**
     * @description:<p>[权限重写]</p>
     *
     * @param:
     * @return:java.util.Collection<? extends org.springframework.security.core.GrantedAuthority>
     * @auther: chenqinglin
     * @date: 2019/1/11 09:58
     */
    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collection = new HashSet<>();
        if (!CollectionUtils.isEmpty(sysRoles)) {
            sysRoles.parallelStream().forEach(role -> {
                if (role.getRoleNo().startsWith("ROLE_")) {
                    collection.add(new SimpleGrantedAuthority(role.getRoleNo()));
                } else {
                    collection.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleNo()));
                }
            });
        }
        if (!CollectionUtils.isEmpty(permissions)) {
            permissions.parallelStream().forEach(per -> {
                if(StringUtils.isNotBlank(per)) {
                    collection.add(new SimpleGrantedAuthority(per));
                }
            });
        }
        return collection;
    }

    /**
     * Returns the username used to authenticate the user. Cannot return <code>null</code>.
     *
     * @return the username (never <code>null</code>)
     */
    @Override
    public String getUsername() {
        return getUserName();
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
        return !getIsDelete();
    }
}
