package com.dm.nabidm.www.config;

import com.dm.nabidm.orm.domain.Member;
import com.dm.nabidm.orm.domain.common.UserDetailInfo;
import com.dm.nabidm.orm.repository.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.PortResolverImpl;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

@Service
public class AdminAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private static final Logger logger = LoggerFactory.getLogger(AdminAuthenticationSuccessHandler.class);

	@Resource(name = "memberRepository")
	private MemberRepository userRepository;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {


		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		HttpSession session = request.getSession(true);

		UserDetails uds = (UserDetails)principal;

		session.setAttribute("userPrincipal", uds);				// 시큐리티 정보

		String userId =  uds.getUsername();

		Member userData = userRepository.findMemberByName(userId);

		UserDetailInfo userDetailInfo = new UserDetailInfo();
		Set<String> authorities = AuthorityUtils.authorityListToSet(uds.getAuthorities()); //권한

		userDetailInfo.setUserId(userData.getId());  //ID (PK)

		userDetailInfo.setAuthorities(authorities); //권한

		session.setAttribute("___session___", userDetailInfo);

		setDefaultTargetUrl("/main");

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
