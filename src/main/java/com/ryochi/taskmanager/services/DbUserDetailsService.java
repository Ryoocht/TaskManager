package com.ryochi.taskmanager.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ryochi.taskmanager.entities.Account;
import com.ryochi.taskmanager.entities.DbUserDetails;
import com.ryochi.taskmanager.mapper.LoginMapper;

@Service
public class DbUserDetailsService implements UserDetailsService {
	
	@Autowired
	LoginMapper loginMapper;
	
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        Account account = Optional.ofNullable(loginMapper.findAccount(userName))
                .orElseThrow(() -> new UsernameNotFoundException("User not found."));

        return new DbUserDetails(account, getAuthorities(account));
    }
    
    /**
     * @param user info taken from account DB
     * @return list of scope of authority
     */
    //Set a scope of authority given to a user that is passed this authentication
    private Collection<GrantedAuthority> getAuthorities(Account account) {
        return AuthorityUtils.createAuthorityList("ROLE_USER");
    }
}
