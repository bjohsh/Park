package com.Park.example.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import com.Park.example.domain.User;
import com.Park.example.domain.UserInfo;

public interface UserService extends UserDetailsService{
	//�쑀���씫湲�
	public User readUser(String username);
	
	//�쑀�� �씫湲� �깉濡쒓퀬移�
	public UserInfo readUser_refresh(String username);

	//�쑀���깮�꽦
	   public void createUser(User user);
	   
	//�쉶�썝 紐⑸줉 遺덈윭�삤湲�
	   public List<UserInfo>read_user_list();

	// �떆�걧由ы떚 沅뚰븳 �뼸湲�
	Collection<GrantedAuthority> getAuthorities(String username);

	// 沅뚰븳 �깮�꽦
	public void createAuthority(User user);
}


