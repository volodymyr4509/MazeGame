package com.game.mazeapp;

import com.game.mazeapp.entity.Player;
import com.game.mazeapp.manager.PlayerManagerImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Home on 06.12.2014.
 */
public class CustomAuthenticationProvider implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String playerNickName) throws UsernameNotFoundException{
        PlayerManagerImpl playerManager = new PlayerManagerImpl();
        Player player = playerManager.findPlayerByNickName(playerNickName);
        Player authenticatedPlayer = playerManager.authenticate(player.getId(),player.getPassword());
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new User(authenticatedPlayer.getNickName(), authenticatedPlayer.getPassword(),true,true,true,true,authorities);
    }
}
