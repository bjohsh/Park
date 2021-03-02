package com.Park.example.mapper;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.GrantedAuthority;
import com.Park.example.domain.User;
import com.Park.example.domain.UserInfo;

@Mapper
public interface UserMapper {
	//�쑀���씫湲�
	public User readUser(String username);
	
	//�쑀���씫湲� �깉濡쒓퀬移�
	public UserInfo readUser_refresh(String username);
	
	//�쑀�� �깮�꽦
    public void createUser(User user);
	
    //�쉶�썝 紐⑸줉 遺덈윭�삤湲�
    public List<UserInfo> read_user_list();
    
    //沅뚰븳 �씫湲�
	public List<GrantedAuthority> readAuthorities(String username);
	
	//沅뚰븳 �깮�꽦
	public void createAuthority(User user);
}
