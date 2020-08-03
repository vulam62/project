package com.example.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.Myuser;
import com.example.entities.Role;
import com.example.entities.User;
import com.example.repositories.UserRepository;


@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//		User user = userRepository.findByEmail(userName)
//				.orElseThrow(() -> new UsernameNotFoundException("Email " + userName + " not found"));
//		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
//				getAuthorities(user));
//	}
//
//	private static Collection<? extends GrantedAuthority> getAuthorities(User user) {
//		String[] userRoles = user.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
//		Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
//		return authorities;
		User userEntity = userRepository.findByEmail(userName);
		
		if (userEntity == null) {
			throw new UsernameNotFoundException("User not found");
		}
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Role role: userEntity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		Myuser myUser = new Myuser(userEntity.getEmail(), userEntity.getPassword(), 
							true, true, true, true, authorities);
		myUser.setName((userEntity.getName()));
		return myUser;
	}

}
