package com.lcomputerspring3.example.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.lcomputerspring3.example.domain.User;

public interface UserService extends UserDetailsService{
	
	//유저 읽기 
	public User readUser(String username);
	
	//유저 생성 
	public void createUser(User user);
	
	//권한 생성 
	public void createAuthorities(User user);
	
	//시큐리티 권한 얻기 
	Collection<GrantedAuthority> getAuthorities(String username);
	
	public List<String> getUserAuth(Collection<GrantedAuthority> authorities);
	
}
