package com.ryochi.taskmanager.entities;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class DbUserDetails extends User {
	//User Information
	private final Account account;
	
	public DbUserDetails(Account account, Collection<GrantedAuthority> authorities) {
		super(account.getName(), account.getPassword(), true, true, true, true, authorities);
		this.account = account;
	}
	
	public Account getAccount() {
		return account;
	}
}
