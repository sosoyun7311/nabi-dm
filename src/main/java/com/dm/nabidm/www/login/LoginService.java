package com.dm.nabidm.www.login;

import com.dm.nabidm.orm.domain.Member;
import com.dm.nabidm.orm.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.RequestDispatcher;
import java.util.ArrayList;
import java.util.List;

@Service("loginService")
public class LoginService  implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = null;
        try {
            String usernames =  username;
            String userId =  username;

            member = getUser(usernames);

            boolean enabled = true;
            boolean accountNonExpired = true;
            boolean credentialsNonExpired = true;
            boolean accountNonLocked = true;

            if(member == null) {
                throw new UsernameNotFoundException(" LogIn ID : "+userId);
            }
            return new org.springframework.security.core.userdetails.User(username, member.getPasswd(), enabled,
                    accountNonExpired, credentialsNonExpired, accountNonLocked, getAuthList(member));


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<GrantedAuthority> getAuthList(Member member){
       List<GrantedAuthority> authorities = new ArrayList<>();
       authorities.add(new SimpleGrantedAuthority ( member.getRole() )) ;

       return authorities;
    }

    //사용자 정보 조회
    private Member getUser(String username) {
        return memberRepository.findMemberByName(username);
    }
}
